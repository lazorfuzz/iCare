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
public class Notification {
    private String message;
    
    /**
     * Constructor for the Notification class.
     * @param message sets the notification message.
     */
    public Notification(String message) {
        this.message = message;
    }
    
    /**
     * Gets the notification payload.
     * @return A String containing the notification message.
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Sets the notification payload.
     * @param message A String that sets the notification message.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
