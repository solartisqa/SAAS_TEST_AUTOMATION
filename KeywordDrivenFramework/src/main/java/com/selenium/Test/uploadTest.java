package com.selenium.Test;

import org.testng.annotations.Test;


import StarrAssistPOM.*;

public class uploadTest extends BaseSuite
{
	public LoginPage log;
	public HomePage hmpage;
@Test
public void upload() throws InterruptedException
{
	driver.get("https://saqa2.solartis.net/");
	System.out.println(driver.getTitle());
	Thread.sleep(1000);
	log=new LoginPage(driver);
	log.setUserName("csruser");
	
	log.setPassword("Welcome*1");
	
	hmpage=log.ClickLogin();
	hmpage.upload();
	
	
System.out.println("hi.............");


}
}
