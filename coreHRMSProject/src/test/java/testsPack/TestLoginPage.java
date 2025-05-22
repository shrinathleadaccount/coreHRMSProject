package testsPack;

import org.testng.annotations.Test;

import basePack.BasePage;
import pagesPack.LoginPage;
import utilsPack.CommonUtils;
import utilsPack.TestNGUtility;

public class TestLoginPage extends BasePage {

    LoginPage loginPage = new LoginPage();
	
	
	@Test(description="verify LoginPage",priority=0)
	public void verifyLoginPage() throws Exception {
			
	loginPage.login();
	CommonUtils.hardWait(5);
	TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomePage()),"Welcome selenium");
	System.out.println("verified");
	
	}
	
}
