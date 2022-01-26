/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastor11.repositories.sql;

import hr.kpastor11.factories.DataSourceFactory;
import hr.kpastor11.roles.User;
import hr.kpastor11.repositories.interfaces.RoleManager;
import hr.kpastor11.repositories.interfaces.UsersRepository;
import hr.kpastor11.roles.enums.Role;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.sql.DataSource;

/**
 *
 * @author islan
 */
public class MSqlUsersRepository implements UsersRepository, RoleManager {

    private final String ID = "@id";
    
    private static final String IS_USER_IN_ROLE = "{ CALL isUserInRole (?,?) }";
    
    @Override
    public User getUser(int id) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall("")) {
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isUserInRole(int idUser, Role role) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(IS_USER_IN_ROLE)) {
            
            stmt.setInt(ID, idUser);
            stmt.setString("@role", role.name());
            return stmt.execute();
        }
    }
    
}
