package Base;

	import java.time.Duration;

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
	     
	  public static WebDriver launchBowser (String targetBrowser) 
	  {
	    	   WebDriver driver= null;
	    	   
	    	   if (targetBrowser.equals("Chrome")) 
	    	   {
	    		   driver = launchChromeBowser();
	    	   }
	    	   if(targetBrowser.equals("Edge")) {
	    		   driver =launchEdgeBowser();
	    	   } 
	    	   
	    	 driver.manage().window().maximize();
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    	 return driver;
	    	 
	}
	}



