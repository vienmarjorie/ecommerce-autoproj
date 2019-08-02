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
	
	@AfterTest
	
	public static void closeBrowser() {
		browser.closeBrowser();
	}
	
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
 // @Test (priority=2)
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
  
  //@Test (priority=3)
  public void userRegistration() {
	  
	  int timeOut = 20;
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
	  
	  //Password
	  element = Browsers.driver.findElement(By.xpath("//*[@id='passwd']"));
	  element.click();
	  element.sendKeys(Variables.invalidRegPassword);
	  
	  //Date of birth
	  element = Browsers.driver.findElement(By.xpath("//*[@id='days']"));
	  element.click();
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='days']/option[6]"));
	  element.click();
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='months']"));
	  element.click();
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='months']/option[2]"));
	  element.click();
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='years']"));
	  element.click();
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='years']/option[31]"));
	  element.click();
	  
	  //Newsletter Subscription
	  element = Browsers.driver.findElement(By.xpath("//*[@name='newsletter']"));
	  element.click();
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@name='optin']"));
	  element.click();
	  
	  //Name
	  element = Browsers.driver.findElement(By.xpath("//*[@id='firstname']"));
	  String actualFirstName = element.getAttribute("value");
	  Assert.assertEquals(actualFirstName, Variables.firstName);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@name='lastname']"));
	  String actualLastName = element.getAttribute("value");
	  Assert.assertEquals(actualLastName, Variables.lastName);
	  
	  //Address
	  element = Browsers.driver.findElement(By.xpath("//*[@id='company']"));
	  element.sendKeys(Variables.company);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@name='address1']"));
	  element.sendKeys(Variables.address);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='city']"));
	  element.sendKeys(Variables.city);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@name='id_state']/option[6]"));
	  element.click();
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='postcode']"));
	  element.sendKeys(Variables.postCode);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@name='phone_mobile']"));
	  element.sendKeys(Variables.phoneNumber);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='alias']"));
	  element.clear();
	  element.sendKeys(Variables.aliasEmail);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='submitAccount']"));
	  element.click();
	  
	  String expectedPasswdError = "passwd is invalid.";
	  new WebDriverWait(Browsers.driver, timeOut).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(@class, 'alert-danger')]/ol/li"), Variables.passwordErrorMsg));
	  element = Browsers.driver.findElement(By.xpath("//*[contains(@class, 'alert-danger')]/ol/li"));
	  String actualPasswdError = element.getText();
	  Assert.assertEquals(actualPasswdError, expectedPasswdError);
	  
	  //Password
	  element = Browsers.driver.findElement(By.xpath("//*[@id='passwd']"));
	  element.click();
	  element.sendKeys(Variables.emailRegPassword);
	  
	  element = Browsers.driver.findElement(By.xpath("//*[@id='submitAccount']"));
	  element.click(); 
	  
	  String expected = "My account";
  	  String actual = Browsers.driver.findElement(By.xpath("//div[@id='columns']/div[1]/span[2]")).getText();
      Assert.assertEquals(actual, expected);
  }
}
