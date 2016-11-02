/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Follower;
import facades.FollowerFacade;
import facades.IFollowerFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("api")
public class FollowerService {

    @Context
    private UriInfo context;

    private static final IFollowerFacade FACADE = new FollowerFacade(Persistence.createEntityManagerFactory("PU"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of Follower
     */
    public FollowerService() {
    }

    /**
     * Retrieves representation of an instance of rest.Follower
     *
     * @return an instance of java.lang.String
     */
    //try to fix
//    @GET
//    @Path("getFollowList")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getFollowList(String forUser) {
//        Follower f = GSON.fromJson(forUser, Follower.class);
//        List<Follower> fl = FACADE.getFollowList(f);
//        return GSON.toJson(fl);
//    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String addUserToFollowList(String json) {
        Follower fw = GSON.fromJson(json, Follower.class);
        Follower f = (Follower) FACADE.addUserToFollowList(fw.getFkUserFollowUsername(), fw.getFkUserUsername());
        return GSON.toJson(f);
    }
}
