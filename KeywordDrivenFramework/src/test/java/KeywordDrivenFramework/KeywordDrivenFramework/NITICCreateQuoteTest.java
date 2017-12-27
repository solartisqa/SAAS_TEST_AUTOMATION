package KeywordDrivenFramework.KeywordDrivenFramework;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.Test.BaseSuite;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;

import NITICPOM.*;


public class NITICCreateQuoteTest extends BaseSuite
{
	public static   ObjectMapper inputtableobjectMapper;
	public static   ObjectMapper outputtableobjectMapper;
	public  DatabaseOperation input;
	public  DatabaseOperation output;
	public static  LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public static  LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;

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
    
    
    
    @Parameters({"jdbcDriver","dburl","dbUsername","dbPassword","inputtableName","outputtableName"})
    @BeforeSuite
    public void loadConfig(String jdbcDriver,String dburl,String dbUsername,String dbPassword,String inputtableName,String outputtableName) throws DatabaseException
    {
    	System.setProperty("jsse.enableSNIExtension", "false");
    	DatabaseOperation.ConnectionSetup(jdbcDriver,dburl,dbUsername,dbPassword); 
    	input = new DatabaseOperation();
    	output = new DatabaseOperation();
    	inputtable = input.GetDataObjects("SELECT * FROM "+inputtableName);
    	outputtable = output.GetDataObjects("SELECT * FROM "+outputtableName);
    	
    }
    
    @Parameters({"EnvURL","userName","password"})
	@Test
	public void Login(String EnvURL,String userName,String password) throws InterruptedException
	{
		driver.get(EnvURL);
		log=new LoginPage(driver);
		log.setUserName(userName);
		log.setPassword(password);
		hmpage=log.ClickLogin();
	}
	
    @Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
    public void createQuote(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws DatabaseException, InterruptedException, AWTException, IOException
    {
    	LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
		LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
		if(inputrow.get("Flag_for_execution").equals(TestFlag))
		{
			 System.out.println("Started Flow");
			
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
			 DocPage.AttachFile3(inputrow);
			 QSPage.ClickIssuePolicy();
			 PSPage=QSPage.ClickIssuePolicyYes();
	
			 Thread.sleep(1000);
			 inputrow.put("Flag_for_execution", "completed");
			 outputrow.put("Flag_for_execution", "completed");
			 
				input.UpdateRow(RowIterator, inputrow);
				output.UpdateRow(RowIterator, inputrow);
		}
		
    }
    
    @DataProvider(name="UITestData",parallel=true)
	 public  static Object[][] getDataFromDataprovider() throws DatabaseException, PropertiesHandleException
	 {
		 Iterator<Entry<Integer, LinkedHashMap<String,String>>> inputtableiterator = inputtable.entrySet().iterator();
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
