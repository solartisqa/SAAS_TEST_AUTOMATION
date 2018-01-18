package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import com.selenium.Test.BaseSuite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class Login extends BaseSuite
{
  @Given("^user navicate to StarrAssist URL$")
  public void given() throws Throwable
  {
	  System.out.println("hiiiiiiiiiiiiiiiiiiiiii...........");
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
