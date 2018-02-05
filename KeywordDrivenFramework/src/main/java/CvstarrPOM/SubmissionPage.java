package CvstarrPOM;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SubmissionPage {
	private WebDriver driver;
	 WebDriverWait wait;
	private By submision_hover=By.id("oCMenu_tabSubmissions");
	private By new_submission=By.xpath("//div[@id='oCMenu_menuNewSubmission' and contains(.,'New Submission')]");
	private By find_submission=By.xpath("//div[@id='oCMenu_menuFindSubmission']");
	
	public SubmissionPage(WebDriver driver) 
	{
    	
        this.driver = driver;
         
	}
	//======================================================================================================
	public void hover_submissionTab()
	{
		try
		{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(submision_hover));
    	Actions mouse_hover = new Actions(driver);
		mouse_hover.moveToElement(driver.findElement(submision_hover)).build().perform();
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(submision_hover));
		    	Actions mouse_hover = new Actions(driver);
				mouse_hover.moveToElement(driver.findElement(submision_hover)).build().perform();
		 }
	}
	//============================================================================================
	public void click_newSubmission()
	{
		try
		{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(new_submission));
	    driver.findElement(new_submission).click();
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(new_submission));
			    driver.findElement(new_submission).click();
		 }
	
	}
	//==============================================================================================================
	public void Click_FindSubmission()
	{
		try
		{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(find_submission));
		 driver.findElement(find_submission).click();
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(find_submission));
			 driver.findElement(find_submission).click();
		 }
	
    }
	
	 
	
	

}
