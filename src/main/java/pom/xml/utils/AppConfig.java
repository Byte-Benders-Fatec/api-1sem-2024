package pom.xml.utils;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import pom.xml.utils.FileReader;

public class AppConfig {

    private final Properties prop;
    private String filePath;
    private String configFilePath;
    
    public AppConfig(Component componentParent) {
        prop = new Properties();
        char sep = File.separatorChar;
        filePath = "src" + sep + "main" + sep + "resources" + sep;
        configFilePath = filePath + "app.config";
        this.loadConfig(componentParent, configFilePath);
    }

    public void loadConfig(Component componentParent, String configFilePath){
        
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            prop.load(fis);
            this.setConfigFilePath(configFilePath);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(componentParent, "File not found!");
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

    public String getConfigFilePath() {
        return configFilePath;
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
        return prop.getProperty("DB.SCHEMA"); 
    }
    
    public String getDbSchema() {
        String dbSchema = "";
        try {
            FileReader fileReader = new FileReader();

            char sep = File.separatorChar;
            if(getDbSchemaFile().indexOf(sep) != -1){
                dbSchema = fileReader.convertTextFileToString(getDbSchemaFile());
            }
            else{
                dbSchema = fileReader.convertTextFileToString(filePath + getDbSchemaFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dbSchema;
    }
    
    public String getTemplateFile() {
        return prop.getProperty("OLLAMA.TEMPLATE"); 
    }
    
    public String getTemplate() {
        String template = "";
        try {
            FileReader fileReader = new FileReader();

            char sep = File.separatorChar;
            if(getTemplateFile().indexOf(sep) != -1){
                template = fileReader.convertTextFileToString(getTemplateFile());
            }
            else{
                template = fileReader.convertTextFileToString(filePath + getTemplateFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template;
    }
    
    public void setConfigFilePath(String configFilePath){
        this.configFilePath = configFilePath;
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
    
    public void setTemplateFile(String newTemplateFile) {
        prop.setProperty("OLLAMA.TEMPLATE", newTemplateFile); 
    }
    
}

