/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.tabel;

import com.buku.model.transaksi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BintangDiLangit
 */
public class tModTransaksi extends AbstractTableModel{
    private List<transaksi> list;

    public tModTransaksi(List<transaksi> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKodeBuku();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getJenis();
            case 3:
                return list.get(rowIndex).getHarga();
            case 4:
                return list.get(rowIndex).getJumlah();
            case 5:
                return list.get(rowIndex).getTotalHg();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Buku";
            case 1:
                return "Nama";
            case 2:
                return "Jenis";
            case 3:
                return "Harga";
            case 4:
                return "Jumlah";
            case 5:
                return "Total Harga";
            default:
                return null;
        }
    }
}
