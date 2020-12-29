/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.DAO;

import com.buku.DB.ConnectDB;
import com.buku.model.buku;
import com.buku.model.intrfc.intrfcBuku;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class bukuDAO implements intrfcBuku{
    private List<buku> list;
    
    @Override
    public List<buku> getAll(){
        list = new ArrayList<buku>();
        try {
            PreparedStatement ps = ConnectDB.koneksiDB().prepareStatement(
            
            "SELECT * FROM buku");
            
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {                
                buku buku = new buku();
                buku.setKodebuku(res.getString("kodebuku"));
                buku.setNama(res.getString("nama_buku"));
                buku.setJenis(res.getString("jenis_buku"));
                buku.setHarga(res.getString("harga"));
                buku.setStok(res.getString("stok"));
                list.add(buku);
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int jumlahData(){
        int jumlah = 0;
        try {
            PreparedStatement st = ConnectDB.koneksiDB().prepareStatement(
            "SELECT MAX(bukuke) as jml FROM buku");
            
            ResultSet res = st.executeQuery();
            
            if (res.next()) {
                jumlah = res.getInt("jml");
            }
            return jumlah;
        } catch (Exception e) {
            e.printStackTrace();
            return jumlah;
        }
    }
    
    @Override
    public boolean insert(String kodeBk, String namaBk, String jenis, String harga, String stok){
        
        try {
            int buku_Ke = jumlahData() + 1;
            
            PreparedStatement st = ConnectDB.koneksiDB().prepareStatement(
            "INSERT INTO buku VALUES(?,?,?,?,?,?)");
            
            st.setString(1, kodeBk);
            st.setString(2, namaBk);
            st.setString(3, jenis);
            st.setString(4, harga);
            st.setString(5, stok);
            st.setInt(6, buku_Ke);
            
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String kodebuku) {
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "delete from buku where kodebuku =?");
            
            statement.setString(1, kodebuku);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(String kodeBk, String namaBk, String jenis, String harga, String stok) {
        try {
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "update buku set nama_buku = ? ,jenis_buku = ? ,harga = ? ,stok = ? where kodebuku = ?");
            
            statement.setString(1, namaBk);
            statement.setString(2, jenis);
            statement.setString(3, harga);
            statement.setString(4, stok);
            statement.setString(5, kodeBk);
            statement.executeUpdate();
       
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public List<buku> getCari(String kodeBk, String namaBk, String jenis, String harga, String stok) {
        list = new ArrayList<buku>();
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select* from buku where kodebuku like ?"
                    + " or nama_buku like ?"
                    + " or jenis_buku like ?"
                    + " or harga like ?"
                    + " or stok like ?");
            
            statement.setString(1, kodeBk);
            statement.setString(2, namaBk);
            statement.setString(3, jenis);
            statement.setString(4, harga);
            statement.setString(5, stok);
            
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                buku buku = new buku();
                buku.setKodebuku(result.getString("kodebuku"));
                buku.setNama(result.getString("nama_buku"));
                buku.setJenis(result.getString("jenis_buku"));
                buku.setHarga(result.getString("harga"));
                buku.setStok(result.getString("stok"));
                list.add(buku);

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    

}
