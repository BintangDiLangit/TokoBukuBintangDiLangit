/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.DAO;

import com.buku.DB.ConnectDB;
import com.buku.model.intrfc.intrfcKasir;
import com.buku.model.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class kasirDAO implements intrfcKasir{
     private List<user> list;

    @Override
    public List<user> getAllKasir() {
        list = new ArrayList<user>();
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select userkasir, nama ,ttl , password from kasir ORDER BY userkasir");
            
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                user user = new user();
                user.setUserId(result.getString("userkasir"));
                user.setName(result.getString("nama"));
                user.setTtl(result.getString("ttl"));
                user.setPwd(result.getString("password"));
                list.add(user);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<user> getCari(String userkasir, String nama, String ttl, String pass) {
        list = new ArrayList<user>();
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select* from kasir "
                    + "where userkasir like ? "
                    + "or nama like ? "
                    + "or ttl like ? "
                    + "or password like ?");
            
            statement.setString(1, userkasir);
            statement.setString(2, nama);
            statement.setString(3, ttl);
            statement.setString(4, pass);
            
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                user user = new user();
                user.setUserId(result.getString("userkasir"));
                user.setName(result.getString("nama"));
                user.setTtl(result.getString("ttl"));
                user.setPwd(result.getString("password"));
                list.add(user);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int jumlahData() {
        int jumlah = 0;
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "SELECT max(kasirke) as jumlah FROM kasir");
            
            ResultSet result = statement.executeQuery();
            
            if (result.next()){
                jumlah = result.getInt("jumlah");      
            }
          
            return jumlah;
        } catch (Exception e) {
            e.printStackTrace();
            return jumlah;
        }

    }

    @Override
    public boolean insert(String userkasir, String nama, String ttl, String pass) {
        try {
            int kasirke = jumlahData() + 1;
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "insert into kasir values (?,?,?,?,?)");
      
            statement.setString(1, userkasir);
            statement.setString(2, nama);
            statement.setString(3, ttl);
            statement.setString(4, pass);
            statement.setInt(5, kasirke);
            statement.executeUpdate();
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String userid) {
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "delete from kasir where userkasir =?");
            
            statement.setString(1, userid);
            
            statement.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(String userkasir, String nama, String ttl, String pass) {
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "update kasir set nama = ?, ttl = ?, password = ? where userkasir = ?");
            
            statement.setString(1, nama);
            statement.setString(2, ttl);
            statement.setString(3, pass);
            statement.setString(4, userkasir);
            statement.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }
}
