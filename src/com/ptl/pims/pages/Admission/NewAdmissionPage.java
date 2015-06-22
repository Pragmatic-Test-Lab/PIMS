package com.ptl.pims.pages.Admission;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.SelectInmatePage;
import com.ptl.pims.util.Constants;

public class NewAdmissionPage extends SelectInmatePage {

	
	@FindBy(xpath = Constants.CreateAdmissionButton)
	WebElement CreateAdmissionButton;
	
	public NewAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	public CreateAdmissionPage getCreateAdmissionPage(){
		CreateAdmissionButton.click();
		CreateAdmissionPage createNewAdmissionPage = PageFactory.initElements(driver, CreateAdmissionPage.class);
		return createNewAdmissionPage;	
	}


	

}
