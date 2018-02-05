
package CucumberHooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukHooks
{
	protected  WebDriver driver;
	 @Before 
	 public void setUp()
	 { 
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 System.setProperty("webdriver.chrome.driver","src/main/java/Drivers/chromedriver.exe");
		 capabilities.setCapability("javascriptEnabled", true);
		 driver = new ChromeDriver(capabilities);
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
	 } 
	 
	  @After
	  public void cleanUp()
	  { 
	      driver.close(); 
	  }
}