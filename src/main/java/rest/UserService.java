/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Pokemon;
import entity.User;
import facades.interfaces.IUserFacade;
import facades.UserFacade;
import httpErrors.PokemonNotFoundException;
import httpErrors.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import jsonMappers.PokemonMapper;
import jsonMappers.UserMapper;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("user")
@RolesAllowed({"User", "Admin"})
public class UserService {

    @Context
    private UriInfo context;

    @Context
    private SecurityContext securityContext;

    private static final IUserFacade FACADE = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of User
     */
    public UserService() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        return "Hello from user service";
    }

    @POST
    @Path("points/add/{points:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addPoints(@PathParam("points") int points) throws UserNotFoundException {
        User user = FACADE.addPoints(points, securityContext.getUserPrincipal().getName());
        UserMapper u = new UserMapper(user);

        return GSON.toJson(u);
    }

    /*
    @POST
    @Path("points/remove/{points:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removePoints(@PathParam("points") int points) throws UserNotFoundException {
        User user = FACADE.removePoints(points, securityContext.getUserPrincipal().getName());
        UserMapper u = new UserMapper(user);

        return GSON.toJson(u);
    }
    */

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserByUsername(@PathParam("username") String username) throws UserNotFoundException {
        User user = FACADE.getUserByUsername(username);
        UserMapper u = new UserMapper(user);

        return GSON.toJson(u);
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsers() throws UserNotFoundException {
        List<User> users = FACADE.getAllUsers();
        List<UserMapper> u = new ArrayList();

        for (User user : users) {
            u.add(new UserMapper(user));
        }

        return GSON.toJson(u);
    }
    
    @PUT
    @Path("buy/{pokedexId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String buyPokemon(@PathParam("pokedexId") int pokedexId) throws PokemonNotFoundException, Exception {
        Pokemon p = FACADE.buyPokemon(pokedexId, securityContext.getUserPrincipal().getName());
        PokemonMapper pm = new PokemonMapper(p);
        
        return GSON.toJson(pm);
    }
}
