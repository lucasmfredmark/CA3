/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Team;
import facades.interfaces.ITeamFacade;
import facades.TeamFacade;
import httpErrors.TeamNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
import jsonMappers.TeamMapper;

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
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        return "Hello from team";
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createTeam(String json_team) {
        Team team = GSON.fromJson(json_team, Team.class);
        Team t = FACADE.createTeam(team);
        
        return GSON.toJson(t);
    }
    
    @DELETE
    @Path("delete/{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteTeam(@PathParam("id") int id) throws TeamNotFoundException {
        Team t = FACADE.deleteTeam(id);
        
        return GSON.toJson(t);
    }

    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeams() throws TeamNotFoundException {
        List<Team> teams = FACADE.getTeams();
        List<JsonObject> jsonTeams = new ArrayList();
        
        for (Team t : teams) {
            JsonArray pokedex_ids = new JsonArray();
            JsonObject jo = new JsonObject();
            
            jo.addProperty("id", t.getId());
            jo.addProperty("name", t.getName());
            jo.addProperty("creator", t.getFkUserUsername().getUserName());
            
            for (Pokemon p : t.getPokemonList()) {
                pokedex_ids.add(p.getPokedexId());
            }
            
            jo.add("pokemon", pokedex_ids);
            jsonTeams.add(jo);
        }
        
        return GSON.toJson(teams);
    }
    */
    
    /*
    @GET
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeamById(@PathParam("id") int id) throws TeamNotFoundException {
        Team t = (Team) FACADE.getTeamById(id);
        JsonArray pokedex_ids = new JsonArray();
        JsonObject jo = new JsonObject();
        jo.addProperty("id", t.getId());
        jo.addProperty("name", t.getName());
        jo.addProperty("creator", t.getFkUserUsername().getUserName());
        for (Pokemon p : t.getPokemonList()) {
            pokedex_ids.add(p.getPokedexId());
        }
        jo.add("pokemon", pokedex_ids);
        return GSON.toJson(jo);
    }
    */
    
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
