package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InmateRegistrationSelectPage extends SelectInmatePage {
	public InmateRegistrationSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public InmateRegistration clickFirstInmate() {
		
		firstInmateLink.click();
		
		InmateRegistration inmateRegistration = PageFactory
				.initElements(driver, InmateRegistration.class);
		return inmateRegistration;
	}

}
