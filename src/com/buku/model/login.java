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
public class login {
    public static String pass;
    public static String statusLog;
    public static String part;
    public static String userId;
    public static String namaToko = "BintangDiLangit";

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        login.pass = pass;
    }

    public static String getStatusLog() {
        return statusLog;
    }

    public static void setStatusLog(String statusLog) {
        login.statusLog = statusLog;
    }

    public static String getPart() {
        return part;
    }

    public static void setPart(String part) {
        login.part = part;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        login.userId = userId;
    }

    public static String getNamaToko() {
        return namaToko;
    }

    
    public static void logout(){
        login.setStatusLog(null);
        login.setUserId(null);
        login.setPart(null);
        login.setPass(null);
    }

    public static Object getStatus() {
        return statusLog;
    }
    
}
