/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Follower;
import entity.Pokemon;
import entity.Team;
import entity.User;
import httpErrors.PokemonNotFoundException;
import httpErrors.TeamNotFoundException;
import httpErrors.UserNotFoundException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Låne PC
 */
public class FacadeTest {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
//    private static final Facade facade = = new Facade(emf);
    private static final UserFacade uf = new UserFacade(emf);
    private static final TeamFacade tf = new TeamFacade(emf);
    private static final FollowerFacade ff = new FollowerFacade(emf);
    private static final PokemonFacade pf = new PokemonFacade(emf);
    
    public FacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void createTeam(){
        Team team = new Team();
        User user = new User();
        team.setName("team");
        team.setUser(user);
        assertTrue(team.getName() == "team" && team.getUser() == user);
        
    }

    @Test(expected = NullPointerException.class)
    public void deleteTeam() throws TeamNotFoundException {
        Team team = new Team();
        tf.deleteTeam(team.getId());
        
    }
    /**
     * Test of getAllUsers method, of class Facade.
     */
//    @Test
//    public void testGetAllUsers() throws UserNotFoundException {
//        List<User> users = uf.getAllUsers();
//        // If fails, check database for users. Should have 3
//        assertTrue(users.size() > 1);
//    }

    /**
     * Test of getUserByName method, of class Facade.
     */
//    @Test
//    public void testGetUserByName() throws UserNotFoundException {
//        String username = "Lucas";
//        User user = uf.getUserByUsername(username);
//        assertTrue(user != null);
//    }

    /**
     * Test of getfollowList method, of class Facade.
     * Test will fail because facade needs to be refactored and method implemented
     * properly
     */
//    @Test
//    public void testGetfollowList() throws UserNotFoundException {
//        String user = "Lucas";
//        User forUser = uf.getUserByUsername(user);
//        List<Follower> followList = ff.getFollowList(forUser);
//        assertTrue(followList.size() > 1);
//    }

    /**
     * Test of addUserToFollowList method, of class Facade.
     * Test will fail because of missing implementation in facade. addUserToFollowList
     * is not properly implemented
     */
//    @Test
//    public void testAddUserToFollowList() throws UserNotFoundException {
//        String username = "Lucas";
//        String usernameF = "Thomas";
//        User me = uf.getUserByUsername(username);
//        User friend = uf.getUserByUsername(username);
//        List<Follower> followList = ff.getFollowList(me);
//        int beforeAdd = followList.size();
//        ff.addUserToFollowList(friend, me);
//        followList = ff.getFollowList(me);
//        int afterAdd = followList.size();
//        assertTrue(afterAdd > beforeAdd);
//    }

    /**
     * Test of createTeam method, of class Facade.
     * Missing implementation of facade method
     */
//    @Test
//    public void testCreateTeam() throws UserNotFoundException {
//        Team team = new Team();
//        String lookUp = "Lucas";
//        team.setName("FacadeTeam");
//        User user = uf.getUserByUsername(lookUp);
//        team.setFkUserUsername(user);
//        tf.createTeam(team);
//        user = uf.getUserByUsername(lookUp);
//        assertTrue(user.getTeamList().size() > 1);
//    }

    /**
     * Test of getTeams method, of class Facade.
     */
//    @Test
//    public void testGetTeams() throws UserNotFoundException {
//        String lookUp = "Lucas";
//        User user = uf.getUserByUsername(lookUp);
//        assertTrue(user.getTeamList().size() > 0);
//    }

    /**
     * Test of getTeamById method, of class Facade.
     * Refactor facade method to take an int instead of Team
     */
    @Test
    public void testGetTeamById() throws TeamNotFoundException {
        int team_id = 1;
        Team team = tf.getTeamById(team_id);
        assertTrue(team != null);
    }

    /**
     * Test of createPokemon method, of class Facade.
     */
//    @Test
//    public void testCreatePokemon() throws PokemonNotFoundException {
//        Pokemon pokemon = new Pokemon();
//        pokemon.setPokedexId(13);
//        pf.createPokemon(pokemon);
//        Pokemon returnedPokemon = pf.getPokemonById(7);
//        assertTrue(returnedPokemon != null);
//    }

    /**
     * Test of getAllPokemon method, of class Facade.
     */
    @Test
    public void testGetAllPokemon() throws PokemonNotFoundException {
        List<Pokemon> pokemonMasterList = pf.getAllPokemon();
        assertTrue(pokemonMasterList.size() > 1);
    }

    /**
     * Test of getPokemonById method, of class Facade.
     * Refactor getPokemonById to take int instead of object
     */
//    @Test
//    public void testGetPokemonById() throws PokemonNotFoundException {
//        Pokemon pokemon = pf.getPokemonById(1);
//        assertTrue(pokemon != null);
//    }

    /**
     * Test of getPokemonByTeam method, of class Facade.
     * Refactor getTeamById to take int instead of object
     */
    @Test
    public void testGetPokemonByTeam() throws TeamNotFoundException {
        Team t = tf.getTeamById(1);
        List<Pokemon> pokemonInTeam = t.getPokemonList();
        System.out.println(pokemonInTeam.size());
        assertTrue(pokemonInTeam.size() > 0);
    }

    /**
     * Test of addPoints method, of class Facade.
     * Missing implementation of edit user to make this happen
     */ 
//    @Test
//    public void testAddPoints() {
//        String lookUp = "Lucas";
//        User user = uf.getUserByUsername(lookUp);
//        int pointsToAdd = 100;
//        int beforeAdd = user.getPoints();
//        user.addPoints(pointsToAdd);
//        user = uf.getUserByUsername(lookUp);
//        int afterAdd = user.getPoints();
//        assertTrue(afterAdd > beforeAdd);
//    }
    
    
}
