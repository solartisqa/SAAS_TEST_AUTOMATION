package NITICPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FindInsuredPage 
{
	private WebDriver driver;


	 public FindInsuredPage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in Home page");
		 }
		 PageFactory.initElements(driver, this);
	 }
}
