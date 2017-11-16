package com.selenium.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.BaseDriverScript;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;

import NITICPOM.*;


public class NITICSuite 
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
	
	
	public String FlagforExecution;
	
	public LoginPage log;
	public HomePage hmpage;
	public BusinessPage BusPage;
	public CoveragePage CovPage;
    
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
		
		driver.get("https://qanitic.solartis.net/NITIC/NITIC/Login.xhtml");
		log=new LoginPage(driver);
		log.setUserName("nitic_uw");
		log.setPassword("welcome1");
		hmpage=log.ClickLogin();
	}



	  // @SuppressWarnings("unchecked")
		@Test(dependsOnMethods = { "Login" })
		
	    public void TestCase1() throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException
	    {
			
				//String dataFlag="Y1";
				// if(dataFlag.equals(FlagforExecution))//
				  // {  
					
					 hmpage.ClickTruckersInsurance();
					 hmpage.selectSubBusinessType("Business - Not for Hire");
					 BusPage=hmpage.ClickContinue();
					 BusPage.setFirstName1("Test");
					 BusPage.setLastName2("QA");
					 BusPage.ClickPrimaryCommunicationType("Home");
					 BusPage.setPrimaryNumber("1234567890");
					 BusPage.ClickAlternateNumberType("Home");
					 BusPage.setAlternativeNumber("5632147890");
					 BusPage.setEmailAddress("test@gmail.com");
					 BusPage.selectTypeOfBusiness("Corporation");
					 BusPage.setBusinessName1("busname");
					 BusPage.setYearInBusiness("2");
					 BusPage.setSSN_FEIN("456123789");
					 BusPage.setInsuredDescription("description");
					 BusPage.setAddress1("1000 North Florida Avenue");
					 Thread.sleep(1000);
					 BusPage.setAddress2("1645 Parkway");
					 Thread.sleep(1000);
					 BusPage.setCity("Tampa");
					 Thread.sleep(1000);
					 BusPage.selectState("Florida");
					 BusPage.setZipcode("37862");
					 BusPage.ClickIsMailingAddressSame("Yes");
					 CovPage=BusPage.ClickCoverage();
					 CovPage.selectLiabilityLimitType("Split Limit"); //condition
					 CovPage.selectSplitLimitofLiability("$15,000 / $30,000 / $5,000");
					 CovPage.setPremiumPerVehicle("1000");
					 CovPage.setQuoteStartDate("11/16/2017");
					 // inputrow.put("Flag_for_execution", inputrow.get("Flag_for_execution")+"Completed");
					 // outputrow.put("Flag_for_execution", "Completed");
				  // }		   
			 // input.UpdateRow(RowIterator, inputrow);
			 // output.UpdateRow(RowIterator, outputrow);
	    }
	   
	   
	   @DataProvider(name="UITestData")//,parallel=true)
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
			 }
	   
}
