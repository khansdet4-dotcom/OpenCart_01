package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
 
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerationLink;
	
	@FindBy(xpath ="(//a[text()='Login'])[1]")
	WebElement loginLink;
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegistrationLink() {
		registerationLink.click();
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
}
