/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.User;
import facades.IUserFacade;
import facades.UserFacade;
import httpErrors.UserNotFoundException;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

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
    
    /**
     * Retrieves representation of an instance of rest.User
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String allUsers() throws UserNotFoundException {
        List <User> users = FACADE.getAllUsers();      
        return GSON.toJson(users);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("greeting")
    public String getGreeting() {
        return "Hello from User Service";
    }
    
    @GET
    @Path("username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
<<<<<<< HEAD
    public String getUserByUsername(String json_user) throws UserNotFoundException {
        FACADE.getUserByUsername(json_user);
        return GSON.toJson(json_user);
=======
    public String getUserByUsername(@PathParam("username") String json_user) {
        User user = FACADE.getUserByUsername(json_user);
        return GSON.toJson(user);
>>>>>>> 1bc42606936f535cab9d7f2688e1390ec4b94497
    }
    
    @PUT
    @Path("createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(String json_user){
        User user = GSON.fromJson(json_user, User.class);
        User p = (User) FACADE.createUser(user);
        return GSON.toJson(p);
    }
    
    @PUT
    @Path("addPoints")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPoints(int json_points) throws UserNotFoundException{
        User u = (User) FACADE.addPoints(json_points);        
        return GSON.toJson(u);
    }
    
}
