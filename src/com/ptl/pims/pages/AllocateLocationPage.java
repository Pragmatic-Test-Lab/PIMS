package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.pims.util.Constants;

public class AllocateLocationPage {

	WebDriver driver;	

	// Allocate Location Page
	@FindBy(xpath = Constants.AllocateLocation_RegistrationNo)
	public WebElement RegistrationNum;
	@FindBy(xpath = Constants.AllocateLocation_InmateName)
	public WebElement InmateName;
	@FindBy(xpath = Constants.AllocateLocation_LocationDropdown)
	public WebElement LocationDropdown;
	@FindBy(xpath = Constants.AllocateLocation_SaveLocation)
	public WebElement SaveLocation;

	public AllocateLocationPage(WebDriver dr) {
		driver = dr;
	}
	
	public boolean validateAllocateLocationPageData(String RegNo, String Name,
			String Location) {

		if (!RegNo.equals(RegistrationNum.getText()) || !Name.equals(InmateName.getText()))
			return false;
		
		if (!(LocationDropdown.getText().equals("Select...") && Location == null)) {
			if (!Location.equals(LocationDropdown.getText()))
			return false;
		}	
		
		return true;
	}

	public void changeLocation(String newLocation) {
		LocationDropdown.sendKeys(newLocation);
		SaveLocation.click();
	}
}
