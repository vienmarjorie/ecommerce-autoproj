package com.testsuite.addtocart;

import common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class testcase1_addItemsToCart {
	
	static Browsers browser = new Browsers();
	static CommonFunctionality common = new CommonFunctionality();
	static int timeout = 20;

	
	@BeforeTest
	public static void openBrowser() {
		browser.ChromeBrowser();
	}
	
	/*@AfterTest
	public static void closeBrowser() {
		browser.closeBrowser();
	}*/
	
	@Test (priority=1)
	public void addItemToCart() {
		Actions action = new Actions(Browsers.driver);
		WebElement element = null;
		
		element = Browsers.driver.findElement(By.xpath("//*[@title='Blouse']"));
		action.moveToElement(element).perform();
		element = Browsers.driver.findElement(By.xpath("//*[@data-id-product='2']"));
		element.click();
		
		//common.implicitWait();
		new WebDriverWait(Browsers.driver, 20).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2"), "Product successfully added to your shopping cart"));
		String expected = "Product successfully added to your shopping cart";
		String actual = Browsers.driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2")).getText();
		Assert.assertEquals(actual, expected);
	}
	@Test (priority=2)
	public void addAnotherItemToCart() {
		
		Actions action = new Actions(Browsers.driver);
		WebDriverWait wait = new WebDriverWait(Browsers.driver, timeout);
		WebElement element = null;
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Continue shopping']")));
		element = Browsers.driver.findElement(By.xpath("//*[@title='Continue shopping']"));
		element.click();
		
		element = Browsers.driver.findElement(By.xpath("//*[@title='Printed Chiffon Dress']"));
		action.moveToElement(element).perform();
		element = Browsers.driver.findElement(By.xpath("//*[@data-id-product='7']"));
		element.click();
		
		new WebDriverWait(Browsers.driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Continue shopping']")));
		element = Browsers.driver.findElement(By.xpath("//*[@title='Continue shopping']"));
		element.click();
		
		element = Browsers.driver.findElement(By.xpath("//*[@title='Printed Summer Dress']"));
		action.moveToElement(element).perform();
		new WebDriverWait(Browsers.driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-id-product='5']")));
		element = Browsers.driver.findElement(By.xpath("//*[@data-id-product='5']"));
		element.click();
		
		new WebDriverWait(Browsers.driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Continue shopping']")));
		element = Browsers.driver.findElement(By.xpath("//*[@title='Continue shopping']"));
		element.click();
	}
	@Test (priority=3)
	public void verifyItemsinCart() {
		WebElement element = null;
		element = Browsers.driver.findElement(By.xpath("//*[@title='View my shopping cart']"));
		element.click();
	}
}
