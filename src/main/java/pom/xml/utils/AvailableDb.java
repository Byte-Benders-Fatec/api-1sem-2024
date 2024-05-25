package pom.xml.utils;

public class AvailableDb {
    private static String[] dbTypes = {"mysql", "postgresql", "mongodb", "sqlserver", "oracle"};

    public static String[] getAvailableDb() {
        return dbTypes;
    }

}
