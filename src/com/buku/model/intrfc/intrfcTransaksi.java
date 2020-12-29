/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.intrfc;

import com.buku.model.transaksi;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public interface intrfcTransaksi {
    
    public List<String> ambilNamaBuku();
    
    public List<transaksi> getAll(String kodeBk,String jumlah);
    
    public int jumlahData();
    
    public void insertStruk(String kodeStruk, String tanggal, String waktu, String userKasir, String totalBayar, String uangBayar, String uangKembalian);
    
    public void insertDetail(String jumlah, String totalHarga, String kodeBk, String kodeStruk);
    
    public String ambilStok(String namaBarang);
}
