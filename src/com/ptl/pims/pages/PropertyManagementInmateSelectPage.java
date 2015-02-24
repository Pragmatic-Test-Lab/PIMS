package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PropertyManagementInmateSelectPage extends SelectInmatePage {

	
	public PropertyManagementInmateSelectPage(WebDriver dr) {
		driver = dr;
	}

	// clicks the first inmate in Table
	public PropertyManagementPage clickFirstInmate() {
		
		firstInmateLink.click();
		
		PropertyManagementPage propertyManagement = PageFactory
				.initElements(driver, PropertyManagementPage.class);
		return propertyManagement;
	}

	
}
