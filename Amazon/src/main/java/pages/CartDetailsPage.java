package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartDetailsPage {
	
	
	@FindBy (xpath = "//div[@class='sc-item-content-group'][1]//h4//span[@class='a-truncate-cut']")
	private WebElement cartproductTitle ;
	
	@FindBy (xpath = "((//div[@class='sc-item-price-block'])[1]//div[@class='sc-badge-price-to-pay']//span)[1]")
	private WebElement cartproductPrice;
	
	public CartDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String cartproductTitle() {
		return cartproductTitle.getText().trim();
	}
	public String cartproductPrice() {
		return cartproductPrice.getText().trim();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
