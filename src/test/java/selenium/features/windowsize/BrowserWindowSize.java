package selenium.features.windowsize;

import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowSize {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launching Firefox Browser");
        //setup firefox binary
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        
        //To load the url
        driver.navigate().to("https://www.google.com/");
        
        System.out.println(driver.getTitle());
          
        //completely maximize window
        driver.manage().window().maximize();
        
        Thread.sleep(1000);
        
        driver.manage().window().minimize();
        
        Thread.sleep(1000);
        
        //completely maximize web page fit into the screen of monitor
        driver.manage().window().fullscreen();
        
        Thread.sleep(1000);
        
        
        driver.manage().window().setSize(new Dimension(1440, 900));
        
        Thread.sleep(1000);
        
        String currentWindowSize = driver.manage().window().getSize().toString();
        
        System.out.println("Current window size: "+currentWindowSize);
        
        
        driver.manage().window().setPosition(new Point(20, 100));
        
        int currentPositionX = driver.manage().window().getPosition().getX();
        int currentPositionY = driver.manage().window().getPosition().getY();
        
        System.out.println("Current window position in X: "+currentPositionX);
        System.out.println("Current window position in Y: "+currentPositionY);
	
        driver.quit();
        
	}
	
}
