package security;

import facades.UserFacadeOld;
import javax.persistence.Persistence;

/**
 *
 * @author lam
 */
public class UserFacadeFactory {
//    private static final IUserFacade instance = 
//            new UserFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
private static final IUserFacadeOld instance = 
            new UserFacadeOld(Persistence.createEntityManagerFactory("pu_development"));
    public static IUserFacadeOld getInstance(){
        return instance;
    }
}
