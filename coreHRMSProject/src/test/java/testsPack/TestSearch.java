package testsPack;

import org.testng.annotations.Test;

import basePack.BasePage;
import pagesPack.LoginPage;
import pagesPack.PIMPage;
import utilsPack.CommonUtils;

public class TestSearch extends BasePage {
    
	LoginPage loginPage = new LoginPage();
	
	PIMPage pimPage = new PIMPage();
	
	@Test(description="Verify that the search functionality returns the correct employee",groups= {"Smoke"},priority=1,enabled=true)
	public void searchEmployee() throws Exception {

		//Login
	    loginPage.login();
	  
	    //wait for 3 seconds
	    CommonUtils.hardWait(3);
	    
	    //switch to frame
	    CommonUtils.switchToFrame(PIMPage.getFrame());
	  
	    //select dropdown value 
	    CommonUtils.selectDropdownValue(PIMPage.getSelect(),3);
	    
	    //enter value in search box
		CommonUtils.enterValue(PIMPage.getSearch(), "Odin", true);
	
		//click on search button
		CommonUtils.clickElement(PIMPage.getSearchBtn());
	}
	
}
