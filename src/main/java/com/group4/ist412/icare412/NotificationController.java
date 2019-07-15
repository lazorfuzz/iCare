/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class NotificationController {
    
    ArrayList<Notification> notificationsList;
    
    /**
     * Constructor for the NotificationController class.
     * @param notificationsList List of notifications to hydrate the controller with.
     */
    public NotificationController(ArrayList<Notification> notificationsList) {
        this.notificationsList = notificationsList;
    }
    
}
