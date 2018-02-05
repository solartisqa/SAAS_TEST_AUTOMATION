package CvstarrPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuoteSummaryPage {
	private WebDriver driver;
	 WebDriverWait wait;
   private By create_quote_propasal=By.id("Create_Quote_Proposal");
	private By radio_btn_create_quote=By.name("answer(Object::QuoteAdditional::Praposal)");
	private By quote_propasal_submit=By.id("QuoteProposalSubmit");
	private By bind_request=By.id("Bind_Request");
	private By bind_request_submit=By.id("BindRequestSubmit");
	private By issue_binder=By.id("Issue_Binder");
	private By policy_no_prefix=By.id("PolicyNumPreFix");
	private By profit_center=By.id("ProfitCenter");
	private By occupancies=By.id("Occupancies");
	private By Issue_binder_btn=By.id("IssueBinderSubmit");
	private By issue_policy_btn=By.id("IssuePolicySubmit");
    private By lnk_policy_summary=By.xpath("//a[@title='Click here to goto Policy Summary']");
    private By lnk_insured_summary=By.xpath("//a[@title='Click here to goto Insured Summary']");
	
	
	
	
	 public QuoteSummaryPage(WebDriver driver) 
	{
	
this.driver = driver;

	}
	//==================================================================================================================
	 private void click_create_quote_propasal_btn()
	 {
		 try{
			 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(create_quote_propasal));
			    driver.findElement(create_quote_propasal).click();
			  
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(create_quote_propasal));
				    driver.findElement(create_quote_propasal).click();
			 }
			
	}
	 //======================================================================================================================
		private void select_create_quote_radiobtn(String create_quote)
		{
			try
			{
			List CheckBoxList = driver.findElements(radio_btn_create_quote);
			for(int i=0; i< CheckBoxList.size() ; i++)
			{
				if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(create_quote))
				{
					((WebElement) CheckBoxList.get(i)).click();
				}
			}
			}
			catch(StaleElementReferenceException|TimeoutException e)
			 {
				List CheckBoxList = driver.findElements(radio_btn_create_quote);
				for(int i=0; i< CheckBoxList.size() ; i++)
				{
					if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(create_quote))
					{
						((WebElement) CheckBoxList.get(i)).click();
					}
				}
				 
			 }
		
		}
	//=========================================================================================================================
		private void click_quote_propasal_submit()
		{
			try{
				 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(quote_propasal_submit));
			    driver.findElement(quote_propasal_submit).click();
			  
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(quote_propasal_submit));
				    driver.findElement(quote_propasal_submit).click();
			 }
			
		}
 //===================================================================================================================
		private void click_bind_request()
		{
			try{
				 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(bind_request));
			    driver.findElement(bind_request).click();
			  
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(bind_request));
				    driver.findElement(bind_request).click();
			 }
			
		}
	//==============================================================================================================================
		private void click_bind_request_submit()
		{
			try{
				 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(bind_request_submit));
			    driver.findElement(bind_request_submit).click();
			  
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(bind_request_submit));
				    driver.findElement(bind_request_submit).click();
			 }
			
		}
	//==============================================================================================================================
		private void click_issue_binder()
		{
			try{
				 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(issue_binder));
			    driver.findElement(issue_binder).click();
			  
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(issue_binder));
				    driver.findElement(issue_binder).click();
			 }
			
		}
		//============================================================================================================================
		 private void select_policyNo_prefix(String prefix)
		 {
	    try {
				 
				 wait = new WebDriverWait(driver, 30);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(policy_no_prefix));
				 Select dropdown = new Select(driver.findElement(policy_no_prefix));
				 dropdown.selectByVisibleText(prefix);
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 wait = new WebDriverWait(driver, 30);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(policy_no_prefix));
				 Select dropdown = new Select(driver.findElement(policy_no_prefix));
				 dropdown.selectByVisibleText(prefix);
				 
			 }
			
		 }
		 //============================================================================================================================
		 private void select_profit_center(String profit_center_name)
		 {
	    try {
				 
				 wait = new WebDriverWait(driver, 30);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(profit_center));
				 Select dropdown = new Select(driver.findElement(profit_center));
				 dropdown.selectByVisibleText(profit_center_name);
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 wait = new WebDriverWait(driver, 30);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(profit_center));
				 Select dropdown = new Select(driver.findElement(profit_center));
				 dropdown.selectByVisibleText(profit_center_name);
				 
			 }
			
		 }
		//===========================================================================================================================
		 private void select_product(String pdct)
		 {
          try {
				 
				 wait = new WebDriverWait(driver, 30);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(occupancies));
				 Select dropdown = new Select(driver.findElement(occupancies));
				 dropdown.selectByVisibleText(pdct);
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 wait = new WebDriverWait(driver, 30);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(occupancies));
				 Select dropdown = new Select(driver.findElement(occupancies));
				 dropdown.selectByVisibleText(pdct);
				 
			 }
			
		 }
		//===============================================================================================================================
			private void click_issue_binder_btn()
			{
				try{
					 
					wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(Issue_binder_btn));
				    driver.findElement(Issue_binder_btn).click();
				  
				 }
				 catch(StaleElementReferenceException|TimeoutException e)
				 {
					 	wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(Issue_binder_btn));
					    driver.findElement(Issue_binder_btn).click();
				 }
				
			}
		//============================================================================================================================
			private void click_issue_policy_btn()
			{
				try{
					 
					wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(issue_policy_btn));
				    driver.findElement(issue_policy_btn).click();
				  
				 }
				 catch(StaleElementReferenceException|TimeoutException e)
				 {
					 	wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(issue_policy_btn));
					    driver.findElement(issue_policy_btn).click();
				 }
				
			}
		//============================================================================================================================
			public void go_to_policy_summary()
			{

				 try{
					 
						wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_policy_summary));
					    driver.findElement(lnk_policy_summary).click();
					  
					 }
					 catch(StaleElementReferenceException|TimeoutException e)
					 {
						 	wait = new WebDriverWait(driver, 30);
							wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_policy_summary));
						    driver.findElement(lnk_policy_summary).click();
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
			public void quote_flow(String create_quote_rad,String prefix,String profit,String occupancy)
			{
				this.click_create_quote_propasal_btn();
				this.select_create_quote_radiobtn(create_quote_rad);
				this.click_quote_propasal_submit();
				this.click_bind_request();
				this.click_bind_request_submit();
				this.click_issue_binder();
				this.select_policyNo_prefix(prefix);
				this.select_profit_center(profit);
				this.select_product(occupancy);
				this.click_issue_binder_btn();
				this.click_issue_policy_btn();
			}
		 
		 
}
