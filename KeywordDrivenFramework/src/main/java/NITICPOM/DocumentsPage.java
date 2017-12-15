package NITICPOM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import BasePage.BasePage;

public class DocumentsPage extends BasePage
{
	static WiniumDriver d;
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(xpath="//tr[contains(.,'Application - Liability.pdf')]//td[3]")WebElement DownloadApplicationPDF;
	@FindBy(xpath="//tr[contains(.,'Quote Proposal - Liability.pdf')]//td[3]")WebElement DownloadPropasalPDF;
	@FindBy(xpath="//button[contains(.,'Attach')]")WebElement Attach;
	@FindBy(id="AttachmentsTile:AttachmentForm:Object__Attachment__Name")WebElement AttachmentName;
	@FindBy(id="AttachmentsTile:AttachmentForm:Object__Attachment__Description")WebElement AttachmentDescription;
	@FindBy(xpath="//span[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-choose' and @role='button']")WebElement Browse;

	@FindBy(xpath="//button[contains(.,'Attach File')]")WebElement AttachFile;
	
	@FindBy(id="AttachmentsTile:AttachmentForm:Object__Button__Cancel")WebElement Close;
	@FindBy(xpath="//button[contains(.,'Add Notes')]")WebElement AddNotes;
	@FindBy(id="NotesTile:NotesForm:Object__Notes__Description")WebElement NotesDescription;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__Zipcode")WebElement Zipcode;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__Insured__AdditionalInsured__Description")WebElement AdditionalInsuredDescription;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Cancel')]")WebElement Cancel;
	
	
	
	public DocumentsPage(WebDriver driver)
	{
		super(driver);
	}
	
	 private boolean isInitialized(boolean displayed)
	 {
	  return Attach.isDisplayed();
	 }
	 
	public void DownloadApllicationPDF()
	{
		String sourceLocation = DownloadApplicationPDF.getAttribute("href");
        System.out.println("Pdf href---------"+sourceLocation);
	}
	public void DownloadPropasalPDF()
	{
		String sourceLocation = DownloadPropasalPDF.getAttribute("href");
        System.out.println("Pdf href---------"+sourceLocation);
	}
	
	 public void ClickAttach()
	 {
		Attach.click();
		//this.waitForLoading();
	  }
	 public void setAttachmentName(String attachmentName)
	 {
		 this.WaitWithVisibility(AttachmentName,driver);
		 AttachmentName.clear();
		 AttachmentName.sendKeys(attachmentName);
		 
	 }
	 public void setAttachmentDescription(String attachmentDescription)
	 {
		 this.WaitWithVisibility(AttachmentDescription,driver);
		 AttachmentDescription.clear();
		 AttachmentDescription.sendKeys(attachmentDescription);
		 
	 }
	 public void ClickBrowse()
	 {
		Browse.click();
		//this.waitForLoading();
	  }
	
	 public QuoteSummaryPage ClickAttachFile()
	 {
		 AttachFile.click();
		 this.waitForLoading();
		 return new QuoteSummaryPage(this.driver);
		
	  }
	 
	public void upload(String inputValue) throws AWTException
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
	
	public void ClickDesktopEnter() throws AWTException
	{
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	 public void waitForLoading()
	 {
		 try{
		 wait.until(ExpectedConditions.visibilityOfAllElements(LoadingIcon));
		 wait.until(ExpectedConditions.invisibilityOfAllElements(LoadingIcon));
		 }
		 catch(Exception e)
		 {
			 
		 }
	 }
	 
	 public void AttachFile(LinkedHashMap<String, String> inputrow) throws AWTException, InterruptedException, IOException
	 {
		 this.ClickAttach();
		 this.setAttachmentName(inputrow.get("AttachementName"));
		 this.setAttachmentDescription("attachement");
		 this.ClickBrowse();
		 Thread.sleep(1000);
		 this.uploadFileusingWinium();
		 Thread.sleep(2000);
		 this.ClickAttachFile();
	 }
	 
	 public void AttachFile1(LinkedHashMap<String, String> inputrow) throws AWTException, InterruptedException, IOException
	 {
		 this.ClickAttach();
		 this.setAttachmentName(inputrow.get("AttachementName"));
		 this.setAttachmentDescription("attachement");
		 this.ClickBrowse();
		 Thread.sleep(1000);
		 String Path="D:\\SeleniumConfig\\ResourceFiles\\sample.png";
		 this.upload(Path);
		 Thread.sleep(1000);
		 this.ClickAttachFile();
	 }
	 
	 public void AttachFile2(LinkedHashMap<String, String> inputrow) throws AWTException, InterruptedException, IOException
	 {
		 this.ClickAttach();
		 this.setAttachmentName(inputrow.get("AttachementName"));
		 this.setAttachmentDescription("attachement");
		 this.ClickBrowse();
	     this.uploadFileusingAutoIt();
	     Thread.sleep(1000);
		 this.ClickAttachFile();
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
	
}
