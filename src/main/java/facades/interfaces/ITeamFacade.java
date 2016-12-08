/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.interfaces;

import entity.Team;
import httpErrors.TeamNotFoundException;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface ITeamFacade {

    Team createTeam(String name, String username);

    Team deleteTeam(int id) throws TeamNotFoundException;

    Team getTeamById(int id) throws TeamNotFoundException;

    List<Team> getTeamsByUsername(String username) throws TeamNotFoundException;
}
