package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Login;
import pageObject.MyAccount;
import testBase.BaseClass;
import utils.DataProviders;




public class TC_003_LOGIN_DDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_loginDDT(String email,String password,String exp_result) {
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		Login lg = new Login(driver);
		lg.enterEmail(email);
		lg.enterPassword(password);
		lg.clickLoginButton();
		
		MyAccount ma= new MyAccount(driver);
		boolean targetPage = ma.checkMyAccountVisible();
		
		if(exp_result.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				ma.clickLogoutLink();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else if(exp_result.equalsIgnoreCase("invalid")){
			if(targetPage==true ) {
				
				ma.clickLogoutLink();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		
		
	}

}
