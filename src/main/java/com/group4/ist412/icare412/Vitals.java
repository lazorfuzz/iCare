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
    
    private double bodyTempF, bmi, weightLB, heightFT, bpSystolic, bpDiastolic, respRate, pulseBPM;  
    private String email;
    /**
     * This is the constructor for the vitals class
     * @param bodyTempF The patient's body temperature in Fahrenheit.
     * @param weightLB The patient's weight in pounds.
     * @param heightFT The patient's height in feet.
     * @param bpSystolic This is the systolic(top) blood pressure number.
     * @param bpDiastolic This sis the diastolic(bottom) blood pressure number.
     * @param respRate This is the patient's respiration rate (breaths per minute).
     * @param pulseBPM This is the patient's pulse (beats per minute).
     */
    public Vitals(String email, double bodyTempF,double weightLB, double heightFT, double bpSystolic, double bpDiastolic, double respRate, double pulseBPM) {
        
        this.email=email;
        
        this.bodyTempF = bodyTempF;
        this.weightLB = weightLB;
        this.heightFT = heightFT;
        //Removed BMI from constructor due to it being calculated in it's own method using height & weight
        this.bpSystolic = bpSystolic;//added by WS
        this.bpDiastolic = bpDiastolic;//added by WS
        this.respRate = respRate;//added by WS
        this.pulseBPM = pulseBPM;//added by WS
    }

    public double getBodyTempF() {
        return bodyTempF;
    }

    public void setBodyTempF(double bodyTempF) {
        this.bodyTempF = bodyTempF;
    }
/**********************Commented out get & set BMI due to BMI being calculated in its own method
//    public double getBmi() {
//        return bmi;
//    }
//
//    public void setBmi(double bmi) {
//        this.bmi = bmi;
//    }
*/

    public double getWeightLB() {
        return weightLB;
    }

    public void setWeightLB(double weightLB) {
        this.weightLB = weightLB;
    }

    public double getHeightFT() {
        return heightFT;
    }

    public void setHeightFT(double heightFT) {
        this.heightFT = heightFT;
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
    
    /**
     * Calculates BMI
     */
    public double calculateBMI(double heightFT, double weightLB){//added by WS
        int heightIN = (int) (heightFT * 12);//added by WS
        this.bmi = (weightLB/(Math.pow(heightIN, 2)))*703;//added by WS
        return this.bmi;//added by WS
    }  
    /**
     * Gets all patient vitals.
     * @return A HashMap containing patient data.
     */
    public HashMap getAllVitals() {
        HashMap<String, String> vitals = new HashMap<>();
        vitals.put("email", this.email);
        vitals.put("BMI", ""+this.bmi);
        vitals.put("Body Temperature", ""+this.bodyTempF);
        vitals.put("Weight", ""+this.weightLB);
        vitals.put("Height", ""+this.heightFT);
        vitals.put("Systolic", ""+this.bpSystolic); //added by WS
        vitals.put("Diastolic", ""+this.bpDiastolic);//added by WS
        vitals.put("Respiration", ""+this.respRate);//added by WS
        vitals.put("Pulse", ""+this.pulseBPM);//added by WS
        
        return vitals;
    }
    
   
}
