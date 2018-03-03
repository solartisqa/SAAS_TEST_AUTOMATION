package selenide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukHooks
{
	public static  WebDriver driver;
	
	 @Before 
	 public void setUp() throws MalformedURLException
	 { 
		/* DesiredCapabilities capabilities = new DesiredCapabilities();
		 System.setProperty("webdriver.chrome.driver","src/main/java/Drivers/chromedriver.exe");
		 capabilities.setCapability("javascriptEnabled", true);
		 driver = new ChromeDriver(capabilities);*/
		    DesiredCapabilities cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			//cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://192.168.4.131:5561/wd/hub"), cap);
			System.out.println("Remote webdriver opened");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		 // pageObject = PageFactory.initElements(driver, PageObject.class);
	 } 
	 
	  @After
	  public void cleanUp()
	  { 
	      driver.close(); 
	  }
}