package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BasePage;

public class TravellerInformationPage extends BasePage
{
	
	 @FindBy(xpath="//table/tbody[@id='TravelerList:TravelerForm:TravelerDatatable_data']/tr/td[1]/div[@class='ui-row-toggler ui-icon ui-icon-circle-triangle-e']")WebElement FillinInfo;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Traveler__FirstName")WebElement FirstName;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Traveler__LastName")WebElement LastName;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Insured__Traveler__DOB")WebElement TravelerDOB;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Traveler__Gender")WebElement Gender;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:streetAddress:Object__Common__Address1")WebElement Address1;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:streetAddress:Object__Common__Address2")WebElement Address2;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:streetAddress:Object__Common__City")WebElement City;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:streetAddress:Object__Common__County")WebElement County;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:streetAddress:Object__Common__ZipCode")WebElement ZipCode;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Common__Contact__PhoneNumber")WebElement PhoneNumber;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Common__Contact__EmailId")WebElement EmailId;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Traveler__EmergencyContact__FirstName")WebElement EmergencyContactFirstName;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Traveler__EmergencyContact__LastName")WebElement EmergencyContactLastName;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Object__Traveler__EmergencyContact__PhoneNumber")WebElement EmergencyContactPhoneNumber;
	 @FindBy(id="TravelerList:TravelerForm:TravelerDatatable:0:Save")WebElement Save;
	 @FindBy(name="TravelerList:TravelerButtons:Object__Traveler__Continue")WebElement Continue;
	
	
	 public TravellerInformationPage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 public void clickFillin()
	 {
		 FillinInfo.click();
	 }
	 public void setFirstName(String firstName)
	 {
		 FirstName.sendKeys(firstName);
	 }
	 public void setLastName(String lastName)
	 {
		 LastName.sendKeys(lastName);
	 }
	 public void setTravelerDOB(String travelerDOB)
	 {
		 TravelerDOB.sendKeys(travelerDOB);
	 }
	 public void setGender(String gender)
	 {
		 Gender.sendKeys(gender);
	 }
	 public void setAddress1(String address1)
	 {
		 Address1.sendKeys(address1);
	 }
	 public void setAddress2(String address2)
	 {
		 Address2.sendKeys(address2);
	 }
	 public void setCity(String city)
	 {
		 City.sendKeys(city);
	 }
	 public void setCounty(String county)
	 {
		 County.sendKeys(county);
	 }
	 public void setZipCode(String zipCode)
	 {
		 ZipCode.sendKeys(zipCode);
	 }
	 public void setPhoneNumber(String phoneNumber)
	 {
		 PhoneNumber.sendKeys(phoneNumber);
	 }
	 public void setEmailId(String emailId)
	 {
		 EmailId.sendKeys(emailId);
	 }
	 public void setEmergencyContactFirstName(String emergencyContactFirstName)
	 {
		 EmergencyContactFirstName.sendKeys(emergencyContactFirstName);
	 }
	 public void setEmergencyContactLastName(String emergencyContactLastName)
	 {
		 EmergencyContactLastName.sendKeys(emergencyContactLastName);
	 }
	 public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber)
	 {
		 EmergencyContactPhoneNumber.sendKeys(emergencyContactPhoneNumber);
	 }
	 public void ClickSave()
	 {
		 Save.click();
	 }
	 public PaymentInformationPage ClickContinue()
	 {
		 Continue.click();
		 return new PaymentInformationPage(this.driver);
	 }
	
}
