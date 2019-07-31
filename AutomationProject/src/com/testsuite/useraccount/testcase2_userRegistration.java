package com.testsuite.useraccount;

import common.Browsers;
import common.Variables;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class testcase2_userRegistration {
	static Browsers browser = new Browsers();
	
	@BeforeTest
	
	public static void openBrowser() {
		browser.ChromeBrowser();
	}
	
	@AfterTest
	
	public static void closeBrowser() {
		browser.closeBrowser();
	}
  @Test
  public void userRegistration() {
	  Browsers.driver.findElement(By.xpath("//*[contains(@title, 'Log in')]")).click();
	  Browsers.driver.findElement(By.xpath("//*[@name='email_create']")).click();
	  Browsers.driver.findElement(By.xpath("//*[@name='email_create']")).sendKeys(Variables.newEmailAccount);
  }
}
