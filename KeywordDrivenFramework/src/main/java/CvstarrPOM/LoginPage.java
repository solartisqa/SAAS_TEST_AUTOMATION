package CvstarrPOM;

import java.util.NoSuchElementException;
//import java.util.concurrent.TimeoutException;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
//import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.basePage;
import utillPack.Login_action;
import utillPack.UIOperation;


public class LoginPage extends basePage
{
	 private WebDriver driver;
	 WebDriverWait wait;
	 @FindBy(name="answer(Object::UserDetail::userName)")WebElement objusername;
	 @FindBy(name="answer(Object::UserDetail::passWord)")WebElement objpassword;
	 @FindBy(xpath="//input[@value='Log In']")WebElement objlogin ;
	  
	 
		public LoginPage(WebDriver driver,String url) 
		{
	    	
	        this.driver = driver;
	         
	       // if(!this.driver.getTitle().equals("Welcome to Starr Online Quoting & Policy Administration System")) 
	        //{
	        	this.driver.get(url);
	      //}  
	        	PageFactory.initElements(driver, this);
	        
		}
			
       public void setUserName(String username) //objusername
	     {
	    	try
	 		{
	 			this.setText(objusername, username);
	 		}
	 		catch(StaleElementReferenceException|TimeoutException e)
	 		{
	 		this.setText(objusername, username);
	 	    }
	
	    }
	     
	     
	     public void setPassWord(String password)
	     {
	    	 System.out.println("Set password");
	    	 try
	    	 {
	    		 this.setText(objpassword, password);
	    	 }
	    	 catch(StaleElementReferenceException|TimeoutException e)
	    	 {
	    		 this.setText(objpassword, password);
	    		 
	    	 }
	    	
	    	
	     }
	     
	     public SubmissionPage click_login() 
	     {
	    	 try
	    	 {
	    		 this.click(objlogin);
	    		 
	    		
	    	 }
	    		 
	    	 catch(StaleElementReferenceException|TimeoutException e)
	    	 {
	    		this.click(objlogin);
	    		 
	    	 }
	    	 
	    	try
	    	{
	    	 wait.until(ExpectedConditions.titleContains("Starr Online Quoting & Policy Administration System"));
	    	 if(!driver.getTitle().equals("Starr Online Quoting & Policy Administration System")) 
			{
	    		 objlogin.click();
	    		 
			}
	    	}
	    	catch(TimeoutException e)
	    	{
	    		System.out.println("TimeoutException");
	    	}
			return new SubmissionPage(driver) ;
	     }
	     
	     public void Login(String username,String password)
	     {
	    	 this.setUserName(username);
	    	 this.setPassWord(password);
	    	 this.click_login();
	     }
	     
}
