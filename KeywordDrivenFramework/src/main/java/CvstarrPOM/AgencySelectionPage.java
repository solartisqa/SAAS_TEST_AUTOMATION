package CvstarrPOM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;
import basePage.basePage;
import utillPack.browser_launching;

public class AgencySelectionPage extends BasePage {
	
	private WebDriver driver;
	 WebDriverWait wait;
	 @FindBy(id="State") WebElement agency_state_loc;
	 @FindBy(xpath="//input[@value='Find >']") WebElement find_loc;
	 @FindBy(xpath="//table/tbody/tr[1]/td/div/input[@id='Select']") WebElement Agencyradio_loc;
	 @FindBy(xpath="//div[@id='divSelectButton']/input[@value='Select']") WebElement selectButton_loc;
	 @FindBy(xpath="//table/tbody/tr[1]/td/div/input[@name='answer(Select)']") WebElement Agent_radio_loc;
	 @FindBy(xpath="//div/input[@value='Select']") WebElement Selectbutton2_loc;
	 
	 
	 
	public AgencySelectionPage(WebDriver driver) 
	{
   	
       super(driver);
        
	}
 void select_Agency_state()
 {
	 try
	 {
	   agency_state_loc.click();
	 }
	 catch(StaleElementReferenceException|TimeoutException e)
	 {
		 agency_state_loc.click();
	 }
	
 }
 
public void click_findAgency()
 {
	 try
	 {
		click(find_loc);
	 }
	 catch(StaleElementReferenceException|TimeoutException e)
	 {
		 click(find_loc);
	 }
	
 }
 
public void click_selectAgency()
 {
	 try
	 {
		click(Agencyradio_loc);
	 }
	 catch(StaleElementReferenceException|TimeoutException e)
	 {
		 click(Agencyradio_loc);
	 }
	 
 }
public void Click_selectButton1()
 { 
	 try
    {
	click(selectButton_loc);
    }
   catch(StaleElementReferenceException|TimeoutException e)
    {
 	click(selectButton_loc);
    }
 }
 
public void click_agent()
 {
	 try
	 {
		click(Agent_radio_loc);
	 }
	 catch(StaleElementReferenceException|TimeoutException e)
	 {
		 click(Agent_radio_loc);
	 }
		 
 }
 
public void Click_selectAgent()
 {
	 try
	 {
		click(Selectbutton2_loc);
	 }
	 catch(StaleElementReferenceException|TimeoutException e)
	 {
		 click(Selectbutton2_loc);
	 }
	
 }
	
}
