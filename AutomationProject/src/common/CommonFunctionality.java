package common;

import common.Browsers;
import common.Variables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class CommonFunctionality {
	public static WebDriver driver = null;
	public static WebElement element = null;
	
	// Registration
	public void registration(){
		Browsers.driver.findElement(By.xpath("//*[contains(@title, 'Log in')]")).click();
		Browsers.driver.findElement(By.xpath("//*[@name='email_create']")).click();
	}
	
	//Sign-in
	public void login() {
		Browsers.driver.findElement(By.xpath("//*[contains(@title, 'Log in')]")).click();
		Browsers.driver.findElement(By.xpath("//input[@name='email']")).click();
		Browsers.driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Variables.registeredEmail);
		Browsers.driver.findElement(By.xpath("//*[contains(@type, 'pass')]")).click();
		Browsers.driver.findElement(By.xpath("//*[contains(@type, 'pass')]")).sendKeys(Variables.registeredPassword);
		Browsers.driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	}
	
	public void implicitWait(){
		Browsers.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}




