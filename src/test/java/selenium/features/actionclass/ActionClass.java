package selenium.features.actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException {
		
		
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize(); // maximize the browser
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 seconds to find element applicable for findelement function each time driver calls it
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Actions action = new Actions(driver);
        
        action.scrollToElement(driver.findElement(By.id("courses-iframe"))).build().perform();
        
        action.moveToElement(driver.findElement(By.id("mousehover"))).build().perform(); // mousehover on element
        
        Thread.sleep(1000);
        
        action.moveToElement(driver.findElement(By.cssSelector("a[href*='top']"))).click().build().perform(); // for action click
        
        Thread.sleep(1000);
        
        action.scrollToElement(driver.findElement(By.id("courses-iframe"))).build().perform();
        
       // action.moveToElement(driver.findElement(By.id("courses-iframe"))).contextClick().build().perform(); // for mouse right click
        
        driver.get("https://letcode.in/edit");
        
        action.moveToElement(driver.findElement(By.cssSelector("#join"))).click()
        .keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c")
        .keyUp(Keys.CONTROL).build().perform(); // Ctrl + C
        
        
        
        action.moveToElement(driver.findElement(By.cssSelector("#fullName"))).click()
        .keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // Ctrl + V
        
        // .build().perform() is mandatory for execute actions
        
        driver.get("https://letcode.in/draggable");
        int x = driver.findElement(By.id("sample-box")).getLocation().getX();
        System.out.println(x);
        int y = driver.findElement(By.id("sample-box")).getLocation().getY();
        System.out.println(y);
        
        action.clickAndHold(driver.findElement(By.id("sample-box")))
        .moveByOffset(x+20, y+20).click().build().perform();
        
        driver.get("https://letcode.in/dropable");
          
        action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
        
        driver.quit();
	}

}
