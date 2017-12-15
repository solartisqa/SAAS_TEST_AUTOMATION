package NITICPOM;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BasePage.BasePage;

public class FindQuotePage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(id="FindQuote:FindQuoteForm:Object__Quote__QuoteNumber")WebElement QuoteNumber;
	@FindBy(id="FindQuote:FindQuoteForm:FindQuoteButton")WebElement FindQuoteButton;
	@FindBy(xpath="//tbody[@id='FindQuote:FindQuoteForm:dtable_data']//td/a")List<WebElement> QuoteList;
	
	
	
	 public FindQuotePage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 private boolean isInitialized(boolean displayed)
	 {
		
		return QuoteNumber.isDisplayed();
	}
	 
	 public void setQuoteNumber(String quoteNumber)
	 {
		 this.WaitWithVisibility(QuoteNumber,driver);
		 QuoteNumber.clear();
		 QuoteNumber.sendKeys(quoteNumber);
		
	 }
	 
	 public void ClickFindQuoteButton()
	 {
		 this.WaitWithVisibility(FindQuoteButton,driver);
		 try
		 {
			 FindQuoteButton.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 FindQuoteButton.click();
		 }
		// this.waitForLoading();
	 }
	 
	 public QuoteSummaryPage ClickQuoteFromList(String quotenumber)
	 {
		 for(int i=0; i<QuoteList.size(); i++)
			{
			if(QuoteList.get(i).getText().equals(quotenumber))
			{
				QuoteList.get(i).click();
				break;
			}
			}	
		 return new QuoteSummaryPage(this.driver);
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

