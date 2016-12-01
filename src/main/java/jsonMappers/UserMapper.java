/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonMappers;

import entity.Follower;
import entity.Pokemon;
import entity.Role;
import entity.Team;
import entity.User;
import java.util.List;

/**
 *
 * @author xboxm
 */
public class UserMapper {
    
    private String username;
    private String firstname;
    private String lastname;
    private String gender;
    private String passwordHash;
    private int points;
    private List<Role> roleList;
    private List<Pokemon> pokemonList;
    private List<Team> teamList;
    private List<Follower> followerList;
    private List<Follower> followerList1;

    public UserMapper(User user) {
        this.username = user.getUserName();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.gender = user.getGender();
        this.passwordHash = user.getPasswordhash();
        this.points = user.getPoints();
        this.roleList = user.getRoleList();
        this.pokemonList = filterPokemonList(user.getPokemonList());
        this.teamList = filterTeamList(user.getTeamList());
        this.followerList = filterFollowerList(user.getFollowerList());
        this.followerList1 = filterFollowerList1(user.getFollowerList1());
    }
    
    private List<Pokemon> filterPokemonList(List<Pokemon> pl) {
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
        }
        return fl;
    }
    
    // I am not sure about the implementation of these follower lists. We haven't implemented
    // Follower functionality yet. But we need to rename the lists. It is confusing
    private List<Follower> filterFollowerList1(List<Follower> fl) {
        for (Follower f : fl) {
            f.setUser(null);
        }
        return fl;
    }
    
    
}
