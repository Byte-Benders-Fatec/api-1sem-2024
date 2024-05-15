package pom.xml.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import pom.xml.AppConfig;
import java.sql.Connection;

public class ConnectionFactory {

    public Connection getConnection() {
        String url = AppConfig.getDatabaseURL();
        String username = AppConfig.getDatabaseUsername();
        String password = AppConfig.getDatabasePassword();
        
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
