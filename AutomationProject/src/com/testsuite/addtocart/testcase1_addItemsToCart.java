package com.testsuite.addtocart;

import common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class testcase1_addItemsToCart {
	
	static Browsers browser = new Browsers();
	static CommonFunctionality common = new CommonFunctionality();

	
	@BeforeTest
	public static void openBrowser() {
		browser.ChromeBrowser();
	}
	
	/*@AfterTest
	public static void closeBrowser() {
		browser.closeBrowser();
	}*/
	
	@Test
	public void addItemToCart() {
		Actions action = new Actions(Browsers.driver);
		
		WebElement target = Browsers.driver.findElement(By.xpath("//*[@title='Blouse']"));
		action.moveToElement(target).perform();
		Browsers.driver.findElement(By.xpath("//*[@data-id-product='2']")).click();
		
		String expected = "Product successfully added to your shopping cart";
		String actual = Browsers.driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2")).getText();
		Assert.assertEquals(actual, expected);
		
	}
}
