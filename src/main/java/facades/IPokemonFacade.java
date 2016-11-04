/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Pokemon;
import httpErrors.PokemonNotFoundException;
import httpErrors.TeamNotFoundException;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface IPokemonFacade {

    Pokemon createPokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon() throws PokemonNotFoundException;

    Pokemon getPokemonById(int id) throws PokemonNotFoundException;

    List<Pokemon> getPokemonByTeam(int team_id) throws PokemonNotFoundException, TeamNotFoundException;

}
