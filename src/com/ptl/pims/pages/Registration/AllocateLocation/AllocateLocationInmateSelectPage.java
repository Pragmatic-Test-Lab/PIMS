package com.ptl.pims.pages.Registration.AllocateLocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;

public class AllocateLocationInmateSelectPage extends SelectInmatePage{


	public AllocateLocationInmateSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public AllocateLocationPage clickFirstInmate() {
		
		clickFirstRecord();
		AllocateLocationPage allocateLocation = PageFactory
				.initElements(driver, AllocateLocationPage.class);
		return allocateLocation;
	}



}
