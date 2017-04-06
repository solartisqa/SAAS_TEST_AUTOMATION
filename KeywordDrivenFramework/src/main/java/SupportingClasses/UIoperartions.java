package SupportingClasses;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;


public class UIoperartions extends browserLaunching {
	
	 protected String inputValue;
	 protected String outputValue;
	 public WebElement element;
	
//**************************************UI operations***************************************************************************
public void perform(String p,String operation,String objectType,String value,String dbcolumn_name,String dataFlag,databaseOperartions input,databaseOperartions output,String waitingTime) throws SQLException, IOException
{
	long waitingTimeinseconds=Long.parseLong(waitingTime);
	
	//System.out.println("waitingtime"+waitingTimeinseconds);
	wait = new WebDriverWait(driver, waitingTimeinseconds);
	
try
{
switch (operation.toUpperCase())
{
//-------------------------------click operation-------------------------------------------------------------------------------
case "CLICK": 
        this.click(p, objectType);
        break;
 //---------------------------------------SET TEXT-----------------------------------------------------------------------       
 case "SETTEXT":
         inputValue=this.getInputValue(dataFlag, input, value, dbcolumn_name);
     	 this.setTextWithEnter(p, objectType,inputValue);
         break;  		 
 //------------------------------------------------GO TO URL--------------------------------------------------------------------------    
 case "GOTOURL":	 
		 inputValue = value;
         this.goToURL(inputValue); 
         break;
 //-------------------------------------------------------GET ATTRIBUTE-------------------------------------------------------------	 
 case "GETATTRIBUTE":
	     outputValue=this.getValueByAttribute(p, objectType);
	     output.write_data(dbcolumn_name, outputValue);
	     output.update_row();
         break;
 //------------------------------------------------------GET TEXT----------------------------------------------------------------------                 
 case "GETTEXT":
	     outputValue=this.getValueByText(p, objectType);
	     output.write_data(dbcolumn_name, outputValue);
	     output.update_row();
	     break;
  //----------------------------------------------------SELECT OPERATION------------------------------------------------------------------------- 
 case "SELECT":
	     inputValue = this.getInputValue(dataFlag, input, value, dbcolumn_name);
	     this.select(p, objectType, inputValue);
	     break;
//--------------------------------------------------MOUSE HOVER---------------------------------------------------------------------------------- 
 case "MOUSEHOVER": 
	 	 this.mouseHover(p, objectType);
	 	 break;
//-----------------------------------------------AUTO COMPLETE--------------------------------------------------------------------------------------	  
case "AUTOCOMPLETE":
		 inputValue = this.getInputValue(dataFlag, input, value, dbcolumn_name);
		 this.autoComplete(p, objectType, inputValue);
		 break;
//--------------------------------------------------------------------------------------------------------------------------------       	
case "ASSERTTEXT":
	  	 inputValue = value;
	  	 this.assertText(operation, objectType, inputValue);
	  	 break; 	   
//------------------------------------------------SCREENSHOT------------------------------------------------------------------   	
case "SCREENSHOT":
    	 this.takeScreenShot();
    	 break;	   	
 //-----------------------------------------CLICK RADIO BUTTON BY ITS VALUE-------------------------------------------------------------------------------
    	   		
case "RADIOBUTTON":
	     inputValue = this.getInputValue(dataFlag, input, value, dbcolumn_name);
	     this.radioButton(p, objectType, inputValue);
		 break;
//------------------------------------------DATE PICKER-----------------------------------------------------------------------------------------
case "DATEPICKER":
		 inputValue = this.getInputValue(dataFlag, input, value, dbcolumn_name);
		 this.datePicker(p, objectType, inputValue);
         break;

//-------------------------------------------------------------WAIT FOR LOAD-----------------------------------------------------------------
case "WAITLOAD":
		    this.waitLoad(p, objectType);
		    break;
//-------------------------------------------------------CONTINUES OPERATION------------------------------------------------------------------------------	
case "CONTOPERATION":
		inputValue = this.getInputValue(dataFlag, input, value, dbcolumn_name);
		this.contSendkeysOperation(p, objectType, inputValue);
		break;
     
//--------------------------------------------------------WAITING FOR IMG INVISIBILITY----------------------------------------------------------------------------     
case "IMGIDVISIBLE":	
		
			this.waitTillInvisible(p, objectType);
		    break;
//---------------------------------------------------------Set text without enter-------------------------------------------------------------------------------------------	
case "SETTEXT_WITHOUT_ENTER":
		inputValue = this.getInputValue(dataFlag, input, value, dbcolumn_name);
		this.setTextWithoutEnter(p, objectType, inputValue);
		break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
default:
	    System.out.println("operations not  performed");
	    break;
} 
}
catch(StaleElementReferenceException e)
{
  this.perform(p, operation, objectType, value, dbcolumn_name, dataFlag, input, output, waitingTime);
}

}


 //============================================Locator Action====================================================================  
 private By getObject(String p,String objectType)
  {
    switch(objectType.toUpperCase())
    {
    case "XPATH":	
    	return By.xpath(p);
    	
    	
    case "CLASSNAME":

    	return By.className(p);
 
    	
    case "NAME":
        
    	return By.name(p);
    	
    	
    case "CSS":
    	
    	return By.cssSelector(p);
    	
    case "LINK":
    	
    	return By.linkText(p);
    
    	
    case "PARTIALLINK":
    	
    	return By.partialLinkText(p);
    		
    case "ID":
    	
    	return By.id(p);
    	 	
   default:
	   
	   System.out.println("wrong object type");
	   return null;
	   
    }
	   
    }
  //========================================================Methods of UI oprations=============================================================
    
  protected void click(String p,String objectType) throws StaleElementReferenceException
  {  
	  	this.waitWithClickable(p, objectType);
	  	element = driver.findElement(this.getObject(p,objectType));
	  	element.click(); 	
  }
    
   protected void setTextWithEnter(String p,String objectType,String inputValue) throws StaleElementReferenceException
   {
	   	this.waitWithClickable(p, objectType);
	   	element = driver.findElement(this.getObject(p,objectType));
	   	element.clear();
	   	element.sendKeys(Keys.ENTER);
	   	element.sendKeys(inputValue);
	   	element.sendKeys(Keys.ENTER);	
   }
   
   protected void setTextWithoutEnter(String p,String objectType,String inputValue) throws StaleElementReferenceException
   {
	   	this.waitWithClickable(p, objectType);
	   	element = driver.findElement(this.getObject(p,objectType));
	   	element.clear();
	   	element.sendKeys(inputValue);
   }
    
    
 protected void goToURL(String inputURL )
 {
	 	driver.get(inputValue); 	
 }
    
 protected String getValueByText(String p,String objectType) throws StaleElementReferenceException
 {
	   	this.waitWithoutClickable(p, objectType);
	   	element = driver.findElement(this.getObject(p,objectType));
	   	String label=element.getText();
	   	return label;
 }
 protected String getValueByAttribute(String p,String objectType) throws StaleElementReferenceException
 {
	 	this.waitWithoutClickable(p, objectType);
	 	element = driver.findElement(this.getObject(p,objectType));
	 	String label=element.getAttribute("value"); 
	 	return label;
 }
 
 protected void select(String p,String objectType,String inputValue) throws StaleElementReferenceException
 {
	    this.waitWithClickable(p, objectType);
	    element = driver.findElement(this.getObject(p,objectType));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(inputValue);
 }
 
 protected void mouseHover(String p,String objectType) throws StaleElementReferenceException
 {
	    this.waitWithClickable(p, objectType);
	    element = driver.findElement(this.getObject(p,objectType));
	    Actions mouse_hover = new Actions(driver);
		mouse_hover.moveToElement(element).build().perform();
 }
 
 protected void autoComplete(String p,String objectType,String inputValue) throws StaleElementReferenceException
 {
	 	this.waitWithClickable(p, objectType);
	 	element = driver.findElement(this.getObject(p,objectType));
	 	element.sendKeys(inputValue);
	 	element.sendKeys(Keys.DOWN);
	 	element.sendKeys(Keys.ENTER);
 }
 
 
 protected void waitWithClickable(String p,String objectType) 
 {
	 	wait.until(ExpectedConditions.presenceOfElementLocated(this.getObject(p,objectType)));
	 	wait.until(ExpectedConditions.elementToBeClickable(this.getObject(p,objectType)));
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(this.getObject(p,objectType)));
 }
 
 protected void waitWithoutClickable(String p,String objectType)
 {
	    wait.until(ExpectedConditions.presenceOfElementLocated(this.getObject(p,objectType)));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(this.getObject(p,objectType)));
 }
 
protected void radioButton(String p,String objectType,String inputValue) throws StaleElementReferenceException
{
		this.waitWithClickable(p, objectType);
		List<WebElement> RadButtonList =driver.findElements(this.getObject(p,objectType));
			for(int i=0; i< RadButtonList.size() ; i++)
			{
				//System.out.println(((WebElement) RadButtonList.get(i)).getAttribute("value"));
			if(((WebElement) RadButtonList.get(i)).getAttribute("value").equals(inputValue))
			{
				System.out.println("radio button clicked");
			   ((WebElement) RadButtonList.get(i)).click();	
			}
			}	
}
 
 protected void datePicker(String p,String objectType,String inputValue) throws StaleElementReferenceException
 {
	 	this.waitWithClickable(p, objectType);
	 	element = driver.findElement(this.getObject(p,objectType));
	 	element.clear();
	 	element.sendKeys(inputValue);
	 	element.sendKeys(Keys.ENTER);
 }
 
 protected void contSendkeysOperation(String p,String objectType,String inputValue) 
 {
	 	this.waitWithClickable(p, objectType);
	 	element = driver.findElement(this.getObject(p,objectType));
	 	Actions builder = new Actions(driver);
	 	Actions seriesOfActions = builder.moveToElement(element).click().sendKeys(element, inputValue);
	 	seriesOfActions.perform();
 }
 
 protected void waitTillInvisible(String p,String objectType)
 {
	 try{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(this.getObject(p,objectType)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(this.getObject(p,objectType)));
	 }
	 catch(TimeoutException e)
	 {
		 
	 }
 }
 protected void waitLoad(String p,String objectType) 
 {
	    this.waitWithClickable(p, objectType);
	    element = driver.findElement(this.getObject(p,objectType));
		element.isDisplayed();
 }
 
 protected  boolean assertText(String p,String objectType,String expectedText)
 {
	   	boolean status = false;
	   	this.waitWithoutClickable(p, objectType);
	   	element = driver.findElement(this.getObject(p,objectType));
	   	String actualText = element.getText();
	   	if(actualText.equals(expectedText))
	   	{
		   status=true;
	   	}
	   	return status;
 }
  
 protected void takeScreenShot() throws SQLException, IOException
 {
	 	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	FileUtils.copyFile(scrFile, new File("D:\\Exception\\screenshots\\"+".png"));	
   	 
 }
 
 protected String getInputValue(String dataFlag,databaseOperartions input,String value,String dbcolumn_name) throws SQLException
 {
	 switch(dataFlag)
	 	{
	 		case "Read":
	 			inputValue = input.read_data(dbcolumn_name);
	 			break;
    		
	 		case "Default":	
	 			inputValue = value;
	 			break;
	 	}
	 	return inputValue;
 }







    
}
