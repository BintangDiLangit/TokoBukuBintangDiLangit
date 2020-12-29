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
public class transaksi {
    private String nama;
    private String kodeBuku;
    private String harga;
    private String jenis;
    private String jumlah;
    private String totalHg;
    private String stok;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTotalHg() {
        return totalHg;
    }

    public void setTotalHg() {
        int total = Integer.parseInt(this.harga) * Integer.parseInt(this.jumlah);
        this.totalHg = String.valueOf(total);
    }
    public void setTotalHg(String totalHg) {
        this.totalHg = totalHg;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }
    
}
