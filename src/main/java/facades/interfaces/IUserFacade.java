/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.interfaces;

import entity.Pokemon;
import entity.User;
import httpErrors.PokemonNotFoundException;
import httpErrors.UserNotFoundException;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface IUserFacade {

    User addPoints(int points, String username) throws UserNotFoundException;

    User removePoints(int points, String username) throws UserNotFoundException;

    public Pokemon addPokemon(int pokedexId, String username);

    User getUserByUsername(String username) throws UserNotFoundException;

    List<User> getAllUsers() throws UserNotFoundException;

    Pokemon buyPokemon(int pokedexId, String username) throws PokemonNotFoundException, UserNotFoundException, Exception;

}
