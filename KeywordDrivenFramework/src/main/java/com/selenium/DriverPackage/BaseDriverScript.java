package com.selenium.DriverPackage;

import com.selenium.Configuration.PropertiesHandle;
import com.selenium.SupportingClasses.ConditionsChecking;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.SupportingClasses.ExcelOperationsJXL;
import com.selenium.SupportingClasses.TheEventListener;
import com.selenium.SupportingClasses.UIoperartions;
import com.selenium.exception.DatabaseException;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
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
	protected ArrayList<String> errorParentname = new ArrayList<String>();
	protected ArrayList<String> errorMessage=new ArrayList<String>();
	protected ConditionsChecking Conditonchecking = null;

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
public LinkedHashMap<String, String> CompareFunction(LinkedHashMap<String, String> outputrow,LinkedHashMap<String, String> comparisonrow)  
{		
    try
    {
    	Conditonchecking = new ConditionsChecking();
    	System.out.println("coming to Before CompareFunction");
    	if(comparisonrow.get("Comaparision_Flag").equalsIgnoreCase("Y"))
		{
	    	System.out.println("coming to CompareFunction");
			String ExpectedColumn = comparisonrow.get("ExpectedColumn");
			String ActualColumn = comparisonrow.get("OutputColumn");
			String StatusColumn = comparisonrow.get("StatusColumn");
			if(!(StatusColumn.equals("")) && !(ExpectedColumn.equals("")))
			{
				System.out.println(ExpectedColumn+"---------------"+ActualColumn);
				System.out.println(outputrow.get(ExpectedColumn)+"--------------"+outputrow.get(ActualColumn));
				if(premium_comp(outputrow.get(ExpectedColumn),outputrow.get(ActualColumn)))
				{
					System.out.println("coming to PASS");
					outputrow.put(StatusColumn, "Pass");
				}
				else
				{
					System.out.println("coming to FAIL");
					outputrow.put(StatusColumn, "Fail");
					//outputrow.UpdateRow();
					analyse(comparisonrow,outputrow);
				}
			}
		}	    
				 			
		String message = "";
		for(int i=0;i<errorMessage.size();i++)
		{
			message=message+errorMessage.get(i)+"; ";
		}
		outputrow.put("AnalyserResult", message);
		errorMessage.clear();
		errorParentname.clear();
		return outputrow;

    }	
    catch(DatabaseException e)
    {
    	System.out.println(e);
    }
	return outputrow;
}

//======================================PRIVATE FUNCTION FOR SUPPORTING COMPARISON FUNCTION=======================================	
protected static boolean premium_comp(String expected,String actual)
{
	
	boolean status = false;
	if(actual == null||actual.equals(""))
	{
		if((expected == null || expected.equals("")||expected.equals("0") || expected.equals("0.0")))
		{
			status = true;
		}
	}
	if(expected == null||expected.equals(""))
	{
		if(actual == null|| actual.equals("")||actual.equals("0") || actual.equals("0.0"))
		{
			status = true;
		}
	}
	if(actual!=null && expected!=null)
	{
		expected = expected.replaceAll("\\[\"", "");
		actual = actual.replaceAll("\\[\"", "");	
		expected = expected.replaceAll("\"\\]", "");
		actual = actual.replaceAll("\"\\]", "");
		expected = expected.replaceAll("\\.[0-9]*", "");
		actual = actual.replaceAll("\\.[0-9]*", "");
		actual=actual.replace("$","");
		actual=actual.replace(",", "");
		if(expected.equals(actual))
		{
			System.out.println(expected+"---------------------------------"+actual);
			status = true;
		}
	}

	return status;	
	
}

protected void analyse(LinkedHashMap<String, String> Conditiontablerow,LinkedHashMap<String, String> outputrow ) throws DatabaseException 
{		
	boolean flag = false;
	
	if(outputrow.get(Conditiontablerow.get("StatusColumn")).equals("Pass"))
	{		

	}

	else if(outputrow.get(Conditiontablerow.get("StatusColumn")).equals("Fail"))
	{	
		String[] Parentname =Conditiontablerow.get("ParentName").split(";");
		int noOfParentname=Parentname.length;
		for(int i=0;i<noOfParentname;i++)
		{								
			if(!this.ifexist(Conditiontablerow.get("NodeName")))
			{
				errorParentname.add(Parentname[i]);
				if(flag == false)
				{
					errorMessage.add(Conditiontablerow.get("Message"));
					flag = true;
				}
			}
		}					
	}

}

protected boolean ifexist (String NodeName)
{
	boolean exist = false;
	int arraylength =errorParentname.size();
	for(int i = 0; i<arraylength;i++)
	{
		String existParentName =errorParentname.get(i);
		if(existParentName.equals(NodeName))
		{
			exist = true;
			break;
		}
	}
	return exist;	

}

//============================================Function to close the browser===============================================================================

public void closeBrowser()
{
	this.stop_browser();
}

}
