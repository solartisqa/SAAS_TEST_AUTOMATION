package CvstarrPOM;

import java.util.NoSuchElementException;

//import org.openqa.jetty.html.List;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuredDetailsPage {
	
	private WebDriver driver;
	 WebDriverWait wait;
	private By submission_type=By.xpath("//select[@id='productId']");
	private By state_of_delivery=By.id("StateOfDelivery");
	private By address1=By.id("Address1");
	private By city_loc=By.id("City");
	private By sate_or_province=By.id("State");
	private By municipalty_or_school=By.name("answer(Object::Customer::SchoolOrMunicipality)");
	private By form_of_bus=By.id("FormOfBusiness");
	private By next_button=By.id("NextButton");
	private By Activity_or_eventGroup=By.id("ActivityEventGroupNameSelect");
	 
	 
	 
	public InsuredDetailsPage(WebDriver driver) 
	{
 	
     this.driver = driver;
      
	}
	//================================================================================
	private void select_submissionType(String submission)
	{
		try
		 {
			 System.out.println("select sate");
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(submission_type));
			 Select dropdown = new Select(driver.findElement(submission_type));
			 dropdown.selectByVisibleText(submission);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(submission_type));
			 Select dropdown = new Select(driver.findElement(submission_type));
			 dropdown.selectByVisibleText(submission);
			 
		 }
		
	}
	//========================================================================================
	private void select_stateOfDelivery(String state)
	{

		try
		 {
			 System.out.println("select sate");
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(state_of_delivery));
			 Select dropdown = new Select(driver.findElement(state_of_delivery));
			 dropdown.selectByVisibleText(state);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(state_of_delivery));
			 Select dropdown = new Select(driver.findElement(state_of_delivery));
			 dropdown.selectByVisibleText(state);
		}
		
	}
	//=============================================================================================
	private void Select_activity_group(String activity)
	{
		try
		 {
			 System.out.println("select sate");
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(Activity_or_eventGroup));
			 Select dropdown = new Select(driver.findElement(Activity_or_eventGroup));
			 dropdown.selectByVisibleText(activity);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(Activity_or_eventGroup));
			 Select dropdown = new Select(driver.findElement(Activity_or_eventGroup));
			 dropdown.selectByVisibleText(activity);
			 
		 }
		
	}
	//========================================================================================
	
	private void set_addressLine1(String address_line1)
	{
		try
		{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(address1));
        driver.findElement(address1).sendKeys(address_line1);
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 	wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(address1));
		        driver.findElement(address1).sendKeys(address_line1);
			 
		 }
	
	}
	//==========================================================================================================
	private void set_city(String city)
	{

		try
		{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(city_loc));
        driver.findElement(city_loc).sendKeys(city);
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 	wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(city_loc));
		        driver.findElement(city_loc).sendKeys(city);
			 
		 }
		
		
	}
	
	//===========================================================================================================
	private void Select_state_province(String state)
	{
		try
		 {
			 System.out.println("select sate");
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(sate_or_province));
			 Select dropdown = new Select(driver.findElement(sate_or_province));
			 dropdown.selectByVisibleText(state);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(sate_or_province));
			 Select dropdown = new Select(driver.findElement(sate_or_province));
			 dropdown.selectByVisibleText(state);
			 
		 }
	}
	//=========================================================================
	private void select_municipalty_or_school(String municipal_school)
	{
		try
		{
		List CheckBoxList = driver.findElements(municipalty_or_school);
		for(int i=0; i< CheckBoxList.size() ; i++)
		{
			if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(municipal_school))
			{
				((WebElement) CheckBoxList.get(i)).click();
			}
		}
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			List CheckBoxList = driver.findElements(municipalty_or_school);
			for(int i=0; i< CheckBoxList.size() ; i++)
			{
				if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(municipal_school))
				{
					((WebElement) CheckBoxList.get(i)).click();
				}
			}
			 
		 }
	
	}
	//===================================================================================================
	private void select_form_of_bus(String business)
	{
		try
		{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(form_of_bus));
        driver.findElement(form_of_bus).sendKeys(business);
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 	wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(form_of_bus));
		        driver.findElement(form_of_bus).sendKeys(business);
			 
		 }
		
	}
	//===============================================================================
	private void click_nextbutton()
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
	//======================================================================================================
	public void fill_nameInfo(String submission,String state,String activity_gruop)
	{
		this.select_submissionType(submission);
		if(submission.equals("Blanket Accident")| submission.equals("Sports And Special Events"))
		{
		this.select_stateOfDelivery(state);
		}
		if(submission.equals("Sports And Special Events"))
		{
		this.Select_activity_group(activity_gruop);
		}
		
	}
	
	public void fill_primary_bus_address(String address1,String city,String state,String form_of_bus,String municipal)
	{
		this.set_addressLine1(address1);
		this.set_city(city);
		this.Select_state_province(state);
		if(state.equals("Kentucky"))
		{
		this.select_municipalty_or_school(municipal);
		}
		this.select_form_of_bus(form_of_bus);
	    this.click_nextbutton();
	}

}
