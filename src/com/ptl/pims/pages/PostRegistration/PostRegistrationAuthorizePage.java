package com.ptl.pims.pages.PostRegistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;

public class PostRegistrationAuthorizePage extends SelectInmatePage {
	
	
	public PostRegistrationAuthorizePage(WebDriver dr){
		driver = dr;
	}
	
	public AuthorizePostRegUserPage clickFirstInmate() {
		
		firstInmateLink.click();
		
		AuthorizePostRegUserPage authorizePostRegUserPage = PageFactory
				.initElements(driver, AuthorizePostRegUserPage.class);
		return authorizePostRegUserPage;
	}


}
