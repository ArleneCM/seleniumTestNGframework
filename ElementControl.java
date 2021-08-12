package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// wrapper methods to control the external utilities
public class ElementControl {
	
	// define driver instance
	WebDriver driver;
	
	// common driver
	public ElementControl(WebDriver driver) {
		this.driver = driver; //  class-level variable
	}

	public void clickElement(WebElement element) {
		element.click();
	}
	
	// eg. to clear a textbox
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void getTextFromAlert() {
		driver.switchTo().alert().getText();
	}
	
	public void selectViaVisibleText(WebElement element, String text) {
		Select selDropdown = new Select(element);
		
		selDropdown.selectByVisibleText(text);
	}
	
	
}
