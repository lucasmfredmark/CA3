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
import httpErrors.UserNotFoundException;
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
import jsonMappers.PokemonMapper;
import jsonMappers.UserMapper;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("user")
public class UserService {

    @Context
    private UriInfo context;

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
    
    /*
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String allUsers() throws UserNotFoundException {
        List <User> users = FACADE.getAllUsers();      
        return GSON.toJson(users);
    }
    
    @GET
    @Path("username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserByUsername(String json_user) throws UserNotFoundException {
        FACADE.getUserByUsername(json_user);
        return GSON.toJson(json_user);
    }
    
    @PUT
    @Path("createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(String json_user){
        User user = GSON.fromJson(json_user, User.class);
        User p = (User) FACADE.createUser(user);
        return GSON.toJson(p);
    }

*/
    
    @POST
    @Path("{username}/points/add/{points:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addPoints(@PathParam("points") int points, @PathParam("username") String username) throws UserNotFoundException{
        User user = FACADE.addPoints(points, username); 
        UserMapper u = new UserMapper(user);
        
        return GSON.toJson(u);
    }
    
    @POST
    @Path("{username}/points/remove/{points:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removePoints(@PathParam("points") int points, @PathParam("username") String username) throws UserNotFoundException{
        User user = FACADE.removePoints(points, username);
        UserMapper u = new UserMapper(user);
        
        return GSON.toJson(u);
    }
    
    @PUT
    @Path("{username}/pokemon/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPokemon(String json_pokemon, @PathParam("username") String username) {
        Pokemon pokemon = FACADE.addPokemon(GSON.fromJson(json_pokemon, Pokemon.class), username);
        PokemonMapper p = new PokemonMapper(pokemon);
        
        return GSON.toJson(p);
    }
    
    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserByUsername(@PathParam("username") String username) throws UserNotFoundException {
        User user = FACADE.getUserByUsername(username);
        UserMapper u = new UserMapper(user);
        
        return GSON.toJson(u);
    }
}
