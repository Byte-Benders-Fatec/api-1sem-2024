package pom.xml;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class GUI extends JFrame {
    private JTextField questionField;
    private JTextField schemaField;
    private JButton getSQLButton;
    private JTextArea resultArea;
    private SQLExecutor sqlExecutor;

    public GUI() {
        sqlExecutor = new SQLExecutor();
        
        setTitle("API-2SEM-2024");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel questionLabel = new JLabel("Faça uma pergunta:");
        JLabel schemaLabel = new JLabel("Schema do banco de dados:");
        questionField = new JTextField();
        schemaField = new JTextField();
        schemaField.setPreferredSize(new Dimension(250, 40));
        schemaField.setText(AppConfig.getDbSchema());
        schemaField.setEditable(false);
        
        getSQLButton = new JButton("Procurar");
        inputPanel.add(questionLabel);
        inputPanel.add(questionField);
        inputPanel.add(schemaLabel);
        inputPanel.add(schemaField);
        inputPanel.add(new JLabel());
        inputPanel.add(getSQLButton);

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
                    SQLGenerator sqlGenerator = new SQLGenerator();
                    String sqlQuery = sqlGenerator.getSQL(questionField.getText(), schemaField.getText());
                    
                    String resultSQLQuery = sqlExecutor.resultFromSqlQuery(sqlQuery);

                    resultArea.setText(resultSQLQuery);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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

