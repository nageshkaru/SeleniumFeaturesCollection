package selenium.features.setproperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LaunchBrowserInHeadlessMode {

	public static void main(String[] args) {
		System.out.println("Launching Firefox Browser");
		//This below line Browser_logfile is for reduce the firefox log messages in console nothing else.
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		
		System.out.println("Launching Chrome Browser");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless=new");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
