package com.selenium.DriverPackage;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.selenium.exception.DatabaseException;

public interface UIScriptsInterface
{
	public RemoteWebDriver launchBrowser(String browser) throws MalformedURLException;
	public void login(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException,AWTException;
	public void executeTestScript(LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData) throws SQLException, IOException, InterruptedException, AWTException,DatabaseException;
	
}
