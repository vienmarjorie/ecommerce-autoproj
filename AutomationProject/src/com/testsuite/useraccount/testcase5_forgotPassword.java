package com.testsuite.useraccount;

import common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class testcase5_forgotPassword {
	
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
	
	@Test (priority=1)
	public void forgotPassword() {
		int timeOut = 20;
		String text = "Sign in";
		
		String actualTitle = Browsers.driver.getTitle();
		System.out.println(actualTitle);
		new WebDriverWait (Browsers.driver, timeOut).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"), text));
		Browsers.driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		Browsers.driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=password']")).click();
		
		String expected = "FORGOT YOUR PASSWORD?";
		String actual = Browsers.driver.findElement(By.xpath("//div[@class='box']/h1")).getText();
		Assert.assertEquals(actual, expected);
		
		Browsers.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Variables.registeredEmail);
		Browsers.driver.findElement(By.xpath("//*[@id='form_forgotpassword']/fieldset/p/button/span")).click();
		common.implicitWait();
		
		String expectedConfirmation = "A confirmation email has been sent to your address: " + Variables.registeredEmail;
		String actualConfirmation = Browsers.driver.findElement(By.xpath("//*[contains(@class, 'alert-success')]")).getText();
		Assert.assertEquals(actualConfirmation, expectedConfirmation);
	}
	
	@Test (priority=2)
	public void forgotPasswordNonExistentUser() {
		
		Browsers.driver.findElement(By.xpath("//*[@title='Back to Login']")).click();
		Browsers.driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=password']")).click();
		
		String expected = "FORGOT YOUR PASSWORD?";
		String actual = Browsers.driver.findElement(By.xpath("//div[@class='box']/h1")).getText();
		Assert.assertEquals(actual, expected);
		
		Browsers.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Variables.unregisteredEmail);
		Browsers.driver.findElement(By.xpath("//*[@id='form_forgotpassword']/fieldset/p/button/span")).click();
		common.implicitWait();
		
		String expectedConfirmation = "There is no account registered for this email address.";
		String actualConfirmation = Browsers.driver.findElement(By.xpath("//*[contains(@class, 'alert-danger')]/ol")).getText();
		Assert.assertEquals(actualConfirmation, expectedConfirmation);
		
	}
}
