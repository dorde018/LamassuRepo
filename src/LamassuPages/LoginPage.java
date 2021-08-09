package LamassuPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement emailField;
	WebElement textBelowEmailField;
	WebElement passwordField;
	WebElement loginButton;
	WebElement boldSignInText;
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getEmailField() {
		return driver.findElement(By.name("email"));
	}

	public void insertEmail(String Email) {
		getEmailField().clear();
		getEmailField().sendKeys(Email);
	}

	public WebElement getTextBelowEmailField() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div/form/div/div[1]/div/div[2]/div[2]"));
	}
	
	public String textBelowEmailField() {
		return getTextBelowEmailField().getText();
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.name("password"));
	}

	public void insertPassword(String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary"));
	}
	public void clickLoginButton() {
		getLoginButton().click();
	}

	public WebElement getBoldSignInText() {
		return driver.findElement(By.cssSelector(".jss46"));
	}
	public String boldSignInText() {
		return getBoldSignInText().getText();
}
	public boolean isBoldSignInTextPresent() {
		boolean present;
		try {
			getBoldSignInText().getText();
			present = true;	
		} catch (Exception e) {
			present = false;
		}
		return present;
	}
}
