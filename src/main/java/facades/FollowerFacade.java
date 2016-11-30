/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import facades.interfaces.IFollowerFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Låne PC
 */
public class FollowerFacade implements IFollowerFacade {
    
    EntityManagerFactory emf;

    public FollowerFacade(EntityManagerFactory emf) {
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
    
}
