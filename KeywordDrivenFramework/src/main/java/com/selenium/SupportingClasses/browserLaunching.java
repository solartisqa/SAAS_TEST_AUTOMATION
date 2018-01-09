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
	
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	
	protected WebDriver wdriver=null;
	protected EventFiringWebDriver driver=null;
	protected TheEventListener eventListerner=null;
	//protected RemoteWebDriver driver=null;
	protected WebDriverWait wait=null; 
	
	 public WebDriver launch_browser(String browser,PropertiesHandle config) throws MalformedURLException
	 {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String driver_path = config.getProperty("driverPath");
		/* //String Url= config.getProperty("EnvURL");
		 if(browser.equalsIgnoreCase("chrome")){
				DesiredCapabilities capability = new DesiredCapabilities().chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.4.131:4444/wd/hub"), capability);
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				DesiredCapabilities capability = new DesiredCapabilities().firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.4.77:4444/wd/hub"), capability);
			}
		 setWebDriver(driver);
		 //driver=getDriver();
		 getDriver().manage().window().maximize();
		 getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 return getDriver();
	 }*/
	 
	   switch(browser.toUpperCase()) 
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
					//driver.manage().window().maximize();
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
	 }
	 

	 public void stop_browser()
		{
			driver.quit();
		}
	 public WebDriver getDriver() {
			return dr.get();
		}

		public void setWebDriver(RemoteWebDriver driver) {
			dr.set(driver);
		}

	 
	 
}
