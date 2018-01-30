package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BasePage;

public class CancelPolicyPage extends BasePage
{

	
	 @FindBy(id="Welcome:CancelConfirm:agreeCheck1")WebElement CancelPolicyCheck;
	 @FindBy(id="Welcome:CancelConfirm:CancelBtn")WebElement CancelPolicy;
	
	 public CancelPolicyPage(WebDriver driver)
	 {
		 super(driver);
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
