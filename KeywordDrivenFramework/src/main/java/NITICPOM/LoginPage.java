package NITICPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;
import NITICPOM.HomePage;
import common.Assert;



public class LoginPage extends BasePage
{
	
	 @FindBy(id="login_username")WebElement UserName;
	 @FindBy(id="login_password")WebElement PassWord;
	 @FindBy(xpath="//input[@value='Login']")WebElement login;
	 
	 public LoginPage(WebDriver driver)
	 {
		 super(driver);
		
	 }
	 
	 private boolean isInitialized(boolean displayed)
	 {
		return UserName.isDisplayed();
	 }
	 
	 public void setUserName(String username)
	 {
		 this.WaitWithVisibility(UserName,driver);
		 try
		 {
		     UserName.sendKeys(username);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 UserName.sendKeys(username);
		 }
		
	 }
	 
	 public void setPassword(String password)
	 {
		 this.WaitWithVisibility(PassWord,driver);
		 try
		 {
		 PassWord.sendKeys(password);
		 
		 }
		 catch(StaleElementReferenceException e)
		 {
			 PassWord.sendKeys(password);
		 }
	 }
	 
	 public HomePage ClickLogin()
	 {
		 this.WaitWithVisibility(login,driver);
		 try
		 {
		 login.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 login.click();
		 }
		 return new HomePage(this.driver);
	 }
}
