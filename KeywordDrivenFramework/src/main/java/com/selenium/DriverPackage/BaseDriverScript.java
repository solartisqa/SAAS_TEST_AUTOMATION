package com.selenium.DriverPackage;

import com.selenium.Configuration.PropertiesHandle;
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
		
//==========================================================================================================================================================
	
	public BaseDriverScript()
	{
		
	}
	
//===========constructor to initialize objects======================================================================================================================
public BaseDriverScript(PropertiesHandle configFile) throws SQLException, ClassNotFoundException
{
	this.configFile = configFile;
	event=new TheEventListener();
	objectLoginScript = new ExcelOperationsJXL(this.configFile.getProperty("TestScriptPath"));
	objectLoginScript.getsheets(this.configFile.getProperty("loginSheetName"));
	objectTestScript = new ExcelOperationsJXL(this.configFile.getProperty("TestScriptPath"));
	objectTestScript.getsheets(this.configFile.getProperty("ScriptSheetName"));
	//objectComparisonScript = new ExcelOperationsJXL(this.configFile.getProperty("Test_script_path")+this.configFile.getProperty("ScriptFileName"));
	//objectComparisonScript.getsheets(this.configFile.getProperty("ComparisonSheetName"));
	
}
//====================================Function to launch browser====================================================================================================
public WebDriver launchBrowser() throws MalformedURLException
{
	    String browser = configFile.getProperty("browser");
		return this.launch_browser(browser);
			
}
//==============================================Function to login===================================================================================================
  public void login(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException, AWTException
  {
	  objectLoginScript.set_rownumber(1);
	  while(objectLoginScript.has_next_row())
		{
			if(objectLoginScript.read_data(objectLoginScript.get_rownumber(),8).toString().equals("enabled"))
			{
				//String fieldName = objectTestScript.read_data(objectTestScript.get_rownumber(),1);
				String actionKeyword = objectLoginScript.read_data(objectLoginScript.get_rownumber(),2);
				String ObjectType = objectLoginScript.read_data(objectLoginScript.get_rownumber(),3);
				String PropertyString= objectLoginScript.read_data(objectLoginScript.get_rownumber(),4);
				String dbcolumnNmae = objectLoginScript.read_data(objectLoginScript.get_rownumber(),5);
				String value = objectLoginScript.read_data(objectLoginScript.get_rownumber(),6);
				String dataProvidingFlag=objectLoginScript.read_data(objectLoginScript.get_rownumber(),9);
				String  waitingTime=objectLoginScript.read_data(objectLoginScript.get_rownumber(),10);
				//System.out.println(fieldName);
				this.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,InputData,outputData,waitingTime);
				
			}
			objectLoginScript.next_row();
		}	  
  }
 //=============================================Function to run the test script========================================================================================  
public void executeTestScript(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException, AWTException, DatabaseException
{
	objectTestScript.set_rownumber(1);
	while(objectTestScript.has_next_row())
	{
		String conditions=objectTestScript.read_data(objectTestScript.get_rownumber(),7);
		if(objectTestScript.read_data(objectTestScript.get_rownumber(),8).toString().equals("enabled")&& this.ConditionReading(conditions, InputData))
		{	
			   //System.out.println("condition true for "+objectTestScript.read_data(objectTestScript.get_rownumber(),1));
				//String pageName = objectTestScript.read_data(objectTestScript.get_rownumber(),0);
				//String fieldName = objectTestScript.read_data(objectTestScript.get_rownumber(),1);
				String actionKeyword = objectTestScript.read_data(objectTestScript.get_rownumber(),2);
				String ObjectType = objectTestScript.read_data(objectTestScript.get_rownumber(),3);
				String PropertyString= objectTestScript.read_data(objectTestScript.get_rownumber(),4);
				String dbcolumnNmae = objectTestScript.read_data(objectTestScript.get_rownumber(),5);
				String value = objectTestScript.read_data(objectTestScript.get_rownumber(),6);
			    //String condtions1=objectTestScript.read_data(objectTestScript.get_rownumber(),7);
				String dataProvidingFlag=objectTestScript.read_data(objectTestScript.get_rownumber(),9);
				String  waitingTime=objectTestScript.read_data(objectTestScript.get_rownumber(),10);
				//System.out.println(fieldName);
				this.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,InputData,outputData,waitingTime);
		}
		objectTestScript.next_row();
	} //end of while 
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
