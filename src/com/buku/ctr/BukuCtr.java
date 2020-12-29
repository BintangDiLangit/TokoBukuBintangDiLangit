/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.bukuDAO;
import com.buku.model.buku;
import com.buku.model.intrfc.intrfcBuku;
import com.buku.model.login;
import com.buku.vw.FormLogin;
import com.buku.vw.admin.Buku;
import com.buku.vw.admin.formAdmn;
import com.buku.model.tabel.tModBuku;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author BintangDiLangit
 */
public class BukuCtr extends Cetak {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<buku> list;
    private Buku bukupanel;
    private buku buku;
    private intrfcBuku intrfcBuku;
    private int databaru = 0;

    public BukuCtr(Buku bukupanel) {
        this.bukupanel = bukupanel;
        intrfcBuku = new bukuDAO();
        buku = new buku();
        if (login.getStatus().equals("aktif")) {
            lokasiform();
            isitabel();
            komponen("awal");
        } else {
            JOptionPane.showMessageDialog(null, "Anda belum login");
            new FormLogin().setVisible(true);
            this.bukupanel.setVisible(false);

        }

    }

    public void lokasiform() {
        int x = layar.width / 2 - bukupanel.getSize().width / 2;
        int y = layar.height / 2 - bukupanel.getSize().height / 2;
        bukupanel.setLocation(x, y);
    }

    public void komponen(String action) {
        switch (action) {
            case "awal":
                bukupanel.getBtn_cari().setEnabled(true);
                bukupanel.getBtn_databaru().setEnabled(true);
                bukupanel.getBtn_hapus().setEnabled(false);
                bukupanel.getBtn_ubah().setEnabled(false);
                break;
            case "cari":
                bukupanel.getBtn_cari().setEnabled(true);
                bukupanel.getBtn_databaru().setEnabled(false);
                bukupanel.getBtn_hapus().setEnabled(false);
                bukupanel.getBtn_ubah().setEnabled(false);
                break;
            case "segarkan":
                bukupanel.getBtn_cari().setEnabled(true);
                bukupanel.getBtn_databaru().setEnabled(true);
                bukupanel.getBtn_hapus().setEnabled(false);
                bukupanel.getBtn_ubah().setEnabled(false);
                bukupanel.getTxt_kodebuku().setEnabled(true);
                bukupanel.getTxt_kodebuku().setText(null);
                bukupanel.getTxt_nama().setText(null);
                bukupanel.getTxt_jenis().setText(null);
                bukupanel.getTxt_harga().setText(null);
                bukupanel.getTxt_stok().setText(null);
                databaru = 0;
                isitabel();
                break;

            case "simpan":
                bukupanel.getBtn_cari().setEnabled(true);
                bukupanel.getBtn_databaru().setEnabled(true);
                bukupanel.getBtn_hapus().setEnabled(false);
                bukupanel.getBtn_ubah().setEnabled(false);
                break;

            case "klik":
                bukupanel.getTxt_kodebuku().setEnabled(false);
                bukupanel.getBtn_cari().setEnabled(false);
                bukupanel.getBtn_databaru().setEnabled(false);
                bukupanel.getBtn_hapus().setEnabled(true);
                bukupanel.getBtn_ubah().setEnabled(true);
                databaru = 0;
                break;

            case "databaru":
                bukupanel.getBtn_cari().setEnabled(false);
                bukupanel.getBtn_databaru().setEnabled(true);
                bukupanel.getBtn_hapus().setEnabled(false);
                bukupanel.getBtn_ubah().setEnabled(false);
                bukupanel.getTxt_kodebuku().setEnabled(false);
                bukupanel.getTxt_kodebuku().setText(null);
                bukupanel.getTxt_nama().setText(null);
                bukupanel.getTxt_jenis().setText(null);
                bukupanel.getTxt_harga().setText(null);
                bukupanel.getTxt_stok().setText(null);
                break;

        }
    }

    public void isitabel() {
        list = intrfcBuku.getAll();
        bukupanel.getTabelbuku().setModel(new tModBuku(list));

    }

    public void kliktabel(java.awt.event.MouseEvent evt) {
        komponen("klik");

        try {

            int row = bukupanel.getTabelbuku().rowAtPoint(evt.getPoint());

            buku.setKodebuku(bukupanel.getTabelbuku().getValueAt(row, 0).toString());
            buku.setNama(bukupanel.getTabelbuku().getValueAt(row, 1).toString());
            buku.setJenis(bukupanel.getTabelbuku().getValueAt(row, 2).toString());
            buku.setHarga(bukupanel.getTabelbuku().getValueAt(row, 3).toString());
            buku.setStok(bukupanel.getTabelbuku().getValueAt(row, 4).toString());

            bukupanel.getTxt_kodebuku().setText(String.valueOf(buku.getKodebuku()));
            bukupanel.getTxt_nama().setText(String.valueOf(buku.getNama()));
            bukupanel.getTxt_jenis().setText(String.valueOf(buku.getJenis()));
            bukupanel.getTxt_harga().setText(String.valueOf(buku.getHarga()));
            bukupanel.getTxt_stok().setText(String.valueOf(buku.getStok()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tomboltambah() {

        buku.setKodebuku("BKU" + String.valueOf(intrfcBuku.jumlahData() + 1));

        if (databaru == 0) {
            komponen("databaru");
            JOptionPane.showMessageDialog(null, "Masukkan Data");
            databaru = 1;
            bukupanel.getTxt_kodebuku().setText(buku.getKodebuku());

        } else {
            buku.setKodebuku(bukupanel.getTxt_kodebuku().getText());
            buku.setNama(bukupanel.getTxt_nama().getText());
            buku.setJenis(bukupanel.getTxt_jenis().getText());
            buku.setHarga(bukupanel.getTxt_harga().getText());
            buku.setStok(bukupanel.getTxt_stok().getText());

            if (buku.getNama().equals("")) {
                warn("Maaf, Nama Buku belum diisi !");
                bukupanel.getTxt_nama().requestFocus();
            } else if (buku.getJenis().equals("")) {
                warn("Maaf, Jenis Buku belum diisi !");
                bukupanel.getTxt_jenis().requestFocus();
            } else if (buku.getHarga().equals("")) {
                warn("Maaf, Harga Buku belum diisi !");
                bukupanel.getTxt_harga().requestFocus();
            } else if (buku.getStok().equals("")) {
                warn("Maaf, Stok Buku belum diisi !");
                bukupanel.getTxt_stok().requestFocus();
            } else {
                if (intrfcBuku.insert(buku.getKodebuku(), buku.getNama(), buku.getJenis(), buku.getHarga(), buku.getStok())) {
                    info("Data Berhasil di tambahkan ");

                    databaru = 0;
                    komponen("segarkan");
                } else {
                    info("Data Gagal di tambahkan ");
                }

            }

        }
    }

    public void tombolhapus() {
        buku.setKodebuku(bukupanel.getTxt_kodebuku().getText());
        if (confirmation("Apakah Anda yakin akan menghapus data ini ?")) {
            if (intrfcBuku.delete(buku.getKodebuku())) {
                info("Data Telah Di Hapus");
                komponen("segarkan");
            } else {
                info("Data Gagal Di Hapus");
            }
        }

    }

    public void tombolKembali() {
        new formAdmn().setVisible(true);
        bukupanel.setVisible(false);

    }

    public void tombolrubah() {
        buku.setKodebuku(bukupanel.getTxt_kodebuku().getText());
        buku.setNama(bukupanel.getTxt_nama().getText());
        buku.setJenis(bukupanel.getTxt_jenis().getText());
        buku.setHarga(bukupanel.getTxt_harga().getText());
        buku.setStok(bukupanel.getTxt_stok().getText());

        if (buku.getNama().equals("")) {
            warn("Maaf, Nama Buku belum diisi !");
            bukupanel.getTxt_nama().requestFocus();
        } else if (buku.getJenis().equals("")) {
            warn("Maaf, Jenis Buku belum diisi !");
            bukupanel.getTxt_jenis().requestFocus();
        } else if (buku.getHarga().equals("")) {
            warn("Maaf, Harga Buku belum diisi !");
            bukupanel.getTxt_harga().requestFocus();
        } else if (buku.getStok().equals("")) {
            warn("Maaf, Stok Buku belum diisi !");
            bukupanel.getTxt_stok().requestFocus();
        } else {
            if (confirmation("Apakah Anda yakin akan merubah data ini ?")) {
                if (intrfcBuku.update(buku.getKodebuku(), buku.getNama(), buku.getJenis(), buku.getHarga(), buku.getStok())) {
                    info("Data berhasil diubah");
                    komponen("segarkan");
                } else {
                    info("Data gagal diubah");
                }
            }

        }

    }

    public void tombolcari() {

        if (bukupanel.getTxt_kodebuku().getText().equals("")) {
            buku.setKodebuku(null);
        } else {
            buku.setKodebuku("%" + bukupanel.getTxt_kodebuku().getText() + "%");
        }
        if (bukupanel.getTxt_nama().getText().equals("")) {
            buku.setNama(null);
        } else {
            buku.setNama("%" + bukupanel.getTxt_nama().getText() + "%");
        }
        if (bukupanel.getTxt_jenis().getText().equals("")) {
            buku.setJenis(null);
        } else {
            buku.setJenis("%" + bukupanel.getTxt_jenis().getText() + "%");
        }
        if (bukupanel.getTxt_harga().getText().equals("")) {
            buku.setHarga(null);
        } else {
            buku.setHarga("%" + bukupanel.getTxt_harga().getText() + "%");
        }
        if (bukupanel.getTxt_stok().getText().equals("")) {
            buku.setStok(null);
        } else {
            buku.setStok("%" + bukupanel.getTxt_stok().getText() + "%");
        }

        list = intrfcBuku.getCari(buku.getKodebuku(), buku.getNama(), buku.getJenis(), buku.getHarga(), buku.getStok());
        bukupanel.getTabelbuku().setModel(new tModBuku(list));
        info("Data yang di Temukan " + list.size());

        komponen("cari");

    }

}
