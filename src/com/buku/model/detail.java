/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model;

/**
 *
 * @author BintangDiLangit
 */
public class detail {
    private static String strukCode;
    private String namaBuku;
    private String kodeBuku;
    private String harga;
    private String jumlah;
    private String totalHg;

    public static String getStrukCode() {
        return strukCode;
    }

    public static void setStrukCode(String strukCode) {
        detail.strukCode = strukCode;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTotalHg() {
        return totalHg;
    }
    
    public void setTotal(){
        int jumlah = Integer.parseInt(this.harga) * Integer.parseInt(this.jumlah);
        this.totalHg = String.valueOf(jumlah);
    }

    public void setTotalHg(String totalHg) {
        this.totalHg = totalHg;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    
    
}
