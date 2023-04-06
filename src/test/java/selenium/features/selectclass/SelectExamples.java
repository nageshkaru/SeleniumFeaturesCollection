package selenium.features.selectclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectExamples {

	public static void main(String[] args) {
		
		System.out.println("Launching Browser");
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize(); // maximize the browser
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 seconds to find element applicable for findelement function each time driver calls it
        
        driver.get("https://letcode.in/dropdowns");

		By dropDown = By.cssSelector("#fruits");
		
		Select select = new Select(driver.findElement(dropDown));
		
		String selectedOption = select.getFirstSelectedOption().getText();
		
		System.out.println("Selected option in the dropdown "+selectedOption);
		
		select.selectByVisibleText("Apple");
		
		// To find the already selected option
		selectedOption = select.getFirstSelectedOption().getText();
		
		System.out.println("Selected option in the dropdown "+selectedOption);
		
		// Select using the attribute value
		select.selectByValue("3");
		
		selectedOption = select.getFirstSelectedOption().getText();
		
		System.out.println("Selected option in the dropdown "+selectedOption);
		
		By multiDropDown = By.cssSelector("#superheros");
		
		select = new Select(driver.findElement(multiDropDown));
		
		//This is multi dropdown
		select.selectByVisibleText("Ant-Man");
		select.selectByVisibleText("Batman");
		select.selectByVisibleText("Daredevil");
		select.selectByVisibleText("Thor");
		select.selectByVisibleText("Wolverine");
		
		//To get the all selected elements of the multidropdown
		List<WebElement> allDropdownSelectedOptions = select.getAllSelectedOptions();
		
		List<String> selectedOptions = new ArrayList<>();
		
		//get the text of the all selected elements in the dropdown and store in it the list
		for(WebElement e: allDropdownSelectedOptions) {
			selectedOptions.add(e.getText());
		}
		
		System.out.println("All selected options in the dropdown: "+selectedOptions);
		
		// deselect few values in the multidropdown 
		select.deselectByVisibleText("Ant-Man");
		select.deselectByVisibleText("Daredevil");
		
		allDropdownSelectedOptions = select.getAllSelectedOptions();
		
		selectedOptions = new ArrayList<>();
		
		for(WebElement e: allDropdownSelectedOptions) {
			selectedOptions.add(e.getText());
		}
		
		System.out.println("All selected options after removed Ant-Man and Daredevil: "+selectedOptions);
		
		
		driver.quit();
	}

}
