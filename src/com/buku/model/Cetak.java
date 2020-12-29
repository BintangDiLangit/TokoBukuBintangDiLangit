/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model;

import javax.swing.JOptionPane;

/**
 *
 * @author BintangDiLangit
 */
public class Cetak {
    private String viewI;
    private String viewM;
    private String viewB;

    protected String getViewI() {
        return viewI;
    }

    protected void setViewI(String viewI) {
        this.viewI = viewI;
    }

    protected String getViewM() {
        return viewM;
    }

    protected void setViewM(String viewM) {
        this.viewM = viewM;
    }

    protected String getViewB() {
        return viewB;
    }

    protected void setViewB(String viewB) {
        this.viewB = viewB;
    }
    
    protected void warn (String message){
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    protected void info (String message){
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    protected boolean confirmation (String message){
        if (JOptionPane.showConfirmDialog(null, message, "Warning",2) == JOptionPane.YES_OPTION) {
            return true;
            
        }
        return false;
    }
}
