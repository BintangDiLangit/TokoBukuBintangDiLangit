/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.vw.kasir;

import com.buku.ctr.transaksiCtr;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BintangDiLangit
 */
public class FormTabelKasir extends javax.swing.JFrame {
    
    private transaksiCtr ctrtrans;
    /**
     * Creates new form FormTabelKasir
     */
    public FormTabelKasir() {
        initComponents();
        ctrtrans = new transaksiCtr(this);
    }
    public JTextField getTxt_totalharga() {
        return txtTotalHg;
    }

    public JLabel getTxt_stok() {
        return txt_stok;
    }
    
    

    public JComboBox<String> getCm_buku() {
        return pilihbuku;
    }

    public JTextField getTxt_jumlah() {
        return txtjumlah;
    }

    public JDateChooser getCm_tanggal() {
        return jDateChooser1;
    }

    public JLabel getTxt_kodekasir() {
        return txt_kodekasir;
    }

    public JLabel getTxt_waktu() {
        return txt_waktu;
    }

    public JTable getTabeltransaksi() {
        return jTable1;
    }

    public JTextField getjTextField1() {
        return txtTotalHg;
    }

    public JTextField getTxt_kembali() {
        return txtKembalian;
    }

    public JTextField getTxt_tunai() {
        return txtTunai;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_kodekasir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtjumlah = new javax.swing.JTextField();
        pilihbuku = new javax.swing.JComboBox<>();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        txt_stok = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalHg = new javax.swing.JTextField();
        txtTunai = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        txt_waktu = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_kodekasir.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        txt_kodekasir.setForeground(new java.awt.Color(255, 255, 255));
        txt_kodekasir.setText("jLabel1");
        getContentPane().add(txt_kodekasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 25, -1, -1));

        jLabel1.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tanggal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 125, -1, -1));

        jLabel2.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Buku");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 163, -1, -1));

        jLabel3.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transaksi Toko");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 53, -1, -1));

        jLabel4.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 214, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 292, 750, 160));

        txtjumlah.setBackground(new java.awt.Color(0, 0, 0));
        txtjumlah.setFont(new java.awt.Font("LM Mono 10", 0, 12)); // NOI18N
        txtjumlah.setForeground(new java.awt.Color(255, 255, 255));
        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });
        getContentPane().add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 210, 321, -1));

        pilihbuku.setBackground(new java.awt.Color(0, 0, 0));
        pilihbuku.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        pilihbuku.setForeground(new java.awt.Color(255, 255, 255));
        pilihbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pilihbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihbukuActionPerformed(evt);
            }
        });
        getContentPane().add(pilihbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 158, 321, -1));

        tambah.setBackground(new java.awt.Color(0, 0, 0));
        tambah.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        tambah.setForeground(new java.awt.Color(255, 255, 255));
        tambah.setText("Tambahkan");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 251, -1, -1));

        hapus.setBackground(new java.awt.Color(0, 0, 0));
        hapus.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 251, -1, -1));

        kembali.setBackground(new java.awt.Color(153, 0, 0));
        kembali.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        kembali.setForeground(new java.awt.Color(255, 255, 255));
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 251, -1, -1));

        cetak.setBackground(new java.awt.Color(0, 0, 0));
        cetak.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        cetak.setForeground(new java.awt.Color(255, 255, 255));
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 251, -1, -1));

        txt_stok.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        txt_stok.setForeground(new java.awt.Color(255, 255, 255));
        txt_stok.setText("Stok");
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 177, -1));

        jDateChooser1.setBackground(new java.awt.Color(0, 0, 0));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 111, 321, -1));

        jLabel5.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Harga");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, 20));

        jLabel6.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tunai");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, -1, 20));

        txtTotalHg.setBackground(new java.awt.Color(0, 0, 0));
        txtTotalHg.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalHg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHgActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotalHg, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 124, -1));

        txtTunai.setBackground(new java.awt.Color(0, 0, 0));
        txtTunai.setForeground(new java.awt.Color(255, 255, 255));
        txtTunai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTunaiActionPerformed(evt);
            }
        });
        getContentPane().add(txtTunai, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 124, -1));

        txtKembalian.setBackground(new java.awt.Color(0, 0, 0));
        txtKembalian.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 560, 124, -1));

        txt_waktu.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        txt_waktu.setForeground(new java.awt.Color(255, 255, 255));
        txt_waktu.setText("jLabel6");
        getContentPane().add(txt_waktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setFont(new java.awt.Font("LM Mono 10", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Kembalian");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, 100, 40));

        bg.setIcon(new javax.swing.ImageIcon("/media/odading/mangoleh/Semester 3/PBO/Prak/Project UAS/tokobukubintangdilangit/img/formtabelKasir.jpg")); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
       ctrtrans.tombolcetak();
    }//GEN-LAST:event_cetakActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
       ctrtrans.tomboltambahkan();
       
    }//GEN-LAST:event_tambahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        ctrtrans.tombolhapus();
    }//GEN-LAST:event_hapusActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        ctrtrans.kembali();
    }//GEN-LAST:event_kembaliActionPerformed

    private void txtTotalHgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHgActionPerformed
        
    }//GEN-LAST:event_txtTotalHgActionPerformed

    private void txtTunaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTunaiActionPerformed
        ctrtrans.jumlahuangkembali();
    }//GEN-LAST:event_txtTunaiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        ctrtrans.kliktabel(evt);
    }//GEN-LAST:event_jTable1MouseClicked

    private void pilihbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihbukuActionPerformed
        ctrtrans.stok();
    }//GEN-LAST:event_pilihbukuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ctrtrans.jumlahuangkembali();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton kembali;
    private javax.swing.JComboBox<String> pilihbuku;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtTotalHg;
    private javax.swing.JTextField txtTunai;
    private javax.swing.JLabel txt_kodekasir;
    private javax.swing.JLabel txt_stok;
    private javax.swing.JLabel txt_waktu;
    private javax.swing.JTextField txtjumlah;
    // End of variables declaration//GEN-END:variables
}
