/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Follow;
import facades.FollowFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.core.SecurityContext;
import facades.interfaces.IFollowFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jsonMappers.FollowMapper;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("follow")
@RolesAllowed({"User", "Admin"})
public class FollowService {

    @Context
    private UriInfo context;

    @Context
    private SecurityContext securityContext;

    private static final IFollowFacade FACADE = new FollowFacade(Persistence.createEntityManagerFactory("pu_development"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of Follower
     */
    public FollowService() {
    }

    @GET
    @Path("me")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsersFollowed() {
        String username = securityContext.getUserPrincipal().getName();
        List<Follow> usersFollowed = FACADE.getAllUsersFollowed(username);
        List<FollowMapper> fm = new ArrayList();
        for (Follow f : usersFollowed) {
            fm.add(new FollowMapper(f));
        }
        return GSON.toJson(fm);
    }

    @PUT
    @Path("add/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String followAUser(@PathParam("username") String username) {
        String me = securityContext.getUserPrincipal().getName();
        Follow follow = FACADE.followAUser(me, username);
        FollowMapper fm = new FollowMapper(follow);

        return GSON.toJson(fm);
    }
}
