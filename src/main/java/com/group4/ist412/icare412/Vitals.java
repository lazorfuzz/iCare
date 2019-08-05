/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import java.util.HashMap;

/**
 *
 * @author adam
 */
public class Vitals {
    
    private double bodyTemp, bmi, weight, height, bpSystolic, bpDiastolic, respRate, pulseBPM;  
    private String email;
    /**
     * This is the constructor for the vitals class
     * @param email The patient's email
     * @param bodyTemp The patient's body temperature in Fahrenheit
     * @param weight The patient's weight in kilograms.
     * @param height The patient's height in centimeters.
     * @param bpSystolic This is the systolic(top) blood pressure number.
     * @param bpDiastolic This sis the diastolic(bottom) blood pressure number.
     * @param respRate This is the patient's respiration rate (breaths per minute).
     * @param pulseBPM This is the patient's pulse (beats per minute).
     */
    public Vitals(String email, double bodyTemp,double weight, double height, double bpSystolic, double bpDiastolic, double respRate, double pulseBPM) {
        
        this.email = email;
        this.bodyTemp = bodyTemp;
        this.weight = weight;
        this.height = height;
        //Removed BMI from constructor due to it being calculated in it's own method using height & weight
        this.bpSystolic = bpSystolic;//added by WS
        this.bpDiastolic = bpDiastolic;//added by WS
        this.respRate = respRate;//added by WS
        this.pulseBPM = pulseBPM;//added by WS
    }

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weightLB) {
        this.weight = weightLB;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBpSystolic() {
        return bpSystolic;
    }

    public void setBpSystolic(double bpSystolic) {
        this.bpSystolic = bpSystolic;
    }

    public double getBpDiastolic() {
        return bpDiastolic;
    }

    public void setBpDiastolic(double bpDiastolic) {
        this.bpDiastolic = bpDiastolic;
    }

    public double getRespRate() {
        return respRate;
    }

    public void setRespRate(double respRate) {
        this.respRate = respRate;
    }

    public double getPulseBPM() {
        return pulseBPM;
    }

    public void setPulseBPM(double pulseBPM) {
        this.pulseBPM = pulseBPM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
}
