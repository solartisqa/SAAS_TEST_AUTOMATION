package com.selenium.DriverPackage;

import com.selenium.Configuration.PropertiesHandle;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.SupportingClasses.ExcelOperationsJXL;
import com.selenium.SupportingClasses.TheEventListener;
import com.selenium.SupportingClasses.UIoperartions;
import com.selenium.exception.DatabaseException;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

public class BaseDriverScript extends UIoperartions implements UIScriptsInterface
{
//***************************global objects and variables****************************************	
	protected String dbColumnNmae=null;
	protected ExcelOperationsJXL objectTestScript=null;
	protected ExcelOperationsJXL objectLoginScript=null;
	protected ExcelOperationsJXL objectComparisonScript=null;
	protected PropertiesHandle configFile;
	protected static TheEventListener event;

	public static DatabaseOperation TestScript;
//==========================================================================================================================================================
	
	public BaseDriverScript()
	{
		
	}
	
//===========constructor to initialize objects======================================================================================================================
public BaseDriverScript(PropertiesHandle configFile) throws SQLException, ClassNotFoundException
{
	this.configFile = configFile;
	event=new TheEventListener();
	
}
//====================================Function to launch browser====================================================================================================
public WebDriver launchBrowser() throws MalformedURLException
{
	    String browser = configFile.getProperty("browser");
		return this.launch_browser(browser,configFile);
			
}
//================================================================================================================================================================= 

public void executeTestScript(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException, AWTException, DatabaseException
{
	TestScript=new DatabaseOperation();
	TestScript.getDataobjects(configFile.getProperty("TestScript"));
	do
	{
		String conditions=TestScript.readData("Flowcondition");
		if(TestScript.readData("Status").equals("enabled")&& this.ConditionReading(conditions, InputData))
		{	
			 
				String actionKeyword = TestScript.readData("Keyword");
				String ObjectType = TestScript.readData("Locator");
				String PropertyString= TestScript.readData("Property");
				String dbcolumnNmae = TestScript.readData("DbColumnName");
				String value = TestScript.readData("DefaultInputvalue");
				String dataProvidingFlag=TestScript.readData("DataFlag");
				String  waitingTime=TestScript.readData("WaitTime");
				
				this.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,InputData,outputData,waitingTime);
		}
	}
	while(TestScript.moveForward());
}
//==================================Function to compare  the results========================================================================================================
/*public void comparisonScript(DatabaseOperation objectInput,DatabaseOperation objectOutput) throws SQLException
{
	objectComparisonScript.set_rownumber(1);
	    while(objectComparisonScript.has_next_row())
		{
	    	String conditions=objectComparisonScript.read_data(objectComparisonScript.get_rownumber(),4);
			if(objectComparisonScript.read_data(objectComparisonScript.get_rownumber(),3).toString().equals("Y")&& this.ConditionReading(conditions, objectInput))
			{
				String expectedcolumn = objectComparisonScript.read_data(objectComparisonScript.get_rownumber(),0);
				String actualColumn = objectComparisonScript.read_data(objectComparisonScript.get_rownumber(),1);
				String StatusColumn = objectComparisonScript.read_data(objectComparisonScript.get_rownumber(),2);
				String expectedValue = (objectOutput.read_data(expectedcolumn)).replace("$","").replace(",","");
				String actualValue = (objectOutput.read_data(actualColumn)).replace("$","").replace(",","");
				
				if(expectedValue.equals(actualValue))
		        {
					objectOutput.write_data(StatusColumn,"Pass");
		        }
		        else
		        {
		        	objectOutput.write_data(StatusColumn, "Fail");
		        }
			}
			objectComparisonScript.next_row();
		}	
 }*/

//============================================Function to close the browser===============================================================================

public void closeBrowser()
{
	this.stop_browser();
}

}
