package com.redbusprojects.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbusprojects.testbase.TestBase;

public class waitHelpers extends TestBase{
	
	public void pageLoadWait(long time,TimeUnit seconds){
		driver.manage().timeouts().pageLoadTimeout(time, seconds);
	}
	
	public void implicitWait(long time,TimeUnit seconds){
		driver.manage().timeouts().implicitlyWait(time, seconds);
	}

	public WebElement waitForElementPresent(WebElement element, long time, TimeUnit seconds){
		return new WebDriverWait(driver, time).ignoring(NoSuchElementException.class).ignoring(TimeoutException.class)
				.until(ExpectedConditions.visibilityOf(element));
		
	}
}
