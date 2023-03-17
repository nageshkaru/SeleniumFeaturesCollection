package selenium.features.locators;

import org.openqa.selenium.By;

public class Xpath {

	public static void main(String[] args) {
		
		
		// Syntax of  Xpath =//tagname[@attribute=’value’]
		/*
		 *  // - double forward slashes represents the current node
		 *  tagname - represents tag name of element i.e input, button, a
		 *  attribute - represents attributes of the element i.e id, class, name, type
		 *  value - represents the values of the attribute 
		 * */
		
		/*
		 * There is absolute and relative xpath 
		 * Absolute means finding xpath directly from the root of the document. like this :/html/body/div[1]/div/div[2]/header/div/div[2]/a
		 * It will fail if any small changes made into the document. 
		 * 
		 * Then the relative xpath comes into the picture. It starts with // which means the element can present anywhere in the webpage.
		 * Below examples are the relative ones.
		 * 
		 * */
		
		
		// lets take above button field
		// <button type="button" name="checkBtn" id="showInput" class="checkValueBtn">Get Checked value</button>
		
		By.xpath("//button[@id='showInput']");
		By.xpath("//button[@type='button']");
		By.xpath("//button[@name='checkBtn']");
		By.xpath("//button[@class='checkValueBtn']");
		
		// text() function used to get elements by text values and using contains method we can filter the attribute values.
		
		By.xpath("//button[text()='Get Checked value']");
		By.xpath("//button[contains(text(),'Checked value'])");
		By.xpath("//button[contains(@class,'checkValue'])");
		
		// starts-with() function similar to contains method we can filter the values.
		
		By.xpath("//button[starts-with(text(),'Get Checked'])");
		
		// we can use AND or OR in between the attributes
		
		By.xpath("//button[@name='checkBtn' and @type = 'button']");
		By.xpath("//button[@name='checkBtn' or @type = 'button']");
		
		
		
		/*
		 * There are several xpath axes methods available. Those are useful to find complex and dynamic elements.
		 * 
		 * */
		
		/*
		<div class="card-content">
		   <div class="field">
		      <label for="name" class="label">Enter your full Name</label>
		      <div class="control"><input id="fullName" type="text" placeholder="Enter first &amp; last name" class="input is-focused"></div>
		   </div>
		   <div class="field">
		      <label for="name" class="label">Append a text and press keyboard tab</label>
		      <div class="control"><input id="join" value="I am good" type="text" placeholder="Enter " class="input"></div>
		   </div>
		   <div class="field">
		      <label for="name" class="label">Clear the text</label>
		      <div class="control"><input id="clearMe" value="Koushik Chatterjee" type="text" placeholder="Enter " class="input"></div>
		   </div>
		   <div class="field">
		      <label for="name" class="label">Confirm edit field is disabled</label>
		      <div class="control"><input id="noEdit" type="text" placeholder="Enter" disabled="" class="input"></div>
		   </div>
		   <div class="field">
		      <label for="name" class="label">Confirm text is readonly</label>
		      <div class="control"><input id="dontwrite" type="text" value="This text is readonly" readonly="" class="input"></div>
		   </div>
		</div>
		*/
		
		
		// 1. Following
		
		By.xpath("//div[@class='card-content']//following::label"); // This xpath select all the elements which has label tag below the mentioned div.
		
		By.xpath("//div[@class='card-content']//following::label[1]"); // This xpath select first label tag below the mentioned div. we can use index for this and index starts from 1.
		
		// 2. Preceding - It is opposite of the following
		
		By.xpath("//div[@class='field']//preceding::label"); // This xpath select all the elements which has label tag above the mentioned div.
		
		By.xpath("//div[@class='field']//preceding::label[1]"); // This xpath select first label tag above the mentioned div. we can use index for this and index starts from 1.
		
		By.xpath("//div[@class='card-content']//following-sibling::div");  // select the following sibling
		By.xpath("//div[@class='card-content']//preceding-sibling::div");  // select the preceding sibling
		
		By.xpath("//div[@class='card-content']//child::div"); //it will select the child 
		By.xpath("//div[@class='card-content']//parent::div"); //It will select the direct parent
		
		
		
		
		
	}
}
