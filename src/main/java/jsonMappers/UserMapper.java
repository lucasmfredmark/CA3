/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonMappers;

import entity.Follow;
import entity.Pokemon;
import entity.Team;
import entity.User;
import java.util.List;

/**
 *
 * @author xboxm
 */
public class UserMapper {
    
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String gender;
    private final Integer points;
    private List<Pokemon> pokemonList;
    private List<Team> teamList;
    private List<Follow> followList;
    private List<Follow> followList1;

    public UserMapper(User user) {
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.gender = user.getGender();
        this.points = user.getPoints();
//        this.roleList = null;
//        this.pokemonList = null;
//        this.teamList = null;
//        this.followList = null;
//        this.followList1 = null;
//        this.pokemonList = filterPokemonList(user.getPokemon());
//        this.teamList = filterTeamList(user.getTeamList());
//        this.followerList = filterFollowerList(user.getFollowerList());
//        this.followerList1 = filterFollowerList1(user.getFollowerList1());
    }
    
    /*private List<Pokemon> filterPokemonList(List<Pokemon> pl) {
        for (Pokemon p : pl) {
            p.setTeam(null);
            p.setUser(null);
        }
        return pl;
    }
    
    private List<Team> filterTeamList(List<Team> tl) {
        for (Team t : tl) {
            t.setUser(null);
            t.setPokemonList(filterPokemonList(t.getPokemonList()));
        }
        return tl;
    }
    
    // I am not sure about the implementation of these follower lists. We haven't implemented
    // Follower functionality yet. But we need to rename the lists. It is confusing
    private List<Follower> filterFollowerList(List<Follower> fl) {
        for (Follower f : fl) {
            f.setUser(null);
            f.setFollowUser(null);
        }
        return fl;
    }
    
    // I am not sure about the implementation of these follower lists. We haven't implemented
    // Follower functionality yet. But we need to rename the lists. It is confusing
    private List<Follower> filterFollowerList1(List<Follower> fl) {
        for (Follower f : fl) {
            f.setUser(null);
            f.setFollowUser(null);
        }
        return fl;
    }*/
    
    
}
