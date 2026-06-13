package testCase;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Login;
import pageObject.MyAccount;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	
	@Test(groups="Sanity")
	public void verify_Login() {
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		Login lg = new Login(driver);
		lg.enterEmail(p.getProperty("email"));
		lg.enterPassword(p.getProperty("password"));
		lg.clickLoginButton();
		
		MyAccount mp = new MyAccount(driver);
		boolean expectRes =mp.checkMyAccountVisible();
		Assert.assertEquals(expectRes, true, "login failed");
	}
		catch(Exception e) {
			Assert.fail();
		}
		
	}
}
