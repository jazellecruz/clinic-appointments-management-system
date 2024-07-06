/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.views;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.java.models.Doctor;
import main.java.models.Schedule;
import main.java.models.Specialization;
import main.java.models.VisitType;

//import org.jdesktop.swingx.prompt.PromptSupport;

public class ApptFormView extends javax.swing.JFrame {
      
    public ApptFormView(boolean isPatientNew) {

        Container c = this.getContentPane();
        c.setBackground(new Color(254, 254, 254));
       
        /* initialize common components */
        initComponents();
        
       if (isPatientNew) {
           initComponentsForNewPatient(); 
       } else {
           initComponentsForOldPatient();
       } 
      
        pack();
        setLocationRelativeTo(null);
    }
    
    private void initComponentsForNewPatient() {
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        sexComboBox = new javax.swing.JComboBox<>();
        sexLabel = new javax.swing.JLabel();

        nameLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 51, 51));
        nameLabel.setText("Full Name");

        getNameField().setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getNameField().setForeground(new java.awt.Color(102, 102, 102));
        getNameField().setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        ageLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ageLabel.setForeground(new java.awt.Color(51, 51, 51));
        ageLabel.setText("Age");

        ageField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ageField.setForeground(new java.awt.Color(102, 102, 102));
        ageField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        getSexComboBox().setBackground(new java.awt.Color(255, 255, 255));
        getSexComboBox().setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getSexComboBox().setForeground(new java.awt.Color(102, 102, 102));
        getSexComboBox().setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Female", "Male"}));
        getSexComboBox().setSelectedIndex(-1);
        getSexComboBox().setBorder(new EmptyBorder(0, 0,0,0));
        getSexComboBox().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        sexLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        sexLabel.setForeground(new java.awt.Color(51, 51, 51));
        sexLabel.setText("Sex");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visitTypeLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getNameField(), javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                            .addComponent(getSpecComboBox(), 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getDocComboBox(), 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getSchedComboBox(), 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(schedlabel)
                            .addComponent(docLabel)
                            .addComponent(specLabel)
                            .addComponent(nameLabel)
                            .addComponent(subLabel)
                            .addComponent(apptTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ageLabel)
                                        .addGap(200, 200, 200))
                                    .addComponent(getAgeField(), javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(getSexComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexLabel))))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(getVisitTypeComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getAddBtn(), javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(apptTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subLabel)
                .addGap(37, 37, 37)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getNameField(), javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(sexLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(getAgeField(), javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getSexComboBox()))
                .addGap(41, 41, 41)
                .addComponent(specLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getSpecComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(docLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getDocComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(schedlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getSchedComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(visitTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getVisitTypeComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(getAddBtn(), javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }
    
    private void initComponentsForOldPatient() {
        patientIdLabel = new javax.swing.JLabel();
        patientIdField = new javax.swing.JTextField();
        
        patientIdLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        patientIdLabel.setForeground(new java.awt.Color(51, 51, 51));
        patientIdLabel.setText("Patient ID");

        getPatientIdField().setBackground(new java.awt.Color(255, 255, 255));
        getPatientIdField().setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getPatientIdField().setText("Enter Patient ID");
        getPatientIdField().setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subLabel)
                            .addComponent(apptTitle))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(schedlabel)
                            .addComponent(docLabel)
                            .addComponent(specLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(getSchedComboBox(), javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(getDocComboBox(), javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(visitTypeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(getSpecComboBox(), javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(getVisitTypeComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(getAddBtn(), javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(patientIdLabel)
                            .addComponent(getPatientIdField(), javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 38, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(apptTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subLabel)
                .addGap(34, 34, 34)
                .addComponent(patientIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getPatientIdField(), javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(specLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getSpecComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(docLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getDocComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(schedlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getSchedComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(visitTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getVisitTypeComboBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(getAddBtn(), javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.getContentPane().setBackground(new Color(254, 254, 254));

        apptTitle = new javax.swing.JLabel();
        subLabel = new javax.swing.JLabel();
        specLabel = new javax.swing.JLabel();
        specComboBox = new JComboBox<Specialization>();
        docLabel = new javax.swing.JLabel();
        docComboBox = new JComboBox<Doctor>();
        schedlabel = new javax.swing.JLabel();
        schedComboBox = new JComboBox<Schedule>();
        visitTypeLabel = new javax.swing.JLabel();
        visitTypeComboBox = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Final Destination Clinic");

        apptTitle.setBackground(new java.awt.Color(255, 255, 255));
        apptTitle.setFont(new java.awt.Font("Metropolis Medium", 0, 24)); // NOI18N
        apptTitle.setForeground(new java.awt.Color(51, 51, 51));
        apptTitle.setText("Appointment Form");

        subLabel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        subLabel.setForeground(new java.awt.Color(102, 102, 102));
        subLabel.setText("Fill out the form to add a new appointment.");

        specLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        specLabel.setForeground(new java.awt.Color(51, 51, 51));
        specLabel.setText("Specialization");

        specComboBox.setBackground(new java.awt.Color(255, 255, 255));
        specComboBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        specComboBox.setForeground(new java.awt.Color(102, 102, 102));
        specComboBox.setBorder(null);

        docLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        docLabel.setForeground(new java.awt.Color(51, 51, 51));
        docLabel.setText("Doctor");

        docComboBox.setBackground(new java.awt.Color(255, 255, 255));
        docComboBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        docComboBox.setForeground(new java.awt.Color(102, 102, 102));
        docComboBox.setBorder(null);

        schedlabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        schedlabel.setForeground(new java.awt.Color(51, 51, 51));
        schedlabel.setText("Schedule");

        schedComboBox.setBackground(new java.awt.Color(255, 255, 255));
        schedComboBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        schedComboBox.setForeground(new java.awt.Color(102, 102, 102));
        schedComboBox.setBorder(null);

        visitTypeLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        visitTypeLabel.setForeground(new java.awt.Color(51, 51, 51));
        visitTypeLabel.setText("Visit Type");

        visitTypeComboBox.setBackground(new java.awt.Color(255, 255, 255));
        visitTypeComboBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        visitTypeComboBox.setForeground(new java.awt.Color(102, 102, 102));
        visitTypeComboBox.setBorder(null);

        addBtn.setBackground(new java.awt.Color(158, 0, 118));
        addBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setBorder(null);
        addBtn.setLabel("Submit");

        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void showMessageBox(String msg, String title, int icon) {
        JOptionPane.showMessageDialog(this, msg, title, icon);  
    }

    public String getNameFieldValue () { return nameField.getText(); }
    public int getAgeFieldValue () { return Integer.parseInt(this.ageField.getText()); }
    public String getSexComboBoxValue () { return  this.sexComboBox.getSelectedItem().toString(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addBtn;
    private JTextField ageField;
    private JLabel ageLabel;
    private JLabel apptTitle;
    private JComboBox<Doctor> docComboBox;
    private JLabel docLabel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JComboBox<Schedule> schedComboBox;
    private JLabel schedlabel;
    private JComboBox<String> sexComboBox;
    private JLabel sexLabel;
    private JComboBox<Specialization> specComboBox;
    private JLabel specLabel;
    private JLabel subLabel;
    private JComboBox<VisitType> visitTypeComboBox;
    private JLabel visitTypeLabel;
    private JTextField patientIdField;
    private JLabel patientIdLabel;
    // End of variables declaration//GEN-END:variables

    public JTextField getAgeField() { return ageField; }
    public JComboBox<Doctor> getDocComboBox() { return docComboBox;   }
    public JTextField getNameField() { return nameField; }
    public JComboBox<Schedule> getSchedComboBox() { return schedComboBox; }
    public JComboBox<String> getSexComboBox() { return sexComboBox; }
    public JComboBox<Specialization> getSpecComboBox() { return specComboBox; }
    public JComboBox<VisitType> getVisitTypeComboBox() { return visitTypeComboBox; }
    public JTextField getPatientIdField() { return patientIdField; }
    public JButton getAddBtn() { return addBtn; }

}
