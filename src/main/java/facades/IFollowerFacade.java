/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Follower;
import entity.User;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface IFollowerFacade {

    Follower addUserToFollowList(User friend, User me);

    List<Follower> getFollowList(User forUser);
    
}
