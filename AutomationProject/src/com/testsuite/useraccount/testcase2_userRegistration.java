package com.testsuite.useraccount;

import common.Browsers;
import common.Variables;
import common.CommonFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class testcase2_userRegistration {
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
	
  @Test (priority=1)
  public void createAccount() {
	  
	  int timeOut = 20;
	  WebElement element = null;
	  
	  common.registration();
	  element = Browsers.driver.findElement(By.xpath("//*[@name='email_create']"));
	  element.sendKeys(Variables.emailRegistration);
	  element = Browsers.driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
	  element.click();
	  
	  String expected = "YOUR PERSONAL INFORMATION";
	  new WebDriverWait(Browsers.driver, timeOut).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='account-creation_form']/div[1]/h3"), "YOUR PERSONAL INFORMATION")); 
	  element = Browsers.driver.findElement(By.xpath("//*[@id='account-creation_form']/div[1]/h3"));
	  String actual = element.getText();
	  Assert.assertEquals(actual, expected);
	  
  }
  @Test (priority=2)
  public void emptyRequiredFields() {
	  
	  int timeOut = 20;
	  String errorMessage = "There are 8 errors";
	  WebElement element = null;
	  
	  //Clicking Register button
	  element = Browsers.driver.findElement(By.xpath("//*[@id='submitAccount']"));
	  element.click();
	  
	  //Error message
	  String expectedErrorMsg = "There are 8 errors";
	  new WebDriverWait(Browsers.driver, timeOut).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(@class, 'alert')]/p"), errorMessage));
	  element = Browsers.driver.findElement(By.xpath("//*[contains(@class, 'alert')]/p"));
	  String actualErrorMsg = element.getText();
	  System.out.println(actualErrorMsg);
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
  }
  
  //@Test
  public void userRegistration() {
	  
	  WebElement element = null;
	   
	  //Gender
	  element = Browsers.driver.findElement(By.xpath("//*[@id='id_gender2']"));
	  element.click();
	  boolean bool = Browsers.driver.findElement(By.xpath("//*[@id='id_gender2']")).isSelected();
	  System.out.println("isGenderSelected: " + bool);
	  
	  //Firstname
	  element = Browsers.driver.findElement(By.xpath("//*[@name='customer_firstname']"));
	  element.click();
	  element.sendKeys(Variables.firstName);
	  
	  //Lastname
	  element = Browsers.driver.findElement(By.xpath("//*[@name='customer_lastname']"));
	  element.click();
	  element.sendKeys(Variables.lastName);
	  
	  //Email
	  element = Browsers.driver.findElement(By.xpath("//*[@id='email']"));
	  element.click();
	  String email = element.getAttribute("value");
	  System.out.println(email);
	  Assert.assertEquals(email, Variables.emailRegistration);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='passwd']"));
	  element.click();
	  element.sendKeys(Variables.invalidRegPassword);
	  
	  
  }
}
