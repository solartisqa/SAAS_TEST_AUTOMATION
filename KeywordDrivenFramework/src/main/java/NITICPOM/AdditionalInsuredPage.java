package NITICPOM;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class AdditionalInsuredPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(xpath="//button[contains(.,'Add Additional Insured')]")WebElement AddAdditionalInsured;
	@FindBy(xpath="//button[contains(.,'Prior Carrier ')]")WebElement PriorCarrier;
	@FindBy(xpath="//button[contains(.,'Driver')]")WebElement Driver;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__Insured__AdditionalInsured__FirstName")WebElement AIFirstName;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__AddressLookup")WebElement AddressLookup;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__AddressLine1")WebElement AddressLine1;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__AddressLine2")WebElement AddressLine2;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__City")WebElement City;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__StateRegionCode")WebElement State;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__Zipcode")WebElement Zipcode;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__Insured__AdditionalInsured__Description")WebElement AdditionalInsuredDescription;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Cancel')]")WebElement Cancel;
	
	
	public AdditionalInsuredPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	 private boolean isInitialized(boolean displayed)
	 {
		
		return AIFirstName.isDisplayed();
	}

	public void ClickAddAdditionalInsured()
	 {
		 this.WaitWithVisibility(AddAdditionalInsured,driver);
		 try
		 {
			 AddAdditionalInsured.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AddAdditionalInsured.click();
		 }
		 this.waitForLoading();
	 }
	 
	 
	 public void setAIFirstName(String firstname)
	 {
		 this.WaitWithVisibility(AIFirstName,driver);
		 AIFirstName.clear();
		 AIFirstName.sendKeys(firstname);
		
	 }
	
	 public void setAddressLookup(String addressLookup)
	 {
		 this.WaitWithVisibility(AddressLookup,driver);
		 AddressLookup.clear();
		 AddressLookup.sendKeys(addressLookup);
		
	 }
	 public void setAddressLine1(String addressLine1)
	 {
		 this.WaitWithVisibility(AddressLine1,driver);
		 AddressLine1.clear();
		 AddressLine1.sendKeys(addressLine1);
		
	 }
	 public void setAddressLine2(String addressLine2)
	 {
		 this.WaitWithVisibility(AddressLine2,driver);
		 AddressLine2.clear();
		 AddressLine2.sendKeys(addressLine2);
		
	 }
	 public void setCity(String city)
	 {
		 this.WaitWithVisibility(City,driver);
		 City.clear();
		 City.sendKeys(city);
		
	 }
	 
	 public void selectState(String state)
	 {
		 this.WaitWithVisibility(State,driver);
		 try
		 {
		 Select dropdown = new Select(State);
		 dropdown.selectByVisibleText(state);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(State);
			 dropdown.selectByVisibleText(state);
		 }
		 
	 }
	 
	 public void setZipcode(String zipcode)
	 {
		 this.WaitWithVisibility(Zipcode,driver);
		 Zipcode.clear();
		 Zipcode.sendKeys(zipcode);
		
	 }
	 public void setAdditionalInsuredDescription(String description)
	 {
		 this.WaitWithVisibility(AdditionalInsuredDescription,driver);
		 AdditionalInsuredDescription.clear();
		 AdditionalInsuredDescription.sendKeys(description);
		
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
		// this.waitForLoading();
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
	 
	 public PriorCarrierPage ClickPriorCarrier()
	 {
		 this.WaitWithVisibility(PriorCarrier,driver);
		 try
		 {
			 PriorCarrier.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 PriorCarrier.click();
		 }
		 this.waitForLoading();
		 return new PriorCarrierPage(this.driver);
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
	 
	 public void FillAdditionalInsured(LinkedHashMap<String, String> inputrow)
	 {
		 this.ClickAddAdditionalInsured();
		 this.setAIFirstName(inputrow.get("AIName"));
		
		 this.setAddressLine1(inputrow.get("AddressLine1"));
		
		 this.setCity(inputrow.get("City"));
		 this.selectState(inputrow.get("State"));
		 this.setZipcode(inputrow.get("ZipCode"));
		 //this.setAdditionalInsuredDescription(inputrow.get("FirstName"));
		 this.ClickSave();
		 
	 }
	
}
