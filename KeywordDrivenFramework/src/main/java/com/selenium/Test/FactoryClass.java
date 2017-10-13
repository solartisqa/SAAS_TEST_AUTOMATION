package com.selenium.Test;

import org.testng.annotations.Factory;

import com.beust.jcommander.Parameters;

public class FactoryClass 
{
	@Factory
    public Object[] create()
	{
        return new Object[]
        		{ 
        		new UIMainscript(System.getProperty("Project"),System.getProperty("Flow"),System.getProperty("Env"),System.getProperty("FlagForExecution"),System.getProperty("JDBC_DRIVER"),System.getProperty("DB_URL"),System.getProperty("USER"),System.getProperty("password"),System.getProperty("browser"),System.getProperty("ResultChoice"))
        		};
    }
}
