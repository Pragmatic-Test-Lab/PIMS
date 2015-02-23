package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.pims.util.Constants;

public class PostRegistrationMainPage {
	WebDriver driver ;
	
	@FindBy(xpath=Constants.PostRegistration_PageTitle)
	WebElement pageTitle;
	
	
	public PostRegistrationMainPage(WebDriver dr){
		driver = dr;
	}
	
	
	public String getActualPageTitle(){
		String ActualPageTitle = pageTitle.getText();
		return ActualPageTitle;
	}
	
	
	public String getExpectedPageTitle(){
		String ExpectedPageTitle = Constants.PostRegistration_PageTitleText;
		return ExpectedPageTitle;
	}

}
