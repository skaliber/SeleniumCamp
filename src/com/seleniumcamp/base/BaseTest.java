package com.seleniumcamp.base;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;

import com.seleniumcamp.load.GlobalSettingsLoad;

public class BaseTest extends PageDriver {

	GlobalSettingsLoad loaddata = new GlobalSettingsLoad();
	
	@Before
	public void Setup() throws IOException{
		
		getDriver();
		driver.navigate().to(loaddata.getPropValues("webserver.url"));
		
     }
	
	@After
	public void TearDown() throws Exception{
		
		quitDriver();
		
	}
	
	
}
