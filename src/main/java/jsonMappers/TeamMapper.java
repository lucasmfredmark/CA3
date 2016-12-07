/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonMappers;

import entity.Pokemon;
import entity.Team;
import java.util.List;

/**
 *
 * @author lucasmfredmark
 */
public class TeamMapper {
    private final int id;
    private final String name;
    private final String username;
    private final List<Pokemon> pokemonList;

    public TeamMapper(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.pokemonList = removeCircRefPokeList(team.getPokemon());
        this.username = team.getFkUserUsername().getUsername();
    }
    
    private List<Pokemon> removeCircRefPokeList(List<Pokemon> pl) {
        for (Pokemon p : pl) {
            p.setTeams(null);
            p.setFkUserUsername(null);
        }
        return pl;
    }
    
}
