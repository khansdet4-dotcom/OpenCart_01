package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Regristration;
import testBase.BaseClass;

public class TC_001_AccountRegristrationPage extends BaseClass{

	
	@Test(groups={"Regression","Master"})
	public void verify_Account_Regristration() {
		
		try {
		logger.info("**** Starting TC_001_AccountRegristrationPage ****");
		HomePage hp = new HomePage(driver);
		logger.info("**** Click on Register Link ****");
		hp.clickMyAccount();
		hp.clickRegistrationLink();
		
	
		
		Regristration rg = new Regristration(driver);
		logger.info("**** Providing Customer Data ****");
		rg.enterFirstName(randomString().toUpperCase());
		rg.enterLastName(randomString().toUpperCase());
		rg.enterEmail(randomString()+"@gmail.com");
		rg.enterTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		rg.enterPassword(password);
		rg.enterConfirmPassword(password);
		rg.clickNewsletter();
		rg.clickAgree();
		rg.clickContinue();
	}
		catch(Exception e) {
			logger.error("**** TC_001_AccountRegristrationPage Failed ****");
			logger.error(e.getMessage());
			logger.debug("Debug Information: ", e);
			Assert.fail();
		}
		logger.info("**** Finished ****");
	}
	
	
	
	
}
