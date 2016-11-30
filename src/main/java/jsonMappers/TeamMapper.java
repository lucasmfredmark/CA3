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
    private final String username;

    public TeamMapper(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.pokemonList = removeCircRefPokeList(team.getPokemonList());
        this.username = team.getUser().getUserName();
    }
    
    private List<Pokemon> removeCircRefPokeList(List<Pokemon> pl) {
        for (Pokemon p : pl) {
            p.setTeam(null);
            p.setUser(null);
        }
        return pl;
    }
    
}
