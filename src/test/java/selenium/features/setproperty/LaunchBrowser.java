package selenium.features.setproperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		System.out.println("Launching Firefox Browser");
		System.setProperty("webdriver.gecko.driver", "/home/nageshwaran_k/geckodriver-v0.32.2-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		
		System.out.println("Launching Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "/home/nageshwaran_k/chromedriver_linux64/chromedriver");
		//remote allow origins added for prevent from connection reset error
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		
		
	}

}
