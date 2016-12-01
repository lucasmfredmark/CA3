/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.interfaces;

import entity.Pokemon;
import entity.User;
import httpErrors.UserNotFoundException;

/**
 *
 * @author Låne PC
 */
public interface IUserFacade {

    User addPoints(int points, String username) throws UserNotFoundException;
    
    User removePoints(int points, String username) throws UserNotFoundException;
    
    Pokemon addPokemon(Pokemon pokemon, String username);
    
    User getUserByUsername(String username) throws UserNotFoundException;
    
}
