package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditAdmissionSelectPage extends SelectInmatePage{
	
	public EditAdmissionSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public EditAdmissionPage clickFirstInmate() {
		
		firstInmateLink.click();
		
		EditAdmissionPage editAdmissionPage = PageFactory.initElements(driver, EditAdmissionPage.class);
		return editAdmissionPage;
	}

}
