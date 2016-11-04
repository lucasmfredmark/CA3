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
import httpErrors.PokemonNotFoundException;
import java.util.List;
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
@Path("pokemon")
public class PokemonService {

    @Context
    private UriInfo context;

    private static final IPokemonFacade FACADE = new PokemonFacade(Persistence.createEntityManagerFactory("pu_development"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of Pokemon
     */
    public PokemonService() {
    }

    /**
     * Retrieves representation of an instance of rest.Pokemon
     *
     * @param json_pokemon
     * @return an instance of java.lang.String
     */
    @PUT
    @Path("createPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createPokemon(String json_pokemon) {
        Pokemon pokemon = GSON.fromJson(json_pokemon, Pokemon.class);
        Pokemon p = (Pokemon) FACADE.createPokemon(pokemon);
        return GSON.toJson(p);
    }
    
    @GET
    @Path("getAllPokemon")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPokemon(String json_list) throws PokemonNotFoundException {
        List <Pokemon> p = FACADE.getAllPokemon();
        return GSON.toJson(p);
    }
    
    @GET
    @Path("getPokemonById")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPokemonById(int json_id) throws PokemonNotFoundException {
       FACADE.getPokemonById(json_id);
       return GSON.toJson(json_id);
       
    }
}
