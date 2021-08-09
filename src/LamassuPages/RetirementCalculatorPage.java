package LamassuPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetirementCalculatorPage {
	WebDriver driver;
	WebElement boldRetirementCalculatorText;
	WebElement annualIncome;
	WebElement annualExpenses;
	WebElement currentNetWorth;
	WebElement currentAge;
	WebElement calculateButton;
	WebElement errorMessageBelowAnnualIncome;
	WebElement errorMessageBelowCurrentAge;
	WebElement resultText;
	
	public RetirementCalculatorPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getBoldRetirementCalculatorText() {
		return driver.findElement(By.cssSelector(".jss70"));
	}
	
	public boolean isRetirementCalculatortPresent() {
		boolean present;
		try {
			getBoldRetirementCalculatorText().getText();
			present = true;	
		} catch (Exception e) {
			present = false;
		}
		return present;
	}

	public WebElement getAnnualIncome() {
		return driver.findElement(By.name("anualIncome"));
	}

	public void insertAnnualIncome(String annualIncome) {
		getAnnualIncome().clear();
		getAnnualIncome().sendKeys(annualIncome);
	}

	public WebElement getAnnualExpenses() {
		return driver.findElement(By.name("annualExpenses"));
	}

	public void insertAnnualExpenses(String annualExpenses) {
		getAnnualExpenses().clear();
		getAnnualExpenses().sendKeys(annualExpenses);
	}

	public WebElement getCurrentNetWorth() {
		return driver.findElement(By.name("currentNetWorth"));
	}

	public void insertCurrentNetWorth(String currentNetWorth) {
		getCurrentNetWorth().clear();
		getCurrentNetWorth().sendKeys(currentNetWorth);
	}

	public WebElement getCurrentAge() {
		return driver.findElement(By.name("currentAge"));
	}

	public void insertCurrentAge(String currentAge) {
		getCurrentAge().clear();
		getCurrentAge().sendKeys(currentAge);
	}

	public WebElement getCalculateButton() {
		return driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary"));
	}

	public void clickCalculateButton() {
		getCalculateButton().click();
	}

	public WebElement getErrorMessageBelowAnnualIncome() {
		return driver.findElement(By.cssSelector(".jss46"));
	}
	
	public String textBelowAnnualIncome() {
		return getErrorMessageBelowAnnualIncome().getText();
	}

	public WebElement getErrorMessageBelowCurrentAge() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div/form/div/div[1]/div/div[5]/div[2]"));
	}
	public String textBellowCurrentAge() {
		return getErrorMessageBelowCurrentAge().getText();
	}

	public WebElement getResultText() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div/div/h4"));
	}
	public String textResult() {
		return getResultText().getText();
	}
}

