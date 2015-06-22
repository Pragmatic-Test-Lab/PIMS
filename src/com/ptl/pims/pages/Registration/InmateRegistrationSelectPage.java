package com.ptl.pims.pages.Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;

public class InmateRegistrationSelectPage extends SelectInmatePage {


	public InmateRegistrationSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public InmateRegistration clickFirstInmate() {

		firstInmateLink.click();

		InmateRegistration inmateRegistration = PageFactory.initElements(driver, InmateRegistration.class);
		return inmateRegistration;
	}


}
