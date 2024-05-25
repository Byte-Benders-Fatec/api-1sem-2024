package pom.xml.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileReader {
    public String convertTextFileToString (String filePath) throws IOException {

        InputStream inputStream = new FileInputStream(filePath);
        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            StringBuilder stringBuffer = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuffer.append(scanner.nextLine()).append("\n");
            }
            scanner.close();  
            return stringBuffer.toString();
        } else {
            throw new IOException("Sample database question file not found.");
        }

    } 
}

