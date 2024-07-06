package main.java.views;

import javax.swing.JOptionPane;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        roleBoxOpts = new javax.swing.JComboBox<>();
        roleLabel = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Final Destination Clinic Appointment Management System");
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(740, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(243, 208, 215));
        emailLabel.setText("Email");
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 226, 79, 31));

        passwordLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(243, 208, 215));
        passwordLabel.setText("Password");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 264, 79, 31));

        emailField.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(255, 64, 125));
        emailField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 227, 167, 31));

        passwordField.setForeground(new java.awt.Color(255, 64, 125));
        passwordField.setName("Password"); // NOI18N
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 264, 167, 31));
        passwordField.getAccessibleContext().setAccessibleName("Password");

        loginBtn.setBackground(new java.awt.Color(255, 64, 125));
        loginBtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 100, -1));

        titleLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(243, 208, 215));
        titleLabel.setText("Final Destination Clinic");
        getContentPane().add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 418, 60));

        roleBoxOpts.setBackground(new java.awt.Color(255, 255, 255));
        roleBoxOpts.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        roleBoxOpts.setForeground(new java.awt.Color(255, 64, 125));
        roleBoxOpts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor", "Admin" }));
        getContentPane().add(roleBoxOpts, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 110, -1));

        roleLabel.setFont(new java.awt.Font("Eras Light ITC", 1, 12)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(243, 208, 215));
        roleLabel.setText("Role");
        getContentPane().add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/resources/images/hospi.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 0, 850, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void showInvalidUserMessage() { 
        JOptionPane.showMessageDialog(this, "Invalid user credentials.");
    }
            
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox<String> roleBoxOpts;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

  
    public javax.swing.JTextField getEmailField() { return emailField; }
    public javax.swing.JButton getLoginBtn() { return loginBtn; }
    public javax.swing.JPasswordField getPasswordField() { return passwordField; }
    public javax.swing.JComboBox<String> getRoleBoxOpts() { return roleBoxOpts; }

}
