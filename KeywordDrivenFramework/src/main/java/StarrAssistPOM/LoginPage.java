package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import StarrAssistPOM.HomePage;



public class LoginPage 
{
	 private WebDriver driver;
	 WebDriverWait wait;
	 @FindBy(id="loginForm:login_username")WebElement UserName;
	 @FindBy(id="loginForm:login_password")WebElement PassWord;
	 @FindBy(xpath="//input[@value='Log In']")WebElement login;
	 
	 public LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void setUserName(String username)
	 {
		 UserName.sendKeys(username);
	 }
	 
	 public void setPassword(String password)
	 {
		 PassWord.sendKeys(password);
	 }
	 
	 public HomePage ClickLogin()
	 {
		 login.click();
		 return new HomePage(this.driver);
	 }
}
