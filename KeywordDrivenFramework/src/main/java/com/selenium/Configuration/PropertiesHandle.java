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
	protected String browser;
	protected String AppURL;
	protected String TestSctiptFilePath;
	protected String LoginSheetName;
	protected String TestScriptSheetName;
	protected String inpuTableName;
	protected String outputtableName;
	protected String jdbcDriver;
	protected String dbURL;
	protected String dbusername;
	protected String dbPassword;
	protected String FlagForExecution;
	protected String ScreenshotPath;
	

	static DatabaseOperation ConfigQuery = new DatabaseOperation();
			
	    public PropertiesHandle(String browser,String AppURL,String TestSctiptFilePath,String LoginSheetName,String TestScriptSheetName,String inpuTableName,String outputtableName,String jdbcDriver,String dbURL,String dbusername,String dbPassword,String FlagForExecution,String ScreenshotPath) throws DatabaseException, PropertiesHandleException
		{
			this.browser = browser;
			this.AppURL =AppURL;
			this.TestSctiptFilePath=TestSctiptFilePath;
			this.LoginSheetName=LoginSheetName;
			this.TestScriptSheetName=TestScriptSheetName;
			this.inpuTableName=inpuTableName;
			this.outputtableName=outputtableName;
			this.jdbcDriver=jdbcDriver;
			System.out.println("1---------"+dbURL);
			this.dbURL=dbURL;
			this.dbusername=dbusername;
			this.dbPassword=dbPassword;
			this.FlagForExecution=FlagForExecution;
			this.ScreenshotPath=ScreenshotPath;
			WriteProperty();
			
		}
		
		protected void WriteProperty() throws DatabaseException, PropertiesHandleException
		{
			
			
		   this.browser();
		   this.AppURL();
		   this.TestSctiptFilePath();
		   this.LoginSheetName();
		   this.TestScriptSheetName();
		   this.InputQuery();
		   this.OutputQuery();
		    this.DBdetails();
		    this.FlagForExecution();
		    this.ScreenshotPath();
		 
		}
		
		protected void browser() throws PropertiesHandleException// FUNCTION FOR SAMPLEREQUEST PATH
		{
			this.put("browser", browser);
		}
		
		protected void AppURL() throws PropertiesHandleException// FUNCTION FOR SAMPLEREQUEST PATH
		{
			this.put("EnvURL", AppURL);
		}
		
		protected void TestSctiptFilePath() throws PropertiesHandleException// FUNCTION FOR RESPONSE TO SAVE PATH
		{
			this.put("TestScriptPath", TestSctiptFilePath);
		}
		protected void LoginSheetName() throws PropertiesHandleException// FUNCTION FOR EXPECTED RATING MODEL PATH
		{
			this.put("loginSheetName", LoginSheetName);
		}
		
		protected void TestScriptSheetName() throws PropertiesHandleException// FUNCTION TO GET RESULT SET FROM MACRO MAPPING TABLE 
		{
			this.put("ScriptSheetName", TestScriptSheetName);
		}
		
		protected void FlagForExecution() throws PropertiesHandleException// FUNCTION TO GET RESULT SET FROM MACRO TRNSLATION TABLE 
		{
			this.put("flagForExecution", FlagForExecution);
		}

	
		protected void InputQuery() throws PropertiesHandleException// FUNCTION FOR INPUTQUERY
		{
			this.put("inputQuery",  "SELECT * From "+inpuTableName);//+" where "+ this.RdmsValue("InputTable")+".Flag_for_execution='"+FlagForExecution+"'");
			
		}
		
		protected void OutputQuery() throws PropertiesHandleException// FUNCTION FOR OUTPUTQUERY
		{
			this.put("outputQuery", "SELECT * From "+outputtableName);
		}
		
	
	    protected void DBdetails() throws PropertiesHandleException// FUNCTION FOR DB-DETAILS
		{
			this.put("jdbc_driver",jdbcDriver);
			System.out.println("----"+dbURL);
			this.put("db_url",dbURL);
			this.put("db_username",dbusername);
			this.put("db_password",dbPassword);
		}	
		
	    
	    protected void ScreenshotPath() throws PropertiesHandleException
	    {
	    	this.put("ScreenShotPath",ScreenshotPath );
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