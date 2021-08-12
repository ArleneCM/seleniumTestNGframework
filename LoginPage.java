package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	@CacheLookup
	@FindBy(name="uid")
	private WebElement userId;
	
	@CacheLookup
	@FindBy(name="password")
	private WebElement userPassword;
	
	@CacheLookup
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	// constructor to initialize the above elements.
	public LoginPage(WebDriver driver) {
		
		// call an explicit constructor will take an argument
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToApplication(String username, String password) {
		
		elementControl.setText(userId, username);
		
		elementControl.setText(userPassword, password);
		
		elementControl.clickElement(loginButton);
	}
	
}

	