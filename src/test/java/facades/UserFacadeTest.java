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
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
    private static final IUserFacade userFacade = new UserFacade(emf);
    
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
    }
    
    @After
    public void tearDown() {
    }
  
    @Test public void testAddPoints() throws UserNotFoundException {
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
        int points = 50;
        String username = "Lucas";
        User user = userFacade.getUserByUsername(username);
        int oldBalance = user.getPoints();
        User result = userFacade.removePoints(points, username);
        int newBalance = result.getPoints();
        assertTrue(newBalance < oldBalance);
    }

    /**
     * Test of addPokemon method, of class UserFacade.
     */
//    @Test
//    public void testAddPokemon() {
//        System.out.println("addPokemon");
//        Pokemon pokemon = null;
//        User userid = null;
//        UserFacade instance = null;
//        Pokemon expResult = null;
//        Pokemon result = instance.addPokemon(pokemon, userid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
