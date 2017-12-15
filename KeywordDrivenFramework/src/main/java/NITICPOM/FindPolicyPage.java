package NITICPOM;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BasePage.BasePage;

public class FindPolicyPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(id="FindPolicy:FindPolicyForm:Object__Policy__PolicyNumber")WebElement PolicyNumber;
	@FindBy(id="FindPolicy:FindPolicyForm:Object__Policy__PolicySubNumber")WebElement PolicySubNumber;
	@FindBy(id="FindPolicy:FindPolicyForm:FindPolicyButton")WebElement FindPolicyButton;
	@FindBy(xpath="//tbody[@id='FindPolicy:FindPolicyForm:dtablepol_data']//td/a")List<WebElement> PolicyList;
	
	
	
	 public FindPolicyPage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 private boolean isInitialized(boolean displayed)
	 {
		
		return PolicyNumber.isDisplayed();
	}
	 
	 public void setPolicyNumber(String policyNumber)
	 {
		 String[] policy=policyNumber.split("-");
		 this.WaitWithVisibility(PolicyNumber,driver);
		 PolicyNumber.clear();
		 PolicyNumber.sendKeys(policy[0]);
		 PolicySubNumber.clear();
		 PolicySubNumber.sendKeys(policy[1]);
		
	 }
	 
	 public void ClickFindPolicyButton()
	 {
		 this.WaitWithVisibility(FindPolicyButton,driver);
		 try
		 {
			 FindPolicyButton.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 FindPolicyButton.click();
		 }
		// this.waitForLoading();
	 }
	 
	 public PolicySummaryPage ClickPolicyFromList(String PolicyNumber)
	 {
		 for(int i=0; i<PolicyList.size(); i++)
			{
			if(PolicyList.get(i).getText().equals(PolicyNumber))
			{
				PolicyList.get(i).click();
				break;
			}
			}	
		 return new PolicySummaryPage(this.driver);
	 } 
	 

	 
	 public void waitForLoading()
	 {
		 try{
		 wait.until(ExpectedConditions.visibilityOfAllElements(LoadingIcon));
		 wait.until(ExpectedConditions.invisibilityOfAllElements(LoadingIcon));
		 }
		 catch(Exception e)
		 {
			 
		 }
	 }	
}
