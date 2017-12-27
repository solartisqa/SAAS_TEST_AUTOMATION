package StarrAssistPOM;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BasePage.BasePage;

public class HomePage extends BasePage
{
	private WebDriver driver;
	
	 @FindBy(id="MenuBar:QuoteFlowLink")WebElement GetAQuote;
	 @FindBy(id="AccountLink")WebElement Find;
	 @FindBy(id="MenuBar:MyQuotes")WebElement FindQuote;
	 @FindBy(id="MyPolicyLink")WebElement FindPolicy;
	 @FindBy(id="MenuBar:FindCustomer")WebElement FindCustomer;
	 @FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	 @FindBy(id="groupBooking:Object__Attachment__FileUpload_input")WebElement FileUpload;
	
	 public HomePage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 public GetAQuotePage ClickGetAQuote()
	 {
		 this.WaitWithVisibility(GetAQuote,driver);
		 try
		 {
		 GetAQuote.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 GetAQuote.click();
		 }
		 this.waitForLoading();
		 return new GetAQuotePage(this.driver);
	 }
	 
	 public void ClickFind()
	 {
		 this.WaitWithVisibility(Find,driver);
		 try
		 {
		 Find.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Find.click();
		 }
		
	 }
	 public FindQuotePage ClickFindQuote()
	 {
		 this.WaitWithVisibility(FindQuote,driver);
		 try
		 {
		 FindQuote.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 FindQuote.click();
		 }
		 return new FindQuotePage(this.driver);
	 }
	 public FindPolicyePage ClickFindPolicy()
	 {
		 this.WaitWithVisibility(FindPolicy,driver);
		 try
		 {
		 FindPolicy.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 FindPolicy.click();
		 }
		 return new FindPolicyePage(this.driver);
	 }
	 
	 public FindCustomerPage ClickFindCustomer()
	 {
		 this.WaitWithVisibility(FindCustomer,driver);
		 try
		 {
		 FindCustomer.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
		  FindCustomer.click();
		 }
		 return new FindCustomerPage(this.driver);
	 }
	 
	 public void ClickFileUpload()
	 {
		 this.WaitWithVisibility(FileUpload,driver);
		 FileUpload.click();
		 this.waitForLoading();
	 }
	 public void waitForLoading()
	 {
		 wait.until(ExpectedConditions.visibilityOfAllElements(LoadingIcon));
		 wait.until(ExpectedConditions.invisibilityOfAllElements(LoadingIcon));
	 }
	 public void upload() throws InterruptedException
	 {
		 FileUpload.sendKeys("D:\\sas\\Format_for_Spreadsheet_Upload.xls");
		 Thread.sleep(1000);
	 }
}
