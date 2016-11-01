package rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("demouser")
@RolesAllowed("User")
public class User {
  
  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllUsers(){
    return "{\"message\" : \"REST call accesible by only authenticated USERS\"}"; 
  }
 
}