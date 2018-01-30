package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class EndorsementPage extends BasePage
{

	 @FindBy(id="Get_Quote:travelform:Object__Risk__Trip__DestinationCountry")WebElement DestinationCountry;
	 @FindBy(id="Get_Quote:travelform:Saveandcontinue")WebElement Saveandcontinue;
	
	 public EndorsementPage(WebDriver driver)
	 {
		 super(driver);
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
