/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.Connect;
import DAOModels.DAORent;
import Models.RentModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author A D E P T
 */
public class UIGiveBack extends javax.swing.JFrame {

    Connect connect = new Connect();
    RentModel rentModel = new RentModel();
    DAORent DAORent = new DAORent();
    
    public UIGiveBack() {
        initComponents();
        completeClientName();
        completeProductName();
        connect.Connection();
    }


    public void completeClientName(){
        connect.Connection();
        
        connect.executaSql("SELECT * FROM tb_rents ORDER BY client_name");
        try {
            connect.rs.first();
            cb_client_name.removeAllItems();
            do {
                cb_client_name.addItem(connect.rs.getString("client_name"));
            } while (connect.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao preencher a lista de clientes: "+ ex);
        }
    }
    
    public void completeProductName(){
        connect.Connection();
        
        connect.executaSql("SELECT * FROM tb_rents ORDER BY product_name");
        try {
            connect.rs.first();
            cb_product_name.removeAllItems();
            do {
                cb_product_name.addItem(connect.rs.getString("product_name"));
            } while (connect.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao preencher a lista de filmes: "+ ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_give_back_title = new javax.swing.JLabel();
        lb_client_name = new javax.swing.JLabel();
        cb_client_name = new javax.swing.JComboBox<>();
        lb_product_name = new javax.swing.JLabel();
        cb_product_name = new javax.swing.JComboBox<>();
        bt_give_back = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lb_give_back_title.setFont(new java.awt.Font("Calibri", 1, 55)); // NOI18N
        lb_give_back_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_give_back_title.setText("Devolver Filme");

        lb_client_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_client_name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_client_name.setText("Nome do Cliente: ");

        cb_client_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o cliente" }));
        cb_client_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_client_nameActionPerformed(evt);
            }
        });

        lb_product_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_product_name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_product_name.setText("Nome do Filme: ");

        cb_product_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o filme" }));

        bt_give_back.setBackground(new java.awt.Color(255, 255, 255));
        bt_give_back.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        bt_give_back.setText("Devolver");
        bt_give_back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        bt_give_back.setFocusPainted(false);
        bt_give_back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_give_back.setMaximumSize(new java.awt.Dimension(90, 28));
        bt_give_back.setMinimumSize(new java.awt.Dimension(90, 28));
        bt_give_back.setPreferredSize(new java.awt.Dimension(90, 28));
        bt_give_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_give_backActionPerformed(evt);
            }
        });

        bt_cancel.setBackground(new java.awt.Color(255, 255, 255));
        bt_cancel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        bt_cancel.setText("Cancelar");
        bt_cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bt_cancel.setFocusPainted(false);
        bt_cancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_cancel.setMaximumSize(new java.awt.Dimension(90, 28));
        bt_cancel.setMinimumSize(new java.awt.Dimension(90, 28));
        bt_cancel.setPreferredSize(new java.awt.Dimension(90, 28));
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_give_back_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_client_name, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(lb_product_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_give_back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lb_give_back_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_client_name))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_product_name))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_give_back, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(674, 431));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Deseja cancelar a devolução do produto ?","Devolução",JOptionPane.YES_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            connect.Disconnect();
            dispose();
        }
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_give_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_give_backActionPerformed
        int confirm = 0;
        confirm = JOptionPane.showConfirmDialog(rootPane, "Deseja realizar a devolução do produto ?");
        
        if (confirm == JOptionPane.YES_OPTION) {
            rentModel.setProduct_name((String)cb_product_name.getSelectedItem());
            DAORent.Delete(rentModel);
            connect.Disconnect();
            dispose();
        }
        
    }//GEN-LAST:event_bt_give_backActionPerformed

    private void cb_client_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_client_nameActionPerformed

    }//GEN-LAST:event_cb_client_nameActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int option = JOptionPane.showConfirmDialog(null, "Deseja cancelar a devolução do produto ?","Devolução",JOptionPane.YES_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            connect.Disconnect();
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(UIGiveBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIGiveBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIGiveBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIGiveBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UIGiveBack().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_give_back;
    private javax.swing.JComboBox<String> cb_client_name;
    private javax.swing.JComboBox<String> cb_product_name;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_client_name;
    private javax.swing.JLabel lb_give_back_title;
    private javax.swing.JLabel lb_product_name;
    // End of variables declaration//GEN-END:variables
}
