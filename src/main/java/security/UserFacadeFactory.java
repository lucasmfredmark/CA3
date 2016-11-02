package security;

import facades.Facade_DO_NOT_USE;
import javax.persistence.Persistence;

/**
 *
 * @author lam
 */
public class UserFacadeFactory {
//    private static final IUserFacade instance = 
//            new UserFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
private static final IUserFacadeOld instance = 
            new Facade_DO_NOT_USE(Persistence.createEntityManagerFactory("pu_development"));
    public static IUserFacadeOld getInstance(){
        return instance;
    }
}
