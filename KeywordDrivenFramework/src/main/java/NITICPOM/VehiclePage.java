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

public class VehiclePage extends BasePage
{
	private WebDriver driver;
	@FindBy(xpath="//div/div/img[@class='loading_icon']")List<WebElement> LoadingIcon;
	@FindBy(xpath="//button[contains(.,'Add Vehicle')]")WebElement AddVehicle;
	@FindBy(xpath="//div[@id='VehiclesTile:VehicleDetailsAddForm:Object__Vehicle__GaragingAddress__SameAsBusinessAddress']//span")List<WebElement> SameAsBusinessAddress;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__VIN")WebElement VehicleVIN;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__Make")WebElement VehicleMake;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__Model")WebElement VehicleModel;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__Year")WebElement VehicleYear;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__SeatingCapacity")WebElement VehicleSeatingCapacity;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__BodyType")WebElement VehicleBodyType;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__VehicleValue")WebElement VehicleValue;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__GrossWeight")WebElement GrossWeight;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__Radius")WebElement Radius;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__RegistrationState")WebElement RegistrationState;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__BusinessUse")WebElement BusinessUse;
	@FindBy(xpath="//div[@id='VehiclesTile:VehicleDetailsAddForm:Object__Risk__Vehicle__IsLossPayee']//span")List<WebElement> IsLossPayee;
	@FindBy(xpath="//button[contains(.,'Save')]")WebElement Save;
	@FindBy(xpath="//button[contains(.,'Cancel')]//span")WebElement Cancel;
	@FindBy(xpath="//button[contains(.,'Add Loss Payee')]")WebElement AddLossPayee;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Vehicle__LossPayee__Type")WebElement LossPayeeType;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Vehicle__LossPayee__Name")WebElement LossPayeeName;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:Object__Risk__RiskID")WebElement VehicleNumber;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:LossPayeeAddressPanelForm:Object__Vehicle__LossPayee__AddressLookup")WebElement AddressLookup;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:LossPayeeAddressPanelForm:Object__Vehicle__LossPayee__Address1")WebElement Address1;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:LossPayeeAddressPanelForm:Object__Vehicle__LossPayee__Address2")WebElement Address2;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:LossPayeeAddressPanelForm:Object__Vehicle__LossPayee__City")WebElement City;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:LossPayeeAddressPanelForm:Object__Vehicle__LossPayee__StateRegionCode")WebElement State;
	@FindBy(id="VehiclesTile:VehicleDetailsAddForm:LossPayeeAddressPanelForm:Object__Vehicle__LossPayee__Zipcode")WebElement Zipcode;
	@FindBy(xpath="//button[contains(.,'Driver')]")WebElement Driver;
	
	
	public VehiclePage(WebDriver driver)
	{
		 this.driver=driver;
		 if(driver==null)
		 {
			 System.out.println("driver is null in get a Quote page");
		 }
		 PageFactory.initElements(driver, this);
	}
	
	 public void ClickAddVehicle()
	 {
		 this.WaitWithVisibility(AddVehicle,driver);
		 try
		 {
			 AddVehicle.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AddVehicle.click();
		 }
		 this.waitForLoading();
		
	 }
	
	
	 public void ClickSameAsBusinessAddress(String Option)
	 {
		 for(int i=0; i<SameAsBusinessAddress.size(); i++)
			{
			if(SameAsBusinessAddress.get(i).getText().equals(Option))
			{
				SameAsBusinessAddress.get(i).click();
				break;
			}
			}	
	 }
	
	 public void setVehicleVIN(String vehicleVIN)
	 {
		 try
		 {
		 this.WaitWithVisibility(VehicleVIN,driver);
		 VehicleVIN.clear();
		 VehicleVIN.sendKeys(vehicleVIN);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 this.WaitWithVisibility(VehicleVIN,driver);
			 VehicleVIN.clear();
			 VehicleVIN.sendKeys(vehicleVIN);
		 }
	 }	 
		
	 public void setVehicleMake(String vehicleMake)
		 {
			 try
			 {
			 this.WaitWithVisibility(VehicleMake,driver);
			 VehicleMake.clear();
			 VehicleMake.sendKeys(vehicleMake);
			 }
			 catch(StaleElementReferenceException e)
			 {
				 this.WaitWithVisibility(VehicleMake,driver);
				 VehicleMake.clear();
				 VehicleMake.sendKeys(vehicleMake);
			 }
		}
	 
	 
		public void setVehicleModel(String vehicleModel)
		{
			 try
			 {
			 this.WaitWithVisibility(VehicleModel,driver);
			 VehicleModel.clear();
			 VehicleModel.sendKeys(vehicleModel);
			 }
			 catch(StaleElementReferenceException e)
			 {
				 this.WaitWithVisibility(VehicleModel,driver);
				 VehicleModel.clear();
				 VehicleModel.sendKeys(vehicleModel);
			 }	
		}
				 
		public void setVehicleYear(String vehicleYear)
	     {
			 try
			 {
			 this.WaitWithVisibility(VehicleYear,driver);
			 VehicleYear.clear();
			 VehicleYear.sendKeys(vehicleYear);
			 }
			 catch(StaleElementReferenceException e)
			 {
				 this.WaitWithVisibility(VehicleYear,driver);
				 VehicleYear.clear();
				 VehicleYear.sendKeys(vehicleYear);
			}		
	     }
					
		public void setVehicleSeatingCapacity(String vehicleSeatingCapacity)
		{
			 try
			 {
			 this.WaitWithVisibility(VehicleSeatingCapacity,driver);
			 VehicleSeatingCapacity.clear();
			 VehicleSeatingCapacity.sendKeys(vehicleSeatingCapacity);
			 }
			 catch(StaleElementReferenceException e)
			 { 
			this.WaitWithVisibility(VehicleSeatingCapacity,driver);
			 VehicleSeatingCapacity.clear();
			 VehicleSeatingCapacity.sendKeys(vehicleSeatingCapacity);
			 }		
		}
		
	    public void selectVehicleBodyType(String vehicleBodyType)
		 {
			 this.WaitWithVisibility(VehicleBodyType,driver);
			 try
			 {
			 Select dropdown = new Select(VehicleBodyType);
			 dropdown.selectByVisibleText(vehicleBodyType);
			 }
			 catch(StaleElementReferenceException e)
			 {
			 Select dropdown = new Select(VehicleBodyType);
			 dropdown.selectByVisibleText(vehicleBodyType);
			 }
		 }
		 
		 
		 
	public void setVehicleValue(String vehicleValue)
     {
		 try
		 {
		 this.WaitWithVisibility(VehicleValue,driver);
		 VehicleValue.clear();
		 VehicleValue.sendKeys(vehicleValue);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 this.WaitWithVisibility(VehicleValue,driver);
			 VehicleValue.clear();
			 VehicleValue.sendKeys(vehicleValue);
		}		
     }
	
	 
	public void setGrossWeight(String grossWeight)
	{
		 try
		 {
		 this.WaitWithVisibility(VehicleYear,driver);
		 GrossWeight.clear();
		 GrossWeight.sendKeys(grossWeight);
		 }
		 catch(StaleElementReferenceException e)
		 {
		  this.WaitWithVisibility(VehicleYear,driver);
		  GrossWeight.clear();
		  GrossWeight.sendKeys(grossWeight);
		}		
	}

	public void setRadius(String radius)
	{
	try
	{
	this.WaitWithVisibility(Radius,driver);
	Radius.clear();
	Radius.sendKeys(radius);
	}
	catch(StaleElementReferenceException e)
	{
	 this.WaitWithVisibility(Radius,driver);
	 Radius.clear();
	 Radius.sendKeys(radius);
	}		
	}
	
	 public void selectRegistrationState(String registrationState)
	 {
		 this.WaitWithVisibility(RegistrationState,driver);
		 try
		 {
		 Select dropdown = new Select(RegistrationState);
		 dropdown.selectByVisibleText(registrationState);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(RegistrationState);
			 dropdown.selectByVisibleText(registrationState);
		 }
	 }
	 
	 public void selectBusinessUse(String businessUse)
	 {
		 this.WaitWithVisibility(BusinessUse,driver);
		 try
		 {
		 Select dropdown = new Select(BusinessUse);
		 dropdown.selectByVisibleText(businessUse);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(BusinessUse);
			 dropdown.selectByVisibleText(businessUse);
		 }
	 }
	
	 public void ClickIsLossPayee(String Option)
	 {
		 for(int i=0; i<IsLossPayee.size(); i++)
			{
			if(IsLossPayee.get(i).getText().equals(Option))
			{
				IsLossPayee.get(i).click();
				break;
			}
			}	
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
	
	 public void ClickCancel()
	 {
		IsLossPayee.get(0).click();
		
	 }
	 
	 
	 public void ClickAddLossPayee()
	 {
		 this.WaitWithVisibility(AddLossPayee,driver);
		 try
		 {
			 AddLossPayee.click();
		 }
		 catch(StaleElementReferenceException e)
		 {
			 AddLossPayee.click();
		 }
		 this.waitForLoading();
		
	 }
	 
	  
	 public void selectLossPayeeType(String lossPayeeType)
	 {
		 this.WaitWithVisibility(LossPayeeType,driver);
		 try
		 {
		 Select dropdown = new Select(LossPayeeType);
		 dropdown.selectByVisibleText(lossPayeeType);
		 }
		 catch(StaleElementReferenceException e)
		 {
			 Select dropdown = new Select(LossPayeeType);
			 dropdown.selectByVisibleText(lossPayeeType);
		 }
	 }
	  
		public void setLossPayeeName(String lossPayeeName)
		{
		try
		{
		this.WaitWithVisibility(LossPayeeName,driver);
		LossPayeeName.clear();
		LossPayeeName.sendKeys(lossPayeeName);
		}
		catch(StaleElementReferenceException e)
		{
			this.WaitWithVisibility(LossPayeeName,driver);
			LossPayeeName.clear();
			LossPayeeName.sendKeys(lossPayeeName);	
		}		
		}
		
		
		public void selectVehicleNumber(String vehicleNumber)
		 {
			 this.WaitWithVisibility(VehicleNumber,driver);
			 try
			 {
			 Select dropdown = new Select(VehicleNumber);
			 dropdown.selectByVisibleText(vehicleNumber);
			 }
			 catch(StaleElementReferenceException e)
			 {
				 Select dropdown = new Select(VehicleNumber);
				 dropdown.selectByVisibleText(vehicleNumber);
			 }
		 }
		
		public void setAddressLookup(String addressLookup)
		{
		try
		{
		this.WaitWithVisibility(AddressLookup,driver);
		AddressLookup.clear();
		AddressLookup.sendKeys(addressLookup);
		}
		catch(StaleElementReferenceException e)
		{
			this.WaitWithVisibility(AddressLookup,driver);
			AddressLookup.clear();
			AddressLookup.sendKeys(addressLookup);
		}	
		
		}
		public void setAddress1(String address1)
		{
		try
		{
		this.WaitWithVisibility(Address1,driver);
		Address1.clear();
		Address1.sendKeys(address1);
		}
		catch(StaleElementReferenceException e)
		{
			this.WaitWithVisibility(Address1,driver);
			Address1.clear();
			Address1.sendKeys(address1);
		}		
		}
		
		public void setAddress2(String address1)
		{
		try
		{
		this.WaitWithVisibility(Address2,driver);
		Address2.clear();
		Address2.sendKeys(address1);
		}
		catch(StaleElementReferenceException e)
		{
			this.WaitWithVisibility(Address2,driver);
			Address2.clear();
			Address2.sendKeys(address1);
		}		
		}
		
		public void setCity(String city)
		{
		try
		{
		this.WaitWithVisibility(City,driver);
		City.clear();
		City.sendKeys(city);
		}
		catch(StaleElementReferenceException e)
		{
			this.WaitWithVisibility(City,driver);
			City.clear();
			City.sendKeys(city);
		}		
		}
		
		public void setLossPayeeState(String state)
		{
		try
		{
		this.WaitWithVisibility(State,driver);
		State.clear();
		State.sendKeys(state);
		}
		catch(StaleElementReferenceException e)
		{
			this.WaitWithVisibility(State,driver);
			State.clear();
			State.sendKeys(state);
		}		
		}
		
		public void selectLossPayeeState(String state)
		 {
			 this.WaitWithVisibility(State,driver);
			 try
			 {
			 Select dropdown = new Select(State);
			 dropdown.selectByVisibleText(state);
			 }
			 catch(StaleElementReferenceException e)
			 {
				 Select dropdown = new Select(State);
				 dropdown.selectByVisibleText(state);
			 }
		 }
		
		public void setLossPayeeZipCode(String zipcode)
		{
		try
		{
		this.WaitWithVisibility(Zipcode,driver);
		Zipcode.clear();
		Zipcode.sendKeys(zipcode);
		}
		catch(StaleElementReferenceException e)
		{
		 this.WaitWithVisibility(Radius,driver);
		 Radius.clear();
		 Radius.sendKeys(zipcode);
		}		
		}
		
		
		 public DriverPage ClickDriver()
		 {
			 this.WaitWithVisibility(Driver,driver);
			 try
			 {
				 Driver.click();
			 }
			 catch(StaleElementReferenceException e)
			 {
				 Driver.click();
			 }
			 this.waitForLoading();
			 return new DriverPage(this.driver);
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
	 
	public void FillVehicleDetails(LinkedHashMap<String, String> inputrow)
	{
		 this.ClickAddVehicle();
		 this.setVehicleVIN(inputrow.get("VIN"));
		 this.setVehicleMake(inputrow.get("Make"));
		 this.setVehicleModel(inputrow.get("Model"));
		 this.setVehicleYear(inputrow.get("Year"));
		 this.setVehicleSeatingCapacity(inputrow.get("SeatingCapacity"));
		 this.selectVehicleBodyType(inputrow.get("BodyType"));
		 this.setVehicleValue(inputrow.get("VehicleValue"));
		 this.setGrossWeight(inputrow.get("RadiusOfOperation"));
		 this.selectRegistrationState(inputrow.get("State"));
		 this.selectBusinessUse(inputrow.get("BusinessUse"));
		 this.ClickIsLossPayee(inputrow.get("LossPayee1"));
		 this.ClickSave();
	}
	 
	public void FillLossPayeeDetails(LinkedHashMap<String, String> inputrow)
	{
		 this.ClickAddLossPayee();
		 this.selectLossPayeeType(inputrow.get("LossPayee__Type"));
		 this.setLossPayeeName(inputrow.get("LossPayeeName"));
		 this.selectVehicleNumber(inputrow.get("VehicleNumber"));
		 this.setAddress1(inputrow.get("AddressLine1"));
		 this.setCity(inputrow.get("City"));
		 this.selectLossPayeeState(inputrow.get("State"));
		 this.setLossPayeeZipCode(inputrow.get("ZipCode"));
		 this.ClickSave();		
	}
	 
	 
}
