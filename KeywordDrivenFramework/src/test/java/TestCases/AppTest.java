package TestCases;

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


public class AppTest extends BaseSuite
{
	public  ObjectMapper inputtableobjectMapper;
	public  ObjectMapper outputtableobjectMapper;
	public static DatabaseOperation input;
	public static DatabaseOperation output;
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;

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
    	// Iterator<Entry<Integer, LinkedHashMap<String,String>>> inputtableiterator = inputtable.entrySet().iterator();
		 //Iterator<Entry<Integer, LinkedHashMap<String,String>>> outputtableiterator = outputtable.entrySet().iterator();
    	
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
    public void createQuote(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws DatabaseException
    {
    	LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
		LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
		if(inputrow.get("Flag_for_execution").equals(TestFlag))
		{
		inputrow.put("Flag_for_execution", "completed");
		outputrow.put("Flag_for_execution", "completed");
		input.UpdateRow(RowIterator, inputrow);
	    System.out.println("hi....");
		}
	  
    }
    
    @DataProvider(name="UITestData")//,parallel=true)
	 public Object[][] getDataFromDataprovider() throws DatabaseException, PropertiesHandleException
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
