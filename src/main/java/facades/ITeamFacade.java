/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Team;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface ITeamFacade {

    Team createTeam(Team team);

    Team getTeamById(int id);

    List<Team> getTeams();
    
}
