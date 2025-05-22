package basePack;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilsPack.CommonUtils;

public class BasePage {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws Exception {
		CommonUtils.readPropertiesFile();
		CommonUtils.launchBrowserAndNavigateToApp();
	}
	
	@AfterTest
	public void afterTest() {
//		driver.quit();
	}
}
