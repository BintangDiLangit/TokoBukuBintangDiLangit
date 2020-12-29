/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.DAO;

import com.buku.DB.ConnectDB;
import com.buku.model.intrfc.intrfcUbahPass;
import java.sql.PreparedStatement;

/**
 *
 * @author BintangDiLangit
 */
public class UbahPassDAO implements intrfcUbahPass{
    @Override
    public boolean ubahPass(String userid, String passbaru) {
       
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "update admin set password = ? where useradmin = ?");
            
            statement.setString(1, passbaru);
            statement.setString(2, userid);
            statement.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return false;
    }
}
