/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Role;
import entity.User;
import facades.UserFacadeOld;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author lucasmfredmark
 */
public class CreateTestUsers {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("pu_development").createEntityManager();
        
        try {
            System.out.println("Creating TEST Users");
            
            if (em.find(User.class, "user") == null) {
                em.getTransaction().begin();
                
                Role userRole = new Role("User");
                Role adminRole = new Role("Admin");
                
                User lucas = new User("Lucas", "test");
                lucas.addRole(userRole);
                lucas.addRole(adminRole);
                
                User patrick = new User("Patrick", "test");
                patrick.addRole(userRole);
                patrick.addRole(adminRole);
                
                User thomas = new User("Thomas", "test");
                thomas.addRole(userRole);
                thomas.addRole(adminRole);
                
                em.persist(userRole);
                em.persist(adminRole);
                em.persist(lucas);
                em.persist(patrick);
                em.persist(thomas);
                
                em.getTransaction().commit();
                
                System.out.println("Created TEST Users");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserFacadeOld.class.getName()).log(Level.SEVERE, null, ex);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
