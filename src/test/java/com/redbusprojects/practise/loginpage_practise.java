package com.redbusprojects.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class loginpage_practise {
	
	WebDriver driver;
	
	@Test
	public void testCases(){
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("marionette", false);
		driver = new FirefoxDriver(cap);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.redbus.in/");
		
		/*driver.findElement(By.id("go")).click();*/
		data_log(driver.getTitle());
		
		driver.findElement(By.id("signin-block")).click();
		driver.findElement(By.id("signInLink")).click();
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@src='/account?pageName=Home&noReload=noReload']"));
		driver.switchTo().frame(frameEle);
		
		driver.findElement(By.xpath("//*[@id='signInView']/div[2]/div/div[3]/button")).click();
		
	
		
	}
	
	public void data_log(String data){
		
		System.out.println(data);
	}

}
