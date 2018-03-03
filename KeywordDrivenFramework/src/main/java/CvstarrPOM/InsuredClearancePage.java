/*package CvstarrPOM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utillPack.browser_launching;

public class InsuredClearancePage {
	private WebDriver driver;
	 WebDriverWait wait;
	 By insured_name_type=By.name("answer(Object::Clearance::NameType)");
	 By Legal_name=By.id("LegalName1");
	 By zip_or_city=By.id("Zip");
	 By country=By.id("Country");
	 By next_button=By.xpath("//input[@value='Next']");
	 
	 
	 
	public InsuredClearancePage(WebDriver driver) 
	{
  	
      this.driver = driver;
       
	}
	//==================================================================
	public  void selectInsured_nameType(String insuredNameType)
	{
		 try
		 {
			 System.out.println("select sate");
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(insured_name_type));
			 Select dropdown = new Select(driver.findElement(insured_name_type));
			 dropdown.selectByVisibleText(insuredNameType);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(insured_name_type));
			 Select dropdown = new Select(driver.findElement(insured_name_type));
			 dropdown.selectByVisibleText(insuredNameType);
			 
		 }
		
	}
//===========================================================================================	
	public void set_LegalName(String legalName)
	{
		
		try
		{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Legal_name));
        driver.findElement(Legal_name).sendKeys(legalName);
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 	wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(Legal_name));
		        driver.findElement(Legal_name).sendKeys(legalName);
			 
		 }
		
	}
	//============================================================================================
	public void autoComplete_zip(String zip)
	{
		try
		{
		wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(zip_or_city));
    	driver.findElement(zip_or_city).sendKeys(zip);
    	driver.findElement(zip_or_city).sendKeys(Keys.ENTER);
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			wait = new WebDriverWait(driver, 30);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(zip_or_city));
	    	driver.findElement(zip_or_city).sendKeys(zip);
	    	driver.findElement(zip_or_city).sendKeys(Keys.ENTER);
		 }
		
	}
	//==============================================================================================
	public void select_country(String country_name)
	{

		 try
		 {
			 System.out.println("select sate");
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(country));
			 Select dropdown = new Select(driver.findElement(country));
			 dropdown.selectByVisibleText(country_name);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(country));
			 Select dropdown = new Select(driver.findElement(country));
			 dropdown.selectByVisibleText(country_name);
			 
		 }
		
	}
	//======================================================================================================
	
	public void click_nextbutton()
	{
		 try{
			 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(next_button));
			    driver.findElement(next_button).click();
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(next_button));
				    driver.findElement(next_button).click();
			 }
		 
			
		}
	//==========================================================================
	
	public void fill_insured_details(String nameType,String legal_name,String zip)
	{
		this.selectInsured_nameType(nameType);
		this.set_LegalName(legal_name);
		this.autoComplete_zip(zip);
		this.click_nextbutton();
	}
	
	
	
	}
	


*/