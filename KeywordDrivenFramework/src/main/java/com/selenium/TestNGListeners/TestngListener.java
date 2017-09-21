package com.selenium.TestNGListeners;

import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.selenium.Test.UIMainscript;

public class TestngListener implements ITestListener
{

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
		for (ITestResult temp : failedTests) {
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
		}
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

	public void onTestFailure(ITestResult arg0) 
	{
		System.out.println(arg0.getTestClass().getName());
	
		// TODO Auto-generated method stub
		
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
	

}
