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
    public Follow followAUser(String me, String you) {
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

            return entry;
        } finally {
            em.close();
        }
    }

}
