/*package CvstarrPOM;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.basePage;
import common.Assert;

public class ClassesPage extends basePage{
	private WebDriver driver;
	 WebDriverWait wait;
	 @FindBy(id="AddClassButton") WebElement add_class;
	 @FindBy(name="answer(Object::Risk::Class::ClassName__DMS_SUBMISSION_INSURED_CLASS~CLASS_NAME)") WebElement class_name;
	 @FindBy(name="answer(Object::Risk::Class::ClassDescription__DMS_SUBMISSION_INSURED_CLASS~CLASS_DESCRIPTION)") WebElement class_description;
	 @FindBy(name="answer(SubmitType)") WebElement next_but;
	 @FindBy(name="answer(Object::Quote::PolicyHazards_ExposureAndDisapperance__DMS_SUBMISSION_VER_ADD_HAZARDS~EXPOSURE_AND_DISAPPEARANCE)") WebElement exposure_cov;
	 @FindBy(name="answer(SubmitType)") WebElement save_button;
	 @FindBy(id="CampConferenceCoverageDescription") WebElement camp_conf_desc;
	 @FindBy(xpath="//a[contains(.,'Camp Conference Coverage')]") WebElement link_camp_conf;
	 @FindBy(xpath="//a[contains(.,' Add Activity ')]") WebElement add_activity_btn;
	 @FindBy(id="ActivityName") WebElement ActivityName;
	 @FindBy(id="submitButtonNew") WebElement saveButton;
	 @FindBy(id="classBenefits") WebElement class_benefits_tab;
	 @FindBy(id="AccidentDeathPrincipalSum") WebElement accidental_death_principal;
	 @FindBy(id="TotalBenefitMedicalDental") WebElement total_benefit_max;
	 @FindBy(id="Deductible") WebElement deductible_amt;
	 @FindBy(id="TermsOfPayment") WebElement terms_of_payment;
	 @FindBy(id="NumberOfInsureds") WebElement no_of_insureds;
	 @FindBy(xpath="//div[@id='saveSuccess2']") WebElement successfull_save;
	 @FindBy(xpath="//a[contains(.,'Complete Registration')]") WebElement complete_registarion;
	 @FindBy(xpath="//input[@value='Create Quote For This Submission']") WebElement create_quote_btn;
	
	
	
	
	
	
	 
	 
	public ClassesPage(WebDriver driver) 
	{
	
   this.driver = driver;
    
	}
	
	//==================================================================================================
	public void click_addClass_btn()
	{
		try
		 {
			click(add_class);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 click(add_class);
		 }
			
		
	}
	
	//============================================================================================================
	
	public void click_next_btn()
	{
		try
		 {
			click(next_but);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 click(next_but);
		 }
	}
	
	//===============================================================================================================
	public void set_conference_description(String camp_desc) //camp_conf_desc
	{
		try
		{
			setText(camp_conf_desc, camp_desc);
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 setText(camp_conf_desc, camp_desc);
			 
		 }
		
	}
	
	//=======================================================================================================================
	
	public void click_save_btn() //save_button
	{
	try
	 {
		click(save_button);
	 }
	 catch(StaleElementReferenceException|TimeoutException e)
	 {
		 click(save_button);
	 }
	
	}
	
	//=======================================================================================================================
	public void click_camp_conf_coverage() //link_camp_conf
	{
		try
		 {
			click(link_camp_conf);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 click(link_camp_conf);
		 }
		
	
	}
	//===================================================================================================
	public void click_add_activity_btn() //add_activity_btn
	{
		try
		 {
			click(add_activity_btn);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 click(add_activity_btn);
		 }
		
	}
	
	//======================================================================================================
	public void select_activity_name(String activityname) //ActivityName
	{
		try
		 {
			select(ActivityName,activityname);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 select(ActivityName,activityname);
			 
		 }
	
	}
	//=================================================================================================================
	public void click_class_benefitsTab()  //class_benefits_tab
	{
		try
		 {
			click(class_benefits_tab);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 click(class_benefits_tab);
		 }
		
	}
	//============================================================================================================================================
	public void select_accidental_death(String acc_death)  //accidental_death_principal
	{
		try
		 {
			select(accidental_death_principal,acc_death);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 select(accidental_death_principal,acc_death);
			 
		 }
		
	}
	//========================================================================================================
	public void select_total_benefit(String tot_benefits)  //total_benefit_max
	{
		try
		 {
			select(total_benefit_max,tot_benefits);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 select(total_benefit_max,tot_benefits);
			 
		 }
		
	}
	//=================================================================================================================
	public void select_deductible(String deductible) //deductible_amt
	{
	try
	 {
		select(deductible_amt,deductible);
	 }
	 catch(StaleElementReferenceException|TimeoutException e)
	 {
		 select(deductible_amt,deductible);
		 
	 }
		
		
	}
	//===========================================================================================================
	public void select_terms_of_payment(String payment) //terms_of_payment
	{
		try
		 {
			select(terms_of_payment,payment);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 select(terms_of_payment,payment);
			 
		 }
		
	}
	//=========================================================================================================================
	public void set_no_of_insureds(String insured_no) //no_of_insureds
	{
		try
		{
			setText(no_of_insureds, insured_no);
		}
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 setText(no_of_insureds, insured_no);
			 
		 }
	
		
	}
	//===========================================================================================================================
	public void verify_successfully_saved(String text) //successfull_save
	{
		assertText(successfull_save,text);
	}
	
	//======================================================================================================================================
	public void click_complete_registration() //complete_registarion
	{
		try
		 {
			click(complete_registarion);
		 }
		 catch(StaleElementReferenceException|TimeoutException e)
		 {
			 click(complete_registarion);
		 }
		
			
	}
	//======================================================
	public void add_classes(String description,String activityname)
	{
		this.click_addClass_btn();
		this.click_next_btn();
		this.set_conference_description(description);
		this.click_save_btn();
		this.click_camp_conf_coverage();
		this.click_add_activity_btn();
		this.select_activity_name(activityname);
		this.click_save_btn();
		
	}
	
	public void fill_benefits_tab(String acc_death_sum,String tot_ben_dental,String deductible,String terms_payment,String no_insureds)
	{
		this.click_class_benefitsTab();
		this.select_accidental_death(acc_death_sum);
		this.select_total_benefit(tot_ben_dental);
		this.select_deductible(deductible);
		this.select_terms_of_payment(terms_payment);
		this.set_no_of_insureds(no_insureds);
		this.click_save_btn();
		//this.verify_successfully_saved();
		this.click_complete_registration();
	}
	

}
*/