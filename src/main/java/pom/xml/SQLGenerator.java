package pom.xml;

import pom.xml.utils.*;
import io.github.amithkoujalgi.ollama4j.core.utils.OptionsBuilder;
import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.models.OllamaResult;


public class SqlGenerator {
    public String getSQL(String question, String databaseSchema) {
        String sqlQuery = "";
        String ollamaUrl= AppConfig.getOllamaUrl();
        
        try {
            OllamaAPI ollamaAPI = new OllamaAPI(ollamaUrl);
            ollamaAPI.setRequestTimeoutSeconds(1000);

            String prompt = databaseSchema.replace("<question>", question);
            
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