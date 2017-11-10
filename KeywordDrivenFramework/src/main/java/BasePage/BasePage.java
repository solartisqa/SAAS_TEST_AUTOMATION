package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.SupportingClasses.browserLaunching;

public class BasePage extends browserLaunching
{
  public WebDriverWait wait;
  public void WaitWithVisibility(WebElement element,WebDriver driver)//
 {
	 wait=new WebDriverWait(driver, 1000);
	 wait.until(ExpectedConditions.visibilityOf(element));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	 
}
}
