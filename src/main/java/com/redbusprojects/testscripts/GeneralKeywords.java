package com.redbusprojects.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.redbusprojects.helpers.FrameHelpers;
import com.redbusprojects.helpers.waitHelpers;
import com.redbusprojects.testbase.TestBase;

public class GeneralKeywords extends TestBase{

	waitHelpers helpers = new waitHelpers();
	FrameHelpers framehelpers = new FrameHelpers();
	public String openBrowser(String objectKeys) throws IOException {
		try{
			init(prop.getProperty(objectKeys));
		}
		catch(Exception e){
			return e.getMessage();
		}
		return "Pass";
	}

	public String navigateURL(String objectKeys) {
		try{
			driver.get(prop.getProperty(objectKeys));
			implewait();
		}catch(Exception e){ return e.getMessage();}
		
		return "Pass";
	}
	
	public String implewait(){
		helpers.implicitWait(20, TimeUnit.SECONDS);
		return "Pass";
		
	}
	
	public String verifyLink(String objectKeys) throws Exception{
		
		if(getWebElements(objectKeys).size()!=0)
			return "Pass";
		else 
			return "Fail";
		
	}

	public String click(String objectKeys) {
		try{
			getWebElement(objectKeys).click();
		}
		catch(Exception e){
		return e.getMessage();
		}
		return "Pass";
	}
	public String swichToFrame(String objectKeys) throws Exception{
		try{
			framehelpers.usingFrameLocatorSwicthtoWindow(getWebElement(objectKeys));
		}
		catch(Exception e){
			return e.getMessage();
		}
		return "Pass";	
	}

	public String input(String objectKeys, String string) {
		
		try{
			getWebElement(objectKeys).sendKeys(string);
		}
		catch(Exception e) { return e.getMessage();}
		return null;
	}
}
