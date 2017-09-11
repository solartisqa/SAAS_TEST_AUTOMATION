package DriverPackages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import SupportingClasses.TheEventListener;
import SupportingClasses.propertiesHandle;
import SupportingClasses.ConditionsChecking;
import SupportingClasses.UIoperartions;
import SupportingClasses.databaseOperartions;
import SupportingClasses.ExcelOperationsJXL;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

public class BaseDriverScript extends UIoperartions implements UIScriptsInterface
{
//***************************global objects and variables****************************************	
	protected String dbColumnNmae=null;
	protected ExcelOperationsJXL objectTestScript=null;
	protected ExcelOperationsJXL objectLoginScript=null;
	protected ExcelOperationsJXL objectComparisonScript=null;
	protected propertiesHandle configFile;
	protected static TheEventListener event;
		
//================================================================================================
	
	public BaseDriverScript()
	{
		
	}
	
//===========constructor to initialize objects======================================================================================================================
public BaseDriverScript(propertiesHandle configFile) throws SQLException, ClassNotFoundException
{
	this.configFile = configFile;
	event=new TheEventListener();
	objectLoginScript = new ExcelOperationsJXL(this.configFile.getProperty("Test_script_path")+this.configFile.getProperty("File_name"));
	objectLoginScript.getsheets(this.configFile.getProperty("Login"));
	objectTestScript = new ExcelOperationsJXL(this.configFile.getProperty("Test_script_path")+this.configFile.getProperty("File_name"));
	objectTestScript.getsheets(this.configFile.getProperty("ScriptSheetName"));
	objectComparisonScript = new ExcelOperationsJXL(this.configFile.getProperty("Test_script_path")+this.configFile.getProperty("File_name"));
	objectComparisonScript.getsheets(this.configFile.getProperty("ComparisonSheetName"));
	
	
}

//====================================Function to launch browser====================================================================================================
public void launchBrowser()
{
	    String browser = configFile.getProperty("browser");
		//String url = configFile.getProperty("url");
		//System.out.println(url);
		
		this.launch_browser(browser,configFile);
			
}

//==============================================Function to login===================================================================================================
  public void login(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException, InterruptedException, AWTException
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
				this.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,objectInput,objectOutput,waitingTime);
				
			}
			objectLoginScript.next_row();
		}	  
  }
 //=============================================Function to run the test script========================================================================================  
public void executeTestScript(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException, InterruptedException, AWTException
{
	objectTestScript.set_rownumber(1);
	while(objectTestScript.has_next_row())
	{
		String conditions=objectTestScript.read_data(objectTestScript.get_rownumber(),7);
		if(objectTestScript.read_data(objectTestScript.get_rownumber(),8).toString().equals("enabled")&& this.condition_reading(conditions, objectInput))
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
				this.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,objectInput,objectOutput,waitingTime);
		}
		objectTestScript.next_row();
	} //end of while 
}
//==================================Function to close the browser========================================================================================================
public void comparisonScript(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException
{
	objectComparisonScript.set_rownumber(1);
	    while(objectComparisonScript.has_next_row())
		{
	    	String conditions=objectComparisonScript.read_data(objectComparisonScript.get_rownumber(),4);
			if(objectComparisonScript.read_data(objectComparisonScript.get_rownumber(),3).toString().equals("Y")&& this.condition_reading(conditions, objectInput))
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
 }


public void closeBrowser()
{
	this.stop_browser();
}
}
