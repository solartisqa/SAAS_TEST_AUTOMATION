package DriverPackages;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import SupportingClasses.databaseOperartions;

public interface UIScriptsInterface
{
	public void launchBrowser();
	public void login(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException, InterruptedException,AWTException;
	public void executeTestScript(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException, InterruptedException,AWTException;
	public void closeBrowser();
}
