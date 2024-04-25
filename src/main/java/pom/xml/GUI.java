package pom.xml;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GUI extends JFrame {
    private JTextField questionField;
    private JTextArea schemaField;
    private JButton getSQLButton;
    private JTextArea resultArea;

    public GUI() {
        setTitle("SQL Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel questionLabel = new JLabel("Ask a question:");
        JLabel schemaLabel = new JLabel("Database Schema:");
        questionField = new JTextField();
        schemaField = new JTextArea();
        schemaField.setPreferredSize(new Dimension(250, 40));
        getSQLButton = new JButton("Get SQL");
        inputPanel.add(questionLabel);
        inputPanel.add(questionField);
        inputPanel.add(schemaLabel);
        inputPanel.add(schemaField);
        inputPanel.add(new JLabel());
        inputPanel.add(getSQLButton);

        JPanel resultPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("Result:");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        getSQLButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String resultSQLQuery = "";
                try {
                    SQLGenerator sqlGenerator = new SQLGenerator();
                    String sqlQuery = sqlGenerator.getSQL(questionField.getText(), schemaField.getText());
                    
                    Connection connection = new ConnectionFactory().getConnection();

                    Statement stmt = connection.createStatement();     
                    ResultSet resultSet = stmt.executeQuery(sqlQuery); 
                    ResultSetMetaData metadata = resultSet.getMetaData();
                    int numColumns = metadata.getColumnCount();

                    while (resultSet.next()) { 
                        for (int i = 1; i <= numColumns; i++) {
                            String columnName = metadata.getColumnName(i);
                            String sqlType = metadata.getColumnTypeName(i);
                            Object value = resultSet.getObject(i);

                            // System.out.println(columnName);
                            // System.out.println(sqlType);
                            // System.out.println(value);

                            resultSQLQuery += columnName + ": " + value.toString() + "\n";

                            // int id = resultSet.getInt("aluno_id"); 
                            // String client_name = resultSet.getString("aluno_nome"); 

                            // resultSQLQuery += "ID: " + id + ", Cliente Nome: " + client_name + "\n";
                        }
                    }

                    stmt.close();

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

