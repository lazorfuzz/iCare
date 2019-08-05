/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import javafx.print.PrinterJob;
import javafx.scene.web.WebEngine;

/**
 *
 * @author leon
 */
public class PrinterController {
    WebEngine webEngine;

    /**
     *
     * @param webEngine The WebView WebEngine
     */
    public PrinterController(WebEngine webEngine) {
        this.webEngine = webEngine;
    }
    
    /**
     * Create a print job and open the system print dialog
     */
    public void print() {
        PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                this.webEngine.print(job);
                job.endJob();
            }
    }
}
