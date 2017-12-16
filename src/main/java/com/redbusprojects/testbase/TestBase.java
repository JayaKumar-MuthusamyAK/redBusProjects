package com.redbusprojects.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fileinputstream;
	
	public void init(String browser) throws IOException{
		//loadproperties();
		if(driver==null){
			if(System.getProperty("os.name").contains("Windows")){
				if(browser.equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("marionette", false);
					driver = new FirefoxDriver(cap);
					driver.manage().window().maximize();
					//log("Opening the "+Constants.browserName+"Browser in "+System.getProperty("os.name")+"System");
				}else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					options.addArguments("start-maximized");
					options.addArguments("--enable-automation");
					options.addArguments("test-type=browser");
					options.addArguments("disable-infobars");
					
					driver = new ChromeDriver(options);
					//log("Opening the "+Constants.browserName+"Browser in "+System.getProperty("os.name")+"System");

				}
			}
			else if(System.getProperty("os.name").contains("Mac")){
				if(browser.equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("marionette", false);
					driver = new FirefoxDriver(cap);
					driver.manage().window().maximize();
					//log("Opening the "+Constants.browserName+"Browser in "+System.getProperty("os.name")+"System");
				}else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					options.addArguments("start-maximized");
					options.addArguments("--enable-automation");
					options.addArguments("test-type=browser");
					options.addArguments("disable-infobars");
					
					driver = new ChromeDriver(options);
					//log("Opening the "+Constants.browserName+"Browser in "+System.getProperty("os.name")+"System");

				}
			}

		}
	}
	public void loadproperties() throws IOException {
		prop = new Properties();
		try {
			
			fileinputstream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\redbusprojects\\confiq\\confiq.properties");
			prop.load(fileinputstream);

			fileinputstream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\redbusprojects\\pageLocators\\homepage.properties");
			prop.load(fileinputstream);
			 
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public WebElement getLocator(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public List<WebElement> getLocators(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public WebElement getWebElement(String locator) throws Exception{
		return getLocator(prop.getProperty(locator));
		
	}
	
	public List<WebElement> getWebElements(String locators) throws Exception{
		return getLocators(prop.getProperty(locators));
		
	}
	
	

}
