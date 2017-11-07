package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EndorsementPage
{
	private WebDriver driver;
	
	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__DestinationCountry")WebElement DestinationCountry;
	 @FindBy(id="Get_Quote:travelform:Saveandcontinue")WebElement Saveandcontinue;
	
	 public EndorsementPage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void selectDestinationCountry(String DestCountry)
	 {
		 Select dropdown = new Select(DestinationCountry);
		 dropdown.selectByVisibleText(DestCountry);
		
	 } 
	 
	 public TravellerInformationPage ClickSaveandcontinue()
	 {
		 Saveandcontinue.click();
		 return new TravellerInformationPage(this.driver);
	 }
}
