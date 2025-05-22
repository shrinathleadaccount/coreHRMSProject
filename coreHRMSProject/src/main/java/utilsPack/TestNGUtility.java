package utilsPack;

import org.testng.Assert;

public class TestNGUtility {

	//This method checks if the actual string contains the expected string.
		public static void assertTrue(String expected, String actual) {
			if (actual.contains(expected)) {
				Assert.assertTrue(actual.contains(expected));
			} else {
				System.out.println(expected+" not present in "+actual);
			}
		}
	//This method checks if two integers, expected and actual, are equal.
		public static void assertEquals(int expected, int actual) {
			if (actual == expected) {
				Assert.assertEquals(actual, expected);
			} else {
				System.out.println(expected+" is not matched with "+actual);
			}
		}
		// when the test fails, it logs a failure message
		public static void assertFail(String logMessage) {
			Assert.fail(logMessage);
		}

	
}
