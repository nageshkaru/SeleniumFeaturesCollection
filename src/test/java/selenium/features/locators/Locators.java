package selenium.features.locators;

import org.openqa.selenium.By;

public class Locators {

	public static void main(String[] args) {
		
		
		//   <input id="join" name="feedback" value="I am good" type="text" placeholder="Enter " class="input">
		
		
		By idLocator = By.id("join"); // above input tag contains id value as "join"
		By classLocator = By.className("input"); // above class tag contains id value as "input"
		By tagLocator = By.tagName("input"); // above element has input tag
		By nameLocator = By.name("feedback"); //above input tag contains name value as "feedback"
		By linkTextLocator = By.linkText(""); // elements which have <a> anchor tag 
		By partialLinkTextLocator = By.partialLinkText(""); // elements which have <a> anchor tag
		
		//These all returns the By value which we can store and use it to find elements in the webpage.
	
		//If you can't find elements by using above functions then we can go far Xpath mechanism to find elements in web page.
		
	}

}
