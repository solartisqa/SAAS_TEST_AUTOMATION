package StarrAssistTestCases;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.Configuration.PropertiesHandle;
import com.selenium.SupportingClasses.DatabaseOperation;
import com.selenium.SupportingClasses.browserLaunching;
import com.selenium.Test.BaseTest;
import com.selenium.exception.DatabaseException;
import com.selenium.exception.PropertiesHandleException;
import StarrAssistPOM.*;

public class StarrAssistSuite 
{
	//public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	public static Connection conn = null;
	
	@BeforeTest
	public void connectionSetup() throws DatabaseException
	{
		conn=DatabaseOperation.ConnectionSetup("com.mysql.jdbc.Driver","jdbc:mysql://192.168.84.225:3700/TestDB_Starr","root","redhat");
	}
	
	@Test(dataProvider="datafromdb")
	public void Login(Integer RowIterator, Object inputtablerowobj) throws InterruptedException, MalformedURLException, SQLException
	{
		//RemoteWebDriver driver = null;
		BaseTest base=new BaseTest();
		WebDriver wdriver = base.launchRemoteBrowser("chrome");
	     ObjectMapper inputtableobjectMapper= new ObjectMapper();
	     @SuppressWarnings("unchecked")
	     LinkedHashMap<String, String> inputrow = inputtableobjectMapper.convertValue(inputtablerowobj, LinkedHashMap.class);
	/*	 DesiredCapabilities cap = null;
		 cap = DesiredCapabilities.chrome();
		 cap.setBrowserName("chrome");
		 cap.setPlatform(Platform.WINDOWS);
		// driver = new RemoteWebDriver(new URL("http://192.168.4.75:4444/wd/hub"), cap);
		 //setWebDriver(driver);
		// wdriver=getDriver();
		//wdriver.manage().window().maximize();
		 //wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
*/		 wdriver.get("https://saqa.solartis.net/");
		 Thread.sleep(2000);
		 Statement stmt = conn.createStatement();
		 stmt.executeUpdate("update ParallelTest set status='pass' where S_No="+RowIterator);
		 LoginPage log=new LoginPage(wdriver);
		 log.setUserName(inputrow.get("Username"));
		 log.setPassword(inputrow.get("password"));
		 log.ClickLogin();
		 
		 wdriver.quit();	
	}
	
	@AfterTest
	public void quit()
	{
		
	}
/*	public WebDriver getDriver()
	{
        return dr.get();
    }
 
    public void setWebDriver(RemoteWebDriver driver) {
        dr.set(driver);
    }*/


	
	   @DataProvider(name="datafromdb",parallel=true)
		 public Object[][] getDataFromdb() throws DatabaseException, PropertiesHandleException
		 {
		   LinkedHashMap<Integer, LinkedHashMap<String, String>> inputtable=null;
			 inputtable = this.GetDataObjects("com.mysql.jdbc.Driver","jdbc:mysql://192.168.84.225:3700/TestDB_Starr","root","redhat","SELECT * FROM ParallelTest");
			 Iterator<Entry<Integer, LinkedHashMap<String,String>>> inputtableiterator = inputtable.entrySet().iterator();
		
			 int rowIterator = 0;
			 Object[][] combined = new Object[inputtable.size()][2];
			 while (inputtableiterator.hasNext()) 
				{
					Entry<Integer, LinkedHashMap<String, String>> inputentry = inputtableiterator.next();
			        LinkedHashMap<String, String> inputrow = inputentry.getValue();
			        ObjectMapper   inputtableobjectMapper = new ObjectMapper();
					 Object inputtablerowobject = inputtableobjectMapper.convertValue(inputrow, Object.class);
					 combined[rowIterator][0] = rowIterator+1;
					 combined[rowIterator][1] = inputtablerowobject;
					 rowIterator++;
				}  
			 return combined;
		 }
	   
	   public LinkedHashMap<Integer, LinkedHashMap<String, String>> GetDataObjects(String jdbcdriver,String dburl,String user,String password,String query) throws DatabaseException
		{
		  // Connection conn=null;
		   ResultSet rs = null;
		   LinkedHashMap<Integer, LinkedHashMap<String, String>> table = null;
		   ResultSetMetaData meta = null;
		   Statement stmt =null;
		   int rs_row = 1;
		/*   try
		   {
		  // Class.forName("com.mysql.jdbc.Driver");
		  // conn = DriverManager.getConnection("jdbc:mysql://192.168.84.225:3700/TestDB_Starr","root","redhat");
		   }
		   catch(Exception e)
		   {
			   System.out.println("Error in connection settings");
		   }*/
			LinkedHashMap<String, String> row = null;
			try 
			{
				stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			    rs =    stmt.executeQuery(query);
			    table = new LinkedHashMap<Integer, LinkedHashMap<String, String>>();
		        meta = rs.getMetaData();        
		        while (rs.next())
		        {
		        	row = new LinkedHashMap<String, String>();
		            for (int columnIterator = 1; columnIterator <= meta.getColumnCount(); columnIterator++) 
		            {
		                String key = meta.getColumnName(columnIterator);
		                String value = rs.getString(key);
		                row.put(key, value);
		            }
		            table.put(rs_row, row);
		            rs_row = rs_row + 1;   
		        } 
		        return table;  
			} 
			catch (SQLException e) 
			{
				throw new DatabaseException("PROBLEM WITH RESULT-SET OBTAINED FROM DB",e);
			}
			
		}
		
	   
}
