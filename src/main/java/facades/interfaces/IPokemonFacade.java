/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.interfaces;

import entity.Pokemon;
import entity.PokemonPrice;
import httpErrors.PokemonNotFoundException;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface IPokemonFacade {

    List<Pokemon> getAllPokemon() throws PokemonNotFoundException;

    List<Pokemon> getAllPokemonByUsername(String username) throws PokemonNotFoundException;

    List<PokemonPrice> getAllPokemonPrices() throws PokemonNotFoundException;
}
