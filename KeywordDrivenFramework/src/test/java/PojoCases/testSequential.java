package PojoCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testSequential
{
  private String s1=null;
   private String s2=null;
   private String s3=null;
	public testSequential(String s1,String s2,String s3)
	{
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
	}
	
	@Test
	public void Testcase1()
	{
		System.out.println("TC1");
		System.out.println(s1+s2+s3);
	}
	
	@Test
	public void Testcase2()
	{
		System.out.println("TC2");
		System.out.println(s1+s2+s3);
	}
	
	@Test
	public void Testcase3()
	{
		System.out.println("TC3");
		System.out.println(s1+s2+s3);
	}
	

/*	 @DataProvider(name="sampleData")//,parallel=true)
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
	    	
	    }*/
}
