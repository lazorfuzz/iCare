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
public class NotificationsController {
    
    Gson gson;
    Double BMI, weight, height, systolic, diastolic;
    String warn;
    Nitrite db;
    
    /**
     *
     * @param wt Weight in kilograms
     * @param ht Height in centimeters
     * @return Notification message
     */
    public String calculateAdultBMI(String wt, String ht)
    {
        this.weight = Double.parseDouble(wt);
        this.height = Double.parseDouble(ht);
        BMI = (weight/(Math.pow(height, 2))) * 10000;
        if (BMI < 18){
            Notification bmiUnder = new Notification("WARNING! Your are underweight based on your BMI");
            return bmiUnder.getMessage();
        }
        else if((BMI > 25) && (BMI < 30)){
            Notification bmiOver = new Notification("WARNING! Your are overweight based on your BMI");
            return bmiOver.getMessage();
        }
        else if(BMI > 30){
            Notification bmiObese = new Notification("WARNING! Your are obese based on your BMI");
            return bmiObese.getMessage();
        }
        else{
            Notification bmiNormal = new Notification("Your BMI is within the normal range");
            return bmiNormal.getMessage();
        }
    }
    
    /**
     *
     * @param sys Systolic blood pressure
     * @param dia Diastolic blood pressure
     * @return Notification message
     */
    public String bloodPressureChecks(String sys, String dia)
    {
        this.systolic = Double.parseDouble(sys);
        this.diastolic = Double.parseDouble(dia);
        
        if((systolic>=180)||(diastolic>=120)){
            Notification bpCrisis = new Notification("Your blood pressure is in hypertensive crisis!!!");
            return bpCrisis.getMessage();
        }
        else if((systolic>120)&&(systolic<=129)&&(diastolic<=80)){
            Notification bpElevated = new Notification("Your blood pressure is elevated");
            return bpElevated.getMessage();
        }
        else if(((systolic>=130)&&(systolic<=139))||((diastolic>80)&&(diastolic<=89))){
            Notification bpHypeOne = new Notification("Your blood pressure is high, STAGE 1");
            return bpHypeOne.getMessage();
        }
        else if(((systolic>=140)&&(systolic<=180))||((diastolic>=90)&&(diastolic<=119))){
            Notification bpHypeTwo = new Notification("Your blood pressure is high, STAGE 2");
            return bpHypeTwo.getMessage();
        }
        else{
            Notification bpNormal = new Notification("Your blood pressure is within the normal range");
            return bpNormal.getMessage();
        }
    }
    
    /**
     *
     * @param db
     */
    public void setDb(Nitrite db) {
        this.db = db;
    }
    
}
