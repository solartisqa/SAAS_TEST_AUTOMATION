package com.selenium.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Constructor;
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
import com.solartis.selenium.macroPackage.MacroInterface;

public class UIMainscript
{
	public static DatabaseOperation input;
	public static DatabaseOperation output;
	public static DatabaseOperation LoginScript;
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;
	public static Iterator<Entry<Integer, LinkedHashMap<String, String>>> inputtableiterator;
	public static Iterator<Entry<Integer, LinkedHashMap<String, String>>> outputtableiterator;
	public static ObjectMapper inputtableobjectMapper;
	public static ObjectMapper outputtableobjectMapper;
	public static BaseDriverScript objDriver;
	public static PropertiesHandle configFile;
	public static boolean loginStatus;
	public  static WebDriver driver=null;
	public static String exceptionScreenshotPath=null;
	public static MacroInterface macro = null;
	public static DatabaseOperation objectcomparison ;
	
	String Project=null;
	String Flow=null;
	String Environment=null;
	String Flag=null;
	String jdbcDriver=null;
	String url=null;
	String dbUsername=null;
	String dbPassword=null;
	String ResultsChoice=null;
	String browser=null;

	public UIMainscript(String Project,String Flow,String Environment,String Flag,String jdbcDriver,String url,String dbUsername,String dbPassword,String browser, String ResultsChoice)
	{
		this.Project=Project;
		this.Flow=Flow;
		this.Environment=Environment;
		this.Flag=Flag;
		this.jdbcDriver=jdbcDriver;
		this.url=url;
		this.dbUsername=dbUsername;
		this.dbPassword=dbPassword;
		this.browser=browser;
		this.ResultsChoice=ResultsChoice;
		
	}
  
	@BeforeTest//(alwaysRun=true)
	public void loadconfig() throws DatabaseException, ClassNotFoundException, SQLException, PropertiesHandleException, MalformedURLException
	{
		System.setProperty("jsse.enableSNIExtension", "false");
		//configFile = new PropertiesHandle(System.getProperty("Project"),System.getProperty("Flow"),System.getProperty("Env"),Flag,System.getProperty("JDBC_DRIVER"),System.getProperty("DB_URL"),System.getProperty("USER"),System.getProperty("password"),myBrowser,System.getProperty("ResultChoice"));		
		configFile = new PropertiesHandle(Project,Flow,Environment,Flag,jdbcDriver,url,dbUsername,dbPassword,browser,ResultsChoice);		

		DatabaseOperation.ConnectionSetup(configFile);  
		objDriver=new BaseDriverScript(configFile);
		driver=objDriver.launchBrowser();
		exceptionScreenshotPath=configFile.getProperty("ScreenShotPath");
		LoginScript=new DatabaseOperation();
		LoginScript.getDataobjects(configFile.getProperty("loginScript"));
	
	}
		
	@Test//(alwaysRun=true)
	public void Login() throws SQLException, IOException, InterruptedException, AWTException, DatabaseException
	{
		 driver.get(configFile.getProperty("EnvURL"));
		 System.out.println(configFile.getProperty("username")+configFile.getProperty("password"));
		 objDriver.login(LoginScript,configFile.getProperty("username"),configFile.getProperty("password"));
	}
	
	@SuppressWarnings("unchecked")
	 
	@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
	
    public void UITest(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws SQLException, IOException, InterruptedException, AWTException, DatabaseException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MacroException, POIException
    {
		LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
		LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
    	System.out.println(RowIterator);
    	
		if(inputrow.get("Flag_for_execution").equals(configFile.getProperty("flagForExecution")))
		{ 			    	
		   	System.out.println("Executing main script");
		   	objDriver.executeTestScript(inputrow, outputrow);
		   	this.generatExpectedResult(inputrow,outputrow);		
		   	output.UpdateRow(RowIterator, outputrow);
		    inputrow.put("Flag_for_execution", inputrow.get("Flag_for_execution")+"Completed");
		    outputrow.put("Flag_for_execution", "Completed");
		    this.CompareExpectedWithActual(outputrow);				    				  
		}		   
		input.UpdateRow(RowIterator, inputrow);
		output.UpdateRow(RowIterator, outputrow);
    }
	
	@AfterTest
	public void close() throws DatabaseException
	{
		objDriver.closeBrowser();
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
    
    public void generatExpectedResult(LinkedHashMap<String, String> inputrow,LinkedHashMap<String, String> outputrow ) throws ClassNotFoundException, MacroException, DatabaseException, POIException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
    	System.out.println(configFile.getProperty("comparison")+"-----------"+this.Project+"Macro");
    	if(configFile.getProperty("comparison").equals("Y"))
		  {
			  String classname = "com.solartis.selenium.macroPackage."+configFile.getProperty("MacroClassName");
			  Class<?> classobj=Class.forName(classname);
			  Constructor<?> cons = classobj.getConstructor(PropertiesHandle.class);
			  macro = (MacroInterface) cons.newInstance(configFile);
			  macro.LoadSampleRatingmodel(configFile, inputrow);
			  macro.GenerateExpected(inputrow, configFile);
			  macro.PumpinData(inputrow, configFile);
			  macro.PumpoutData(outputrow, inputrow, configFile);
		  }
    }
    
    public void CompareExpectedWithActual(LinkedHashMap<String, String> outputrow) throws SQLException, DatabaseException
    {
    	objectcomparison=new DatabaseOperation();
		LinkedHashMap<Integer, LinkedHashMap<String, String>> comparisontable=objectcomparison.GetDataObjects("select * from ComparisionCondition");
    	if (configFile.getProperty("comparison").equals("Y"))
	    {
    		for (Entry<Integer, LinkedHashMap<String, String>> entry : comparisontable.entrySet()) 	
    		{
    			LinkedHashMap<String, String> comparisonrow = entry.getValue();
				if (comparisonrow.get("Comaparision_Flag").equals("Y"))
				{
					System.out.println("coming to comparison");
				   outputrow=objDriver.CompareFunction(outputrow,comparisonrow);
				}
			}
			   //outputrow.updateRow();
	    	
		}
    }
}
