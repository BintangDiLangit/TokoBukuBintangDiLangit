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
import com.buku.vw.admin.Buku;
import com.buku.vw.admin.Kasir;
import com.buku.vw.admin.Penjualan;
import com.buku.vw.admin.formAdmn;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class adminCtr extends Cetak{
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static formAdmn adminpanel;
    private static intrfcUser implementuser;
    private user user;
    private List<user> list;

    public adminCtr(formAdmn adminpanel) {
        this.adminpanel = adminpanel;
        implementuser = new userDAO();
        user = new user();
        if (login.getStatus().equals("aktif")) {
            lokasiform();
            tampilanawal();
        } else {
            warn("Anda belum login");
            new FormLogin().setVisible(true);
            this.adminpanel.setVisible(false);
        }

    }

    public void lokasiform() {
        int x = layar.width / 2 - adminpanel.getSize().width / 2;
        int y = layar.height / 2 - adminpanel.getSize().height / 2;
        adminpanel.setLocation(x, y);
    }

    public void tampilanawal() {
        list = implementuser.dataUser(login.userId);

        adminpanel.getTxt_userid().setText(list.get(0).getUserId());
        adminpanel.getTxt_nama().setText(list.get(0).getName());
        adminpanel.getTxt_tanggallahir().setText(list.get(0).getTtl());
        adminpanel.getTxt_pass().setText(list.get(0).getPwd());
        adminpanel.getTxt_pass().setEnabled(false);
    }

    public void tombollihatkasir() {
        new Kasir().setVisible(true);
        adminpanel.setVisible(false);
    }

    public void tombollihatbuku() {
        new Buku().setVisible(true);
        adminpanel.setVisible(false);
    }

    public void logout() {
        login.logout();
        new FormLogin().setVisible(true);
        adminpanel.setVisible(false);

    }

    public void lihatpass() {
        user.setPwd(adminpanel.getTxt_pass().getText());
        info("Password anda : " + user.getPwd());
    }

    public void rubahpass() {
        new FormUbahPass().setVisible(true);
        adminpanel.setVisible(false);
    }

    public void keluar() {
        if(confirmation("Apakan Anda yakin ingin keluar ?")){
            System.exit(0);
        }
    }

    public void tombollihatpenjualan() {
        new Penjualan().setVisible(true);
        adminpanel.setVisible(false);
    }

    public void tombolrubahprofile() {
        user.setUserId(adminpanel.getTxt_userid().getText());
        user.setName(adminpanel.getTxt_nama().getText());
        user.setTtl(adminpanel.getTxt_tanggallahir().getText());

        if (implementuser.rubahProf(user.getUserId(), user.getName(), user.getTtl())) {
            info("Profile telah di Ubah");
        } else {
            info("Gagal Ubah Profile");
        }
    }
}
