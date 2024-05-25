package pom.xml.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pom.xml.AppConfig;

public class ConnectionFactory {
    
    private final AppConfig appConfig; 

    public ConnectionFactory(AppConfig appConfig){
        this.appConfig = appConfig;
    }

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
