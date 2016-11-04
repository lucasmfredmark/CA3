/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Team;
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
    public Team createTeam(Team team) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(team);
            em.getTransaction().commit();
            return team;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Team> getTeams() throws TeamNotFoundException {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Team> result = em.createNamedQuery("Team.findAll", Team.class);
            List<Team> teams = result.getResultList();
            if (teams.isEmpty()) throw new TeamNotFoundException("No teams found in the database");
            return teams;
        } finally {
            em.close();
        }
    }

    @Override
    public Team getTeamById(int id) throws TeamNotFoundException{
        EntityManager em = getEntityManager();

        try {
            Team t = em.find(Team.class, id);
            if (t == null) throw new TeamNotFoundException("No team found with id: " + id);
            return t;
        } finally {
            em.close();
        }
    }
}
