/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastor11.factories;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

/**
 *
 * @author islan
 */
public class DataSourceFactory {

    // TODO: read constants from config.txt
    private static final String SERVER = "localhost";
    private static final String DATABASE = "CinemaAppDB";
    private static final String USER = "sa";
    private static final String PASSWORD = "SQL";

    private DataSourceFactory(){}

    private static DataSource instance;

    public static DataSource getLocalHostDataSource() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }

    private static DataSource createInstance() {
        SQLServerDataSource sqlServerDataSource = new SQLServerDataSource();
        sqlServerDataSource.setServerName(SERVER);
        sqlServerDataSource.setDatabaseName(DATABASE);
        sqlServerDataSource.setUser(USER);
        sqlServerDataSource.setPassword(PASSWORD);
        return sqlServerDataSource;
    }
}
