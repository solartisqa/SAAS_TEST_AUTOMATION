package StarrAssistPOM;

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

public class GetAQuotePage extends BasePage
{
	 private WebDriver driver;
	 @FindBy(id="Get_Quote:travelform:Object__Insured__State__Resident__Code")WebElement StateOfResidence;
	 @FindBy(id="Get_Quote:travelform:Object__Quote__Plan")WebElement PlanName;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__DestinationCountry")WebElement DestinationCountry;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__Depaturedate")WebElement Depaturedate;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__Returndate")WebElement Returndate;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__Depositdate")WebElement Depositdate;
	 @FindBy(id="Get_Quote:travelform:TravelerListDataTable:0:Object__Risk__Traveler__Travelcost")WebElement Travelcost;
	 @FindBy(id="Get_Quote:travelform:TravelerListDataTable:0:Object__Insured__Traveler__DOB")WebElement TravelerDOB;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__Cancellation:0")WebElement TripCancellationInclude;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__Cancellation:1")WebElement TripCancellationExclude;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__NumberofTravelers")WebElement NumberofTravelers;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Vehicle__Rental__StartDate")WebElement RentalStartDate;
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Vehicle__Rental__EndDate")WebElement RentalEndDate;
	 @FindBy(id="Get_Quote:travelform:Object__PolicyEffectiveDate")WebElement PolicyEffectiveDate;
	 @FindBy(id="Get_Quote:travelform:calculate")WebElement calculate;
	 @FindBy(id="Get_Quote:travelform:addtraveler")WebElement Addtraveler;
	 @FindBy(id="Get_Quote:travelform:Saveandcontinue")WebElement Saveandcontinue;
	 @FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	 @FindBy(xpath="//div[@id='Get_Quote:travelform:PremiumCalculation']//div[3]//div//label")WebElement Premium;
	 @FindBy(id="groupBooking:Object__Attachment__FileUpload_input")WebElement FileUpload;
	 
	 
	 
	 
	 public GetAQuotePage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 
	 public void selectStateOfResidence(String State)
	 {
		 this.WaitWithVisibility(StateOfResidence,driver);
		 try
		 {
		 Select dropdown = new Select(StateOfResidence);
		 dropdown.selectByVisibleText(State);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(StateOfResidence);
			 dropdown.selectByVisibleText(State);
		 }
		this.waitForLoading();
	 }
	 public void selectPlanName(String planName)
	 {
		 this.WaitWithVisibility(PlanName,driver);
		 try
		 {
		 Select dropdown = new Select(PlanName);
		 dropdown.selectByVisibleText(planName);
		 }
		 catch(StaleElementReferenceException e)
		 {
		 }
		 this.waitForLoading();
		
	 }
	 public void selectDestinationCountry(String DestCountry)
	 {
		 this.WaitWithVisibility(DestinationCountry,driver);
		 try
		 {
		 Select dropdown = new Select(DestinationCountry);
		 dropdown.selectByVisibleText(DestCountry);
		 }
		 catch(StaleElementReferenceException e)
		 {
		 }
		 this.waitForLoading();
		
	 }
	 public void setDepaturedate(String depaturedate)
	 {
		 this.WaitWithVisibility(Depaturedate,driver);
		 Depaturedate.clear();
		 Depaturedate.sendKeys(depaturedate);
		 Depaturedate.sendKeys(Keys.ENTER);
		 this.waitForLoading();
		
	 }
	 public void setReturndate(String returndate)
	 {
		 this.WaitWithVisibility(Returndate,driver);
		 Returndate.clear();
		 Returndate.sendKeys(returndate);
		 Returndate.sendKeys(Keys.ENTER);
		 this.waitForLoading();
	 }
	 public void setDepositdate(String depositdate)
	 {
		 this.WaitWithVisibility(Depositdate,driver);
		 Depositdate.clear();
		 Depositdate.sendKeys(depositdate);
		 Depositdate.sendKeys(Keys.ENTER);
		 this.waitForLoading();
		
	 }
	 public void setTravelcost(String travelcost)
	 {
		 this.WaitWithVisibility(Travelcost,driver);
		 Travelcost.sendKeys(travelcost);
		 this.waitForLoading();
		
	 }
	 public void setTravelerDOB(String travelerDOB)
	 {
		 this.WaitWithVisibility(TravelerDOB,driver);
		 TravelerDOB.clear();
		 TravelerDOB.sendKeys(travelerDOB);
		 TravelerDOB.sendKeys(Keys.ENTER);
		 this.waitForLoading();
		 
		
	 }
	 public void ClickTripCancellation(String TripCancellation)
	 {
		 
		 if(TripCancellation.equals("With Trip Cancellation for Any Reason"))
		 {
			 this.WaitWithVisibility(TripCancellationInclude,driver);
			 TripCancellationInclude.click();
		 }
		 else if(TripCancellation.equals("With Trip Cancellation"))
		 {
			 this.WaitWithVisibility(TripCancellationExclude,driver);
			 TripCancellationExclude.click();
		 }
		 this.waitForLoading();
	 }
	 public void setNumberofTravelers(String numberofTravelers)
	 {
		 this.WaitWithVisibility(NumberofTravelers,driver);
		 NumberofTravelers.sendKeys(numberofTravelers);
		 this.waitForLoading();
		
	 }
	 public void setRentalStartDate(String rentalStartDate)
	 {
		 this.WaitWithVisibility(RentalStartDate,driver);
		 RentalStartDate.clear();
		 RentalStartDate.sendKeys(rentalStartDate);
		 RentalStartDate.sendKeys(Keys.ENTER);
		 this.waitForLoading();
		
	 }
	 public void setRentalEndDate(String rentalEndDate)
	 {
		 this.WaitWithVisibility(RentalEndDate,driver);
		 RentalEndDate.clear();
		 RentalEndDate.sendKeys(rentalEndDate);
		 RentalEndDate.sendKeys(Keys.ENTER);
		 this.waitForLoading();
		
	 }
	 public void setPolicyEffectiveDate(String policyEffectiveDate)
	 {
		 this.WaitWithVisibility(PolicyEffectiveDate,driver);
		 PolicyEffectiveDate.clear();
		 PolicyEffectiveDate.sendKeys(policyEffectiveDate);
		 PolicyEffectiveDate.sendKeys(Keys.ENTER);
		 this.waitForLoading();
		
	 }
	 
	 public void Clickcalculate()
	 {
		 this.WaitWithVisibility(calculate,driver);
		 calculate.click();
		 this.waitForLoading();
	 }
	 public void ClickAddtraveler()
	 {
		 this.WaitWithVisibility(Addtraveler,driver);
		 Addtraveler.click();
		 this.waitForLoading();
	 }
	 public TravellerInformationPage ClickSaveandcontinue()
	 {
		 this.WaitWithVisibility(Saveandcontinue,driver);
		 Saveandcontinue.click();
		 this.waitForLoading();
		 return new TravellerInformationPage(this.driver);
	 }
	 
	 public String getPremium()
	 {
		this.WaitWithVisibility(Premium, driver);
		return Premium.getText();
	 }
	 
	 public void ClickFileUpload()
	 {
		 this.WaitWithVisibility(FileUpload,driver);
		 FileUpload.click();
		 this.waitForLoading();
	 }
	 public void waitForLoading()
	 {
		 wait.until(ExpectedConditions.visibilityOfAllElements(LoadingIcon));
		 wait.until(ExpectedConditions.invisibilityOfAllElements(LoadingIcon));
	 }
	 
}
