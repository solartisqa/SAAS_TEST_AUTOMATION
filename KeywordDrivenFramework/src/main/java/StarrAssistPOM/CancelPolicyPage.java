package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelPolicyPage 
{
	private WebDriver driver;
	
	 @FindBy(id="Welcome:CancelConfirm:agreeCheck1")WebElement CancelPolicyCheck;
	 @FindBy(id="Welcome:CancelConfirm:CancelBtn")WebElement CancelPolicy;
	
	 public CancelPolicyPage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void ClickCancelPolicyCheck()
	 {
		 CancelPolicyCheck.click();
		
	 }
	 public PolicyInformationPage ClickSaveandcontinue()
	 {
		 CancelPolicy.click();
		 return new PolicyInformationPage(this.driver);
	 }
	 
}
