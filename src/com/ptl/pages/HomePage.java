package com.ptl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.util.Constants;


public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath=Constants.Home_PageHeader)
	WebElement pageHeader;
	@FindBy(xpath=Constants.RegistrationMainLink)
	WebElement registrationMainLink;
	@FindBy(xpath=Constants.RegistrationSubLink)
	WebElement registrationSubLink;
	
	String ExpectedPageHeader = Constants.Home_PageHeaderText;
	
	String ActualPageHeader;
		
	public HomePage(WebDriver dr){
		driver = dr;
		
	}
	
	public String getActualPageHeader(){
		return ActualPageHeader = pageHeader.getText();
	}
	
	public String getExpectedPageHeader(){
		return ExpectedPageHeader;
	}
	
	public InmateRegistration goToInmateRegistration(){
	    registrationMainLink.click();
	    registrationSubLink.click();
		InmateRegistration inmateRegistration = PageFactory.initElements(driver, InmateRegistration.class);
	    return inmateRegistration;
	}
}
