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
public class LoginControllerIT {
    
    public LoginControllerIT() {
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
     * Test of authenticate method, of class LoginController.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        String email = "";
        String password = "";
        LoginController instance = new LoginController();
        Boolean expResult = null;
        Boolean result = instance.authenticate(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class LoginController.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        String user = "";
        LoginController instance = new LoginController();
        Boolean expResult = null;
        Boolean result = instance.createUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class LoginController.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        String email = "";
        LoginController instance = new LoginController();
        Boolean expResult = null;
        Boolean result = instance.deleteUser(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class LoginController.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        String user = "";
        LoginController instance = new LoginController();
        Boolean expResult = null;
        Boolean result = instance.updateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByEmail method, of class LoginController.
     */
    @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");
        String email = "";
        LoginController instance = new LoginController();
        String expResult = "";
        String result = instance.getUserByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class LoginController.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        LoginController instance = new LoginController();
        String expResult = "";
        String result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDb method, of class LoginController.
     */
    @Test
    public void testSetDb() {
        System.out.println("setDb");
        Nitrite db = null;
        LoginController instance = new LoginController();
        instance.setDb(db);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
