package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class AllocateLocationPage {

	WebDriver driver;	

	// Allocate Location Page
	@FindBy(xpath = Constants.AllocateLocation_RegistrationNo)
	public WebElement RegistrationNum;
	@FindBy(xpath = Constants.AllocateLocation_InmateName)
	public WebElement InmateName;
	@FindBy(xpath = Constants.AllocateLocation_CurrentLocation)
	public WebElement CurrentLocation;
	@FindBy(xpath = Constants.AllocateLocation_LocationDropdown)
	public WebElement LocationDropdown;
	@FindBy(xpath = Constants.AllocateLocation_SaveButton)
	public WebElement SaveButton;

	public AllocateLocationPage(WebDriver dr) {
		driver = dr;
	}
	
	public boolean validateInmateData(String RegNo, String Name) {

		if (!RegNo.equals(RegistrationNum.getText()) || !Name.equals(InmateName.getText()))
			return false;

		return true;
	}
	
	public String getCurrentLocation(){
		return CurrentLocation.getText();
		
	}

	public AllocateLocationInmateSelectPage changeLocation(String newLocation) {
		LocationDropdown.sendKeys(newLocation);
		SaveButton.click();
		
		AllocateLocationInmateSelectPage allocateLocationSelectPage = PageFactory
				.initElements(driver, AllocateLocationInmateSelectPage.class);
		return allocateLocationSelectPage;
	}
}
