package KeywordDrivenFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.net.UrlChecker;

import SupportingClasses.propertiesHandle;
import SupportingClasses.ConditionsChecking;
import SupportingClasses.UIoperartions;
import SupportingClasses.databaseOperartions;
import SupportingClasses.ExcelOperationsJXL;
import SupportingClasses.browserLaunching;
import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;

public class StarrassistBenefitsCheck 
{
	//***************************global objects and variables****************************************	
	public static  WebDriver driver=null;
	public static databaseOperartions objectInput;
	public static databaseOperartions objectOutput;
	public static String dbColumnNmae=null;
	public static UIoperartions objectUIoperations=null;
	public static ExcelOperationsJXL objectTestScript=null;
	public static ExcelOperationsJXL objectLoginScript=null;
	public static browserLaunching objectBrowse=null;
	public static propertiesHandle configFile;
	public static ConditionsChecking objectconditions=null;	
	
	public static void main(String args[]) throws Exception	
	{
		objectBrowse=new browserLaunching();
		objectUIoperations=new UIoperartions();
		objectconditions=new ConditionsChecking();
		configFile = new propertiesHandle("A:/1 Projects/13 Starr Assist/PDF Change/Configuration/Config_Automation4.properties");
		databaseOperartions.conn_setup(configFile);
		System.setProperty("jsse.enableSNIExtension", "false");	
		objectInput = new databaseOperartions();
		objectOutput = new databaseOperartions();
		objectInput.get_dataobjects(configFile.getProperty("input_query"));
		objectOutput.get_dataobjects(configFile.getProperty("output_query"));
		Logger log = Logger.getLogger("devpinoyLogger");
		
//********************Login operation************************************************************************************************************* 
		
	    String browser=configFile.getProperty("browser");
		String url=configFile.getProperty("url");
		driver=objectBrowse.launch_browser(browser,url,configFile);
		log.debug("browser launched");
		
		objectLoginScript = new ExcelOperationsJXL(configFile.getProperty("Test_script_path")+configFile.getProperty("File_name"));
		objectLoginScript.getsheets("Login");
		objectLoginScript.set_rownumber(1);
		System.out.println(objectLoginScript.get_sheetname());
			
			while(objectLoginScript.has_next_row())
			{
				if(objectLoginScript.read_data(objectLoginScript.get_rownumber(),8).toString().equals("enabled"))
						{
					String actionKeyword = objectLoginScript.read_data(objectLoginScript.get_rownumber(),2);
					String ObjectType = objectLoginScript.read_data(objectLoginScript.get_rownumber(),3);
					String PropertyString= objectLoginScript.read_data(objectLoginScript.get_rownumber(),4);
					String dbcolumnNmae = objectLoginScript.read_data(objectLoginScript.get_rownumber(),5);
					String value = objectLoginScript.read_data(objectLoginScript.get_rownumber(),6);
					String dataProvidingFlag=objectLoginScript.read_data(objectLoginScript.get_rownumber(),9);
					String  waitingTime=objectLoginScript.read_data(objectLoginScript.get_rownumber(),10);
					objectUIoperations.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,objectInput,objectOutput,driver,waitingTime);
					
						}
				objectLoginScript.next_row();
			}	
	
//************************************************************************************************************************************************
		objectTestScript = new ExcelOperationsJXL(configFile.getProperty("Test_script_path")+configFile.getProperty("File_name"));
		objectTestScript.getsheets("Test_Scripts");
		objectTestScript.set_rownumber(1);
		System.out.println(objectTestScript.get_sheetname());
		
  do
	{
	  objectTestScript.set_rownumber(1);
	  if(objectInput.read_data("flag_for_execution").equals("Y"))
		{  
		
		try
		{
		while(objectTestScript.has_next_row())
		{
			//log.info(testscript.read_data(testscript.get_rownumber(),5).toString());
			String conditions=objectTestScript.read_data(objectTestScript.get_rownumber(),7);
			// boolean blnConditionStatus=objectconditions.condition_reading(conditions, objectInput, objectOutput);
			 //System.out.println(blnConditionStatus);
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
					objectUIoperations.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,objectInput,objectOutput,driver,waitingTime);
			} //end of if 
			objectTestScript.next_row();
		} //end of while
		
		objectInput.write_data("Flag_for_execution", "Completed");
		 objectOutput.write_data("Flag_for_execution", "Completed");
		}
		catch(TimeoutException e)
		{
			objectInput.write_data("Flag_for_execution", "Error");
			objectOutput.write_data("Flag_for_execution", "Error");
			objectBrowse.login(url, configFile.getProperty("userName"), configFile.getProperty("password"));
			
		}
		 objectInput.update_row();
		 objectOutput.update_row();
		} //end of if
	     
	 
	}while(objectInput.move_forward() && objectOutput.move_forward()); //end of do
   databaseOperartions.close_conn(); 	
		
		
	}
}
