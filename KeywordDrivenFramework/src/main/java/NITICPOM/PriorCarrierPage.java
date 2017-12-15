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

import BasePage.BasePage;

public class PriorCarrierPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(xpath="//button[contains(.,'Shareholder')]")WebElement Shareholder;
    @FindBy(xpath="//button[contains(.,'Additional Insured')]")WebElement AdditionalInsured;
	@FindBy(xpath="//button[contains(.,'Add Prior Carrier')]")WebElement AddPriorCarrier;
	@FindBy(id="PriorCarrierInfoTile:priorCarrierinfo:Object__PriorCarrierInfo__CarrierName")WebElement CarrierName;
	@FindBy(id="PriorCarrierInfoTile:priorCarrierinfo:Object__PriorCarrierInfo__PolicyNo")WebElement PolicyNo;
    @FindBy(id="PriorCarrierInfoTile:priorCarrierinfo:Object__PriorCarrierInfo__EffectiveDate")WebElement EffectiveDate;
    @FindBy(id="PriorCarrierInfoTile:priorCarrierinfo:Object__PriorCarrierInfo__ExpirationDate")WebElement ExpirationDate;
	@FindBy(xpath="//div[@id='PriorCarrierInfoTile:priorCarrierinfo:Object__PriorCarrierInfo__CoverageTypeVal']//span"  )List<WebElement> CoverageTypeVal;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Cancel')]")WebElement Cancel;
	
	
	public PriorCarrierPage(WebDriver driver)
	{
		super(driver);
	}
	
	 private boolean isInitialized(boolean displayed)
	 {
		
		return AddPriorCarrier.isDisplayed();
	}
	 
	 public void ClickAddPriorCarrier()
	 {
		 this.WaitWithVisibility(AddPriorCarrier,driver);
		 try
		 {
			 AddPriorCarrier.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AddPriorCarrier.click();
		 }
		 this.waitForLoading();
	 }
	

	 public void ClickAdditionalInsured()
	 {
		 this.WaitWithVisibility(AdditionalInsured,driver);
		 try
		 {
			 AdditionalInsured.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AdditionalInsured.click();
		 }
		 this.waitForLoading();
	 }
	
	 public void setCarrierName(String carrierName)
	 {
		 this.WaitWithVisibility(CarrierName,driver);
		 CarrierName.clear();
		 CarrierName.sendKeys(carrierName);
		
	 }
	 public void setPolicyNo(String policyNo)
	 {
		 this.WaitWithVisibility(PolicyNo,driver);
		 PolicyNo.clear();
		 PolicyNo.sendKeys(policyNo);
		
	 }
	
	 public void setEffectiveDate(String effectiveDate)
	 {
		 this.WaitWithVisibility(EffectiveDate,driver);
		 EffectiveDate.clear();
		 EffectiveDate.sendKeys(effectiveDate);
		 EffectiveDate.sendKeys(Keys.ENTER);
		
	 }
	 public void setExpirationDate(String expirationDate)
	 {
		 this.WaitWithVisibility(ExpirationDate,driver);
		 ExpirationDate.clear();
		 ExpirationDate.sendKeys(expirationDate);
		 ExpirationDate.sendKeys(Keys.ENTER);
		
	 }
	 public void ClickCoverageTypeVal(String coverageTypeVal)
	 {
		 for(int i=0; i<CoverageTypeVal.size(); i++)
			{
			if(CoverageTypeVal.get(i).getText().equals(coverageTypeVal))
			{
				CoverageTypeVal.get(i).click();
				break;
			}
			}	
	  }
	
	
	 public void ClickSave()
	 {
		 this.WaitWithVisibility(Save,driver);
		 try
		 {
			 Save.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Save.click();
		 }
		 this.waitForLoading();
	 }
	 
	 public void ClickCancel()
	 {
		 this.WaitWithVisibility(Cancel,driver);
		 try
		 {
			 Cancel.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Cancel.click();
		 }
		 this.waitForLoading();
	 }
	 
	 
	 public ShareholderPage ClickShareholder()
	 {
		 this.WaitWithVisibility(Shareholder,driver);
		 try
		 {
			 Shareholder.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Shareholder.click();
		 }
		 this.waitForLoading();
		 return new ShareholderPage(this.driver);
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
	 
	 
	 public void FillPriorCarrier(LinkedHashMap<String, String> inputrow)
	 {
		 this.ClickAddPriorCarrier();
		 this.setCarrierName(inputrow.get("CarrierName"));
		 this.setPolicyNo(inputrow.get("PolicyNo"));
		 this.setEffectiveDate(inputrow.get("PriorEffectiveDate"));
		 this.setExpirationDate(inputrow.get("PriorExpirationDate"));
		 this.ClickCoverageTypeVal(inputrow.get("CoverageType"));
		 this.ClickSave();
		 
	 }
}
