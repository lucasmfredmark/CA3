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
import java.util.List;
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
    
    private final Facade facade;
    
    public FacadeTest() {
        facade = new Facade(Persistence.createEntityManagerFactory("pu_development"));
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

    /**
     * Test of authenticateUser method, of class Facade.
     */
    @Test
    public void testAuthenticateUser() {
        System.out.println("authenticateUser");
        String userName = "";
        String password = "";
        Facade instance = null;
        List<String> expResult = null;
        List<String> result = instance.authenticateUser(userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class Facade.
     */
    @Test
    public void testGetAllUsers() {
        List<User> users = facade.getAllUsers();
        // If fails, check database for users. Should have 3
        assertTrue(users.size() > 1);
    }

    /**
     * Test of getUserByName method, of class Facade.
     */
    @Test
    public void testGetUserByName() {
        String username = "Lucas";
        User user = facade.getUserByName(username);
        assertTrue(user != null);
    }

    /**
     * Test of getfollowList method, of class Facade.
     * Test will fail because facade needs to be refactored and method implemented
     * properly
     */
    @Test
    public void testGetfollowList() {
        int forUser = 1;
        List<Follower> followList = facade.getfollowList(forUser);
        assertTrue(followList.size() > 1);
    }

    /**
     * Test of addUserToFollowList method, of class Facade.
     * Test will fail because of missing implementation in facade. addUserToFollowList
     * is not properly implemented
     */
    @Test
    public void testAddUserToFollowList() {
        int forUser = 1;
        String lookUp = "Lucas";
        List<Follower> followList = facade.getfollowList(forUser);
        int beforeAdd = followList.size();
        User user = facade.getUserByName(lookUp);
        facade.addUserToFollowList(user);
    }

    /**
     * Test of createTeam method, of class Facade.
     * Missing implementation of facade method
     */
    @Test
    public void testCreateTeam() {
        Team team = new Team();
        String lookUp = "Lucas";
        team.setName("FacadeTeam");
        User user = facade.getUserByName(lookUp);
        facade.addTeamToUser(user);
        user = facade.getUserByName(lookUp);
        assertTrue(user.getTeamList().size() > 0);
    }

    /**
     * Test of getTeams method, of class Facade.
     */
    @Test
    public void testGetTeams() {
        String lookUp = "Lucas";
        User user = facade.getUserByName(lookUp);
        assertTrue(user.getTeamList().size() > 0);
    }

    /**
     * Test of getTeamById method, of class Facade.
     * Refactor facade method to take an int instead of Team
     */
    @Test
    public void testGetTeamById() {
        int team_id = 1;
        Team team = facade.getTeamById(team_id);
        assertTrue(team != null);
    }

    /**
     * Test of createPokemon method, of class Facade.
     */
    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setPokedexId(13);
        int team_id = 1;
        facade.addPokemonToTeam(team_id);
        List<Pokemon> pokemonList = facade.getPokemonByTeam(team_id);
        for (Pokemon p : pokemonList) {
            if (p.getPokedexId().equals(13)) {
                pokemon = p;
            }
        }
        assertTrue(pokemon.getPokedexId().equals(13));
    }

    /**
     * Test of getAllPokemon method, of class Facade.
     */
    @Test
    public void testGetAllPokemon() {
        List<Pokemon> pokemonMasterList = facade.getAllPokemon();
        assertTrue(pokemonMasterList.size() > 1);
    }

    /**
     * Test of getPokemonById method, of class Facade.
     * Refactor getPokemonById to take int instead of object
     */
    @Test
    public void testGetPokemonById() {
        Pokemon pokemon = facade.getPokemonById(1);
        assertTrue(pokemon != null);
    }

    /**
     * Test of getPokemonByTeam method, of class Facade.
     * Refactor getTeamById to take int instead of object
     */
    @Test
    public void testGetPokemonByTeam() {
        Team t = facade.getTeamById(1);
        List<Pokemon> pokemonInTeam = t.getPokemonList();
        assertTrue(pokemonInTeam.size() > 0);
    }

    /**
     * Test of addPoints method, of class Facade.
     */
    @Test
    public void testAddPoints() {
        String lookUp = "Lucas";
        User user = facade.getUserByName(lookUp);
        int pointsToAdd = 100;
        int beforeAdd = user.getPoints();
        user.addPoints(pointsToAdd);
        user = facade.getUserByName(lookUp);
        int afterAdd = user.getPoints();
        assertTrue(afterAdd > beforeAdd);
    }
    
}
