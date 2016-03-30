package com.ptl.pims.pages.Admission;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ptl.pims.pages.CalendarPopup;
import com.ptl.pims.pages.CommonMethods;
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
    @FindBy(xpath = Constants.Admission_InmateCourtTableBody)
	WebElement CaseTabTable;
	@FindBy(xpath = Constants.CreateAdmission_InmateCourtDetail_AddNew)
	WebElement InmateAddNewCase;


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
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Item)
	WebElement InmatePrivatePropertiesItem;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Description)
	WebElement InmatePrivatePropertiesDesciption;
	@FindBy(xpath = Constants.CreateAdmission_PrivateProperties_Quantity)
	WebElement InmatePrivatePropertiesQuantity;

	//
	//CreateAdmission Infant Fields
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolTab)
	WebElement InmateInfantsPreschoolTab;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolAddNew)
	WebElement InmateInfantsPreschoolAddNew;
	@FindBy(xpath = Constants.CreateAdmission_InfantsPreschoolName)
	WebElement InmateInfantsPreschoolName;
	@FindBy(xpath = Constants.Create_Admission_CreateButton)
	WebElement SaveInamteAdmissionButton;
	
	public CreateAdmissionPage(WebDriver dr){
		driver = dr;
	}

	public void fillRequiredFields(String inmateCatagory, String court, String age, String meal,
								   String biometric, String nameAsWarrent, String classification, String gender){

		InmateCatagory.sendKeys(inmateCatagory);
     	CourtWarant.sendKeys(court);
     	AgeAdmission.sendKeys(age);
		MealType.sendKeys(meal);
		BioMetric.sendKeys(biometric);
		NameWarrent.sendKeys(nameAsWarrent);
		OccurenceClassificatio.sendKeys(classification);
		Gender.sendKeys(gender);
	}

	public void addInmatePictures(String RHS_Image,String Front_Image, String LHS_Image){

			ImageRHSBrowse.sendKeys(RHS_Image);
			ImageFrontBrowse.sendKeys(Front_Image);
			ImageLHSBrowse.sendKeys(LHS_Image);			

	}

	public void fillCourtDetailsTab(String caseCourts, String caseNos,
									String caseDates, String senDates) {
		
		String[] court = caseCourts.split(",");
		String[] caseNo = caseNos.split(",");
		String[] conviction = caseDates.split(",");
		String[] sentence = senDates.split(",");
		
		int dataRows = initialRowCount(CaseTabTable);
		CalendarPopup CLNDR = new CalendarPopup(driver);
		
		for(int i=0; i< court.length; i++){		
			
		InmateAddNewCase.click();
		
		driver.findElement(By.xpath(Constants.Admission_InmateCourtDetail_Court + "[" + (dataRows + i) + "]")).sendKeys(court[i]);
		driver.findElement(By.xpath(Constants.Admission_InmateCourtDetail_CaseNumber + "[" + (dataRows + i) + "]")).sendKeys(caseNo[i]);
		
		CLNDR.selectDate(driver.findElement(By.xpath(Constants.Admission_InmateCourtDetail_DateConviction + "[" + (dataRows + i) + "]")), conviction[i]);		
		CLNDR.selectDate(driver.findElement(By.xpath(Constants.Admission_InmateCourtDetail_DateSentence + "[" + (dataRows + i) + "]")), sentence[i]);
		}	
	}

	public void fillHealthConditionsTab(boolean isPregnant, String hlthRemarks, boolean isFroPreSchool, String ofPreSchool, String drug,
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
	
	public void fillInmateComplaintsTab(String complaintDate, String complainType, String complainDescription){
		
		InmateComplainTab.click();
		InmateComplainAddNew.click();
		
		CalendarPopup CLNDR = new CalendarPopup(driver);
		CLNDR.selectDate(driver.findElement(By.xpath(Constants.CreateAdmission_InmateComplainDate)), complaintDate);
		
		InmateComplainType.sendKeys(complainType);
		InmateComplainDescription.sendKeys(complainDescription);
	}
	
	public void fillPrivatePropertiesTab(String ppDate, String ppItem, String ppDes, String ppQuantity){
		
		InmatePrivatePropertiesTab.click();
		InmatePrivatePropertiesAddNew.click();

		CalendarPopup CLNDR = new CalendarPopup(driver);
		CLNDR.selectDate(driver.findElement(By.xpath(Constants.CreateAdmission_PrivateProperties_Date)), ppDate);

		InmatePrivatePropertiesItem.sendKeys(ppItem);
		InmatePrivatePropertiesDesciption.sendKeys(ppDes);
		InmatePrivatePropertiesQuantity.sendKeys(ppQuantity);
	}
	
	public void fillInfantsPreschoolTab(String infantsPreschoolName, String InfantsPreschoolDob){
		
		InmateInfantsPreschoolTab.click();
		InmateInfantsPreschoolAddNew.click();
		InmateInfantsPreschoolName.sendKeys(infantsPreschoolName);

		CalendarPopup CLNDR = new CalendarPopup(driver);
		CLNDR.selectDate(driver.findElement(By.xpath(Constants.CreateAdmission_InfantsPreschoolDateOfBirth)), InfantsPreschoolDob);
	}
	
	public NewAdmissionPage submitAdmission() {

		waitForJSandJQueryToLoad(driver);
		SaveInamteAdmissionButton.click();
		NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver,NewAdmissionPage.class);
		return newAdmissionPage;
	}

	public String getRegistrationNumber(){
		return RegNumber.getAttribute("value");		
	}
		
	public String getActualSelectedAgeCategory(){

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForJSandJQueryToLoad(driver);
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

	public String setCategoryAndCourt(String category, String court) {
		
		InmateCatagory.sendKeys(category);
		CourtWarant.sendKeys(court + Keys.TAB);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForJSandJQueryToLoad(driver);
		return RegNumber.getAttribute("value");
	}
	
	private int initialRowCount(WebElement element) {
		List<WebElement> rows = element.findElements(By.tagName("tr"));	
		
		int size = rows.size();		
		return size;
	}
}
