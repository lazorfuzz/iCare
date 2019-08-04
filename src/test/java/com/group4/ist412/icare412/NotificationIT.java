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
public class NotificationIT {
    
    public NotificationIT() {
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
     * Test of getMessage method, of class Notification.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Notification instance = null;
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMessage method, of class Notification.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        Notification instance = null;
        instance.setMessage(message);

    }
    
}
