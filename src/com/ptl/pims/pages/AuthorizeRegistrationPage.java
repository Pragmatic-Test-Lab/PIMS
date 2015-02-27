package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class AuthorizeRegistrationPage {

	//Authorize Registration Page
	@FindBy(xpath = Constants.AuthorizeRegistration_AuthorizeButton)
	public WebElement authorizeButton;
	
	WebDriver driver;	

	public AuthorizeRegistrationPage(WebDriver dr) {
		driver = dr;
	}
	
	public AuthorizeRegistrationInmateSelectPage authorizeInmate(){
		authorizeButton.click();
		
		AuthorizeRegistrationInmateSelectPage allocateLocationInmateSelect = PageFactory
				.initElements(driver, AuthorizeRegistrationInmateSelectPage.class);
		return allocateLocationInmateSelect;
	}
	
	
}






