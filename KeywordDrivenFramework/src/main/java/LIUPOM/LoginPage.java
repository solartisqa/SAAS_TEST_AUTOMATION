package LIUPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;
import LIUPOM.HomePage;

public class LoginPage extends BasePage
{
	@FindBy(xpath="//input[@name='answer(Object::UserDetail::userName)']")WebElement UserName;
	@FindBy(xpath="//input[@name='answer(Object::UserDetail::passWord)']")WebElement PassWord;
	@FindBy(xpath="//input[@value='Log In']")WebElement login;
	 
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
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
