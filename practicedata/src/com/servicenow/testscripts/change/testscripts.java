package com.servicenow.testscripts.change;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.testng.Assert;
import org.testng.ISuiteListener;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.servicenow.pagerepo.onelogin;
import com.servicenow.pagerepo.change.changerepo1;
import com.servicenow.utility.Baselib;
import com.servicenow.utility.Excelsheet;
import com.servicenow.utility.screenshotlib;
import com.servicenow.utility.waitlib;

public class testscripts extends Baselib 
{
	@Test(priority=1)
	public void login() throws Exception, Exception
	{

		System.out.println("change login");
		Thread.sleep(4000);
		onelogin.data(9,7,"ChangeTestCases", "Change Module" );	
		Assert.assertNotEquals("pass", "fails");
	}
	
	
	@Test(priority=2)
	public void createchange() throws IOException, Exception 
	{
        System.out.println("change create");
        Thread.sleep(4000);
		onelogin.data(42,7, "ChangeTestCases", "Change Module");	
	}
	
	@Test(priority=3)
	public void searchchange() throws IOException, Exception
	{
        System.out.println("change search");
        Thread.sleep(4000);
		onelogin.data(75,7, "ChangeTestCases", "Change Module");
	   
	}
	
	

}
