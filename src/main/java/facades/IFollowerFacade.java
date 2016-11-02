/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Follower;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface IFollowerFacade {

    Follower addUserToFollowList(String followerid, String username);

    List<Follower> getFollowList(String forUser);
    
}
