package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class PostRegistrationAuthorizePage {
	WebDriver driver ;
	
	@FindBy(xpath=Constants.PostRegAuthorize_PageTitle)
	WebElement pageTitle;
	@FindBy(xpath=Constants.PostRegAuthorize_SuccessMessage)
	WebElement successMessage;
	@FindBy(xpath=Constants.PostRegAuthorize_FirstAuthorizationIcon)
	WebElement firstAuthorizationIcon;	
	
	
	public PostRegistrationAuthorizePage(WebDriver dr){
		driver = dr;
	}
	
	
	public String getActualPageTitle(){
		String ActualPageTitle = pageTitle.getText();
		return ActualPageTitle;
	}
	
	
	public String getExpectedPageTitle(){
		String ExpectedPageTitle = Constants.PostRegAuthorize_PageTitleText;
		return ExpectedPageTitle;
	}
	
	
	public AuthorizePostRegUserPage gotoAuthorizePostRegUserPage(){
		firstAuthorizationIcon.click();
		AuthorizePostRegUserPage authorizePostRegUserPage = PageFactory.initElements(driver, AuthorizePostRegUserPage.class);
		return authorizePostRegUserPage;
		
	}
	
	public String getActualSuccessMessage(){
		String ActualSuccessMessage = successMessage.getText();
		return ActualSuccessMessage;
		
	}
	
	
	public String getExpectedSuccessMessage(){
		String ExpectedSuccessMessage = Constants.PostRegAuthorize_SuccessMessageText;
		return ExpectedSuccessMessage;
	}



}
