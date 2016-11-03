/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Team;
import facades.ITeamFacade;
import facades.TeamFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("team")
public class TeamService {

    @Context
    private UriInfo context;

    private static final ITeamFacade FACADE = new TeamFacade(Persistence.createEntityManagerFactory("pu_development"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of Team
     */
    public TeamService() {
    }

    /**
     * Retrieves representation of an instance of rest.Team
     *
     * @return an instance of java.lang.String
     */
    
    @PUT
    @Path("createTeam")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createTeam(String json_team) {
        Team team = GSON.fromJson(json_team, Team.class);
        Team t = (Team) FACADE.createTeam(team);
        return GSON.toJson(t);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeams() {
        List<Team> li = FACADE.getTeams();
        return GSON.toJson(li);
    }

    @GET
    @Path("getTeamById")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeamById(String json_id) {
        Team team = GSON.fromJson(json_id, Team.class);
        Team t = (Team) FACADE.getTeamById(team.getId());
        return GSON.toJson(t);
    }

}
