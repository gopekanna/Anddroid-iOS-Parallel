package com.flip.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class TestFlipkart {
	
	RemoteWebDriver driver;
	Dimension size;

	@SuppressWarnings("rawtypes")
	@BeforeMethod
	@Parameters({"port","device"})
	 public void setUp(String port, String device) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		if(device.contains("iPhone"))
		{
		String xcodeConfigFile = "/Users/gopikannan/node_modules/webdriveragent/WebDriverAgent/Config.xcconfig";
		
		System.out.println("port="+port+":device="+device);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("xcodeConfigFile",xcodeConfigFile);
		capabilities.setCapability("platformVersion", "10.2");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("browserName", "Safari");
//		capabilities.setCapability("udid", "fdjsbfjbsbk65774757fvjvvhjvhvhjvj");
		
		driver = new IOSDriver(new URL("http://172.16.0.19:"+port+"/wd/hub"), capabilities);
		
		}
		if(device.contains("adc70d087d77"))
		{
		
		System.out.println("port="+port+":device="+device);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://172.16.0.19:"+port+"/wd/hub"), capabilities);
		
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://m.hyundai.co.in/mobile/");
		}
	

	@Test(priority = 1)
	@Parameters({"platformname"})
	 public void SignIn(String username) throws InterruptedException, IOException  {
		
		 WebDriverWait waitButton = new WebDriverWait(driver, 60);
		 waitButton.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Special Offers")));
		 driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/div[5]/div[1]/div/ul/li[1]/a")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='images/CarModel/b668300c_elite_i20_logo.png']")).click();
		 driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/div[4]/div[1]/div[4]/div/div/div[11]/h3/a/span/span[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='images/logo.png']")).click();
		 WebDriverWait waitImage = new WebDriverWait(driver, 30);
	     waitImage.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Special Offers")));
	     Thread.sleep(5000);
	}
	 
	
	@AfterMethod
	 public void tearDown() {
			
		 driver.quit();
		 
	 }
	
	}
