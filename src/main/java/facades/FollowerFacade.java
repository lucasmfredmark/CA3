/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Follower;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
    
    @Override
    public List<Follower> getFollowList(String forUser) {
        EntityManager em = getEntityManager();
        // May not work *NOTICE
        try {
            TypedQuery<Follower> result = em.createNamedQuery("Follower.findByOwner", Follower.class);
            List<Follower> followList = result.setParameter(forUser, Follower.class).getResultList();
            return followList;
        } finally {
            em.close();
        }
    }

    @Override
    public Follower addUserToFollowList(String followerid, String username) {
        EntityManager em = getEntityManager();
        Follower fw = new Follower();
        try {
            em.getTransaction().begin();
            fw.setFkUserFollowUsername(followerid);
            fw.setFkUserUsername(username);
            em.persist(fw);
            em.getTransaction().commit();
            return fw;
        } finally {
            em.close();
        }

    }
    
}
