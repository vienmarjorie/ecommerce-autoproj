package com.testsuite.useraccount;

import common.Browsers;

import org.testng.Assert;
import org.testng.annotations.*;

public class testcase1_verifyHomePage {
	
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
	public void verifyHomePage() {
		String expected = "My Store";
		String actual = Browsers.driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
}
