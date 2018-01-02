package LIUPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class HomePage extends BasePage
{
	@FindBy(id="oCMenu_tabSubmissions")WebElement submission;
	@FindBy(id="oCMenu_menuNewSubmission")WebElement newsubmission;
	//@FindBy(id="oCMenu_menuNewSubmission")WebElement login;
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	public void clickSubmission()
	 {
		 this.WaitWithVisibility(submission,driver);
		 try
		 {
			 submission.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 submission.click();
		 }
	 }
	 
	 public AgencyInfo clickNewSubmission()
	 {
		 this.WaitWithVisibility(newsubmission,driver);
		 try
		 {
			 newsubmission.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 newsubmission.click();
		 }
		 return new AgencyInfo(this.driver);
	 }
}
