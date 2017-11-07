package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmailPage 
{
	private WebDriver driver;
	
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
	
	
	 public ComposeEmailPage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	 }
}
