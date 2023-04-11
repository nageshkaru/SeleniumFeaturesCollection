package com.selenium.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		
		// Driver wait for 10 seconds each time the findElement and findElements method is called
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// To maximize the window
		driver.manage().window().maximize();
		
		By googleSearchBox = By.xpath("//*[@name='q']");
		
		driver.findElement(googleSearchBox).sendKeys("Selenium");
		driver.findElement(googleSearchBox).sendKeys(Keys.ENTER);
		
		// Wait for 20 seconds for each condition
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// Wait for title to be 
		wait.until(ExpectedConditions.titleContains("Selenium - Google Search"));
		
		driver.get("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");
		
		By getUser = By.cssSelector("#save");
		
		//waiting for element to appear
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(getUser)));
		
		//click get user btn
		driver.findElement(getUser).click();
		
		//Waiting for the user profile to appear
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#loading > img"))));

		System.out.println("User profile displayed status: "+driver.findElement(By.cssSelector("div#loading > img")).isDisplayed());
		
//		Like this there are so many conditional waits in the ExpectedConditions class.
		
//		WebElement element = null;
//		
//		ExpectedConditions.visibilityOf(element);
//		ExpectedConditions.invisibilityOf(element);
//		ExpectedConditions.presenceOfElementLocated(getUser);
//		ExpectedConditions.elementToBeClickable(element);
//		ExpectedConditions.urlContains("");
//		ExpectedConditions.urlToBe("");
//		ExpectedConditions.urlMatches("");	
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		By autoSuggest = By.cssSelector("#autocomplete");
		
		driver.findElement(autoSuggest).sendKeys("Al");
		
		By listUsers = By.cssSelector("#ui-id-1 li>div");
		
		
		//FluentWait is used to set polling interval for driver to check in the below scenario WebDriver will look for an element every 5 seconds for 20 seconds.
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		fluentWait.until(WebDriver -> driver.findElement(listUsers));
			
		//iterate over the list of auto suggest values click the values we want. driver.findElements() function return list of elements 
		for(WebElement e : driver.findElements(listUsers)) {
			if(e.getText().contains("Australia")) {
				e.click();
			}
		}
		
		System.out.println(driver.findElement(autoSuggest).getAttribute("value"));
		
		//We can use both WebDriverWait and FluentWait when you know the control over polling interval you can go FluentWait. 
		//Otherwise WebDriverWait has more options for conditional waits. There is WebDriverWait constructor which also has polling interval.
		//By default WebDriver poll every 0.5 seconds.
		
		// Wait for 15 seconds with polling interval of 3 seconds for each condition
		wait = new WebDriverWait(driver, Duration.ofSeconds(15),Duration.ofSeconds(3));
		
		driver.get("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		driver.findElement(getUser).click();
		
		
		By profileImg = By.cssSelector("div#loading > img");
		
		//Waiting for the user profile to appear
		wait.until(ExpectedConditions.attributeContains(profileImg, "src", "https://randomuser.me/api/"));
		
		System.out.println(driver.findElement(By.cssSelector("div#loading")).getText());
		
		driver.quit();
		
	}

}
