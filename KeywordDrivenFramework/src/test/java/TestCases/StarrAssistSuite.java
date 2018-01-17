package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;

import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.SupportingClasses.browserLaunching;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;
import StarrAssistPOM.*;
public class StarrAssistSuite extends browserLaunching
{
	public   DatabaseOperation input;
	public  DatabaseOperation output;

	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable;
	public  LinkedHashMap<Integer, LinkedHashMap<String, String>> outputtable;
	public  Iterator<Entry<Integer, LinkedHashMap<String, String>>> inputtableiterator;
	public  Iterator<Entry<Integer, LinkedHashMap<String, String>>> outputtableiterator;
	public  ObjectMapper inputtableobjectMapper;
	public  ObjectMapper outputtableobjectMapper;
	public  LinkedHashMap<String, String> inputrow;
	public  LinkedHashMap<String, String> outputrow;
	
	public  static PropertiesHandle configFile;
	public    RemoteWebDriver driver=null; //changed
	public static  String exceptionScreenshotPath=null;
	
	
	public String FlagforExecution;
	
	public LoginPage log;
	public HomePage hmpage;
    public GetAQuotePage getQuotePage;
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
    
    
	@Test
	public void Login() throws InterruptedException
	{
		
		driver.get(configFile.getProperty("EnvURL"));
		log=new LoginPage(driver);
		
		log.setUserName("csruser");
		
		log.setPassword("welcome1");
		
		hmpage=log.ClickLogin();
		hmpage.ClickFileUpload();
		
		
	}


	/*@Test(dataProvider="sampleData",dependsOnMethods = { "Login" })
	public void TestCase1(String country,String plan,String Flagindata) throws InterruptedException
	{
		
	    System.out.println(FlagforExecution+"----"+Flagindata);
	    if(FlagforExecution.equals(Flagindata))
	    {
		getQuotePage=hmpage.ClickGetAQuote();
		
		getQuotePage.selectStateOfResidence(country);
		getQuotePage.selectPlanName(plan);
	    }
		
	}
	*/
	
	
	  /* @SuppressWarnings("unchecked")
		@Test(dataProvider="UITestData",dependsOnMethods = { "Login" })
		
	    public void UITest(Integer RowIterator, Object inputtablerowobj, Object outputtablerowobj) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException, DatabaseException
	    {
			LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
			LinkedHashMap<String, String> outputrow = outputtableobjectMapper.convertValue(outputtablerowobj, LinkedHashMap.class);
	    	
				
				 if(inputrow.get("Flag_for_execution").equals(FlagforExecution))//
				   {  
					 getQuotePage=hmpage.ClickGetAQuote();
					
					 getQuotePage.selectStateOfResidence(inputrow.get("State_of_Residence"));
					 
					 getQuotePage.selectPlanName(inputrow.get("Plan_Name"));
					 
					 String PlanName=inputrow.get("Plan_Name");
					 String StateOfResidence=inputrow.get("State_of_Residence");
					 if(PlanName.equals("Air Ticket Protector"))
					 {
						 System.out.println("condition true");
					 }
					 
					 if(PlanName.equals("Air Ticket Protector")|PlanName.equals("Classic Plus")|PlanName.equals("Premier")|PlanName.equals("Renter's Collision")|PlanName.equals("CAT 70"))
                     {
						 getQuotePage.selectDestinationCountry(inputrow.get("Destination_Country"));
                     }
					 if(PlanName.equals("Air Ticket Protector")|PlanName.equals("Classic Plus")|PlanName.equals("Premier")|PlanName.equals("CAT 70"))
					 {
						 getQuotePage.setDepaturedate(inputrow.get("Departure_date"));
						 
					 }
					 if(PlanName.equals("Air Ticket Protector")|PlanName.equals("Classic Plus")|PlanName.equals("Premier")|PlanName.equals("CAT 70"))
					 {
						 getQuotePage.setReturndate(inputrow.get("Return_date"));
						 
					 }
					 if(PlanName.equals("Air Ticket Protector")|PlanName.equals("Classic Plus")|PlanName.equals("Premier")|PlanName.equals("CAT 70"))
					 {
						 getQuotePage.setDepositdate(inputrow.get("Deposit_date"));
						 
					 }
					 if(PlanName.equals("Premier Annual")|PlanName.equals("Basic Annual")|PlanName.equals("Medical Only Annual"))
					 {
						 getQuotePage.setPolicyEffectiveDate(inputrow.get("Policy_effective_date"));
						 
					 }
					 if(PlanName.equals("Renter's Collision"))
					 {
						 getQuotePage.setRentalStartDate(inputrow.get("Rental_start_date"));
						 
					 }
					 if(PlanName.equals("Renter's Collision"))
					 {
						 getQuotePage.setRentalEndDate(inputrow.get("Rental_end_date"));
						 
					 }
					 
					 if((PlanName.equals("Classic Plus")|PlanName.equals("Premier")|PlanName.equals("CAT 70"))&&(StateOfResidence.equals("New York")))
					 {
						 getQuotePage.ClickTripCancellation(inputrow.get("Trip_cancellation_coverage"));
					 }
					 if(PlanName.equals("Air Ticket Protector")|PlanName.equals("Classic Plus")|PlanName.equals("Premier")|PlanName.equals("CAT 70"))
					 {
						 getQuotePage.setTravelcost(inputrow.get("Travel_cost"));
						 
					 }
					 if(PlanName.equals("Air Ticket Protector")|PlanName.equals("Classic Plus")|PlanName.equals("Premier")|PlanName.equals("CAT 70")|PlanName.equals("Medical Only Annual"))
					 {
						 getQuotePage.setTravelerDOB(inputrow.get("Traveler_DOB"));
						 
					 }
					 
					 getQuotePage.Clickcalculate();
					 
					 outputrow.put("Premium", getQuotePage.getPremium());
					 
					// getQuotePage.ClickSaveandcontinue();
					 
					 
					
					  inputrow.put("Flag_for_execution", inputrow.get("Flag_for_execution")+"Completed");
					  outputrow.put("Flag_for_execution", "Completed");
				   }		   
			  input.UpdateRow(RowIterator, inputrow);
			  output.UpdateRow(RowIterator, outputrow);
	    }*/
	
	
	
	
//	@AfterTest(alwaysRun=true)
//	public void close()
//	{
//		//driver.quit();
//	}

	 @DataProvider(name="sampleData")//,parallel=true)
	    public Object[][] getSampleData()
	    {
	    	Object data[][]=new Object[3][3];
	    	data[0][0]="Alabama";
	    	data[0][1]="CAT 70";
	    	data[0][2]="Y1";
	    
	    	data[1][0]="Alaska";
	    	data[1][1]="Air Ticket Protector";
	    	data[1][2]="Y2";
	    	
	    	data[2][0]="Arizona";
	    	data[2][1]="Classic Plus";
	    	data[2][2]="Y1";
	    	
			return data;
	    	
	    }
	
	 
	 
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
