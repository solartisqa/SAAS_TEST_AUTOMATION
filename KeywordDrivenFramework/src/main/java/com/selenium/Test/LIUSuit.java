package com.selenium.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.BaseDriverScript;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;

import LIUPOM.LoginPage;
import LIUPOM.AgencyInfo;
import LIUPOM.AgentInfo;
import LIUPOM.HomePage;
import LIUPOM.InsuredClearance;

public class LIUSuit 
{
	public   DatabaseOperation input;
	public  DatabaseOperation output;

	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;

	public  ObjectMapper inputtableobjectMapper;
	public  ObjectMapper outputtableobjectMapper;
	public  LinkedHashMap<String, String> inputrow;
	public  LinkedHashMap<String, String> outputrow;
	public  static BaseDriverScript objDriver;
	public  static PropertiesHandle configFile;
	public  RemoteWebDriver driver=null; //changed
	public  static  String exceptionScreenshotPath=null;
	
	public LoginPage log;
	public HomePage hmpage;
	public AgencyInfo agencyinfo;
	public AgentInfo agentinfo;
	public InsuredClearance insuredclearance;
	
	public String FlagforExecution; 
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
	
	@Parameters({"browser","Flag"})
	@BeforeTest(alwaysRun=true)
	public void launchBrowser(String browser,String Flag) throws MalformedURLException, InterruptedException, DatabaseException, PropertiesHandleException, ClassNotFoundException, SQLException
	{
		//driver=this.launch_browser(browser,configFile);
		objDriver=new BaseDriverScript(configFile);
		driver=objDriver.launchBrowser(browser);
		FlagforExecution=Flag;
		
	}   
	
	@Test
	public void Login() throws InterruptedException
	{
		
		driver.get(configFile.getProperty("EnvURL"));
		log=new LoginPage(driver);
		log.setUserName("nitic_uw");
		log.setPassword("welcome1");
		hmpage=log.ClickLogin();
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
    public void TestCase1(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException
    {
		LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
		LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
		
			//String dataFlag="Y1";
		   System.out.println("flag in xml"+FlagforExecution);
		   System.out.println("flag in data"+inputrow.get("Flag_for_execution"));
			if(inputrow.get("Flag_for_execution").equals(FlagforExecution))//
			  {
				hmpage.clickSubmission();
				hmpage.clickNewSubmission();
				agencyinfo.setAgencyCode("25896");
				agencyinfo.setBusinessName("2587test");
				agencyinfo.setState("Alabama");
				agencyinfo.clickFindAgency();
				agencyinfo.clickAgency();
				agencyinfo.selectAgency();
			  }		   
			  input.UpdateRow(RowIterator, inputrow);
			  output.UpdateRow(RowIterator, outputrow);
	    }
	      
}
