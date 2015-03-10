package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ptl.pims.util.Constants;

public class AuthorizeAdmissionPage {

    WebDriver driver;
  
    @FindBy(xpath = Constants.Authorize_Admission)
	WebElement AuthorizeInamteAdmissionButton;
    
	public AuthorizeAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	
	//PIMS-1194
	public AuthorizeAdmissionSelectPage doAuthorizeAdmission(){

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		AuthorizeInamteAdmissionButton.click();
		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = PageFactory.initElements(driver, AuthorizeAdmissionSelectPage.class);
		return authorizeAdmissionSelectPage;
	}
	
}
