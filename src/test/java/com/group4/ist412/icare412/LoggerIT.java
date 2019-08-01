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
public class LoggerIT {
    
    public LoggerIT() {
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
     * Test of getInstance method, of class Logger.
     */
    @Test
    public void testGetInstance_0args() {
        System.out.println("getInstance");
        Logger expResult = null;
        Logger result = Logger.getInstance();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getInstance method, of class Logger.
     */
    @Test
    public void testGetInstance_String() {
        System.out.println("getInstance");
        String withName = "";
        Logger expResult = null;
        Logger result = Logger.getInstance(withName);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of createLogFile method, of class Logger.
     */
    @Test
    public void testCreateLogFile() {
        System.out.println("createLogFile");
        Logger instance = null;
        instance.createLogFile();
       
    }

    /**
     * Test of log method, of class Logger.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        String message = "";
        Logger.log(message);
      
    }

    /**
     * Test of main method, of class Logger.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Logger.main(args);
        
    }
    
}
