package com.seleniumcamp.utils;
import java.io.IOException;

import resources.GlobalConstants;

import com.seleniumcamp.load.GlobalSettingsLoad;

public class IsHeadLess {
	
	static GlobalSettingsLoad properties = new GlobalSettingsLoad();
	
	  public static Boolean Check() throws IOException{
		
      if(properties.getPropValues(GlobalConstants.SELENIUM_DRIVER) !=  "HtmlUnit"){
			
			return true;
		}
      
		return false;
	}

}
