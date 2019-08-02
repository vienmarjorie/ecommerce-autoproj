package common;

import common.Browsers;
import common.Variables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctionality {
	public static WebDriver driver = null;
	public static WebElement element = null;
	int timeOut = 20;
	
	// Registration
	public void registration(){
		String text = "Sign in";
		new WebDriverWait (Browsers.driver, timeOut).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"), text));
		Browsers.driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		Browsers.driver.findElement(By.xpath("//*[@name='email_create']")).click();
	}
	
	//Sign-in
	public void login() {
		String text = "Sign in";
		new WebDriverWait (Browsers.driver, timeOut).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"), text));
		Browsers.driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		Browsers.driver.findElement(By.xpath("//input[@name='email']")).click();
		Browsers.driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Variables.registeredEmail);
		Browsers.driver.findElement(By.xpath("//*[contains(@type, 'pass')]")).click();
		Browsers.driver.findElement(By.xpath("//*[contains(@type, 'pass')]")).sendKeys(Variables.registeredPassword);
		Browsers.driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	}
	
	public void logout() {
		String text = "Sign out";
		new WebDriverWait (Browsers.driver, timeOut).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a"), text));
		Browsers.driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a")).click();
	}
	public void implicitWait(){
		Browsers.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}




