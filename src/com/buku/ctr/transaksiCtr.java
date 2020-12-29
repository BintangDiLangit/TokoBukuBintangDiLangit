/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.transaksiDAO;
import com.buku.model.intrfc.intrfcTransaksi;
import com.buku.model.login;
import com.buku.model.penjualan;
import com.buku.model.tabel.tModTransaksi;
import com.buku.model.transaksi;
import com.buku.vw.kasir.FormKasir;
import com.buku.vw.kasir.FormTabelKasir;
import com.buku.vw.kasir.formCetakStruk;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;

/**
 *
 * @author BintangDiLangit
 */
public class transaksiCtr extends Cetak {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static FormTabelKasir transaksipanel;
    private static intrfcTransaksi implementtransaksi;
    private List<String> listNama;
    private DefaultComboBoxModel modelcombo;
    private List<transaksi> listtransaksi;
    private List<penjualan> listpenjualan;
    private transaksi transaksi;
    private penjualan penjualan;
    private int baris = -1;

    public transaksiCtr(FormTabelKasir transaksipanel) {
        this.transaksipanel = transaksipanel;
        implementtransaksi = new transaksiDAO();
        listtransaksi = new ArrayList<>();
        transaksi = new transaksi();
        penjualan = new penjualan();
        listpenjualan = new ArrayList<>();

        lokasiform();
        tampilanawal();
        setwaktu();

    }

    public void lokasiform() {
        int x = layar.width / 2 - transaksipanel.getSize().width / 2;
        int y = layar.height / 2 - transaksipanel.getSize().height / 2;
        transaksipanel.setLocation(x, y);
    }

    public void tampilanawal() {
        listNama = new ArrayList<>();
        listNama = implementtransaksi.ambilNamaBuku();
        String[] listAray = listNama.toArray(new String[listNama.size()]);
        modelcombo = new DefaultComboBoxModel(listAray);
        transaksipanel.getCm_buku().setModel(modelcombo);
        transaksipanel.getTxt_kodekasir().setText(login.getUserId());
        transaksipanel.getTabeltransaksi().setModel(new tModTransaksi(listtransaksi));
        stok();
    }

    public void stok() {
        String barang = transaksipanel.getCm_buku().getSelectedItem().toString();
        transaksi.setStok(implementtransaksi.ambilStok(barang));
        transaksipanel.getTxt_stok().setText(transaksi.getStok());
    }

    private final void setwaktu() {
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jam = "", menit = "", detik = "";

                java.util.Date waktu = new java.util.Date();
                int jamsek = waktu.getHours();
                int menitsek = waktu.getMinutes();
                int detiksek = waktu.getSeconds();

                if (jamsek <= 9) {
                    jam = "0";
                }
                if (menitsek <= 9) {
                    menit = "0";
                }
                if (detiksek <= 9) {
                    detik = "0";
                }

                String jampas = jam + String.valueOf(jamsek);
                String menitpas = menit + String.valueOf(menitsek);
                String detikpas = detik + String.valueOf(detiksek);

                transaksipanel.getTxt_waktu().setText(jampas + ":" + menitpas + ":" + detikpas);
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    public void kembali() {
        new FormKasir().setVisible(true);
        transaksipanel.setVisible(false);

    }

    public void tomboltambahkan() {
        int stok = Integer.parseInt(transaksipanel.getTxt_stok().getText());
        int jumlah = Integer.parseInt(transaksipanel.getTxt_jumlah().getText());
        if (jumlah < stok) {
            transaksi.setNama(transaksipanel.getCm_buku().getSelectedItem().toString());
            transaksi.setJumlah(transaksipanel.getTxt_jumlah().getText());
            listtransaksi.addAll(implementtransaksi.getAll(transaksi.getNama(), transaksi.getJumlah()));
            transaksipanel.getTabeltransaksi().setModel(new tModTransaksi(listtransaksi));
            hitungan();
        } else {
            warn("Jumlah melebihi stok!!");

        }

    }

    public void hitungan() {
        int jumlah = 0;
        for (int i = 0; i < listtransaksi.size(); i++) {
            jumlah += Integer.parseInt(listtransaksi.get(i).getTotalHg());
        }
        transaksipanel.getTxt_totalharga().setText(String.valueOf(jumlah));

    }

    public void tombolhapus() {
        if (baris > -1) {
            listtransaksi.remove(baris);
            transaksipanel.getTabeltransaksi().setModel(new tModTransaksi(listtransaksi));
            baris = -1;
            hitungan();
        } else {
            info("Pilih barang yang akan di hapus");

        }

    }

    public void kliktabel(MouseEvent evt) {
        try {
            baris = transaksipanel.getTabeltransaksi().rowAtPoint(evt.getPoint());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tombolcetak() {
        if (transaksipanel.getCm_tanggal().getDate() == null) {
            warn("Maaf tanggal belum diisi !");
            transaksipanel.getCm_tanggal().requestFocus();
        } else if (transaksipanel.getTxt_jumlah().getText().equals("")) {
            warn("Maaf Jumlah belum diisi !");
            transaksipanel.getTxt_jumlah().requestFocus();
        } else if (transaksipanel.getTxt_tunai().getText().equals("")) {
            warn("Maaf Tunai belum diisi !");
            transaksipanel.getTxt_tunai().requestFocus();
        } else if (transaksipanel.getTxt_kembali().getText().equals("")) {
            warn("Maaf Kembalian belum diisi !");
            transaksipanel.getTxt_kembali().requestFocus();
        } else {

            SimpleDateFormat format = new SimpleDateFormat("MM/d/yyyy");
            penjualan.setKodeStruk("STR" + String.valueOf(implementtransaksi.jumlahData() + 1));
            penjualan.setTgl(format.format(transaksipanel.getCm_tanggal().getDate()));
            penjualan.setWaktu(transaksipanel.getTxt_waktu().getText());
            penjualan.setTotalBayar(transaksipanel.getTxt_totalharga().getText());
            penjualan.setUangBayar(transaksipanel.getTxt_tunai().getText());
            penjualan.setUangKembalian(transaksipanel.getTxt_kembali().getText());
            penjualan.setUserKasir(login.getUserId());

            listpenjualan.add(penjualan);
            implementtransaksi.insertStruk(penjualan.getKodeStruk(), penjualan.getTgl(), penjualan.getWaktu(), penjualan.getUserKasir(), penjualan.getTotalBayar(), penjualan.getUangBayar(), penjualan.getUangKembalian());

            for (int i = 0; i < listtransaksi.size(); i++) {
                transaksi.setJumlah(listtransaksi.get(i).getJumlah());
                transaksi.setTotalHg(listtransaksi.get(i).getTotalHg());
                transaksi.setKodeBuku(listtransaksi.get(i).getKodeBuku());

                implementtransaksi.insertDetail(transaksi.getJumlah(), transaksi.getTotalHg(), transaksi.getKodeBuku(), penjualan.getKodeStruk());

            }

            new formCetakStruk(listtransaksi, listpenjualan).setVisible(true);
            listtransaksi = new ArrayList<>();
            transaksi = new transaksi();
            penjualan = new penjualan();
            listpenjualan = new ArrayList<>();
            transaksipanel.getCm_tanggal().setDate(null);
            transaksipanel.getTxt_jumlah().setText(null);
            transaksipanel.getTxt_totalharga().setText(null);
            transaksipanel.getTxt_tunai().setText(null);
            transaksipanel.getTxt_kembali().setText(null);
            transaksipanel.getTabeltransaksi().setModel(new tModTransaksi(listtransaksi));
        }

    }

    public void jumlahuangkembali() {
        penjualan.setTotalBayar(transaksipanel.getTxt_totalharga().getText());
        penjualan.setUangBayar(transaksipanel.getTxt_tunai().getText());
        int jumlah = Integer.parseInt(penjualan.getUangBayar()) - Integer.parseInt(penjualan.getTotalBayar());
        transaksipanel.getTxt_kembali().setText(String.valueOf(jumlah));
    }
}
