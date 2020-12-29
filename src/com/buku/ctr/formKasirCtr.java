/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.userDAO;
import com.buku.model.intrfc.intrfcUser;
import com.buku.model.login;
import com.buku.model.user;
import com.buku.vw.FormLogin;
import com.buku.vw.FormUbahPass;
import com.buku.vw.kasir.FormKasir;
import com.buku.vw.kasir.FormTabelKasir;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class formKasirCtr extends Cetak {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static FormKasir kasirpanel;
    private static intrfcUser implementuser;
    private user user;
    private List<user> list;

    public formKasirCtr(FormKasir kasirpanel) {
        this.kasirpanel = kasirpanel;
        implementuser = new userDAO();
        user = new user();
        lokasiform();
        tampilanawal();

    }

    public void lokasiform() {
        int x = layar.width / 2 - kasirpanel.getSize().width / 2;
        int y = layar.height / 2 - kasirpanel.getSize().height / 2;
        kasirpanel.setLocation(x, y);
    }

    public void tampilanawal() {
        list = implementuser.dataUser(login.userId);

        kasirpanel.getTxt_userid().setText(list.get(0).getUserId());
        kasirpanel.getTxt_nama().setText(list.get(0).getName());
        kasirpanel.getTxt_tanggallahir().setText(list.get(0).getTtl());
        kasirpanel.getTxt_pass().setText(list.get(0).getPwd());
        kasirpanel.getTxt_pass().setEnabled(false);
    }

    public void logout() {
        login.logout();
        new FormLogin().setVisible(true);
        kasirpanel.setVisible(false);

    }

    public void lihatpass() {
        user.setPwd(kasirpanel.getTxt_pass().getText());
        info("Password anda : " + user.getPwd());
    }

    public void rubahpass() {
        new FormUbahPass().setVisible(true);
        kasirpanel.setVisible(false);
    }

    public void keluar() {
        if (confirmation("Apakan Anda yakin ingin keluar ?")) {
            System.exit(0);
        }
    }

    public void tombolkasir() {
        new FormTabelKasir().setVisible(true);
        kasirpanel.setVisible(false);
    }
}
