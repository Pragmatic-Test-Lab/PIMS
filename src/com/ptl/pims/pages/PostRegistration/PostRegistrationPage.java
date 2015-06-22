package com.ptl.pims.pages.PostRegistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;
import com.ptl.pims.util.Constants;

public class PostRegistrationPage extends SelectInmatePage{
	
	WebDriver driver ;
	
	@FindBy(xpath=Constants.PostRegistration_PageTitle)
	WebElement pageTitle;
	@FindBy(xpath=Constants.PostRegistration_SuccessMessage)
	WebElement successMessage;
	@FindBy(xpath=Constants.PostRegistration_SearchByRegistrationNumber)
	WebElement searchByRegNumber;
	@FindBy(xpath=Constants.PostRegistration_SearchByBiometric)
	WebElement searchByBiometric;
	@FindBy(xpath=Constants.PostRegistration_SearchByWarrantName)
	WebElement searchByWarrantName;
	@FindBy(xpath=Constants.PostRegistration_SearchByOtherName)
	WebElement searchByOtherName;
	@FindBy(xpath=Constants.PostRegistration_FirstUpdateIcon)
	WebElement firstUpdateIcon;
	
	
	public PostRegistrationPage(WebDriver dr){
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
	
	
	public UpdatePostRegistrationPage gotoUpdatePostRegistrationPage(){
		firstUpdateIcon.click();
		UpdatePostRegistrationPage updatePostRegPage = PageFactory.initElements(driver, UpdatePostRegistrationPage.class);
		return updatePostRegPage;
		
	}


}
