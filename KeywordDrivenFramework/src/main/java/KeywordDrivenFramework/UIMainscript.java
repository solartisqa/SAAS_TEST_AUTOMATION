package KeywordDrivenFramework;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.TimeoutException;
import DriverPackages.*;
//import SupportingClasses.TheEventListener;
import SupportingClasses.databaseOperartions;
import SupportingClasses.propertiesHandle;


public class UIMainscript
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException
    {
    	databaseOperartions objectInput = new databaseOperartions();
		databaseOperartions objectOutput = new databaseOperartions();
		
		propertiesHandle configFile = new propertiesHandle("A:/1 Projects/20 CHIC_UI/Release1/Configuration/Config_C1128.properties");
		databaseOperartions.conn_setup(configFile);
		System.setProperty("jsse.enableSNIExtension", "false");	
		BaseDriverScript objDriver=new BaseDriverScript(configFile);
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
			 String testdata=objectInput.read_data("Test_data_id");
			 System.out.println(testdata);
			 if(objectInput.read_data("flag_for_execution").equals(configFile.getProperty("flagForExecution")))
				{  
				  objDriver.executeTestScript(objectInput, objectOutput);
				  
				   //objDriver.comparisonScript(objectInput, objectOutput);
				   objectInput.write_data("Flag_for_execution", objectInput.read_data("Flag_for_execution")+"Completed");
				   objectOutput.write_data("Flag_for_execution", "Completed");
			   }		   
	      }
		 catch(Exception e)
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
		//objDriver.closeBrowser();
    }
}
