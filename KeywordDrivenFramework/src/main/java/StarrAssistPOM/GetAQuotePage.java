package StarrAssistPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	 
	
	 public GetAQuotePage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
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
		 
		
	 }
	 public void setDepaturedate(String depaturedate)
	 {
		 this.WaitWithVisibility(Depaturedate,driver);
		 Depaturedate.sendKeys(depaturedate);
		
	 }
	 public void setReturndate(String returndate)
	 {
		 this.WaitWithVisibility(Returndate,driver);
		 Returndate.sendKeys(returndate);
	 }
	 public void setDepositdate(String depositdate)
	 {
		 this.WaitWithVisibility(Depositdate,driver);
		 Depositdate.sendKeys(depositdate);
		
	 }
	 public void setTravelcost(String travelcost)
	 {
		 this.WaitWithVisibility(Travelcost,driver);
		 Travelcost.sendKeys(travelcost);
		
	 }
	 public void setTravelerDOB(String travelerDOB)
	 {
		 this.WaitWithVisibility(TravelerDOB,driver);
		 TravelerDOB.sendKeys(travelerDOB);
		
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
		
	 }
	 public void setNumberofTravelers(String numberofTravelers)
	 {
		 this.WaitWithVisibility(NumberofTravelers,driver);
		 NumberofTravelers.sendKeys(numberofTravelers);
		
	 }
	 public void setRentalStartDate(String rentalStartDate)
	 {
		 this.WaitWithVisibility(RentalStartDate,driver);
		 RentalStartDate.sendKeys(rentalStartDate);
		
	 }
	 public void setRentalEndDate(String rentalEndDate)
	 {
		 this.WaitWithVisibility(RentalEndDate,driver);
		 RentalEndDate.sendKeys(rentalEndDate);
		
	 }
	 public void setPolicyEffectiveDate(String policyEffectiveDate)
	 {
		 this.WaitWithVisibility(PolicyEffectiveDate,driver);
		 PolicyEffectiveDate.sendKeys(policyEffectiveDate);
		
	 }
	 
	 public void Clickcalculate()
	 {
		 this.WaitWithVisibility(calculate,driver);
		 calculate.click();
	 }
	 public void ClickAddtraveler()
	 {
		 this.WaitWithVisibility(Addtraveler,driver);
		 Addtraveler.click();
	 }
	 public TravellerInformationPage ClickSaveandcontinue()
	 {
		 this.WaitWithVisibility(Saveandcontinue,driver);
		 Saveandcontinue.click();
		 return new TravellerInformationPage(this.driver);
	 }
	 
	 
	 
	 	 
	 
}
