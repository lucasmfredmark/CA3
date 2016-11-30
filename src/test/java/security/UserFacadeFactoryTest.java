/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasmfredmark
 */
public class UserFacadeFactoryTest {
    
    public UserFacadeFactoryTest() {
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
     * Test of getInstance method, of class UserFacadeFactory.
     */
    /*@Test
    public void testGetInstance() {
        System.out.println("getInstance");
        IUserFacadeOld expResult = null;
        IUserFacadeOld result = UserFacadeFactory.getInstance();
        assertEquals(expResult, result);
    }*/
    
    @Test
    public void testAuthenticateUser() {
        System.out.println("getAuthenticateUser");

        IUserFacadeOld facade = UserFacadeFactory.getInstance();
        List<String> roles = facade.authenticateUser("Lucas", "test");
        System.out.println(roles.size());
        assertTrue(roles.size() == 2);
    }
    
}
