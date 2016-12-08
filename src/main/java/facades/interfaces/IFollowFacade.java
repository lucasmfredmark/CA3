/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.interfaces;

import entity.Follow;
import java.util.List;

/**
 *
 * @author Låne PC
 */
public interface IFollowFacade {

    public List<Follow> getAllUsersFollowed(String me);

    public Follow followAUser(String me, String you);

}
