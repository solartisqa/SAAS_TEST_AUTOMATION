
package CucumberRunnerClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;
@CucumberOptions(features = {"src/main/java/FeatureFiles"},glue = "StepDefinition")
public class RunCucumber extends AbstractTestNGCucumberTests
{
  @Test
  public void Test() 
  {
      
  }
}
