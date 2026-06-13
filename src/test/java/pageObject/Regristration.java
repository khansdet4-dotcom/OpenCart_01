package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Regristration extends BasePage{


	public Regristration(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	 WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath ="//input[@id='input-email']")
	 WebElement email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath ="//input[@id='input-password']")
	 WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	WebElement newsletter;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueButton;
	
	
	
	
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String emai) {
		email.sendKeys(emai);
	}
	
	public void enterTelephone(String tel) {
		telephone.sendKeys(tel);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String cpass) {
		confirmPassword.sendKeys(cpass);
	}
	
	public void clickNewsletter() {
		newsletter.click();
	}
	
	public void clickAgree() {
		agree.click();
	}
	public void clickContinue() {
		continueButton.click();
	}
	
	
}
