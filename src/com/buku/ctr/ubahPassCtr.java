/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.UbahPassDAO;
import com.buku.model.intrfc.intrfcUbahPass;
import com.buku.model.login;
import com.buku.vw.FormLogin;
import com.buku.vw.FormUbahPass;
import com.buku.vw.admin.formAdmn;
import com.buku.vw.kasir.FormKasir;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author BintangDiLangit
 */
public class ubahPassCtr extends Cetak{
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static FormUbahPass rubahpanel;
    private static intrfcUbahPass implementrubah;

    public ubahPassCtr(FormUbahPass rubahpanel) {
        this.rubahpanel = rubahpanel;
        implementrubah = new UbahPassDAO();

        if (login.getStatus().equals("aktif")) {
            lokasiform();
            this.rubahpanel.getTxtUser().setText(login.userId);
        } else {
            warn("Anda belum login");
            new FormLogin().setVisible(true);
            this.rubahpanel.setVisible(false);
        }
    }

    public void lokasiform() {
        int x = layar.width / 2 - rubahpanel.getSize().width / 2;
        int y = layar.height / 2 - rubahpanel.getSize().height / 2;
        rubahpanel.setLocation(x, y);
    }

    public void rubah() {
        if (rubahpanel.getPwnew().getText().equals(rubahpanel.getPwCon().getText())) {
            if (confirmation("Apakah Anda yakin akan Mengubah dataini ?")) {
                if (implementrubah.ubahPass(rubahpanel.getTxtUser().getText(), rubahpanel.getPwnew().getText())) {
                    if (login.part.equals("admin")) {
                        new formAdmn().setVisible(true);
                        rubahpanel.setVisible(false);
                    } else if (login.part.equals("kasir")) {
                        new FormKasir().setVisible(true);
                        rubahpanel.setVisible(false);
                    }
                } else {
                    warn("Periksa Kembali Password Anda");
                }
            }
        }
    }

    public void kembali() {
        new formAdmn().setVisible(true);
        rubahpanel.setVisible(false);
    }
}
