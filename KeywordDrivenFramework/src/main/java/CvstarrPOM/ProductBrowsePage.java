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

public class ProductBrowsePage {

	private WebDriver driver;
	 WebDriverWait wait;
	private By create_quote_btn=By.xpath("//input[@value='Create Quote For This Submission']");
	private By product_group=By.id("selectGroup");
	
	private By quote_type=By.id("QuoteType");
	private By next_btn=By.id("CreateQuoteSubmit");
	
	
	 public ProductBrowsePage(WebDriver driver) 
	{
	
 this.driver = driver;
  
	}
	 //========================================================================================
	 private void click_create_quote_btn()
	 {
		 try{
			 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(create_quote_btn));
			    driver.findElement(create_quote_btn).click();
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(create_quote_btn));
				    driver.findElement(create_quote_btn).click();
			 }
		
	 }
	 //=========================================================================================
	 private void select_product(String product)
	 {
		 try {
			 
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(product_group));
			 Select dropdown = new Select(driver.findElement(product_group));
			 dropdown.selectByVisibleText(product);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(product_group));
			 Select dropdown = new Select(driver.findElement(product_group));
			 dropdown.selectByVisibleText(product);
			 
		 }
	
	 }
	 //=========================================================================================================
	 private void select_quote_type(String QuoteType)
	 {
try {
			 
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(quote_type));
			 Select dropdown = new Select(driver.findElement(quote_type));
			 dropdown.selectByVisibleText(QuoteType);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(quote_type));
			 Select dropdown = new Select(driver.findElement(quote_type));
			 dropdown.selectByVisibleText(QuoteType);
			 
		 }

	 }
	 //===========================================================================================================
	 private void click_next_btn()
	 {
		 try{
			 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(next_btn));
			    driver.findElement(next_btn).click();
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(next_btn));
				driver.findElement(next_btn).click();
			 }
	 }
	 //======================================================================================================
	 public void Fill_product_browse_page(String product,String quote_typ)
	 {
		 this.click_create_quote_btn();
		 this.select_product(product);
		 this.select_quote_type(quote_typ);
		 this.click_next_btn();
	 }
	 
	 
	 
}
