package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;

import cucumber.api.java.en.And;


public class Login
{
  @Given("^user navicate to StarrAssist URL$")
  public void given() throws Throwable
  {
	  System.out.println("hiiiiiiiiiiiiiiiiiiiiii...........");
	
		$(By.id("loginForm:login_username")).setValue("csruser");
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
  }

  @And("^User enters password$")
  public void and() throws Throwable
  {
	  System.out.println("yo...........");
  }

  @Then("^Login Successfully$")
  public void but() throws Throwable 
  {
	  System.out.println("ri..........."); 
  }

}
