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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import com.selenium.SupportingClasses.browserLaunching;

public class BasePage extends browserLaunching
{
	static WiniumDriver d;
  public WebDriverWait wait;
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
	
  
  
}
