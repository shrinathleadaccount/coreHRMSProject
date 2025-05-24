package pagesPack;

import org.openqa.selenium.By;

import utilsPack.CommonUtils;

public class PIMPage {

	// Web locators

		private final static By by_pim = By.xpath("//li[@id='pim']");
		private final static By by_addEmp = By.xpath("//*[@id='pim']/ul/li[2]/a");
		private final static By by_firstName = By.xpath("//input[@id='txtEmpFirstName']");
		private final static By by_lastName = By.xpath("//input[@id='txtEmpLastName']");
		private final static By by_iframe = By.xpath("//iframe[@id='rightMenu']");
		private final static By by_save = By.xpath("//input[@id='btnEdit']");
		private final static By by_back = By.xpath("//input[@class='backbutton']");
		private final static By by_empName = By.xpath("//a[contains(text(),'Odin')]");
		private final static By by_select = By.xpath("//select[@id='loc_code']");
		private final static By by_search = By.xpath("//input[@id='loc_name']");
		private final static By by_searchBtn = By.xpath("//input[@class='plainbtn']");
		private final static By by_editBtn = By.xpath("//input[@id='btnEditPers']");
		 
		// Getter/Setter Helping functions
		public static void clickOnElement() throws Exception {
			CommonUtils.clickElement(getPim());
		}
		
		public static By getPim() throws Exception {
			return by_pim;
		}
		
		public static By getAddEmp() throws Exception {
			return by_addEmp;
		}
		
		public static By getFirstName() throws Exception {
			return by_firstName;
		}
		
		public static By getLastName() throws Exception {
			return by_lastName;
		}
		
		public static By getFrame() throws Exception {
			return by_iframe;
		}
		
		public static By getSave() throws Exception {
			return by_save;
		}
		
		public static By getSelect() throws Exception {
			return by_select;
		}
		
		public static By getSearch() throws Exception {
			return by_search;
		}
		
		public static By getSearchBtn() throws Exception {
			return by_searchBtn;
		}

		public static By getBackButton() {
			// TODO Auto-generated method stub
			return by_back;
		}
		
		public static By getEmpName() {
			// TODO Auto-generated method stub
			return by_empName;
		}
		
		public static By getEditBtn() {
			return by_editBtn;
		}
	
}
