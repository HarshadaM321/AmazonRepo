package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	private WebDriver driver;
	
	@FindBy (xpath = "(//div[@data-cy='title-recipe'])[1]//h2/a//span")
	private WebElement  clickOnselectedFirstItem ;
	
	@FindBy (xpath = "//div[@data-cy='title-recipe']//h2/a/span")
	private WebElement titleOfFirstitem ;
	
	@FindBy (xpath = "((//div[@data-cy='price-recipe']//a/span)[2]")
	private WebElement priceOfFirstItem           ;
	
	@FindBy (xpath = "(//button[@class='a-button-text'])[3]")
	private WebElement  addToCart;


	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void titleOfFirstitem() {
		titleOfFirstitem.click();
	}
	public void clickOnselectedFirstItem() {
		clickOnselectedFirstItem.click();
	}
	public void priceOfFirstItem() {
		priceOfFirstItem.click();
	}
	public void addToCart() {
		addToCart.click();
	}

	
}

