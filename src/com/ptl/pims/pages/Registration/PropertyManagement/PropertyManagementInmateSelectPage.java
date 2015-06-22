package com.ptl.pims.pages.Registration.PropertyManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;
import com.ptl.pims.util.Constants;

public class PropertyManagementInmateSelectPage extends SelectInmatePage {

	@FindBy(xpath = Constants.PropertyManagement_AddedSuccessfullyMessage)
	public WebElement SuccessMessage;
	
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
	
	public String getSuccessMessage() {		
		return SuccessMessage.getText();
	}

	
}
