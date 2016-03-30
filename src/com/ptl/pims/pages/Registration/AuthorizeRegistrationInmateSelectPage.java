package com.ptl.pims.pages.Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;

public class AuthorizeRegistrationInmateSelectPage extends SelectInmatePage {

	public AuthorizeRegistrationInmateSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public AuthorizeRegistrationPage clickFirstInmate() {
		
		clickFirstRecord();
		AuthorizeRegistrationPage allocateLocation = PageFactory.initElements(driver, AuthorizeRegistrationPage.class);
		return allocateLocation;
	}


	
}
