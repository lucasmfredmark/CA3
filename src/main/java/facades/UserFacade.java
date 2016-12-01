/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Pokemon;
import entity.User;
import facades.interfaces.IUserFacade;
import httpErrors.UserNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
    
    public User removePoints(int points, int userid){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, userid);
            user.removePoints(points);
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } finally {
            em.close();
        }
    }
    
    public Pokemon addPokemon(Pokemon pokemon, User userid){
        EntityManager em = getEntityManager();
        
        try{
            em.getTransaction().begin();
            User user = em.find(User.class, userid);
            user.addPokemon(pokemon);
            em.persist(user);
            em.getTransaction().commit();
            return pokemon;
        }finally {
            em.close();
        }
    }
    
    /*
    @Override
    public IUser getUserByUserId(String id) {
        EntityManager em = getEntityManager();
        try {
            User user = em.find(User.class, id);
            return user;
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<User> result = em.createNamedQuery("User.findAll", User.class);
            List<User> users = result.getResultList();
            if (users.isEmpty()) throw new UserNotFoundException("No users found in database");
            return users;

        } finally {
            em.close();
        }
    }

*/

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        EntityManager em = getEntityManager();

        try {
            User p = em.find(User.class, username);
            if (p == null) throw new UserNotFoundException("No user found by name: " + username);
            return p;
        } finally {
            em.close();
        }
    }

//    @Override
//    public User createUser(User User) {
//        EntityManager em = getEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            em.persist(User);
//            em.getTransaction().commit();
//            return User;
//        } finally {
//            em.close();
//        }
//    }


    
    @Override
    public User addPoints(int points, String username) throws UserNotFoundException {
        EntityManager em = getEntityManager();
        User user = getUserByUsername(username);
        System.out.println("My user is: " + user + " and his/her balance is: " + user.getPoints());
        if (user == null) throw new UserNotFoundException("No user found to add points to");
        
        try {
            em.getTransaction().begin();
            user.addPoints(points);
        System.out.println(user.getPoints());
            em.persist(user);
            
            em.getTransaction().commit();
            return user;
        } finally {
            em.close();
        }

    }
    
}
