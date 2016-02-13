package com.seleniumcamp.logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import resources.GlobalConstants;

import com.seleniumcamp.load.GlobalSettingsLoad;

public class Log {

	Logger logger = Logger.getLogger("MyLog");  
    FileHandler fh;
    Date date = new Date();
    String filelog = new SimpleDateFormat("dd/MM/yyyy").format(date);
    GlobalSettingsLoad prop = new GlobalSettingsLoad();
    

	public void LogActivity(String activitytolog) throws IOException{
    	
    	 String browser = prop.getPropValues(GlobalConstants.SELENIUM_DRIVER);
    	 
    	if(IsTheLoggerActive.Check()){
    		 FileHandler fh;
 	        String filelog = new Date().toString();
 	        File yourFile = new File("src/logger/" +browser + "-" + filelog +".log");
 	        if(!yourFile.exists()) {
 	            yourFile.createNewFile();
 	        } 
 	        try {
 	            
 	            fh = new FileHandler("src/logger/" +browser + "-" + filelog +".log");
 	            logger.addHandler(fh);
 	            //logger.setLevel(Level.ALL);
 	            SimpleFormatter formatter = new SimpleFormatter();
 	            fh.setFormatter(formatter);
 	             
 	            // the following statement is used to log any messages
 	            logger.info(activitytolog);
 	             
 	        } catch (SecurityException e) {
 	            e.printStackTrace();
 	        } catch (IOException e) {
 	            e.printStackTrace();
 	        }
 	      }
    	}	 
    	
    }

