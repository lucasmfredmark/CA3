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
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import jsonMappers.PokemonMapper;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("pokemon")
//@RolesAllowed({"User", "Admin"})
public class PokemonService {

    @Context
    private UriInfo context;

    @Context
    private SecurityContext securityContext;

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
    
    @GET
    @Path("username/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String getAllPokemonByUsername(@PathParam("username") String username) throws PokemonNotFoundException {
//        return "Hello from get all pokemon by username, " + username;
          List<Pokemon> pokemon = FACADE.getAllPokemonByUsername(username);
          List<PokemonMapper> pokemonMapped = new ArrayList();
          for (Pokemon p : pokemon) {
              pokemonMapped.add(new PokemonMapper(p));
          }
          return GSON.toJson(pokemonMapped);
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
