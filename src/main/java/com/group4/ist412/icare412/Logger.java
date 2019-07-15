/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author leon
 */


public final class Logger {
	//Implements a singleton logger instance
	private static final Logger instance = new Logger();

	//Retrieve the execution directory. Note that this is whereever this process was launched
	public String logname = "icarelogger";
	protected String env = System.getProperty("user.dir");
	private static File logFile;

	public static Logger getInstance(){
		return instance;
	}

	public static Logger getInstance(String withName){
		instance.logname = withName;
		instance.createLogFile();
		return instance;
	}

	public void createLogFile(){
		//Determine if a logs directory exists or not.
		File logsFolder = new File(env + '/' + "logs");
		if(!logsFolder.exists()){
			//Create the directory 
			System.out.println("INFO: Creating new logs directory in " + env);
			logsFolder.mkdir();
			
		}

		//Get the current date and time
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   	Calendar cal = Calendar.getInstance();
	   	
	   	//Create the name of the file from the path and current time
		logname =  logname + '-' +  dateFormat.format(cal.getTime()) + ".log";
		Logger.logFile = new File(logsFolder.getName(),logname);
		try{
			if(logFile.createNewFile()){
				//New file made
				System.err.println("INFO: Creating new log file");	
			}
		}catch(IOException e){
			System.err.println("ERROR: Cannot create log file");
			System.exit(1);
		}
	}

	private Logger(){
		if (instance != null){
			//Prevent Reflection
			throw new IllegalStateException("Cannot instantiate a new singleton instance of log");
		}
		this.createLogFile();
	}

	public static void log(String message){
		try (FileWriter out = new FileWriter(Logger.logFile, true)) {
                        message = message + "\n";
			out.write(message.toCharArray());
		} catch(IOException e){
			System.err.println("ERROR: Could not write to log file");
		}
	}

	public static void main(String[] args) {
		
		Logger.log("iCare logger initiated.");
	}

}