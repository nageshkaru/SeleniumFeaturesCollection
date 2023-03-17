package selenium.features.elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element {

	public static void main(String[] args) {
		
		System.out.println("Launching Browser");
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize(); // maximize the browser
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 seconds to find element applicable for findelement function each time driver calls it
        
        driver.get("https://letcode.in/");
        
        System.out.println(driver.getTitle()); // print the page title
        
        System.out.println(driver.getCurrentUrl()); // print the page URL
        
        driver.findElement(By.linkText("Explore Workspace")).click(); // click an element
        
        driver.findElement(By.linkText("Edit")).click(); // click an element
        
        driver.findElement(By.id("fullName")).sendKeys("I am Software Tester"); // type in the input field
        
        driver.findElement(By.id("fullName")).sendKeys(Keys.TAB); // pressing Tab in keyboard 
        
        driver.findElement(By.id("join")).click();
        
        driver.findElement(By.id("join")).sendKeys(" person"); // 
        
        String value = driver.findElement(By.id("getMe")).getAttribute("value"); // get the value in the input field use  getAttribute("value")
        
        System.out.println("Value: "+value);
        
        driver.findElement(By.id("clearMe")).clear(); // clear the textbox 
        
        boolean enabled = driver.findElement(By.id("noEdit")).isEnabled(); // check the element enabled
		 
        System.out.println("Element enabled status: "+enabled);
        
        String readOnly = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
        if(!readOnly.equals(null))
        	System.out.println("Element is readOnly ");
        else
        	System.out.println("Element is not readOnly ");
        
        driver.quit();
        
        
        
	}
	
	
}
