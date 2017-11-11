/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpoolthreads;

import ProtocoleLUGAP.ReponseLUGAP;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Philippe
 */
public class FenAuthentification extends javax.swing.JFrame {
    private Client Client;
    /**
     * Creates new form Login_GUI
     */
    public FenAuthentification() 
    {
        setLocationRelativeTo(null); 
        initComponents();
        this.getRootPane().setDefaultButton(jButton_Connexion);
        
        try 
        {  
            this.Client = new Client();
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, "Problème interne au client !", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
        //this.jButton_ConnexionActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogin = new javax.swing.JLabel();
        jLabelPWD = new javax.swing.JLabel();
        jButton_Connexion = new javax.swing.JButton();
        jButton_Effacer = new javax.swing.JButton();
        jTF_Login = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connexion");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jLabelLogin.setText("Nom d'utilisateur");

        jLabelPWD.setText("Mot de passe");

        jButton_Connexion.setText("Connexion");
        jButton_Connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConnexionActionPerformed(evt);
            }
        });

        jButton_Effacer.setText("Effacer");
        jButton_Effacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EffacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLogin)
                            .addComponent(jLabelPWD))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF_Login)
                            .addComponent(jPasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 70, Short.MAX_VALUE)
                        .addComponent(jButton_Connexion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Effacer)
                        .addGap(60, 60, 60)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(jTF_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPWD)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Connexion)
                    .addComponent(jButton_Effacer)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EffacerActionPerformed
        jTF_Login.setText("");
        jPasswordField.setText("");
    }//GEN-LAST:event_jButton_EffacerActionPerformed

    private void jButton_ConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConnexionActionPerformed
        if (jTF_Login.getText().isEmpty() || jPasswordField.getPassword().length == 0)
        {
            JOptionPane.showMessageDialog(this, ReponseLUGAP.WRONG_USER_PASSWORD_MESSAGE, "Erreur", JOptionPane.ERROR_MESSAGE);
            jPasswordField.setText("");
        }
        else
        {
            ReponseLUGAP Rep = null;
            try 
            {
                Rep = getClient().Authenfication(jTF_Login.getText(), String.valueOf(jPasswordField.getPassword()));
                //ReponseLUGAP Rep = Client.Authenfication("Zeydax", "123");
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(this, "Le serveur est déconnecté !", "Erreur", JOptionPane.ERROR_MESSAGE);
            } 
            catch (NoSuchAlgorithmException | NoSuchProviderException ex) 
            {
                JOptionPane.showMessageDialog(this, "Erreur interne au client !", "Erreur", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

            if (Rep != null) 
            {
                if(Rep.getCode() == ReponseLUGAP.LOGIN_OK)
                {
                    System.out.println("Rep = " + Rep.getChargeUtile().get("Message"));
                    getClient().setNomUtilisateur(Rep.getChargeUtile().get("Prenom").toString() + " " + (Rep.getChargeUtile().get("Nom").toString()));

                    this.dispose();
                    FenAuthentification Test = this;
                    //getClient().setNomUtilisateur("Zeydax");
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new FlightsFrame(Test, getClient()).setVisible(true);
                        }
                    });
                    this.jButton_EffacerActionPerformed(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, (String) Rep.getChargeUtile().get("Message"), "Erreur", JOptionPane.ERROR_MESSAGE);
                    jPasswordField.setText("");
                    getClient().Deconnexion();
                }
            }
        }
    }//GEN-LAST:event_jButton_ConnexionActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        System.out.println("Typed KeyCode = " + evt.getKeyCode());
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            System.out.println("Coucou");
        }
    }//GEN-LAST:event_formKeyTyped

    
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
            java.util.logging.Logger.getLogger(FenAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenAuthentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenAuthentification().setVisible(true);
            }
        });
    }
    
    public Client getClient() {
        return Client;
    }

    public void setClient(Client Client) {
        this.Client = Client;
    }

    public JButton getjButton_Connexion() {
        return jButton_Connexion;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Connexion;
    private javax.swing.JButton jButton_Effacer;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPWD;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTF_Login;
    // End of variables declaration//GEN-END:variables
}
