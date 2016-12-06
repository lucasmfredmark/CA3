/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Team;
import entity.User;
import facades.interfaces.ITeamFacade;
import httpErrors.TeamNotFoundException;
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
public class TeamFacadeTest {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
    private static final ITeamFacade teamFacade = new TeamFacade(emf);
    
    public TeamFacadeTest() {
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
     * Test of createTeam method, of class TeamFacade.
     * @throws httpErrors.TeamNotFoundException
     */
    @Test
    public void testCreateTeam() throws TeamNotFoundException {
        System.out.println("createTeam");
        
        String username = "Lucas";
        List<Team> oldTeams = teamFacade.getTeamsByUsername(username);
        int oldTeamsCount = oldTeams.size();
        
        Team team = new Team();
        User user = new User();
        user.setUsername("Lucas");
        team.setUser(user);
        teamFacade.createTeam(team);
        
        List<Team> newTeams = teamFacade.getTeamsByUsername(user.getUserName());
        int newTeamsCount = newTeams.size();
        
        assertTrue(newTeamsCount > oldTeamsCount);
    }

    /**
     * Test of deleteTeam method, of class TeamFacade.
     * @throws httpErrors.TeamNotFoundException
     */
    @Test
    public void testDeleteTeam() throws TeamNotFoundException {
        /*System.out.println("deleteTeam");
        int id = 1;
        int expResult = id;
        Team result = teamFacade.deleteTeam(id);
        assertTrue(expResult == result.getId());*/
    }
//
//    /**
//     * Test of getTeamById method, of class TeamFacade.
//     */
//    @Test
//    public void testGetTeamById() throws Exception {
//        System.out.println("getTeamById");
//        int id = 0;
//        TeamFacade instance = null;
//        Team expResult = null;
//        Team result = instance.getTeamById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTeamsByUsername method, of class TeamFacade.
//     */
//    @Test
//    public void testGetTeamsByUsername() throws Exception {
//        System.out.println("getTeamsByUsername");
//        String username = "";
//        TeamFacade instance = null;
//        List<Team> expResult = null;
//        List<Team> result = instance.getTeamsByUsername(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
