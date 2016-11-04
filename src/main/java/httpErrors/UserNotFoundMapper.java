/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpErrors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.internal.util.ExceptionUtils;

/**
 *
 * @author Låne PC
 */
@Provider
public class UserNotFoundMapper implements ExceptionMapper<UserNotFoundException> {
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(UserNotFoundException e) {
        com.google.gson.JsonObject job = new JsonObject();
        job.addProperty("status", 404);
        job.addProperty("msg", e.getMessage());
        job.addProperty("stackTrace", ExceptionUtils.exceptionStackTraceAsString(e));
        return Response.status(404).entity(gson.toJson(job)).build();
    }
    
}
