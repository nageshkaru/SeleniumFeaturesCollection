package selenium.features.iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrameHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//First we will try to find the element which is in the iFrame. 
		//Driver will throw no such element exception. We will catch and print it.
		try {
			boolean displayed = driver.findElement(By.cssSelector(".btn-sm.btn-min-block")).isDisplayed();
			System.out.println(displayed);
		}catch(NoSuchElementException e) {
			System.out.println("Element not found in the DOM");
		}
		
		
		//iFrames in the DOM uses the <iframe> html tags
		// switch to the iframe by id
		// we can switch to iframe by using index, id, name and element.
		driver.switchTo().frame("courses-iframe");
		
		System.out.println("I am in the iFrame");
		
		boolean displayed = driver.findElement(By.cssSelector(".btn-sm.btn-min-block")).isDisplayed();
		System.out.println(displayed);
		
		//you have to switch back to default content for access the elements in the DOM.
		driver.switchTo().defaultContent();
		
		
		
		//If iFrame takes some time to load like the payment pages. 
		//We can use explicit wait and switch to it after it has been loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#courses-iframe")));
		System.out.println("I am in the iFrame");
		
		displayed = driver.findElement(By.cssSelector(".btn-sm.btn-min-block")).isDisplayed();
		System.out.println(displayed);
		
		//the above code wait upto 10 seconds for iFrame to load.
		//If iFrame may loaded in 3 seconds, It will instantly switch to it.
		
		
		driver.switchTo().defaultContent();
	
		driver.quit();
	
	}
}
