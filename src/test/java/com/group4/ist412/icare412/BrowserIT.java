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
public class BrowserIT {
    
    public BrowserIT() {
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
     * Test of layoutChildren method, of class Browser.
     */
    @Test
    public void testLayoutChildren() {
        System.out.println("layoutChildren");
        Browser instance = null;
        instance.layoutChildren();
       
    }

    /**
     * Test of computePrefWidth method, of class Browser.
     */
    @Test
    public void testComputePrefWidth() {
        System.out.println("computePrefWidth");
        double height = 0.0;
        Browser instance = null;
        double expResult = 0.0;
        double result = instance.computePrefWidth(height);
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of computePrefHeight method, of class Browser.
     */
    @Test
    public void testComputePrefHeight() {
        System.out.println("computePrefHeight");
        double width = 0.0;
        Browser instance = null;
        double expResult = 0.0;
        double result = instance.computePrefHeight(width);
        assertEquals(expResult, result, 0.0);
       
    }
    
}
