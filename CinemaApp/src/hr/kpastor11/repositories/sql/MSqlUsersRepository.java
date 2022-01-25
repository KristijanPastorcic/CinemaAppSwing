/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastor11.repositories.sql;

import hr.kpastor11.factories.DataSourceFactory;
import hr.kpastor11.modles.User;
import hr.kpastor11.repositories.interfaces.RoleManager;
import hr.kpastor11.repositories.interfaces.UsersRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.sql.DataSource;

/**
 *
 * @author islan
 */
public class MSqlUsersRepository implements UsersRepository, RoleManager {

    @Override
    public User getUser(int id) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try(Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall("")){
        
        }
    }

    @Override
    public boolean isUserInRole(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
