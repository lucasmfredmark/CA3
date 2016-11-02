/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.IUser;
import security.PasswordStorage;
import security.IUserFacadeOld;

/**
 *
 * @author Låne PC
 */
public class UserFacade implements IUserFacade{
    
    EntityManagerFactory emf;

    public UserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public IUser getUserByUserId(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        IUser user = getUserByUserId(userName);
        try {
            return user != null && PasswordStorage.verifyPassword(password, user.getPassword()) ? user.getRolesAsStrings() : null;
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(Facade_DO_NOT_USE.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<User> result = em.createNamedQuery("User.findAll", User.class);
            List<User> users = result.getResultList();
            return users;

        } finally {
            em.close();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        EntityManager em = getEntityManager();

        try {
            User p = em.find(User.class, username);
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
    public User addPoints(int points) {
        EntityManager em = getEntityManager();
        User u = em.find(User.class, points);
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
    
}
