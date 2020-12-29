/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.intrfc;

import com.buku.model.penjualan;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public interface intrfcPenjualan {
    public List<penjualan> getAllpenjualan();
    
    public List<penjualan> getCari(String idStruk,String userKasir);
    
    public boolean delete(String kodeBk);
    
    
}
