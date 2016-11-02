/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Pokemon;
import entity.Team;
import java.util.List;
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

    @Override
    public List<Pokemon> getAllPokemon() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Pokemon> result = em.createNamedQuery("Pokemon.findAll", Pokemon.class);
            List<Pokemon> pokemon = result.getResultList();
            return pokemon;
        } finally {
            em.close();
        }
    }

    @Override
    public Pokemon getPokemonById(int id) {
        EntityManager em = getEntityManager();

        try {
            Pokemon p = em.find(Pokemon.class, id);
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Pokemon> getPokemonByTeam(int team_id) {
        EntityManager em = getEntityManager();

        try {
            Team t = em.find(Team.class, team_id);

            List<Pokemon> pokemon = t.getPokemonList();
            return pokemon;

        } finally {
            em.close();
        }
    }
    
    @Override
    public Pokemon addPokemonToTeam(Pokemon pokemon) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction();
            em.persist(pokemon);
            em.getTransaction().commit();
            return pokemon;
        } finally {
            em.close();
        }
    }
    
}
