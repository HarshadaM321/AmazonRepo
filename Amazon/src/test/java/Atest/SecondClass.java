package Atest;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartDetailsPage;
import pages.HomePage;
import pages.ProductdetailsPage;
import pages.SignInPage;

public class SecondClass {
	private WebDriver driver;
	//private LoginPage loginPage ;
	private HomePage homepage;
	private SignInPage signInPage;

	@BeforeClass
	void launchBrowser() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
    }
	@BeforeMethod
	void loginToAmazon() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		
		homepage = new HomePage (driver);
		homepage.clickOnsigninButton();
		signInPage = new SignInPage (driver);
		signInPage.enterEmailOrmobile("7350871268");
		signInPage.clickOncontinuebutton();
		signInPage.enterpassword("Harshada@123");
		 Thread.sleep(3000);
		signInPage.clickOnsignInSubmit();
		 Thread.sleep(10000);
	}    
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

