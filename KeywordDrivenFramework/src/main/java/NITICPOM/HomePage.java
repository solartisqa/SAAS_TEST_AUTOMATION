package NITICPOM;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	@FindBy(xpath="//div[@id='chicHomePage']//input[@type='image']")WebElement TruckersInsurance;
	@FindBy(xpath="//select[@id='businessSubTypeForm:Object__Risk__SubBusinessType']")WebElement SubBusinessType;
	@FindBy(xpath="//span[contains(.,'Continue')]")WebElement Continue;
	@FindBy(xpath="//span[contains(.,'Cancel')]")WebElement Cancel;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	
	
	 public HomePage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in Home page");
		 }
		 PageFactory.initElements(driver, this);
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
		 this.waitForLoading();
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
		 this.waitForLoading();
	 }

	 
	 public void waitForLoading()
	 {
		 wait.until(ExpectedConditions.visibilityOfAllElements(LoadingIcon));
		 wait.until(ExpectedConditions.invisibilityOfAllElements(LoadingIcon));
	 }
}
