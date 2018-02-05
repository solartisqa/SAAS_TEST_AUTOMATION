package CvstarrPOM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoveragesLimitsPage {

	private WebDriver driver;
	 WebDriverWait wait;
	private By billing_mode=By.id("BillingMode");
	private By save_btn=By.id("SaveBottom");
	private By save_quote=By.xpath("//input[@value='Save Quote']");
	private By base_premium=By.id("TotalBasePremium");
	
	private By total_premium=By.id("TotalPremium");
	
	private By municipal_tax=By.id("MunicipalTax");
	
	
	
	 public CoveragesLimitsPage(WebDriver driver) 
	{
	
this.driver = driver;
 
	}
	 //==========================================================
	 private void select_billing_mode(String billing)
	 {
 try {
			 
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(billing_mode));
			 Select dropdown = new Select(driver.findElement(billing_mode));
			 dropdown.selectByVisibleText(billing);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(billing_mode));
			 Select dropdown = new Select(driver.findElement(billing_mode));
			 dropdown.selectByVisibleText(billing);
			 
		 }
		
		
	 }
	 //===============================================================================================
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
			String base_premium_actual=driver.findElement(base_premium).getAttribute("value");
			 //Assert.assertTrue(actual.toLowerCase().contains(text));
			System.out.println("base_Premium="+base_premium_actual);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(base_premium));
				String base_premium_actual=driver.findElement(base_premium).getAttribute("value");
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
			String total_prem=driver.findElement(total_premium).getAttribute("value");
			 //Assert.assertTrue(actual.toLowerCase().contains(text));
			System.out.println("total_premium="+total_prem);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(total_premium));
				String base_premium_actual=driver.findElement(total_premium).getAttribute("value");
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
			String municipal=driver.findElement(municipal_tax).getAttribute("value");
			 //Assert.assertTrue(actual.toLowerCase().contains(text));
			System.out.println("municipal_tax="+municipal);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(municipal_tax));
				String municipal=driver.findElement(municipal_tax).getAttribute("value");
				 //Assert.assertTrue(actual.toLowerCase().contains(text));
				System.out.println("municipal_tax="+municipal);
		 }
		
		
	 }
	 //===================================================================================================
	 public void cov_and_limits(String billing_type)
	 {
		 this.select_billing_mode(billing_type);
		 this.get_base_premium();
		 this.get_total_premium();
		 this.get_municipal_premium();
		 this.click_save_btn();
	 }
	 
}
