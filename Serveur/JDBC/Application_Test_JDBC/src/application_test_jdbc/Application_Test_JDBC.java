/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_test_jdbc;

import database.utilities.Bean_DB_Access;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Philippe
 */
public class Application_Test_JDBC extends javax.swing.JFrame {
    Bean_DB_Access BeanAccess = null;
    /**
     * Creates new form GUI
     */
    public Application_Test_JDBC() 
    {
        setLocationRelativeTo(null);
        initComponents();        
        setEnabledQuery(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonConnectOracle = new javax.swing.JButton();
        jButtonConnectMySQL = new javax.swing.JButton();
        jComboBoxRequete = new javax.swing.JComboBox<>();
        jTF_Sel_Upd = new javax.swing.JTextField();
        jL_From_Set = new javax.swing.JLabel();
        jTF_From_Set = new javax.swing.JTextField();
        jL_Where = new javax.swing.JLabel();
        jTF_Where = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTA_Error = new javax.swing.JTextArea();
        jButtonSend = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButtonConnectOracle.setText("Connexion à Oracle");
        jButtonConnectOracle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectOracleActionPerformed(evt);
            }
        });

        jButtonConnectMySQL.setText("Connexion à MySQL");
        jButtonConnectMySQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectMySQLActionPerformed(evt);
            }
        });

        jComboBoxRequete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "UPDATE" }));
        jComboBoxRequete.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRequeteItemStateChanged(evt);
            }
        });

        jL_From_Set.setText("FROM");

        jL_Where.setText("WHERE");

        jTA_Error.setColumns(20);
        jTA_Error.setRows(5);
        jTA_Error.setEnabled(false);
        jScrollPane2.setViewportView(jTA_Error);

        jButtonSend.setText("Envoyer la requête");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonClear.setText("Effacer");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jLabel1.setText("Erreur(s) :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(jButtonConnectOracle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConnectMySQL))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jL_From_Set)
                            .addComponent(jComboBoxRequete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jL_Where))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF_Sel_Upd)
                            .addComponent(jTF_From_Set)
                            .addComponent(jTF_Where)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConnectOracle)
                    .addComponent(jButtonConnectMySQL)
                    .addComponent(jButtonSend)
                    .addComponent(jButtonClear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRequete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Sel_Upd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_From_Set)
                    .addComponent(jTF_From_Set, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Where)
                    .addComponent(jTF_Where, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setEnabledQuery(boolean b)
    {
        jComboBoxRequete.setEnabled(b);
        jTF_Sel_Upd.setEnabled(b);
        jL_From_Set.setEnabled(b);
        jTF_From_Set.setEnabled(b);
        jL_Where.setEnabled(b);
        jTF_Where.setEnabled(b);
        jButtonClearActionPerformed(null);
    }
    
    private void jButtonConnectOracleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectOracleActionPerformed
        BeanAccess = new Bean_DB_Access(Bean_DB_Access.DRIVER_ORACLE, "localhost", "1521", "BD_JournalDeBord", "Soleil123", "orcl");
        
        if (jButtonConnectOracle.getText().equals("Connexion à Oracle")) 
        {            
            String Error = BeanAccess.Connexion();
            if (Error != null) 
            {
                jTA_Error.setEnabled(true);
                jTA_Error.setText(Error);
            }
            else 
            {
                jButtonConnectOracle.setEnabled(false);
                jButtonConnectMySQL.setText("Déconnexion");
                setEnabledQuery(true);
            }
        }
        else 
        {
            String Error = BeanAccess.Deconnexion();            
            if (Error != null) 
            {
                jTA_Error.setEnabled(true);
                jTA_Error.setText(Error);
            }
            else 
            {
                jButtonConnectMySQL.setEnabled(true);
                jButtonConnectOracle.setText("Connexion à Oracle");
                setEnabledQuery(false);
            }
        }
    }//GEN-LAST:event_jButtonConnectOracleActionPerformed

    private void jButtonConnectMySQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectMySQLActionPerformed
        BeanAccess = new Bean_DB_Access(Bean_DB_Access.DRIVER_MYSQL, "localhost", "3306", "Zeydax", "1234", "bd_airport");
        
        if (jButtonConnectMySQL.getText().equals("Connexion à MySQL")) 
        {
            
            String Error = BeanAccess.Connexion();
            if (Error != null) {
                jTA_Error.setEnabled(true);
                jTA_Error.setText(Error);
            }
            else
            {
                jButtonConnectOracle.setEnabled(false);
                jButtonConnectMySQL.setText("Déconnexion");
                setEnabledQuery(true);
            }
        }
        else 
        {
            String Error = BeanAccess.Deconnexion();
            if (Error != null) 
            {
                jTA_Error.setEnabled(true);
                jTA_Error.setText(Error);
            }
            else 
            {
                jButtonConnectOracle.setEnabled(true);
                jButtonConnectMySQL.setText("Connexion à MySQL");
                setEnabledQuery(false);
            }
        }
    }//GEN-LAST:event_jButtonConnectMySQLActionPerformed
    
    private void jComboBoxRequeteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRequeteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) 
        {
            if(evt.getItem().toString().equals("SELECT"))
                jL_From_Set.setText("FROM");
            else 
                jL_From_Set.setText("SET");
        }
    }//GEN-LAST:event_jComboBoxRequeteItemStateChanged

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        ResultSet RS;
        String From = null, Set = null;
        
        if(jTF_Sel_Upd.getText().equals("") && jTF_From_Set.getText().equals(""))
        {
            jTA_Error.setEnabled(true);
            jTA_Error.setText("La requête donnée est incorrecte !");
        }
        else
        {                                    
            jTA_Error.setText("");
            jTA_Error.setEnabled(false);
            
            try 
            {
                if(jComboBoxRequete.getSelectedItem().equals("SELECT")) 
                {        
                    if (jTF_From_Set.getText().toUpperCase().equals("DUAL"))
                        From = jTF_From_Set.getText();
                    else if (!jButtonConnectMySQL.isEnabled())
                    {
                        String[] Tokens;

                        Tokens = jTF_From_Set.getText().toLowerCase().split(" and ");
                        for (int i = 0 ; i < Tokens.length; i++) {
                            if (From != null)
                                From = From + BeanAccess.getSchema() + "." + Tokens[i];
                            else
                                From = BeanAccess.getSchema() + "." + Tokens[i];
                        }
                    }
                    else
                        From = jTF_From_Set.getText();                

                    if (jTF_Where.getText().equals("")) 
                    {
                        RS = BeanAccess.Select((jComboBoxRequete.getSelectedItem().toString() + " " + jTF_Sel_Upd.getText() + " from " + From).toLowerCase());
                        System.out.println((jComboBoxRequete.getSelectedItem().toString() + " " + jTF_Sel_Upd.getText() + " from " + From).toLowerCase());
                    }
                    else 
                    {
                        RS = BeanAccess.Select((jComboBoxRequete.getSelectedItem().toString() + " " + jTF_Sel_Upd.getText() + " from " + From + " where " + jTF_Where.getText()).toLowerCase());
                        System.out.println((jComboBoxRequete.getSelectedItem().toString() + " " + jTF_Sel_Upd.getText() + " from " + From + " where " + jTF_Where.getText()).toLowerCase());
                    }

                    if (RS != null)
                        AfficherResultSet(RS);
                    else 
                    {
                        jTA_Error.setEnabled(true);
                        jTA_Error.setText("Aucun résultat à afficher !");
                    }
                }
                else 
                {     
                    int Ok;
                    if (jTF_Where.getText().equals("")) 
                    {                    
                        Ok = BeanAccess.Update((jComboBoxRequete.getSelectedItem().toString() + " " + BeanAccess.getSchema() + "." + jTF_Sel_Upd.getText() + " set " + jTF_From_Set.getText()).toLowerCase());
                        System.out.println((jComboBoxRequete.getSelectedItem().toString() + " " + BeanAccess.getSchema() + "." + jTF_Sel_Upd.getText() + " set " + jTF_From_Set.getText()).toLowerCase());
                    }
                    else 
                    {
                        Ok = BeanAccess.Update((jComboBoxRequete.getSelectedItem().toString() + " " + BeanAccess.getSchema() + "." + jTF_Sel_Upd.getText() + " set " + jTF_From_Set.getText() + " where " + jTF_Where.getText()).toLowerCase());
                        System.out.println((jComboBoxRequete.getSelectedItem().toString() + " " + BeanAccess.getSchema() + "." + jTF_Sel_Upd.getText() + " set " + jTF_From_Set.getText() + " where " + jTF_Where.getText()).toLowerCase());
                    }

                    if (Ok == 1)
                        System.out.println("Mise à jour réussie !");
                    else 
                    {                   
                        jTA_Error.setEnabled(true);
                        jTA_Error.setText("Erreur lors de la mise à jour !"); 
                    }
                }                                 
            } 
            catch (SQLException ex) 
            {
                jTA_Error.setEnabled(true);
                jTA_Error.setText(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTF_Sel_Upd.setText("");                                   
        jTF_From_Set.setText("");                                   
        jTF_Where.setText("");                               
        jTA_Error.setText("");
        jTA_Error.setEnabled(false);
        jTable1.setModel(new DefaultTableModel());
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (BeanAccess.isConnected())
        {
            String Error = BeanAccess.Deconnexion();
            if (Error != null) 
            {
                jTA_Error.setEnabled(true);
                jTA_Error.setText(Error);
            }
        }    
    }//GEN-LAST:event_formWindowClosing
    
    private void AfficherResultSet(ResultSet RS) throws SQLException 
    {        
        try 
        {
            int Cpt = 0, nCol, MaxColonnes = RS.getMetaData().getColumnCount();
            String[] NomColonnes = new String [MaxColonnes];        
            String[] TypeColonnes = new String [MaxColonnes];
            
            if (RS.next()) 
            {                
                for (nCol = 1 ; nCol <= MaxColonnes ; nCol++) 
                {
                    NomColonnes[nCol - 1] = RS.getMetaData().getColumnName(nCol);
                    TypeColonnes[nCol - 1] = RS.getMetaData().getColumnTypeName(nCol);
                }
                
                DefaultTableModel dtm = new DefaultTableModel(NomColonnes, 0);
                
                RS.beforeFirst();
                nCol = 1;
                while(RS.next()) 
                {
                    nCol = 1;
                    String[] ligne = new String[MaxColonnes];
                    
                    while (nCol <= MaxColonnes) 
                    {
                        switch (TypeColonnes[nCol - 1]) 
                        {
                            case "BIT":
                            case "TINYINT":
                                ligne[nCol - 1] = String.valueOf(RS.getBoolean(nCol));
                                break;
                            case "LONG":
                            case "BIGINT":
                                ligne[nCol - 1] = String.valueOf(RS.getLong(nCol));
                                break;
                            case "NUMBER":
                            case "INT": 
                            case "SMALLINT":
                            case "MEDIUMINT":
                                ligne[nCol - 1] = String.valueOf(RS.getInt(nCol));
                                break;
                            case "FLOAT":
                                ligne[nCol - 1] = String.valueOf(RS.getFloat(nCol));
                                break;
                            case "DOUBLE":
                                ligne[nCol - 1] = String.valueOf(RS.getDouble(nCol));
                                break;
                            case "VARCHAR":
                            case "VARCHAR2":
                            case "CHAR":
                            case "TEXT":
                            case "LONGTEXT":
                            case "MEDIUMTEXT":
                            case "TIXYTEXT":
                                ligne[nCol - 1] = String.valueOf(RS.getString(nCol));
                                break;
                            case "DATE":
                                ligne[nCol - 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.FRANCE).format(RS.getDate(nCol));
                                break;
                            case "TIMESTAMP":                                
                                ligne[nCol - 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.FRANCE).format(RS.getTimestamp(nCol));
                                break;
                            default : 
                                break;
                        }                        
                        nCol++;
                    }
                    dtm.insertRow(Cpt, ligne);
                    Cpt++;
                }
                RS.close();
                
                jTable1.setModel(dtm);
            }
            else 
            {
                jTA_Error.setEnabled(true);
                jTA_Error.setText("Aucun resultat à afficher !");
            }
        } 
        catch (SQLException ex) 
        {            
            jTA_Error.setEnabled(true);
            jTA_Error.setText(ex.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(Application_Test_JDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application_Test_JDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application_Test_JDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application_Test_JDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application_Test_JDBC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonConnectMySQL;
    private javax.swing.JButton jButtonConnectOracle;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JComboBox<String> jComboBoxRequete;
    private javax.swing.JLabel jL_From_Set;
    private javax.swing.JLabel jL_Where;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTA_Error;
    private javax.swing.JTextField jTF_From_Set;
    private javax.swing.JTextField jTF_Sel_Upd;
    private javax.swing.JTextField jTF_Where;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
