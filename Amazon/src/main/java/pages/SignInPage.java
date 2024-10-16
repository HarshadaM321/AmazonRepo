package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	private WebDriver driver;
	private Actions action;

	@FindBy(xpath =" //input[@id='ap_email'] ")
	private WebElement email;
	
	@FindBy(xpath ="//input [@id='continue']")
	private WebElement continuebutton;
	
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath ="//input[@id='signInSubmit']")
	private WebElement signInSubmit;
	
	public SignInPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	    action =new Actions(driver);
	}
		public void enterEmailOrmobile(String mobileNo) {
		email.sendKeys(mobileNo);
	}
	public void clickOncontinuebutton() {
		continuebutton.click();
	}
    public void enterpassword(String userpassword) {	
	   password.sendKeys(userpassword);
	}
    public void clickOnsignInSubmit() {
    	signInSubmit.click();
	}
}
