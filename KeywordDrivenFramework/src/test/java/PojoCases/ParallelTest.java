package PojoCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertNotNull;

public class ParallelTest {
    public static final String SEARCH_TERMS = "search-terms";
    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(@Optional("chrome") String browser) throws MalformedURLException{
        driver = getBrowser(browser);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private WebDriver getBrowser(String browser) throws MalformedURLException {
        if(browser.equals("chrome")){
        	DesiredCapabilities cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			driver = new RemoteWebDriver(new URL("http://192.168.4.131:5561/wd/hub"), cap);
			return driver;
        }
        return new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test(description = "Check parallel selenium works.",
          dataProvider = SEARCH_TERMS)
    public void parallelSeleniumTest(String searchTerm){
        driver.get("http://google.com");
        WebElement search = driver.findElement(By.id("gbqfq"));
        new Actions(driver)
                .sendKeys(search, searchTerm)
                .sendKeys(search, Keys.ENTER)
                .perform();
        String firstResult = driver.findElements(By.className("r")).get(0).getText();
        assertNotNull(firstResult);
        System.out.println(firstResult);
    }

    @DataProvider(name = SEARCH_TERMS, parallel = true)
    public Object[][] getSearchTerms(){
        return new Object[][]{
                {"google"},
                {"microsoft"},
                {"facebook"},
                {"amazon"},
                {"apple"},
                {"oracle"},
                {"yahoo"},
                {"jetbrains"},
                {"intellij idea"},
                {"selenium"},
                {"java"},
                {"testng"},
                {"code"}
        };
    }
}