package CvstarrPOM;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hazardsPage {
	private WebDriver driver;
	 WebDriverWait wait;
	private By sports_coverage=By.name("answer(Object::Quote::PolicyHazards_SportsCoverage__DMS_SUBMISSION_VER_ADD_HAZARDS~SPORTS_COVERAGE)");
	private By school_coverage=By.name("answer(Object::Quote::PolicyHazards_SchoolCoverage__DMS_SUBMISSION_VER_ADD_HAZARDS~SCHOOL_COVERAGE)");
	private By sponsered_activities=By.name("answer(Object::Quote::PolicyHazards::SponseredAndSupervisedActivities__DMS_SUBMISSION_VER_ADD_HAZARDS~SPONSERED_ACTIVITIES)");
	private By camp_conf_cov=By.name("answer(Object::Quote::PolicyHazards::CampConferenceCoverage__DMS_SUBMISSION_VER_ADD_HAZARDS~CAMP_CONFERENCE_COVERAGE)");
	private By exposure_cov=By.name("answer(Object::Quote::PolicyHazards_ExposureAndDisapperance__DMS_SUBMISSION_VER_ADD_HAZARDS~EXPOSURE_AND_DISAPPEARANCE)");
	private By save_button=By.name("answer(SubmitType)");
	
	 
	 
	public hazardsPage(WebDriver driver) 
	{
	
    this.driver = driver;
     
	}
	private void select_sports_cov(String sports_cov)
	{
		try
		{
		List CheckBoxList = driver.findElements(sports_coverage);
		for(int i=0; i< CheckBoxList.size() ; i++)
		{
			if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(sports_cov))
			{
				((WebElement) CheckBoxList.get(i)).click();
			}
		}
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			List CheckBoxList = driver.findElements(sports_coverage);
			for(int i=0; i< CheckBoxList.size() ; i++)
			{
				if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(sports_cov))
				{
					((WebElement) CheckBoxList.get(i)).click();
				}
			}
			 
		 }
		
		
	}
	//---------------------------------------------------------------
	
	private void select_school_cov(String school_cov)
	{
		try
		{
		List CheckBoxList = driver.findElements(school_coverage);
		for(int i=0; i< CheckBoxList.size() ; i++)
		{
			if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(school_cov))
			{
				((WebElement) CheckBoxList.get(i)).click();
			}
		}
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			List CheckBoxList = driver.findElements(school_coverage);
			for(int i=0; i< CheckBoxList.size() ; i++)
			{
				if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(school_cov))
				{
					((WebElement) CheckBoxList.get(i)).click();
				}
			}
			 
		 }
		
	}
	
	//--------------------------------------------------------------------------------
	
	private void select_sponsered_activities(String sponsered_act)
	{
		try
		{
		List CheckBoxList = driver.findElements(sponsered_activities);
		for(int i=0; i< CheckBoxList.size() ; i++)
		{
			if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(sponsered_act))
			{
				((WebElement) CheckBoxList.get(i)).click();
			}
		}
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			List CheckBoxList = driver.findElements(sponsered_activities);
			for(int i=0; i< CheckBoxList.size() ; i++)
			{
				if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(sponsered_act))
				{
					((WebElement) CheckBoxList.get(i)).click();
				}
			}
			 
		 }
		
		
	}
	
	
	//----------------------------------------------------------------------------------------
	
	private void select_camp_confCov(String camp_cov)
	{
		try
		{
		List CheckBoxList = driver.findElements(camp_conf_cov);
		for(int i=0; i< CheckBoxList.size() ; i++)
		{
			if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(camp_cov))
			{
				((WebElement) CheckBoxList.get(i)).click();
			}
		}
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			List CheckBoxList = driver.findElements(camp_conf_cov);
			for(int i=0; i< CheckBoxList.size() ; i++)
			{
				if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(camp_cov))
				{
					((WebElement) CheckBoxList.get(i)).click();
				}
			}
			 
		 }
	
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	private void select_exposure(String exposure)
	{
		try
		{
		List CheckBoxList = driver.findElements(exposure_cov);
		for(int i=0; i< CheckBoxList.size() ; i++)
		{
			if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(exposure_cov))
			{
				((WebElement) CheckBoxList.get(i)).click();
			}
		}
		
		}
		catch(StaleElementReferenceException|TimeoutException e)
		 {
			List CheckBoxList = driver.findElements(exposure_cov);
			for(int i=0; i< CheckBoxList.size() ; i++)
			{
				if(((WebElement) CheckBoxList.get(i)).getAttribute("value").equals(exposure_cov))
				{
					((WebElement) CheckBoxList.get(i)).click();
				}
			}
			 
		 }
		
	
		
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	private void click_saveButton()
	{
		 try{
			 
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(save_button));
			    driver.findElement(save_button).click();
			 }
			 catch(StaleElementReferenceException|TimeoutException e)
			 {
				 	wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(save_button));
				    driver.findElement(save_button).click();
			 }
		 try
		 	{
		 	 wait.until(ExpectedConditions.titleContains("Starr Online Quoting & Policy Administration System"));
		 	 if(!driver.getTitle().equals("Starr Online Quoting & Policy Administration System")) 
				{
		 		wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(save_button));
			    driver.findElement(save_button).click();
				}
		 	}
		 	catch(TimeoutException e)
		 	{
		 		System.out.println("TimeoutException");
		 	}
			
			
			
	}
	//==============================================================================================================
	
	public void fill_hazards_page(String sports,String school,String sponsered,String camp,String exposure)
	{
		this.select_sports_cov(sports);
		this.select_school_cov(school);
		this.select_sponsered_activities(sponsered);
		this.select_camp_confCov(camp);
		this.select_exposure(exposure);
		this.click_saveButton();
	}
	

}
