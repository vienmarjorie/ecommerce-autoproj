package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class Browsers {
	public static WebDriver driver = null;
	public static WebElement element = null;
	public static final String URL = "http://automationpractice.com/index.php?";
	
	public void ChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\browser\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}



