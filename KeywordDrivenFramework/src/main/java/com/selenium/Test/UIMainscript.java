package com.selenium.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.*;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.MacroException;
import com.selenium.exception.POIException;
import com.selenium.exception.PropertiesHandleException;

public class UIMainscript
{
	public static DatabaseOperation input;
	public static DatabaseOperation output;

	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;
	public static Iterator<Entry<Integer, LinkedHashMap<String, String>>> inputtableiterator;
	public static Iterator<Entry<Integer, LinkedHashMap<String, String>>> outputtableiterator;
	public static ObjectMapper inputtableobjectMapper;
	public static ObjectMapper outputtableobjectMapper;
	public static LinkedHashMap<String, String> inputrow;
	public static LinkedHashMap<String, String> outputrow;
	public static BaseDriverScript objDriver;
	public static PropertiesHandle configFile;
	public static boolean loginStatus;
	public  static WebDriver driver=null;
	public static String exceptionScreenshotPath=null;

	@BeforeTest//(alwaysRun=true)
	public void loadconfig() throws DatabaseException, ClassNotFoundException, SQLException, PropertiesHandleException, MalformedURLException
	{
		System.setProperty("jsse.enableSNIExtension", "false");
		System.out.println(System.getProperty("Project")+System.getProperty("Flow")+System.getProperty("Env")+System.getProperty("FlagForExecution")+System.getProperty("JDBC_DRIVER")+System.getProperty("DB_URL")+System.getProperty("USER")+System.getProperty("password")+System.getProperty("browser")+ System.getProperty("ResultChoice")+System.getProperty("remoteIP")+ System.getProperty("Port"));
		try
		{
		configFile = new PropertiesHandle(System.getProperty("Project"),System.getProperty("Flow"),System.getProperty("Env"),System.getProperty("FlagForExecution"),System.getProperty("JDBC_DRIVER"),System.getProperty("DB_URL"),System.getProperty("USER"),System.getProperty("password"),System.getProperty("browser"), System.getProperty("ResultChoice"), System.getProperty("remoteIP"), System.getProperty("Port"),System.getProperty("userLogin"));		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		DatabaseOperation.ConnectionSetup(configFile);
		objDriver=new BaseDriverScript(configFile);
		driver=objDriver.launchBrowser();
		exceptionScreenshotPath=configFile.getProperty("ScreenShotPath");
	}
		
	@Test//(alwaysRun=true)
	public void Login() throws SQLException, IOException, InterruptedException, AWTException
	{
		driver.get(configFile.getProperty("EnvURL"));
		try
		{
		objDriver.login(inputrow, outputrow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
    public void UITest(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MacroException, POIException
    {
		LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
		LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
		try
		{
			 if(inputrow.get("Flag_for_execution").equals(configFile.getProperty("flagForExecution")))
				{  
				 String ExecutionChoice=configFile.getProperty("ResultsChoice");
				  System.out.println("Executing main script");
				  if(ExecutionChoice.equals("Comparison"))
				  {
					  objDriver.generatExpectedResult(inputrow, outputrow);
				  }
				  
				  try
				  {
				  objDriver.executeTestScript(inputrow, outputrow);
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
				  if(ExecutionChoice.equals("Comparison"))
				  {
					  objDriver.CompareExpectedWithActual(outputrow);
				  }
				  inputrow.put("Flag_for_execution", "Completed");
				  outputrow.put("Flag_for_execution", "Pass");
			   }
		}
		catch(Exception e)
		{
			 inputrow.put("Flag_for_execution", "Fail");
			  outputrow.put("Flag_for_execution", "Fail");
		}
			 
		   input.UpdateRow(RowIterator, inputrow);
		   output.UpdateRow(RowIterator, outputrow);
    }
	@AfterTest
	public void close() throws DatabaseException
	{
		//objDriver.closeBrowser();
		DatabaseOperation.CloseConn();
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
	 }
}
