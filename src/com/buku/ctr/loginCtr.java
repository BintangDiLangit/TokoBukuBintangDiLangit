/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.ctr;

import com.buku.model.Cetak;
import com.buku.model.DAO.loginDAO;
import com.buku.model.intrfc.intrfcLogin;
import com.buku.model.login;
import com.buku.vw.FormLogin;
import com.buku.vw.admin.formAdmn;
import com.buku.vw.kasir.FormKasir;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author BintangDiLangit
 */
public class loginCtr extends Cetak{
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static FormLogin loginPanel;
    private static intrfcLogin implementLogin;

    public loginCtr(FormLogin loginPanel) {
        this.loginPanel = loginPanel;
        implementLogin = new loginDAO();
        lokasiform();
        loginPanel.gettxt_Title().setText(login.getNamaToko());
    }
    
    public void lokasiform(){
        int x = layar.width / 2  -loginPanel.getSize().width / 2;
        int y = layar.height / 2 - loginPanel.getSize().height / 2;
        loginPanel.setLocation(x, y);
    }
    
    public void masuk(){
        login.setUserId(loginPanel.getUserText().getText());
        login.setPass(loginPanel.getPassTxt().getText());
        
        if(implementLogin.sbgAdmin(login.getUserId(), login.getPass())){
            JOptionPane.showMessageDialog(null, "Anda Login sebagai Admin");
            new formAdmn().setVisible(true);
            loginPanel.setVisible(false);
        }else if(implementLogin.sbgKasir(login.getUserId(), login.getPass())){
            JOptionPane.showMessageDialog(null, "Anda Login sebagai kasir");
            new FormKasir().setVisible(true);
            loginPanel.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Periksa Kembali User dan Password");
            login.setUserId(null);
            login.setPass(null);
        }
    
    }
    
    public void keluar() {
        if (confirmation("Apakah Anda Yakin Keluar ?")) {
            System.exit(0);
        }
        
    }
}
