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
public class Report {
    public Report(){

    }
    
    /**
     * Fetches patient info from the database.
     * @param userId The patient's ID.
     */
    public void getPatientInfo(String userId) {}
    
    /**
     * Generates a report.
     * 
     * @param userId The patient's ID.
     */
    public String generateReport(String userId, double bodyTempF,double weightLB, double heightFT, double bmi, double bpSystolic, double bpDiastolic, double respRate, double pulseBPM){
        
        String vitalsReport = ("\n UserID: "+userId +"\n Body Temperature: "+bodyTempF+"º\n Height: "+heightFT+"'\n Weight: "+weightLB+
                               " pounds\n Body Mass Index: " +bmi+" bmi \n Blood Pressure: "+bpSystolic+"/"+bpDiastolic+"\n Respiration: "+respRate+" breaths per minute \n Pulse: "+pulseBPM+" beats per minute. \n\n ***End of Record***");
        return vitalsReport;
    }
}
