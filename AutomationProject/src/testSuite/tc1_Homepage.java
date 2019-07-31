package testSuite;

import common.Browsers;

import org.testng.Assert;
import org.testng.annotations.*;

public class tc1_Homepage {

  static Browsers browser = new Browsers();
  
  @BeforeTest
  public static void openBrowser() {
	 browser.ChromeBrowser();
  }
  
  @AfterTest
  public static void closeBrowser() {
	 browser.closeBrowser();
  }
  
  @Test
  public static void verifyHomePageTitle() {
	  String expectedResult = "My Store";
	  String actualResult = Browsers.driver.getTitle();
	  Assert.assertEquals(actualResult, expectedResult);
  }

}
