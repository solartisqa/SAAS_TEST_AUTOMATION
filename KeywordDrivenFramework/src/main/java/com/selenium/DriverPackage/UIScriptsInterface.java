package com.selenium.DriverPackage;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.selenium.exception.DatabaseException;
import com.selenium.exception.MacroException;
import com.selenium.exception.POIException;

public interface UIScriptsInterface
{
	public WebDriver launchBrowser() throws MalformedURLException;
	public void login(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException,AWTException;
	public void executeTestScript(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException, AWTException,DatabaseException;
	public void closeBrowser();
	public void generatExpectedResult(LinkedHashMap<String, String> inputrow, LinkedHashMap<String, String> outputrow)
			throws ClassNotFoundException, MacroException, DatabaseException, POIException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException;
	public void CompareExpectedWithActual(LinkedHashMap<String, String> outputrow)
			throws SQLException, DatabaseException;
}
