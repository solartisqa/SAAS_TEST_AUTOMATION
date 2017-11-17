package NITICPOM;

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

public class DriverPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(xpath="//button[contains(.,'Add Driver')]")WebElement AddDriver;
	@FindBy(xpath="//button[contains(.,'Additional Insured')]")WebElement AdditionalInsured;
	@FindBy(xpath="//button[contains(.,'Vehicle')]")WebElement VehiclePage;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__Name")WebElement DriverName;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__DOB")WebElement DriverDOB;
	@FindBy(xpath="//div[@id='DriversTile:DriverInformation:Object__Driver__Gender']//span")List<WebElement> Gender;
	@FindBy(id="DriversTile:DriverInformation:Object__Driver__MaritalStatus")WebElement MaritalStatus;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__SSNorFEIN")WebElement SSNorFEIN;
	@FindBy(id="DriversTile:DriverInformation:Object__Vehicle__GaragingAddress__AddressLookup")WebElement AddressLookup;
	@FindBy(id="DriversTile:DriverInformation:Object__Vehicle__GaragingAddress__StreetNumberAddress1")WebElement Address1;
	@FindBy(id="DriversTile:DriverInformation:Object__Vehicle__GaragingAddress__StreetNameAddress2")WebElement Address2;
	@FindBy(id="DriversTile:DriverInformation:Object__Vehicle__GaragingAddress__City")WebElement City;
	@FindBy(id="DriversTile:DriverInformation:Object__Vehicle__GaragingAddress__StateRegionCode")WebElement State;
	@FindBy(id="DriversTile:DriverInformation:Object__Vehicle__GaragingAddress__Zipcode1")WebElement Zipcode;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__LicenseNumber")WebElement LicenseNumber;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__FirstLicensedYear")WebElement FirstLicensedYear;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__Experience")WebElement Experience;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__StateLicensed")WebElement StateLicensed;
	@FindBy(xpath="//div[@id='DriversTile:DriverInformation:Object__Risk__Driver__AnyAccident']//span")List<WebElement> AnyAccident;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__AccidentDescription")WebElement AccidentDescription;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Cancel')]")List<WebElement> Cancel;
	
	
	
	
	public DriverPage(WebDriver driver)
	{
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	}
	
	public void ClickAddDriver()
	 {
		 this.WaitWithVisibility(AddDriver,driver);
		 try
		 {
			 AddDriver.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AddDriver.click();
		 }
		 this.waitForLoading();
		 
	 }
	
	public void setDriverName(String driverName)
	 {
		 this.WaitWithVisibility(DriverName,driver);
		 DriverName.clear();
		 DriverName.sendKeys(driverName);
		 
	 }
	
	public void setDriverDOB(String driverDOB)
	 {
		 this.WaitWithVisibility(DriverDOB,driver);
		 DriverDOB.clear();
		 DriverDOB.sendKeys(driverDOB);
		 DriverDOB.sendKeys(Keys.ENTER);
		this.waitForLoading();
		
	 }
	
	 public void ClickIsMailingAddressSame(String gender)
	 {
		 for(int i=0; i<Gender.size(); i++)
			{
			if(Gender.get(i).getText().equals(gender))
			{
				Gender.get(i).click();
				break;
			}
			}	
	  }
	 
	 public void selectMaritalStatus(String maritalStatus)
	 {
		 this.WaitWithVisibility(MaritalStatus,driver);
		 try
		 {
		 Select dropdown = new Select(MaritalStatus);
		 dropdown.selectByVisibleText(maritalStatus);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(MaritalStatus);
			 dropdown.selectByVisibleText(maritalStatus);
		 }
		 
	 }
	 
	 public void setSSNorFEIN(String sSNorFEIN)
	 {
		 this.WaitWithVisibility(SSNorFEIN,driver);
		 SSNorFEIN.clear();
		 SSNorFEIN.sendKeys(sSNorFEIN);
		 SSNorFEIN.sendKeys(Keys.ENTER);
		this.waitForLoading();
		
	 } 
	 
	 public void setAddress1(String address1)
	 {
		 this.WaitWithVisibility(Address1,driver);
		 Address1.clear();
		 Address1.sendKeys(address1);
		 Address1.sendKeys(Keys.ENTER);
		this.waitForLoading();
		
	 } 
	 
	 public void setAddress2(String address1)
	 {
		 this.WaitWithVisibility(Address1,driver);
		 Address1.clear();
		 Address1.sendKeys(address1);
		 Address1.sendKeys(Keys.ENTER);
		this.waitForLoading();
		
	 }  
	 
	 public void setCity(String city)
	 {
		 this.WaitWithVisibility(City,driver);
		 City.clear();
		 City.sendKeys(city);
		 City.sendKeys(Keys.ENTER);
		this.waitForLoading();
		
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
	
	 public void setZipCode(String zipCode)
	 {
		 this.WaitWithVisibility(Zipcode,driver);
		 Zipcode.clear();
		 Zipcode.sendKeys(zipCode);
		 Zipcode.sendKeys(Keys.ENTER);  //FirstLicensedYear
		this.waitForLoading();
		
	 }  
	 
	 public void setLicenseNumber(String licenseNumber)
	 {
		 this.WaitWithVisibility(LicenseNumber,driver);
		 LicenseNumber.clear();
		 LicenseNumber.sendKeys(licenseNumber);
		 LicenseNumber.sendKeys(Keys.ENTER);  
		this.waitForLoading();
		
	 }  
	 
	 public void setFirstLicensedYear(String firstLicensedYear)
	 {
		 this.WaitWithVisibility(FirstLicensedYear,driver);
		 FirstLicensedYear.clear();
		 FirstLicensedYear.sendKeys(firstLicensedYear);
		 FirstLicensedYear.sendKeys(Keys.ENTER);  //FirstLicensedYear
		this.waitForLoading();
	 }  
	 
	 public void setExperience(String experience)
	 {
		 this.WaitWithVisibility(Experience,driver);
		 Experience.clear();
		 Experience.sendKeys(experience);
		 Experience.sendKeys(Keys.ENTER);  //FirstLicensedYear
		this.waitForLoading();
	 }  
	 
	 public void selectStateLicensed(String stateLicensed)
	 {
		 this.WaitWithVisibility(StateLicensed,driver);
		 try
		 {
		 Select dropdown = new Select(StateLicensed);
		 dropdown.selectByVisibleText(stateLicensed);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(StateLicensed);
			 dropdown.selectByVisibleText(stateLicensed);
		 }
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
