package com.ptl.pims.pages.Admission;

import com.ptl.pims.pages.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.CalendarPopup;
import com.ptl.pims.util.Constants;

public class AuthorizeAdmissionPage extends CommonMethods{

    WebDriver driver;
    
	@FindBy(xpath = Constants.CreateAdmission_NameWarrant)
	WebElement NameWarrent;
	@FindBy(xpath = Constants.CreateAdmission_Biometric)
	WebElement BioMetric;
	@FindBy(xpath = Constants.CreateAdmission_AgeAdmission)
	WebElement AgeAddmission;
	
    @FindBy(xpath = Constants.Admission_DOAdmission)
    WebElement DOAdmission;
  
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
	
	public void changeAdmissionDate(String date){
		
		CalendarPopup CLNDR = new CalendarPopup(driver);
		
		CLNDR.selectDateOfAdmission(DOAdmission, date);
	}


	public void checkSavedData(String inmateCatagory, String court, String age, String meal,
							   String nameAsWarrent, String classification, String gender){

		matchSelectedDropdownWithText(driver, Constants.CreateAdmission_InmateCategory, inmateCatagory, true);
		matchSelectedDropdownWithText(driver, Constants.CreateAdmission_CourtWarant, court, true);
		matchSelectedDropdownWithText(driver, Constants.CreateAdmission_MealType, meal, false);
		matchSelectedDropdownWithText(driver, Constants.CreateAdmission_OccurenceClassification, classification, false);
		matchSelectedDropdownWithText(driver, Constants.CreateAdmission_Gender, gender, false);
		matchValueWithText(driver, Constants.CreateAdmission_AgeAdmission, age, false);
		matchValueWithText(driver, Constants.CreateAdmission_NameWarrant, nameAsWarrent, true);
	}
	
}
