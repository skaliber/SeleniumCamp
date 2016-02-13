package com.seleniumcamp.load;

import java.io.IOException;

import resources.GlobalConstants;

public class SetChromeDriverPath {

	GlobalSettingsLoad properties = new GlobalSettingsLoad();
	
	   public String setChromeDriverPath() throws IOException{
		   
		   if(properties.getPropValues(GlobalConstants.WINDOWS_MACHINE) == "true"){
			   
			   return "src/resources/chromedriver.exe";
			   
		   }
		   else if (properties.getPropValues(GlobalConstants.LINUX32_MACHINE) == "true") {
			   
			   return "src/resources/linux32/chromedriver";
			   
		}
		   else if (properties.getPropValues(GlobalConstants.LINUX_64_MACHINE) == "true") {
			   
			   return "src/resources/linux64/chromedriver";
			
		}
		   else
		   
		   return "src/resources/chromedriver";
		   
	   }
	
	
}
