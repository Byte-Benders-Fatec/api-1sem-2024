package pom.xml.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import pom.xml.AppConfig;
import java.sql.Connection;

public class ConnectionFactory {
    private AppConfig appConfig = new AppConfig(); 

    public Connection getConnection() {
        String url = appConfig.getDatabaseURL();
        String username = appConfig.getDatabaseUsername();
        String password = appConfig.getDatabasePassword();
        
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
