package pom.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import pom.xml.utils.FileReader;

public class AppConfig {
    private static final Properties prop = new Properties();
    private static final String CONFIG_FILE = "src\\main\\resources\\app.config";

    static {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static String getDatabaseURL() {
        return "jdbc:" + getDatabaseType() + "://" + getDatabaseHost() + ":" + getDatabasePort() + "/" + getDatabaseName();
    }

    public static String getDatabaseType(){
        return prop.getProperty("DB.TYPE");
    }

    public static String getDatabaseHost(){
        return prop.getProperty("DB.HOST");
    }

    public static String getDatabasePort(){
        return prop.getProperty("DB.PORT");
    }

    public static String getDatabaseName(){
        return prop.getProperty("DB.NAME");
    }

    public static String getDatabaseUsername() {
        return prop.getProperty("DB.USERNAME");
    }

    public static String getDatabasePassword() {
        return prop.getProperty("DB.PASSWORD");
    }

    public static String getOllamaHost() {
        return prop.getProperty("OLLAMA.HOST");
    }
    
    public static String getOllamaPort() {
        return prop.getProperty("OLLAMA.PORT");
    }

    public static String getOllamaUrl() {
        return "http://" + getOllamaHost() + ":" + getOllamaPort(); 
    }

    public static String getDbSchemaFile() {
        return prop.getProperty("DB.SCHEMA"); 
    }

    public static String getDbSchema() {
        String dbSchema = "";
        try {
            dbSchema = FileReader.convertTextFileToString(getDbSchemaFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dbSchema;
    }
    
}

