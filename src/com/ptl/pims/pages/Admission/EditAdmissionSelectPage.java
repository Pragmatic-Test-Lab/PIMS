package com.ptl.pims.pages.Admission;

import com.ptl.pims.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;

public class EditAdmissionSelectPage extends SelectInmatePage{
	
	public EditAdmissionSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public EditAdmissionPage clickFirstInmate() {

		clickFirstRecord();
		EditAdmissionPage editAdmissionPage = PageFactory.initElements(driver, EditAdmissionPage.class);
		return editAdmissionPage;
	}

}
