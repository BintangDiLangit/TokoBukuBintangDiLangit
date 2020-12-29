/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.model.intrfc;

import com.buku.model.user;
import java.util.List;

/**
 *
 * @author BintangDiLangit
 */
public interface intrfcUser {
    
    public List<user> dataUser(String userId);
    
    public boolean rubahProf(String userId, String nama, String ttl);
}
