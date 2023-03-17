package selenium.features.webdrivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * How to set ThirdParty WebDriverManager for automatic download and management of driver binaries
 * Add this below dependency in your pom.xml file
 *  <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
 */
public class WebDriverManagerTest 
{

	public static void main(String[] args) {
		
		System.out.println("Launching Chrome Browser");
    	//setup chrome binary
		WebDriverManager.chromedriver().setup();
    	//this ChromeOptions added for prevent connection reset error
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
        
        System.out.println("Launching Firefox Browser");
        //setup firefox binary
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://google.com/");
        System.out.println(driver.getTitle());
        driver.quit();

        
	}
 
}
