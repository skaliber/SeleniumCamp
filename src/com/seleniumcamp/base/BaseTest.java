package com.seleniumcamp.base;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

import resources.GlobalConstants;

import com.seleniumcamp.load.GlobalSettingsLoad;
import com.seleniumcamp.logger.Log;
import com.seleniumcamp.utils.IsHeadLess;

public class BaseTest extends PageDriver {

	GlobalSettingsLoad properties = new GlobalSettingsLoad();
	private static Log logger = new Log();
	
	@Before
	public void Setup() throws IOException{
		
		getDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        
		if(IsHeadLess.Check()){
			
			driver.manage().window().maximize();
			logger.LogActivity("Driver setup done" +getDriver().toString());
			
		}
		driver.navigate().to(properties.getPropValues(GlobalConstants.WEB_SERVER));
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		logger.LogActivity("Driver succesfully navigated to " + " " + properties.getPropValues(GlobalConstants.WEB_SERVER));
		
     }
	
	@After
	public void TearDown() throws Exception{
		
		quitDriver();
		
	}
	
	
}
