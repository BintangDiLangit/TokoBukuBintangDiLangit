/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku;

/**
 *
 * @author BintangDiLangit
 */
public abstract class AbstractTableModel {
    public abstract int getRowCount();
    public abstract int getColumnCount();
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    public abstract String getColumnName(int column);
}
