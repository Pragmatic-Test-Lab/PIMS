package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class InmateRegistrationSelectPage extends SelectInmatePage {
	
	@FindBy(xpath = Constants.InmateRegistration_AddedSuccessfullyMessage)
	public WebElement InmateSuccessMessage;
	
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
	
public  String getInmateSuccessMessage() {
		
		return InmateSuccessMessage.getText();
	}

}
