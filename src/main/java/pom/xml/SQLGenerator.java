package pom.xml;

import io.github.amithkoujalgi.ollama4j.core.utils.OptionsBuilder;

import java.io.InputStream;
import java.util.Scanner;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.models.OllamaResult;


public class SQLGenerator {
    private String sqlQuery;

        public String getSQL(String question, String databaseSchema) {
            String prompt;
            
            try {
                String host = "http://localhost:11434/";

                OllamaAPI ollamaAPI = new OllamaAPI(host);
                ollamaAPI.setRequestTimeoutSeconds(1000);

                prompt = databaseSchema.replace("<question>", question);

                if (databaseSchema.isBlank()) {
                    ClassLoader classLoader = OllamaAPI.class.getClassLoader();
                    InputStream inputStream = classLoader.getResourceAsStream("test_schema.txt");
                    if (inputStream != null) {
                        Scanner scanner = new Scanner(inputStream);
                        StringBuilder stringBuffer = new StringBuilder();
                        while (scanner.hasNextLine()) {
                            stringBuffer.append(scanner.nextLine()).append("\n");
                        }
                        scanner.close();
                        
                        prompt = stringBuffer.toString().replace("<question>", question);
                    } else {
                        throw new Exception("Sample database question file not found.");
                    }
                }
              
                OllamaResult result =
                        ollamaAPI.generate("api", prompt,
                         new OptionsBuilder()
                            .build()
                        );

                sqlQuery = result.getResponse();
                
            } catch (Exception e) {
                System.out.println(e);
            }

            return sqlQuery;

        }

}