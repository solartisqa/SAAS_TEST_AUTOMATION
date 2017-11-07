package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
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
		 GetAQuote.click();
		 return new GetAQuotePage(this.driver);
	 }
	 
	 public void ClickFind()
	 {
		 Find.click();
		
	 }
	 public FindQuotePage ClickFindQuote()
	 {
		 FindQuote.click();
		 return new FindQuotePage(this.driver);
	 }
	 public FindPolicyePage ClickFindPolicy()
	 {
		 FindPolicy.click();
		 return new FindPolicyePage(this.driver);
	 }
	 
	 public FindCustomerPage ClickFindCustomer()
	 {
		 FindCustomer.click();
		 return new FindCustomerPage(this.driver);
	 }
}
