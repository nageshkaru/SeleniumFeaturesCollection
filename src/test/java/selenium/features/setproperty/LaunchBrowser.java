package selenium.features.setproperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		System.out.println("Launching Firefox Browser");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		
		System.out.println("Launching Chrome Browser");
		driver = new ChromeDriver();
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		
		
	}

}
