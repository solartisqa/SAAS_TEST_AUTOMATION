package CvstarrPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PolicySummaryPage {

		private WebDriver driver;
		 WebDriverWait wait;
	   private By policy_number=By.xpath("//table[3]/tbody/tr[2]/td[2]");
	   private By lnk_policy_summary=By.xpath("//a[@title='Click here to goto Policy Summary']");
	   private By lnk_quote_summary=By.xpath("//a[@title='Click here to goto Quote Summary']");
	   private By lnk_insured_summary=By.xpath("//a[@title='Click here to goto Insured Summary']");
	   
	   
	   
		
		
		
		
		 public PolicySummaryPage(WebDriver driver) 
		{
		
	this.driver = driver;

		}
		 
	//==================================================================================================================
		 public void goto_Quote_summary()
		 {
			 try{
				 
					wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_quote_summary));
				    driver.findElement(lnk_quote_summary).click();
				  
				 }
				 catch(StaleElementReferenceException|TimeoutException e)
				 {
					 	wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_quote_summary));
					    driver.findElement(lnk_quote_summary).click();
				 }
				
		 }
		 
		 //=================================================================================================================
		 public void get_policy_number()
		 {
			 try
			 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_policy_summary));
				String policy_no=driver.findElement(lnk_policy_summary).getText();
				 //Assert.assertTrue(actual.toLowerCase().contains(text));
				System.out.println("policy_no="+policy_no);
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_policy_summary));
					String policy_no=driver.findElement(lnk_policy_summary).getText();
					 //Assert.assertTrue(actual.toLowerCase().contains(text));
					System.out.println("policy_no="+policy_no);
			 }
			
		 }
		 
		
		//===============================================================================================================================
			public void go_to_insured_summary()
			{
				try{
					 
					wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_insured_summary));
				    driver.findElement(lnk_insured_summary).click();
				  
				 }
				 catch(StaleElementReferenceException|TimeoutException e)
				 {
					 	wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_insured_summary));
					    driver.findElement(lnk_insured_summary).click();
				 }
			}
			
      //=======================================================================================================================================			

}
