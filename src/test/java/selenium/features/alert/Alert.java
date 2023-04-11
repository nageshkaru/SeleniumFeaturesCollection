package selenium.features.alert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Launching Browser");
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize(); // maximize the browser
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 seconds to find element applicable for findelement function each time driver calls it
        
        driver.get("https://letcode.in/alert");
        
        driver.findElement(By.id("accept")).click();
        
        System.out.println(driver.switchTo().alert().getText());
        
        driver.switchTo().alert().accept();
        
        driver.findElement(By.id("confirm")).click();
        
        Thread.sleep(1000);
        
        driver.switchTo().alert().dismiss();
        
        driver.findElement(By.id("prompt")).click();
        
        Thread.sleep(1000);
        
        driver.switchTo().alert().sendKeys("I am Thomas Shelby");
        
        driver.switchTo().alert().accept();
        
	}

}
