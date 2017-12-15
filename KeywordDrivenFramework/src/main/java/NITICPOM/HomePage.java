package NITICPOM;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;


public class HomePage extends BasePage
{
	private WebDriver driver;
	//WebDriverWait wait;
	@FindBy(xpath="//a[@class='header_menu_item home-icon']")WebElement Home;
	@FindBy(xpath="//div[@id='chicHomePage']//input[@type='image']")WebElement TruckersInsurance;
	@FindBy(xpath="//select[@id='businessSubTypeForm:Object__Risk__SubBusinessType']")WebElement SubBusinessType;
	@FindBy(xpath="//span[contains(.,'Continue')]")WebElement Continue;
	@FindBy(xpath="//span[contains(.,'Cancel')]")WebElement Cancel;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(id="AccountLink")WebElement Find;
	@FindBy(id="MyInsured")WebElement FindInsured;
	@FindBy(id="MyQuote")WebElement FindQuote;
	@FindBy(id="MyPolicies")WebElement FindPolicy;
	
	 public HomePage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 private boolean isInitialized(boolean displayed)
	 {
		
		return TruckersInsurance.isDisplayed();
	}
	 
	 public void ClickHome()
	 {
		 this.WaitWithVisibility(Home,driver);
		 try
		 {
			 Home.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Home.click();
		 }
		// this.waitForLoading();
	 }
	 
	 public void ClickTruckersInsurance()
	 {
		 this.WaitWithVisibility(TruckersInsurance,driver);
		 try
		 {
			 TruckersInsurance.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 TruckersInsurance.click();
		 }
		 //this.waitForLoading();
	 }
	 
	 public void selectSubBusinessType(String BusinessType)
	 {
		 this.WaitWithVisibility(SubBusinessType,driver);
		 try
		 {
		 Select dropdown = new Select(SubBusinessType);
		 dropdown.selectByVisibleText(BusinessType);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(SubBusinessType);
			 dropdown.selectByVisibleText(BusinessType);
		 }
		
	 }
	 
	 public BusinessPage ClickContinue()
	 {
		 this.WaitWithVisibility(Continue,driver);
		 try
		 {
			 Continue.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Continue.click();
		 }
		 this.waitForLoading();
		 return new BusinessPage(this.driver);
	 }
	 
	 public void ClickFind()
	 {
		 this.WaitWithVisibility(Find,driver);
		 try
		 {
			 Find.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Find.click();
		 }
		
	 }
	 
	 public FindInsuredPage ClickFindInsured()
	 {
		 this.WaitWithVisibility(FindInsured,driver);
			Actions builder = new Actions(driver);
			builder.moveToElement(FindInsured).build().perform();
			FindInsured.click();
			return new FindInsuredPage(this.driver);
	 }
	 
	 public FindQuotePage ClickFindQuote()
	 {
		this.WaitWithVisibility(FindQuote,driver);
		Actions builder = new Actions(driver);
		builder.moveToElement(FindQuote).build().perform();
		FindQuote.click();
		return new FindQuotePage(this.driver);
	 }
	 
	 public FindPolicyPage ClickFindPolicy()
	 {
		 this.WaitWithVisibility(FindPolicy,driver);
			Actions builder = new Actions(driver);
			builder.moveToElement(FindPolicy).build().perform();
			FindPolicy.click();
		 return new FindPolicyPage(this.driver);
	 }
	 public void ClickCancel()
	 {
		 this.WaitWithVisibility(Continue,driver);
		 try
		 {
			 Cancel.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Cancel.click();
		 }
		
	 }

	 
	 public void waitForLoading()
	 {
		 wait.until(ExpectedConditions.visibilityOfAllElements(LoadingIcon));
		 wait.until(ExpectedConditions.invisibilityOfAllElements(LoadingIcon));
	 }
}
