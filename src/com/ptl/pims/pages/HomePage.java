package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.pims.util.Constants;

public class HomePage extends CommonMethods {

	WebDriver driver;
	@FindBy(xpath = Constants.Home_PageHeader)
	WebElement pageHeader;


	public HomePage(WebDriver dr) {
		driver = dr;

	}

	public String getActualPageHeader() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		return pageHeader.getText();
	}





}
