package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class AllocateLocationInmateSelectPage extends SelectInmatePage{


	public AllocateLocationInmateSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public AllocateLocationPage clickFirstInmate() {
		
		firstInmateLink.click();
		
		AllocateLocationPage allocateLocation = PageFactory
				.initElements(driver, AllocateLocationPage.class);
		return allocateLocation;
	}


}
