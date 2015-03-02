package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class PostRegistrationAuthorizePage extends SelectInmatePage{
	
	
	public PostRegistrationAuthorizePage(WebDriver dr){
		driver = dr;
	}
	
	// clicks the first inmate in Table
	public AuthorizePostRegUserPage clickFirstInmate() {
		
		firstInmateLink.click();
		
		AuthorizePostRegUserPage authorizePostRegUserPage = PageFactory
				.initElements(driver, AuthorizePostRegUserPage.class);
		return authorizePostRegUserPage;
	}


}
