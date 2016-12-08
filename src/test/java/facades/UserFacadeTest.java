/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Pokemon;
import entity.User;
import facades.interfaces.IUserFacade;
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
 * @author Staal
 */
public class UserFacadeTest {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");
    private final IUserFacade userFacade = new UserFacade(emf);
    
    public UserFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // reset database data
        
    }
    
    @After
    public void tearDown() {
    }
  
    @Test
    public void testAddPoints() throws UserNotFoundException {
        System.out.println("addPoints");
        String username = "Lucas";
        int pointsToAdd = 1000;
        User user = userFacade.getUserByUsername(username);
        int oldBalance = user.getPoints();
        userFacade.addPoints(pointsToAdd, username);
        user = userFacade.getUserByUsername(username);
        int newBalance = user.getPoints();
        assertTrue(newBalance > oldBalance);
    }
    
    @Test
    public void testRemovePoints() throws UserNotFoundException {
        System.out.println("removePoints");
        String username = "Lucas";
        int pointsToRemove = 50;
        User user = userFacade.getUserByUsername(username);
        int oldBalance = user.getPoints();
        User result = userFacade.removePoints(pointsToRemove, username);
        int newBalance = result.getPoints();
        assertTrue(newBalance < oldBalance);
    }
    
    @Test
    public void testAddPokemon() {
        System.out.println("addPokemon");
        Pokemon pokemon = new Pokemon();
        String username = "Lucas";
        Pokemon expResult = new Pokemon();
        //Pokemon result = userFacade.addPokemon(pokemon, username);
        //assertEquals(expResult, result);
        
        fail("Not implemented completely.");
    }
    
    @Test
    public void testGetAllUsers() throws UserNotFoundException {
        System.out.println("getAllUsers");
        List<User> result = userFacade.getAllUsers();
        assertTrue(result.size() > 0);
    }
}
