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

public class CoveragePage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Risk__BusinessTypeName")WebElement BusinessTypeName;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Location__StateRegion_Static")WebElement State;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Risk__SubBusinessType")WebElement BusinessType;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Plan__LiabilityLimitType")WebElement LiabilityLimitType;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Plan__SplitLimitofLiability")WebElement SplitLimitofLiability;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Plan__CombinedLimitofLiabilityType1")WebElement CombinedLimitofLiabilityType;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Liability__PremiumPerVehicle")WebElement PremiumPerVehicle;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Quote__QuoteStartDate")WebElement QuoteStartDate;
	@FindBy(id="CoveragesTile:CoverageInformation:Object__Quote__QuoteEndDate1")WebElement QuoteEndDate;
	@FindBy(xpath="//button[contains(.,'Business')]")WebElement Business;
	@FindBy(xpath="//button[contains(.,'Vehicle')]")WebElement Vehicle;
	
		
	public CoveragePage(WebDriver driver) 
	{
		super(driver);
	}
	
	 private boolean isInitialized(boolean displayed)
	 {
	  return BusinessTypeName.isDisplayed();
	 }
	 
	 public void selectLiabilityLimitType(String Lltype)
	 {
		 this.WaitWithVisibility(LiabilityLimitType,driver);
		 try
		 {
		 Select dropdown = new Select(LiabilityLimitType);
		 dropdown.selectByVisibleText(Lltype);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(LiabilityLimitType);
			 dropdown.selectByVisibleText(Lltype);
		 }
		 
	 }
	
	 public void selectSplitLimitofLiability(String Value)
	 {
		 this.WaitWithVisibility(SplitLimitofLiability,driver);
		 try
		 {
		 Select dropdown = new Select(SplitLimitofLiability);
		 dropdown.selectByVisibleText(Value);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(SplitLimitofLiability);
			 dropdown.selectByVisibleText(Value);
		 }
		
	 }
	
	 public void selectCombinedLimitofLiability(String Value)
	 {
		 this.WaitWithVisibility(CombinedLimitofLiabilityType,driver);
		 try
		 {
		 Select dropdown = new Select(CombinedLimitofLiabilityType);
		 dropdown.selectByVisibleText(Value);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(CombinedLimitofLiabilityType);
			 dropdown.selectByVisibleText(Value);
		 }
		 
	 }
	
	 public void setPremiumPerVehicle(String VehiclePremium)
	 {
		 this.WaitWithVisibility(PremiumPerVehicle,driver);
		 PremiumPerVehicle.clear();
		 PremiumPerVehicle.sendKeys(VehiclePremium);
		 
	 }
	
	 public void setQuoteStartDate(String EffectiveDate)
	 {
		 this.WaitWithVisibility(QuoteStartDate,driver);
		 QuoteStartDate.clear();
		 QuoteStartDate.sendKeys(EffectiveDate);
		 QuoteStartDate.sendKeys(Keys.ENTER);
		this.waitForLoading();
		
	 }
	
	 public VehiclePage ClickVehicle()
	 {
		 this.WaitWithVisibility(Vehicle,driver);
		 try
		 {
			 Vehicle.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Vehicle.click();
		 }
		 this.waitForLoading();
		 return new VehiclePage(this.driver);
	 }
	
	 public BusinessPage ClickBusiness()
	 {
		 this.WaitWithVisibility(Business,driver);
		 try
		 {
			 Business.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Business.click();
		 }
		 this.waitForLoading();
		 return new BusinessPage(this.driver);
	 }
	
	public void FillCoverageDetails(LinkedHashMap<String, String> inputrow)
	{
		 this.selectLiabilityLimitType(inputrow.get("LiabilityLimitType"));//condition
		 if(inputrow.get("LiabilityLimitType").equals("Combined Single Limit"))
		 {
			 this.selectCombinedLimitofLiability(inputrow.get("PrimaryLiabilityLimit"));
		 }
		 else
		 {
			 this.selectSplitLimitofLiability(inputrow.get("PrimaryLiabilityLimit"));
		 }
		 this.setPremiumPerVehicle("1000");
		 this.setQuoteStartDate("11/18/2017");
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
