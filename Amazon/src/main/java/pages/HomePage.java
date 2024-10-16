package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//span[text()='Account & Lists']")
	private WebElement accountlist;
	
	@FindBy(xpath = "//span[text()='Sign in']")
	private WebElement signinButton;
	
	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement signoutButton;
	
	@FindBy(xpath = "//input[@name='field-keywords']")
	private WebElement searchtextbox;
	
	@FindBy(xpath = "//input[@Id='nav-search-submit-button']")
	private WebElement searchtButton;
	
	@FindBy(xpath = "(//div[@id='nav-flyout-searchAjax']//div[@role='button'])[1]") //(//div[@class='s-suggestion-container'])[1]
	private WebElement suggessionOption;
	
	private Actions action;
	private WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	   action =new Actions(driver);
	}
	  public void clickOnaccountlist() {
		accountlist.click();
	}
	  
	public void clickOnsigninButton() {
		action.moveToElement(accountlist).moveToElement(signinButton).click().build().perform();
	}
	public void clickOnsignoutButton() {
		action.moveToElement(accountlist).moveToElement(signoutButton).click().build().perform();
			}	
	public void enterProductName(String productname) {
		searchtextbox.sendKeys(productname);
			}	
	public void clickOnsearchtButton() {
		searchtButton.click();
	}
	public void clickOnFirstsuggessionOption() {
		suggessionOption.click();
			}			
				
}
