/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.DAO;

import com.buku.DB.ConnectDB;
import com.buku.model.intrfc.intrfcTransaksi;
import com.buku.model.transaksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public class transaksiDAO implements intrfcTransaksi{
    private List<String> list;
    private List<transaksi> listtransaksi;
    
    @Override
    public List<String> ambilNamaBuku() {
        list = new ArrayList<String>();
        try {
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select nama_buku from buku");
            
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                list.add(result.getString("nama_buku"));
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    @Override
    public List<transaksi> getAll(String namabuku, String jumlah){
        listtransaksi = new ArrayList<transaksi>();
        try {
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select* from buku where nama_buku = '"+namabuku+"'");
            
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                transaksi transaksi = new transaksi();
                transaksi.setKodeBuku(result.getString("kodebuku"));
                transaksi.setNama(result.getString("nama_buku"));
                transaksi.setJenis(result.getString("jenis_buku"));
                transaksi.setHarga(result.getString("harga"));
                transaksi.setJumlah(jumlah);
                transaksi.setTotalHg();
                listtransaksi.add(transaksi);
            }

            return listtransaksi;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    
    }

    @Override
    public int jumlahData() {     
        int jumlah = 0;
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "SELECT max(strukke) as jumlah FROM struk");
            
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
    public void insertStruk(String kodestruk, String tanggal, String waktu, String userkasir, String totalbayar, String uangbayar, String uangkembali) {
        try {
            
            int bukuke = jumlahData() + 1;
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "insert into struk values (?,?,?,?,?,?,?,?)");
            
            statement.setString(1, kodestruk);
            statement.setString(2, tanggal);
            statement.setString(3, waktu);
            statement.setString(4, totalbayar);
            statement.setString(5, uangbayar);
            statement.setString(6, uangkembali);
            statement.setString(7, userkasir);
            statement.setInt(8, bukuke);
            statement.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void insertDetail(String jumlah, String totalharga, String kodebuku, String kodestruk) {
        try {
            
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "insert into detail_struck values (null, ?,?,?,?)");
            
            statement.setString(1, jumlah);
            statement.setString(2, totalharga);
            statement.setString(3, kodebuku);
            statement.setString(4, kodestruk);
            
            statement.executeUpdate();
            
            statement = ConnectDB.koneksiDB().prepareStatement(
            "update buku set stok = stok - ? where kodebuku = ?");
            
            
            statement.setString(1, jumlah);
            statement.setString(2, kodebuku);
            statement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public String ambilStok(String namabarang) {
        try {
            PreparedStatement statement = ConnectDB.koneksiDB().prepareStatement(
            "select stok from buku where nama_buku = '"+namabarang+"'");
            
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                transaksi tr = new transaksi();
                tr.setStok(result.getString("stok"));
                return tr.getStok();
            }

             

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
