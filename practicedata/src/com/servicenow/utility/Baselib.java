package com.servicenow.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.servicenow.pagerepo.onelogin;

public class Baselib 
{
	public static WebDriver driver ; 
	@BeforeTest
	public void beforetest()
	{
		System.out.println("before test");
	}
	@BeforeClass
	@Parameters({"browser", "url"})
	public void setup(String browser, String url) throws MalformedURLException, Exception {
		System.out.println("before class");
		if(browser.equalsIgnoreCase("internet"))
		{
		    System.setProperty ("webdriver.ie.driver","./exefiles/IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		    
		    //for remote script run
		    
		    //driver = new RemoteWebDriver(DesiredCapabilities.internetExplorer());
		    
		   
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty ("webdriver.chrome.driver","./exefiles/chromedriver.exe");
			//for remote script run
			
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setBrowserName(browser);
//			cap.setPlatform(Platform.WIN10);
//			URL url1 = new URL("http://10.104.87.197:4444/wd/hub");
//			driver = new RemoteWebDriver(url1, cap);
			
            //for normal run
		    
			driver = new ChromeDriver();
		    //driver = new RemoteWebDriver(DesiredCapabilities.chrome());
		    
		    //using chromeoption
		    
//		    ChromeOptions options = new ChromeOptions();
//		    options.addArguments("start-maximized");
//		    driver = new ChromeDriver(options);
			
			Thread.sleep(4000);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			driver.get(url);
			driver.manage().deleteAllCookies();	
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty ("webdriver.gecko.driver","./exefiles/geckodriver.exe");
			driver = new FirefoxDriver();

			//for remote script run
		    
		    //driver = new RemoteWebDriver(DesiredCapabilities.firefox());
		    
            
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();	
		}
	}
	
	@AfterMethod
	public void testscriptstatus(ITestResult result) throws EncryptedDocumentException, IOException
	{
		int i=onelogin.returnrowno();
		int j=onelogin.returncolumno();
		String shpath = onelogin.returnshpath();
		String shname = onelogin.returnshname();
		System.out.println("Class name +" + result.getTestClass().getName());
		if(result.isSuccess())
		{
		System.out.println("Result : "+ result.isSuccess());
		System.out.println("Instance name : "+ result.getName());
		Excelsheet.datawritenormal(i, j, shpath, "pass", shname);
		
		}
		
		else {
			Excelsheet.datawritenormal(i, j, shpath, "fail", shname);
		}
	}
	
	@AfterClass
	public void afterclass() throws Exception
	{
		System.out.println("After class");
		Thread.sleep(4000);
		//driver.quit();
		
	}
	@AfterTest
	public void teardown() throws Exception 
	{
		System.out.println("After test");
		
		//driver.quit();
		
		
	}
	@AfterSuite
	public void aftersuite() throws Exception
	{
		mail.outlook();
	}

}
