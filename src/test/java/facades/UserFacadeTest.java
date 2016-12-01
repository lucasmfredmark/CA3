/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Pokemon;
import entity.User;
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

    /**
     * Test of removePoints method, of class UserFacade.
     */
    @Test
    public void testRemovePoints() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        

        int points = 50;
        String username = "Lucas";
        Integer expResult = 50;
        
        UserFacade instance = new UserFacade(emf);
        User result = instance.removePoints(points, username);
        
        assertEquals(expResult, result.getPoints());
    }

    /**
     * Test of addPokemon method, of class UserFacade.
     */
    @Test
    public void testAddPokemon() {
        /*
        System.out.println("addPokemon");
        Pokemon pokemon = null;
        User userid = null;
        UserFacade instance = null;
        Pokemon expResult = null;
        Pokemon result = instance.addPokemon(pokemon, userid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
*/
    }
    
}
