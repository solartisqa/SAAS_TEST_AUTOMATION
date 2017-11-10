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
	protected TheEventListener eventListerner=null;
	protected RemoteWebDriver driver=null;
	
	 public RemoteWebDriver launch_browser(String browser,PropertiesHandle config) throws MalformedURLException
	 {
		
		 if (browser.equals("firefox"))
			{
				DesiredCapabilities cap = new DesiredCapabilities().firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else if (browser.equals("chrome"))
			{
				DesiredCapabilities cap = new DesiredCapabilities().chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.4.131:4444/wd/hub"), cap);
			} 
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			return driver;
	 }
	
}
