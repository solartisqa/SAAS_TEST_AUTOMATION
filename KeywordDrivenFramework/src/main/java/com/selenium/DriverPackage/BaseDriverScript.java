package com.selenium.DriverPackage;

import com.selenium.Configuration.PropertiesHandle;
import com.selenium.SupportingClasses.ConditionsChecking;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.SupportingClasses.ExcelOperationsJXL;
import com.selenium.SupportingClasses.TheEventListener;
import com.selenium.SupportingClasses.UIoperartions;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.MacroException;
import com.selenium.exception.POIException;
import com.solartis.selenium.macroPackage.MacroInterface;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

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
	public static MacroInterface macro = null;
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
	objectLoginScript = new ExcelOperationsJXL(this.configFile.getProperty("TestScriptPath"));
	objectLoginScript.getsheets(this.configFile.getProperty("loginSheetName"));
	objectTestScript = new ExcelOperationsJXL(this.configFile.getProperty("TestScriptPath"));
	objectTestScript.getsheets(this.configFile.getProperty("ScriptSheetName"));

}
//====================================Function to launch browser====================================================================================================
public WebDriver launchBrowser() throws MalformedURLException
{
	    String browser = configFile.getProperty("browser");
		return this.launch_browser(browser,configFile.getProperty("server"));
			
}
//==============================================Function to login===================================================================================================
  public void login(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException, AWTException
  {
	  
	  objectLoginScript.set_rownumber(1);
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
				System.out.println("action started");
				//this.perform(PropertyString,actionKeyword,ObjectType,value,dbcolumnNmae,dataProvidingFlag,InputData,outputData,waitingTime);
				System.out.println("action ended");
				
			}
			objectLoginScript.next_row();
		}	  
  }
 //=============================================Function to run the test script========================================================================================  
public void executeTestScript(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException, AWTException, DatabaseException
{
	objectTestScript.set_rownumber(1);
	int n=0;
	int l=0;
	String[] actionKeyword=null;
	String[] ObjectType=null;
	String[] PropertyString=null;
	String[] dbcolumnNmae=null;
	String[] value=null;
	String[] dataProvidingFlag=null;
	String[] waitingTime=null;
	String[] condition=null;
	String[] status=null;

	while(objectTestScript.has_next_row())
	{
		boolean loopFlag=false;
		String conditions=objectTestScript.read_data(objectTestScript.get_rownumber(),7);
		if(objectTestScript.read_data(objectTestScript.get_rownumber(),8).toString().equals("enabled")&& ConditionsChecking.ConditionReading(conditions, InputData))
		{	
			
			if(objectTestScript.read_data(objectTestScript.get_rownumber(),11).toString().equals("loop"))
			{
				String str1=InputData.get(objectTestScript.read_data(objectTestScript.get_rownumber(),5));
				System.out.println("-----------------"+InputData.get(objectTestScript.read_data(objectTestScript.get_rownumber(),5)));
				if(str1==null)	
				{
				System.out.println("no looping");
				}
				else
				{
				n=Integer.parseInt(InputData.get(objectTestScript.read_data(objectTestScript.get_rownumber(),5)));
				int rows=Integer.parseInt(objectTestScript.read_data(objectTestScript.get_rownumber(),6));
				actionKeyword=new String[rows];
				ObjectType=new String[rows];
				PropertyString=new String[rows];
				dbcolumnNmae=new String[rows];
				value=new String[rows];
				dataProvidingFlag=new String[rows];
				waitingTime=new String[rows];
				condition=new String[rows];
				status=new String[rows];
				while((objectTestScript.read_data(objectTestScript.get_rownumber(),11).toString().equals("loop")))
				{
					condition[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),7);
					status[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),8);
					actionKeyword[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),2);
					ObjectType[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),3);
					PropertyString[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),4);
					dbcolumnNmae[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),5);
					value[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),6);
					dataProvidingFlag[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),9);
					waitingTime[l]=objectTestScript.read_data(objectTestScript.get_rownumber(),10);
					l++;
					objectTestScript.next_row();

				}
				loopFlag=true;
				}
			}
			
			 if(loopFlag)
			 {
				 
				 for(int i=0;i<n;i++)
				 {
					 for(int j=0;j<l;j++)
					 {
					 if(status[j].equals("enabled")&& ConditionsChecking.ConditionReading(condition[j], InputData))
					 {
                       
						this.perform(configFile,PropertyString[j],actionKeyword[j],ObjectType[j],value[j],dbcolumnNmae[j],dataProvidingFlag[j],InputData,outputData,waitingTime[j]);
					 }
					 }
				 }
				 
			 }
			 if(!loopFlag)
			 {				 
				String actionKeyword1 = objectTestScript.read_data(objectTestScript.get_rownumber(),2);
				String ObjectType1 = objectTestScript.read_data(objectTestScript.get_rownumber(),3);
				String PropertyString1= objectTestScript.read_data(objectTestScript.get_rownumber(),4);
				String dbcolumnNmae1 = objectTestScript.read_data(objectTestScript.get_rownumber(),5);
				String value1 = objectTestScript.read_data(objectTestScript.get_rownumber(),6);
				String dataProvidingFlag1=objectTestScript.read_data(objectTestScript.get_rownumber(),9);
				String  waitingTime1=objectTestScript.read_data(objectTestScript.get_rownumber(),10);
				long start = System.currentTimeMillis();
				this.perform(configFile,PropertyString1,actionKeyword1,ObjectType1,value1,dbcolumnNmae1,dataProvidingFlag1,InputData,outputData,waitingTime1);
				if(dataProvidingFlag1.equals("CheckResTime"))
				{
					long end = System.currentTimeMillis();
					System.out.println("Round trip response time = " + (end-start) + " Millis");
					System.out.println("Round trip response time = " + (((end-start)/1000)%60) + " Soconds");
				}
				objectTestScript.next_row();
		     }
		}
		else
		{
			objectTestScript.next_row();
		}
	} 
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
public void generatExpectedResult(LinkedHashMap<String, String> inputrow,LinkedHashMap<String, String> outputrow ) throws ClassNotFoundException, MacroException, DatabaseException, POIException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
{
	
		  String classname = "com.solartis.selenium.macroPackage."+configFile.getProperty("MacroClassName");
		  Class<?> classobj=Class.forName(classname);
		  Constructor<?> cons = classobj.getConstructor(PropertiesHandle.class);
		  macro = (MacroInterface) cons.newInstance(configFile);
		  macro.LoadSampleRatingmodel(configFile, inputrow);
		  macro.GenerateExpected(inputrow, configFile);
		  macro.PumpinData(inputrow, configFile);
		  macro.PumpoutData(outputrow, inputrow, configFile);
	
}


public void CompareExpectedWithActual(LinkedHashMap<String, String> outputrow) throws SQLException, DatabaseException
{
	DatabaseOperation objectcomparison=new DatabaseOperation();
	LinkedHashMap<Integer, LinkedHashMap<String, String>> comparisontable=objectcomparison.GetDataObjects(configFile.getProperty("comparisonTableQuery"));//"select * from ComparisionCondition"
	
		for (Entry<Integer, LinkedHashMap<String, String>> entry : comparisontable.entrySet()) 	
		{
			LinkedHashMap<String, String> comparisonrow = entry.getValue();
			if (comparisonrow.get("Comaparision_Flag").equals("Y"))
			{
				//System.out.println("coming to comparison");
			   outputrow=this.CompareFunction(outputrow,comparisonrow);
			}
		}
		   //outputrow.updateRow();
    	
}

public void closeBrowser()
{
	this.stop_browser();
}


//==================================Function to compare  the results========================================================================================================
public LinkedHashMap<String, String> CompareFunction(LinkedHashMap<String, String> outputrow,LinkedHashMap<String, String> comparisonrow)  
{		
  try
  {
  	if(comparisonrow.get("Comaparision_Flag").equalsIgnoreCase("Y"))
		{
			String ExpectedColumn = comparisonrow.get("ExpectedColumn");
			String ActualColumn = comparisonrow.get("OutputColumn");
			String StatusColumn = comparisonrow.get("StatusColumn");
			if(!(StatusColumn.equals("")) && !(ExpectedColumn.equals("")))
			{
				if(premium_comp(outputrow.get(ExpectedColumn),outputrow.get(ActualColumn)))
				{
					outputrow.put(StatusColumn, "Pass");
				}
				else
				{
					outputrow.put(StatusColumn, "Fail");
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
		actual=actual.replace(",","");
		expected=expected.replace("$","");
		expected=expected.replace(",","");
		if(expected.equals(actual))
		{
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
}
