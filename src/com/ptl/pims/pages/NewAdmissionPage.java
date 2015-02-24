package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.ptl.pims.util.Constants;

import com.ptl.pims.util.*;


public class NewAdmissionPage {
	
	WebDriver driver;
	
	@FindBy(xpath = Constants.CreateAdmissionButton)
	WebElement CreateAdmissionButton;
	@FindBy(xpath = Constants.NewAdmissionHeder)
	WebElement CreateAdmissionHeader;
	@FindBy(xpath = Constants.TopMenu_AdmissionTopLink)
	WebElement AdmissionMenu;
	@FindBy(xpath = Constants.TopMenu_NewAdmissionSubLink)
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
	@FindBy(xpath = Constants.CreateAdmission_ImageFrontBrowse)
	WebElement ImageFrontBrowse;
	@FindBy(xpath = Constants.CreateAdmission_ImageFrontRemove)
	WebElement ImageFrontRemove;
	@FindBy(xpath = Constants.CreateAdmission_ImageLHSBrowse)
	WebElement ImageLHSBrowse;
	@FindBy(xpath = Constants.CreateAdmission_ImageLHSRemove)
	WebElement ImageLHSRemove;
	
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetailTab)
	WebElement InmateCaseDetailsTab;
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_AddNew)
	WebElement InmateAddNewCase;
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_Court)
	WebElement InmateCaseDetailsCourt;
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_CaseNumber)
	WebElement InmateCaseDetailsCaseNumber;
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_DateConviction)
	WebElement InmateCaseDetailsDateConviction;
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_Action)
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
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_ManageDrugs_AddNew)
	WebElement InmateHealthConditionDrugsAddNew;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_ManageDrugs_Drug)
	WebElement InmateHealthConditionManageDrugs_Drugs;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_ManagePhysical_AddNew)
	WebElement InmateHealthConditionPhysicalAddNew;
	@FindBy(xpath = Constants.CreateAdmission_HealthCondition_ManagePhysical_Observation)
	WebElement InmateHealthConditionPhysicalObservation;
	
		
	@FindBy(xpath = Constants.CreateAdmission_InmateComplainTab)
	WebElement InmateComplainTab;
	@FindBy(xpath = Constants.CreateAdmission_InmateComplainNew)
	WebElement InmateComplainAddNew;
	@FindBy(xpath = Constants.CreateAdmission_InmateComplainDate)
	WebElement InmateComplainDate;
	@FindBy(xpath = Constants.CreateAdmission_InmateComplain_TypeOfComplaint)
	WebElement InmateComplainType;
	@FindBy(xpath = Constants.CreateAdmission_InmateComplain_Description)
	WebElement InmateComplainDescription;
	
	
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Tab)
	WebElement InmatePrivatePropertiesTab;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_AddNew)
	WebElement InmatePrivatePropertiesAddNew;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Date)
	WebElement InmatePrivatePropertiesDate;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Item)
	WebElement InmatePrivatePropertiesItem;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Description)
	WebElement InmatePrivatePropertiesDesciption;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Quantity)
	WebElement InmatePrivatePropertiesQuantity;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Value)
	WebElement InmatePrivatePropertiesValue;
	
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolTab)
	WebElement InmateInfantsPreschoolTab;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolAddNew)
	WebElement InmateInfantsPreschoolAddNew;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolName)
	WebElement InmateInfantsPreschoolName;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolDateOfBirth)
	WebElement InmateInfantsPreschoolDateOfBirth;
	@FindBy(xpath = Constants.Save_Admission)
	WebElement SaveInamteAdmissionButton;
	
	 	
	String ActualPage_Header;
	String ExpectedPage_Header;
	String RHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String Front_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String LHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	
	
	public NewAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	public void doCreateNewAdmition() throws InterruptedException{
		
		CreateAdmissionButton.click();
     	InmateCatagory.sendKeys("Child");
     	CourtWarant.sendKeys("Colombo");
     	AgeAddmission.sendKeys("20");
		AgeCatagory.sendKeys("Youth");
		//DateAddmission.sendKeys("2015-01-28 13:30");
		MealType.sendKeys("Diet");
		BioMetric.sendKeys("Biometric Content");
		NameWarrent.sendKeys("Name As Warrent");
		OccurenceClassificatio.sendKeys("FO");
		Gender.sendKeys("male");
		//CurrentPositionInstitute.sendKeys("welikada");
		Thread.sleep(3000);
		ImageRHSBrowse.sendKeys(RHS_Image_Path);
		Thread.sleep(3000);
		ImageFrontBrowse.sendKeys(Front_Image_Path);
		Thread.sleep(3000);
		ImageLHSBrowse.sendKeys(LHS_Image_Path);
		
		//Add court details
		InmateAddNewCase.click();
		InmateCaseDetailsCourt.sendKeys("Colombo");
		InmateCaseDetailsCaseNumber.sendKeys("CASE001");
		InmateCaseDetailsDateConviction.sendKeys("2015-02-24");
		
		//Add Health Condition
		InmateHealthConditionTab.click();
		InmateHealthConditionAddNew.click();
		InmateHealthConditionMedicalAttention.click();
		InmateHealthConditionPregnant.click();
		InmateHealthConditionRemarks.sendKeys("Health Conditions Remarks");
		InmateHealthConditionForPreSchool.click();
		InmateHealthConditionOfPreSchool.sendKeys("Health of school");
		InmateHealthConditionDrugsAddNew.click();
		InmateHealthConditionManageDrugs_Drugs.sendKeys("Other");
		InmateHealthConditionPhysicalAddNew.clear();
		InmateHealthConditionPhysicalObservation.sendKeys("Cough");
		
		//Inmate Complaint
		InmateComplainTab.click();
		InmateComplainAddNew.click();
		InmateComplainDate.sendKeys("2015-02-10");
		InmateComplainType.sendKeys("Health");
		InmateComplainDescription.sendKeys("Descriptios");
		
		//Inmate Private Properties
		InmatePrivatePropertiesTab.click();
		InmatePrivatePropertiesAddNew.click();
		InmatePrivatePropertiesDate.sendKeys("2015-02-18");
		InmatePrivatePropertiesItem.sendKeys("Other");
		InmatePrivatePropertiesDesciption.sendKeys("Descriptions");
		InmatePrivatePropertiesQuantity.sendKeys("1");
		InmatePrivatePropertiesValue.sendKeys("200.89");
		
		//InfantsPreschoolTab.
		InmateInfantsPreschoolTab.click();
		InmateInfantsPreschoolAddNew.click();
		InmateInfantsPreschoolName.sendKeys("Name hi");
		InmateInfantsPreschoolDateOfBirth.sendKeys("2015-02-25");
		
		SaveInamteAdmissionButton.click();
		
		//TODO : Add verification for confirmation message
		
		
	}
	
	public String getActualPageTitle(){
	    ActualPage_Header = CreateAdmissionHeader.getText();
		return ActualPage_Header;
	}
	
	public String getExpectedPageHeader(){
		ExpectedPage_Header = Constants.NewAdmission_ExpectedPageHeader;
		return ExpectedPage_Header;
		
	}

}
