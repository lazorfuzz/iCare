/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class Medications {
    ArrayList <Medication> medicationList;

    /**
     * Constructor for the medications class.
     * @param medicationList sets the list of Medications
     */
    public Medications(ArrayList medicationList) {
        this.medicationList = medicationList;
    }
    
    /**
     * Constructor for the medications class.
     * @return An ArrayList of Medications.
     */
    public ArrayList<Medication> getMedicationList() {
        return medicationList;
    }
    
    /**
     * Constructor for the medications class.
     * @param medicationList sets the list of Medications.
     */
    public void setMedicationList(ArrayList<Medication> medicationList) {
        this.medicationList = medicationList;
    }
    
    
    
}
