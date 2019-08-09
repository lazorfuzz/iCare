/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

/**
 *
 * @author leon
 */
public class Medication {
    String name;
    int dosage;
    String measurementUnit;
    Boolean isPrescription;
    int count;
    
    public Medication(String name, int dosage, String measurementUnit, Boolean isPrescription, int count) {
        this.name = name;
        this.dosage = dosage;
        this.measurementUnit = measurementUnit;
        this.isPrescription = isPrescription;
        this.count = count;
    }
}
