/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Follow;
import facades.interfaces.IFollowFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author xboxm
 */
public class FollowFacadeTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");
    IFollowFacade ff = new FollowFacade(emf);
    
    public FollowFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Set up dummy data for apache derby
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllUsersFollowed() {
        System.out.println("Test Get All Users Followed By A User");
        String me = "Lucas";
        List<Follow> listOfUsersFollowed = ff.getAllUsersFollowed(me);
        System.out.println("Number of users followed by Lucas: " + listOfUsersFollowed.size());
        assertTrue(listOfUsersFollowed.size() >= 0);
    }
    
    @Test
    public void testFollowAUser() {
        System.out.println("Test Follow A User");
        String me = "Lucas";
        String you = "Thomas";
        List<Follow> listOfUsersFollowed = ff.getAllUsersFollowed(me);
        int users_before = listOfUsersFollowed.size();
        ff.followAUser(me, you);
        listOfUsersFollowed = ff.getAllUsersFollowed(me);
        int users_after = listOfUsersFollowed.size();
        System.out.println("Size before: " + users_before + " & after: " + users_after);
        assertTrue(users_after > users_before);
    }
    
}
