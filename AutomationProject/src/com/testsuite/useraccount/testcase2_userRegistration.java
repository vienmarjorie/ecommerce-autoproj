package com.testsuite.useraccount;

import common.Browsers;
import common.Variables;
import common.CommonFunctionality;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class testcase2_userRegistration {
	static Browsers browser = new Browsers();
	static CommonFunctionality common = new CommonFunctionality();
	
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
	  common.registration();
	  Browsers.driver.findElement(By.xpath("//*[@name='email_create']")).sendKeys(Variables.newEmailAccount);
  }
}
