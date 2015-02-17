package com.ptl.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.util.Constants;

public class AllocateLocation {

	WebDriver driver;
	
	//AllocateLocation Inmate Select Page
	@FindBy(xpath = Constants.AllocateLocation_Header)
	public WebElement HeaderField;	
		//SearchFields
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
	@FindBy(xpath = Constants.AllocateLocation_TableFirstLink)
	public WebElement firstInmateLink;
	
	//Allocate Location Page
	@FindBy(xpath = Constants.AllocateLocation_LocationDropdown)
	public WebElement LocationDropdown;
	@FindBy(xpath = Constants.AllocateLocation_SaveLocation)
	public WebElement SaveLocation;

	public AllocateLocation(WebDriver dr) {
		driver = dr;
	}
	
	public String getHeader(){		
		return HeaderField.getText();
	}
	
	public String getExpectedHeader(){
		return Constants.AllocateLocation_ExpectedHeader;
	}

	//Search for inmate
	public void doSearch(String RegNo, String Biometric, String Name, 
			String OtherName1, String Location){	
		
		RegNoSearchField.sendKeys(RegNo);
		BiometricSearchField.sendKeys(Biometric);
		NameSearchField.sendKeys(Name);
		OtherName1SearchField.sendKeys(OtherName1);
		LocationSearchField.sendKeys(Location);
		
		LocationSearchField.sendKeys(Keys.ENTER);
	}
	
	//clicks the first inmate in Table
	public void clickFirstInmate(){		
		firstInmateLink.click();
	}
	
	
	
	public void changeLocation(String newLocation){		
		LocationDropdown.sendKeys(newLocation);
		SaveLocation.click();
	}
	
	
	
	
	
}











