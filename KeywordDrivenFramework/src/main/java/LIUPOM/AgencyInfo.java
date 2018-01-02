package LIUPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class AgencyInfo extends BasePage
{
	@FindBy(id="AgencyCode")WebElement AgencyCode;
	@FindBy(id="BusinessName")WebElement BusinessName;
	@FindBy(id="State")WebElement State;
	@FindBy(xpath="//input[@value=\"Find >\"]")WebElement FindAgency;
	@FindBy(xpath="//input[@name=\"LoginPage\"]")WebElement AgencyName;
	@FindBy(xpath="//input[@value=\"Select\"]")WebElement SelectAgency;	

	public AgencyInfo(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void setAgencyCode(String AgenCode)
	 {
		 this.WaitWithVisibility(AgencyCode,driver);
		 try
		 {
			 AgencyCode.sendKeys(AgenCode);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AgencyCode.sendKeys(AgenCode);
		 }
	 }
	
	public void setBusinessName(String BusnName)
	 {
		 this.WaitWithVisibility(BusinessName,driver);
		 try
		 {
			 BusinessName.sendKeys(BusnName);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 BusinessName.sendKeys(BusnName);
		 }
	 }
	
	public void setState(String Statename)
	 {
		 this.WaitWithVisibility(State,driver);
		 try
		 {
			 State.sendKeys(Statename);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 State.sendKeys(Statename);
		 }
	 }
	public void clickFindAgency()
	 {
		 this.WaitWithVisibility(FindAgency,driver);
		 try
		 {
			 FindAgency.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 FindAgency.click();
		 }
	 }
	
	public void clickAgency()
	 {
		 this.WaitWithVisibility(AgencyName,driver);
		 try
		 {
			 AgencyName.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AgencyName.click();
		 }
	 }
	
	public AgentInfo selectAgency()
	 {
		 this.WaitWithVisibility(SelectAgency,driver);
		 try
		 {
			 SelectAgency.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 SelectAgency.click();
		 }
		 
		 return new AgentInfo(this.driver);
	 }
}
