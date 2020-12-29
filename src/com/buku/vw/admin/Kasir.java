/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.vw.admin;

import com.buku.ctr.kasirCtr;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BintangDiLangit
 */
public class Kasir extends javax.swing.JFrame {

    private kasirCtr kasirCtr;
    public Kasir() {
        initComponents();
        kasirCtr = new kasirCtr(this);
    }

   public JTextField getTxt_nama() {
        return txt_nama;
    }

    public JTextField getTxt_pass() {
        return txt_pass;
    }

    public JDateChooser getJtanggal() {
        return jtanggal;
    }

    public JTextField getTxt_userid() {
        return txt_userid;
    }
    
    public JTable getTabelkasir() {
        return Tabelkasir;
    }

    public JButton getBtn_cari() {
        return btn_cari;
    }

    public JButton getBtn_daftar() {
        return btn_daftar;
    }

    public JButton getBtn_hapus() {
        return btn_hapus;
    }

    public JButton getBtn_Ubah() {
        return btn_rubah;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_userid = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_pass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabelkasir = new javax.swing.JTable();
        btn_cari = new javax.swing.JButton();
        btn_daftar = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_rubah = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jtanggal = new com.toedter.calendar.JDateChooser();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("LM Mono 10", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Kasir Toko");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 68, -1, -1));

        jLabel4.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 111, -1, -1));

        jLabel5.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TTL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 154, -1, -1));

        jLabel6.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 195, -1, -1));

        txt_userid.setFont(new java.awt.Font("LM Mono 10", 0, 12)); // NOI18N
        getContentPane().add(txt_userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 64, 200, -1));

        txt_nama.setFont(new java.awt.Font("LM Mono 10", 0, 12)); // NOI18N
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 107, 200, -1));

        txt_pass.setFont(new java.awt.Font("LM Mono 10", 0, 12)); // NOI18N
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 199, 200, -1));

        Tabelkasir.setFont(new java.awt.Font("LM Mono 10", 0, 12)); // NOI18N
        Tabelkasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabelkasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelkasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabelkasir);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 244, 650, 280));

        btn_cari.setBackground(new java.awt.Color(0, 0, 0));
        btn_cari.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        btn_cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 60, 93, -1));

        btn_daftar.setBackground(new java.awt.Color(0, 0, 0));
        btn_daftar.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        btn_daftar.setForeground(new java.awt.Color(255, 255, 255));
        btn_daftar.setText("Daftar");
        btn_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 103, 93, -1));

        btn_hapus.setBackground(new java.awt.Color(0, 0, 0));
        btn_hapus.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 146, 93, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 195, 93, -1));

        btn_rubah.setBackground(new java.awt.Color(0, 0, 0));
        btn_rubah.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        btn_rubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_rubah.setText("Ubah");
        btn_rubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rubahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_rubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 103, 95, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Segarkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 60, 90, -1));
        getContentPane().add(jtanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 146, 200, -1));

        bg.setIcon(new javax.swing.ImageIcon("/media/odading/mangoleh/Semester 3/PBO/Prak/Project UAS/tokobukubintangdilangit/img/KasirAdmin.png")); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelkasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelkasirMouseClicked
        kasirCtr.kliktabel(evt);
        
    }//GEN-LAST:event_TabelkasirMouseClicked

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        kasirCtr.tombolcari();
        
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftarActionPerformed
        kasirCtr.tomboldaftar();
        

    }//GEN-LAST:event_btn_daftarActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        kasirCtr.tombolhapus();
        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       kasirCtr.tombolKembali();
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_rubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rubahActionPerformed
        kasirCtr.tombolrubah();
        

    }//GEN-LAST:event_btn_rubahActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        kasirCtr.komponen("segarkan");
       
    }//GEN-LAST:event_jButton1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabelkasir;
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_daftar;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_rubah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jtanggal;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_userid;
    // End of variables declaration//GEN-END:variables
}
