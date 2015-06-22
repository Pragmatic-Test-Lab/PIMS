package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ptl.pims.util.Constants;


public class HomePage extends CommonMethods{

	WebDriver driver;

	public HomePage(WebDriver dr) {
		driver = dr;

	}

	public boolean IsMainPageImageShown() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		return checkElementIsPresent(driver, By.xpath(Constants.Home_MainImage));
	}





}
