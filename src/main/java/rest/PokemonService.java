/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Pokemon;
import facades.interfaces.IPokemonFacade;
import facades.PokemonFacade;
import httpErrors.PokemonNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import jsonMappers.PokemonMapper;

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
    
    /*
    @PUT
    @Path("createPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createPokemon(String json_pokemon) {
        Pokemon pokemon = GSON.fromJson(json_pokemon, Pokemon.class);
        Pokemon p = (Pokemon) FACADE.createPokemon(pokemon);
        return GSON.toJson(p);
    }
    */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPokemon() throws PokemonNotFoundException {
        List<Pokemon> p = FACADE.getAllPokemon();
        List<PokemonMapper> pm = new ArrayList();
        
        for (Pokemon pokemon : p) {
            pm.add(new PokemonMapper(pokemon));
        }
        
        return GSON.toJson(pm);
    }
    
    /*
    @GET
    @Path("getPokemonById")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPokemonById(int json_id) throws PokemonNotFoundException {
       FACADE.getPokemonById(json_id);
       return GSON.toJson(json_id);
    }
    */
}
