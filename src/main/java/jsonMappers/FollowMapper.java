/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonMappers;

import entity.Follow;

/**
 *
 * @author xboxm
 */
public class FollowMapper {
    
    private int id;
    private String meUserUsername;
    private String youUserUsername;

    public FollowMapper(Follow follow) {
        this.id = follow.getId();
        this.meUserUsername = follow.getMeUserUsername().getUsername();
        this.youUserUsername = follow.getYouUserUsername().getUsername();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeUserUsername() {
        return meUserUsername;
    }

    public void setMeUserUsername(String meUserUsername) {
        this.meUserUsername = meUserUsername;
    }

    public String getYouUserUsername() {
        return youUserUsername;
    }

    public void setYouUserUsername(String youUserUsername) {
        this.youUserUsername = youUserUsername;
    }
    
    
    
}
