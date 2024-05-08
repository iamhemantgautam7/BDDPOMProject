package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Locate All Doms
	@FindBy(id = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	// creating constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Actions Methods
	public void login(String strUser, String StrPwd) {
		userName.sendKeys(strUser);
		pwd.sendKeys(StrPwd);
		loginBtn.click();
	}

}
