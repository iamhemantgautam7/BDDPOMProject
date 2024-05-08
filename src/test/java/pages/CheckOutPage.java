package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(id = "continue")
	WebElement contBtn;

	@FindBy(id = "finish")
	WebElement finishBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Thank you')]")
	WebElement successMsg;
	

	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterDetails(String firstname,String lastname,String postal) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		postalCode.sendKeys(postal);

	}

	public void continueOrder() {
		contBtn.click();

	}

	public void finish() {

		finishBtn.click();
	}
	
	public String getSuccessMsg() {
		
		String suMsg=successMsg.getText();
		return suMsg;
		
		
		
	}
	

}
