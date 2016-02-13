package com.seleniumcamp.load;

import java.io.IOException;

public class SetChromeDriverPath {

	GlobalSettingsLoad properties = new GlobalSettingsLoad();
	
	   public String setChromeDriverPath() throws IOException{
		   
		   if(properties.getPropValues("windows.machine") == "true"){
			   
			   return "src/resources/chromedriver.exe";
			   
		   }
		   else if (properties.getPropValues("linux.machine32") == "true") {
			   
			   return "src/resources/linux32/chromedriver";
			   
		}
		   else if (properties.getPropValues("linux.machine64") == "true") {
			   
			   return "src/resources/linux64/chromedriver";
			
		}
		   else
		   
		   return "src/resources/chromedriver";
		   
	   }
	
	
}
