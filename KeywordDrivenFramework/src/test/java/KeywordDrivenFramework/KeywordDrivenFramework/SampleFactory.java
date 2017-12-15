package KeywordDrivenFramework.KeywordDrivenFramework;

import org.testng.annotations.*;
import org.testng.annotations.Factory;

public class SampleFactory
{
	@Factory(dataProvider="sampleData")
	public Object[] createInstances(String s1, String s2,String s3)
	{
		return new Object[] {new testSequential(s1,s2,s3)};
	}
	

	 @DataProvider(name="sampleData")
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
}
