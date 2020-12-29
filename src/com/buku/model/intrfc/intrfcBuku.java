/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.intrfc;

import com.buku.model.buku;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public interface intrfcBuku {
    public List<buku> getAll();
    
    public boolean insert(String kodeBk, String namaBk, String jenis, String harga, String stok);
    
    public boolean delete(String kodebuku);
    
    public boolean update(String kodeBk, String namaBk, String jenis, String harga, String stok);
    
    public List<buku> getCari(String kodeBk, String namaBk, String jenis, String harga, String stok);
    
    public int jumlahData();
}
