/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.tabel;

import com.buku.model.detail;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BintangDiLangit
 */
public class tModDetail extends AbstractTableModel{

    private List<detail> list;
    
    public tModDetail(List<detail> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int iR, int iC) {
        switch(iC){
            case 0:
                return list.get(iR).getKodeBuku();
            case 1:
                return list.get(iR).getNamaBuku();
            case 2:
                return list.get(iR).getHarga();
            case 3:
                return list.get(iR).getJumlah();
            case 4:
                return list.get(iR).getTotalHg();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col){
        switch (col){
            case 0:
                return "Kode Buku";
            case 1:
                return "Nama Buku";
            case 2:
                return "Harga";
            case 3:
                return "Jumlah";
            case 4:
                return "Total Harga";
            default:
                return null;
        }
    }
}
