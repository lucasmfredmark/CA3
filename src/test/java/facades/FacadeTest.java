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
        System.out.println("getAllUsers");
        Facade instance = null;
        List<User> expResult = null;
        List<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of createUser method, of class Facade.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        User User = null;
        Facade instance = null;
        User expResult = null;
        User result = instance.createUser(User);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getfollowList method, of class Facade.
     */
    @Test
    public void testGetfollowList() {
        System.out.println("getfollowList");
        Facade instance = null;
        List<Follower> expResult = null;
        List<Follower> result = instance.getfollowList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserToFollowList method, of class Facade.
     */
    @Test
    public void testAddUserToFollowList() {
        System.out.println("addUserToFollowList");
        Follower FollowList = null;
        Facade instance = null;
        List<Follower> expResult = null;
        List<Follower> result = instance.addUserToFollowList(FollowList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTeam method, of class Facade.
     */
    @Test
    public void testCreateTeam() {
        System.out.println("createTeam");
        Team Team = null;
        Facade instance = null;
        Team expResult = null;
        Team result = instance.createTeam(Team);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeams method, of class Facade.
     */
    @Test
    public void testGetTeams() {
        System.out.println("getTeams");
        Facade instance = null;
        List<Team> expResult = null;
        List<Team> result = instance.getTeams();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamById method, of class Facade.
     */
    @Test
    public void testGetTeamById() {
        System.out.println("getTeamById");
        Team id = null;
        Facade instance = null;
        Team expResult = null;
        Team result = instance.getTeamById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPokemon method, of class Facade.
     */
    @Test
    public void testCreatePokemon() {
        System.out.println("createPokemon");
        Pokemon pokemon = null;
        Facade instance = null;
        Pokemon expResult = null;
        Pokemon result = instance.createPokemon(pokemon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPokemon method, of class Facade.
     */
    @Test
    public void testGetAllPokemon() {
        System.out.println("getAllPokemon");
        Facade instance = null;
        List<Pokemon> expResult = null;
        List<Pokemon> result = instance.getAllPokemon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPokemonById method, of class Facade.
     */
    @Test
    public void testGetPokemonById() {
        System.out.println("getPokemonById");
        Pokemon id = null;
        Facade instance = null;
        Pokemon expResult = null;
        Pokemon result = instance.getPokemonById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPokemonByTeam method, of class Facade.
     */
    @Test
    public void testGetPokemonByTeam() {
        System.out.println("getPokemonByTeam");
        int team_id = 0;
        Facade instance = null;
        List<Pokemon> expResult = null;
        List<Pokemon> result = instance.getPokemonByTeam(team_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPoints method, of class Facade.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        int points = 0;
        Facade instance = null;
        User expResult = null;
        User result = instance.addPoints(points);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
