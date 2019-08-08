/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import com.google.gson.Gson;
import org.dizitart.no2.Nitrite;

/**
 *
 * @author leon
 */
public class DoctorController {
    Gson gson;
    Nitrite db;
    
    /**
     *
     */
    public DoctorController() {
        gson = new Gson();
    }
    
    public String getPatientsList(String doctorId) {
        return "";
    }
    
    /**
     *
     * @param db
     */
    public void setDb(Nitrite db) {
        this.db = db;
    }
}
