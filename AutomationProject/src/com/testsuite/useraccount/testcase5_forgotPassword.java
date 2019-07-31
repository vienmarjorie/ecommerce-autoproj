package com.testsuite.useraccount;

import common.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class testcase5_forgotPassword {
	
	static Browsers browser = new Browsers();
	static CommonFunctionality common = new CommonFunctionality();
	
	@BeforeTest
	public static void openBrowser(){
		browser.ChromeBrowser();
	}
	
	/*@AfterTest
	public static void closeBrowser(){
		browser.closeBrowser();
	}*/
	@Test
	public void forgotPassword() {
		Browsers.driver.findElement(By.xpath("//*[contains(@title, 'Log in')]")).click();
		Browsers.driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=password']")).click();
		
		String expected = "FORGOT YOUR PASSWORD?";
		String actual = Browsers.driver.findElement(By.xpath("//div[@class='box']/h1")).getText();
		Assert.assertEquals(actual, expected);
		
		Browsers.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Variables.registeredEmail);
		Browsers.driver.findElement(By.xpath("//*[@id='form_forgotpassword']/fieldset/p/button/span")).click();
		common.implicitWait();
		
		String expectedConfirmation = "A confirmation email has been sent to your address: test.slnx1@gmail.com";
		String actualConfirmation = Browsers.driver.findElement(By.xpath("//*[contains(@class, 'alert-success')]")).getText();
		Assert.assertEquals(actualConfirmation, expectedConfirmation);
	}
}
