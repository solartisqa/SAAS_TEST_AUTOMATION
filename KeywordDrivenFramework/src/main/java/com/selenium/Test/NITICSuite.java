package com.selenium.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.DriverPackage.BaseDriverScript;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;

import NITICPOM.*;


public class NITICSuite 
{
	public   DatabaseOperation input;
	public  DatabaseOperation output;

	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;

	public  ObjectMapper inputtableobjectMapper;
	public  ObjectMapper outputtableobjectMapper;
	public  LinkedHashMap<String, String> inputrow;
	public  LinkedHashMap<String, String> outputrow;
	public  static BaseDriverScript objDriver;
	public  static PropertiesHandle configFile;
	public    RemoteWebDriver driver=null; //changed
	public static  String exceptionScreenshotPath=null;
	
	
	public String FlagforExecution;
	
	public LoginPage log;
	public HomePage hmpage;
	public BusinessPage BusPage;
	public CoveragePage CovPage;
	public VehiclePage VehPage;
	public DriverPage drPage;
	public AdditionalInsuredPage AIPage;
	public PriorCarrierPage PCPage;
    public ShareholderPage SHPage;
    public QuoteSummaryPage QSPage;
    public DocumentsPage DocPage;
    public FindQuotePage FQPage;
    public FindPolicyPage FPPage;
    public PolicySummaryPage PSPage;
    public EndorsementPage EndorsePage;
    @Parameters({"Project","Flow","Environment","Flag","jdbcDriver","url","dbUsername","dbPassword","browser","ResultsChoice"})
	@BeforeSuite
	public void loadconfig(String Project,String Flow,String Environment,String Flag,String jdbcDriver,String url,String dbUsername,String dbPassword,String browser,String ResultsChoice) throws DatabaseException, ClassNotFoundException, SQLException, PropertiesHandleException, MalformedURLException
	{
    	System.out.println("before test");
		System.setProperty("jsse.enableSNIExtension", "false");
		configFile = new PropertiesHandle(Project,Flow,Environment,Flag,jdbcDriver,url,dbUsername,dbPassword,browser,ResultsChoice);		
		DatabaseOperation.ConnectionSetup(configFile);  
		exceptionScreenshotPath=configFile.getProperty("ScreenShotPath"); 
		
		
	}
    
      @Parameters({"browser","Flag"})
	  @BeforeTest(alwaysRun=true)
	 public void launchBrowser(String browser,String Flag) throws MalformedURLException, InterruptedException, DatabaseException, PropertiesHandleException, ClassNotFoundException, SQLException
	 {
		//driver=this.launch_browser(browser,configFile);
    	objDriver=new BaseDriverScript(configFile);
  		driver=objDriver.launchBrowser(browser);
  		FlagforExecution=Flag;
  		
	}
    
    
	@Test
	public void Login() throws InterruptedException
	{
		
		driver.get(configFile.getProperty("EnvURL"));
		log=new LoginPage(driver);
		log.setUserName("nitic_uw");
		log.setPassword("welcome1");
		hmpage=log.ClickLogin();
	}

	 /* @SuppressWarnings("unchecked")
		
		@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
	    public void TestCase1(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException
	    {
			LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
			LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
			
				//String dataFlag="Y1";
			   System.out.println("flag in xml"+FlagforExecution);
			   System.out.println("flag in data"+inputrow.get("Flag_for_execution"));
				if(inputrow.get("Flag_for_execution").equals(FlagforExecution))//
				  {  
					 hmpage.ClickFind();
					 FQPage=hmpage.ClickFindQuote();
					 FQPage.setQuoteNumber("QNITIC-849");
					 FQPage.ClickFindQuoteButton();
					 QSPage=FQPage.ClickQuoteFromList("QNITIC-849");
					 QSPage.ClickQuoteSummary();
					 DocPage=QSPage.ClickDocuments();
					 DocPage.AttachFile(inputrow);
					 FPPage=hmpage.ClickFindPolicy();
					 FPPage.setPolicyNumber("B3015-01");
					 FPPage.ClickFindPolicyButton();
					 PSPage=FPPage.ClickPolicyFromList("B3015-01");
					 outputrow.put("PolicyNumber", PSPage.getPolicyNumber());
					 EndorsePage=PSPage.ClickEndorsementAccordian();
					 EndorsePage.EditEndorsementPage(inputrow);
					 
					inputrow.put("Flag_for_execution", inputrow.get("Flag_for_execution")+"Completed");
					outputrow.put("Flag_for_execution", "Completed");
					 
				  }		   
			  input.UpdateRow(RowIterator, inputrow);
			  output.UpdateRow(RowIterator, outputrow);
	    }
	   */


	  @SuppressWarnings("unchecked")
		
		@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
	    public void TestCase1(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException
	    {
			LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
			LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
			
				//String dataFlag="Y1";
			   System.out.println("flag in xml"+FlagforExecution);
			   System.out.println("flag in data"+inputrow.get("Flag_for_execution"));
				if(inputrow.get("Flag_for_execution").equals(FlagforExecution))//
				  {  
					 hmpage.ClickHome();
					 hmpage.ClickTruckersInsurance();
					 Thread.sleep(2000);
					 hmpage.selectSubBusinessType(inputrow.get("BusinessType"));
					 BusPage=hmpage.ClickContinue();
					 BusPage.FillBusinessDetails(inputrow);
					 CovPage=BusPage.ClickCoverage();
					 CovPage.FillCoverageDetails(inputrow);
					 VehPage=CovPage.ClickVehicle();
					 VehPage.FillVehicleDetails(inputrow);
					 VehPage.FillLossPayeeDetails(inputrow);
					 drPage=VehPage.ClickDriver();
					 drPage.FillDriverDetails(inputrow);
					 drPage.FillAccidentViolationDetails(inputrow);
					 AIPage=drPage.ClickAdditionalInsured();
					 AIPage.FillAdditionalInsured(inputrow);
					 PCPage=AIPage.ClickPriorCarrier();
					 PCPage.FillPriorCarrier(inputrow);
					 SHPage=PCPage.ClickShareholder();
					 SHPage.FillShareHolderDetails(inputrow);
					 SHPage.ClickQuoteType(inputrow.get("QuoteType"));
					 QSPage=SHPage.ClickCreateQuote();
					 QSPage.EditCoverageDetails(inputrow);
					 QSPage.getDetailsFromQuoteSummary(outputrow);
					 QSPage.ClickOfferQuote();
					 DocPage=QSPage.ClickOfferQuoteYes();
					 DocPage.AttachFile2(inputrow);
					 QSPage.ClickIssuePolicy();
					 PSPage=QSPage.ClickIssuePolicyYes();
					 
					 outputrow.put("PolicyNumber", PSPage.getPolicyNumber());
					 
					 inputrow.put("Flag_for_execution", inputrow.get("Flag_for_execution")+"Completed");
					// outputrow.put("Flag_for_execution", "Completed");
					 
				  }		   
			  input.UpdateRow(RowIterator, inputrow);
			  output.UpdateRow(RowIterator, outputrow);
	    }
	   
	/*   @SuppressWarnings("unchecked")
		
		@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
	    public void TestCase2(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException
	    {
			LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
			LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
			
				//String dataFlag="Y1";
			   System.out.println("flag in xml"+FlagforExecution);
			   System.out.println("flag in data"+inputrow.get("Flag_for_execution"));
				if(outputrow.get("Flag_for_execution").equals(FlagforExecution))//
				  {  
					 hmpage.ClickFind();
					 FPPage=hmpage.ClickFindPolicy();
					 FPPage.setPolicyNumber(outputrow.get("PolicyNumber"));
					 FPPage.ClickFindPolicyButton();
					 PSPage=FPPage.ClickPolicyFromList(outputrow.get("PolicyNumber"));
					 PSPage.ClickPolicySummary();
					 DocPage=PSPage.ClickDocuments();
					 DocPage.AttachFile(inputrow);
					// DocPage.ClickAttach();
					// DocPage.ClickBrowse();
				    // DocPage.uploadFile();
				     String title=driver.getTitle();
				     System.out.println(title);
				 
					 ///DocPage.ClickAttachFile();
				    //PSPage.ClickPolicySummary();
				   // DocPage=PSPage.ClickDocuments();
					 
					// EndorsePage=PSPage.ClickEndorsementAccordian();
					 //EndorsePage.EditEndorsementPage(inputrow);
					 
					 
					 
					//inputrow.put("Flag_for_execution", inputrow.get("Flag_for_execution")+"Completed");
					outputrow.put("Flag_for_execution", "Completed");
					 
				  }		   
			  input.UpdateRow(RowIterator, inputrow);
			  output.UpdateRow(RowIterator, outputrow);
	    }*/
	   
	   @DataProvider(name="UITestData")//,parallel=true)
			 public Object[][] getDataFromDataprovider() throws DatabaseException, PropertiesHandleException
			 {
				 input = new DatabaseOperation();
				 inputtable = input.GetDataObjects(configFile.getProperty("inputQuery"));
				 Iterator<Entry<Integer, LinkedHashMap<String,String>>> inputtableiterator = inputtable.entrySet().iterator();
				 output = new DatabaseOperation();
				 outputtable = output.GetDataObjects(configFile.getProperty("outputQuery"));
				 Iterator<Entry<Integer, LinkedHashMap<String,String>>> outputtableiterator = outputtable.entrySet().iterator();
				 int rowIterator = 0;
				 Object[][] combined = new Object[inputtable.size()][3];
				 while (inputtableiterator.hasNext() && outputtableiterator.hasNext()) 
					{
						Entry<Integer, LinkedHashMap<String, String>> inputentry = inputtableiterator.next();
						Entry<Integer, LinkedHashMap<String, String>> outputentry = outputtableiterator.next();
				        LinkedHashMap<String, String> inputrow = inputentry.getValue();
				        LinkedHashMap<String, String> outputrow = outputentry.getValue();
				         inputtableobjectMapper = new ObjectMapper();
						 Object inputtablerowobject = inputtableobjectMapper.convertValue(inputrow, Object.class);
						 outputtableobjectMapper = new ObjectMapper();
						 Object outputtablerowobject = outputtableobjectMapper.convertValue(outputrow, Object.class);
						 combined[rowIterator][0] = rowIterator+1;
						 combined[rowIterator][1] = inputtablerowobject;
						 combined[rowIterator][2] = outputtablerowobject;
						 rowIterator++;
					}  
				 return combined;
			 }
	   
}
