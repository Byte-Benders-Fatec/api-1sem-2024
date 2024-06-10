package pom.xml.gui;

import pom.xml.AppConfig;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUIAppConfig extends javax.swing.JFrame {
    
    private AppConfig appConfig;
    private final char sep = File.separatorChar;
    private final String schemaPathComplement = "src" + sep + "main" + sep + "resources" + sep;
    private final String appLocalPath = System.getProperty("user.dir") + sep + schemaPathComplement;
    private GUI gui;
    
    public GUIAppConfig(GUI gui, AppConfig appConfig) {
        
        initComponents();
        
        this.gui = gui;
        
        setTitle("API-2SEM-2024");
        setSize(520,600);
        setResizable(false);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.appConfig = appConfig;
        if(appConfig.getDatabaseType() != null){
            jTxtConfigDB.setText(appConfig.getConfigFilePath());
            jTxtType.setText(appConfig.getDatabaseType());
            jTxtHost.setText(appConfig.getDatabaseHost());
            jTxtPort.setText(appConfig.getDatabasePort());
            jTxtName.setText(appConfig.getDatabaseName());
            jTxtUserName.setText(appConfig.getDatabaseUsername());
            jPasswordField1.setText(appConfig.getDatabasePassword());
            jPasswordField2.setText(appConfig.getDatabasePassword());

            if(appConfig.getDbSchemaFile().indexOf(sep) == -1){
                appConfig.setDbSchemaFile(schemaPathComplement + appConfig.getDbSchemaFile());
            }

            jTxtSchema.setText(appConfig.getDbSchemaFile());      
            jTxtModelLLM.setText(appConfig.getOllamaModel());
            jTxtHostLLM.setText(appConfig.getOllamaHost());
            jTxtPortLLM.setText(appConfig.getOllamaPort());
        }        
    
    }

    public GUIAppConfig() {
        
        initComponents();
        
        setTitle("API-2SEM-2024");
        setSize(520,600);
        setResizable(false);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jTxtConfigDB.setText("");
        jTxtType.setText("");
        jTxtHost.setText("");
        jTxtPort.setText("");
        jTxtName.setText("");
        jTxtUserName.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        jTxtSchema.setText("");
        jTxtModelLLM.setText("");
        jTxtHostLLM.setText("");
        jTxtPortLLM.setText("");
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonLoad = new javax.swing.JButton();
        jTxtConfigDB = new javax.swing.JTextField();
        jLblConfigDB = new javax.swing.JLabel();
        jButtonApply = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLblType = new javax.swing.JLabel();
        jTxtType = new javax.swing.JTextField();
        jLblHost = new javax.swing.JLabel();
        jTxtHost = new javax.swing.JTextField();
        jLblPort = new javax.swing.JLabel();
        jTxtPort = new javax.swing.JTextField();
        jLblName = new javax.swing.JLabel();
        jTxtName = new javax.swing.JTextField();
        jLblUserName = new javax.swing.JLabel();
        jTxtUserName = new javax.swing.JTextField();
        jLblPassword1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLblPassword2 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLblSchema = new javax.swing.JLabel();
        jTxtSchema = new javax.swing.JTextField();
        jButtonFind = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLblHostLLM = new javax.swing.JLabel();
        jTxtHostLLM = new javax.swing.JTextField();
        jLblModelLLM = new javax.swing.JLabel();
        jTxtModelLLM = new javax.swing.JTextField();
        jLblPortLLM = new javax.swing.JLabel();
        jTxtPortLLM = new javax.swing.JTextField();

        jTextField4.setText("jTextField1");

        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Application Settings", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setToolTipText("");

        jButtonLoad.setText("Load");
        jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadActionPerformed(evt);
            }
        });

        jTxtConfigDB.setEditable(false);

        jLblConfigDB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblConfigDB.setText("Config. File:");

        jButtonApply.setText("Apply");
        jButtonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApplyActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database Settings", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLblType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblType.setText("Type:");

        jLblHost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblHost.setText("Host:");

        jLblPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblPort.setText("Port:");

        jLblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblName.setText("Name:");

        jLblUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblUserName.setText("User Name:");

        jLblPassword1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblPassword1.setText("Password:");

        jLblPassword2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblPassword2.setText("Confirm Password:");

        jLblSchema.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblSchema.setText("Schema:");

        jTxtSchema.setEditable(false);

        jButtonFind.setText("Find");
        jButtonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLblPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblPassword2))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLblPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLblSchema, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtType, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTxtSchema, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFind, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblType)
                    .addComponent(jTxtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblHost)
                    .addComponent(jTxtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPort)
                    .addComponent(jTxtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblName)
                            .addComponent(jTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblUserName)
                            .addComponent(jTxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLblPassword1)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLblPassword2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtSchema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblSchema)
                    .addComponent(jButtonFind))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LLM Settings", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLblHostLLM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblHostLLM.setText("Host:");

        jLblModelLLM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblModelLLM.setText("Model:");

        jLblPortLLM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLblPortLLM.setText("Port:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLblModelLLM, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLblPortLLM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLblHostLLM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtModelLLM, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPortLLM, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtHostLLM, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblModelLLM)
                    .addComponent(jTxtModelLLM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblHostLLM)
                    .addComponent(jTxtHostLLM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPortLLM)
                    .addComponent(jTxtPortLLM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLblConfigDB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtConfigDB, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLoad))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSave)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonExit)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtConfigDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblConfigDB)
                    .addComponent(jButtonLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonApply)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindActionPerformed
    
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(appLocalPath));
        try{
            int resp = fc.showOpenDialog(null);
            if(resp == JFileChooser.APPROVE_OPTION){                
                File file = fc.getSelectedFile();
                jTxtSchema.setText(file.getAbsolutePath());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_jButtonFindActionPerformed

    private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(appLocalPath));
        try{
            int resp = fc.showOpenDialog(null);
            if(resp == JFileChooser.APPROVE_OPTION){
                
                File file = fc.getSelectedFile();
                
                appConfig.loadConfig(file.getCanonicalPath());
                jTxtConfigDB.setText(appConfig.getConfigFilePath());
                jTxtType.setText(appConfig.getDatabaseType());
                jTxtHost.setText(appConfig.getDatabaseHost());
                jTxtPort.setText(appConfig.getDatabasePort());
                jTxtName.setText(appConfig.getDatabaseName());
                jTxtUserName.setText(appConfig.getDatabaseUsername());
                jPasswordField1.setText(appConfig.getDatabasePassword());
                jPasswordField2.setText(appConfig.getDatabasePassword());
                
                if(appConfig.getDbSchemaFile().indexOf(sep) == -1){
                    appConfig.setDbSchemaFile(schemaPathComplement + appConfig.getDbSchemaFile());
                }

                jTxtSchema.setText(appConfig.getDbSchemaFile());
                jTxtModelLLM.setText(appConfig.getOllamaModel());
                jTxtHostLLM.setText(appConfig.getOllamaHost());
                jTxtPortLLM.setText(appConfig.getOllamaPort());
                
                gui.setSchemaField();
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButtonLoadActionPerformed

    private void jButtonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApplyActionPerformed

        boolean resp = applyConfiguration(true);
        
    }//GEN-LAST:event_jButtonApplyActionPerformed
    
    private boolean applyConfiguration(boolean successNotice){
        
        int vazios = 0;
        if(jTxtConfigDB.getText().isEmpty()){
            vazios++;
        }
        if(jTxtType.getText().isEmpty()){
            vazios++;
        }
        if(jTxtHost.getText().isEmpty()){
            vazios++;
        }
        if(jTxtPort.getText().isEmpty()){
            vazios++;
        }
        if(jTxtName.getText().isEmpty()){
            vazios++;
        }
        if(jTxtUserName.getText().isEmpty()){
            vazios++;
        }
        if(jPasswordField1.getPassword().length == 0){
            vazios++;
        }
        if(jPasswordField2.getPassword().length == 0){
            vazios++;
        }
        if(jTxtSchema.getText().isEmpty()){
            vazios++;
        }
        if(jTxtModelLLM.getText().isEmpty()){
            vazios++;
        }
        if(jTxtHostLLM.getText().isEmpty()){
            vazios++;
        }
        if(jTxtPortLLM.getText().isEmpty()){
            vazios++;
        }

        if(vazios > 0){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return false;
        }
        else{
            if(Arrays.equals(jPasswordField1.getPassword(), jPasswordField2.getPassword())){
                
                appConfig.setDatabaseType(jTxtType.getText());
                appConfig.setDatabaseHost(jTxtHost.getText());
                appConfig.setDatabasePort(jTxtPort.getText());
                appConfig.setDatabaseName(jTxtName.getText());
                appConfig.setDatabaseUsername(jTxtUserName.getText());
                appConfig.setDatabasePassword(new String(jPasswordField1.getPassword()));
                
                int index = jTxtSchema.getText().indexOf(schemaPathComplement);
                if(index != -1){
                    appConfig.setDbSchemaFile(jTxtSchema.getText().substring(index));
                }
                else{
                    appConfig.setDbSchemaFile(jTxtSchema.getText());
                }

                appConfig.setOllamaModel(jTxtModelLLM.getText());
                appConfig.setOllamaHost(jTxtHostLLM.getText());
                appConfig.setOllamaPort(jTxtPortLLM.getText());          
                if(successNotice){
                    JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
                }
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Atenção: senhas diferentes!");
                return false;
            }
        }
    
    }
    
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
        boolean resp = applyConfiguration(false);
        
        if(resp){
        
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(appLocalPath));
            try{
                int resp2 = fc.showSaveDialog(null);
                if(resp2 == JFileChooser.APPROVE_OPTION){

                    File file = fc.getSelectedFile();
                    appConfig.setNewConfig(file.getCanonicalPath());
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
               
        }
        
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        
        this.dispose();

    }//GEN-LAST:event_jButtonExitActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIAppConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAppConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAppConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAppConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAppConfig().setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApply;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JButton jButtonLoad;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLblConfigDB;
    private javax.swing.JLabel jLblHost;
    private javax.swing.JLabel jLblHostLLM;
    private javax.swing.JLabel jLblModelLLM;
    private javax.swing.JLabel jLblName;
    private javax.swing.JLabel jLblPassword1;
    private javax.swing.JLabel jLblPassword2;
    private javax.swing.JLabel jLblPort;
    private javax.swing.JLabel jLblPortLLM;
    private javax.swing.JLabel jLblSchema;
    private javax.swing.JLabel jLblType;
    private javax.swing.JLabel jLblUserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTxtConfigDB;
    private javax.swing.JTextField jTxtHost;
    private javax.swing.JTextField jTxtHostLLM;
    private javax.swing.JTextField jTxtModelLLM;
    private javax.swing.JTextField jTxtName;
    private javax.swing.JTextField jTxtPort;
    private javax.swing.JTextField jTxtPortLLM;
    private javax.swing.JTextField jTxtSchema;
    private javax.swing.JTextField jTxtType;
    private javax.swing.JTextField jTxtUserName;
    // End of variables declaration//GEN-END:variables
}
