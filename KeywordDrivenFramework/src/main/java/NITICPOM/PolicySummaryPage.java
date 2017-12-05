package NITICPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BasePage.BasePage;

public class PolicySummaryPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__PolicyNumber")WebElement PolicyNumber;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__PolicyType")WebElement PolicyType;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__PolicyStatus")WebElement PolicyStatus;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__EffectiveDate")WebElement EffectiveDate;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__ExpirationDate")WebElement ExpirationDate;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__Liability__TotalPremium")WebElement LiabilityTotalPremium;
	
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__TotalPremium")WebElement TotalPremium;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__TotalDownPayment")WebElement TotalDownPayment;
	@FindBy(id="PolicyHeaderTile:PolicyHeaderForm:Object__Policy__TotalMonthlyPayment")WebElement TotalMonthlyPayment; 
	@FindBy(xpath="//button[contains(.,'Policy Summary')]")WebElement PolicySummary;
	@FindBy(xpath="//button[contains(.,'Go to Quote Summary')]")WebElement GotoQuoteSummary;
	@FindBy(xpath="//button[contains(.,'Documents')]")WebElement Documents;
	@FindBy(xpath="//tbody[contains(.,'Endorsement')]//td[2]")WebElement Endorsement;
	

	public PolicySummaryPage(WebDriver driver)
	{
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	}
	
	public String getPolicyNumber()
	 {
		 this.WaitWithVisibility(PolicyNumber,driver);
		 if(PolicyNumber.isDisplayed())
		 {
			 return PolicyNumber.getText();
		 }
		 
		 return "";
	 }
	
	public String getPolicyType()
	 {
		 this.WaitWithVisibility(PolicyType,driver);
		 if(PolicyType.isDisplayed())
		 {
			 return PolicyType.getText();
		 }
		 
		 return "";
	 }
	
	public String getPolicyStatuss()
	 {
		 this.WaitWithVisibility(PolicyStatus,driver);
		 if(PolicyStatus.isDisplayed())
		 {
			 return PolicyStatus.getText();
		 }
		 
		 return "";
	 }
	
	public String getEffectiveDate()
	 {
		 this.WaitWithVisibility(EffectiveDate,driver);
		 if(EffectiveDate.isDisplayed())
		 {
			 return EffectiveDate.getText();
		 }
		 
		 return "";
	 }
	
	public String getExpirationDate()
	 {
		 this.WaitWithVisibility(ExpirationDate,driver);
		 if(ExpirationDate.isDisplayed())
		 {
			 return ExpirationDate.getText();
		 }
		 
		 return "";
	 }
	
	public String getLiabilityTotalPremium()
	 {
		 this.WaitWithVisibility(LiabilityTotalPremium,driver);
		 if(LiabilityTotalPremium.isDisplayed())
		 {
			 return LiabilityTotalPremium.getText();
		 }
		 
		 return "";
	 }
	

	
	public String getTotalPremium()
	 {
		 this.WaitWithVisibility(TotalPremium,driver);
		 if(TotalPremium.isDisplayed())
		 {
			 return TotalPremium.getText();
		 }
		 
		 return "";
	 }
	
	public String getTotalDownPayment()
	 {
		 this.WaitWithVisibility(TotalDownPayment,driver);
		 if(TotalDownPayment.isDisplayed())
		 {
			 return TotalDownPayment.getText();
		 }
		 
		 return "";
	 }
	
	public String getTotalMonthlyPayment()
	 {
		 this.WaitWithVisibility(TotalMonthlyPayment,driver);
		 if(TotalMonthlyPayment.isDisplayed())
		 {
			 return TotalMonthlyPayment.getText();
		 }
		 
		 return "";
	 }
	
	
	 public EndorsementPage ClickEndorsementAccordian()
	 {
		 this.WaitWithVisibility(Endorsement,driver);
		 Endorsement.click();
		 this.waitForLoading();
		 return new EndorsementPage(this.driver);
	}
	
	 public void ClickPolicySummary()
	 {
		 this.WaitWithVisibility(PolicySummary,driver);
		 PolicySummary.click();
		 this.waitForLoading();
	}
	 
	 public DocumentsPage ClickDocuments()
	 {
		 this.WaitWithVisibility(Documents,driver);
		 Documents.click();
		 this.waitForLoading();
		 return new DocumentsPage(this.driver);
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
	
	
	
	
	
	
	
	
	
	
}
