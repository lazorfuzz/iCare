/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.dizitart.no2.Nitrite;

/**
 *
 * @author leon
 */

class Browser extends Region {
 
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    LoginController loginController = new LoginController();
    PatientController patientController = new PatientController();
    NotificationsController notificationsController = new NotificationsController();
    PrinterController printerController = new PrinterController(webEngine);
     
    public Browser(Nitrite db) {
        getStyleClass().add("browser");
        loginController.setDb(db);
        patientController.setDb(db);
        notificationsController.setDb(db);
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    if (newValue != Worker.State.SUCCEEDED) { return; }
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    // Let our React app access the controllers
                    window.setMember("LoginController", loginController);
                    window.setMember("PatientController", patientController);
                    window.setMember("NotificationsController", notificationsController);
                    window.setMember("PrinterController", printerController);
                }
            }
        );
        // To develop the UI and see changes:
        // cd ui
        // yarn start
        // Set the port here to 3000
        webEngine.load("http://localhost:49555");
        getChildren().add(browser);
 
    }
 
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}