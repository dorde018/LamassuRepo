package LamassuTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RetirementCalculatorTests extends BaseTestLamassu {
	@BeforeMethod
	public void beforeEachTest() {
		driver.navigate().to(loginUrl);
		driver.manage().window().maximize();
		String email = excelReader.getStringData("TSu1", 61, 2);
		loginPage.insertEmail(email);
		String password = excelReader.getStringData("TSu1", 62, 2);
		loginPage.insertPassword(password);
		loginPage.clickLoginButton();
	}
	
	@Test (priority = 0) 
	public void canNotCalculateIfAnnuaIncomeIsEmpty(){
		String annualExpenses = String.valueOf(excelReader.getIntegerData("TSu2", 6, 2));
		retirementCalculatorPage.insertAnnualExpenses(annualExpenses);
		String currentNetWorth = excelReader.getStringData("TSu2", 7, 2);
		retirementCalculatorPage.insertCurrentNetWorth(currentNetWorth);
		String currentAge = String.valueOf(excelReader.getIntegerData("TSu2", 8, 2));
		retirementCalculatorPage.insertCurrentAge(currentAge);
		retirementCalculatorPage.clickCalculateButton();
		String actualResult = retirementCalculatorPage.textBelowAnnualIncome();
		String expectedResult = excelReader.getStringData("TSu2", 11, 2);
		assertEquals(actualResult, expectedResult);
	}
		
	@Test (priority = 5)
	public void canNotCalculateIfAgeIsLetter() {
		String annualIncome =  String.valueOf(excelReader.getIntegerData("TSu2", 50, 2));
		retirementCalculatorPage.insertAnnualIncome(annualIncome);
		String annualExpenses = String.valueOf(excelReader.getIntegerData("TSu2", 51, 2));
		retirementCalculatorPage.insertAnnualExpenses(annualExpenses);
		String currentNetWorth = excelReader.getStringData("TSu2", 52, 2);
		retirementCalculatorPage.insertCurrentNetWorth(currentNetWorth);
		String currentAge = excelReader.getStringData("TSu2", 53, 2);
		retirementCalculatorPage.insertCurrentAge(currentAge);
		retirementCalculatorPage.clickCalculateButton();
		String actualResult = retirementCalculatorPage.textBellowCurrentAge();
		String expectedResult = excelReader.getStringData("TSu2", 56, 2);
		assertEquals(actualResult, expectedResult);
			
	}
	
	@Test (priority = 10)
	public void allValuesCorrectCheckingResult() {
		String annualIncome =  String.valueOf(excelReader.getIntegerData("TSu2", 111, 2));
		retirementCalculatorPage.insertAnnualIncome(annualIncome);
		String annualExpenses = String.valueOf(excelReader.getIntegerData("TSu2", 112, 2));
		retirementCalculatorPage.insertAnnualExpenses(annualExpenses);
		String currentNetWorth = excelReader.getStringData("TSu2", 113, 2);
		retirementCalculatorPage.insertCurrentNetWorth(currentNetWorth);
		String currentAge = String.valueOf(excelReader.getIntegerData("TSu2", 114, 2));
		retirementCalculatorPage.insertCurrentAge(currentAge);
		retirementCalculatorPage.clickCalculateButton();
		String actualResult = retirementCalculatorPage.textResult();
		String expectedResult = excelReader.getStringData("TSu2", 117, 2);	
	}
	
	@Test (priority = 15)
	public void userStaysOnTheSamePage() {
		String annualIncome =  String.valueOf(excelReader.getIntegerData("TSu2", 65, 2));
		retirementCalculatorPage.insertAnnualIncome(annualIncome);
		String annualExpenses = String.valueOf(excelReader.getIntegerData("TSu2", 66, 2));
		retirementCalculatorPage.insertAnnualExpenses(annualExpenses);
		String currentNetWorth = excelReader.getStringData("TSu2", 67, 2);
		retirementCalculatorPage.insertCurrentNetWorth(currentNetWorth);
		String currentAge = String.valueOf(excelReader.getIntegerData("TSu2", 68, 2));
		retirementCalculatorPage.insertCurrentAge(currentAge);
		retirementCalculatorPage.clickCalculateButton();
		driver.navigate().refresh();
		boolean expectedResult = retirementCalculatorPage.isRetirementCalculatortPresent();
		assertTrue(expectedResult);
		
	}
	
	@AfterMethod
	public void afterEachTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
