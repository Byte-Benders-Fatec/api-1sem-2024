package pom.xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaSQLQuery {

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();

        String sqlQuery = "SELECT * from cliente";
        Statement stmt = connection.createStatement();
        
        ResultSet resultSet = stmt.executeQuery(sqlQuery); 

        while (resultSet.next()) { 
            int id = resultSet.getInt("cli_id"); 
            String client_name = resultSet.getString("cli_nome"); 

            System.out.println("ID: " + id + ", Cliente Nome: " + client_name); 
        } 

        stmt.close();
    }
    
}
