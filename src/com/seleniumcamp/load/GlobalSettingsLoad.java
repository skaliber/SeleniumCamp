package com.seleniumcamp.load;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalSettingsLoad {

	String result = "";
	InputStream inputStream;
	String resources = "resources/global_settings.properties";
	Properties properties = new Properties();
	
	public String getPropValues(String propname) throws IOException {
		 
		inputStream = getClass().getClassLoader().getResourceAsStream(resources);
		
			if(inputStream == null){
				
				System.err.println("input stream is null");;
			}
		
		properties.load(inputStream);
		
		result = properties.getProperty(propname);
		
		System.out.println("you are looking for the following properties " + result);
		
		return result;
		
	}
	
}
