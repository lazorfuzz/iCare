/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

/**
 *
 * @author adam
 */


class Medication {
    private String medName;
    private double quantity;
    private String medQuantityUnit;
    private int frequency;
    private String frequencyTakenUnit;
    
    
    public Medication() {
        
    }
    
    /**
     * Gets the medication name.
     */
    public String getMedName() {
        return medName;
    }
    
    /**
     * Sets the medication name.
     * @param medName name of the medicine.
     */
    public void setMedName(String medName) {
        this.medName = medName;
    }
    
    /**
     * Gets medication quantity.
     */
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Gets medication quantity unit.
     */
    public String getMedQuantityUnit() {
        return medQuantityUnit;
    }
    
    /**
     * Sets the medication quantity unit.
     * @param medQuantityUnit Sets the quantity unit to use to measure the medication.
     */
    public void setMedQuantityUnit(String medQuantityUnit) {
        this.medQuantityUnit = medQuantityUnit;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getFrequencyTakenUnit() {
        return frequencyTakenUnit;
    }

    public void setFrequencyTakenUnit(String frequencyTakenUnit) {
        this.frequencyTakenUnit = frequencyTakenUnit;
    }
    
}
