package pom.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import pom.xml.utils.FileReader;

public class AppConfig {
    private static final Properties prop = new Properties();
    private static final String CONFIG_FILE = "src\\main\\resources\\app.config";

    static {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void loadNewConfig(String configFilePath){
        
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            prop.load(fis);
            System.out.println("It's file...");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }

    public void setNewConfig(String configFilePath) {
        try {
            FileOutputStream fos = new FileOutputStream(configFilePath);
            prop.store(fos, null);
        } catch (Exception e) {
            System.out.println(e);
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

    public String getOllamaModel() {
        return prop.getProperty("OLLAMA.MODEL");
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
        System.out.println(prop.getProperty("DB.SCHEMA"));
        return prop.getProperty("DB.SCHEMA"); 
    }

    public String getDbSchema() {
        String dbSchema = "";
        try {
            FileReader fileReader = new FileReader();
            dbSchema = fileReader.convertTextFileToString(getDbSchemaFile());
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

    public void setOllamaModel(String newOllamaModel) {
        prop.setProperty("OLLAMA.MODEL", newOllamaModel);
    }

    public void setOllamaHost(String newOllamaHost) {
        prop.setProperty("OLLAMA.HOST", newOllamaHost);
    }
    
    public void setOllamaPort(String newOllamaPort) {
        prop.setProperty("OLLAMA.PORT", newOllamaPort);
    }

    public void setDbSchemaFile(String newDbSchemaFile) {
        prop.setProperty("DB.SCHEMA", newDbSchemaFile); 
    }
    
}

