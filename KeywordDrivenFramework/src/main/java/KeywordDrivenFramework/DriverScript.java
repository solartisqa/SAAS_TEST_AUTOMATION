package KeywordDrivenFramework;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import SupportingClasses.TheEventListener;
import SupportingClasses.propertiesHandle;
import SupportingClasses.ConditionsChecking;
import SupportingClasses.UIoperartions;
import SupportingClasses.databaseOperartions;
import SupportingClasses.ExcelOperationsJXL;

import java.io.IOException;
import java.sql.SQLException;

public class DriverScript 
{
	//***************************global objects and variables****************************************	
	protected String dbColumnNmae=null;
	protected UIoperartions objectUIoperations=null;
	protected ExcelOperationsJXL objectTestScript=null;
	protected ExcelOperationsJXL objectLoginScript=null;
	protected propertiesHandle configFile;
	protected ConditionsChecking objectconditions=null;
	protected static TheEventListener event;
	
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException
	{
		databaseOperartions objectInput = new databaseOperartions();
		databaseOperartions objectOutput = new databaseOperartions();
		event=new TheEventListener();
		propertiesHandle configFile = new propertiesHandle("A:/1 Projects/14 CVSTARR/BAD/config/BAD_Config_C1131.properties");
		databaseOperartions.conn_setup(configFile);
		System.setProperty("jsse.enableSNIExtension", "false");	
		DriverScript objDriver=new DriverScript(configFile);
		objDriver.launchBrowser();
		boolean loginStatus=true;
		objectInput.get_dataobjects(configFile.getProperty("input_query"));
		objectOutput.get_dataobjects(configFile.getProperty("output_query"));
		do
		{
		  try{
			  if(loginStatus)
			   {
				 objDriver.login(objectInput, objectOutput);
				 loginStatus=false;
			   
			   }
			 String testdata=objectInput.read_data("test_case_id");
			 System.out.println(testdata);
			  event.testData(testdata);
			  if(objectInput.read_data("flag_for_execution").equals(configFile.getProperty("flagForExecution")))
				{  
				   objDriver.executeTestScript(objectInput, objectOutput);
				   objectInput.write_data("Flag_for_execution", objectInput.read_data("Flag_for_execution")+"Completed");
				   objectOutput.write_data("Flag_for_execution", "Completed");
			    }
			   
		    }
		  catch(TimeoutException e)
			{
			 	e.printStackTrace();
				objectInput.write_data("Flag_for_execution",  objectInput.read_data("Flag_for_execution")+"Error");
				objectOutput.write_data("Flag_for_execution", "Error");	
				loginStatus=true;
			}
		  objectInput.update_row();
		  objectOutput.update_row();
		  
		}while(objectInput.move_forward() && objectOutput.move_forward());
		databaseOperartions.close_conn();
		objDriver.closeBrowser();
}
	
	//================================================================================================
	
	public DriverScript()
	{
		
	}
	
//===========constructor to initialize objects======================================================================================================================
public DriverScript(propertiesHandle configFile) throws SQLException, ClassNotFoundException
{
	this.configFile = configFile;
	objectUIoperations=new UIoperartions();
	objectconditions=new ConditionsChecking();
	
	objectLoginScript = new ExcelOperationsJXL(this.configFile.getProperty("Test_script_path")+this.configFile.getProperty("File_name"));
	objectLoginScript.getsheets(this.configFile.getProperty("Login"));
	

	objectTestScript = new ExcelOperationsJXL(this.configFile.getProperty("Test_script_path")+this.configFile.getProperty("File_name"));
	objectTestScript.getsheets(this.configFile.getProperty("ScriptSheetName"));
	
}

//====================================Function to launch browser====================================================================================================
public void launchBrowser()
{
	    String browser = configFile.getProperty("browser");
		//String url = configFile.getProperty("url");
		//System.out.println(url);
		
		objectUIoperations.launch_browser(browser,configFile);
			
}

//==============================================Function to login===================================================================================================
  protected void login(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException
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
				objectUIoperations.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,objectInput,objectOutput,waitingTime);
				
			}
			objectLoginScript.next_row();
		}	  
  }
 //=============================================Function to run the test script========================================================================================  
protected void executeTestScript(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException
{
	objectTestScript.set_rownumber(1);
	while(objectTestScript.has_next_row())
	{
		String conditions=objectTestScript.read_data(objectTestScript.get_rownumber(),7);
		if(objectTestScript.read_data(objectTestScript.get_rownumber(),8).toString().equals("enabled")&& objectconditions.condition_reading(conditions, objectInput))
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
				objectUIoperations.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,objectInput,objectOutput,waitingTime);
		}
		objectTestScript.next_row();
	} //end of while 
}
//==================================Function to close the browser========================================================================================================
public void closeBrowser()
{
	objectUIoperations.stop_browser();
}
}
