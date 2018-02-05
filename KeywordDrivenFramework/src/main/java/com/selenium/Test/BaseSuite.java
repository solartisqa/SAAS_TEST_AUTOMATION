package com.selenium.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseSuite 
{
//protected  RemoteWebDriver Rdriver=null;
protected  WebDriver driver;
protected   String TestFlag;

    @Parameters({"browser","driverType","FlagForTest"})
	@BeforeTest
	public  void setUp(String browser,String driverType,String FlagForTest) throws MalformedURLException
    {
    	System.out.println("Before Test........");
		if(driverType.equals("Local"))
		{
			this.lauchLocalBrowser(browser);
		}
		else if(driverType.equals("Remote"))
		{
			this.launchRemoteBrowser(browser);
		}
		TestFlag=FlagForTest;
		System.out.println(TestFlag);
		
	}
	
	
	@AfterClass
	public  void tearDown()
	{
		//driver.manage().deleteAllCookies();
		//driver.close();
	}	
	
	public  void lauchLocalBrowser(String browser)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		 if (browser.equals("firefox"))
			{
			 System.setProperty("webdriver.gecko.driver","src/main/java/Drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
			 driver.manage().deleteAllCookies();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			}
		 else if (browser.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver","src/main/java/Drivers/chromedriver.exe");
			 capabilities.setCapability("javascriptEnabled", true);
			 driver = new ChromeDriver(capabilities);
			 driver.manage().deleteAllCookies();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 
		 }
		 else if(browser.equals("IE"))
		 {
			 System.setProperty("webdriver.ie.driver","src/main/java/Drivers/IEDriverServer.exe");
			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			    capabilities.setCapability("ignoreZoomSetting", true);
				capabilities.setCapability("javascriptEnabled", true);
				capabilities.setCapability("platform", "WINDOWS");
				capabilities.setCapability("ignoreProtectedModeSettings", true);
				capabilities.setCapability("ie.ensureCleanSession", true);
				capabilities.setCapability("browserName", "internet explorer");
				capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,"dismiss");
				capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,0);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,true);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP,true);
				capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,false);
			    driver = new InternetExplorerDriver(capabilities);
			    driver.manage().deleteAllCookies();
			    driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 
		 }
		
	}
	
	public  void launchRemoteBrowser(String browser) throws MalformedURLException
	{
		 if (browser.equals("firefox"))
			{
				DesiredCapabilities cap = new DesiredCapabilities().firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.4.48:4444/wd/hub"), cap);
			} 
		 else if (browser.equals("chrome"))
			{
				DesiredCapabilities cap = new DesiredCapabilities().chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.LINUX);
				driver = new RemoteWebDriver(new URL("http://192.168.4.48:4444/wd/hub"), cap);
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
				driver = new RemoteWebDriver(new URL("http://192.168.4.131:4444/wd/hub"), cap);
		 }
		 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	
	public static void main(String args[])
	{
		BaseSuite base=new BaseSuite();
		base.lauchLocalBrowser("firefox");
	}
}
