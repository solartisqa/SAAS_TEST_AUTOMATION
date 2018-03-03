package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import selenide.CukHooks;
import cucumber.api.java.en.Then;

import org.openqa.selenium.WebDriver;

import StarrAssistPOM.LoginPage;
import cucumber.api.java.en.And;

public class Login
{
	WebDriver driver=null;
	public Login()
	{
	driver=CukHooks.driver;
	}
	LoginPage log=new LoginPage(driver);
	
  @Given("^user navicate to StarrAssist URL$")
  public void given() throws Throwable
  {
	  System.out.println("hiiiiiiiiiiiiiiiiiiiiii...........");
	driver.get("https://saqa.solartis.net/");
		//$(By.id("loginForm:login_username")).setValue("csruser");
  }

  @When("^user is on Login Page$")
  public void when() throws Throwable 
  {
	  System.out.println("hello...........");
  }

  @And("^User enters UserName$")
  public void then() throws Throwable 
  {
	  System.out.println("hooooo...........");
	  log.setUserName("csruser");
  
	
  }

  @And("^User enters password$")
  public void and() throws Throwable
  {
	  System.out.println("yo...........");
	  log.setPassword("Welcome*1");
  }

  @Then("^Login Successfully$")
  public void but() throws Throwable
  {
	  System.out.println("ri..........."); 
	  log.ClickLogin();
  }

}
