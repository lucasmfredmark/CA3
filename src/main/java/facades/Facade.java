package facades;

import entity.Team;
import security.IUserFacade;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import entity.Pokemon;
import entity.Follower;
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
            TypedQuery<User> result = em.createNamedQuery("User.findAll", User.class);
            List<User> users = result.getResultList();
            return users;

        } finally {
            em.close();
        }
    }

    public User getUserByUserName(String username) {
        EntityManager em = getEntityManager();

        try {
            User p = em.find(User.class, username);
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

    public List<Follower> getFollowList() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Follower> result = em.createNamedQuery("Follower.findAll", Follower.class);
            List<Follower> followList = result.getResultList();
            return followList;
        } finally {
            em.close();
        }
    }

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
            TypedQuery<Team> result = em.createNamedQuery("Team.findAll", Team.class);
            List<Team> teams = result.getResultList();
            return teams;
        } finally {
            em.close();
        }
    }

    public Team getTeamById(int id) {
        EntityManager em = getEntityManager();

        try {
            Team t = em.find(Team.class, id);
            return t;
        } finally {
            em.close();
        }
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(pokemon);
            em.getTransaction().commit();
            return pokemon;
        } finally {
            em.close();
        }
    }

    public List<Pokemon> getAllPokemon() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Pokemon> result = em.createNamedQuery("Pokemon.findAll", Pokemon.class);
            List<Pokemon> pokemon = result.getResultList();
            return pokemon;
        } finally {
            em.close();
        }
    }

    public Pokemon getPokemonById(int id) {
        EntityManager em = getEntityManager();

        try {
            Pokemon p = em.find(Pokemon.class, id);
            return p;
        } finally {
            em.close();
        }
    }

    public List<Pokemon> getPokemonByTeam(int team_id) {
        EntityManager em = getEntityManager();

        try {
            Team t = em.find(Team.class, team_id);

            List<Pokemon> pokemon = t.getPokemonList();
            return pokemon;

        } finally {
            em.close();
        }
    }

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

    public Team addTeamToUser(Team team) {
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

    public Pokemon addPokemonToTeam(Pokemon pokemon) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction();
            em.persist(pokemon);
            em.getTransaction().commit();
            return pokemon;
        } finally {
            em.close();
        }
    }
}
