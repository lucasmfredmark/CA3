/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.FollowerFacade;
import facades.interfaces.IFollowerFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;


/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("follower")
public class FollowerService {

    @Context
    private UriInfo context;

    private static final IFollowerFacade FACADE = new FollowerFacade(Persistence.createEntityManagerFactory("pu_development"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of Follower
     */
    public FollowerService() {
    }

    /*
    @GET
    @Path("getFollowList")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFollowList(String forUser) {
        User u = GSON.fromJson(forUser, User.class);
        List<Follower> fl = FACADE.getFollowList(u);
        return GSON.toJson(fl);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUserToFollowList(String json) {
        Follower fw = GSON.fromJson(json, Follower.class);
        Follower f = (Follower) FACADE.addUserToFollowList(fw.getFkUserFollowUsername(), fw.getFkUserUsername());
        return GSON.toJson(f);
    }
    */
}
