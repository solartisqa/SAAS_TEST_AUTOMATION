package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GetAQuotePage 
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
		 Select dropdown = new Select(StateOfResidence);
		 dropdown.selectByVisibleText(State);
		
	 }
	 public void selectPlanName(String planName)
	 {
		 Select dropdown = new Select(PlanName);
		 dropdown.selectByVisibleText(planName);
		
	 }
	 public void selectDestinationCountry(String DestCountry)
	 {
		 Select dropdown = new Select(DestinationCountry);
		 dropdown.selectByVisibleText(DestCountry);
		
	 }
	 public void setDepaturedate(String depaturedate)
	 {
		 Depaturedate.sendKeys(depaturedate);
		
	 }
	 public void setReturndate(String returndate)
	 {
		 Returndate.sendKeys(returndate);
	 }
	 public void setDepositdate(String depositdate)
	 {
		 Depositdate.sendKeys(depositdate);
		
	 }
	 public void setTravelcost(String travelcost)
	 {
		 Travelcost.sendKeys(travelcost);
		
	 }
	 public void setTravelerDOB(String travelerDOB)
	 {
		 TravelerDOB.sendKeys(travelerDOB);
		
	 }
	 public void ClickTripCancellation(String TripCancellation)
	 {
		 if(TripCancellation.equals("With Trip Cancellation for Any Reason"))
		 {
			 TripCancellationInclude.click();
		 }
		 else if(TripCancellation.equals("With Trip Cancellation"))
		 {
			 TripCancellationExclude.click();
		 }
		
	 }
	 public void setNumberofTravelers(String numberofTravelers)
	 {
		 NumberofTravelers.sendKeys(numberofTravelers);
		
	 }
	 public void setRentalStartDate(String rentalStartDate)
	 {
		 RentalStartDate.sendKeys(rentalStartDate);
		
	 }
	 public void setRentalEndDate(String rentalEndDate)
	 {
		 RentalEndDate.sendKeys(rentalEndDate);
		
	 }
	 public void setPolicyEffectiveDate(String policyEffectiveDate)
	 {
		 PolicyEffectiveDate.sendKeys(policyEffectiveDate);
		
	 }
	 
	 public void Clickcalculate()
	 {
		 calculate.click();
	 }
	 public void ClickAddtraveler()
	 {
		 Addtraveler.click();
	 }
	 public TravellerInformationPage ClickSaveandcontinue()
	 {
		 Saveandcontinue.click();
		 return new TravellerInformationPage(this.driver);
	 }
	 
	 
	 
	 	 
	 
}
