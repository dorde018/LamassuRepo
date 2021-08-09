package LamassuTests;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTestLamassu {
	@BeforeMethod
	public void beforeEachTest() {
		driver.navigate().to(loginUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 0) 
	public void userCanNotLogInIfPasswordFieldLeftEmpty(){
		String email = excelReader.getStringData("TSu1", 19, 2);
		loginPage.insertEmail(email);
		String password = excelReader.getStringData("TSu1", 20, 2);
		loginPage.insertPassword(password);
		loginPage.clickLoginButton();
		boolean expectedResult = retirementCalculatorPage.isRetirementCalculatortPresent();
		assertFalse(expectedResult);
	}
	
	@Test (priority = 5) 
	public void userCanNotLogInIfEmailFieldLeftEmpty(){
		String email = excelReader.getStringData("TSu1", 33, 2);
		loginPage.insertEmail(email);
		String password = excelReader.getStringData("TSu1", 34, 2);
		loginPage.insertPassword(password);
		loginPage.clickLoginButton();
		String actualResult = loginPage.textBelowEmailField();
		String expectedResult = excelReader.getStringData("TSu1", 38, 2);
		assertEquals(actualResult, expectedResult);
	}
	
	@Test (priority = 10) 
	public void userCanNotLogInIfBothFieldSLeftEmpty(){
		String email = excelReader.getStringData("TSu1", 47, 2);
		loginPage.insertEmail(email);
		String password = excelReader.getStringData("TSu1", 48, 2);
		loginPage.insertPassword(password);
		loginPage.clickLoginButton();
		boolean expectedResult = loginPage.isBoldSignInTextPresent();
		assertTrue(expectedResult);
	}
	
	@Test (priority = 15) 
	public void userCanLogInWithValidCredentials(){
		String email = excelReader.getStringData("TSu1", 61, 2);
		loginPage.insertEmail(email);
		String password = excelReader.getStringData("TSu1", 62, 2);
		loginPage.insertPassword(password);
		loginPage.clickLoginButton();
		boolean expectedResult = retirementCalculatorPage.isRetirementCalculatortPresent();
		assertTrue(expectedResult);
	}
	
	@AfterMethod
	public void afterEachTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
