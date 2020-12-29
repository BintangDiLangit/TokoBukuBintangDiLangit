/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.intrfc;

import com.buku.model.user;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public interface intrfcKasir { 
    
    public List<user> getAllKasir();
    
    public List<user> getCari(String userKasir, String nama, String ttl, String pass);
    
    public boolean insert(String userKasir, String nama, String ttl, String pass);
    
    public int jumlahData();
    
    public boolean delete(String userId);
    
    public boolean update(String userKasir, String nama, String ttl, String pass);
}
