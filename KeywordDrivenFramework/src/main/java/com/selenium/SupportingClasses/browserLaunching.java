package com.selenium.SupportingClasses;

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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Configuration.PropertiesHandle;

import org.openqa.selenium.remote.CapabilityType;

public class browserLaunching extends ConditionsChecking{
	
	
	protected WebDriver driver = null;
	//protected RemoteWebDriver wdriver=null;
	//protected WebDriver wdriver=null;
	//protected EventFiringWebDriver driver=null;
	//protected TheEventListener eventListerner=null;
	protected WebDriverWait wait=null; 
	
	 public WebDriver launch_browser(String browser) throws MalformedURLException
	 {
		
		 if (browser.equals("firefox"))
			{
				DesiredCapabilities cap = new DesiredCapabilities().firefox();
				cap.setBrowserName("firefox");
				//cap.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.4.131:4444/wd/hub"), cap);
				driver.manage().window().maximize();
			} 
		 else if (browser.equals("chrome"))
			{
				DesiredCapabilities cap = new DesiredCapabilities().chrome();
				cap.setBrowserName("chrome");
				//cap.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.4.131:4444/wd/hub"), cap);
				driver.manage().window().maximize();
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
				driver.manage().window().maximize();
		 }
		 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return driver;
	 }
	 
	   /*switch(browser.toUpperCase()) 
		{
					
			case "IE":
				    System.setProperty("webdriver.ie.driver",driver_path + "IEDriverServer.exe");
				 	capabilities.setCapability("browser", "IE");
				 	capabilities.setCapability("browser_version", "10.0");
				 	capabilities.setCapability("os", "Windows");
				 	capabilities.setCapability("os_version", "7");
				 	capabilities.setCapability("resolution", "800x600");
				 	capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
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
					capabilities.setCapability("browserstack.debug", true);
					System.out.println(browser);			
				    wdriver = new InternetExplorerDriver(capabilities);
				    driver=new EventFiringWebDriver(wdriver);
				    eventListerner=new TheEventListener();
				    driver.register(eventListerner);
				    driver.manage().deleteAllCookies();
				    driver.manage().window().maximize();
				    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				    break;
				 
			case "CHROME":
				
					System.out.println(browser);	
					System.setProperty("webdriver.chrome.driver",driver_path + "chromedriver.exe");
				 	capabilities.setCapability("browser", "Chrome");
					capabilities.setCapability("browser_version", "57.0");
					capabilities.setCapability("os", "Windows");
					capabilities.setCapability("os_version", "7");
					capabilities.setCapability("resolution", "800x600");
					capabilities.setCapability("browserstack.debug", true);
					wdriver = new ChromeDriver(capabilities);
					driver=new EventFiringWebDriver(wdriver);
				    eventListerner=new TheEventListener();
				    driver.register(eventListerner);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					break;
				
				
		    case "FIREFOX":
				
				  	System.out.println(browser);	  						
					System.setProperty("webdriver.gecko.driver",driver_path + "geckodriver.exe");
					capabilities.setCapability("ignoreZoomSetting", true);
					capabilities.setCapability("javascriptEnabled", true);
					capabilities.setCapability("platform", "WINDOWS");
					capabilities.setCapability("ignoreProtectedModeSettings", true);		
					wdriver=new FirefoxDriver(capabilities);
					driver=new EventFiringWebDriver(wdriver);
				    eventListerner=new TheEventListener();
				    driver.register(eventListerner);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					break;
					
		   default	:	 
			    System.out.println("not a valid browser");
			    break;
		}
	   //driver.get(Url);
		return driver;
	 }*/

	 public void stop_browser()
		{
			driver.quit();
		}
	

	 
		public static void main(String args[]) throws MalformedURLException
		{
			browserLaunching br=new browserLaunching();
			br.launch_browser("chrome");
			
		}
	 
}
