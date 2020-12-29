/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.tabel;

import com.buku.model.penjualan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BintangDiLangit
 */
public class tModelPenjualan extends AbstractTableModel{
    private List<penjualan> list;
    
    public tModelPenjualan(List<penjualan> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int iR, int iC) {
        switch (iC){
            case 0:
                return list.get(iR).getKodeStruk();
            case 1:
                return list.get(iR).getTgl();
            case 2:
                return list.get(iR).getWaktu();
            case 3:
                return list.get(iR).getTotalBayar();
            case 4:
                return list.get(iR).getUangBayar();
            case 5:
                return list.get(iR).getUangKembalian();
            case 6:
                return list.get(iR).getUserKasir();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Kode Struk";
            case 1:
                return "Tanggal";
            case 2:
                return "Waktu";
            case 3:
                return "Total Bayar";
            case 4:
                return "Tunai";
            case 5:
                return "Uang Kembali";
            case 6:
                return "User Kasir";
            default:
                return null;
        }
    }
}
