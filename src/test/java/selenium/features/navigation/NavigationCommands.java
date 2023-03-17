package selenium.features.navigation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationCommands {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		System.out.println("Launching Firefox Browser");
        //setup firefox binary
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        
        //To load the url
        driver.navigate().to("https://translate.google.com/");
        
        System.out.println(driver.getTitle());
        
      //open url with URL Object button in the browser
        URL urlObject = new URL("https://www.google.com/");
        
        driver.navigate().to(urlObject);
           
        System.out.println(driver.getTitle());
        
        //click back button in the browser
        driver.navigate().back();
        
        System.out.println(driver.getTitle());
        
        //click forward button in the browser
        driver.navigate().forward();
        
        System.out.println(driver.getTitle());
        
        //click refresh in the browser
        driver.navigate().refresh();
        
        System.out.println(driver.getTitle());
        
        //Quit driver instance and close all windows
        driver.quit();
        
	}

}
