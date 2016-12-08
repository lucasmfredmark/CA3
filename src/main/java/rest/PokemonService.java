/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Pokemon;
import entity.PokemonPrice;
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
import javax.ws.rs.PUT;
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

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPokemon() throws PokemonNotFoundException {
        List<Pokemon> pokemon = FACADE.getAllPokemon();
        List<PokemonMapper> pm = new ArrayList();

        for (Pokemon p : pokemon) {
            pm.add(new PokemonMapper(p));
        }

        return GSON.toJson(pm);
    }

    @GET
    @Path("username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPokemonByUsername(@PathParam("username") String username) throws PokemonNotFoundException {
        List<Pokemon> pokemon = FACADE.getAllPokemonByUsername(username);
        List<PokemonMapper> pm = new ArrayList();

        for (Pokemon p : pokemon) {
            pm.add(new PokemonMapper(p));
        }

        return GSON.toJson(pm);
    }
    
    @GET
    @Path("prices")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPokemonPrices() throws PokemonNotFoundException {
        List<PokemonPrice> pp = FACADE.getAllPokemonPrices();
        
        return GSON.toJson(pp);
    }
}
