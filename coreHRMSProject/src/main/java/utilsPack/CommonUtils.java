package utilsPack;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	public static WebDriverWait wait;
	public static Properties config;
	public static WebDriver driver;
	public static FileInputStream fis ;
	public static final String configFilePath = "\\src\\test\\resources\\config.properties";

	// -------------------- Properties Implementations ----------------------
	
	//this method loads the application's configuration settings from a properties file.
		public static void readPropertiesFile() throws Exception{
									
			try {
				 fis = new FileInputStream(System.getProperty("user.dir") + configFilePath);
				 config = new Properties();
				 config.load(fis);
			} catch (Exception e) {
				TestNGUtility.assertFail(e.getMessage());
			}
		}
//The method launches a specified web browser and navigates to a URL.	
	public static void launchBrowserAndNavigateToApp() {

		try {
			String browserName = config.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}else if(browserName.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}else if(browserName.equalsIgnoreCase("edge")) {
				
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}
				
			driver.get(config.getProperty("url"));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ---------------------- Selenium Implementations -------------------------
	//method locates a web element on the page.
	public static WebElement findElement(By by){
		WebElement element = null;
		try {
			element = driver.findElement(by);
			return element;
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return element;
	}
//The method switches the browser's focus to a specified iframe.
	public static void switchToFrame(By by){
		WebElement iframe=null;
		try {
	
			iframe = driver.findElement(by);
			driver.switchTo().frame(iframe);
			
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		
	}

	//method locates a list of web elements on the page.
	public static List<WebElement> findElements(By by){
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(by);
			return elements;
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return elements;
	}
	
	//method clicks on a web element
	public static void clickElement(By by){
		try {
			
			findElement(by).click();
		
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	//it clears any existing text from the web element before entering the new value. This method enters the value into the input field.
	public static void enterValue(By by, String value, Boolean isClear){
		try {
		
			if(isClear)
				clearWholeText(by);
			findElement(by).sendKeys(value);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	//The method is used to delete all the text in a web element (like a text box or input field).
	public static void clearWholeText(By by) throws Exception {
		try {
			findElement(by).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	//The method is designed to select an option from a dropdown menu.
	public static void selectDropDownValue(By DropDown, String option) {
		try {
			
			clickElement(DropDown);
			
			clickElement(getCommonLocatorUsingText(option));
		}catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	
//method is used to switch the browser's focus from the current window to a new one (usually a popup or a new tab).
	
	public static void switchToWindow() {
		try {
			String parentWindow = driver.getWindowHandle();
			
			for (String window : driver.getWindowHandles()) {
			    if(!parentWindow.contentEquals(window)) {
			        driver.switchTo().window(window);
			        break;
			    }
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	
	//method creates an XPath locator to find an element on the web page based 
	//on its visible text.
	
	public static By getCommonLocatorUsingText(String value) throws Exception {
		By by = null;
		try {
			
			by = By.xpath("//*[text()='" + value + "']");
			
		}catch (Exception e) {
			
			
			TestNGUtility.assertFail(e.getMessage());
		}
		return by;
	}
	
	//The method retrieves the title of the current browser window.
	public static String getWindowTitle() {
		String title = null ;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return title;
	}
	
	//method retrieves the URL of the current web page.
	public static String getCurrentPageUrl() {
		String url= null;
		try {
			url = driver.getCurrentUrl();
		}catch(Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return url;
	}
	//method retrieves the visible text from a web element.
	public static String getElementText(By by) {
		String text = null ;
		try {
			text = findElement(by).getText();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return text;
	}
	
	//method retrieves the value of a specified attribute from a web element.
	public static String getElementAttributeValue(By by, String attributeName) {
		String attributeValue = null ;
		try {
			attributeValue = findElement(by).getAttribute(attributeName);
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return attributeValue;
	}
	
	//wait for a given number of seconds
	public static void hardWait(int millis) {
		try {
			Thread.sleep(millis * 1000);
		}catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	
	//method checks if a web element is visible on the webpage
	public static Boolean isElementDisplayed(By by) {
		Boolean result = false;
		try {
		
			result = findElement(by).isDisplayed();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return result;
	}
	
	//method checks if a web element is selected or checked (typically used for checkboxes or radio buttons).
	public static Boolean isElementSelected(By by) {
		Boolean result = false;
		try {
			result = findElement(by).isSelected();
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return result;
	}
	//Scroll till the target element
	
	public static void scrollToElement(By by) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", findElement(by));
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	
	
//to wait for a specific web element to become visible on a web page
	public static boolean waitForElementToBeVisible(By by) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("loadTime"))));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			flag = true;
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
		return flag;
	}

	//This method performs a drag-and-drop action
	public static void dragAndDrop(By byDrag, By byDrop) {
		try {
			(new Actions(driver)).dragAndDrop(findElement(byDrag), findElement(byDrop)).build().perform();
		}catch(Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	//This method performs a mouse hover action over a specific web element
	public static void moveToElement(By by) {
		try {
			if(waitForElementToBeVisible(by)) {
				new Actions(driver).moveToElement(findElement(by)).perform();
			}
		} catch (Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	
	//This method selects dropdown value
	public static void selectDropdownValue(By by, int index) {
	    try {
	        WebElement dropdownElement = findElement(by);
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByIndex(index); // Selects option by index
	    } catch (Exception e) {
	        TestNGUtility.assertFail("Failed to select index '" + index + "' from dropdown: " + e.getMessage());
	    }
	}
}
