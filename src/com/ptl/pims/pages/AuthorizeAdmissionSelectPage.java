package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class AuthorizeAdmissionSelectPage extends SelectInmatePage{

	
	//first Inmate Select Button


	public AuthorizeAdmissionSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public AuthorizeAdmissionPage clickFirstInmate() {
		
		firstInmateLink.click();
		
		AuthorizeAdmissionPage authorizeAdmissionPage = PageFactory.initElements(driver, AuthorizeAdmissionPage.class);
		return authorizeAdmissionPage;
	}

	
}
