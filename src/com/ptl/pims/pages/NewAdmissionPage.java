package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.pims.util.Constants;

public class NewAdmissionPage {
	
	WebDriver driver;
	
	@FindBy(xpath = Constants.AdmissionTopLink)
	WebElement AdmissionMenu;
	@FindBy(xpath = Constants.NewAdmissionSubLink)
	WebElement NewAdmissionSubMenu;
	@FindBy(xpath = Constants.CreateAdmission_InmateCategory)
	WebElement InmateCatagory;
	@FindBy(xpath = Constants.CreateAdmission_CourtWarant)
	WebElement CourtWarant;
	@FindBy(xpath = Constants.CreateAdmission_AgeAdmission)
	WebElement AgeAddmission;
	@FindBy(xpath = Constants.CreateAdmission_AgeCategory)
	WebElement AgeCatagory;
	@FindBy(xpath = Constants.CreateAdmission_RegistrationNumber)
	WebElement RegNumber;
	@FindBy(xpath = Constants.CreateAdmission_DateAdmission)
	WebElement DateAddmission;
	@FindBy(xpath = Constants.CreateAdmission_MealType)
	WebElement MealType;
	@FindBy(xpath = Constants.CreateAdmission_Biometric)
	WebElement BioMetric;
	@FindBy(xpath = Constants.CreateAdmission_NameWarrant)
	WebElement NameWarrent;
	@FindBy(xpath = Constants.CreateAdmission_OccurenceClassification)
	WebElement OccurenceClassificatio;
	@FindBy(xpath = Constants.CreateAdmission_Gender)
	WebElement Gender;
	@FindBy(xpath = Constants.CreateAdmission_CurrentPrisonInstitute)
	WebElement CurrentPositionInstitute;
	@FindBy(xpath = Constants.CreateAdmission_ImageRHSBrowse)
	WebElement ImageRHSBrowse;
	@FindBy(xpath = Constants.CreateAdmission_ImageRHSRemove)
	WebElement ImageRHSRemove;
	@FindBy(xpath = Constants.CreateAdmission_ImageFrontRemove)
	WebElement ImageFrontBrowse;
	@FindBy(xpath = Constants.CreateAdmission_ImageFrontRemove)
	WebElement ImageFrontRemove;
	@FindBy(xpath = Constants.CreateAdmission_ImageLHSBrowse)
	WebElement ImageLHSBrowse;
	@FindBy(xpath = Constants.CreateAdmission_ImageLHSRemove)
	WebElement ImageLHSRemove;
	
	@FindBy(xpath = Constants.CreateAdmission_InmateCaseDetailTab)
	WebElement InmateCaseDetailsTab;
	@FindBy(xpath = Constants.CreateAdmission_InmateCaseDetail_AddNew)
	WebElement InmateAddNewCase;
	@FindBy(xpath = Constants.CreateAdmission_InmateCaseDetail_Court)
	WebElement InmateCaseDetailsCourt;
	@FindBy(xpath = Constants.CreateAdmission_InmateCaseDetail_CaseNumber)
	WebElement InmateCaseDetailsCaseNumber;
	@FindBy(xpath = Constants.CreateAdmission_InmateCaseDetail_DateConviction)
	WebElement InmateCaseDetailsDateConviction;
	@FindBy(xpath = Constants.CreateAdmission_InmateCaseDetail_Action)
	WebElement InmateCaseDetailsAction;
	
	@FindBy(xpath = Constants.CreateAdmission_HealthConditionTab)
	WebElement InmateHealthConditionTab;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_AddNew)
	WebElement InmateHealthConditionAddNew;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_MedicalAttention)
	WebElement InmateHealthConditionMedicalAttention;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_Pregnant)
	WebElement InmateHealthConditionPregnant;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_Remarks)
	WebElement InmateHealthConditionRemarks;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_ForPreschool)
	WebElement InmateHealthConditionForPreSchool;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_OfPreschool)
	WebElement InmateHealthConditionOfPreSchool;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_Action)
	WebElement InmateHealthConditionAction;
	
	@FindBy(xpath = Constants.CreateAdmission_InmateComplainTab)
	WebElement InmateComplainTab;
	@FindBy(xpath = Constants.CreateAdmission_PrivatePropertiesTab)
	WebElement InmatePrivatePropertiesTab;
	
	
	public NewAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	public void doCreateNewAdmition(){
		
		
		AdmissionMenu.click();
		NewAdmissionSubMenu.click();
	/*	InmateCatagory.sendKeys("lady");
		CourtWarant.sendKeys("colombo");
		AgeAddmission.sendKeys("40");
		AgeCatagory.sendKeys("adult");
		DateAddmission.sendKeys("2015-01-28 13:30");
		MealType.sendKeys("Diet");
		BioMetric.sendKeys("Biometric");
		NameWarrent.sendKeys("Name As Warrent");
		OccurenceClassificatio.sendKeys("FO");
		Gender.sendKeys("male");
		CurrentPositionInstitute.sendKeys("welikada");*/
		
		
		
		
		
	}

}
