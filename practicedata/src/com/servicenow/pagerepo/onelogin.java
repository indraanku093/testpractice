package com.servicenow.pagerepo;

import java.io.IOException;
import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.servicenow.utility.Baselib;
import com.servicenow.utility.Excelsheet;
import com.servicenow.utility.screenshotlib;

public class onelogin extends Baselib 
{
	static int i=0,j=0;
	static String shname,shpath;
		
	 public onelogin(WebDriver driver) 
	   {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	   }
	public static void data(int h, int k, String spath, String sname)
	{
		i=h;
		j=k;
		shname=sname;
		shpath=spath;
	}
	public static int returnrowno() {return i;}
	public static int returncolumno() {return j;}
	public static String returnshpath() {System.out.println("shpath "+shpath);return shpath;}
	public static String returnshname() {System.out.println("shname "+shname);return shname;}
}
