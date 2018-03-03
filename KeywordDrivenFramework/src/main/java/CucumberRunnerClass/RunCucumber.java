
package CucumberRunnerClass;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;


import org.testng.annotations.Test;

@CucumberOptions(features = {"src/main/java/FeatureFiles"},glue = {"src/main/java/StepDefinition"})

public class RunCucumber extends AbstractTestNGCucumberTests
{
  
 
}
