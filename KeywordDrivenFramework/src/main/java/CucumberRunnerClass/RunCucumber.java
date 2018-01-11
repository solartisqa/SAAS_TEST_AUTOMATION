
package CucumberRunnerClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;
@CucumberOptions(features = {"src/test/java/com/solartis/test/Features"},glue = "com.solartis.test.stepDefinition")
public class RunCucumber extends AbstractTestNGCucumberTests{
  @Test
  public void Test() 
  {
      
  }
}
