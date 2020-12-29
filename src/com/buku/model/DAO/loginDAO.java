/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.DAO;

import com.buku.DB.ConnectDB;
import com.buku.model.intrfc.intrfcLogin;
import com.buku.model.login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BintangDiLangit
 */
public class loginDAO implements intrfcLogin{
     @Override
    public boolean sbgAdmin(String userid, String pass) {
       
        try {

            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select useradmin, password from admin where useradmin = ? and password = ?");
            statement.setString(1, userid);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            
            if (result.next()){
                login.setUserId(userid);
                login.setPass(pass);
                login.setPart("admin");
                login.setStatusLog("aktif");
                return true;      
            
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
     @Override
    public boolean sbgKasir(String userid, String pass) {
       
        try {

            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select userkasir, password from kasir where userkasir = ? and password = ?");
            statement.setString(1, userid);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            
            if (result.next()){
                login.setPart("kasir");
                return true;      
            
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
