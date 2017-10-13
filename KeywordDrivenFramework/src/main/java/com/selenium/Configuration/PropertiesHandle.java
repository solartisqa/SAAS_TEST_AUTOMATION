package com.selenium.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Map.Entry;

import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;

public class PropertiesHandle extends Properties

{
	private static final long serialVersionUID = 1L;
	protected String path = null;
	protected String Project;
	protected String Flow;
	protected String Env;
	protected String FlagForExecution;
	protected String browser;
	protected String JDBC_DRIVER;
	protected String DB_URL;
	protected String USER;
	protected String password;
	protected String priority;
	protected String queryresult;
	protected String ResultChoice;
	

	static DatabaseOperation ConfigQuery = new DatabaseOperation();
			
	    public PropertiesHandle(String Project,String Flow, String Env ,String FlagForExecution, String JDBC_DRIVER, String DB_URL, String USER, String password, String browser,String ResultChoice) throws DatabaseException, PropertiesHandleException
		{
			this.Project = Project;
			this.Flow=Flow;
			this.Env=Env;
			this.FlagForExecution=FlagForExecution;
			this.JDBC_DRIVER=JDBC_DRIVER;
			this.DB_URL=DB_URL;
			this.USER=USER;
			this.password=password;
			this.browser=browser;
			this.ResultChoice=ResultChoice;
		
			WriteProperty();
			
		}
		
		protected void WriteProperty() throws DatabaseException, PropertiesHandleException
		{
			DatabaseOperation.ConnectionSetup(JDBC_DRIVER, DB_URL, USER, password);
						
            if(ResultChoice.equalsIgnoreCase("ActualOnly"))
            {
				 this.ActualAndStatus("Y", "N");    
            }
			if(ResultChoice.equalsIgnoreCase("CompareResults"))
			{
				this.ActualAndStatus("Y", "Y");    
			}
			
		   this.browser();
		   this.driverPath();
		   this.TestScriptPath();
		   this.ScriptFileName();
		   this.loginSheetName();
		   this.ScriptSheetName();
		   this.flagForExecution();
		   this.EnvURL();

		   this.InputQuery();
		   this.OutputQuery();
 		    
		    this.DBdetails();
		    this.ScreenshotPath();
		    DatabaseOperation.CloseConn();
		 
		}
		
		protected String RdmsQuery(String OutputColoumn) throws PropertiesHandleException
		{
			try
			{
				LinkedHashMap<Integer, LinkedHashMap<String, String>> tableRdmsQuery =  ConfigQuery.GetDataObjects("SELECT ProjectName,ProjectDBName, DriverPath,RootFolder,FileName,ScriptSheetName,LoginSheetName,InputTable,OutputTable,UserDBName,JDCDriver,DB_URL,DB_UserName,DB_Password,Env_Name,URL FROM Project_CONFIG INNER JOIN UserFolder_CONFIG INNER JOIN Flow_CONFIG ON Project_CONFIG.ProjectID = Flow_CONFIG.ProjectID INNER JOIN Environment_CONFIG ON Flow_CONFIG.FlowID = Environment_CONFIG.FlowID INNER JOIN Version_CONFIG ON Environment_CONFIG.Env_ID = Version_CONFIG.Env_ID INNER JOIN VersionDetail_CONFIG ON (VersionDetail_CONFIG.Verision = Version_CONFIG.Version and VersionDetail_CONFIG.FlowID = Flow_CONFIG.FlowID)WHERE Project_CONFIG.ProjectName ='" +Project+ "' AND Flow_CONFIG.FlowName = '" +Flow+ "' AND Environment_CONFIG.Env_Name = '" +Env+ "' ORDER BY Version_CONFIG.Version DESC LIMIT 1");
				for (Entry<Integer, LinkedHashMap<String, String>> entry : tableRdmsQuery.entrySet())	
				{
					LinkedHashMap<String, String> rowRdmsQuery = entry.getValue();
					queryresult =  rowRdmsQuery.get(OutputColoumn);
				}
				return "SELECT * FROM " + queryresult;		
			}
			catch(DatabaseException e)
			{
				throw new PropertiesHandleException("ERROR IN SQL - QUERY -- " + OutputColoumn, e);
			}
		}
		
		protected String RdmsValue(String OutputColoumn) throws PropertiesHandleException
		{
			try
			{
				LinkedHashMap<Integer, LinkedHashMap<String, String>> tableRdmsValue = ConfigQuery.GetDataObjects("SELECT ProjectName,ProjectDBName, DriverPath,RootFolder,FileName,ScriptSheetName,LoginSheetName,InputTable,OutputTable,UserDBName,JDCDriver,DB_URL,DB_UserName,DB_Password,Env_Name,URL FROM Project_CONFIG INNER JOIN UserFolder_CONFIG INNER JOIN Flow_CONFIG ON Project_CONFIG.ProjectID = Flow_CONFIG.ProjectID INNER JOIN Environment_CONFIG ON Flow_CONFIG.FlowID = Environment_CONFIG.FlowID INNER JOIN Version_CONFIG ON Environment_CONFIG.Env_ID = Version_CONFIG.Env_ID INNER JOIN VersionDetail_CONFIG ON (VersionDetail_CONFIG.Verision = Version_CONFIG.Version and VersionDetail_CONFIG.FlowID = Flow_CONFIG.FlowID)WHERE Project_CONFIG.ProjectName ='" +Project+ "' AND Flow_CONFIG.FlowName = '" +Flow+ "' AND Environment_CONFIG.Env_Name = '" +Env+ "' ORDER BY Version_CONFIG.Version DESC LIMIT 1");
				for (Entry<Integer, LinkedHashMap<String, String>> entry : tableRdmsValue.entrySet())	
				{
					LinkedHashMap<String, String> rowRdmsValue = entry.getValue();
					queryresult = rowRdmsValue.get(OutputColoumn);
				}
				return queryresult;
			}
			catch(DatabaseException e)
			{
				throw new PropertiesHandleException("ERROR IN RETRIVING DATA FROM -- " + OutputColoumn, e);
			}
		}

	
		protected void ActualAndStatus(String Actual, String Status)// FUNCTION FOR ACTUAL AND STATUS OCCURANCE
		{
			this.put("actual", Actual);
			this.put("comparison", Status);
		}	
		
		protected void browser() throws PropertiesHandleException// FUNCTION FOR SAMPLEREQUEST PATH
		{
			this.put("browser", browser);
		}
		
		protected void driverPath() throws PropertiesHandleException// FUNCTION FOR REQUEST TO SAVE PATH
		{
			this.put("driverPath", this.RdmsValue("DriverPath"));
		}
		
		protected void TestScriptPath() throws PropertiesHandleException// FUNCTION FOR RESPONSE TO SAVE PATH
		{
			this.put("TestScriptPath", this.RdmsValue("RootFolder") + "/" + Project + "/" + Flow + "/Script/");
		}
		
		protected void ScriptFileName() throws PropertiesHandleException// FUNCTION FOR SAMPLE RATING MODEL PATH
		{
			this.put("ScriptFileName", this.RdmsValue("FileName"));
		}
		
		protected void loginSheetName() throws PropertiesHandleException// FUNCTION FOR EXPECTED RATING MODEL PATH
		{
			this.put("loginSheetName", this.RdmsValue("LoginSheetName"));
		}
		
		protected void ScriptSheetName() throws PropertiesHandleException// FUNCTION TO GET RESULT SET FROM MACRO MAPPING TABLE 
		{
			this.put("ScriptSheetName", this.RdmsValue("ScriptSheetName"));
		}
		
		protected void flagForExecution() throws PropertiesHandleException// FUNCTION TO GET RESULT SET FROM MACRO TRNSLATION TABLE 
		{
			this.put("flagForExecution", FlagForExecution);
		}

		protected void EnvURL() throws PropertiesHandleException// FUNCTION TO GET URL
		{
			this.put("EnvURL", this.RdmsValue("URL"));	
		}
	
		protected void InputQuery() throws PropertiesHandleException// FUNCTION FOR INPUTQUERY
		{
			this.put("inputQuery",  this.RdmsQuery("InputTable"));//+" where "+ this.RdmsValue("InputTable")+".Flag_for_execution='"+FlagForExecution+"'");
			
		}
		
		protected void OutputQuery() throws PropertiesHandleException// FUNCTION FOR OUTPUTQUERY
		{
			this.put("outputQuery", this.RdmsQuery("OutputTable"));
		}
		
	
	    protected void DBdetails() throws PropertiesHandleException// FUNCTION FOR DB-DETAILS
		{
			this.put("jdbc_driver", this.RdmsValue("JDCDriver"));
			this.put("db_url", this.RdmsValue("DB_URL") + "/" + this.RdmsValue("ProjectDBName"));
			this.put("db_username", this.RdmsValue("DB_UserName"));
			this.put("db_password", this.RdmsValue("DB_Password"));
		}	
		
	    
	    protected void ScreenshotPath() throws PropertiesHandleException
	    {
	    	this.put("ScreenShotPath", this.RdmsValue("RootFolder") + "/" + Project + "/" + Flow + "/ScreenShots/");
	    }
		public PropertiesHandle(String path) throws PropertiesHandleException
		{
			this.path = path;
			
			FileInputStream configuration = null;
			
			try 
			{
				configuration = new FileInputStream(path);
			} 
			catch (FileNotFoundException e) 
			{
				throw new PropertiesHandleException("CONFIGURATION FILE PATH DOES NOT CONTAINS CONFIG FILE", e);
			}
			try 
			{
				this.load(configuration);
			} 
			catch (IOException e) 
			{
				throw new PropertiesHandleException("ERROR IN LOADING A CONFIG FILE", e);
			}
		}
		
		public void store(String newpath) throws PropertiesHandleException
		{
			Writer writer = null;
			try 
			{
				 writer = new FileWriter(newpath);
			} 
			catch (IOException e) 
			{
				throw new PropertiesHandleException("ERROR IN WRITING A CONFIG FILE", e);
			}
			try 
			{
				this.store(writer, "File saved");
			} 
			catch (IOException e) 
			{
				throw new PropertiesHandleException("ERROR IN STORING A CONFIG FILE", e);
			};
		}
		
		public void store()
		{
			Writer writer = null;
			try 
			{
				 writer = new FileWriter(this.path);
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{
				this.store(writer, "File saved");
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		
		/*public static void main(String args[]) throws DatabaseException, PropertiesHandleException
		{
			System.setProperty("jsse.enableSNIExtension", "false");
			PropertiesHandle configFile = new PropertiesHandle("CHIC","Quote","QA","Y","com.mysql.jdbc.Driver","jdbc:mysql://192.168.35.2:3391/SeleniumConfig","root","password","Chrome","ActualOnly");
			System.out.println(configFile.getProperty("EnvURL"));
		}*/
}