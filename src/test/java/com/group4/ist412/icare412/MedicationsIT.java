/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import java.util.ArrayList;
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
public class MedicationsIT {
    
    public MedicationsIT() {
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
     * Test of getMedicationList method, of class Medications.
     */
    @Test
    public void testGetMedicationList() {
        System.out.println("getMedicationList");
        Medications instance = null;
        ArrayList<Medication> expResult = null;
        ArrayList<Medication> result = instance.getMedicationList();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMedicationList method, of class Medications.
     */
    @Test
    public void testSetMedicationList() {
        System.out.println("setMedicationList");
        ArrayList<Medication> medicationList = null;
        Medications instance = null;
        instance.setMedicationList(medicationList);
       
    }
    
}
