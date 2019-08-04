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
public class MedicationIT {
    
    public MedicationIT() {
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
     * Test of getMedName method, of class Medication.
     */
    @Test
    public void testGetMedName() {
        System.out.println("getMedName");
        Medication instance = new Medication();
        String expResult = "";
        String result = instance.getMedName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMedName method, of class Medication.
     */
    @Test
    public void testSetMedName() {
        System.out.println("setMedName");
        String medName = "";
        Medication instance = new Medication();
        instance.setMedName(medName);
        
    }

    /**
     * Test of getQuantity method, of class Medication.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Medication instance = new Medication();
        double expResult = 0.0;
        double result = instance.getQuantity();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setQuantity method, of class Medication.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        double quantity = 0.0;
        Medication instance = new Medication();
        instance.setQuantity(quantity);
     
    }

    /**
     * Test of getMedQuantityUnit method, of class Medication.
     */
    @Test
    public void testGetMedQuantityUnit() {
        System.out.println("getMedQuantityUnit");
        Medication instance = new Medication();
        String expResult = "";
        String result = instance.getMedQuantityUnit();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setMedQuantityUnit method, of class Medication.
     */
    @Test
    public void testSetMedQuantityUnit() {
        System.out.println("setMedQuantityUnit");
        String medQuantityUnit = "";
        Medication instance = new Medication();
        instance.setMedQuantityUnit(medQuantityUnit);
       
    }

    /**
     * Test of getFrequency method, of class Medication.
     */
    @Test
    public void testGetFrequency() {
        System.out.println("getFrequency");
        Medication instance = new Medication();
        int expResult = 0;
        int result = instance.getFrequency();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFrequency method, of class Medication.
     */
    @Test
    public void testSetFrequency() {
        System.out.println("setFrequency");
        int frequency = 0;
        Medication instance = new Medication();
        instance.setFrequency(frequency);
      
    }

    /**
     * Test of getFrequencyTakenUnit method, of class Medication.
     */
    @Test
    public void testGetFrequencyTakenUnit() {
        System.out.println("getFrequencyTakenUnit");
        Medication instance = new Medication();
        String expResult = "";
        String result = instance.getFrequencyTakenUnit();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFrequencyTakenUnit method, of class Medication.
     */
    @Test
    public void testSetFrequencyTakenUnit() {
        System.out.println("setFrequencyTakenUnit");
        String frequencyTakenUnit = "";
        Medication instance = new Medication();
        instance.setFrequencyTakenUnit(frequencyTakenUnit);
       
    }
    
}
