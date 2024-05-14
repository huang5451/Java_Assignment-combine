/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java_assignment.Customer_Login.LoginFunction;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class Customer_Payment extends javax.swing.JFrame {

    private DefaultTableModel model;
    double totalAmount = 0;
    private LoginFunction lf;
    
    /**
     * Creates new form Customer_Payment
     * @throws java.io.FileNotFoundException
     */
    public Customer_Payment(Customer_Login.LoginFunction lf) throws FileNotFoundException {
        try{
            initComponents();
            this.lf = lf;
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            lblOrderID.setText(lf.getLoggedInCustomerName()+df.format(date));
            lblCustomerID.setText(lf.getLoggedInCustomerID());
            lblCustomerName.setText(lf.getLoggedInCustomerName());
            File f =new File("PaymentData.txt");
            if(!f.exists()){
                f.createNewFile();
            }
            BufferedReader br= new BufferedReader(new FileReader(f));

            model = (DefaultTableModel) tblPayment.getModel();

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if(lblOrderID.getText().equals(dataRow[1]))
                model.addRow(dataRow);
            }
            for (int j = 0; j < tableLines.length; j++) {
                String linej = tableLines[j].toString().trim();
                String[] dataRowj = linej.split(",");
                if(lblOrderID.getText().equals(dataRowj[1]))
                totalAmount += Double.parseDouble(dataRowj[3]);
                txtTotalAmount.setText(String.valueOf(totalAmount));
            }
            
            File f2 =new File("CustomerData.txt");
            if(!f2.exists()){
                f2.createNewFile();
            }
            BufferedReader br2= new BufferedReader(new FileReader(f2));
            String line2 = "", input2 = "";
            while ((line2 = br2.readLine()) != null) {
            String[] values2 = line2.split(",");
            if (lblCustomerID.getText().equals(values2[0])) {
                txtCredit.setText(values2[4]);
            }
            input2 += line2 + "\n";
        }
            br.close();
    } catch (IOException e) {
        // Handle the exception (e.g., log it, display an error message, etc.)
        e.printStackTrace();
    }
    

   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayment = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCredit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PaymentID", "OrderID", "CustomerID", "Total_Amount", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblPayment);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Amount");

        jLabel2.setText("Your Credit");

        txtCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Payment");

        jLabel4.setText("Customer ID");

        jLabel5.setText("Customer Name");

        lblCustomerID.setText("jLabel5");

        lblCustomerName.setText("jLabel5");

        jLabel6.setText("OrderID");

        lblOrderID.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCredit, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtTotalAmount)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(232, 232, 232)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblOrderID))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(48, 48, 48)
                                        .addComponent(lblCustomerID))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCustomerName)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblCustomerID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblCustomerName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblOrderID))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(10, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        try {
        
        double customerCredit = Double.parseDouble(txtCredit.getText());

        if (customerCredit >= totalAmount) {
            
            double newCredit = customerCredit - totalAmount;

            txtCredit.setText(String.valueOf(newCredit));
            
            updateCustomerData(newCredit);
            
            updatePaymentData();
            jOptionPane1.showMessageDialog(this, "Payment successful! \nRemaining credit: " + newCredit);
            try {
            dispose();
            Customer_TransactionHistory cth;
            cth = new Customer_TransactionHistory(lf);
            cth.setVisible(true);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customer_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            jOptionPane1.showMessageDialog(this, "Insufficient funds. Please add credit to your account.");
        }
    } catch (NumberFormatException ex) {

        jOptionPane1.showMessageDialog(this, "Invalid input");
    }
    
    
    }//GEN-LAST:event_btnPayActionPerformed
private void updateCustomerData(double newCredit) {
    try {
        File file = new File("CustomerData.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", input = "";
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            if (lblCustomerID.getText().equals(values[0])) {
                values[4] = String.valueOf(newCredit);
                line = String.join(",", values);
            }
            input += line + "\n";
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(input);
        writer.close();
        JOptionPane.showMessageDialog(null, "Status updated successfully!");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error reading/writing to file!");
    }
}
    private void txtCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        Customer_Dashboard cd;
        cd = new Customer_Dashboard(lf);
        cd.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
private void updatePaymentData() {
    try {
        File file = new File("PaymentData.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", input = "";
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            if (lblOrderID.getText().equals(values[1])) {
                values[4] = "Success Pay";
                line = String.join(",", values);
            }
            input += line + "\n";
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(input);
        writer.close();
        JOptionPane.showMessageDialog(null, "Status updated successfully!");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error reading/writing to file!");
    }
}
    
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
            java.util.logging.Logger.getLogger(Customer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JTable tblPayment;
    private javax.swing.JTextField txtCredit;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables

}