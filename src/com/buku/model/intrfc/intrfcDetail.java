package com.buku.model.intrfc;


import com.buku.model.detail;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BintangDiLangit
 */
public interface intrfcDetail {
    public List<detail> getAll(String kodeStruk);
    
    public int getJumlah(String kodeStruk);
}
