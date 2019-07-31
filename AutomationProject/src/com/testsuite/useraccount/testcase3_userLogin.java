package com.testsuite.useraccount;

import common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testcase3_userLogin {
	
	static Browsers browser = new Browsers();
	static CommonFunctionality common = new CommonFunctionality();
	static WebElement element = null;
	@BeforeTest
	
	public static void openBrowser() {
		browser.ChromeBrowser();
	}
	
	@AfterTest
	
	public static void closeBrowser() {
		browser.closeBrowser();
	}
	
    @Test
    public void userLogin() {
    	common.login();
    	String expected = "My account";
    	String actual = Browsers.driver.findElement(By.xpath("//div[@id='columns']/div[1]/span[2]")).getText();
        Assert.assertEquals(actual, expected);
    }
}
