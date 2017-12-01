package NITICPOM;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class EndorsementPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(xpath="//button[contains(.,'Add Endorsement')]")WebElement AddEndorsement;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Vehicle')]")WebElement Vehicle;
	@FindBy(xpath="//button[contains(.,'Business')]")WebElement Business;
	@FindBy(xpath="//button[contains(.,'Issue Endorsement')]")WebElement IssueEndorsement;
	@FindBy(xpath="//span[contains(.,'Yes')]")List<WebElement> IssueEndorsementYes;
	@FindBy(xpath="//span[contains(.,'No')]")WebElement IssueEndorsementNo;
	
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Policy__PolicyNumber")WebElement PolicyNumber;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Policy__TotalPremium")WebElement TotalPremium;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Policy__TotalDownPayment")WebElement TotalDownPayment;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Policy__TotalMonthlyPayment")WebElement TotalMonthlyPayment;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Policy__EffectiveDate")WebElement EffectiveDate;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Policy__ExpirationDate")WebElement ExpirationDate;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Quote__QuoteNumber")WebElement QuoteNumber;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Endorsement__Liability__Premium")WebElement TotalEndorsementPremium;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Endorsement__AdjustedDownPayment")WebElement newAdjustedDownPayment;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Quote__TotalMonthlyPayment")WebElement newTotalMonthlyPayment;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Quote__EffectiveDate")WebElement EndorsementEffectiveDate;
	@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Endorsement__ProrataFactor")WebElement ProrataFactor;
	
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Plan__LiabilityLimitType")WebElement LiabilityLimitType;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Plan__CombinedLimitofLiabilityType1")WebElement CombinedLimitofLiabilityType1;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Plan__SplitLimitofLiability")WebElement SplitLimitofLiability;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Liability__PerVehiclePremium")WebElement LiabilityPerVehiclePremium;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Quote__QuoteStartDate")WebElement QuoteStartDate;
	//@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Endorsement__ProrataFactor")WebElement ProrataFactor;
	//@FindBy(id="EndorsementHeaderTile:EndorsementHeaderForm:Object__Endorsement__ProrataFactor")WebElement ProrataFactor;
	
	
	public EndorsementPage(WebDriver driver)
	{
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	}
	
	 public void ClickAddEndorsement()
	 {
		 this.WaitWithVisibility(AddEndorsement,driver);
		 AddEndorsement.click();
		
	 }
	
	 public void selectLiabilityLimitType(String liabilityLimitType)
	 {
		 Select dropdown = new Select(LiabilityLimitType);
		 dropdown.selectByVisibleText(liabilityLimitType);
	 }
	 
	 public void selectCombinedLimitofLiability(String combinedLimitofLiabilityType1)
	 {
		 this.WaitWithVisibility(CombinedLimitofLiabilityType1,driver);
		 Select dropdown = new Select(CombinedLimitofLiabilityType1);
		 dropdown.selectByVisibleText(combinedLimitofLiabilityType1);
	 }
	 
	 public void selectSplitLimitofLiability(String splitLimitofLiability)
	 {
		 this.WaitWithVisibility(SplitLimitofLiability,driver);
		 Select dropdown = new Select(SplitLimitofLiability);
		 dropdown.selectByVisibleText(splitLimitofLiability);
	 }
	 
	 public void setQuoteStartDate(String quoteStartDate)
	 {
		 this.WaitWithVisibility(QuoteStartDate,driver);
		 QuoteStartDate.clear();
		 QuoteStartDate.sendKeys(quoteStartDate);
		 QuoteStartDate.sendKeys(Keys.ENTER);
				
	 }
	 
	 public void ClickSave()
	 {
		 this.WaitWithVisibility(Save,driver);
		 Save.click();
	 }
	 public void ClickIssueEndorsement()
	 {
		 this.WaitWithVisibility(IssueEndorsement,driver);
		 IssueEndorsement.click();
	 }
	 
	 public DocumentsPage ClickIssueEndorsementYes()
	 {
		 for(int i=0; i<IssueEndorsementYes.size(); i++)
			{
			if(IssueEndorsementYes.get(i).getText().equals("Yes"))
			{
				IssueEndorsementYes.get(i).click();
				break;
			}
			}	
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
	 
	 public void EditEndorsementPage(LinkedHashMap<String, String> inputrow)
	 {
		 
		 this.ClickAddEndorsement();
		 this.setQuoteStartDate("11/30/2017");
		 this.ClickSave();
		 this.ClickIssueEndorsement();
	 }
	
}
