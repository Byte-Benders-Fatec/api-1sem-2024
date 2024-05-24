package pom.xml.gui;

import javax.swing.*;

import pom.xml.AppConfig;
import pom.xml.sql.SQLExecutor;
import pom.xml.sql.SQLGenerator;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class GUI extends JFrame {
    private JTextField questionField;
    private JTextField schemaField;
    private JButton getSQLButton;
    private JButton configButton;
    private JTextArea resultArea;
    private SQLExecutor sqlExecutor;
    private AppConfig appConfig;

    public GUI() {
        appConfig = new AppConfig();
        sqlExecutor = new SQLExecutor();
        
        setTitle("API-2SEM-2024");
        setSize(400,300);
        setResizable(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel questionLabel = new JLabel("Faça uma pergunta:");
        JLabel schemaLabel = new JLabel("Schema do banco de dados:");
        questionField = new JTextField();
        schemaField = new JTextField();
        schemaField.setPreferredSize(new Dimension(250, 40));
        schemaField.setText(appConfig.getDbSchema());
        schemaField.setEditable(false);
        
        getSQLButton = new JButton("Procurar");
        configButton = new JButton("Config");
        inputPanel.add(questionLabel);
        inputPanel.add(questionField);
        inputPanel.add(schemaLabel);
        inputPanel.add(schemaField);
        inputPanel.add(new JLabel());
        inputPanel.add(getSQLButton);
        inputPanel.add(configButton);

        JPanel resultPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("Resultado:");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        getSQLButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SQLGenerator sqlGenerator = new SQLGenerator(appConfig);
                    String sqlQuery = sqlGenerator.getSQL(questionField.getText());
                    
                    String resultSQLQuery = sqlExecutor.resultFromSqlQuery(sqlQuery);

                    resultArea.setText(resultSQLQuery);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        configButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIAppConfig NovaInstanciaConfig = new GUIAppConfig(appConfig);
                NovaInstanciaConfig.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }
}

