package pom.xml.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import pom.xml.utils.AppConfig;
import pom.xml.db.ConnectionFactory;


public class SQLExecutor {

    private final AppConfig appConfig; 

    public SQLExecutor(AppConfig appConfig){
        this.appConfig = appConfig;
    }

    public String resultFromSqlQuery(String sqlQuery) throws SQLException {
        Connection connection = new ConnectionFactory(appConfig).getConnection();
        Statement stmt = connection.createStatement();     
        ResultSet resultSet = stmt.executeQuery(sqlQuery); 
        ResultSetMetaData metadata = resultSet.getMetaData();
        int numColumns = metadata.getColumnCount();
        String resultSQLQuery = "";

        while (resultSet.next()) {
            String rowString = "";
            for (int i = 1; i <= numColumns; i++) {
                String columnName = metadata.getColumnName(i);
                Object value = resultSet.getObject(i);
                
                //Verificar erro na lógica para implementar de forma adequada
                //String formattedColumnName = columnName.split("_")[1].toUpperCase();
                String formattedColumnName = columnName;
                
                if (value != null) {
                    if (i < numColumns) {
                        rowString += formattedColumnName + ": " + value.toString() + ", ";
                    } else {
                        rowString += formattedColumnName + ": " + value.toString();
                    }
                } else {
                    if (i < numColumns) {
                        rowString += formattedColumnName + ": " + "NULL" + ", ";
                    } else {
                        rowString += formattedColumnName + ": " + "NULL";
                    }
                }
            }

            resultSQLQuery += rowString + "\n";
            rowString = "";
        }

        stmt.close();

        if (resultSQLQuery.isEmpty()) {
            resultSQLQuery = "We found no results...";
        }

        return resultSQLQuery;
    }
    
}
