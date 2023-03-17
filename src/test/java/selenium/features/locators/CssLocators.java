package selenium.features.locators;

import org.openqa.selenium.By;

public class CssLocators {

	/*
	 * CSS Locators are another way also easy way of finding the elements
	 * 
	 * */
	
	
	/*
	<div class="card-content">
	   <div class="field">
	      <label for="name" class="label">Enter your full Name</label>
	      <div class="control">
	      <input id="fullName" name='fullname' type="text" placeholder="Enter first and last name" class="input is-focused">
	      </div>
	   </div>
	</div>
	*/
	
	By idCssLocator = By.cssSelector("#fullName"); // id's prefix with '#' like this
	By classCssLocator = By.cssSelector(".input.is-focused"); // classes prefix with '.' like this if there is space in between class replace with '.' 
	By attributeCssLocator = By.cssSelector("input[type='text']");
	By attribute2CssLocator = By.cssSelector("input[class='input is-focused']");
	By attribute3CssLocator = By.cssSelector("input[placeholder='Enter first and last name']");
	
	By contains = By.cssSelector("input[placeholder*='first and last']"); // prefix * for contains check
	By startsWith = By.cssSelector("input[placeholder^='Enter first']"); // prefix ^ for starts with check
	By endsWith = By.cssSelector("input[placeholder$='last name']"); // prefix $ for ends with check
	
	By parentToChild = By.cssSelector("div.card-content > div");  // or div[class='card-content'] > input
	By parentToChildOrGrantChild = By.cssSelector("div.card-content input");  // or div[class='card-content'] input or div[class='card-content'] > input

}
