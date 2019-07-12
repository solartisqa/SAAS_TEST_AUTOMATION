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
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.*;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.MacroException;
import com.selenium.exception.POIException;
import com.selenium.exception.PropertiesHandleException;

public class UIMainscript {
	public static DatabaseOperation input;
	public static DatabaseOperation output;
	protected WebDriver wdriver = null;
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;
	public static Iterator<Entry<Integer, LinkedHashMap<String, String>>> inputtableiterator;
	public static Iterator<Entry<Integer, LinkedHashMap<String, String>>> outputtableiterator;
	public static ObjectMapper inputtableobjectMapper;
	public static ObjectMapper outputtableobjectMapper;
	public static LinkedHashMap<String, String> inputrow;
	public static LinkedHashMap<String, String> outputrow;
	// public BaseDriverScript objDriver;
	public static PropertiesHandle configFile;
	public static boolean loginStatus;
	public static WebDriver driver = null;
	public static String exceptionScreenshotPath = null;
	public static Connection conn = null;
	public Statement stmt = null;

	@BeforeTest // (alwaysRun=true)
	public void loadconfig(ITestContext context) throws DatabaseException, ClassNotFoundException, SQLException, PropertiesHandleException,
			MalformedURLException {
		String APIName = "";
		System.setProperty("jsse.enableSNIExtension", "false");
		context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(System.getProperty("Numberofbrowser")));
		System.out.println(System.getProperty("Project") + System.getProperty("Flow") + System.getProperty("Env")
				+ System.getProperty("FlagForExecution") + System.getProperty("JDBC_DRIVER")
				+ System.getProperty("DB_URL") + System.getProperty("USER") + System.getProperty("password")
				+ System.getProperty("browser") + System.getProperty("ResultChoice") + System.getProperty("remoteIP")
				+ System.getProperty("Port"));
		try {
			if(System.getProperty("Project").equalsIgnoreCase("BriteCo"))
			{
				APIName = "Submission";
			}
			System.out.println(APIName);
			configFile = new PropertiesHandle(System.getProperty("Project"), System.getProperty("Flow"),
					System.getProperty("Env"), System.getProperty("FlagForExecution"),
					System.getProperty("JDBC_DRIVER"), System.getProperty("DB_URL"), System.getProperty("USER"),
					System.getProperty("password"), System.getProperty("browser"), System.getProperty("ResultChoice"),
					System.getProperty("remoteIP"), System.getProperty("Port"), System.getProperty("userLogin"),APIName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn = (Connection) DatabaseOperation.ConnectionSetup(configFile);
		exceptionScreenshotPath = configFile.getProperty("ScreenShotPath");

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "UITestData")
	public void UITest(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MacroException, POIException 
	{
		LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
		LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
		stmt = (Statement) conn.createStatement();
		if (inputrow.get("Flag_for_execution").equals(configFile.getProperty("flagForExecution"))) 
		{
			try 
			{
				String ExecutionChoice = configFile.getProperty("ResultsChoice");
				UIScriptsInterface objDriver = new BaseDriverScript(configFile);
				if(System.getProperty("Project").equals("BriteCo"))
				{
					objDriver = new BriteCoDriverScript(configFile);
				} else {
					objDriver = new BaseDriverScript(configFile);
				}
				if (ExecutionChoice.equalsIgnoreCase("ActualOnly") || ExecutionChoice.equalsIgnoreCase("ActualAndCompare") ) 
				{
					objDriver.login(inputrow, outputrow);
					wdriver = objDriver.launchBrowser();
					input.UpdateRow(RowIterator, inputrow);
					output.UpdateRow(RowIterator, outputrow);
				}
				
				System.out.println("Executing main script");
				if (ExecutionChoice.equalsIgnoreCase("Comparison") || ExecutionChoice.equalsIgnoreCase("ExpectedOnly")|| ExecutionChoice.equalsIgnoreCase("ActualAndCompare") ) 
				{	
					
					objDriver.generatExpectedResult(inputrow, outputrow);
					output.UpdateRow(RowIterator, outputrow);
				}
				
				if (ExecutionChoice.equalsIgnoreCase("ActualOnly") || ExecutionChoice.equalsIgnoreCase("ActualAndCompare")) 
				{
					objDriver.executeTestScript(inputrow, outputrow);
					output.UpdateRow(RowIterator, outputrow);
				}
				
				if (ExecutionChoice.equalsIgnoreCase("Comparison") || ExecutionChoice.equalsIgnoreCase("ActualAndCompare") ) 
				{
					objDriver.CompareExpectedWithActual(outputrow);
				}
				output.UpdateRow(RowIterator, outputrow);
				stmt.executeUpdate("update " + configFile.getProperty("inputTable")	+ " set Flag_for_execution='Completed' where S_No=" + RowIterator);
				stmt.executeUpdate("update " + configFile.getProperty("outputTable") + " set Result='Completed' where S_No=" + RowIterator);
			} 
			catch (Exception e) 
			{
				System.out.println("Error Message ----------" + e);
				e.printStackTrace();
				String message = e.getMessage().toString().replace("'", "\\'");
				stmt.executeUpdate("update " + configFile.getProperty("inputTable")	+ " set Flag_for_execution='Fail' where S_No=" + RowIterator);
				stmt.executeUpdate("update " + configFile.getProperty("outputTable") + " set Result='Fail' where S_No="	+ RowIterator);
				controllerScript.addExceptionReport(conn, stmt, "Exceptions", inputrow.get("Testdata"), message);
				controllerScript.takeScreenShot(wdriver, exceptionScreenshotPath, inputrow.get("Testdata"));

			}
		}

	}

	@AfterTest
	public void close() throws DatabaseException {
		DatabaseOperation.CloseConn();
		// wdriver.close();
		// wdriver.quit();
	}

	// ========================================================================data
	// provider=========================================================================================
	@DataProvider(name = "UITestData", parallel = true)
	public Object[][] getDataFromDataprovider() throws DatabaseException, PropertiesHandleException {
		input = new DatabaseOperation();
		inputtable = input.GetDataObjects(configFile.getProperty("inputQuery"));
		Iterator<Entry<Integer, LinkedHashMap<String, String>>> inputtableiterator = inputtable.entrySet().iterator();
		output = new DatabaseOperation();
		outputtable = output.GetDataObjects(configFile.getProperty("outputQuery"));
		Iterator<Entry<Integer, LinkedHashMap<String, String>>> outputtableiterator = outputtable.entrySet().iterator();
		//System.out.println("Inside Data Provider");
		int rowIterator = 0;
		Object[][] combined = new Object[inputtable.size()][3];
		while (inputtableiterator.hasNext()) {
			Entry<Integer, LinkedHashMap<String, String>> inputentry = inputtableiterator.next();
			Entry<Integer, LinkedHashMap<String, String>> outputentry = outputtableiterator.next();
			LinkedHashMap<String, String> inputrow = inputentry.getValue();
			LinkedHashMap<String, String> outputrow = outputentry.getValue();
			inputtableobjectMapper = new ObjectMapper();
			outputtableobjectMapper = new ObjectMapper();
			Object inputtablerowobject = inputtableobjectMapper.convertValue(inputrow, Object.class);
			Object outputtablerowobject = outputtableobjectMapper.convertValue(outputrow, Object.class);
			combined[rowIterator][0] = rowIterator + 1;
			combined[rowIterator][1] = inputtablerowobject;
			combined[rowIterator][2] = outputtablerowobject;
			rowIterator++;
		}
		return combined;
	}
}
