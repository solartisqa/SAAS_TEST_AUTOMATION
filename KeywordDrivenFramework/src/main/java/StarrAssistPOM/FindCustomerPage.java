package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FindCustomerPage 
{
	private WebDriver driver;
	 public FindCustomerPage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	 }
}
