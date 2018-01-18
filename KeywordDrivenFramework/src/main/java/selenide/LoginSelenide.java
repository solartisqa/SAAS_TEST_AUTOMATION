package selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginSelenide
{
public static WebDriver driver;
	@Test
	public void login()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","E:\\Sasirekha1054\\Selenium\\WebDrivers\\chromedriver.exe");
		capabilities.setCapability("browser", "Chrome");
		driver = new ChromeDriver(capabilities);
		WebDriverRunner.setWebDriver(driver);
		open("https://sa.uat.solartis.net/");
		$(By.id("loginForm:login_username")).setValue("csruser");
		//$(byText("Password")).setValue("welcome1");
		//$(byText("Log In")).click();
	}
}
