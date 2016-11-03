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
@Path("api")
public class TeamService {

    @Context
    private UriInfo context;

    private static final ITeamFacade FACADE = new TeamFacade(Persistence.createEntityManagerFactory("PU"));
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
    @GET
    @Path("createTeam")
    @Produces(MediaType.APPLICATION_JSON)
    public String createTeam(String json_team) {
        Team team = GSON.fromJson(json_team, Team.class);
        Team t = (Team) FACADE.createTeam(team);
        return GSON.toJson(t);
    }

    @GET
    @Path("getTeams")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeams(String json_teams) {
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
