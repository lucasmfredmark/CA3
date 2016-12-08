/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Team;
import facades.interfaces.ITeamFacade;
import facades.TeamFacade;
import httpErrors.TeamNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import jsonMappers.TeamMapper;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("team")
@RolesAllowed({"User", "Admin"})
public class TeamService {

    @Context
    private UriInfo context;

    @Context
    private SecurityContext securityContext;

    private static final ITeamFacade FACADE = new TeamFacade(Persistence.createEntityManagerFactory("pu_development"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of Team
     */
    public TeamService() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        return "Hello from team";
    }

    @PUT
    @Path("create/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String createTeam(@PathParam("name") String name) {
        Team t = FACADE.createTeam(name, securityContext.getUserPrincipal().getName());
        TeamMapper tm = new TeamMapper(t);

        return GSON.toJson(tm);
    }

    @DELETE
    @Path("delete/{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteTeam(@PathParam("id") int id) throws TeamNotFoundException {
        Team t = FACADE.deleteTeam(id);
        TeamMapper tm = new TeamMapper(t);

        return GSON.toJson(tm);
    }

    @GET
    @Path("username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeamsByUsername(@PathParam("username") String username) throws TeamNotFoundException {
        List<Team> t = FACADE.getTeamsByUsername(username);
        List<TeamMapper> tm = new ArrayList();

        for (Team team : t) {
            tm.add(new TeamMapper(team));
        }

        return GSON.toJson(tm);
    }

}
