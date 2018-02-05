package CvstarrPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class worksheetPage {
	private WebDriver driver;
	 WebDriverWait wait;
    private By worksheet_tab=By.id("WorksheetBAD");
	private By save_btn=By.id("worksheetSave");
	private By base_premium=By.xpath("//form[@id='SaveQuoteUnderwriterStatusAction']/x:table[2]/x:tbody/x:tr[15]/x:td[2]");
	private By total_premium=By.xpath("//form[@id='SaveQuoteUnderwriterStatusAction']/table/tbody/tr/td[contains(.,'Total Policy Premium')]/../td[@align]");
	private By municipal_tax=By.xpath("//form[@id='SaveQuoteUnderwriterStatusAction']/table/tbody/tr/td[contains(.,'KY Municipal Tax Surcharge')]/../td[@align]");
	
	
	
	 public worksheetPage(WebDriver driver) 
	{
	
this.driver = driver;

	}
	//==================================================================================================================
	 private void click_worksheet_tab()
	 {
		 try{
			 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(worksheet_tab));
			    driver.findElement(worksheet_tab).click();
			  
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(worksheet_tab));
				    driver.findElement(worksheet_tab).click();
			 }
			
			
	 }
//========================================================================================================================
	 private void click_save_btn()
	 {
		 try{
			 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(save_btn));
			    driver.findElement(save_btn).click();
			  
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(save_btn));
				    driver.findElement(save_btn).click();
			 }
			
			
	 }
	 
	 //================================================================================================================
	 private void get_base_premium()
	 {
		 try
		 {
		 wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(base_premium));
			String base_premium_actual=driver.findElement(base_premium).getText();
			 //Assert.assertTrue(actual.toLowerCase().contains(text));
			System.out.println("base_Premium="+base_premium_actual);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(base_premium));
				String base_premium_actual=driver.findElement(base_premium).getText();
				 //Assert.assertTrue(actual.toLowerCase().contains(text));
				System.out.println("base_Premium="+base_premium_actual);
		 }
		
		
	 }
	 //=========================================================================================================
	 
	 private void get_total_premium()
	 {
		 try
		 {
		 wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(total_premium));
			String total_prem=driver.findElement(total_premium).getText();
			 //Assert.assertTrue(actual.toLowerCase().contains(text));
			System.out.println("total_premium="+total_prem);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(total_premium));
				String base_premium_actual=driver.findElement(total_premium).getText();
				 //Assert.assertTrue(actual.toLowerCase().contains(text));
				System.out.println("total_premium="+base_premium_actual);
		 }
	
	 }
	 //=================================================================================================
	 private void get_municipal_premium()
	 {
		 try
		 {
		 wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(municipal_tax));
			String municipal=driver.findElement(municipal_tax).getText();
			 //Assert.assertTrue(actual.toLowerCase().contains(text));
			System.out.println("municipal_tax="+municipal);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(municipal_tax));
				String municipal=driver.findElement(municipal_tax).getText();
				 //Assert.assertTrue(actual.toLowerCase().contains(text));
				System.out.println("municipal_tax="+municipal);
		 }
		
		
	 }
	 //===================================================================================================
	 public void worksheet_operations()
	 {
		 this.click_worksheet_tab();
		// this.get_base_premium();
		 this.get_total_premium();
		 this.get_municipal_premium();
		 this.click_save_btn();
	 }
	 
}


