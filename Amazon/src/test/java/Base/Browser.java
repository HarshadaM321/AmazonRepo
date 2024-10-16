package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
    public static WebDriver launchChromeBowser() {
    	
     	WebDriver driver = new ChromeDriver();
           return driver;
      } 
       public static WebDriver launchEdgeBowser() {

          WebDriver driver = new EdgeDriver();
            return driver;
     }  
}



