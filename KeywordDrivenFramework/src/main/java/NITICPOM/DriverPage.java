package NITICPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
