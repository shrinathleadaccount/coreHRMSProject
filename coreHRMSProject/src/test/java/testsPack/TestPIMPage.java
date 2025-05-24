package testsPack;

import org.testng.annotations.Test;

import basePack.BasePage;
import pagesPack.LoginPage;
import pagesPack.PIMPage;
import utilsPack.CommonUtils;
import utilsPack.TestNGUtility;

public class TestPIMPage extends BasePage {
	
		LoginPage loginPage = new LoginPage();
		
		PIMPage pimPage = new PIMPage();
		
		@Test(description="Verify that an employee can be added successfully",priority=0,enabled=false)
		public void addEmployee() throws Exception {
		    
		    // Log in to the application using the login page method
		    loginPage.login();
		    
		    // Wait for 5 seconds to allow the page to load
		    CommonUtils.hardWait(5);
		    
		    // Assert that the welcome message contains "Welcome selenium"
		    TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomePage()), "Welcome selenium");
		    
		    // Move the mouse to the PIM (Personnel Information Management) element
		    CommonUtils.moveToElement(PIMPage.getPim());
		    
		    // Click on the "Add Employee" button
		    CommonUtils.clickElement(PIMPage.getAddEmp());
		    
		    // Wait for 5 seconds to ensure the new page loads
		    CommonUtils.hardWait(5);
		    
		    // Switch to the iframe where the employee form is located
		    CommonUtils.switchToFrame(PIMPage.getFrame());

		    
		    // Enter the first name "Sai" into the first name field
		    CommonUtils.enterValue(PIMPage.getFirstName(), "Thor", true);
		    
		    
		    // Enter the last name "P" into the last name field
		    CommonUtils.enterValue(PIMPage.getLastName(), "Odin", true);
		    
		    
		    // Click the "Save" button to add the new employee
		    CommonUtils.clickElement(PIMPage.getSave());
		    
		    
		    // Click the "Back" button to return to the previous page
		    CommonUtils.clickElement(PIMPage.getBackButton());
		    
		    // Verify added employee
		    TestNGUtility.assertTrue(CommonUtils.getElementText(PIMPage.getEmpName()),"Thor Odin");
		    
		}
		
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
		
		@Test(description="Verify that employee details can be edited successfully",dependsOnMethods= {"searchEmployee"},groups= {"Smoke"},priority=2,enabled=false)
		public void editEmployeeDetails() throws Exception {

		
		}
		
		@Test(description="Verify that an employee can be deleted successfully",priority=3,enabled=false)
		public void deleteEmployee() throws Exception {
		 
			
		
		}
		
		@Test(description="Verify that the employee list is displayed correctly with accurate information",priority=4,enabled=false)
		public void viewEmployeeList() throws Exception {

		
		}
		
		@Test(description="Verify that photos can be added to employee profiles",priority=5,enabled=false)
		public void addEmployeePhotos() throws Exception {
		
		
		}
		
		@Test(description="Verify that employee details are correctly displayed",priority=6,enabled=false)
		public void viewEmployeeDetails() throws Exception {
			
		
		}
		
		@Test(description="Verify that the employment status of an employee can be updated",priority=7,enabled=false)
		public void editEmploymentStatus() throws Exception {
		
		
		}
		
		@Test(description="Verify that the employee list can be filtered based on various criteria",priority=8,enabled=false)
		public void filterEmployeeList() throws Exception {
		
		
		}
	
}
