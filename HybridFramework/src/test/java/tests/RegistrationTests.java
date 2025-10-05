package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTests extends BaseClass{
	
	RegisterPage registerPage;
	
	
	
	@Test(groups = {"sanity"})
	public void registerFormTest() throws InterruptedException 
	{
		
		logger.info("*************** starting test ************************");
		HomePage homePage = new HomePage(driver.get());
		homePage.clickOnMyAccount();
		registerPage= homePage.clickOnRegisterLink();
		registerPage.fillRegisterationForm("sdsd", "sgbr", "gsgg", "efewf", "efef", "ewfewg");
		//Assert.assertTrue(false);
	}
}
