package NITICPOM;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__NumberOfAccident")WebElement NumberOfAccident;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__NumberOfTicket")WebElement NumberOfTicket;
	@FindBy(id="DriversTile:DriverInformation:Object__Risk__Driver__AccidentDescription")WebElement AccidentDescription;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Cancel')]")List<WebElement> Cancel;
	
	@FindBy(xpath="//span[contains(.,'Add Accident/Violation History')]")WebElement AddAccident;
	@FindBy(xpath="//div[contains(.,'DriversTile:DriverInformation:Object__Driver__Accident__IncidentType')]//span")List<WebElement> IncidentType;
	@FindBy(id="DriversTile:DriverInformation:Object__Driver__Accident__Date")WebElement AccidentDate;
	@FindBy(id="DriversTile:DriverInformation:Object__Driver__Accident__Place'")WebElement AccidentPlace;
	@FindBy(id="DriversTile:DriverInformation:driverNameList:Object__Risk__Driver__VehicleDriverID")WebElement AccNameofDriver;
	@FindBy(id="DriversTile:DriverInformation:Object__Driver__Accident__Description")WebElement AccDescription;
	@FindBy(id="DriversTile:DriverInformation:Violation_SubViewDate:Object__Driver__Accident__Date")WebElement ViolationAccidentDate;
	@FindBy(id="DriversTile:DriverInformation:Violation_SubViewDesc:Object__Driver__Accident__Description")WebElement ViolationAccDescription;
    @FindBy(id="DriversTile:DriverInformation:driverNameList:Violation_SubView:Object__Risk__Driver__VehicleDriverID")WebElement ViolationNameofDriver;
	
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
				
	 }
	
	 public void ClickGender(String gender)
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
		
		
	 } 
	 
	 public void setAddress1(String address1)
	 {
		 this.WaitWithVisibility(Address1,driver);
		 Address1.clear();
		 Address1.sendKeys(address1);
		
		
	 } 
	 
	 public void setAddress2(String address1)
	 {
		 this.WaitWithVisibility(Address1,driver);
		 Address1.clear();
		 Address1.sendKeys(address1);
		
		
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
	
	 public void setZipCode(String zipCode)
	 {
		 this.WaitWithVisibility(Zipcode,driver);
		 Zipcode.clear();
		 Zipcode.sendKeys(zipCode);
		
		
	 }  
	 
	 public void setLicenseNumber(String licenseNumber)
	 {
		 this.WaitWithVisibility(LicenseNumber,driver);
		 LicenseNumber.clear();
		 LicenseNumber.sendKeys(licenseNumber);
		
		
	 }  
	 
	 public void setFirstLicensedYear(String firstLicensedYear)
	 {
		 this.WaitWithVisibility(FirstLicensedYear,driver);
		 FirstLicensedYear.clear();
		 FirstLicensedYear.sendKeys(firstLicensedYear);
		
	 }  
	 
	 public void setExperience(String experience)
	 {
		 this.WaitWithVisibility(Experience,driver);
		 Experience.clear();
		 Experience.sendKeys(experience);

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
	 
	 
	 public void ClickAnyAccident(String anyAccident)
	 {
		 for(int i=0; i<AnyAccident.size(); i++)
			{
			if(AnyAccident.get(i).getText().equals(anyAccident))
			{
				AnyAccident.get(i).click();
				break;
			}
			}	
	  }
	 
	 public void setNumberOfAccident(String numberOfAccident)
	 {
		 this.WaitWithVisibility(NumberOfAccident,driver);
		 NumberOfAccident.clear();
		 NumberOfAccident.sendKeys(numberOfAccident);

	 }  
	 
	 public void setNumberOfTicket(String numberOfTicket)
	 {
		 this.WaitWithVisibility(NumberOfTicket,driver);
		 NumberOfTicket.clear();
		 NumberOfTicket.sendKeys(numberOfTicket);

	 }  
	 
	 
	 public void setAccidentDescription(String accidentDescription)
	 {
		 this.WaitWithVisibility(AccidentDescription,driver);
		 AccidentDescription.clear();
		 AccidentDescription.sendKeys(accidentDescription);

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
			Cancel.get(0).click();
			this.waitForLoading();
		  }
		 

		 public void ClickAddAccident()
		 {
			AddAccident.click();
			this.waitForLoading();
		  }
		 
		 
		 public void ClickIncidentType(String incidentType)
		 {
			 for(int i=0; i<IncidentType.size(); i++)
				{
				if(IncidentType.get(i).getText().equals(incidentType))
				{
					IncidentType.get(i).click();
					break;
				}
				}	
		  }
		 
		 
		 public void setAccidentDate(String accidentDate)
		 {
			 this.WaitWithVisibility(AccidentDate,driver);
			 AccidentDate.clear();
			 AccidentDate.sendKeys(accidentDate);
			 AccidentDate.sendKeys(Keys.ENTER);
			this.waitForLoading();
			
		 }
		 
		 public void setAccidentPlace(String accidentPlace)
		 {
			 this.WaitWithVisibility(AccidentPlace,driver);
			 AccidentPlace.clear();
			 AccidentPlace.sendKeys(accidentPlace);
			
			
		 }	 
		 
		 public void selectAccNameofDriver(String accNameofDriver)
		 {
			 this.WaitWithVisibility(AccNameofDriver,driver);
			 try
			 {
			 Select dropdown = new Select(AccNameofDriver);
			 dropdown.selectByVisibleText(accNameofDriver);
			 }
			 catch(StaleElementReferenceException e)
			 {
				 Select dropdown = new Select(AccNameofDriver);
				 dropdown.selectByVisibleText(accNameofDriver);
			 }
		 }	 
		 	 
		 public void setAccDescription(String accDescription)
		 {
			 this.WaitWithVisibility(AccDescription,driver);
			 AccDescription.clear();
			 AccDescription.sendKeys(accDescription);

		 }   
		 public void setViolationAccidentDate(String violationAccidentDate)
		 {
			 this.WaitWithVisibility(ViolationAccidentDate,driver);
			 ViolationAccidentDate.clear();
			 ViolationAccidentDate.sendKeys(violationAccidentDate);
			 ViolationAccidentDate.sendKeys(Keys.ENTER);
			this.waitForLoading();
		  }
		 
		 public void setViolationAccDescription(String violationAccDescription)
		 {
			 this.WaitWithVisibility(ViolationAccDescription,driver);
			 ViolationAccDescription.clear();
			 ViolationAccDescription.sendKeys(violationAccDescription);

		 }   
		 
	
	 
	 public void selectViolationNameofDriver(String violationNameofDriver)
	 {
		 this.WaitWithVisibility(ViolationNameofDriver,driver);
		 try
		 {
		 Select dropdown = new Select(ViolationNameofDriver);
		 dropdown.selectByVisibleText(violationNameofDriver);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(ViolationNameofDriver);
			 dropdown.selectByVisibleText(violationNameofDriver);
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
	 
	 public void FillDriverDetails(LinkedHashMap<String, String> inputrow) throws InterruptedException
	 {
		 Thread.sleep(1000);
		 this.ClickAddDriver();
		 this.setDriverName(inputrow.get("DriverName"));
		 this.setDriverDOB(inputrow.get("DriverDOB"));
		 this.ClickGender(inputrow.get("Gender"));
		 this.selectMaritalStatus(inputrow.get("MaritalStatus"));
		 this.setSSNorFEIN(inputrow.get("SSN_FEIN_no"));
		 this.setAddress1(inputrow.get("AddressLine1"));
		 this.setAddress2(inputrow.get("AddressLine2"));
		 this.setCity(inputrow.get("City"));
		 this.selectState(inputrow.get("State"));
		 this.setZipCode(inputrow.get("ZipCode"));
		 this.setLicenseNumber(inputrow.get("LicenseNumber"));
		 this.setFirstLicensedYear(inputrow.get("YearFirstLicensed"));
		 this.setExperience(inputrow.get("YearsofExperience"));
		 this.selectStateLicensed(inputrow.get("State"));
		 if(inputrow.get("Accident").equals("Yes"))
		 {
			 this.ClickAnyAccident(inputrow.get("Accident"));
			 this.setNumberOfAccident(inputrow.get("NumberOfAccident"));
			 this.setNumberOfTicket(inputrow.get("NumberOfTicket"));
		 }
		 
		 this.ClickSave();
	 }
	 
	 
	 
	 public void FillAccidentViolationDetails(LinkedHashMap<String, String> inputrow) throws InterruptedException
	 {
		 this.ClickAddAccident();
		 this.ClickIncidentType(inputrow.get("AccidentType"));
		 if(inputrow.get("AccidentType").equals("Accident"))
		 {
		 this.setAccidentDate(inputrow.get("AccDate"));
		 this.setAccidentPlace(inputrow.get("AccPlace"));
		 this.selectAccNameofDriver(inputrow.get("DriverName"));
		 }
		 else
		 {
		 this.setViolationAccidentDate(inputrow.get("ViolationDate"));
		 this.selectViolationNameofDriver(inputrow.get("DriverName"));
		 }
		 this.ClickSave(); 
	 }
	  
	 
}
