/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Pokemon;
import entity.PokemonPrice;
import entity.User;
import facades.interfaces.IUserFacade;
import httpErrors.PokemonNotFoundException;
import httpErrors.UserNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Låne PC
 */
public class UserFacade implements IUserFacade {

    EntityManagerFactory emf;

    public UserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public User addPoints(int points, String username) throws UserNotFoundException {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            User user = em.find(User.class, username);
            if (user == null) {
                throw new UserNotFoundException("No user found to add points to");
            }
            user.addPoints(points);
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } finally {
            em.close();
        }

    }

    @Override
    public User removePoints(int points, String username) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, username);
            user.removePoints(points);
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } finally {
            em.close();
        }
    }
    
    @Override
    public Pokemon addPokemon(int pokedexId, String username) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Pokemon p = new Pokemon();
            p.setPokedexId(pokedexId);
            p.setFkUserUsername(new User(username));
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        EntityManager em = getEntityManager();

        try {
            User p = em.find(User.class, username);
            if (p == null) {
                throw new UserNotFoundException("No user found by name: " + username);
            }
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
            List<User> u = query.getResultList();

            if (u == null) {
                throw new UserNotFoundException("No users found.");
            }

            em.getTransaction().commit();

            return u;
        } finally {
            em.close();
        }
    }
    
    @Override
    public Pokemon buyPokemon(int pokedexId, String username) throws PokemonNotFoundException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            
            TypedQuery<PokemonPrice> result = em.createNamedQuery("PokemonPrice.findByPokedexId", PokemonPrice.class);
            result.setParameter("pokedexId", pokedexId);
            PokemonPrice pokemonPrice = result.getSingleResult();
            
            if (pokemonPrice == null) { throw new PokemonNotFoundException("No Pokémon was found with pokedexId " + pokedexId);}
            
            User user = getUserByUsername(username);
            
            if (user.getPoints() < pokemonPrice.getPrice()) throw new Exception("Not enough points on your account.");
            
            removePoints(pokemonPrice.getPrice(), username);
            Pokemon p = addPokemon(pokedexId, username);
            
            em.getTransaction().commit();
            
            return p;
        } finally {
            em.close();
        }
    }
}
