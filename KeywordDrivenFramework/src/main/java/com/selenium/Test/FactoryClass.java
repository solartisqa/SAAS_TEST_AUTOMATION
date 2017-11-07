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
        		//new UIMainscript("STARR-ASSIST","Quote","QA","C28","com.mysql.jdbc.Driver","jdbc:mysql://192.168.35.2:3391/SeleniumConfig","root","password","chrome","ActualOnly")
        		};
    }
}
