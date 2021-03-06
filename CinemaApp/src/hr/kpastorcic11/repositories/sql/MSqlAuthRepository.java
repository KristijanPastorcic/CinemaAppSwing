/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.repositories.sql;

import hr.kpastorcic11.roles.User;
import hr.kpastorcic11.factories.DataSourceFactory;
import hr.kpastorcic11.repositories.interfaces.AuthRepositry;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author islan
 */
public class MSqlAuthRepository implements AuthRepositry {

    private static final String LOGIN_NAME = "@loginName";
    private static final String PASSWORD = "@password";

    private static final String ID_USER = "IDUser";

    private static final String LOGIN = "{ CALL login (?,?) }";
    private static final String REGISTER = "{ CALL register (?,?) }";
    private static final String CLEAN = "{ CALL clean }";

    private static final String DIR = "assets";

    @Override
    public Optional<Integer> login(User user) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(LOGIN)) {

            stmt.setString(LOGIN_NAME, user.getLoginName());
            stmt.setString(PASSWORD, user.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(rs.getInt(ID_USER));
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    @Override
    public boolean register(User user) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(REGISTER)) {

            stmt.setString(LOGIN_NAME, user.getLoginName());
            stmt.setString(PASSWORD, user.getPassword());
            return stmt.executeUpdate() == 1;
        }
    }

    public static void cleanDB() throws SQLException, IOException {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(CLEAN)) {

            stmt.executeUpdate();
        }
        File file = new File(DIR);
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File content : contents) {
                content.delete();
            }
        }
        file.delete();
    }

}
