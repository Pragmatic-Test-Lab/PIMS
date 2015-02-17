package com.ptl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.util.Constants;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = Constants.Home_PageHeader)
	WebElement pageHeader;
	String ExpectedPageHeader = Constants.Home_PageHeaderText;
	String ActualPageHeader;
	
	@FindBy(xpath = Constants.Home_AllocateLocationLink)
	WebElement AllocateLocationLink;

	public HomePage(WebDriver dr) {
		driver = dr;

	}

	public String getActualPageHeader() {
		return ActualPageHeader = pageHeader.getText();
	}

	public String getExpectedPageHeader() {
		return ExpectedPageHeader;
	}

	public AllocateLocation goToAllocateLocation() {

		AllocateLocationLink.click();		
		AllocateLocation allocateLocation = PageFactory.initElements(driver,
				AllocateLocation.class);
		return allocateLocation;
	}
}
