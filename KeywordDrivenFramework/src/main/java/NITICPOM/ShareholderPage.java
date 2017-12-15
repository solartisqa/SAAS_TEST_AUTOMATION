package NITICPOM;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class ShareholderPage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(xpath="//div[@id='ShareHolderInfoTile:ShareHolderInformation:Addbutton']//button/span[contains(.,'Add Shareholder')]")WebElement AddShareHolder;
	@FindBy(id="ShareHolderInfoTile:ShareHolderInformation:Object__ShareHolder__Name")WebElement ShareHolderName;
	@FindBy(id="ShareHolderInfoTile:ShareHolderInformation:Object__ShareHolder__LastName")WebElement ShareHolderLastName;
	@FindBy(id="ShareHolderInfoTile:ShareHolderInformation:Object__ShareHolder__Salutation")WebElement ShareHolderSalutation;
	@FindBy(id="ShareHolderInfoTile:ShareHolderInformation:Object__ShareHolder__Title")WebElement ShareHolderTitle;
    @FindBy(id="ShareHolderInfoTile:ShareHolderInformation:Object__ShareHolder__SocialSecurityNumber")WebElement ShareHolderSSN;
    @FindBy(xpath="//span[@id='ShareHolderInfoTile:ShareHolderInformation:buttonSave']//button")WebElement Save;
    @FindBy(xpath="//button[contains(.,'Prior Carrier ')]")WebElement PriorCarrier;
    @FindBy(xpath="//button[contains(.,'Create Quote')]")WebElement CreateQuote;
    @FindBy(xpath="//div[@id='ShareHolderInfoTile:ShareHolderInformation:Object__Quote__QuoteType']//span")List<WebElement> QuoteType;
	
	public ShareholderPage(WebDriver driver)
	{
		super(driver);
	}
	
	 private boolean isInitialized(boolean displayed)
	 {
		
		return AddShareHolder.isDisplayed();
	}
	 
	
	 public void ClickAddShareHolder()
	 {
		 this.WaitWithVisibility(AddShareHolder,driver);
		 try
		 {
			 AddShareHolder.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AddShareHolder.click();
		 }
		 this.waitForLoading();
	 }
	
	 public void setShareHolderName(String shareHolderName)
	 {
		 this.WaitWithVisibility(ShareHolderName,driver);
		 ShareHolderName.clear();
		 ShareHolderName.sendKeys(shareHolderName);
		
	 }
	 
	 public void setShareHolderLastName(String shareHolderLastName)
	 {
		 this.WaitWithVisibility(ShareHolderLastName,driver);
		 ShareHolderLastName.clear();
		 ShareHolderLastName.sendKeys(shareHolderLastName);
		
	 }
	 public void selectShareHolderSalutation(String shareHolderSalutation)
	 {
		 this.WaitWithVisibility(ShareHolderSalutation,driver);
		 try
		 {
		 Select dropdown = new Select(ShareHolderSalutation);
		 dropdown.selectByVisibleText(shareHolderSalutation);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(ShareHolderSalutation);
			 dropdown.selectByVisibleText(shareHolderSalutation);
		 }
		 
	 }
	 public void setShareHolderTitle(String shareHolderTitle)
	 {
		 this.WaitWithVisibility(ShareHolderTitle,driver);
		 ShareHolderTitle.clear();
		 ShareHolderTitle.sendKeys(shareHolderTitle);
		
	 }
	 public void setShareHolderSSN(String shareHolderSSN)
	 {
		 this.WaitWithVisibility(ShareHolderSSN,driver);
		 ShareHolderSSN.clear();
		 ShareHolderSSN.sendKeys(shareHolderSSN);
		
	 }
	 
	 public void ClickSave()
	 {
		 this.WaitWithVisibility(Save,driver);
		 try
		 {
			 Save.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Save.click();
		 }
		 this.waitForLoading();
	 }
	
	 public void ClickQuoteType(String quoteType)
	 {
		 for(int i=0; i<QuoteType.size(); i++)
			{
			if(QuoteType.get(i).getText().equals(quoteType))
			{
				QuoteType.get(i).click();
				break;
			}
			}	
	 }
	 
	 public QuoteSummaryPage ClickCreateQuote()
	 {
		 this.WaitWithVisibility(CreateQuote,driver);
		 try
		 {
			 CreateQuote.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 CreateQuote.click();
		 }
		 this.waitForLoading();
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
	 
	 public void FillShareHolderDetails(LinkedHashMap<String, String> inputrow)
	 {
		 this.ClickAddShareHolder();
		 this.setShareHolderName(inputrow.get("SHFirstName"));
		 this.setShareHolderLastName(inputrow.get("SHLastName"));
		 this.selectShareHolderSalutation(inputrow.get("Salutation"));
		 this.setShareHolderTitle(inputrow.get("Title"));
		 this.setShareHolderSSN(inputrow.get("SSN_FEIN_no"));
		 this.ClickSave();
	 }
}
