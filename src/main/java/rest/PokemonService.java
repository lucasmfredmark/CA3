/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Pokemon;
import facades.IPokemonFacade;
import facades.PokemonFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("api")
public class PokemonService {

    @Context
    private UriInfo context;

     private static final IPokemonFacade FACADE = new PokemonFacade(Persistence.createEntityManagerFactory("PU"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of Pokemon
     */
    public PokemonService() {
    }

    /**
     * Retrieves representation of an instance of rest.Pokemon
     * @return an instance of java.lang.String
     */
    @GET
    @Path("addPokemonToTeam")
    @Produces(MediaType.APPLICATION_JSON)
    public String addPokemonToTeam(String json_pokemon) {
        Pokemon pm = GSON.fromJson(json_pokemon, Pokemon.class);
        return GSON.toJson(pm);
        
    }

    /**
     * PUT method for updating or creating an instance of Pokemon
     * @param content representation for the resource
     */
//    @PUT
//    @Path("createPokemon")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String createPokemon(String json_pokemon) {
//        
//    }
}
