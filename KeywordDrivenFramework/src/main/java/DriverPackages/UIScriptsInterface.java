package DriverPackages;

import java.io.IOException;
import java.sql.SQLException;

import SupportingClasses.databaseOperartions;

public interface UIScriptsInterface
{
	public void launchBrowser();
	public void login(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException, InterruptedException;
	public void executeTestScript(databaseOperartions objectInput,databaseOperartions objectOutput) throws SQLException, IOException, InterruptedException;
	public void closeBrowser();
}
