package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ptl.pims.util.Constants;

public class CreateAdmissionPage extends CommonMethods {

	WebDriver driver;
	@FindBy(xpath = Constants.NewAdmissionHeder)
	WebElement CreateAdmissionHeader;
	
	//
	//CreateAdmission Main Fields
	@FindBy(xpath = Constants.CreateAdmission_InmateCategory)
	WebElement InmateCatagory;
	@FindBy(xpath = Constants.CreateAdmission_CourtWarant)
	WebElement CourtWarant;
	@FindBy(xpath = Constants.CreateAdmission_AgeAdmission)
	WebElement AgeAdmission;
	@FindBy(xpath = Constants.CreateAdmission_AgeCategory)
	WebElement AgeCatagoryDropdown;
	String AgeCatagoryOptionFirstPart = Constants.AgeCatagoryOptionFirstPart;
	String AgeCategoryOptionLastPart = Constants.AgeCatagoryOptionLastPart;
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
	@FindBy(xpath = Constants.CreateAdmission_ImageFrontBrowse)
	WebElement ImageFrontBrowse;
	@FindBy(xpath = Constants.CreateAdmission_ImageLHSBrowse)
	WebElement ImageLHSBrowse;

	//
	//CreateAdmission Court Details Fields
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
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_DateSentence)
	WebElement InmateCaseDetailsDateOfSentence;
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_Action)
	WebElement InmateCaseDetailsAction;

	//
	//CreateAdmission Health Conditions Fields
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

	//
	//CreateAdmission Complaint Fields	
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
	
	//
	//CreateAdmission Property Fields
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

	//
	//CreateAdmission Infant Fields
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolTab)
	WebElement InmateInfantsPreschoolTab;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolAddNew)
	WebElement InmateInfantsPreschoolAddNew;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolName)
	WebElement InmateInfantsPreschoolName;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolDateOfBirth)
	WebElement InmateInfantsPreschoolDateOfBirth;
	@FindBy(xpath = Constants.Create_Admission_CreateButton)
	WebElement SaveInamteAdmissionButton;


	//temporary variables for admission date selection
	String dateText_FirstPart = Constants.CalendarPopup_DateText_FirstPart;
	String dateText_LastPart = Constants.CalendarPopup_DateText_LastPart;	
	String hourText_FirstPart = Constants.CalendarPopup_HourText_FirstPart;
	String hourText_LastPart = Constants.CalendarPopup_HourText_LastPart;	
	String minuteText_FirstPart = Constants.CalendarPopup_MinuteText_FirstPart;
	String minuteText_LastPart = Constants.CalendarPopup_MinuteText_LastPart;	
	
	
	public CreateAdmissionPage(WebDriver dr){
		driver = dr;
	}

	public String getActualPageTitle(){
		return CreateAdmissionHeader.getText();
	}
	
	//Create any type of inmate with required fields
	public void doFillAllRequiredFileds(String inmateCatagory, String court, String age, String meal, 
			String biometric,String nameAsWarrent, String classification, String gender){
		
		InmateCatagory.sendKeys(inmateCatagory);
     	CourtWarant.sendKeys(court);
     	AgeAdmission.sendKeys(age);
		MealType.sendKeys(meal);
		BioMetric.sendKeys(biometric);
		NameWarrent.sendKeys(nameAsWarrent);
		OccurenceClassificatio.sendKeys(classification);
		Gender.sendKeys(gender);	

		/*DateAddmission.click();
		backMonth.click();
		driver.findElement(By.xpath(dateText_FirstPart + "3" + dateText_LastPart)).click(); //click on the selected date text
		driver.findElement(By.xpath(hourText_FirstPart + "1:00" + hourText_LastPart)).click(); //click on the selected hour text
		driver.findElement(By.xpath(minuteText_FirstPart + "1:25" + minuteText_LastPart)).click();*/
	}

	public void addInmatePictures(String RHS_Image,String Front_Image, String LHS_Image){

			ImageRHSBrowse.sendKeys(RHS_Image);
			ImageFrontBrowse.sendKeys(Front_Image);
			ImageLHSBrowse.sendKeys(LHS_Image);			

	}

	public void filleCourtDetailsTab(String caseCourt, String caseNo,
			String caseDate, String senDate) {
		InmateAddNewCase.click();
		InmateCaseDetailsCourt.sendKeys(caseCourt);
		InmateCaseDetailsCaseNumber.sendKeys(caseNo);
		InmateCaseDetailsDateConviction.sendKeys(caseDate);
		InmateCaseDetailsDateOfSentence.sendKeys(senDate);
	}

	public void filleHealthConditionTab(boolean isPregnant, String hlthRemarks,	boolean isFroPreSchool, String ofPreSchool, String drug,
			String observation) {

		InmateHealthConditionTab.click();
		InmateHealthConditionMedicalAttention.click();
		if(isPregnant)
			InmateHealthConditionPregnant.click();		
		InmateHealthConditionRemarks.sendKeys(hlthRemarks);		
		if(isFroPreSchool)
			InmateHealthConditionForPreSchool.click();		
		InmateHealthConditionOfPreSchool.sendKeys(ofPreSchool);
		
		InmateHealthConditionDrugsAddNew.click();
		InmateHealthConditionManageDrugs_Drugs.sendKeys(drug);
		
		InmateHealthConditionPhysicalAddNew.click();
		InmateHealthConditionPhysicalObservation.sendKeys(observation);
	}
	
	public void fillInmateComplaint(String complaintDate, String complainType, String complainDescription){
		
		InmateComplainTab.click();
		InmateComplainAddNew.click();
		InmateComplainDate.sendKeys(complaintDate);
		InmateComplainType.sendKeys(complainType);
		InmateComplainDescription.sendKeys(complainDescription);
	}
	
	public void fillPrivatePropertiesTab(String ppDate, String ppItem, String ppDes, String ppQuantity, String ppVlue){
		
		InmatePrivatePropertiesTab.click();
		InmatePrivatePropertiesAddNew.click();
		InmatePrivatePropertiesDate.sendKeys(ppDate);
		InmatePrivatePropertiesItem.sendKeys(ppItem);
		InmatePrivatePropertiesDesciption.sendKeys(ppDes);
		InmatePrivatePropertiesQuantity.sendKeys(ppQuantity);
		InmatePrivatePropertiesValue.sendKeys(ppVlue);
	}
	
	public void fillInfantsPreschoolTab(String infantsPreschoolName, String InfantsPreschoolDob){
		
		InmateInfantsPreschoolTab.click();
		InmateInfantsPreschoolAddNew.click();
		InmateInfantsPreschoolName.sendKeys(infantsPreschoolName);
		InmateInfantsPreschoolDateOfBirth.sendKeys(InfantsPreschoolDob);
	}
	
	public NewAdmissionPage doAdmission() {
		SaveInamteAdmissionButton.click();
		NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver,NewAdmissionPage.class);
		return newAdmissionPage;
	}
	
	//PIMS-898
	public boolean checkMealTypeIsSelectable(){
		if(MealType.getAttribute("disabled") == null)
			return true;
		else 
			return false;
	}
	
	//PIMS-869
	public boolean checkImateCatagoryIsSelectable(){		
		if(InmateCatagory.getAttribute("disabled") == null)
			return true;
		else
			return false;	    
	}
	
	//PIMS-408
	public boolean checkIsInmateRegistrationNumberIsAutoGenarated(){
		InmateCatagory.sendKeys("Convicted");
     	CourtWarant.sendKeys("Negombo");

		if(RegNumber.getText()!= "")
			return  true;
		else
			return false;
	}
		
	//PIMS-19
	public void checkRegistrationNumberFormtForUnConvictedInamtes(){		
		InmateCatagory.sendKeys("Un-Convicted");
     	CourtWarant.sendKeys("Negombo");
     	String actualRegNumber = RegNumber.getText();
     	String serialNumberPerYear = actualRegNumber.substring(0,4);
     	String prisionInstitute = actualRegNumber.substring(6,7);
     	String courtCode = actualRegNumber.substring(9,11);
     	String yearOfAddmission = actualRegNumber.substring(13,16);
     	Assert.assertTrue(serialNumberPerYear.matches("^(\\d{5})$"),"Wrong Serial number format");
     	Assert.assertTrue(prisionInstitute.matches("^(\\d{2})$"),"Wrong prisin institute number format");
     	Assert.assertTrue(courtCode.contentEquals("NHC") ,"Wrong court code format");
     	Assert.assertEquals(yearOfAddmission.contentEquals("2015"), "Worg year code");
	}
	
	public String getRegistrationNumber(){
		
		return RegNumber.getAttribute("value");		
	}
		
	public String getActualSelectedAgeCategory(){
		
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {}
		
		String ageCategoryValue = AgeCatagoryDropdown.getAttribute("value");
		WebElement ageCategorySelectedOption = driver.findElement(By.xpath(AgeCatagoryOptionFirstPart + ageCategoryValue + AgeCategoryOptionLastPart));
		
		return ageCategorySelectedOption.getText();
	}
	
	//PIMS-1190
	public void addAge(String age){
		
		AgeAdmission.click();
		AgeAdmission.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		AgeAdmission.sendKeys(Keys.DELETE);		
		AgeAdmission.sendKeys(age + Keys.TAB);
	}

	public boolean checkNumberFormat(String category, String court) {
		
		InmateCatagory.sendKeys(category);
		CourtWarant.sendKeys(court + Keys.TAB);
		
		String CourtId = "";		
		if(court.equals("Colombo")) CourtId = "CSC";
		if(court.equals("Negombo"))	CourtId = "NHC";
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String genaratedRegNum = RegNumber.getAttribute("value");
		
		switch (category) {
		case "Baby":
			if(genaratedRegNum.matches("B/...../../" + CourtId + "/2015"))
				return true;
			break;
		case "Child":
			if(genaratedRegNum.matches("C/...../../" + CourtId + "/2015"))
				return true;
			break;
		case "Convicted":
			if(genaratedRegNum.matches("./...../2015"))
				return true;
			break;
		case "Un-Convicted":
			if(genaratedRegNum.matches("...../../" + CourtId + "/2015"))
				return true;
			break;
		case "Youth":
			if(genaratedRegNum.matches("Y/...../../" + CourtId + "/2015"))
				return true;
			break;
		}
		
		return false;
		
		
		
	}
}
