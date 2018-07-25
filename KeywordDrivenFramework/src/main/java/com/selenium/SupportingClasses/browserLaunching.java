package com.selenium.SupportingClasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.controllerScript;

import org.openqa.selenium.remote.CapabilityType;

public class browserLaunching {

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	WebDriver wdriver = null;

	public WebDriver launch_browser(String browser, String serverip) throws MalformedURLException {

		RemoteWebDriver driver = null;

		if (browser.equals("firefox")) {
			DesiredCapabilities cap = new DesiredCapabilities().firefox();
			cap.setBrowserName("firefox");
			// cap.setPlatform(Platform.LINUX);
			driver = new RemoteWebDriver(new URL("http://" + serverip + "/wd/hub"), cap);
			// driver=new EventFiringWebDriver(wdriver);
			// eventListerner=new TheEventListener();
			// driver.register(eventListerner);
			driver.manage().window().maximize();
		} else if (browser.equals("chrome")) {
			String downloadFilepath = "R:\\SeleniumConfig\\STARR-ASSIST\\Cancel\\PDF";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("pdfjs.disabled", true);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.directory_upgrade", true);
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();

			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			// options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model

			/*
			 * DesiredCapabilities cap = new DesiredCapabilities().chrome();
			 * cap.setBrowserName("chrome"); cap.setPlatform(Platform.LINUX);
			 * cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			 * cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 * cap.setCapability(ChromeOptions.CAPABILITY, options);
			 */
			driver = new RemoteWebDriver(new URL("http://" + serverip + "/wd/hub"), options);
			driver.manage().window().maximize();
		} else if (browser.equals("IE")) {
			DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();
			cap.setCapability("ignoreZoomSetting", true);
			cap.setCapability("javascriptEnabled", true);
			cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "dismiss");
			cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 0);
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			driver = new RemoteWebDriver(new URL("http://" + serverip + "/wd/hub"), cap);
		} else if (browser.equals("phantom")) {
			DesiredCapabilities cap = new DesiredCapabilities().phantomjs();
			driver = new RemoteWebDriver(new URL("http://192.168.4.131:5564/wd/hub"), cap);
			// driver.get("https://saqa.solartis.net/");
		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setWebDriver(driver);
		wdriver = getDriver();
		// wdriver.manage().window().maximize();
		wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return wdriver;
	}

	public WebDriver getDriver() {
		return dr.get();
	}

	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}
	/*
	 * switch(browser.toUpperCase()) {
	 * 
	 * case "IE": System.setProperty("webdriver.ie.driver",driver_path +
	 * "IEDriverServer.exe"); capabilities.setCapability("browser", "IE");
	 * capabilities.setCapability("browser_version", "10.0");
	 * capabilities.setCapability("os", "Windows");
	 * capabilities.setCapability("os_version", "7");
	 * capabilities.setCapability("resolution", "800x600");
	 * capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
	 * capabilities.setCapability(InternetExplorerDriver.
	 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	 * capabilities.setCapability("ignoreZoomSetting", true);
	 * capabilities.setCapability("javascriptEnabled", true);
	 * capabilities.setCapability("platform", "WINDOWS");
	 * capabilities.setCapability("ignoreProtectedModeSettings", true);
	 * capabilities.setCapability("ie.ensureCleanSession", true);
	 * capabilities.setCapability("browserName", "internet explorer");
	 * capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,
	 * "dismiss");
	 * capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,0);
	 * capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,
	 * true); capabilities.setCapability(InternetExplorerDriver.
	 * ENABLE_ELEMENT_CACHE_CLEANUP,true);
	 * capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,false)
	 * ; capabilities.setCapability("browserstack.debug", true);
	 * System.out.println(browser); wdriver = new
	 * InternetExplorerDriver(capabilities); driver=new
	 * EventFiringWebDriver(wdriver); eventListerner=new TheEventListener();
	 * driver.register(eventListerner); driver.manage().deleteAllCookies();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); break;
	 * 
	 * case "CHROME":
	 * 
	 * System.out.println(browser);
	 * System.setProperty("webdriver.chrome.driver",driver_path +
	 * "chromedriver.exe"); capabilities.setCapability("browser", "Chrome");
	 * capabilities.setCapability("browser_version", "57.0");
	 * capabilities.setCapability("os", "Windows");
	 * capabilities.setCapability("os_version", "7");
	 * capabilities.setCapability("resolution", "800x600");
	 * capabilities.setCapability("browserstack.debug", true); wdriver = new
	 * ChromeDriver(capabilities); driver=new EventFiringWebDriver(wdriver);
	 * eventListerner=new TheEventListener(); driver.register(eventListerner);
	 * driver.manage().deleteAllCookies(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); break;
	 * 
	 * 
	 * case "FIREFOX":
	 * 
	 * System.out.println(browser);
	 * System.setProperty("webdriver.gecko.driver",driver_path + "geckodriver.exe");
	 * capabilities.setCapability("ignoreZoomSetting", true);
	 * capabilities.setCapability("javascriptEnabled", true);
	 * capabilities.setCapability("platform", "WINDOWS");
	 * capabilities.setCapability("ignoreProtectedModeSettings", true); wdriver=new
	 * FirefoxDriver(capabilities); driver=new EventFiringWebDriver(wdriver);
	 * eventListerner=new TheEventListener(); driver.register(eventListerner);
	 * driver.manage().deleteAllCookies(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); break;
	 * 
	 * default : System.out.println("not a valid browser"); break; }
	 * //driver.get(Url); return driver; }
	 */

	public void stop_browser() {
		// dr.quit();
	}

	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		RemoteWebDriver driver = null;
		;
		try {
			DesiredCapabilities cap = new DesiredCapabilities().phantomjs();
			driver = new RemoteWebDriver(new URL("http://192.168.4.131:5564/wd/hub"), cap);
			driver.get("https://saqa.solartis.net/");
			driver.findElement(By.id("loginForm:login_username")).sendKeys("csruser");
			driver.findElement(By.id("loginForm:login_password")).sendKeys("Welcome*1");
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
			Thread.sleep(1000);
			// WebDriverWait wait=new WebDriverWait(driver,10);
			// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='MenuBar:QuoteFlowLink']"))));
			driver.findElement(By.xpath("//a[@id='AccountLink']")).click();
		} catch (Exception e) {
			controllerScript.takeScreenShot(driver, "D:\\", "testdata");
		}

	}

}
