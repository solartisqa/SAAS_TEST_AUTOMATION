package BasePage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import com.selenium.SupportingClasses.browserLaunching;

import selenide.CukHooks;

public class BasePage 
{
 static WiniumDriver d;
  public WebDriverWait wait;
  protected WebDriver driver;
  public BasePage(WebDriver driver)
  { 
	  this.driver = driver; 
	  PageFactory.initElements(driver, this);
  }
  
  public void WaitWithVisibility(WebElement element,WebDriver driver)//
 {
	 wait=new WebDriverWait(driver, 1000);
	 wait.until(ExpectedConditions.visibilityOf(element));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	 
}
  
  public void uploadusingRobotClass(String inputValue) throws AWTException
	 {
		    StringSelection ss = new StringSelection(inputValue);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			 Robot r = new Robot();
			 r.keyPress(KeyEvent.VK_ENTER);
			 r.keyRelease(KeyEvent.VK_ENTER);
			 r.keyPress(KeyEvent.VK_CONTROL);
			 r.keyPress(KeyEvent.VK_V);
			 r.keyRelease(KeyEvent.VK_V);    
			 r.keyRelease(KeyEvent.VK_CONTROL);
			 r.keyPress(KeyEvent.VK_ENTER);
			 r.keyRelease(KeyEvent.VK_ENTER);
	 }
  
  public void uploadFileusingWinium() throws IOException, AWTException
	 {
		
		 DesktopOptions options = new DesktopOptions();
		    options.setApplicationPath("C:\\Windows\\System32\\openfiles.exe");
        
		    String WiniumEXEpath = "D:\\SeleniumConfig\\ResourceFiles\\Winium.Desktop.Driver.exe";
		    File file = new File(WiniumEXEpath);
		    if (! file.exists()) 
		    {
		        throw new IllegalArgumentException("The file " + WiniumEXEpath + " does not exist");
		    }
		    Runtime.getRuntime().exec(file.getAbsolutePath());
		    try
		    {
		        d = new WiniumDriver(new URL("http://localhost:9999"),options);
		       
		    } catch (MalformedURLException e) 
		    {
		        e.printStackTrace();
		    }
		    String file1 = "D:\\SeleniumConfig\\ResourceFiles\\sample.png";
		    try
		    {
		    d.switchTo().activeElement();
		    d.findElementByName("File name:").click();	
		    d.findElementByName("File name:").sendKeys(file1);
		    d.findElementByName("Open").click();
		    }
		    catch(VerifyError  e)
		    {
		    	System.out.println("Element not found");
		    }
		    this.ClickDesktopEnter();		      
	 }
  
	public void ClickDesktopEnter() throws AWTException
	{
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	 public void uploadFileusingAutoIt() throws IOException
	 {
		 Runtime.getRuntime().exec("D:\\SeleniumConfig\\AutoItScripts\\FileUpload.exe");
	 }
	
	   public WebElement highlightElement(WebElement elem) {
	        // draw a border around the found element
	        if (driver instanceof JavascriptExecutor) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	        }
	        return elem;
	    }
	   
//=============================================================================================================================================================================================	   
	   public  void launchRemoteBrowser(String browser) throws MalformedURLException
		{
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
					cap.setPlatform(Platform.LINUX);
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
		}

  
}
