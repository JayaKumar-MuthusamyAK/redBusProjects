package com.redbusprojects.helpers;

import org.openqa.selenium.WebElement;

import com.redbusprojects.testbase.TestBase;

public class FrameHelpers extends TestBase{
	
	
	public void usingFrameLocatorSwicthtoWindow(WebElement frameLocator){
		driver.switchTo().frame(frameLocator);
	}

}
