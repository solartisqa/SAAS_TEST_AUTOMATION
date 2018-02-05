package PojoCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckPriority 
{

	
	@Test(dataProvider="SampleData" ,priority=1)
	public void Test1(String name1,String name2)
	{
		System.out.println(".........Test1");
		System.out.println(name1);
		System.out.println(name2);
		
	}
	
	
	@Test(dataProvider="SampleData" ,priority=0)
	public void Test2(String name1,String name2)
	{
		System.out.println(".........Test2");
		System.out.println(name1);
		System.out.println(name2);
		
	}
	
	
	@DataProvider(name="SampleData" ,parallel=true)
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][2];
				data[0][0]="sasi";
		        data[0][1]="rekha";
		        
		        data[1][0]="san";
		        data[1][1]="thiya";
		return data;
	}
}
