/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonMappers;

import entity.Pokemon;

/**
 *
 * @author lucasmfredmark
 */
public class PokemonMapper {
    private final Integer id;
    private final Integer pokedexId;
    private final String user;

    public PokemonMapper(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.pokedexId = pokemon.getPokedexId();
        this.user = pokemon.getFkUserUsername().getUsername();
    }
}
