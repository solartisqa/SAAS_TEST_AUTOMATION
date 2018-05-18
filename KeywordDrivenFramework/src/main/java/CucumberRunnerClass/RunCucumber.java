
package CucumberRunnerClass;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;


import org.testng.annotations.Test;

@CucumberOptions(features = {"src/main/java/FeatureFiles"},glue = {"src/main/java/StepDefinition"},plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, monochrome = true)

public class RunCucumber extends AbstractTestNGCucumberTests
{
  
 
}
