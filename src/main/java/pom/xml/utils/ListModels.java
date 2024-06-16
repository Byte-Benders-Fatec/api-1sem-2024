package pom.xml.utils;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.models.Model;
import pom.xml.AppConfig;

public class ListModels {

    // public static void main(String[] args) {
        
    //     AppConfig appConfig = new AppConfig();;
    //     List<String> listinha = getList(appConfig);
    //     for(String modelo : listinha) {
    //         System.out.println(modelo);
    //     }

    // }

    public static List<String> getList(Component parentComponent, AppConfig appConfig) {
        
        String host = appConfig.getOllamaUrl();
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        List<String> lista = new ArrayList<>();
        try {
            List<Model> models = ollamaAPI.listModels();
            models.forEach(model -> lista.add(removerVersionTag(model.getName())));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique a conexão com o servidor Ollama.", "Erro: Ollama Server", JOptionPane.ERROR_MESSAGE);

        }
        return lista;
    }

    private static String removerVersionTag(String fullname) {
        int index = fullname.indexOf(":");
        if (index != -1) {
            return fullname.substring(0, index);
        }
        return fullname; 
    }

}
