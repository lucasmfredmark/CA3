/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Follow;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import facades.interfaces.IFollowFacade;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Låne PC
 */
public class FollowFacade implements IFollowFacade {
    
    EntityManagerFactory emf;

    public FollowFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /*
    @Override
    public List<Follower> getFollowList(User forUser) {
        EntityManager em = getEntityManager();
        // May not work *NOTICE
        try {
            TypedQuery<Follower> result = em.createNamedQuery("Follower.findByOwner", Follower.class);
            List<Follower> followList = result.setParameter("username", forUser).getResultList();
            return followList;
        } finally {
            em.close();
        }
    }

    @Override
    public Follower addUserToFollowList(User friend, User me) {
        EntityManager em = getEntityManager();
        
        try {
            Follower fEntry = new Follower();
            fEntry.setFkUserFollowUsername(friend);
            fEntry.setFkUserUsername(me);
            em.getTransaction().begin();
            em.persist(fEntry);
            em.getTransaction().commit();
            return fEntry;
        } finally {
            em.close();
        }
    }
    */

    @Override
    public List<Follow> getAllUsersFollowed(String me) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Follow> result = em.createNamedQuery("Follow.findAllUsersFollowed", Follow.class);
            List<Follow> usersFollowed = result.setParameter("username", me).getResultList();
            return usersFollowed;
        } finally {
            em.close();
        }
    }

    @Override
    public void followAUser(String me, String you) {
        EntityManager em = getEntityManager();
        try {
            
            Follow entry = new Follow();
            User first = new User();
            first.setUsername(me);
            User second = new User();
            second.setUsername(you);
            entry.setMeUserUsername(first);
            entry.setYouUserUsername(second);
            
            em.getTransaction().begin();
            em.persist(entry);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
    }
    
}
