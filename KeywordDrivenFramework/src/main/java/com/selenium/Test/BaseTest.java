package com.selenium.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest
{
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	   public  WebDriver launchRemoteBrowser(String browser) throws MalformedURLException
			{
		   RemoteWebDriver driver = null;
			WebDriver wdriver = null;
				 if (browser.equals("firefox"))
					{
						DesiredCapabilities cap = new DesiredCapabilities().firefox();
						cap.setBrowserName("firefox");
						cap.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL("http://192.168.4.75:4444/wd/hub"), cap);
					} 
				 else if (browser.equals("chrome"))
					{
						DesiredCapabilities cap = new DesiredCapabilities().chrome();
						cap.setBrowserName("chrome");
						cap.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL("http://192.168.4.75:4444/wd/hub"), cap);
					} 
				 else if(browser.equals("IE"))
				 {
					   DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();
						cap.setBrowserName("IE");
						cap.setPlatform(Platform.WINDOWS);
						cap.setCapability("ignoreZoomSetting", true);
						cap.setCapability("javascriptEnabled", true);
						cap.setCapability("platform", "WINDOWS");
						cap.setCapability("ignoreProtectedModeSettings", true);
						cap.setCapability("ie.ensureCleanSession", true);
						cap.setCapability("browserName", "internet explorer");
						cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,"dismiss");
						cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,0);
						cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,true);
						cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP,true);
						cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,false);
						driver = new RemoteWebDriver(new URL("http://192.168.4.75:4444/wd/hub"), cap);
				 }
				 
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 setWebDriver(driver);
					 wdriver=getDriver(); 
					 wdriver.manage().window().maximize();
					 wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 return wdriver;
			}
	   
	   
	   public WebDriver getDriver()
		{
	        return dr.get();
	    }
	 
	    public void setWebDriver(RemoteWebDriver driver) {
	        dr.set(driver);
	    }
}
