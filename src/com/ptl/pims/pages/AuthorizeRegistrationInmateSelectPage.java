package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class AuthorizeRegistrationInmateSelectPage extends SelectInmatePage {

	public AuthorizeRegistrationInmateSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public AuthorizeRegistrationPage clickFirstInmate() {
		
		firstInmateLink.click();
		
		AuthorizeRegistrationPage allocateLocation = PageFactory.initElements(driver, AuthorizeRegistrationPage.class);
		return allocateLocation;
	}


	
}
