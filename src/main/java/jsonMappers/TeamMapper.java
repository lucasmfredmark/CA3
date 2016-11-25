/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonMappers;

import entity.Pokemon;
import entity.Team;
import entity.User;
import java.util.List;

/**
 *
 * @author lucasmfredmark
 */
public class TeamMapper {
    private final int id;
    private final String name;
    private final List<Pokemon> pokemonList;
    private final User user;

    public TeamMapper(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.pokemonList = team.getPokemonList();
        this.user = team.getUser();
    }
}
