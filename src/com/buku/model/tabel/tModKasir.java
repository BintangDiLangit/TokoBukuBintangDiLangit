/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.tabel;

import com.buku.model.user;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BintangDiLangit
 */
public class tModKasir extends AbstractTableModel {

    private List<user> list;
    public tModKasir(List<user> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int iR, int iC) {
        switch (iC){
            case 0:
                return list.get(iR).getUserId();
            case 1:
                return list.get(iR).getName();
            case 2:
                return list.get(iR).getTtl();
            case 3:
                return list.get(iR).getPwd();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col){
        switch (col){
            case 0:
                return "User ID";
            case 1:
                return "Nama";
            case 2:
                return "TTL";
            case 3:
                return "Password";
            default:
                return null;
        }
    }
    
}
