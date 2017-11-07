package StarrAssistPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentInformationPage 
{
	private WebDriver driver;
	
	 @FindBy(id="Payment:PaymentInformation:Object__PaymentDetail__PaymentMethod")WebElement PaymentMethod;
	 @FindBy(id="Payment:PaymentInformation:Object__CardDetail__CardType")WebElement CardType;
	 @FindBy(id="Payment:PaymentInformation:Object__CardDetail__CardNumber")WebElement CardNumber;
	 @FindBy(id="Payment:PaymentInformation:Object__Common__Card__ExpiryMonth")WebElement ExpiryMonth;
	 @FindBy(id="Payment:PaymentInformation:Object__Common__Card__ExpiryYear")WebElement ExpiryYear;
	 @FindBy(id="Payment:PaymentInformation:Object__CardDetail__Cvv")WebElement Cvv;
	 @FindBy(id="Payment:PaymentInformation:Object__Traveler1Address")WebElement Traveler1Address;
	 @FindBy(id="Payment:PaymentInformation:Object__Common__Contact__ConfirmEmail")WebElement ConfirmEmail;
	 @FindBy(id="Payment:PaymentInformation:check")WebElement check;
	 @FindBy(id="Payment:PaymentInformation:pay")WebElement pay;
	 @FindBy(id="PolicyInformation:PolicyBatchNumber")WebElement PolicyBatchNumber;
	
	
	
	 public PaymentInformationPage(WebDriver driver)
	 {
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void selectPaymentMethod(String paymentMethod)
	 {
		 Select dropdown = new Select(PaymentMethod);
		 dropdown.selectByVisibleText(paymentMethod);
		
	 }
	 public void selectCardType(String cardType)
	 {
		 Select dropdown = new Select(CardType);
		 dropdown.selectByVisibleText(cardType);
		
	 }
	 public void setCardNumber(String cardNumber)
	 {
		 CardNumber.sendKeys(cardNumber);
	 } 
	 
	 public void selectExpiryMonth(String expiryMonth)
	 {
		 Select dropdown = new Select(ExpiryMonth);
		 dropdown.selectByVisibleText(expiryMonth);
		
	 }
	 public void selectExpiryYear(String expiryYear)
	 {
		 Select dropdown = new Select(ExpiryYear);
		 dropdown.selectByVisibleText(expiryYear);
		
	 }
	 
	 public void setCvv(String cvv)
	 {
		 Cvv.sendKeys(cvv);
	 } 
	 
	 public void ClickSave()
	 {
		 Traveler1Address.click();
	 }
	 
	 public void ClickTraveler1Address()
	 {
		 Traveler1Address.click();
	 }
	 public void setConfirmEmail(String confirmEmail)
	 {
		 ConfirmEmail.sendKeys(confirmEmail);
	 } 
	 public void Clickcheck()
	 {
		 check.click();
	 }
	 public String getBatchNumber()
	 {
		 String batchNumber=PolicyBatchNumber.getText();
		 return batchNumber;
	 }
	 public PolicyInformationPage Clickpay()
	 {
		 pay.click();
		 return new PolicyInformationPage(this.driver);
	 }
	
}
