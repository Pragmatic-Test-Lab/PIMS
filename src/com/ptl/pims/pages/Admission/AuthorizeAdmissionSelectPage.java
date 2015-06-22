package com.ptl.pims.pages.Admission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;

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
