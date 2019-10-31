package com.servicenow.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitlib {
	public static void isleep(long sec) throws InterruptedException {
		Thread.sleep(sec);
}
	public static void iwait( WebDriver driver,long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	public  static void ewaitforvisible(WebDriver driver,WebElement ele,long sec) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public  static void ewaitforpresence(WebDriver driver,WebElement ele,long sec) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
