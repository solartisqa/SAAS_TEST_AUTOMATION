package com.selenium.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.*;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;

public class UIMainscript
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
	public   static RemoteWebDriver driver=null; //changed
	public static  String exceptionScreenshotPath=null;

	

    @Parameters({"Project","Flow","Environment","Flag","jdbcDriver","url","dbUsername","dbPassword","browser","ResultsChoice"})
	@BeforeSuite
	public void loadconfig(String Project,String Flow,String Environment,String Flag,String jdbcDriver,String url,String dbUsername,String dbPassword,String browser,String ResultsChoice) throws DatabaseException, ClassNotFoundException, SQLException, PropertiesHandleException, MalformedURLException
	{
    	
    	System.out.println("before test");
		System.setProperty("jsse.enableSNIExtension", "false");
		configFile = new PropertiesHandle(Project,Flow,Environment,Flag,jdbcDriver,url,dbUsername,dbPassword,browser,ResultsChoice);		
		DatabaseOperation.ConnectionSetup(configFile);  
		
		//driver=objDriver.launchBrowser();
		exceptionScreenshotPath=configFile.getProperty("ScreenShotPath"); 
		
	}
    
      @Parameters({"browser"})
	  @BeforeTest(alwaysRun=true)
	 public void launchBrowser(String browser) throws MalformedURLException, InterruptedException, DatabaseException, PropertiesHandleException, ClassNotFoundException, SQLException
	 {
        objDriver=new BaseDriverScript(configFile);
		driver=objDriver.launchBrowser(browser);
    	//RemoteWebDriver driver = null;
	
		/*if (browser.equals("firefox"))
		{
			DesiredCapabilities cap = new DesiredCapabilities().firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} else if (browser.equals("chrome"))
		{
			DesiredCapabilities cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://192.168.4.131:4444/wd/hub"), cap);
		} 
		
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
    
    
		
	@Test//(dataProvider="sampleData")
	public void Login() throws SQLException, IOException, InterruptedException, AWTException
	{
		Thread.sleep(2000);
		driver.navigate().to(configFile.getProperty("EnvURL"));
		//objDriver.login(inputrow, outputrow);
		/*driver.findElement(By.xpath("//input[@id='loginForm:login_username']")).sendKeys("csruser");
		driver.findElement(By.xpath("//input[@id='loginForm:login_password']")).sendKeys("Welcome*1");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(2000);*/
	}
	
/*@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
	
    public void UITest(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException
    {
		LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
		LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
    	
			 System.out.println(RowIterator);
			 if(inputrow.get("Flag_for_execution").equals(configFile.getProperty("flagForExecution")))//
				{  
				  System.out.println("Executing main script");
				  objDriver.executeTestScript(inputrow, outputrow);
				   //objDriver.comparisonScript(inputrow, outputrow);
				  inputrow.put("Flag_for_execution", inputrow.get("Flag_for_execution")+"Completed");
				  outputrow.put("Flag_for_execution", "Completed");
			   }		   
		  input.UpdateRow(RowIterator, inputrow);
		  output.UpdateRow(RowIterator, outputrow);
    }*/

	@AfterTest
	public void close() throws DatabaseException
	{
		driver.quit();
		//objDriver.closeBrowser();
		//DatabaseOperation.CloseConn();
		
	}
//========================================================================data provider=========================================================================================
	 @DataProvider(name="UITestData")
	 public Object[][] getDataFromDataprovider() throws DatabaseException, PropertiesHandleException
	 {
		 input = new DatabaseOperation();
		 inputtable = input.GetDataObjects(configFile.getProperty("inputQuery"));
		 Iterator<Entry<Integer, LinkedHashMap<String,String>>> inputtableiterator = inputtable.entrySet().iterator();
		 output = new DatabaseOperation();
		 outputtable = output.GetDataObjects(configFile.getProperty("outputQuery"));
		 Iterator<Entry<Integer, LinkedHashMap<String,String>>> outputtableiterator = outputtable.entrySet().iterator();
		 int rowIterator = 0;
		 Object[][] combined = new Object[inputtable.size()][3];
		 while (inputtableiterator.hasNext() && outputtableiterator.hasNext()) 
			{
				Entry<Integer, LinkedHashMap<String, String>> inputentry = inputtableiterator.next();
				Entry<Integer, LinkedHashMap<String, String>> outputentry = outputtableiterator.next();
		        LinkedHashMap<String, String> inputrow = inputentry.getValue();
		        LinkedHashMap<String, String> outputrow = outputentry.getValue();
		         inputtableobjectMapper = new ObjectMapper();
				 Object inputtablerowobject = inputtableobjectMapper.convertValue(inputrow, Object.class);
				 outputtableobjectMapper = new ObjectMapper();
				 Object outputtablerowobject = outputtableobjectMapper.convertValue(outputrow, Object.class);
				 combined[rowIterator][0] = rowIterator+1;
				 combined[rowIterator][1] = inputtablerowobject;
				 combined[rowIterator][2] = outputtablerowobject;
				 rowIterator++;
			}  
		 return combined;
	 }  //Still working fine************************************
    
    
    @DataProvider(name="sampleData",parallel=true)
    public Object[][] getSampleData()
    {
    	Object data[][]=new Object[2][2];
    	data[0][0]="csruser1";
    	data[0][1]="welcome1";
    
    	data[1][0]="csruser2";
    	data[1][1]="welcome2";
    	
		return data;
    	
    }
  

}
