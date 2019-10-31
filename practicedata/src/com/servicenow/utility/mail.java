package com.servicenow.utility;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mail {
	static WebDriver driver;

    
	
    
	
	public static void outlook() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		
		//driver= new RemoteWebDriver(DesiredCapabilities.chrome());
		Robot robot = new Robot();
		driver = new ChromeDriver();
		//er er= new er();
		Excelsheet er= new Excelsheet();
		//er.datawrite(4, 0);
		
		
		
		Reporter.log("test cases to be run");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.get("https://outlook.office.com");
        driver.findElement(By.id("i0116")).sendKeys(er.dataread(1, 0, "outlookmaildata", "sheet1"));
        
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(10000);
        
        driver.findElement(By.id("passwordInput")).sendKeys(er.dataread(1, 1, "outlookmaildata", "sheet1"));;
        //wait.until(ExpectedConditions.visibilityOf(pass));
        
        driver.findElement(By.id("submitButton")).click();
        
        //Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'New message')]")));
        driver.findElement(By.xpath("//div[contains(text(),'New message')]")).click();;
        
        Thread.sleep(30000);
        
        
        
        
		
		  //sender in to 
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='ms-BasePicker-input pickerInput_ecad0f63']")));
          List<WebElement> to1 = driver.findElements(By.xpath("//input[@class='ms-BasePicker-input pickerInput_ecad0f63']"));
          System.out.println("size =" +to1.size());
          WebElement to = to1.get(0);
          Thread.sleep(4000);
		  for (int i = 1; i <=2; i++) 
			
		  {
          to.sendKeys(er.dataread(i, 2, "outlookmaildata", "sheet1"));
		  Thread.sleep(4000); 
		  to.sendKeys(Keys.ENTER); 
		  Thread.sleep(3000);
		  }
//		  to.sendKeys(er.dataread(2, 2, "outlookmaildata", "sheet1"));
//		  Thread.sleep(1000); 
//		  to.sendKeys(Keys.ENTER); 
//		  Thread.sleep(1000);
		  
		  //sender in cc 
		  WebElement cc = driver.findElements(By.xpath("//input[@class='ms-BasePicker-input pickerInput_ecad0f63']")).get(1);
		  for (int i = 1; i <=2; i++) 
			
		  {
		  cc.sendKeys(er.dataread(i, 3, "outlookmaildata", "sheet1"));
		  Thread.sleep(4000);
		  cc.sendKeys(Keys.ENTER); 
		  Thread.sleep(3000);
		  }
		  //robot.keyPress(KeyEvent.VK_ENTER); 
		  //robot.keyRelease(KeyEvent.VK_ENTER);
//		  cc.sendKeys(er.dataread(2, 3, "outlookmaildata", "sheet1")); 
//		  Thread.sleep(1000);
//		  cc.sendKeys(Keys.ENTER); 
//		  Thread.sleep(1000);
		  
		  //subject data
		  driver.findElement(By.id("subjectLine0")).sendKeys(er.dataread(1,4, "outlookmaildata", "sheet1")); Thread.sleep(2000);
		  
		  //message body 
		  WebElement msg = driver.findElement(By.xpath("//div[@aria-label='Message body' and @role='textbox']"));
		  msg.sendKeys(er.dataread(1, 5, "outlookmaildata", "sheet1"));
		  Thread.sleep(5000);
		  
		  //add attachement 
		  int n=1;
		  while(n<=2)
		  {
		  driver.findElements(By.name("Attach")).get(0).click();
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Browse this computer')]")));
		  driver.findElement(By.xpath("//span[contains(text(),'Browse this computer')]")).click(); 
		  Thread.sleep(3000); 
		  //using the autoit tool(attachement)
		  //Runtime.getRuntime().exec("./exefiles/uploadfile.exe");
		  
		  //using robot class(attachement) 
		  String path = er.dataread(n, 6,"outlookmaildata", "sheet1"); 
		  System.out.println(path); 
		  StringSelection stringsel = new StringSelection(path);
		  
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringsel, null); 
		  robot.keyPress(KeyEvent.VK_CONTROL); 
		  robot.keyPress(KeyEvent.VK_V);
		  
		  robot.keyRelease(KeyEvent.VK_CONTROL); 
		  robot.keyRelease(KeyEvent.VK_V);
		  
		  robot.keyPress(KeyEvent.VK_ENTER); 
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  
		  Thread.sleep(20000);
		  n++;
		  }
		  
		  //send button
		  //driver.findElements(By.xpath("//div[contains(text(),'Send')]")).get(1).click(); 
		  
		 
        //logout
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt=\"KI\"]")));
        driver.findElement(By.xpath("//img[@alt=\"KI\"]")).click();
        Thread.sleep(4000);
        //driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
        driver.findElement(By.id("meControlSignoutLink")).click();
        Thread.sleep(5000);
        
        
        //driver.quit();
        //test cases run code for demo
        //String data=er.dataread(1, 0, "Change Test Cases", "Change Module");
        //Reporter.log(er.dataread(1, 5, "Change Test Cases", "Change Module"));
        //er.datareadcond("Change Test Cases", "Change Module", data, 2, 35);
        
        Thread.sleep(5000);

        driver.quit();
	}

}
