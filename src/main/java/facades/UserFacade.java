/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import facades.interfaces.IUserFacade;
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

    @Override
    public User createUser(User User) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(User);
            em.getTransaction().commit();
            return User;
        } finally {
            em.close();
        }
    }
    
    @Override
    public User addPoints(int points) throws UserNotFoundException {
        EntityManager em = getEntityManager();
        User u = em.find(User.class, points);
        if (u == null) throw new UserNotFoundException("No user found to add points to");
        u.addPoints(points);
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            return u;
        } finally {
            em.close();
        }

    }
    */
}
