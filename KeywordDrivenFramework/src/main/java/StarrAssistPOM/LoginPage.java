package StarrAssistPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;
import StarrAssistPOM.HomePage;



public class LoginPage extends BasePage
{
	
	 @FindBy(id="loginForm:login_username")WebElement UserName;
	 @FindBy(id="loginForm:login_password")WebElement PassWord;
	 @FindBy(xpath="//input[@value='Log In']")WebElement login;
	 
	 public LoginPage(WebDriver driver)
	 {
		 super(driver);
		
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
			 
		 }
		 return new HomePage(this.driver);
	 }
	 
	 
	 
}
