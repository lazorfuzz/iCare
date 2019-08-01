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
public class VitalsIT {
    
    public VitalsIT() {
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
     * Test of getBodyTempF method, of class Vitals.
     */
    @Test
    public void testGetBodyTempF() {
        System.out.println("getBodyTempF");
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.getBodyTempF();
        assertEquals(expResult, result, 0.0);
      
    }

    /**
     * Test of setBodyTempF method, of class Vitals.
     */
    @Test
    public void testSetBodyTempF() {
        System.out.println("setBodyTempF");
        double bodyTempF = 0.0;
        Vitals instance = null;
        instance.setBodyTempF(bodyTempF);
       
    }

    /**
     * Test of getWeightLB method, of class Vitals.
     */
    @Test
    public void testGetWeightLB() {
        System.out.println("getWeightLB");
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.getWeightLB();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setWeightLB method, of class Vitals.
     */
    @Test
    public void testSetWeightLB() {
        System.out.println("setWeightLB");
        double weightLB = 0.0;
        Vitals instance = null;
        instance.setWeightLB(weightLB);
       
    }

    /**
     * Test of getHeightFT method, of class Vitals.
     */
    @Test
    public void testGetHeightFT() {
        System.out.println("getHeightFT");
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.getHeightFT();
        assertEquals(expResult, result, 0.0);
     
    }

    /**
     * Test of setHeightFT method, of class Vitals.
     */
    @Test
    public void testSetHeightFT() {
        System.out.println("setHeightFT");
        double heightFT = 0.0;
        Vitals instance = null;
        instance.setHeightFT(heightFT);
        
    }

    /**
     * Test of getBpSystolic method, of class Vitals.
     */
    @Test
    public void testGetBpSystolic() {
        System.out.println("getBpSystolic");
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.getBpSystolic();
        assertEquals(expResult, result, 0.0);
      
    }

    /**
     * Test of setBpSystolic method, of class Vitals.
     */
    @Test
    public void testSetBpSystolic() {
        System.out.println("setBpSystolic");
        double bpSystolic = 0.0;
        Vitals instance = null;
        instance.setBpSystolic(bpSystolic);
 
    }

    /**
     * Test of getBpDiastolic method, of class Vitals.
     */
    @Test
    public void testGetBpDiastolic() {
        System.out.println("getBpDiastolic");
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.getBpDiastolic();
        assertEquals(expResult, result, 0.0);
     
    }

    /**
     * Test of setBpDiastolic method, of class Vitals.
     */
    @Test
    public void testSetBpDiastolic() {
        System.out.println("setBpDiastolic");
        double bpDiastolic = 0.0;
        Vitals instance = null;
        instance.setBpDiastolic(bpDiastolic);
       
    }

    /**
     * Test of getRespRate method, of class Vitals.
     */
    @Test
    public void testGetRespRate() {
        System.out.println("getRespRate");
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.getRespRate();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of setRespRate method, of class Vitals.
     */
    @Test
    public void testSetRespRate() {
        System.out.println("setRespRate");
        double respRate = 0.0;
        Vitals instance = null;
        instance.setRespRate(respRate);
       
    }

    /**
     * Test of getPulseBPM method, of class Vitals.
     */
    @Test
    public void testGetPulseBPM() {
        System.out.println("getPulseBPM");
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.getPulseBPM();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setPulseBPM method, of class Vitals.
     */
    @Test
    public void testSetPulseBPM() {
        System.out.println("setPulseBPM");
        double pulseBPM = 0.0;
        Vitals instance = null;
        instance.setPulseBPM(pulseBPM);
      
    }

    /**
     * Test of getEmail method, of class Vitals.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Vitals instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setEmail method, of class Vitals.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Vitals instance = null;
        instance.setEmail(email);
    }

    /**
     * Test of calculateBMI method, of class Vitals.
     */
    @Test
    public void testCalculateBMI() {
        System.out.println("calculateBMI");
        double heightFT = 0.0;
        double weightLB = 0.0;
        Vitals instance = null;
        double expResult = 0.0;
        double result = instance.calculateBMI(heightFT, weightLB);
        assertEquals(expResult, result, 0.0);
       
    }
    
}
