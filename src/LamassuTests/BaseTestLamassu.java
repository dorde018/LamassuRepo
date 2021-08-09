package LamassuTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import LamassuPages.LoginPage;
import LamassuPages.RetirementCalculatorPage;


public class BaseTestLamassu {
	ExcelReader excelReader;
	WebDriver driver;
	String loginUrl;
	LoginPage loginPage;
	RetirementCalculatorPage retirementCalculatorPage;
	
	@BeforeClass
	public void beforeAllTests() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		excelReader =  new ExcelReader("data/Lamassu tests.xlsx");
		loginUrl = excelReader.getStringData("URL", 0, 0);
		loginPage = new LoginPage(driver);
		retirementCalculatorPage = new RetirementCalculatorPage(driver);
	}
	@AfterClass
	public void afterAllTests() {
		driver.close();
	}	

}
