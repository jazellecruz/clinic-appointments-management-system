package main.java.views;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.JTableHeader;

import main.java.models.Status;

public class DoctorView extends javax.swing.JFrame {
    private JComboBox<Status> statusTypeComboBox;
    private Date date;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM,  yyyy");
   
    public DoctorView(){
        statusTypeComboBox = new JComboBox<Status>(); 
        date = new Date();
        String formattedDate = formatter.format(date);

        Border roundedBorder = new LineBorder(Color.white, 10, true); 
        BasicScrollBarUI scrollBarUI = new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GRAY; 
            }
            
               @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        };
        BasicTableHeaderUI tableHeaderUI = new BasicTableHeaderUI() {
            @Override
            public void installDefaults() {
                super.installDefaults();
               
            }
        };
        
        initComponents();
        
        JScrollBar sb = tableScrollPane.getVerticalScrollBar();
        JTableHeader tableHeader = apptTable.getTableHeader();
        
        dateLabel.setText(formattedDate); 
        
        tableScrollPane.setBorder(roundedBorder);
        
        sb.setBackground(Color.white);
        sb.setPreferredSize(new Dimension(5, sb.getPreferredSize().height));
        sb.setUI(scrollBarUI);

        tableHeader.setDefaultRenderer(new CustomTableHeaderUI());
        tableHeader.setUI(tableHeaderUI);
        
        this.getContentPane().setBackground(new java.awt.Color(229, 229, 229));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableScrollPane = new javax.swing.JScrollPane();
        apptTable = new javax.swing.JTable();
        profilePanel = new javax.swing.JPanel();
        doctorNameLabel = new javax.swing.JLabel();
        doctorSpecLabel = new javax.swing.JLabel();
        subheader = new javax.swing.JLabel();
        imgAvatar = new main.java.views.ImageAvatar();
        apptLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        sortByLabel = new javax.swing.JLabel();
        filterComboBox = new javax.swing.JComboBox<>();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Final Destination Clinic");
        setBackground(new java.awt.Color(204, 204, 255));

        tableScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        tableScrollPane.setViewportView(apptTable);

        apptTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        apptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        apptTable.setFillsViewportHeight(true);
        apptTable.setRowHeight(40);
        apptTable.setRowMargin(10);
        apptTable.setSelectionBackground(new java.awt.Color(255, 153, 204));
        apptTable.setShowGrid(false);
        apptTable.getTableHeader().setReorderingAllowed(false);
        tableScrollPane.setViewportView(apptTable);

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));

        doctorNameLabel.setFont(new java.awt.Font("Poppins", 1, 21)); // NOI18N
        doctorNameLabel.setForeground(new java.awt.Color(45, 45, 45));
        doctorNameLabel.setText("Dr. James Reid");

        doctorSpecLabel.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        doctorSpecLabel.setForeground(new java.awt.Color(102, 102, 102));
        doctorSpecLabel.setText("Dentist");

        subheader.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        subheader.setForeground(new java.awt.Color(153, 153, 153));
        subheader.setText("Final Destination Clinic");

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctorNameLabel)
                    .addComponent(subheader)
                    .addComponent(doctorSpecLabel))
                .addContainerGap(946, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(doctorNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doctorSpecLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subheader))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        apptLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 20)); // NOI18N
        apptLabel.setForeground(new java.awt.Color(51, 51, 51));
        apptLabel.setText("All Appointments");

        dateLabel.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(153, 153, 153));
        dateLabel.setText("11 May 2024");

        sortByLabel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        sortByLabel.setText("Sort By:");

        filterComboBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Pending", "Confirmed", "Completed", "Canceled" }));

        logoutBtn.setBackground(new java.awt.Color(255, 64, 125));
        logoutBtn.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateLabel)
                                .addComponent(apptLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortByLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(apptLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortByLabel))
                .addGap(15, 15, 15)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void showMessageBox(String msg, String title, int icon) {
         JOptionPane.showMessageDialog(this, msg, title, icon);
    }
    
    public boolean showConfirmBox(String msg, String title) {
        boolean isConfirmed = false;
        
        int res = JOptionPane.showConfirmDialog(this, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        if(res == JOptionPane.YES_OPTION) isConfirmed = true;
      
        return isConfirmed;
    }
    
    public void setProfileForCurrentUser(String name, String spec, String imgPath) {
        this.doctorNameLabel.setText(name);
        this.doctorSpecLabel.setText(spec);
        this.imgAvatar.setImage(new ImageIcon(getClass().getResource(imgPath)));
    }
    
    public JComboBox<Status> getStatusTypeComboBox() { return statusTypeComboBox; }
    public javax.swing.JTable getApptTable() { return apptTable; }
    public javax.swing.JLabel getDoctorNameLabel() { return doctorNameLabel; }
    public javax.swing.JLabel getDoctorSpecLabel() { return doctorSpecLabel; }
    public javax.swing.JComboBox<String> getFilterComboBox() { return filterComboBox; }
    public main.java.views.ImageAvatar getImgAvatar() {  return imgAvatar; }
    public javax.swing.JButton getLogoutBtn() {  return logoutBtn; }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apptLabel;
    private javax.swing.JTable apptTable;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel doctorNameLabel;
    private javax.swing.JLabel doctorSpecLabel;
    private javax.swing.JComboBox<String> filterComboBox;
    private main.java.views.ImageAvatar imgAvatar;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel sortByLabel;
    private javax.swing.JLabel subheader;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

}
