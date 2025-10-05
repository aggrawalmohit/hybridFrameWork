package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage{

	RegisterPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"input-firstname\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"input-lastname\"]")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement email;
	
	
	@FindBy(xpath = "//*[@id=\"input-telephone\"]")
	WebElement telephone;
	
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"input-confirm\"]")
	WebElement confirmPasswrod;
	
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement continueBtn;
	
	
	public void fillRegisterationForm(String firstN , String lastN, String mail,
			String telePH , String pass , String cfmPass) {
		
		firstName.sendKeys(firstN);
		lastName.sendKeys(lastN);
		email.sendKeys(mail);
		telephone.sendKeys(telePH);
		password.sendKeys(pass);
		confirmPasswrod.sendKeys(cfmPass);
		continueBtn.click();
		
		
	}

}
