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
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;

public class BusinessPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__Contact__FirstName1")WebElement FirstName1;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__Contact__LastName2")WebElement LastName2;
	@FindBy(xpath="//div[contains(.,'Primary Number')]//div[@id='BusinessTile:BusinessInformationForm:Object__Customer__CommunicationType']//span")List<WebElement> PrimaryNumberType;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Customer__PrimaryNumber")WebElement PrimaryNumber;
	@FindBy(xpath="//div[contains(.,'Alternate Number')]//div[@id='BusinessTile:BusinessInformationForm:Object__Customer__CommunicationSubType1']//span")List<WebElement> AlternateNumberType;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Customer__AlternativeNumber")WebElement AlternativeNumber;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Customer__AlternativeExtension")WebElement AlternativeExtension;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Customer__EmailAddress")WebElement EmailAddress;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__InsuredType")WebElement InsuredType;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__BusinessOtherDescription")WebElement BusinessOtherDescription;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__BusinessName1")WebElement BusinessName1;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__YearInBusiness")WebElement YearInBusiness;
	@FindBy(xpath="//div[@id='BusinessTile:BusinessInformationForm:Object__Risk__Driver__SSNFEIN']//span")List<WebElement> SSNorFEIN;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__Billing__Number")WebElement SSN_FEIN;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Insured__InsuredDescription")WebElement InsuredDescription;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Location__AddressLookup")WebElement AddressLookup;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Location__StreetNumberAddress1")WebElement Address1;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Location__StreetNameAddress2")WebElement Address2;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Location__City")WebElement City;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Location__StateRegionCode")WebElement State;
	@FindBy(id="BusinessTile:BusinessInformationForm:Object__Location__Zipcode1")WebElement Zipcode;
	@FindBy(xpath="//div[@id='BusinessTile:BusinessInformationForm:IsMailingAddressSame']//span")List<WebElement> IsMailingAddressSame;
	@FindBy(xpath="//span[@class='common_validation_error']")List<WebElement> validationError;
	@FindBy(xpath="//button[@id='BusinessTile:BusinessInformationForm:BusinessSave']//span[contains(.,'Coverage')]")WebElement Coverage;
	
	
	public BusinessPage(WebDriver driver) 
	{
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	}

	 public void setFirstName1(String firstname)
	 {
		 this.WaitWithVisibility(FirstName1,driver);
		 FirstName1.clear();
		 FirstName1.sendKeys(firstname);
		// FirstName1.sendKeys(Keys.ENTER);
		// this.waitForLoading();
		
	 }
	 
	 public void setLastName2(String lastname)
	 {
		 this.WaitWithVisibility(LastName2,driver);
		 LastName2.clear();
		 LastName2.sendKeys(lastname);
		 //LastName2.sendKeys(Keys.ENTER);
		// this.waitForLoading();
		
	 }
	 
	 public void ClickPrimaryCommunicationType(String Type)
	 {
		 for(int i=0; i<PrimaryNumberType.size(); i++)
			{
			if(PrimaryNumberType.get(i).getText().equals(Type))
			{
				PrimaryNumberType.get(i).click();
				break;
			}
			}	
	 }
	 public void setPrimaryNumber(String primarynumber)
	 {
		 this.WaitWithVisibility(PrimaryNumber,driver);
		 PrimaryNumber.clear();
		 PrimaryNumber.sendKeys(primarynumber);
		// PrimaryNumber.sendKeys(Keys.ENTER);
		// this.waitForLoading();
		
	 }
	 public void ClickAlternateNumberType(String Type)
	 {
		 for(int i=0; i<AlternateNumberType.size(); i++)
			{
			if(AlternateNumberType.get(i).getText().equals(Type))
			{
				AlternateNumberType.get(i).click();
				break;
			}
			}	
	 }
	 public void setAlternativeNumber(String alternativeNumber)
	 {
		 this.WaitWithVisibility(AlternativeNumber,driver);
		 AlternativeNumber.clear();
		 AlternativeNumber.sendKeys(alternativeNumber);
		 //AlternativeNumber.sendKeys(Keys.ENTER);
		 //this.waitForLoading();
		
	 }
	 public void setAlternativeExtension(String alternativeExtension)
	 {
		 this.WaitWithVisibility(AlternativeExtension,driver);
		 AlternativeExtension.clear();
		 AlternativeExtension.sendKeys(alternativeExtension);
		 //AlternativeExtension.sendKeys(Keys.ENTER);
		 //this.waitForLoading();
		
	 }
	 public void setEmailAddress(String emailAddress)
	 {
		 this.WaitWithVisibility(EmailAddress,driver);
		 EmailAddress.clear();
		 EmailAddress.sendKeys(emailAddress);
		// EmailAddress.sendKeys(Keys.ENTER);
		// this.waitForLoading();
		
	 }
	
	 public void selectTypeOfBusiness(String insuredType)
	 {
		 this.WaitWithVisibility(InsuredType,driver);
		 try
		 {
		 Select dropdown = new Select(InsuredType);
		 dropdown.selectByVisibleText(insuredType);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(InsuredType);
			 dropdown.selectByVisibleText(insuredType);
		 }
		// this.waitForLoading();
	 }
	 public void setBusinessOtherDescription(String descriptionforOther)
	 {
		 this.WaitWithVisibility(BusinessOtherDescription,driver);
		 BusinessOtherDescription.clear();
		 BusinessOtherDescription.sendKeys(descriptionforOther);
		// BusinessOtherDescription.sendKeys(Keys.ENTER);
		// this.waitForLoading();
		
	 }
	 public void setBusinessName1(String businessName1)
	 {
		 this.WaitWithVisibility(BusinessName1,driver);
		 BusinessName1.clear();
		 BusinessName1.sendKeys(businessName1);
		// BusinessName1.sendKeys(Keys.ENTER);
		// this.waitForLoading();
		
	 }
	 public void setYearInBusiness(String yearInBusiness)
	 {
		 this.WaitWithVisibility(YearInBusiness,driver);
		 YearInBusiness.clear();
		 YearInBusiness.sendKeys(yearInBusiness);
		// YearInBusiness.sendKeys(Keys.ENTER);
		 //this.waitForLoading();
	 }
	 
	 public void ClickSSNorFEIN(String Type)
	 {
		 for(int i=0; i<SSNorFEIN.size(); i++)
			{
			if(SSNorFEIN.get(i).getText().equals(Type))
			{
				SSNorFEIN.get(i).click();
				break;
			}
			}	
	 }
	 
	 public void setSSN_FEIN(String ssnfein)
	 {
		 this.WaitWithVisibility(SSN_FEIN,driver);
		 SSN_FEIN.clear();
		 SSN_FEIN.sendKeys(ssnfein);
		 //SSN_FEIN.sendKeys(Keys.ENTER);
		 //this.waitForLoading();
	 }
	 
	 public void setInsuredDescription(String insuredDescription)
	 {
		 this.WaitWithVisibility(InsuredDescription,driver);
		 InsuredDescription.clear();
		 InsuredDescription.sendKeys(insuredDescription);
	 }
	 public void setAddressLookup(String addressLookup)
	 {
		 this.WaitWithVisibility(AddressLookup,driver);
		 AddressLookup.clear();
		 AddressLookup.sendKeys(addressLookup);
		
		
	 }
	 public void setAddress1(String address1)
	 {
		 try
		 {
		 this.WaitWithVisibility(Address1,driver);
		 Address1.clear();
		 Address1.sendKeys(address1);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 this.WaitWithVisibility(Address1,driver);
			 Address1.clear();
			 Address1.sendKeys(address1);
		 }
		
		
	 }
	 public void setAddress2(String address2)
	 {
		 try
		 {
		 this.WaitWithVisibility(Address2,driver);
		 Address2.clear();
		 Address2.sendKeys(address2);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 this.WaitWithVisibility(Address2,driver);
			 Address2.clear();
			 Address2.sendKeys(address2);
		 }
		
		 
	 }
	 public void setCity(String city)
	 {
		 try
		 {
		 this.WaitWithVisibility(City,driver);
		 City.clear();
		 City.sendKeys(city);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 this.WaitWithVisibility(City,driver);
			 City.clear();
			 City.sendKeys(city);
		 }
		
		
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
        try
	    {
		 this.WaitWithVisibility(Zipcode,driver);
		 Zipcode.clear();
		 Zipcode.sendKeys(zipcode);
	    }
        catch(StaleElementReferenceException e)
        {
        this.WaitWithVisibility(Zipcode,driver);
   		 Zipcode.clear();
   		 Zipcode.sendKeys(zipcode);
        }
		 
	 }
	 
	 public void ClickIsMailingAddressSame(String isMailingAddressSame)
	 {
		 for(int i=0; i<IsMailingAddressSame.size(); i++)
			{
			if(IsMailingAddressSame.get(i).getText().equals(isMailingAddressSame))
			{
				IsMailingAddressSame.get(i).click();
				break;
			}
			}	
	 }
	 
	 public boolean CheckValidtaionError(String Message)
	 {
		 boolean result=false;
		 for(int i=0; i<validationError.size(); i++)
			{
			if(validationError.get(i).getText().equals("Message"))
			{
				result=true;
			}
			else
			{
				result=false;
			}
			}	
		 return result;
	 }
	 
	 public CoveragePage ClickCoverage()
	 {
		 this.WaitWithVisibility(Coverage,driver);
		 try
		 {
			 Coverage.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Coverage.click();
		 }
		 this.waitForLoading();
		 return new CoveragePage(this.driver);
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
	 
	 
	 public void FillBusinessDetails(LinkedHashMap<String, String> inputrow)
	 {
		 this.setFirstName1(inputrow.get("FirstName"));
		 this.setLastName2(inputrow.get("LastName"));
		 this.setPrimaryNumber(inputrow.get("PrimaryNumber"));
		 this.setAlternativeNumber("1234569870");
		 this.setEmailAddress(inputrow.get("EmailAddress"));
		 this.selectTypeOfBusiness(inputrow.get("TypeOfBusiness"));
		 this.setBusinessName1(inputrow.get("BusinessName"));
		 this.setYearInBusiness(inputrow.get("NumberOfYearsInBusiness"));
		 this.ClickSSNorFEIN(inputrow.get("SSN_FEINChoice"));
		 this.setSSN_FEIN(inputrow.get("SSN_FEIN_no"));
		 this.setInsuredDescription(inputrow.get("DescriptionOfOperation"));

		 //this.setAddress2(inputrow.get("AddressLine2"));
		 this.selectState(inputrow.get("State"));
		 this.setZipcode(inputrow.get("ZipCode"));
		 this.setAddress1(inputrow.get("AddressLine1"));
		 this.setAddress2(inputrow.get("AddressLine2"));
		 this.setCity(inputrow.get("City"));
		 this.ClickIsMailingAddressSame(inputrow.get("MailingAddressChoice"));
	 }
	 
	
}
