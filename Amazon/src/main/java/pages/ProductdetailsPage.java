package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductdetailsPage {

	@FindBy (xpath = "//h1[@id='title']/span")
	private WebElement productTitle ;
	
	@FindBy (xpath = "(//div[@class='celwidget'])[110]")
	private WebElement productprice ;
	
	@FindBy (xpath = "(((//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCart ;
	
	@FindBy (xpath = "((//span[@id='attach-sidesheet-view-cart-button'])[1]")
	private WebElement cartButton;
	////span[@id='attach-sidesheet-view-cart-button']//input[@class='a-button-input']

	@FindBy (xpath = "//input[@id='buy-now-button']")
	private WebElement buyNow ; 
	
	private WebDriver driver;
	
	public ProductdetailsPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	public String productTitle() {
		return productTitle.getText().trim();	
	}
	public int productprice() {
	  productprice.getText().trim();
	return 0;	
	}
	public void addToCart() {
		addToCart.click();	
	}
	public void buyNow() {
		driver.switchTo().frame(buyNow);
	}
	public void cartButton() {
		cartButton.click();
	}

//	String priceText = productPrice.getText().trim();
//	priceText = priceText.replaceAll("[^0-9]", "");
//	int price = Integer.parseInt(priceText);
//	price = price/100;
//	return  price;
}
