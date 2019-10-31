package com.servicenow.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;





public class screenshotlib 
{

	public static void screenshot(WebDriver driver, String scname) throws IOException
	{
		System.out.println("screenshot taken");
		TakesScreenshot ts= (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./screenshots/"+scname+".png");
		FileUtils.copyFile(srcfile, destfile);
}
}