package selenium.features.basic;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicOptions {

	public static void main(String[] args) {
		
    	
        WebDriver driver = new ChromeDriver();
        
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
		 
        System.out.println("Element enabled status of noEdit btn: "+enabled);
        
        driver.get("https://letcode.in/radio");
        
        boolean selectedStatusOfYes = driver.findElement(By.id("yes")).isSelected();
        
        System.out.println("Element enabled status of yes radio btn: "+selectedStatusOfYes);
        
        if(selectedStatusOfYes == false)
        	driver.findElement(By.id("yes")).click();
        
        boolean displayedStatusOfMaybe = driver.findElement(By.id("maybe")).isDisplayed(); //check the element is displayed in the web page
        
        System.out.println("Element display status of maybe radio btn: "+displayedStatusOfMaybe);
        
        boolean enabledStatusOfMaybe = driver.findElement(By.id("maybe")).isEnabled(); //check the element is enabled for input tags
        
        System.out.println("Element enabled status of maybe radio btn: "+enabledStatusOfMaybe);
        
        boolean selectedStatusOfRememberMe = driver.findElement(By.xpath("//label[contains(text(),'Remember me')]/input")).isSelected(); // checking the checkbox or toggle btn is selected 
        
        System.out.println("Element enabled status of remember me checkbox: "+selectedStatusOfRememberMe);
        
        driver.quit();        
        
        
	}
	
	
}
