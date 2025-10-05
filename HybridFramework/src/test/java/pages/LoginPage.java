package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	WebElement login_btn;
	
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
	WebElement logOut_btn;
	
	@FindBy(xpath = "//div[@id=\"content\"]//*[text()=\"My Account\"]")
	WebElement myAccount_txt;
	
	@FindBy(xpath = "//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	WebElement loginError_msg;
	

	public void login(String email, String pwd) {
		
		this.email.sendKeys(email);
        password.sendKeys(pwd);
        login_btn.click();
		
	}
	
	public void logout() 
	{
		logOut_btn.click();
	}
	
	public boolean verifyMyAccPage() 
	{
	return	myAccount_txt.isDisplayed();
	}
	
	public boolean verifyLoginErrorMessage()
	{
		return	loginError_msg.isDisplayed();
	}
	
}
