package pom.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import pom.xml.utils.FileReader;

public class AppConfig {
    private static final Properties prop = new Properties();
    private static final String CONFIG_FILE = "src/main/resources/app.config";

    static {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void setNewConfig() {
        try {
            FileOutputStream fos = new FileOutputStream(CONFIG_FILE);

            prop.store(fos, null);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    public String getDatabaseURL() {
        return "jdbc:" + getDatabaseType() + "://" + getDatabaseHost() + ":" + getDatabasePort() + "/" + getDatabaseName();
    }

    public String getDatabaseType(){
        return prop.getProperty("DB.TYPE");
    }

    public String getDatabaseHost(){
        return prop.getProperty("DB.HOST");
    }

    public String getDatabasePort(){
        return prop.getProperty("DB.PORT");
    }

    public String getDatabaseName(){
        return prop.getProperty("DB.NAME");
    }

    public String getDatabaseUsername() {
        return prop.getProperty("DB.USERNAME");
    }

    public String getDatabasePassword() {
        return prop.getProperty("DB.PASSWORD");
    }

    public String getOllamaHost() {
        return prop.getProperty("OLLAMA.HOST");
    }
    
    public String getOllamaPort() {
        return prop.getProperty("OLLAMA.PORT");
    }

    public String getOllamaUrl() {
        return "http://" + getOllamaHost() + ":" + getOllamaPort(); 
    }

    public String getDbSchemaFile() {
        return prop.getProperty("DB.SCHEMA"); 
    }

    public String getDbSchema() {
        String dbSchema = "";
        try {
            dbSchema = FileReader.convertTextFileToString(getDbSchemaFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dbSchema;
    }

    public void setDatabaseType(String newDatabaseType){
        prop.setProperty("DB.TYPE", newDatabaseType);
    }

    public void setDatabaseHost(String newDatabaseHost){
        prop.setProperty("DB.HOST", newDatabaseHost);
    }

    public void setDatabasePort(String newDatabasePort){
        prop.setProperty("DB.PORT", newDatabasePort);
    }

    public void setDatabaseName(String newDatabaseName){
        prop.setProperty("DB.NAME", newDatabaseName);
    }

    public void setDatabaseUsername(String newDatabaseUsername){
        prop.setProperty("DB.USERNAME", newDatabaseUsername);
    }

    public void setDatabasePassword(String newDatabasePassword) {
        prop.setProperty("DB.PASSWORD", newDatabasePassword);
    }

    public void setOllamaHost(String newOllamaHost) {
        prop.setProperty("OLLAMA.HOST", newOllamaHost);
    }
    
    public void setOllamaPort(String newOllamaPort) {
        prop.setProperty("OLLAMA.PORT", newOllamaPort);
    }
    
}

