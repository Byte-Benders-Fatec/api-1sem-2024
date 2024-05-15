package pom.xml.utils;

public class availableDb {
    private static String availableDb[] = {"mysql", "postgresql", "mongodb", "sqlserver", "oracle"};

    public static String[] getAvailableDb() {
        return availableDb;
    }

}
