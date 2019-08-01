/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adam
 */
public class ReportIT {
    
    public ReportIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPatientInfo method, of class Report.
     */
    @Test
    public void testGetPatientInfo() {
        System.out.println("getPatientInfo");
        String userId = "";
        Report instance = new Report();
        instance.getPatientInfo(userId);

    }

    /**
     * Test of generateReport method, of class Report.
     */
    @Test
    public void testGenerateReport() {
        System.out.println("generateReport");
        String userId = "";
        double bodyTempF = 0.0;
        double weightLB = 0.0;
        double heightFT = 0.0;
        double bmi = 0.0;
        double bpSystolic = 0.0;
        double bpDiastolic = 0.0;
        double respRate = 0.0;
        double pulseBPM = 0.0;
        Report instance = new Report();
        String expResult = "";
        String result = instance.generateReport(userId, bodyTempF, weightLB, heightFT, bmi, bpSystolic, bpDiastolic, respRate, pulseBPM);
        assertEquals(expResult, result);
    }
    
}
