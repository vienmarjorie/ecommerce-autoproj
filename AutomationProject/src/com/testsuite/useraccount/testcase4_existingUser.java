package com.testsuite.useraccount;

import common.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class testcase4_existingUser {
	
	static Browsers browser = new Browsers();
	static CommonFunctionality common = new CommonFunctionality();
	
	@BeforeTest
	public static void openBrowser(){
		browser.ChromeBrowser();
	}
	
	@AfterTest
	public static void closeBrowser(){
		browser.closeBrowser();
	}
	
   @Test
   public void existingUser() {
	   common.registration();
	   Browsers.driver.findElement(By.xpath("//*[@name='email_create']")).sendKeys(Variables.registeredEmail);
	   Browsers.driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
	   
	   common.implicitWait();
	   String expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
	   String actual = Browsers.driver.findElement(By.xpath("//*[@id='create_account_error']/ol/li")).getText();
	   Assert.assertEquals(actual, expected);
   }
}
