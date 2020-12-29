/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.detDao;
import com.buku.model.detail;
import com.buku.model.intrfc.intrfcDetail;
import com.buku.model.login;
import com.buku.model.tabel.tModDetail;
import com.buku.vw.FormLogin;
import com.buku.vw.admin.DetPenjualan;
import com.buku.vw.admin.Penjualan;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author odading
 */
public class DetailCtr extends Cetak{
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<detail> list;
    private static DetPenjualan detailpanel;
    private static intrfcDetail intrfcdetail;

    public DetailCtr(DetPenjualan detailpanel) {
        this.detailpanel = detailpanel;
        intrfcdetail = new detDao();
        if (login.getStatus().equals("aktif")) {
            lokasiform();
            isitabel();
            awal();
        } else {
            warn("Anda belum login");
            new FormLogin().setVisible(true);
            this.detailpanel.setVisible(false);
        }

    }

    public void lokasiform() {
        int x = layar.width / 2 - detailpanel.getSize().width / 2;
        int y = layar.height / 2 - detailpanel.getSize().height / 2;
        detailpanel.setLocation(x, y);
    }

    public void awal() {
        int jumlah = intrfcdetail.getJumlah(detail.getStrukCode());
        detailpanel.getTxt_kodestruk().setText(detail.getStrukCode());
        detailpanel.getTxt_jumlah_harga().setText(String.valueOf(jumlah));

    }

    public void isitabel() {

        list = intrfcdetail.getAll(detail.getStrukCode());
        detailpanel.getTabelDetail().setModel(new tModDetail(list));

    }

    public void tombolkembali() {
        new Penjualan().setVisible(true);
        detailpanel.setVisible(false);
        detail.setStrukCode(null);
    }
}
