package CvstarrSmoke;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import SupportingClasses.TheEventListener;
import SupportingClasses.propertiesHandle;
import SupportingClasses.ConditionsChecking;
import SupportingClasses.UIoperartions;
import SupportingClasses.ExcelOperationsJXL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
	
	
public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException, InterruptedException
{
	    event=new TheEventListener();
	    File jarFile = new File(DriverScript.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	    File FolderFile = jarFile.getParentFile();
		propertiesHandle configFile = new propertiesHandle(FolderFile + "\\BAD_Config.properties");
		configFile.setProperty("driver_path", FolderFile +"\\Drivers\\");
		configFile.setProperty("Test_script_path",FolderFile +"\\");
		configFile.setProperty("FileName",FolderFile +"\\Output.txt");
		System.setProperty("jsse.enableSNIExtension", "false");	
		DriverScript objDriver=new DriverScript(configFile);
		objDriver.launchBrowser();
		try{
			
			objDriver.Filecreate();
			objDriver.executeTestScript();
			   
		   }
		  catch(TimeoutException e)
			{
			 	e.printStackTrace();
			}
		//objDriver.closeBrowser();
}
	
	
	
	//================default constructor for driver script================================================================================
	
	public DriverScript()
	{
		
	}
	
//===========constructor to initialize objects======================================================================================================================
public DriverScript(propertiesHandle configFile) throws SQLException, ClassNotFoundException
{
	this.configFile = configFile;
	objectUIoperations=new UIoperartions();
	objectconditions=new ConditionsChecking();

	objectTestScript = new ExcelOperationsJXL(this.configFile.getProperty("Test_script_path")+this.configFile.getProperty("File_name"));
	objectTestScript.getsheets(this.configFile.getProperty("ScriptSheetName"));
	
}

//====================================Function to launch browser====================================================================================================
public void launchBrowser()
{
	    String browser = configFile.getProperty("browser");
		String url = configFile.getProperty("url");
		System.out.println(url);
		
		objectUIoperations.launch_browser(browser,url,configFile);
			
}

//==============================================Function to login===================================================================================================
  protected void login() throws SQLException, IOException, InterruptedException
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
				String value = objectLoginScript.read_data(objectLoginScript.get_rownumber(),6);
				String  waitingTime=objectLoginScript.read_data(objectLoginScript.get_rownumber(),10);
				String Outputname = objectLoginScript.read_data(objectLoginScript.get_rownumber(),5);
				objectUIoperations.perform(PropertyString,actionKeyword,ObjectType,value,waitingTime,Outputname,this.configFile.getProperty("FileName"));
				
			}
			objectLoginScript.next_row();
		}	  
  }
 //=============================================Function to run the test script========================================================================================  
protected void executeTestScript() throws SQLException, IOException, InterruptedException
{
	objectTestScript.set_rownumber(1);
	while(objectTestScript.has_next_row())
	{
		if(objectTestScript.read_data(objectTestScript.get_rownumber(),8).toString().equals("enabled"))
		{	
			     System.out.println("success1");
				//String fieldName = objectTestScript.read_data(objectTestScript.get_rownumber(),1);
				String actionKeyword = objectTestScript.read_data(objectTestScript.get_rownumber(),2);
				String ObjectType = objectTestScript.read_data(objectTestScript.get_rownumber(),3);
				String PropertyString= objectTestScript.read_data(objectTestScript.get_rownumber(),4);
				String value = objectTestScript.read_data(objectTestScript.get_rownumber(),6);
				String  waitingTime=objectTestScript.read_data(objectTestScript.get_rownumber(),10);
				String Outputname = objectLoginScript.read_data(objectLoginScript.get_rownumber(),5);
				objectUIoperations.perform(PropertyString,actionKeyword,ObjectType,value,waitingTime,Outputname,this.configFile.getProperty("FileName"));
		}
		objectTestScript.next_row();
	} //end of while 
}
//==================================Function to close the browser========================================================================================================
public void closeBrowser()
{
	objectUIoperations.stop_browser();
}
//============================================file function=========================================================================================================
public void Filecreate() throws IOException
{
	File file = new File(this.configFile.getProperty("FileName"));
	if (!file.exists()) 
	{
		file.createNewFile();
	}
	else
	{
		file.delete();
		file.createNewFile();
	}
}
}
