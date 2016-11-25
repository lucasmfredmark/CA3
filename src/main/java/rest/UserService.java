/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.interfaces.IUserFacade;
import facades.UserFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;

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
    
    @PUT
    @Path("addPoints")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPoints(int json_points) throws UserNotFoundException{
        User u = (User) FACADE.addPoints(json_points);        
        return GSON.toJson(u);
    }
    */
}
