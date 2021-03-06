/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import facades.interfaces.ITeamFacade;
import entity.Team;
import entity.User;
import httpErrors.TeamNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Låne PC
 */
public class TeamFacade implements ITeamFacade {

    EntityManagerFactory emf;

    public TeamFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Team createTeam(String name, String username) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            Team team = new Team();
            team.setName(name);
            team.setFkUserUsername(new User(username));
            em.persist(team);
            em.getTransaction().commit();

            return team;
        } finally {
            em.close();
        }
    }

    @Override
    public Team deleteTeam(int id) throws TeamNotFoundException {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Team> query = em.createNamedQuery("Team.findById", Team.class);
            query.setParameter("id", id);
            Team t = query.getSingleResult();

            if (t == null) {
                throw new TeamNotFoundException("No team found with id: " + id);
            }

            em.remove(t);
            em.getTransaction().commit();

            return t;
        } finally {
            em.close();
        }
    }

    @Override
    public Team getTeamById(int id) throws TeamNotFoundException {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Team> query = em.createNamedQuery("Team.findById", Team.class);
            query.setParameter("id", id);
            Team t = query.getSingleResult();

            if (t == null) {
                throw new TeamNotFoundException("No team found with id: " + id);
            }

            return t;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Team> getTeamsByUsername(String username) throws TeamNotFoundException {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Team> query = em.createNamedQuery("Team.findByUsername", Team.class);
            query.setParameter("username", username);
            List<Team> t = query.getResultList();

            if (t == null) {
                throw new TeamNotFoundException("No team found with username: " + username);
            }

            return t;
        } finally {
            em.close();
        }
    }
}
