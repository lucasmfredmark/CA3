package facades;

import security.IUserFacade;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import rest.FollowList;
import rest.Pokemon;
import rest.Team;
import security.IUser;
import security.PasswordStorage;

public class Facade implements IUserFacade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
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
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<User> user = em.createQuery("SELECT * FROM User", User.class);
            List<User> u = user.getResultList();
            return u;

        } finally {
            em.close();
        }
    }

    public User getUserByName(User name) {
        EntityManager em = getEntityManager();

        try {
            User p = em.find(User.class, name);
            return p;
        } finally {
            em.close();
        }
    }

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

    public List<FollowList> getfollowList() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<FollowList> followlist = em.createQuery("SELECT * FROM FollowList", FollowList.class);
            List<FollowList> fl = followlist.getResultList();
            return fl;
        } finally {
            em.close();
        }
    }

    public FollowList addUserToFollowList(FollowList FollowList) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(FollowList);
            em.getTransaction().commit();
            return FollowList;
        } finally {
            em.close();
        }
    }

    public Team createTeam(Team Team) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(Team);
            em.getTransaction().commit();
            return Team;
        } finally {
            em.close();
        }
    }

    public List<Team> getTeams() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Team> teams = em.createQuery("SELECT * Team", Team.class);
            List<Team> t = teams.getResultList();
            return t;
        } finally {
            em.close();
        }
    }

    public Team getTeamById(Team id) {
        EntityManager em = getEntityManager();

        try {
            em.find(Team.class, id);
            return id;
        } finally {
            em.close();
        }
    }

    public Pokemon createPokemon(Pokemon Pokemon) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(Pokemon);
            em.getTransaction().commit();
            return Pokemon;
        } finally {
            em.close();
        }
    }

    public List<Pokemon> getAllPokemon() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Pokemon> pokemon = em.createQuery("SELECT * Pokemon", Pokemon.class);
            List<Pokemon> p = pokemon.getResultList();
            return p;
        } finally {
            em.close();
        }
    }

    public Pokemon getPokemonById(Pokemon id) {
        EntityManager em = getEntityManager();

        try {
            Pokemon p = em.find(Pokemon.class, id);
            return p;
        } finally {
            em.close();
        }
    }

    public Team getPokemonByTeam(int team_id) {
        EntityManager em = getEntityManager();

        try {
            Team t = em.find(Team.class, team_id);
            //Collection<Pokemon> pokemon = t.getAllPokemon()
            return t;

        } finally {
            em.close();
        }
    }

    public User addPoints(int points) {
        EntityManager em = getEntityManager();
        User u = em.find(User.class, points);
        
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
