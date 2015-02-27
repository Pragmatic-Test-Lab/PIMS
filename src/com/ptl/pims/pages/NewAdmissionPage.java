package com.ptl.pims.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ptl.pims.util.*;

public class NewAdmissionPage extends SelectInmatePage {

	
	@FindBy(xpath = Constants.CreateAdmissionButton)
	WebElement CreateAdmissionButton;
	
	@FindBy(xpath = Constants.CreateAdmission_Allert)
	WebElement CreateAdmission_Success_Alert;
	
	public NewAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	public CreateNewAdmissionPage getCreateAdmissionPage(){
		CreateAdmissionButton.click();
		CreateNewAdmissionPage createNewAdmissionPage = PageFactory.initElements(driver, CreateNewAdmissionPage.class);
		return createNewAdmissionPage;	
	}
	
	public String getSuccessMessage() {		
		return CreateAdmission_Success_Alert.getText();
	}
	

}
