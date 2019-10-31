package com.servicenow.pagerepo.change;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



import com.servicenow.utility.Baselib;
import com.servicenow.utility.Excelsheet;
import com.servicenow.utility.waitlib;

public class changerepo1 extends Baselib {
    
    public changerepo1(WebDriver driver) 
   {
	this.driver=driver;
	PageFactory.initElements(driver, this);
   }
  
   @FindBy()
   List<WebElement> ele;
}