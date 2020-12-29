/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.penjualanDAO;
import com.buku.model.detail;
import com.buku.model.intrfc.intrfcPenjualan;
import com.buku.model.login;
import com.buku.model.penjualan;
import com.buku.model.tabel.tModelPenjualan;
import com.buku.vw.FormLogin;
import com.buku.vw.admin.DetPenjualan;
import com.buku.vw.admin.Penjualan;
import com.buku.vw.admin.formAdmn;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class penjualanCtr extends Cetak {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<penjualan> list;
    private penjualan penjualan;
    private static Penjualan penjualanpanel;
    private static intrfcPenjualan implementPenjualan;

    public penjualanCtr(Penjualan penjualanpanel) {
        this.penjualanpanel = penjualanpanel;
        implementPenjualan = new penjualanDAO();
        penjualan = new penjualan();
        if (login.getStatus().equals("aktif")) {
            lokasiform();
            IsiTabel();
            komponen("awal");
        } else {
            warn("Anda belum login");
            new FormLogin().setVisible(true);
            this.penjualanpanel.setVisible(false);
        }

    }

    public void lokasiform() {
        int x = layar.width / 2 - penjualanpanel.getSize().width / 2;
        int y = layar.height / 2 - penjualanpanel.getSize().height / 2;
        penjualanpanel.setLocation(x, y);
    }

    public void komponen(String action) {
        switch (action) {
            case "awal":
                penjualanpanel.getBtn_cari().setEnabled(true);
                penjualanpanel.getBtn_detail().setEnabled(false);
                penjualanpanel.getBtn_hapus().setEnabled(false);
                penjualanpanel.getTxt_tanggal().setText("MM/d/yyyy");
                penjualanpanel.getTxt_waktu().setText("00:00");
                penjualanpanel.getTxt_user().setText(null);
                break;
            case "cari":
                penjualanpanel.getBtn_cari().setEnabled(true);
                penjualanpanel.getBtn_hapus().setEnabled(true);
                penjualanpanel.getBtn_detail().setEnabled(true);
                break;
            case "segarkan":
                penjualanpanel.getBtn_cari().setEnabled(true);
                penjualanpanel.getBtn_hapus().setEnabled(false);
                penjualanpanel.getBtn_detail().setEnabled(false);
                penjualanpanel.getTxt_idStruk().setEnabled(true);
                penjualanpanel.getTxt_idStruk().setText(null);
                penjualanpanel.getTxt_tanggal().setText("MM/d/yyyy");
                penjualanpanel.getTxt_waktu().setText("00:00");
                penjualanpanel.getTxt_user().setText(null);
                IsiTabel();
                break;

            case "klik":
                penjualanpanel.getTxt_idStruk().setEnabled(false);
                penjualanpanel.getBtn_cari().setEnabled(false);
                penjualanpanel.getBtn_hapus().setEnabled(true);
                penjualanpanel.getBtn_detail().setEnabled(true);

                break;

        }
    }

    public void tombolKembali() {
        new formAdmn().setVisible(true);
        penjualanpanel.setVisible(false);
    }

    public void IsiTabel() {
        list = implementPenjualan.getAllpenjualan();
        penjualanpanel.getTabelPenjualan().setModel(new tModelPenjualan(list));
    }

    public void kliktabel(java.awt.event.MouseEvent evt) {
        komponen("klik");
        try {
            int row = penjualanpanel.getTabelPenjualan().rowAtPoint(evt.getPoint());
            if (row > - 1) {
                penjualan.setKodeStruk(penjualanpanel.getTabelPenjualan().getValueAt(row, 0).toString());
                penjualan.setTgl(penjualanpanel.getTabelPenjualan().getValueAt(row, 1).toString());
                penjualan.setWaktu(penjualanpanel.getTabelPenjualan().getValueAt(row, 2).toString());
                penjualan.setUserKasir(penjualanpanel.getTabelPenjualan().getValueAt(row, 6).toString());

                penjualanpanel.getTxt_idStruk().setText(penjualan.getKodeStruk());
                penjualanpanel.getTxt_tanggal().setText(penjualan.getTgl());
                penjualanpanel.getTxt_waktu().setText(penjualan.getWaktu());
                penjualanpanel.getTxt_user().setText(penjualan.getUserKasir());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tombolcari() {
        penjualan.setKodeStruk(penjualanpanel.getTxt_idStruk().getText());
        penjualan.setUserKasir(penjualanpanel.getTxt_user().getText());

        if (penjualan.getKodeStruk().equals("")) {
            penjualan.setKodeStruk("null");
        } else {
            penjualan.setKodeStruk("%" + penjualanpanel.getTxt_idStruk().getText() + "%");
        }
        if (penjualan.getUserKasir().equals("")) {
            penjualan.setUserKasir("null");
        } else {
            penjualan.setUserKasir("%" + penjualanpanel.getTxt_user().getText() + "%");
        }

        list = implementPenjualan.getCari(penjualan.getKodeStruk(), penjualan.getUserKasir());

        penjualanpanel.getTabelPenjualan().setModel(new tModelPenjualan(list));
        info("Data yang di Temukan " + list.size());

        komponen("cari");

    }

    public void tombolDetail() {
        detail.setStrukCode(penjualanpanel.getTxt_idStruk().getText().toString());
        new DetPenjualan().setVisible(true);
        penjualanpanel.setVisible(false);
    }

    public void tombolhapus() {
        penjualan.setKodeStruk(penjualanpanel.getTxt_idStruk().getText().toString());
        if (confirmation("Apakah Anda yakin akan menghapus dataini ?")) {
            if (implementPenjualan.delete(penjualan.getKodeStruk())) {
                info("Data Berhasil di Hapus");
                komponen("segarkan");
            } else {
                info("Data gagal di Hapus");
            }
        }

    }

    public void kembali() {
        new formAdmn().setVisible(true);
        penjualanpanel.setVisible(false);
    }
}
