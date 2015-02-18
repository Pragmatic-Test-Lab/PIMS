package com.ptl.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.util.Constants;

public class AllocateLocationInmateSelectPage {

	WebDriver driver;

	// AllocateLocation Inmate Select Page
	@FindBy(xpath = Constants.AllocateLocation_Header)
	public WebElement HeaderField;
	// SearchFields
	@FindBy(xpath = Constants.AllocateLocation_RegNoSearchField)
	public WebElement RegNoSearchField;
	@FindBy(xpath = Constants.AllocateLocation_BiometricSearchField)
	public WebElement BiometricSearchField;
	@FindBy(xpath = Constants.AllocateLocation_NameSearchField)
	public WebElement NameSearchField;
	@FindBy(xpath = Constants.AllocateLocation_OtherName1SearchField)
	public WebElement OtherName1SearchField;
	@FindBy(xpath = Constants.AllocateLocation_LocationSearchField)
	public WebElement LocationSearchField;

	@FindBy(xpath = Constants.AllocateLocation_TableFirstInmate_RegNo)
	public WebElement firstInmateRegNo;
	@FindBy(xpath = Constants.AllocateLocation_TableFirstInmate_Name)
	public WebElement firstInmateName;
	@FindBy(xpath = Constants.AllocateLocation_TableFirstInmate_Location)
	public WebElement firstInmateLocation;
	@FindBy(xpath = Constants.AllocateLocation_TableFirstLink)
	public WebElement firstInmateLink;


	public AllocateLocationInmateSelectPage(WebDriver dr) {
		driver = dr;
	}

	public String getHeader() {
		return HeaderField.getText();
	}

	public String getExpectedHeader() {
		return Constants.AllocateLocation_ExpectedHeader;
	}

	// Search for inmate
	public void doSearch(String RegNo, String Biometric, String Name,
			String OtherName1, String Location) {

		RegNoSearchField.sendKeys(RegNo);
		BiometricSearchField.sendKeys(Biometric);
		NameSearchField.sendKeys(Name);
		OtherName1SearchField.sendKeys(OtherName1);
		LocationSearchField.sendKeys(Location);

		LocationSearchField.sendKeys(Keys.ENTER);
	}

	// gets First Inmates Registration No
	public String getFInmateRegNo() {
		return firstInmateRegNo.getText();
	}

	// gets First Inmates Name
	public String getFInmateName() {
		return firstInmateName.getText();
	}

	// gets First Inmates Location
	public String getFInmateLocation() {
		return firstInmateLocation.getText();
	}

	// clicks the first inmate in Table
	public void clickFirstInmate() {
		firstInmateLink.click();
	}


}
