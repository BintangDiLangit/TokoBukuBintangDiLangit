/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.login;
import com.buku.model.penjualan;
import com.buku.model.transaksi;
import com.buku.vw.kasir.formCetakStruk;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class cetakStrukCtr extends Cetak {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static formCetakStruk cetakpanel;
    private List<transaksi> list;
    private List<penjualan> list1;

    public cetakStrukCtr(formCetakStruk cetakpanel, List<transaksi> list, List<penjualan> list1) {
        this.cetakpanel = cetakpanel;

        this.list = list;
        this.list1 = list1;
        awal();
        lokasiform();

    }

    public void lokasiform() {
        int x = layar.width / 2 - cetakpanel.getSize().width / 2;
        int y = layar.height / 2 - cetakpanel.getSize().height / 2;
        cetakpanel.setLocation(x, y);
    }

    public void awal() {
        cetakpanel.getTampilan().setEditable(false);
        String tengah = "";
        setViewI("\n\t  \t" + login.getNamaToko() + "\n "
                + "=============================================\n"
                + list1.get(0).getTgl() + "\n"
                + list1.get(0).getWaktu() + "\n"
                + "=============================================\n");
        for (int i = 0; i < list.size(); i++) {
            if (tengah.equals("")) {
                tengah = list.get(i).getKodeBuku() + "\t" + list.get(i).getNama() + "\t\t" + list.get(i).getJumlah() + "\t" + list.get(i).getTotalHg() + "\n";
            } else {
                tengah += list.get(i).getKodeBuku() + "\t" + list.get(i).getNama() + "\t\t" + list.get(i).getJumlah() + "\t" + list.get(i).getTotalHg() + "\n";
            }

        }
        setViewM(tengah);
        setViewB(
                "=============================================\n"
                + "Total Bayar\t= " + list1.get(0).getTotalBayar() + "\n"
                + "Tunai  \t= " + list1.get(0).getUangBayar() + "\n"
                + "Kembalian  \t= " + list1.get(0).getUangKembalian() + "\n"
                + "=============================================\n");

        cetakpanel.getTampilan().setText(getViewI() + getViewM() + getViewB());
    }

    public void kembali() {
        cetakpanel.setVisible(false);
    }
}
