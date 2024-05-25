package pom.xml.db;

import java.sql.Connection;
import java.sql.SQLException;

import pom.xml.AppConfig;

public class ConnectionTest {
    
    private final AppConfig appConfig; 

    public ConnectionTest(AppConfig appConfig){
        this.appConfig = appConfig;
    }

    public void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory(appConfig).getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }

}
