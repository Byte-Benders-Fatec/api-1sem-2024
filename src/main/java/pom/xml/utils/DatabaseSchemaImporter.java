package pom.xml.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseSchemaImporter {
    
    public static void importSchema(AppConfig appConfig) {
        try (Connection connection = DriverManager.getConnection(appConfig.getDatabaseURL(), appConfig.getDatabaseUsername(), appConfig.getDatabasePassword())) {
            DatabaseMetaData metaData = connection.getMetaData();
            String databaseName = connection.getCatalog();

            StringBuilder scriptBuilder = new StringBuilder();

            // Obtendo tabelas
            ResultSet tablesResultSet = metaData.getTables(databaseName, null, "%", new String[]{"TABLE"});
            while (tablesResultSet.next()) {
                String tableName = tablesResultSet.getString("TABLE_NAME");

                // Adicionando CREATE TABLE statement ao script
                scriptBuilder.append("CREATE TABLE ").append(tableName).append(" (\n");

                // Obtendo colunas
                ResultSet columnsResultSet = metaData.getColumns(databaseName, null, tableName, null);
                while (columnsResultSet.next()) {
                    String columnName = columnsResultSet.getString("COLUMN_NAME");
                    String columnType = columnsResultSet.getString("TYPE_NAME");
                    int columnSize = columnsResultSet.getInt("COLUMN_SIZE");
                    String nullable = columnsResultSet.getString("IS_NULLABLE");

                    scriptBuilder.append("\t").append(columnName).append(" ").append(columnType);
                    if (columnSize > 0) {
                        scriptBuilder.append("(").append(columnSize).append(")");
                    }
                    if (nullable.equals("NO")) {
                        scriptBuilder.append(" NOT NULL");
                    }
                    scriptBuilder.append(",\n");
                }

                // Adicionando PRIMARY KEY constraint
                ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(databaseName, null, tableName);
                while (primaryKeyResultSet.next()) {
                    String primaryKeyColumn = primaryKeyResultSet.getString("COLUMN_NAME");
                    scriptBuilder.append("\tPRIMARY KEY (").append(primaryKeyColumn).append("),\n");
                }

                // Adicionando FOREIGN KEY constraints
                ResultSet foreignKeysResultSet = metaData.getImportedKeys(databaseName, null, tableName);
                while (foreignKeysResultSet.next()) {
                    String fkColumnName = foreignKeysResultSet.getString("FKCOLUMN_NAME");
                    String pkTableName = foreignKeysResultSet.getString("PKTABLE_NAME");
                    String pkColumnName = foreignKeysResultSet.getString("PKCOLUMN_NAME");
                    scriptBuilder.append("\tFOREIGN KEY (").append(fkColumnName).append(") REFERENCES ").append(pkTableName).append("(").append(pkColumnName).append("),\n");
                }

                scriptBuilder.append(");\n\n");
            }

            // Gravando o script em um arquivo
            try (FileWriter writer = new FileWriter(appConfig.getDbSchemaFile())) {
                writer.write(scriptBuilder.toString());
            }

            System.out.println("Script de esquema gerado com sucesso.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    
}
