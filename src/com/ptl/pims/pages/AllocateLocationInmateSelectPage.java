package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

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
