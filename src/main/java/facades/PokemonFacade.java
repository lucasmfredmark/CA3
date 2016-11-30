/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import facades.interfaces.IPokemonFacade;
import entity.Pokemon;
import entity.Team;
import httpErrors.PokemonNotFoundException;
import httpErrors.TeamNotFoundException;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Låne PC
 */
public class PokemonFacade implements IPokemonFacade {
    
    EntityManagerFactory emf;

    public PokemonFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /*
    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(pokemon);
            em.getTransaction().commit();
            return pokemon;
        } finally {
            em.close();
        }
    }
    */

    @Override
    public List<Pokemon> getAllPokemon() throws PokemonNotFoundException {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Pokemon> result = em.createNamedQuery("Pokemon.findAll", Pokemon.class);
            List<Pokemon> p = result.getResultList();
            
            if (p == null) throw new PokemonNotFoundException("No Pokémon was found.");
            
            return p;
        } finally {
            em.close();
        }
    }

    /*
    @Override
    public Pokemon getPokemonById(int id) throws PokemonNotFoundException {
        EntityManager em = getEntityManager();

        try {
            Pokemon p = em.find(Pokemon.class, id);
            if (p == null) throw new PokemonNotFoundException("No pokemon found with id: " + id);
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Pokemon> getPokemonByTeam(int team_id) throws PokemonNotFoundException, TeamNotFoundException {
        EntityManager em = getEntityManager();

        try {
            Team t = em.find(Team.class, team_id);
            if (t == null) throw new TeamNotFoundException("No team found with id: " + team_id);
            List<Pokemon> pokemon = t.getPokemonList();
            if (pokemon.isEmpty()) throw new PokemonNotFoundException("No pokemon in team: " + team_id);
            return pokemon;

        } finally {
            em.close();
        }
    }
    */
}
