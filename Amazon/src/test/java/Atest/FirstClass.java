package Atest;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Base.Browser;
import Utils.Utility;
import pages.CartDetailsPage;
import pages.HomePage;
import pages.ProductdetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;

public class FirstClass extends Browser {

		private WebDriver driver;
		//private LoginPage loginPage ;
		private HomePage homepage;
		private SignInPage signInPage;
		private SearchResultPage searchResultPage;
		private CartDetailsPage cartDetailsPage;
		private ProductdetailsPage productdetailsPage;
	    private ArrayList<String> browserAddress;
	    private String testID;
	    
	@Parameters ("browser")
	
	@BeforeTest
    void openBrowser(String expectedBrowser) {
	
		driver =launchBowser(expectedBrowser);
	}
	
	@BeforeClass
	void initializePOM() {
	driver = new ChromeDriver();
	homepage = new HomePage (driver);
	signInPage = new SignInPage (driver);
	searchResultPage = new SearchResultPage(driver);
	productdetailsPage = new ProductdetailsPage(driver);
	cartDetailsPage = new CartDetailsPage(driver);
	
  }
	@BeforeMethod
	void loginToAmazon() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		homepage.clickOnsigninButton();
		signInPage.enterEmailOrmobile("7350871268");
		signInPage.clickOncontinuebutton();
		signInPage.enterpassword("Harshada@123");
		signInPage.clickOnsignInSubmit();
		 Thread.sleep(5000); 
	}
	@Test 
	void verifySearch() throws InterruptedException {
		testID="TC01";
		
	homepage.enterProductName("mobile");
	Thread.sleep(3000); 
	homepage.clickOnFirstsuggessionOption();
	homepage.clickOnsearchtButton();
    searchResultPage.clickOnselectedFirstItem();
	
	browserAddress = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(browserAddress.get(1));
       String expectedProductname =productdetailsPage.productTitle();
	    int  expectedProductPrice =productdetailsPage.productprice();
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
	    
	    productdetailsPage.addToCart();
	    //productdetailsPage.cartButton();
	   
	    String actualProductname=cartDetailsPage.cartproductTitle();
	    String actualProductPrice=cartDetailsPage.cartproductPrice();
	      
	     Assert.assertEquals(actualProductname, expectedProductname);
	     Assert.assertEquals(actualProductPrice, expectedProductPrice);
	     SoftAssert softAssert = new SoftAssert();
	     softAssert.assertEquals(actualProductname, expectedProductname);
	     softAssert.assertAll();
	}

	@AfterMethod
	void signOut() throws IOException {
    driver.close();
   driver.switchTo().window(browserAddress.get(0));
   homepage.clickOnsignoutButton();
   Utility.captureScreenShot(driver, testID);
	}
	
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
	//ArrayList<String> addr =new ArrayList<String>(driver.getWindowHandles());
	//driver.switchTo().window(addr.get(1));	

