package com.selenium.TestNGListeners;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import org.apache.commons.io.FileUtils;
import com.selenium.Test.*;
public class TestngListener implements ITestListener
{
	
	WebDriver driver=null;
	String filePath=null;
	
	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
		// Code to avoid duplicate test run due to retry
		Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		//failedTests.addAll(skippedTests);
		for (ITestResult temp : skippedTests) 
		{
			ITestNGMethod method = temp.getMethod();
			if (context.getSkippedTests().getResults(method).size() > 1) 
			{
				skippedTests.remove(temp);
			} else 
			{
				if (context.getPassedTests().getResults(method).size() > 0) 
				{
					//skippedTests.remove(temp);
				}
				
			}
		}
		/*for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) 
			{
				failedTests.remove(temp);
			} else 
			{
				if (context.getPassedTests().getResults(method).size() > 0) 
				{
					failedTests.remove(temp);
				}
				
			}
		}*/
	}

	public void onStart(ITestContext arg0) 
	{
		// TODO Auto-generated method stub
		Set<String> attributeNames = arg0.getAttributeNames();
		for(String sttributeName: attributeNames)
		{
			System.out.println(sttributeName);
		}
		System.out.println("Calling Listener Class");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("FailedButWithinSuccessPercentage");
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("***** Error "+result.getName()+" test has failed *****");
		String testClassName = getTestClassName(result.getInstanceName()).trim();
    	String methodName=result.getName().toString().trim();
    	Object []parameter = result.getParameters();
    	String test=String.valueOf(parameter[0]);
    	System.out.println(String.valueOf(parameter[0]));
    	takeScreenShot(methodName,test,testClassName);
    	
	}

	public void onTestSkipped(ITestResult arg0) 
	{
		// TODO Auto-generated method stub	
		
	}

	public void onTestStart(ITestResult arg0) 
	{
		// TODO Auto-generated method stub
		Set<String> sttributeNames = arg0.getAttributeNames();
		for(String sttributeName: sttributeNames)
		{
			System.out.println(sttributeName);
		}
	}

	public void onTestSuccess(ITestResult arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("On Test Success");
		long millisec = arg0.getEndMillis();
		System.out.println(millisec);
		
		Set<String> sttributeNames = arg0.getAttributeNames();
		for(String sttributeName: sttributeNames)
		{
			System.out.println(sttributeName);
		}
	}
	
	 public void takeScreenShot(String methodName,String testNo,String className) 
	 {
		 //UIMainscript ob=new UIMainscript();
		 System.out.println("Taking ScreenShot");
	    	//driver=UIMainscript.driver;
	    	
	    	System.out.println("file path: "+filePath);
	            try
	            {
	   	    	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(filePath+className+"_"+methodName+"_"+testNo+".png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e)
	            {
					System.out.println("Exception in taking Screenshots");
					e.printStackTrace();
				}
	    }
	 
	 
	 
	 public String getTestClassName(String testName) {
			String[] reqTestClassname = testName.split("\\.");
			int i = reqTestClassname.length - 1;
			System.out.println("Required Test Name : " + reqTestClassname[i]);
			return reqTestClassname[i];
		}
	 
	 
}
