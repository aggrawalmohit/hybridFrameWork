package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataProvider;

public class LoginTests extends BaseClass{
	
	
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProvider.class,groups = {"sanity"})
	public void loginTest(String userName, String pwd,String dataStatus) throws InterruptedException 
	{
		
		
		
	logger.info("*************** starting test ************************");
		HomePage homePage = new HomePage(driver.get());
		homePage.clickOnMyAccount();
	LoginPage lp =	homePage.clickOnLoginLink();
	
	lp.login(userName, pwd);
	
	
	if(dataStatus.equals("Valid")) 
	{
	 
		Assert.assertTrue(lp.verifyMyAccPage(), "Account Page is not displayed");	
		lp.logout();
	}
	
	else if(dataStatus.equals("Invalid"))
	{
		
		Assert.assertTrue(lp.verifyLoginErrorMessage(), "Login error message is not displayed");
		
	}
	
	Thread.sleep(2000);
	}
	
	
	

}
