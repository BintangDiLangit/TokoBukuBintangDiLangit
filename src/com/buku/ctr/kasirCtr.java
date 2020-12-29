/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.kasirDAO;
import com.buku.model.intrfc.intrfcKasir;
import com.buku.model.login;
import com.buku.model.tabel.tModKasir;
import com.buku.model.user;
import com.buku.vw.FormLogin;
import com.buku.vw.admin.Kasir;
import com.buku.vw.admin.formAdmn;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author BintangDiLangit
 */
public class kasirCtr extends Cetak {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<user> list;
    private user user;
    private static Kasir kasirpanel;
    private intrfcKasir implementkasir;
    private int daftar = 0;

    public kasirCtr(Kasir kasirpanel) {
        this.kasirpanel = kasirpanel;
        implementkasir = new kasirDAO();
        user = new user();
        if (login.getStatus().equals("aktif")) {
            lokasiform();
            IsiTabel();
            komponen("awal");
        } else {
            warn("Anda belum login");
            new FormLogin().setVisible(true);
            this.kasirpanel.setVisible(false);
        }

    }

    public void lokasiform() {
        int x = layar.width / 2 - kasirpanel.getSize().width / 2;
        int y = layar.height / 2 - kasirpanel.getSize().height / 2;
        kasirpanel.setLocation(x, y);
        komponen("awal");
    }

    public void komponen(String action) {
        switch (action) {
            case "awal":
                kasirpanel.getBtn_cari().setEnabled(true);
                kasirpanel.getBtn_daftar().setEnabled(true);
                kasirpanel.getBtn_hapus().setEnabled(false);
                kasirpanel.getBtn_Ubah().setEnabled(false);
                break;
            case "cari":
                kasirpanel.getBtn_cari().setEnabled(true);
                kasirpanel.getBtn_daftar().setEnabled(false);
                kasirpanel.getBtn_hapus().setEnabled(false);
                kasirpanel.getBtn_Ubah().setEnabled(false);
                break;
            case "segarkan":
                kasirpanel.getBtn_cari().setEnabled(true);
                kasirpanel.getBtn_daftar().setEnabled(true);
                kasirpanel.getBtn_hapus().setEnabled(false);
                kasirpanel.getBtn_Ubah().setEnabled(false);
                kasirpanel.getTxt_userid().setEnabled(true);
                kasirpanel.getTxt_userid().setText(null);
                kasirpanel.getTxt_nama().setText(null);
                kasirpanel.getJtanggal().setDate(null);
                kasirpanel.getTxt_pass().setText(null);
                IsiTabel();
                daftar = 0;
                break;

            case "simpan":
                kasirpanel.getBtn_cari().setEnabled(true);
                kasirpanel.getBtn_daftar().setEnabled(true);
                kasirpanel.getBtn_hapus().setEnabled(false);
                kasirpanel.getBtn_Ubah().setEnabled(false);
                break;

            case "klik":
                kasirpanel.getTxt_userid().setEnabled(false);
                kasirpanel.getBtn_cari().setEnabled(false);
                kasirpanel.getBtn_daftar().setEnabled(false);
                kasirpanel.getBtn_hapus().setEnabled(true);
                kasirpanel.getBtn_Ubah().setEnabled(true);
                daftar = 0;
                break;

            case "daftar":
                kasirpanel.getBtn_cari().setEnabled(false);
                kasirpanel.getBtn_daftar().setEnabled(true);
                kasirpanel.getBtn_hapus().setEnabled(false);
                kasirpanel.getBtn_Ubah().setEnabled(false);
                kasirpanel.getTxt_userid().setEnabled(false);
                kasirpanel.getTxt_userid().setText(null);
                kasirpanel.getTxt_nama().setText(null);
                kasirpanel.getJtanggal().setDate(null);
                kasirpanel.getTxt_pass().setText(null);

        }
    }

    public void IsiTabel() {
        list = implementkasir.getAllKasir();
        kasirpanel.getTabelkasir().setModel(new tModKasir(list));
    }

    public void kliktabel(java.awt.event.MouseEvent evt) {
        komponen("klik");
        try {
            Date date = null;
            int row = kasirpanel.getTabelkasir().rowAtPoint(evt.getPoint());

            user.setUserId(kasirpanel.getTabelkasir().getValueAt(row, 0).toString());
            user.setName(kasirpanel.getTabelkasir().getValueAt(row, 1).toString());
            user.setTtl(kasirpanel.getTabelkasir().getValueAt(row, 2).toString());
            if (user.getTtl().equals("null")) {
                date = null;
            } else {
                date = new SimpleDateFormat("dd/MM/yy").parse(user.getTtl());
            }
            user.setPwd(kasirpanel.getTabelkasir().getValueAt(row, 3).toString());

            kasirpanel.getTxt_userid().setText(String.valueOf(user.getUserId()));
            kasirpanel.getTxt_nama().setText(String.valueOf(user.getName()));
            kasirpanel.getJtanggal().setDate(date);
            kasirpanel.getTxt_pass().setText(String.valueOf(user.getPwd()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tombolcari() {

        if (kasirpanel.getTxt_userid().getText().equals("")) {
            user.setUserId("null");
        } else {
            user.setUserId("%" + kasirpanel.getTxt_userid().getText() + "%");
        }
        if (kasirpanel.getTxt_nama().getText().equals("")) {
            user.setName("null");
        } else {
            user.setName("%" + kasirpanel.getTxt_nama().getText() + "%");
        }
        if (kasirpanel.getJtanggal().getDate() == null) {
            user.setTtl("null");
        } else {
            SimpleDateFormat format = new SimpleDateFormat("MM/d/yyyy");
            user.setTtl((format.format(kasirpanel.getJtanggal().getDate())));
        }
        if (kasirpanel.getTxt_pass().getText().equals("")) {
            user.setPwd("null");
        } else {
            user.setPwd(kasirpanel.getTxt_pass().getText());
        }

        list = implementkasir.getCari(user.getUserId(), user.getName(), user.getTtl(), user.getPwd());

        kasirpanel.getTabelkasir().setModel(new tModKasir(list));
        info("Data yang di Temukan " + list.size());
        komponen("cari");
    }

    public void tomboldaftar() {

        user.setUserId("KSR" + String.valueOf(implementkasir.jumlahData() + 1));

        if (daftar == 0) {
            komponen("daftar");
            info("Masukkan Data");
            daftar = 1;
            kasirpanel.getTxt_userid().setText(user.getUserId());

        } else {
            SimpleDateFormat format = new SimpleDateFormat("MM/d/yyyy");
            user.setName(kasirpanel.getTxt_nama().getText());
            user.setTtl((format.format(kasirpanel.getJtanggal().getDate())));
            user.setPwd(kasirpanel.getTxt_pass().getText());

            if (user.getName().equals("")) {
                warn("Maaf, Nama Buku belum diisi !");
                kasirpanel.getTxt_nama().requestFocus();
            } else if (user.getTtl().equals("")) {
                warn("Maaf, Jenis Buku belum diisi !");
                kasirpanel.getJtanggal().requestFocus();
            } else if (user.getPwd().equals("")) {
                warn("Maaf, Harga Buku belum diisi !");
                kasirpanel.getTxt_pass().requestFocus();
            } else {
                if (implementkasir.insert(user.getUserId(), user.getName(), user.getTtl(), user.getPwd())) {
                    info("Data Telah di Tambahkan");
                    daftar = 0;
                    komponen("segarkan");
                } else {
                    info("Data Gagal di Tambahkan");
                }
            }

        }

    }

    public void tombolhapus() {
        user.setUserId(kasirpanel.getTxt_userid().getText());

        if (confirmation("Apakah Anda yakin akan menghapus dataini ?")) {
            if (implementkasir.delete(user.getUserId())) {
                info("Data Telah Di Hapus");
                komponen("segarkan");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
            }
        }

    }

    public void tombolrubah() {
        SimpleDateFormat format = new SimpleDateFormat("MM/d/yyyy");
        user.setUserId(kasirpanel.getTxt_userid().getText().toString());
        user.setName(kasirpanel.getTxt_nama().getText().toString());
        user.setTtl((format.format(kasirpanel.getJtanggal().getDate())));
        user.setPwd(kasirpanel.getTxt_pass().getText().toString());

        if (confirmation("Apakah Anda yakin akan merubah data ini ?")) {
            if (implementkasir.update(user.getUserId(), user.getName(), user.getTtl(), user.getPwd())) {
                info("Data Telah di Ubah");
                komponen("segarkan");
            } else {
                info("Data Gagal di Ubah");
            }
        }

    }

    public void tombolKembali() {
        new formAdmn().setVisible(true);
        kasirpanel.setVisible(false);
    }
}
