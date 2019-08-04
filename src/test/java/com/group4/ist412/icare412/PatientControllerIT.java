/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import org.dizitart.no2.Nitrite;
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
public class PatientControllerIT {
    
    public PatientControllerIT() {
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
     * Test of getUserVitals method, of class PatientController.
     */
    @Test
    public void testGetUserVitals() {
        System.out.println("getUserVitals");
        String email = "";
        PatientController instance = new PatientController();
        String expResult = "";
        String result = instance.getUserVitals(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserVitals method, of class PatientController.
     */
    @Test
    public void testSetUserVitals() {
        System.out.println("setUserVitals");
        String vitals = "";
        PatientController instance = new PatientController();
        Boolean expResult = null;
        Boolean result = instance.setUserVitals(vitals);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDb method, of class PatientController.
     */
    @Test
    public void testSetDb() {
        System.out.println("setDb");
        Nitrite db = null;
        PatientController instance = new PatientController();
        instance.setDb(db);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
