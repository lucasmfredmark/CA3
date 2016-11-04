/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.User;
import httpErrors.UserNotFoundException;
import java.util.List;
import security.IUser;
import security.IUserFacadeOld;

/**
 *
 * @author Låne PC
 */
public interface IUserFacade extends IUserFacadeOld {

    User addPoints(int points) throws UserNotFoundException;

    /*
    Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    List<String> authenticateUser(String userName, String password);

    User createUser(User User);

    List<User> getAllUsers() throws UserNotFoundException;
    
    @Override
    IUser getUserByUserId(String id);

    User getUserByUsername(String username) throws UserNotFoundException;
    
}
