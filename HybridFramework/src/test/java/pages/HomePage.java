package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(xpath = "//a[@title=\"My Account\"]")
	WebElement myAccount;
	
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()='Login']")
	WebElement loginLink;
	

	
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	
	public RegisterPage clickOnRegisterLink() throws InterruptedException {
		
		registerLink.click();
		Thread.sleep(2000);
		return new RegisterPage(driver);
		
	}
	
public LoginPage clickOnLoginLink() throws InterruptedException {
		
		loginLink.click();
		Thread.sleep(2000);
		return new LoginPage(driver);
		
	}

}
