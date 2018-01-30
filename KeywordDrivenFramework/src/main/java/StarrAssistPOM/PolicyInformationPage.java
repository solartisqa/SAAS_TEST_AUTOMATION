package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BasePage;

public class PolicyInformationPage extends BasePage
{
	
	 @FindBy(xpath="//tbody[contains(@id,'BatchTravalerInformation')]//a[contains(@title,'Policy Summary')]")WebElement PolicyNumber;
	 @FindBy(id="endorsement:EndorsementForm:AddEndorsement")WebElement AddEndorsement;
	 @FindBy(xpath="//button//span[contains(.,'Cancel Policy')]")WebElement CancelPolicy;
	 @FindBy(xpath="//button//span[contains(.,'Compose Email')]")WebElement ComposeEmail;
	 @FindBy(xpath="//td[contains(.,'Total Policy Premium ')]/../td[2]")WebElement TotalPolicyPremium;
	 @FindBy(id="PolicyInformation:BatchPolicyStatus")WebElement PolicyStatus;
	
	
	
	 public PolicyInformationPage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 
	 public String getPolicyNumber()
	 {
		 String policyNumber=PolicyNumber.getText();
		 return policyNumber;
	 }
	 
	 public String getTotalPolicyPremium()
	 {
		 String totalPolicyPremium=TotalPolicyPremium.getText();
		 return totalPolicyPremium;
	 }
	 
	 public EndorsementPage ClickAddEndorsement()
	 {
		 AddEndorsement.click();
		 return new EndorsementPage(this.driver);
	 }
	 
	 public CancelPolicyPage ClickCancelPolicy()
	 {
		 CancelPolicy.click();
		 return new CancelPolicyPage(this.driver);
	 }
	 
	 public ComposeEmailPage ClickComposeEmail()
	 {
		 ComposeEmail.click();
		 return new ComposeEmailPage(this.driver);
	 }
	 
	 public String getPolicyStatus()
	 {
		 String policyStatus=PolicyStatus.getText();
		 return policyStatus;
	 }
	 
}
