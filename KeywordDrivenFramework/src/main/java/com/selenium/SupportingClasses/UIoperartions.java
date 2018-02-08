package com.selenium.SupportingClasses;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;


public class UIoperartions extends browserLaunching
{
	
	 protected String inputValue;
	 protected String outputValue;
	 public WebElement element;
	 public Document document;
	
//**************************************UI operations***************************************************************************
public void perform(String p,String operation,String objectType,String value,String dbcolumn_name,String dataFlag,LinkedHashMap<String, String> InputData,LinkedHashMap<String, String> outputData,String waitingTime) throws SQLException, IOException, InterruptedException, AWTException
{
	long waitingTimeinseconds=Long.parseLong(waitingTime);
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
         inputValue=this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
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
	     outputData.put(dbcolumn_name, outputValue);
         break;
 //------------------------------------------------------GET TEXT----------------------------------------------------------------------                 
 case "GETTEXT":
	     outputValue=this.getValueByText(p, objectType);
	     outputData.put(dbcolumn_name, outputValue);
	     break;
  //----------------------------------------------------SELECT OPERATION------------------------------------------------------------------------- 
 case "SELECT":
	     inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
	     this.select(p, objectType, inputValue);
	     break;
//--------------------------------------------------MOUSE HOVER---------------------------------------------------------------------------------- 
 case "MOUSEHOVER": 
	 	 this.mouseHover(p, objectType);
	 	 break;
//-----------------------------------------------AUTO COMPLETE--------------------------------------------------------------------------------------	  
case "AUTOCOMPLETE":
		 inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
		 this.autoComplete(p, objectType, inputValue);
		 break;
//--------------------------------------------------------------------------------------------------------------------------------       	
case "ASSERTTEXT":
	  	 inputValue = value;
	  	 this.assertText(p, objectType, inputValue);
	  	 break; 	   
//------------------------------------------------SCREENSHOT------------------------------------------------------------------   	
case "SCREENSHOT":
    	 this.takeScreenShot();
    	 break;	   	
 //-----------------------------------------CLICK RADIO BUTTON BY ITS VALUE-------------------------------------------------------------------------------
    	   		
case "RADIOBUTTON":
	     inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
	     this.radioButton(p, objectType,inputValue);
		 break;
//------------------------------------------DATE PICKER-----------------------------------------------------------------------------------------
case "DATEPICKER":
		 inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
		 this.datePicker(p, objectType, inputValue);
         break;

//-------------------------------------------------------------WAIT FOR LOAD--------------------------------------------------------------------
case "DATEPICKER_WITHOUT_ENTER":
	
	  inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
	  this.datePickerWithoutEnter(p, objectType, inputValue);
      break;
         
 //---------------------------------------------------------------------------------------------------------------------------------------        
         
case "WAITLOAD":
		   this.waitLoad(p, objectType);
		   break;
//-------------------------------------------------------CONTINUES OPERATION------------------------------------------------------------------------------	
case "CONTOPERATION":
		inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
		this.contSendkeysOperation(p, objectType, inputValue);
		break;
     
//--------------------------------------------------------WAITING FOR IMG INVISIBILITY----------------------------------------------------------------------------     
case "IMGINVISIBLE":	
		
			this.waitTillInvisible(p, objectType);
		    break;
//---------------------------------------------------------Set text without enter-------------------------------------------------------------------------------------------	
case "SETTEXT_WITHOUT_ENTER":
		inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
		this.setTextWithoutEnter(p, objectType, inputValue);
		break;
//----------------------------------------------------------Thread sleep------------------------------------------------------------------------------------------------	
case "SETTEXT_THEN_ENTER":
	
	inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
	this.setTexThenEnter(p, objectType, inputValue);
	break;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
case "WAIT":
	   Thread.sleep(waitingTimeinseconds);
       break;
       
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
case "WAITFORTEXT":
	
	element = driver.findElement(this.getObject(p,objectType));
	if(element.isEnabled() && element.isDisplayed())
	{
	String expectedText=element.getText();
	wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
	}
    break;   
 //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
case "DYNAMICDATEPICKER":
	
	inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
	this.dynamicDatePicker(p, objectType, inputValue);
	break;
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
case "DYNAMICCLICK":
	inputValue = this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
	this.dynamicClick(p, objectType, inputValue);
	break;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------
	
case "UPLOAD":
	   this.upload(value);
	   break;
	//--------------------------------------------------------------------------------------------------------------------------------------------------   
	   
case "CLICKVISIBLEELEMENT":
	this.clickVisibleElement(p, objectType);
	break;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
case "JSCLICK":
	
	this.jsClick(p, objectType);
	break;
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
       
case "SETEXTRACTEDVALUE":
	
	inputValue=this.getValueByAttribute(value, objectType);
	this.setTextWithoutEnter(p, objectType, inputValue);
	break;
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
case "WEBELEMENTLIST":
    
    inputValue=this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
    this.selectFromelementlistByValue(p, objectType, inputValue);
    break;
    
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
case "WEBELEMENTLISTBYTEXT":
    System.out.println("By text.......");
    inputValue=this.getInputValue(dataFlag, InputData, value, dbcolumn_name);
    this.selectFromelementlistByText(p, objectType, inputValue);
    break;  
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
case "DOWNLOAD":
	   this.download(value);
	   break;
	   
	//------------------------------------------------------------------------------------------------------------------------------------------------------
case "SWITCHWINDOW":
	this.switchwindow();
	break;
	   
	       
default :
	    System.out.println("operations not  performed");
	  
} 
}
catch(StaleElementReferenceException e)
{
  this.perform(p, operation, objectType, value, dbcolumn_name, dataFlag, InputData, outputData, waitingTime);
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
    	
    case "DYNAMICXPATH":
    	return By.xpath(p);	
    	 	
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
  
  //===========================================================================================================================================
  
  protected void clickVisibleElement(String p,String objectType)throws StaleElementReferenceException, InterruptedException
  {  
	  int var_ele_size= driver.findElements(this.getObject(p,objectType)).size();
	  driver.findElements(this.getObject(p,objectType)).get(var_ele_size-1).click();
	  
  }
    
  
 //=================================================================================================================================================== 
  
  protected void jsClick(String p,String objectType)
  {
	  //element = driver.findElement(this.getObject(p,objectType));
	  //JavascriptExecutor executor = (JavascriptExecutor)driver;
	  //executor.executeScript("arguments[0].click()", element);
	  Element var=document.getElementById(p);
	  ((JavascriptExecutor)driver).executeScript(var+".click();");
  }
  
  //===================================================================================================================================================
   protected void setTextWithEnter(String p,String objectType,String inputValue) throws StaleElementReferenceException
   {
	   	this.waitWithClickable(p, objectType);
	   	element = driver.findElement(this.getObject(p,objectType));
	   	element.clear();
	   	element.sendKeys(Keys.ENTER);
	   	element.sendKeys(inputValue);
	   	element.sendKeys(Keys.ENTER);	
   }
  
  //===================================================================================================================================================== 
   protected void setTextWithoutEnter(String p,String objectType,String inputValue) throws StaleElementReferenceException
   {
	   	this.waitWithClickable(p, objectType);
	   	element = driver.findElement(this.getObject(p,objectType));
	   	element.clear();
	   	element.sendKeys(inputValue);
   }
    
  //=================================================================================================================================================== 
   private void setTexThenEnter(String p, String objectType, String inputValue) 
   {
	   this.waitWithClickable(p, objectType);
	   	element = driver.findElement(this.getObject(p,objectType));
	   	element.clear();
	   	element.sendKeys(inputValue);
	   	element.sendKeys(Keys.ENTER);		
   }   
   
   
  //==================================================================================================================================================== 
 protected void goToURL(String inputURL )
 {
	 	driver.get(inputValue); 	
 }
    
 
 //======================================================================================================================================================
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
				//System.out.println("radio button clicked");
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
 
 
 private void datePickerWithoutEnter(String p, String objectType, String inputValue2)
 {
	    this.waitWithClickable(p, objectType);
	 	element = driver.findElement(this.getObject(p,objectType));
	 	element.sendKeys(inputValue);
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
	 try
	 {
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
 
 
 protected void dynamicDatePicker(String p,String objectType,String value) throws InterruptedException
 {
	 String[] objtype=objectType.split(";");
		String[] property=p.split(";");
		String[] value1=value.split("/");
		int totElements=objtype.length;
		for(int i=0;i<totElements;i++)
		{
			p=property[i];
			if(objtype[i].equalsIgnoreCase("DYNAMICXPATH"))
			{ 
				if(i==1)
				{
					p=property[i].replace("!",value1[2]);
				}
				if(i==2)
				{
			        switch (value1[0]) 
			        {
			            case "01":  value1[0] = "Jan";        break;
			            case "02":  value1[0] = "Feb";        break;
			            case "03":  value1[0] = "Mar";        break;
			            case "04":  value1[0] = "Apr";        break;
			            case "05":  value1[0] = "May";        break;
			            case "06":  value1[0] = "Jun";        break;
			            case "07":  value1[0] = "Jul";        break;
			            case "08":  value1[0] = "Aug";        break;
			            case "09":  value1[0] = "Sep";        break;
			            case "10": value1[0] = "Oct";         break;
			            case "11": value1[0] = "Nov";         break;
			            case "12": value1[0] = "Dec";         break;
			            default: value1[0] = "Invalid month"; break;
			        }
			        p=property[i].replace("!",value1[0]);
				}
				if(i==3)
				{
					switch(value1[1])
					{
					    case "01":  value1[1] = "1";        break;
			            case "02":  value1[1] = "2";        break;
			            case "03":  value1[1] = "3";        break;
			            case "04":  value1[1] = "4";        break;
			            case "05":  value1[1] = "5";        break;
			            case "06":  value1[1] = "6";        break;
			            case "07":  value1[1] = "7";        break;
			            case "08":  value1[1] = "8";        break;
			            case "09":  value1[1] = "9";        break;
			            default: value1[0] = "Invaliddate "; break;
					}
					p=property[i].replace("!",value1[1]);
				}
				 
				 //System.out.println(p);
			}
			
			driver.findElement(this.getObject(p,objtype[i])).click();
			Thread.sleep(1000);
		}
 }
 
 
 protected String getInputValue(String dataFlag,LinkedHashMap<String, String> InputData,String value,String dbcolumn_name) throws SQLException
 {
	 switch(dataFlag)
	 	{
	 		case "Read":
	 			inputValue = InputData.get(dbcolumn_name) ;
	 			break;
    		
	 		case "Default":	
	 			inputValue = value;
	 			break;
	 	}
	 //System.out.println(inputValue);
	 	return inputValue;
	 	
 }

 private void dynamicClick(String p, String objectType, String inputValue) 
 {
	    p=p.replace("#", inputValue);
	    this.waitWithClickable(p, objectType);
	  	element = driver.findElement(this.getObject(p,objectType));
	  	element.click(); 
		
 }
 
 private void upload(String inputValue) throws AWTException
 {
	    
	    StringSelection ss = new StringSelection(inputValue);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_V);
		 r.keyRelease(KeyEvent.VK_V);    
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
 }

 private void selectFromelementlistByValue(String p, String objectType, String inputValue) throws InterruptedException
 {
    List<WebElement> elementList = driver.findElements(this.getObject(p,objectType));
    String[] inputlist=inputValue.split(",");
    for(int i=0;i<inputlist.length;i++)
    {
        System.out.println("----inputlist"+inputlist.length);
        for(int j=0;j<elementList.size();j++)
        {
            System.out.println("------elementlist"+elementList.size());
            System.out.println("-------RHS"+inputlist[i]);
            System.out.println("-------lHS"+elementList.get(j).getAttribute("value"));
         if(elementList.get(j).getAttribute("value").equals(inputlist[i]))
           // if(elementList.get(j).getText().equals(inputlist[i]))
            {
                System.out.println("condition satisfied in if loop");
                Thread.sleep(1000);
                
                elementList.get(j).click();
                break;
            }
        }
    }
 }
    private void selectFromelementlistByText(String p, String objectType, String inputValue) throws InterruptedException
    {
       List<WebElement> elementList = driver.findElements(this.getObject(p,objectType));
       String[] inputlist=inputValue.split(",");
       for(int i=0;i<inputlist.length;i++)
       {
           System.out.println("----inputlist"+inputlist.length);
           for(int j=0;j<elementList.size();j++)
           {
               System.out.println("------elementlist"+elementList.size());
               System.out.println("-------RHS"+inputlist[i]);
               System.out.println("-------lHS"+elementList.get(j).getText());
            //if(elementList.get(j).getAttribute("value").equals(inputlist[i]))
              if(elementList.get(j).getText().equals(inputlist[i]))
               {
                   System.out.println("condition satisfied in if loop");
                   Thread.sleep(1000);
                   
                   elementList.get(j).click();
                   break;
               }
           }
       }
 }
    
    private void download(String inputValue) throws AWTException, InterruptedException
    {
   	    
   	    StringSelection ss = new StringSelection(inputValue);
   		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   	    Thread.sleep(3500);  
   		 Robot r1 = new Robot();
   		 r1.keyPress(KeyEvent.VK_CONTROL);
         
         r1.keyPress(KeyEvent.VK_V);
         
         
         r1.keyRelease(KeyEvent.VK_CONTROL);
         
         r1.keyRelease(KeyEvent.VK_V);
         
         Thread.sleep(3500);     
         r1.keyPress(KeyEvent.VK_ENTER);            
         
         r1.keyRelease(KeyEvent.VK_ENTER);
         System.out.println("Vk_Enter" +" cliecked");
    }

private void switchwindow() throws AWTException, InterruptedException
{
	String parent=driver.getWindowHandle();
	 
	// This will return the number of windows opened by Webdriver and will return Set of St//rings
	Set<String>s1=driver.getWindowHandles();
	 
	// Now we will iterate using Iterator
	Iterator<String> I1= s1.iterator();
	 
	while(I1.hasNext())
	{
	 
	   String child_window=I1.next();
	 
	// Here we will compare if parent window is not equal to child window then we            will close
	 
	if(!parent.equals(child_window))
	{
	driver.switchTo().window(child_window);
	 
	System.out.println("ChildWindowsTitle---"+driver.switchTo().window(child_window).getTitle());
	this.click("plugin", "id");
	this.click("Download", "id");
	 this.download("E:\\Downloads\\EAA\\");
	//driver.close();
	}
	 
	}
	// once all pop up closed now switch to parent window
	driver.switchTo().window(parent);
}
}
