package NITICPOM;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BasePage.BasePage;

public class QuoteSummaryPage extends BasePage
{

	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__QuoteNumber")WebElement QuoteNumber;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__QuoteType")WebElement QuoteType;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__QuoteStatus")WebElement QuoteStatus;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__EffectiveDate")WebElement EffectiveDate;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__ExpirationDate")WebElement ExpirationDate;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__Liability__TotalPremium")WebElement LiabilityTotalPremium;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__PhyscialDamage__TotalPremium")WebElement PhyscialDamageTotalPremium;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__TotalPremium")WebElement TotalPremium;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__TotalDownPayment")WebElement TotalDownPayment;
	@FindBy(id="QuoteHeaderTile:QuoteHeaderForm:Object__Quote__TotalMonthlyPayment")WebElement TotalMonthlyPayment;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__AdditionalInsured__Zipcode")WebElement Zipcode;
	@FindBy(id="AdditionalInsuredTile:AdditionalInsured:Object__Insured__AdditionalInsured__Description")WebElement AdditionalInsuredDescription;
	@FindBy(xpath="//button[contains(.,'Lapse Quote')]")WebElement LapseQuote;
	@FindBy(xpath="//button[contains(.,'Offer Quote')]")WebElement OfferQuote;
	//Coverage information details
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__VehicleCount")WebElement VehicleCount;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__BusinessType")WebElement BusinessType;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__LimitType")WebElement LimitType;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__PrimaryLiabilityLimit")WebElement PrimaryLiabilityLimit;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__PIPLimit")WebElement PIPLimit;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__PedestrianPIPLimit")WebElement PedestrianPIPLimit;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__UninsuredMotoristLimit")WebElement UninsuredMotoristLimit;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:j_idt2729:Object__Quote__Liability__PremiumPerVehicle")WebElement PremiumPerVehicle;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Liability__TotalLiabilityPremium")WebElement TotalLiabilityPremium;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__BaseLayer")WebElement BaseLayer;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__Liability__StockFee")WebElement StockFee;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:j_idt2761:Object__Quote__Liability__DownPayment")WebElement DownPayment;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:j_idt2769:Object__Quote__Liability__MonthlyPayment")WebElement MonthlyPayment;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:j_idt2777:Object__Quote__Liability__ProducerCommission")WebElement ProducerCommission;
	@FindBy(id="QuoteContentTile:QuoteCoverageInformationForm:Object__Quote__AdjustmentReason")WebElement AdjustmentReason;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Shareholder')]")WebElement Shareholder;
	@FindBy(xpath="//span[contains(.,'Yes')]")List<WebElement> OfferQuoteYes;
	@FindBy(xpath="//span[contains(.,'No')]")WebElement OfferQuoteNo;
	@FindBy(xpath="//button[contains(.,'Quote Summary')]")WebElement QuoteSummary; 
	@FindBy(xpath="//button[contains(.,'Documents')]")WebElement Documents;
	@FindBy(xpath="//button[contains(.,'Issue Policy')]")WebElement IssuePolicy;
	@FindBy(xpath="//span[contains(.,'Yes')]")List<WebElement> IssuePolicyYes;
	@FindBy(xpath="//span[contains(.,'No')]")WebElement IssuePolicyeNo;
	
	
	
	public QuoteSummaryPage(WebDriver driver)
	{
		super(driver);
	}
	
	 private boolean isInitialized(boolean displayed)
	 {
		
		return QuoteNumber.isDisplayed();
	}
	 
	public String getQuoteNumber()
	 {
		 this.WaitWithVisibility(QuoteNumber,driver);
		 if(QuoteNumber.isDisplayed())
		 {
			 return QuoteNumber.getText();
		 }
		 
		 return "";
	 }
	
	public String getQuoteType()
	 {
		 this.WaitWithVisibility(QuoteType,driver);
		 if(QuoteType.isDisplayed())
		 {
			 return QuoteType.getText();
		 }
		 
		 return "";
	 }
	
	public String getQuoteStatus()
	 {
		 this.WaitWithVisibility(QuoteStatus,driver);
		 if(QuoteStatus.isDisplayed())
		 {
			 return QuoteStatus.getText();
		 }
		 
		 return "";
	 }
	
	public String getEffectiveDate()
	 {
		 this.WaitWithVisibility(EffectiveDate,driver);
		 if(EffectiveDate.isDisplayed())
		 {
			 return EffectiveDate.getText();
		 }
		 
		 return "";
	 }
	
	public String getExpirationDate()
	 {
		 this.WaitWithVisibility(ExpirationDate,driver);
		 if(ExpirationDate.isDisplayed())
		 {
			 return ExpirationDate.getText();
		 }
		 
		 return "";
	 }
	
	public String getLiabilityTotalPremium()
	 {
		 this.WaitWithVisibility(LiabilityTotalPremium,driver);
		 if(LiabilityTotalPremium.isDisplayed())
		 {
			 return LiabilityTotalPremium.getText();
		 }
		 
		 return "";
	 }
	
	public String getPhyscialDamageTotalPremium()
	 {
		 this.WaitWithVisibility(PhyscialDamageTotalPremium,driver);
		 if(PhyscialDamageTotalPremium.isDisplayed())
		 {
			 return PhyscialDamageTotalPremium.getText();
		 }
		 
		 return "";
	 }
	
	public String getTotalPremium()
	 {
		 this.WaitWithVisibility(TotalPremium,driver);
		 if(TotalPremium.isDisplayed())
		 {
			 return TotalPremium.getText();
		 }
		 
		 return "";
	 }
	
	public String getTotalDownPayment()
	 {
		 this.WaitWithVisibility(TotalDownPayment,driver);
		 if(TotalDownPayment.isDisplayed())
		 {
			 return TotalDownPayment.getText();
		 }
		 
		 return "";
	 }
	
	public String getTotalMonthlyPayment()
	 {
		 this.WaitWithVisibility(TotalMonthlyPayment,driver);
		 if(TotalMonthlyPayment.isDisplayed())
		 {
			 return TotalMonthlyPayment.getText();
		 }
		 
		 return "";
	 }
	
	public String getZipcode()
	 {
		 this.WaitWithVisibility(Zipcode,driver);
		 if(Zipcode.isDisplayed())
		 {
			 return Zipcode.getText();
		 }
		 
		 return "";
	 }
	
	public String getAdditionalInsuredDescription()
	 {
		 this.WaitWithVisibility(AdditionalInsuredDescription,driver);
		 if(AdditionalInsuredDescription.isDisplayed())
		 {
			 return AdditionalInsuredDescription.getText();
		 }
		 
		 return "";
	 }
	
	 public void ClickLapseQuote()
	 {
		 this.WaitWithVisibility(LapseQuote,driver);
		 try
		 {
			 LapseQuote.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 LapseQuote.click();
		 }
		 this.waitForLoading();
	 }
	
	 public void ClickOfferQuote()
	 {
		 this.WaitWithVisibility(OfferQuote,driver);
		 try
		 {
			 OfferQuote.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 OfferQuote.click();
		 }
		 this.waitForLoading();
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
	  
	 public void ClickShareHolder()
	 {
		 this.WaitWithVisibility(Shareholder,driver);
		 try
		 {
			 Shareholder.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Shareholder.click();
		 }
		 this.waitForLoading();
	 }
	 
	 public void setTotalLiabilityPremium(String totalLiabilityPremium)
	 {
      
		 this.WaitWithVisibility(TotalLiabilityPremium,driver);
		 TotalLiabilityPremium.clear();
		 TotalLiabilityPremium.sendKeys(totalLiabilityPremium);	 
	 }
	 
	 public String getTotalLiabilityPremium()
	 {
      
		 this.WaitWithVisibility(TotalLiabilityPremium,driver);
		 return  TotalLiabilityPremium.getText();
	 }
	 public void setBaseLayer(String baseLayer)
	 {
		 this.WaitWithVisibility(BaseLayer,driver);
		 BaseLayer.clear();
		 BaseLayer.sendKeys(baseLayer);	 
	 }
	
	 
	 public DocumentsPage ClickOfferQuoteYes()
	 {
		 for(int i=0; i<OfferQuoteYes.size(); i++)
			{
			if(OfferQuoteYes.get(i).getText().equals("Yes"))
			{
				OfferQuoteYes.get(i).click();
				break;
			}
			}	
		 return new DocumentsPage(this.driver);
	  }
	 
	
	 public void ClickQuoteSummary()
	 {
		 this.WaitWithVisibility(QuoteSummary,driver);
		 try
		 {
			 QuoteSummary.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 QuoteSummary.click();
		 }
		 this.waitForLoading();
	 }
	 
	 public DocumentsPage ClickDocuments()
	 {
		 this.WaitWithVisibility(Documents,driver);
		 try
		 {
			 Documents.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Documents.click();
		 }
		 return new DocumentsPage(this.driver);
	 }
	 
	 
	 public void ClickIssuePolicy()
	 {
		 this.WaitWithVisibility(IssuePolicy,driver);
		 try
		 {
			 IssuePolicy.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 IssuePolicy.click();
		 }
		 this.waitForLoading();
	 }
	 
	 public PolicySummaryPage ClickIssuePolicyYes()
	 {
		 for(int i=0; i<IssuePolicyYes.size(); i++)
			{
			if(IssuePolicyYes.get(i).getText().equals("Yes"))
			{
				IssuePolicyYes.get(i).click();
				break;
			}
			}	
		 return new PolicySummaryPage(this.driver);
	  }
	 
	 public void waitForLoading()
	 {
		 try{
		 wait.until(ExpectedConditions.visibilityOfAllElements(LoadingIcon));
		 }
		 catch(Exception e)
		 {
			 
		 }
	 }
	 
	 public void getDetailsFromQuoteSummary(LinkedHashMap<String, String> outputrow)
	 {
		 
		 
		 outputrow.put("QuoteNumber", this.getQuoteNumber());
		 outputrow.put("LiabilityTotalPremium", this.getLiabilityTotalPremium());
		 outputrow.put("TotalPremium", this.getTotalPremium());
		 outputrow.put("TotalDownPayment", this.getTotalDownPayment());
		 outputrow.put("TotalMonthlyPayment", this.getTotalMonthlyPayment());
		// outputrow.put("QuoteNumber", this.getQuoteNumber());
	 }
	 
	public void EditCoverageDetails(LinkedHashMap<String, String> inputrow)
	{
		String PrimaryLiabilityLimit=inputrow.get("PrimaryLiabilityLimit");
		if(inputrow.get("EditLiabilityPremium").equals("Yes")&&PrimaryLiabilityLimit.equals("$300,000")||PrimaryLiabilityLimit.equals("$125,000 / $250,000 / $50,000")||PrimaryLiabilityLimit.equals("$1,500,000")||
				PrimaryLiabilityLimit.equals("$1,000,000")||PrimaryLiabilityLimit.equals("$100,000 / $300,000 / $50,000")||PrimaryLiabilityLimit.equals("$250,000 / $500,000 / $50,000")||PrimaryLiabilityLimit.equals("$500,000"))

		{
			this.setTotalLiabilityPremium(inputrow.get("TotalLiabilityPremium"));
			this.setBaseLayer(inputrow.get("TotalLiabilityPremium"));
			
		}
		
		if(inputrow.get("EditLiabilityPremium").equals("Yes")&&PrimaryLiabilityLimit.equals("$300,000")||PrimaryLiabilityLimit.equals("$125,000 / $250,000 / $50,000")||PrimaryLiabilityLimit.equals("$1,500,000")||
				PrimaryLiabilityLimit.equals("$1,000,000")||PrimaryLiabilityLimit.equals("$100,000 / $300,000 / $50,000")||PrimaryLiabilityLimit.equals("$250,000 / $500,000 / $50,000")||PrimaryLiabilityLimit.equals("$500,000"))
		{
			String BasePremium=this.getTotalLiabilityPremium();
			this.setBaseLayer(BasePremium);
		}
		this.ClickSave();
	}
}
