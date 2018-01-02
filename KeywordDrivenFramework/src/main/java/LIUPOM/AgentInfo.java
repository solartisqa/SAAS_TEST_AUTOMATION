package LIUPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class AgentInfo extends BasePage
{
	@FindBy(xpath="//input[@id=\"Select\"]")WebElement AgentInfo;	
	@FindBy(xpath="//input[@value=\"Select\"]")WebElement AgentSelect;	
	
	public AgentInfo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickAgentInfo()
	 {
		 this.WaitWithVisibility(AgentInfo,driver);
		 try
		 {
			 AgentInfo.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AgentInfo.click();
		 }
	 }
	
	public InsuredClearance clickAgentSelect()
	 {
		 this.WaitWithVisibility(AgentSelect,driver);
		 try
		 {
			 AgentSelect.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AgentSelect.click();
		 }
		 return new InsuredClearance(this.driver);
	 }
}
