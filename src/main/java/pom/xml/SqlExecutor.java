package pom.xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlExecutor {

    public String resultFromSqlQuery(String sqlQuery) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
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

                String formattedColumnName = columnName.split("_")[1].toUpperCase();

                rowString += formattedColumnName + ": " + value.toString() + ", ";
            }

            resultSQLQuery += rowString + "\n";
            rowString = "";
        }

        stmt.close();

        if (resultSQLQuery.isBlank()) {
            resultSQLQuery = "Não encontramos resultados...";
        }

        return resultSQLQuery;
    }
    
}
