package selenium.features.windows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// Initialize chrome driver
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Driver wait for 10 seconds each time the findElement and findElements method
		// is called
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// to maximize the window
		driver.manage().window().maximize();
		
		String currentPageTitle = driver.getTitle();

		System.out.println(currentPageTitle);

		// getWindowHandle() return the current window
		String currentWindow = driver.getWindowHandle();

		By openWindowBtn = By.cssSelector("#openwindow");
		By openTabBtn = By.cssSelector("#opentab");

		driver.findElement(openWindowBtn).click();

		// getWindowHandles() method returns the Set of string which contains all the
		// available windows
		for (String window : driver.getWindowHandles()) {
			if (!currentWindow.equals(window)) {
				// This line for switching to another window
				driver.switchTo().window(window);
			}
		}

		System.out.println(driver.getTitle());

		// to close current and without terminating the session
		driver.close();

		// Now switch the driver reference to current window
		driver.switchTo().window(currentWindow);

		driver.findElement(openTabBtn).click();

		// getWindowHandles() method returns the Set of string which contains all the
		// available windows
		for (String window : driver.getWindowHandles()) {
			if (!currentWindow.equals(window)) {
				// This line for switching to another window
				driver.switchTo().window(window);
			}
		}

		System.out.println(driver.getTitle());

		driver.close();

		// Now switch the driver reference to current window
		driver.switchTo().window(currentWindow);

		// To open new window
		driver.switchTo().newWindow(WindowType.WINDOW);

		driver.get("https://www.yahoo.com/");

		System.out.println(driver.getTitle());

		driver.close();

		// Now switch the driver reference to current window
		driver.switchTo().window(currentWindow);

		// To open new Tab
		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.bing.com/");

		System.out.println(driver.getTitle());

		//Switch to window by title
		for (String window : driver.getWindowHandles()) {
			if (driver.switchTo().window(window).getTitle().contains(currentPageTitle)) {
				// This line for switching to another window
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				break;
			}
		}
		

		// Close driver and Driver session
		driver.quit();

	}

}
