/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Pokemon;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface IPokemonFacade {

    Pokemon addPokemonToTeam(Pokemon pokemon);

    Pokemon createPokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon();

    Pokemon getPokemonById(int id);

    List<Pokemon> getPokemonByTeam(int team_id);
    
}
