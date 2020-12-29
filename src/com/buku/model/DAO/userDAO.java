/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.DAO;

import com.buku.DB.ConnectDB;
import com.buku.model.intrfc.intrfcUser;
import com.buku.model.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class userDAO implements intrfcUser{
    private List<user> list;

    @Override
    public List<user> dataUser(String userid) {
        list = new ArrayList<user>();
        try {
            user user= new user();

            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) ConnectDB.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select* from admin where useradmin='" + userid + "'");
            Statement stmt1 = conn.createStatement();
            ResultSet result1 = stmt1.executeQuery("select* from kasir where userkasir='" + userid + "'");

            if (result.next()) {
                user.setUserId(result.getString("useradmin"));
                user.setName(result.getString("nama"));
                user.setTtl(result.getString("ttl"));
                user.setPwd(result.getString("password"));
                list.add(user);
                return list;
                
            } else if (result1.next()) {
                user.setUserId(result1.getString("userkasir"));
                user.setName(result1.getString("nama"));
                user.setTtl(result1.getString("ttl"));
                user.setPwd(result1.getString("password"));
                list.add(user);
                return list;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }

    @Override
    public boolean rubahProf(String userid, String nama, String ttl) {
        try {
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "update admin set nama = ? ,ttl  = ? where useradmin = ?");
            
            statement.setString(1, nama);
            statement.setString(2, ttl);
            statement.setString(3, userid);
            statement.executeUpdate();
       
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
