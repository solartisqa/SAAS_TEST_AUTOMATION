package StarrAssistPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BasePage;

public class HomePage extends BasePage
{
	private WebDriver driver;
	
	 @FindBy(id="MenuBar:QuoteFlowLink")WebElement GetAQuote;
	 @FindBy(id="AccountLink")WebElement Find;
	 @FindBy(id="MenuBar:MyQuotes")WebElement FindQuote;
	 @FindBy(id="MyPolicyLink")WebElement FindPolicy;
	 @FindBy(id="MenuBar:FindCustomer")WebElement FindCustomer;
	
	
	 public HomePage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
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
}
