package com.seleniumcamp.base;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import resources.GlobalConstants;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.seleniumcamp.load.GlobalSettingsLoad;
import com.seleniumcamp.load.SetChromeDriverPath;
import com.seleniumcamp.logger.Log;

public class PageDriver {
	GlobalSettingsLoad properties = new GlobalSettingsLoad();
	SetChromeDriverPath setchromepath = new SetChromeDriverPath();
	private static Log logger = new Log();

	public enum Drivers{
		HtmlUnit,
		Firefox, 
		InternetExplorer,
		Chrome;
	}
	//driver
	public static WebDriver driver;
	
	//set html unit driver
     public WebDriver SetHTMLUnitDriver(){
		
    	 return new HtmlUnitDriver(BrowserVersion.CHROME);
    	 
     }
     
     //set firefox driver
   public WebDriver setFirefoxDriver(){
    	 
    return driver = new FirefoxDriver();
    		
    }
 
   
   public WebDriver setChromeDriver() throws IOException{
	   
	   String path =  setchromepath.setChromeDriverPath();
	   System.setProperty("webdriver.chrome.driver", path);
	   return driver = new ChromeDriver();
	   
   }
   
     
    public WebDriver getDriver() throws IOException{
    	
    		switch (properties.getPropValues(GlobalConstants.SELENIUM_DRIVER)) {
			case "HtmlUnit":
				return driver = SetHTMLUnitDriver();
			case "Chrome":
				return driver = setChromeDriver();
			case "Firefox":
				return driver = setFirefoxDriver();
			default:
				return driver = setChromeDriver();
				
			}
    }
    
    //quit driver
    public void quitDriver() throws Exception{
    	
    	try {
		driver.quit();
		logger.LogActivity("Driver succesfully closed " + " " + properties.getPropValues(GlobalConstants.SELENIUM_DRIVER));
		
		} catch (Exception e) {
			
			throw new Exception("I Can't quit the driver"+ e.getLocalizedMessage());
		}
    }
	
}
