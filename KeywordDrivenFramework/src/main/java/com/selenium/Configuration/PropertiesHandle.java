package com.selenium.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
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
	protected String remoteIP;
	protected String Port;
	protected String ResultsChoice;
	protected String RMConfigtable;
	protected String lookuptable;
	protected String RMPath;
	protected String RMResultsPath;
	protected String MacroClassName;
	protected String Comparisontable;
	protected String queryresult;
	protected String Project;
	protected String Flow;
	protected String Env;
	protected String JDBC_DRIVER;
	protected String DB_URL;
	protected String USER;
	protected String password;
	protected String priority;
	protected String ResultChoice;
	protected String userlogin;
	protected String Api;
	static DatabaseOperation ConfigQuery = new DatabaseOperation();

	public PropertiesHandle(String Project, String Flow, String Env, String FlagForExecution, String JDBC_DRIVER,
			String DB_URL, String USER, String password, String browser, String ResultChoice, String remoteIP,
			String Port, String userlogin,String Api) throws DatabaseException, PropertiesHandleException, SQLException {
		this.Project = Project;
		this.Flow = Flow;
		this.Env = Env;
		this.FlagForExecution = FlagForExecution;
		this.JDBC_DRIVER = JDBC_DRIVER;
		this.DB_URL = DB_URL;
		this.USER = USER;
		this.password = password;
		this.browser = browser;
		this.ResultChoice = ResultChoice;
		this.remoteIP = remoteIP;
		this.Port = Port;
		this.userlogin = userlogin;
		this.Api = Api;
		WriteProperty();
	}

	protected void WriteProperty() throws DatabaseException, PropertiesHandleException, SQLException {
		DatabaseOperation.ConnectionSetup(JDBC_DRIVER, DB_URL, USER, password);
		this.put("browser", browser);
		this.put("EnvURL", this.RdbmsValue("URL"));
		this.put("TestScriptPath", this.RdbmsValue("RootFolder") + this.RdbmsValue("ProjectName") + "/"
				+ this.RdbmsValue("FlowName") + "/Script/" + this.RdbmsValue("FileName"));
		this.put("loginSheetName", this.RdbmsValue("LoginSheetName"));
		this.put("ScriptSheetName", this.RdbmsValue("ScriptSheetName"));
		this.put("flagForExecution", FlagForExecution);
		this.put("inputQuery", this.RdbmsQuery("InputTable"));
		this.put("outputQuery", this.RdbmsQuery("OutputTable"));
		this.put("jdbc_driver", this.RdbmsValue("JDCDriver"));
		this.put("db_url", this.RdbmsValue("DB_URL") + this.RdbmsValue("ProjectDBName"));
		this.put("db_username", this.RdbmsValue("DB_UserName"));
		this.put("db_password", this.RdbmsValue("DB_Password"));
		this.put("ScreenShotPath", this.RdbmsValue("RootFolder") + this.RdbmsValue("ProjectName") + "/"
				+ this.RdbmsValue("FlowName") + "/ScreenShots/");
		this.put("server", remoteIP + ":" + Port);
		this.put("ResultsChoice", ResultChoice);
		this.put("RMconfig_query", this.RdbmsQuery("MacroMappingTable"));
		this.put("lookup_query", this.RdbmsQuery("MacroTranslationTable"));
		this.put("RatingModelPath", this.RdbmsValue("RootFolder") + this.RdbmsValue("ProjectName") + "/"
				+ this.RdbmsValue("FlowName") + "/SampleRatingModel/");
		this.put("ExpectedRMPath", this.RdbmsValue("RootFolder") + this.RdbmsValue("ProjectName") + "/"
				+ this.RdbmsValue("FlowName") + "/RatingModelResults/");
		this.put("MacroClassName", this.RdbmsValue("MacroClassName"));
		this.put("comparisonTableQuery", this.RdbmsQuery("ComaparisonTableName"));
		this.put("inputTable", this.RdbmsValue("InputTable"));
		this.put("outputTable", this.RdbmsValue("OutputTable"));
		this.put("AppUserName", this.RdbmsValue("AppUserName"));
		this.put("AppPassword", this.RdbmsValue("AppPassword"));
		
		this.put("InputColQuery",this.APIRdmsQuery("InputConditonTable"));
		this.put("OutputColQuery",this.APIRdmsQuery("OutputConditionTable"));
		this.put("ClassName", this.APIRdmsValue("ClassName"));
		this.put("AuthenticationToken", this.APIRdmsValue("AuthenticationToken"));
		this.put("content_type", "application/"+this.APIRdmsValue("ServiceType"));
		this.put("EventName", this.APIRdmsValue("EventName"));
	    this.put("EventVersion", this.APIRdmsValue("EventVersion"));
	    this.put("test_url", this.APIRdmsValue("URL"));
	    this.put("Execution_Flag",ResultChoice);
	    this.put("request_response_Location", this.RdbmsValue("RootFolder") + this.RdbmsValue("ProjectName") + "/"
				+ this.RdbmsValue("FlowName") + "/");
	    this.put("APIName", Api);
		this.put("InputJsonPath", "InputJsonPath");
	    this.put("OutputJsonPath", "OutputJsonPath");
		this.put("InputColumn", "InputColumn");
		this.put("OutputColumn", "OutputColumn");
		this.put("InputCondColumn", "InputColumnCondtn");
		this.put("OutputCondColumn", "OutputColumnCondtn");
		this.put("ExpectedColumn", "ExpectedColumn");
		this.put("StatusColumn", "StatusColumn");
		DatabaseOperation.CloseConn();
	}

	protected String RdbmsQuery(String OutputColoumn) throws PropertiesHandleException {
		try {
			ConfigQuery.switchDB("SeleniumConfig");
			LinkedHashMap<Integer, LinkedHashMap<String, String>> tableRdbmsQuery = ConfigQuery.GetDataObjects(
					"SELECT ComaparisonTableName,MacroClassName,MacroMappingTable,MacroTranslationTable,ProjectName,FlowName,ProjectDBName,RootFolder,FileName,ScriptSheetName,LoginSheetName,InputTable,OutputTable,UserDBName,JDCDriver,DB_URL,DB_UserName,DB_Password,Env_Name,URL,AppUserName,AppPassword FROM Project_CONFIG INNER JOIN UserFolder_CONFIG INNER JOIN Flow_CONFIG ON Project_CONFIG.ProjectID = Flow_CONFIG.ProjectID INNER JOIN Environment_CONFIG ON Project_CONFIG.ProjectID = Environment_CONFIG.ProjectID INNER JOIN Version_CONFIG ON Flow_CONFIG.FlowID = Version_CONFIG.FlowID INNER JOIN VersionDetail_CONFIG ON (VersionDetail_CONFIG.Verision = Version_CONFIG.Version and VersionDetail_CONFIG.FlowID = Flow_CONFIG.FlowID)WHERE Project_CONFIG.ProjectName ='"
							+ Project + "' AND Flow_CONFIG.FlowName = '" + Flow
							+ "' AND Environment_CONFIG.Env_Name = '" + Env + "' AND UserFolder_CONFIG.User_ID = '"
							+ userlogin + "'  ORDER BY Version_CONFIG.Version DESC LIMIT 1");
			for (Entry<Integer, LinkedHashMap<String, String>> entry : tableRdbmsQuery.entrySet()) {
				LinkedHashMap<String, String> rowRdbmsQuery = entry.getValue();
				queryresult = rowRdbmsQuery.get(OutputColoumn);
			}
			return "SELECT * FROM " + queryresult;
		} catch (DatabaseException e) {
			throw new PropertiesHandleException("ERROR IN SQL - QUERY -- " + OutputColoumn, e);
		}
	}
	
	protected String APIRdmsQuery(String OutputColoumn) throws PropertiesHandleException, SQLException
	{
		try
		{
			ConfigQuery.switchDB("Starr_Config_Development");
			LinkedHashMap<Integer, LinkedHashMap<String, String>> tableRdmsQuery =  ConfigQuery.GetDataObjects("SELECT UserFolder_CONFIG.RootFolder,UserFolder_CONFIG.JDCDriver,UserFolder_CONFIG.DB_URL,UserFolder_CONFIG.DB_UserName,UserFolder_CONFIG.DB_Password,UserFolder_CONFIG.UserDBName,Version_CONFIG.Version,Project_CONFIG.ProjectDBName,Project_CONFIG.ServiceType,Environment_CONFIG.URL,Project_CONFIG.Token,VersionDetail_CONFIG.EventName,VersionDetail_CONFIG.EventVersion,API_CONFIG.OutputInInputTable,VersionDetail_CONFIG.ClassName,VersionDetail_CONFIG.InputConditonTable,VersionDetail_CONFIG.InputTable,VersionDetail_CONFIG.OutputConditionTable,VersionDetail_CONFIG.OutputTable,VersionDetail_CONFIG.MacroMappingTable,VersionDetail_CONFIG.MacroTranslationTable FROM Project_CONFIG INNER JOIN UserFolder_CONFIG INNER JOIN API_CONFIG ON Project_CONFIG.ProjectID = API_CONFIG.ProjectID INNER JOIN Environment_CONFIG ON API_CONFIG.APIID = Environment_CONFIG.APIID INNER JOIN Version_CONFIG ON Environment_CONFIG.Env_ID = Version_CONFIG.Env_ID INNER JOIN VersionDetail_CONFIG ON (VersionDetail_CONFIG.Verision = Version_CONFIG.Version and VersionDetail_CONFIG.APIID = API_CONFIG.APIID)  WHERE Project_CONFIG.ProjectName ='" + Project +"' AND API_CONFIG.APIName = '" + Api + "' AND Environment_CONFIG.Env_Name = '" + Env + "' AND UserFolder_CONFIG.User_ID = '" + userlogin + "' ORDER BY Version_CONFIG.Version DESC LIMIT 1");
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

	protected String RdbmsValue(String OutputColoumn) throws PropertiesHandleException {
		try {
			ConfigQuery.switchDB("SeleniumConfig");
			LinkedHashMap<Integer, LinkedHashMap<String, String>> tableRdbmsValue = ConfigQuery.GetDataObjects(
					"SELECT ComaparisonTableName,MacroClassName,MacroMappingTable,MacroTranslationTable,ProjectName,FlowName,ProjectDBName,RootFolder,FileName,ScriptSheetName,LoginSheetName,InputTable,OutputTable,UserDBName,JDCDriver,DB_URL,DB_UserName,DB_Password,Env_Name,URL,AppUserName,AppPassword FROM Project_CONFIG INNER JOIN UserFolder_CONFIG INNER JOIN Flow_CONFIG ON Project_CONFIG.ProjectID = Flow_CONFIG.ProjectID INNER JOIN Environment_CONFIG ON Project_CONFIG.ProjectID = Environment_CONFIG.ProjectID INNER JOIN Version_CONFIG ON Flow_CONFIG.FlowID = Version_CONFIG.FlowID INNER JOIN VersionDetail_CONFIG ON (VersionDetail_CONFIG.Verision = Version_CONFIG.Version and VersionDetail_CONFIG.FlowID = Flow_CONFIG.FlowID)WHERE Project_CONFIG.ProjectName ='"
							+ Project + "' AND Flow_CONFIG.FlowName = '" + Flow
							+ "' AND Environment_CONFIG.Env_Name = '" + Env + "' AND UserFolder_CONFIG.User_ID = '"
							+ userlogin + "' ORDER BY Version_CONFIG.Version DESC LIMIT 1");
			for (Entry<Integer, LinkedHashMap<String, String>> entry : tableRdbmsValue.entrySet()) {
				LinkedHashMap<String, String> rowRdbmsValue = entry.getValue();
				queryresult = rowRdbmsValue.get(OutputColoumn);
			}
			return queryresult;
		} catch (DatabaseException e) {
			throw new PropertiesHandleException("ERROR IN RETRIVING DATA FROM -- " + OutputColoumn, e);
		}
	}
	
	protected String APIRdmsValue(String OutputColoumn) throws PropertiesHandleException, SQLException
	{
		try
		{
			ConfigQuery.switchDB("Starr_Config_Development");
			LinkedHashMap<Integer, LinkedHashMap<String, String>> tableRdmsValue = ConfigQuery.GetDataObjects("SELECT UserFolder_CONFIG.RootFolder,UserFolder_CONFIG.JDCDriver,UserFolder_CONFIG.DB_URL,UserFolder_CONFIG.DB_UserName,UserFolder_CONFIG.DB_Password,UserFolder_CONFIG.UserDBName,Version_CONFIG.Version,Project_CONFIG.ProjectDBName,Project_CONFIG.ServiceType,Environment_CONFIG.URL,Environment_CONFIG.AuthenticationURL,Environment_CONFIG.OwnerID,Environment_CONFIG.Userneme,Environment_CONFIG.Password,Environment_CONFIG.AuthenticationToken,Project_CONFIG.Token,VersionDetail_CONFIG.EventName,VersionDetail_CONFIG.EventVersion,API_CONFIG.OutputInInputTable,VersionDetail_CONFIG.ClassName,VersionDetail_CONFIG.InputConditonTable,VersionDetail_CONFIG.InputTable,VersionDetail_CONFIG.OutputConditionTable,VersionDetail_CONFIG.OutputTable,VersionDetail_CONFIG.MacroMappingTable,VersionDetail_CONFIG.MacroTranslationTable FROM Project_CONFIG INNER JOIN UserFolder_CONFIG INNER JOIN API_CONFIG ON Project_CONFIG.ProjectID = API_CONFIG.ProjectID INNER JOIN Environment_CONFIG ON API_CONFIG.APIID = Environment_CONFIG.APIID INNER JOIN Version_CONFIG ON Environment_CONFIG.Env_ID = Version_CONFIG.Env_ID INNER JOIN VersionDetail_CONFIG ON (VersionDetail_CONFIG.Verision = Version_CONFIG.Version and VersionDetail_CONFIG.APIID = API_CONFIG.APIID)  WHERE Project_CONFIG.ProjectName ='" + Project +"' AND API_CONFIG.APIName = '" + Api + "' AND Environment_CONFIG.Env_Name = '" + Env + "' AND UserFolder_CONFIG.User_ID = '" + userlogin + "' ORDER BY Version_CONFIG.Version DESC LIMIT 1");
			//System.out.println("SELECT UserFolder_CONFIG.RootFolder,UserFolder_CONFIG.JDCDriver,UserFolder_CONFIG.DB_URL,UserFolder_CONFIG.DB_UserName,UserFolder_CONFIG.DB_Password,UserFolder_CONFIG.UserDBName,Version_CONFIG.Version,Project_CONFIG.ProjectDBName,Project_CONFIG.ServiceType,Environment_CONFIG.URL,Environment_CONFIG.AuthenticationURL,Environment_CONFIG.OwnerID,Environment_CONFIG.Userneme,Environment_CONFIG.Password,Project_CONFIG.Token,VersionDetail_CONFIG.EventName,VersionDetail_CONFIG.EventVersion,API_CONFIG.OutputInInputTable,VersionDetail_CONFIG.ClassName,VersionDetail_CONFIG.InputConditonTable,VersionDetail_CONFIG.InputTable,VersionDetail_CONFIG.OutputConditionTable,VersionDetail_CONFIG.OutputTable,VersionDetail_CONFIG.MacroMappingTable,VersionDetail_CONFIG.MacroTranslationTable FROM Project_CONFIG INNER JOIN UserFolder_CONFIG INNER JOIN API_CONFIG ON Project_CONFIG.ProjectID = API_CONFIG.ProjectID INNER JOIN Environment_CONFIG ON API_CONFIG.APIID = Environment_CONFIG.APIID INNER JOIN Version_CONFIG ON Environment_CONFIG.Env_ID = Version_CONFIG.Env_ID INNER JOIN VersionDetail_CONFIG ON (VersionDetail_CONFIG.Verision = Version_CONFIG.Version and VersionDetail_CONFIG.APIID = API_CONFIG.APIID)  WHERE Project_CONFIG.ProjectName ='" + Project +"' AND API_CONFIG.APIName = '" + Api + "' AND Environment_CONFIG.Env_Name = '" + Env + "' AND UserFolder_CONFIG.User_ID = '" + UserName + "' ORDER BY Version_CONFIG.Version DESC LIMIT 1");
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

	public PropertiesHandle(String path) throws PropertiesHandleException {
		this.path = path;

		FileInputStream configuration = null;

		try {
			configuration = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			throw new PropertiesHandleException("CONFIGURATION FILE PATH DOES NOT CONTAINS CONFIG FILE", e);
		}
		try {
			this.load(configuration);
		} catch (IOException e) {
			throw new PropertiesHandleException("ERROR IN LOADING A CONFIG FILE", e);
		}
	}

	public void store(String newpath) throws PropertiesHandleException {
		Writer writer = null;
		try {
			writer = new FileWriter(newpath);
		} catch (IOException e) {
			throw new PropertiesHandleException("ERROR IN WRITING A CONFIG FILE", e);
		}
		try {
			this.store(writer, "File saved");
		} catch (IOException e) {
			throw new PropertiesHandleException("ERROR IN STORING A CONFIG FILE", e);
		}
		;
	}

	public void store() {
		Writer writer = null;
		try {
			writer = new FileWriter(this.path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.store(writer, "File saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

}