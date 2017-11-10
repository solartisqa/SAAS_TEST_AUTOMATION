package com.selenium.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.BaseDriverScript;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.SupportingClasses.browserLaunching;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;
import StarrAssistPOM.*;
public class StarrAssistSuite extends browserLaunching
{
	public   DatabaseOperation input;
	public  DatabaseOperation output;

	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;
	public  Iterator<Entry<Integer, LinkedHashMap<String, String>>> inputtableiterator;
	public  Iterator<Entry<Integer, LinkedHashMap<String, String>>> outputtableiterator;
	public  ObjectMapper inputtableobjectMapper;
	public  ObjectMapper outputtableobjectMapper;
	public  LinkedHashMap<String, String> inputrow;
	public  LinkedHashMap<String, String> outputrow;
	public  static BaseDriverScript objDriver;
	public  static PropertiesHandle configFile;
	public    RemoteWebDriver driver=null; //changed
	public static  String exceptionScreenshotPath=null;
	
	public LoginPage log;
	public HomePage hmpage;
    public GetAQuotePage getQuotePage;
    @Parameters({"Project","Flow","Environment","Flag","jdbcDriver","url","dbUsername","dbPassword","browser","ResultsChoice"})
	@BeforeSuite
	public void loadconfig(String Project,String Flow,String Environment,String Flag,String jdbcDriver,String url,String dbUsername,String dbPassword,String browser,String ResultsChoice) throws DatabaseException, ClassNotFoundException, SQLException, PropertiesHandleException, MalformedURLException
	{
    	System.out.println("before test");
		System.setProperty("jsse.enableSNIExtension", "false");
		configFile = new PropertiesHandle(Project,Flow,Environment,Flag,jdbcDriver,url,dbUsername,dbPassword,browser,ResultsChoice);		
		DatabaseOperation.ConnectionSetup(configFile);  
		exceptionScreenshotPath=configFile.getProperty("ScreenShotPath"); 
		
	}
    
      @Parameters({"browser"})
	  @BeforeTest(alwaysRun=true)
	 public void launchBrowser(String browser) throws MalformedURLException, InterruptedException, DatabaseException, PropertiesHandleException, ClassNotFoundException, SQLException
	 {
		//driver=this.launch_browser(browser,configFile);
    	objDriver=new BaseDriverScript(configFile);
  		driver=objDriver.launchBrowser(browser);
    	
	}
    
    
	@Test
	public void Login() throws InterruptedException
	{
		
		driver.get(configFile.getProperty("EnvURL"));
		log=new LoginPage(driver);
		
		log.setUserName("csruser");
		
		log.setPassword("Welcome*1");
		
		hmpage=log.ClickLogin();
	}
	
	/*@Parameters({"Flag"})
	@Test(dependsOnMethods = { "Login" })
	public void TestCase1(String Flag) throws InterruptedException
	{
		if(Flag.equals("Y"))
		{
		getQuotePage=hmpage.ClickGetAQuote();
		Thread.sleep(3000);
		getQuotePage.selectDestinationCountry("");
		}
	}*/
	
	@Test(dataProvider="sampleData",dependsOnMethods = { "Login" })
	public void TestCase1(String country,String plan) throws InterruptedException
	{
		getQuotePage=hmpage.ClickGetAQuote();
		Thread.sleep(3000);
		getQuotePage.selectStateOfResidence(country);
		getQuotePage.selectPlanName(plan);
		Thread.sleep(1000);
	}
	
	
	@AfterClass(alwaysRun=true)
	public void close()
	{
		driver.quit();
	}

	 @DataProvider(name="sampleData")
	    public Object[][] getSampleData()
	    {
	    	Object data[][]=new Object[2][2];
	    	data[0][0]="Alabama";
	    	data[0][1]="CAT 70";
	    
	    	data[1][0]="Alaska";
	    	data[1][1]="CAT 70";
	    	
	    	/*data[2][0]="Arizona";
	    	data[2][1]="CAT 70";*/
	    	
			return data;
	    	
	    }
	
}
