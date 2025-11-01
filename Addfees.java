/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public final class Addfees extends javax.swing.JFrame {

    /**
     * Creates new form Addfees
     * @throws java.sql.SQLException
     */
    public Addfees() throws SQLException {
        initComponents();
        displayCashFirst();
        
        int  receiptNo = getReceiptNo();
        txtReceiptNo.setText(Integer.toString(receiptNo));
    }
    public void displayCashFirst(){
        lbl_DDNo.setVisible(false);
        lbl_ChequeNo.setVisible(false);
        lbl_BankName.setVisible(false);
        
        txtDDNo.setVisible(false);
        txtChequeNo.setVisible(false);
        txt_bankName.setVisible(false);
        
    }
    
    public boolean validation(){
        if(txt_Received.getText().equals("")){
            JOptionPane.showMessageDialog(this,"please enter user name");
            return false;
        }
        if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this,"please enter amount (in numbers)");
            return false;
        }
        
//        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("cheque")){
//         
//            if(txtChequeNo.getText().equals("")){
//            JOptionPane.showMessageDialog(this,"please enter cheque number");
//            return false;
//        }   
//            if(txt_bankName.getText().equals("")){
//            JOptionPane.showMessageDialog(this,"please enter Bank Name");
//            return false;
//        }  
//        }
//        
//        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("dd")){
//         
//            if(txtDDNo.getText().equals("")){
//            JOptionPane.showMessageDialog(this,"please enter dd no");
//            return false;
//        }   
//            if(txt_bankName.getText().equals("")){
//            JOptionPane.showMessageDialog(this,"please enter Bank Name");
//            return false;
//        }  
//        }
//        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("Card")){
//            if(txt_bankName.getText().equals("")){
//            JOptionPane.showMessageDialog(this,"please enter Bank Name");
//            return false;
//        }  
//        }

return true;
    }

    public int getReceiptNo() throws SQLException{
        int receiptNo = 0;
        try
        {
         Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement("select max(reciept_no) from fees_Details");
         ResultSet rs = pst.executeQuery();
         
         System.out.println(rs);
         if(rs.next()==true){
             
             receiptNo = rs.getInt(1);    
         }
        }
        catch(SQLException e){  
        }
        
        System.out.println(receiptNo);
        
        return receiptNo + 1;
        
    }
    public String insertData(){
        String status ="";
        
            int receiptNo = Integer.parseInt(txtReceiptNo.getText());
            String studentName = txt_Received.getText();
            String paymentMode = combo_PaymentMode.getSelectedItem().toString();
            String chequeNo= txtChequeNo.getText();
            String bankName = txt_bankName.getText();
            String ddNo= txtDDNo.getText();
            String courseName = txt_courseName.getText();
            float totalAmount = Float.parseFloat(txt_total.getText());
            float initialAmount = Float.parseFloat(txt_amount.getText());
            float cgst = Float.parseFloat(txt_cgst.getText());
            float sgst = Float.parseFloat(txt_sgst.getText());
            String totalInWords =  txt_total_words.getText();
            String remark = txt_remark.getText();
            int year1 = Integer.parseInt(txt_year1.getText());
            int year2= Integer.parseInt(txt_year2.getText());
            
        try
        {
         Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
         pst.setInt(1,receiptNo);
         pst.setString(2,studentName);
         pst.setString(3,paymentMode);
         pst.setString(4,chequeNo);
         pst.setString(5,bankName);
         pst.setString(6,ddNo);
         pst.setString(7,courseName);
         pst.setFloat(8,totalAmount);
         pst.setFloat(9,initialAmount);
         pst.setFloat(10,cgst);
         pst.setFloat(11,sgst);
         pst.setString(12,totalInWords);
         pst.setString(13,remark);
         pst.setFloat(14,year1);
         pst.setFloat(15,year2);
         
         int rowCount = pst.executeUpdate();
         
         if(rowCount != 1){
             status = "failed";
         }else{
             status = "success";
         }
        }
        catch(SQLException e){  
        }
        return status ;
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsideBar = new javax.swing.JPanel();
        panelBack = new javax.swing.JPanel();
        btnback = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        btnhome = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btnlogout = new javax.swing.JLabel();
        panelParent = new javax.swing.JPanel();
        txt_gstin = new javax.swing.JLabel();
        lbl_ReceiptNo = new javax.swing.JLabel();
        lbl_PaymentMode = new javax.swing.JLabel();
        lbl_DDNo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_bankName = new javax.swing.JTextField();
        txtReceiptNo = new javax.swing.JTextField();
        combo_PaymentMode = new javax.swing.JComboBox<>();
        lbl_ChequeNo = new javax.swing.JLabel();
        txtDDNo = new javax.swing.JTextField();
        lbl_BankName = new javax.swing.JLabel();
        panelChild = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        lbl_Received = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        combo_Course = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_Received = new javax.swing.JTextField();
        txt_total_words = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_sgst = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_courseName = new javax.swing.JTextField();
        lbl_Course = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        lbl_gstin = new javax.swing.JLabel();
        lbl_Date = new javax.swing.JLabel();
        txtChequeNo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsideBar.setBackground(new java.awt.Color(0, 153, 153));
        panelsideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBack.setBackground(new java.awt.Color(0, 153, 153));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/left-arrow.png"))); // NOI18N
        btnback.setText("Back");
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbackMouseExited(evt);
            }
        });
        panelBack.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 200, 50));

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 280, 80));

        panelHome.setBackground(new java.awt.Color(0, 153, 153));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnhome.setForeground(new java.awt.Color(255, 255, 255));
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnhome.setText("Home");
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhomeMouseExited(evt);
            }
        });
        panelHome.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 60));

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 280, 80));

        panelLogout.setBackground(new java.awt.Color(0, 153, 153));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogout.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/logout.png"))); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogoutMouseExited(evt);
            }
        });
        panelLogout.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 200, 50));

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 280, 80));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 1040));

        panelParent.setBackground(new java.awt.Color(0, 204, 255));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_gstin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_gstin.setText("23H231B2JSS2");
        panelParent.add(txt_gstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, -1, -1));

        lbl_ReceiptNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ReceiptNo.setText("Receipt No :");
        panelParent.add(lbl_ReceiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        lbl_PaymentMode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_PaymentMode.setText("Mode of Payment :");
        panelParent.add(lbl_PaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        lbl_DDNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_DDNo.setText("DD no : ");
        panelParent.add(lbl_DDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelParent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("___/___/___");
        panelParent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 110, -1));

        txt_bankName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bankNameActionPerformed(evt);
            }
        });
        panelParent.add(txt_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 290, 30));

        txtReceiptNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReceiptNoActionPerformed(evt);
            }
        });
        panelParent.add(txtReceiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 170, 30));

        combo_PaymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD ", "Cheque ", "Cash ", "Card" }));
        combo_PaymentMode.setSelectedIndex(2);
        combo_PaymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PaymentModeActionPerformed(evt);
            }
        });
        panelParent.add(combo_PaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 170, 30));

        lbl_ChequeNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ChequeNo.setText("Cheque No :");
        panelParent.add(lbl_ChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        txtDDNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDDNoActionPerformed(evt);
            }
        });
        panelParent.add(txtDDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 170, 30));

        lbl_BankName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_BankName.setText("Bank Name :");
        panelParent.add(lbl_BankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        panelChild.setBackground(new java.awt.Color(0, 204, 255));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("The  following paymentin College Office of the year ");
        panelChild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        panelChild.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 80, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("to");
        panelChild.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        panelChild.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 190, 30));

        lbl_Received.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_Received.setText("Received From :");
        panelChild.add(lbl_Received, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        txt_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year1ActionPerformed(evt);
            }
        });
        panelChild.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 80, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Receiver Signature");
        panelChild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, -1, 20));

        combo_Course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "Python", "Android", "C", "C++", "JavaScript" }));
        combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseActionPerformed(evt);
            }
        });
        panelChild.add(combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Amount (Rs)");
        panelChild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, -1, -1));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 280, 10));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 980, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Remark :");
        panelChild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Sr No :");
        panelChild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Head ");
        panelChild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        txt_Received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ReceivedActionPerformed(evt);
            }
        });
        panelChild.add(txt_Received, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 290, 30));

        txt_total_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_wordsActionPerformed(evt);
            }
        });
        panelChild.add(txt_total_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 430, 30));

        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panelChild.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 190, 30));

        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        panelChild.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 190, 30));

        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        panelChild.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 190, 30));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 970, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Roll no :");
        panelChild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("SGST 9%");
        panelChild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, -1, 20));

        txt_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseNameActionPerformed(evt);
            }
        });
        panelChild.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 460, 30));

        lbl_Course.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_Course.setText("Course :");
        panelChild.add(lbl_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Total in word :");
        panelChild.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panelChild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 400, 60));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 280, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("CGST 9%");
        panelChild.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, -1, 20));

        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelChild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, 70, -1));

        panelParent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 990, 520));

        lbl_gstin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gstin.setText("GSTIN :");
        panelParent.add(lbl_gstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, -1, -1));

        lbl_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_Date.setText("Date  :");
        panelParent.add(lbl_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, -1, -1));

        txtChequeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChequeNoActionPerformed(evt);
            }
        });
        panelParent.add(txtChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 170, 30));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 1300, 1060));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseEntered
        Color clr = new Color(0,102,102);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseEntered

    private void btnhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseExited
        Color clr = new Color(0,152,152);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseExited

    private void btnlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseEntered
        Color clr = new Color(0,102,102);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseEntered

    private void btnlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseExited
        Color clr = new Color(0,152,152);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseExited

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        Color clr = new Color(0,152,152);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseExited

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        Color clr = new Color(0,102,102);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
     home h = new home();
     h.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void txt_bankNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bankNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bankNameActionPerformed

    private void txtReceiptNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceiptNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceiptNoActionPerformed

    private void txtDDNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDDNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDDNoActionPerformed

    private void combo_PaymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PaymentModeActionPerformed
                   if(combo_PaymentMode.getSelectedIndex()==0){
                       
                    lbl_DDNo.setVisible(true);
                    txtDDNo.setVisible(true);
                    lbl_ChequeNo.setVisible(false);
                    txtChequeNo.setVisible(false);
                    lbl_BankName.setVisible(true);
                    txt_bankName.setVisible(true);

                   }
                   if(combo_PaymentMode.getSelectedIndex()==1){   
                    lbl_DDNo.setVisible(false);
                    txtDDNo.setVisible(false);
                    lbl_ChequeNo.setVisible(true);
                    txtChequeNo.setVisible(true);
                    lbl_BankName.setVisible(true);
                    txt_bankName.setVisible(true);
                   }
                   if(combo_PaymentMode.getSelectedIndex()==2){   
                    displayCashFirst();
                   }
                   if(combo_PaymentMode.getSelectedItem().equals("Card")){   
                    lbl_DDNo.setVisible(false);
                    txtDDNo.setVisible(false);
                    lbl_ChequeNo.setVisible(false);
                    txtChequeNo.setVisible(false);
                    lbl_BankName.setVisible(true);
                    txt_bankName.setVisible(true);
                   }
                   
    }//GEN-LAST:event_combo_PaymentModeActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year1ActionPerformed

    private void combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseActionPerformed

        txt_courseName.setText(combo_Course.getSelectedItem().toString());
    }//GEN-LAST:event_combo_CourseActionPerformed

    private void txt_ReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ReceivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceivedActionPerformed

    private void txt_total_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_wordsActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
       
        Float amnt = Float.parseFloat(txt_amount.getText());
        
        Float  cgst = (float)(amnt * 0.09);
        Float  sgst = (float)(amnt * 0.09);
        
        txt_cgst.setText(cgst.toString());
        txt_sgst.setText(sgst.toString());          
        
        float total = amnt + cgst + sgst;
        
        txt_total.setText(Float.toString(total));
        
        txt_total_words.setText(NumberToWordsConverter.convert((int)total)+ " Only");
        
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseNameActionPerformed

    private void txtChequeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChequeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChequeNoActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
     if(validation() == true){
         
         String result = insertData();
         if(result.equals("success")){
            JOptionPane.showMessageDialog(this,"record inserted Successfully");
            
            PrintReciept ps = new PrintReciept();
            ps.setVisible(true);
            this.dispose();
            
         }else{
             JOptionPane.showMessageDialog(this,"record inserted Failed");
         }
       
      }
     
    }//GEN-LAST:event_btn_printActionPerformed

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
            Login login = new Login();
             login.setVisible(true);
             this.dispose();
    }//GEN-LAST:event_btnlogoutMouseClicked

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnbackMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Addfees().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Addfees.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JComboBox<String> combo_Course;
    private javax.swing.JComboBox<String> combo_PaymentMode;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_BankName;
    private javax.swing.JLabel lbl_ChequeNo;
    private javax.swing.JLabel lbl_Course;
    private javax.swing.JLabel lbl_DDNo;
    private javax.swing.JLabel lbl_Date;
    private javax.swing.JLabel lbl_PaymentMode;
    private javax.swing.JLabel lbl_ReceiptNo;
    private javax.swing.JLabel lbl_Received;
    private javax.swing.JLabel lbl_gstin;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTextField txtChequeNo;
    private javax.swing.JTextField txtDDNo;
    private javax.swing.JTextField txtReceiptNo;
    private javax.swing.JTextField txt_Received;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankName;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JLabel txt_gstin;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_words;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables
}
