package com.seleniumcamp.logger;

import java.io.IOException;

import resources.GlobalConstants;

import com.seleniumcamp.load.GlobalSettingsLoad;

public class IsTheLoggerActive {

	static GlobalSettingsLoad prop = new GlobalSettingsLoad();
	 
	public static Boolean Check() throws IOException {
		
		if(GlobalConstants.LOG_THINGS){
			
			return true;
		}
		return false;
	}
	
	
}
