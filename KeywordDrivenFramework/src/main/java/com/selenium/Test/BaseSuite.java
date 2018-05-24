package com.selenium.Test;

import org.testng.annotations.Factory;

public class BaseSuite 
{
@Factory
public Object[] runParallel()
{
	/*String Project=System.getProperty("Project");
	String Flow=System.getProperty("Flow");
	String Env=System.getProperty("Env");
	String[] FlagForExecution=System.getProperty("FlagForExecution").split("-");
	String JDBC_DRIVER =System.getProperty("JDBC_DRIVER");
	String DB_URL=System.getProperty("DB_URL");
	String USER =System.getProperty("USER");
	String password=System.getProperty("password");
	String browser=System.getProperty("browser");
	String ResultChoice=System.getProperty("ResultChoice");
	String[] remoteIP =System.getProperty("remoteIP").split("-");
	String Port=System.getProperty("Port");
	String userLogin=System.getProperty("userLogin");*/
	Object[] run=new Object[2];
	 
	run[0]=	  new UIMainscript(System.getProperty("Project"),System.getProperty("Flow"),System.getProperty("Env"),"Y",System.getProperty("JDBC_DRIVER"),System.getProperty("DB_URL"),System.getProperty("USER"),System.getProperty("password"),System.getProperty("browser"),System.getProperty("ResultChoice"),"192.168.4.131",System.getProperty("Port"),System.getProperty("userLogin"));
	run[1]=	  new UIMainscript(System.getProperty("Project"),System.getProperty("Flow"),System.getProperty("Env"),"S",System.getProperty("JDBC_DRIVER"),System.getProperty("DB_URL"),System.getProperty("USER"),System.getProperty("password"),System.getProperty("browser"),System.getProperty("ResultChoice"),"192.168.4.75",System.getProperty("Port"),System.getProperty("userLogin"));
	return run;
}
}

