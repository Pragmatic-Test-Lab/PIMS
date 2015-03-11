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
	WebElement AgeAdmission;
	@FindBy(xpath = Constants.CreateAdmission_AgeCategory)
	WebElement AgeCatagoryDropdown;
	String AgeCatagoryOptionFirstPart = Constants.AgeCatagoryOptionFirstPart;
	String AgeCategoryOptionLastPart = Constants.AgeCatagoryOptionLastPart;
	@FindBy(xpath = Constants.CreateAdmission_Youth_AgeCategory)
	WebElement SelectedAgeCatagoryAsYoth;
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
	@FindBy(xpath = Constants.Create_Admission_CreateButton)
	WebElement SaveInamteAdmissionButton;
	
	String ActualPage_Header;
	String ExpectedPage_Header;
	String RHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String Front_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String LHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	
	String Name_As_Warrent = "Nimal pathirana";

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
	
	//Create any type of inmate with required fields
	public void doCreateNewAdmissionWithRequiredFileds(String inmateCatagory, String court, String age, String meal, 
			String biometric,String nameAsWarrent, String classification, String gender){
		
		InmateCatagory.sendKeys(inmateCatagory);
     	CourtWarant.sendKeys(court);
     	AgeAdmission.sendKeys(age);
		MealType.sendKeys(meal);
		BioMetric.sendKeys(biometric);
		NameWarrent.sendKeys(nameAsWarrent);
		OccurenceClassificatio.sendKeys(classification);
		Gender.sendKeys(gender);	
		
		//
		//temporary date of admission selection
		//
		DateAddmission.click();
		//backMonth.click();
		driver.findElement(By.xpath(dateText_FirstPart + "3" + dateText_LastPart)).click(); //click on the selected date text
		driver.findElement(By.xpath(hourText_FirstPart + "1:00" + hourText_LastPart)).click(); //click on the selected hour text
		driver.findElement(By.xpath(minuteText_FirstPart + "1:25" + minuteText_LastPart)).click();
	}

	//Create any type of inmate with all sub headings fields
	public void doCreateNewAdmitionWithSubHeadings(String inmateCatagory, String court, String age, String meal, String biometric,
			String nameAsWarrent, String classification, String gender, String RHS_Image,String Front_Image, String LHS_Image,
			String caseCourt, String caseNo, String caseDate,
			boolean isPregnant, String hlthRemarks, boolean isFroPreSchool, String ofPreSchool,String drug, String observation,
			String complaintDate, String complainType, String complainDescription, 
			String ppDate, String ppItem, String ppDes, String ppQuantity, String ppVlue,
			String infantsPreschoolName, String InfantsPreschoolDob) throws Exception{
		
		InmateCatagory.sendKeys(inmateCatagory);
     	CourtWarant.sendKeys(court);
     	AgeAdmission.sendKeys(age);
		MealType.sendKeys(meal);
		BioMetric.sendKeys(biometric);
		NameWarrent.sendKeys(nameAsWarrent);
		OccurenceClassificatio.sendKeys(classification);
		Gender.sendKeys(gender);
		Thread.sleep(3000);
		ImageRHSBrowse.sendKeys(RHS_Image);
		Thread.sleep(3000);
		ImageFrontBrowse.sendKeys(Front_Image);
		Thread.sleep(3000);
		ImageLHSBrowse.sendKeys(LHS_Image);
		
		//Add court details
		InmateAddNewCase.click();
		InmateCaseDetailsCourt.sendKeys(caseCourt);
		InmateCaseDetailsCaseNumber.sendKeys(caseNo);
		InmateCaseDetailsDateConviction.sendKeys(caseDate);
		
		//Add Health Condition
		InmateHealthConditionTab.click();
		InmateHealthConditionMedicalAttention.click();
		if(isPregnant){
			InmateHealthConditionPregnant.click();
		}
		InmateHealthConditionRemarks.sendKeys(hlthRemarks);
		if(isFroPreSchool){
			InmateHealthConditionForPreSchool.click();
		}
		InmateHealthConditionOfPreSchool.sendKeys(ofPreSchool);
		
		InmateHealthConditionDrugsAddNew.click();
		InmateHealthConditionManageDrugs_Drugs.sendKeys(drug);
		
		InmateHealthConditionPhysicalAddNew.click();
		InmateHealthConditionPhysicalObservation.sendKeys(observation);
		
		//Inmate Complaint
		InmateComplainTab.click();
		InmateComplainAddNew.click();
		InmateComplainDate.sendKeys(complaintDate);
		InmateComplainType.sendKeys(complainType);
		InmateComplainDescription.sendKeys(complainDescription);
		
		//Inmate Private Properties
		InmatePrivatePropertiesTab.click();
		InmatePrivatePropertiesAddNew.click();
		InmatePrivatePropertiesDate.sendKeys(ppDate);
		InmatePrivatePropertiesItem.sendKeys(ppItem);
		InmatePrivatePropertiesDesciption.sendKeys(ppDes);
		InmatePrivatePropertiesQuantity.sendKeys(ppQuantity);
		InmatePrivatePropertiesValue.sendKeys(ppVlue);
		
		//InfantsPreschoolTab.
		InmateInfantsPreschoolTab.click();
		InmateInfantsPreschoolAddNew.click();
		InmateInfantsPreschoolName.sendKeys(infantsPreschoolName);
		InmateInfantsPreschoolDateOfBirth.sendKeys(InfantsPreschoolDob);
	}
	
	//PIMS-898
	public boolean checkMealTypeIsSelectable()throws Exception{
		if(MealType.getAttribute("disabled") == null)
			return true;
		else 
			return false;
	}
	
	//PIMS-869
	public boolean checkImateCatagoryIsSelectable() throws Exception{		
		if(InmateCatagory.getAttribute("disabled") == null)
			return true;
		else
			return false;	    
	}
	
	//PIMS-408
	public boolean checkIsInmateRegistrationNumberIsAutoGenarated() throws Exception{
		InmateCatagory.sendKeys("Convicted");
     	CourtWarant.sendKeys("Negombo");
		MealType.sendKeys("Diet");
		if(RegNumber.getText()!= "")
			return  true;
		else
			return false;
	}
	
	//PIMS-1190
	public String checkAgeCatagoryIsAutoSelected() throws Exception{	
		InmateCatagory.sendKeys("Un-Convicted");
     	CourtWarant.sendKeys("Negombo");
		AgeAdmission.sendKeys("20");
		MealType.sendKeys("Diet");
		String selectedOption = new Select(driver.findElement(By.xpath(Constants.CreateAdmission_AgeCategory))).getFirstSelectedOption().getText();
		return selectedOption;
	}
	
	//PIMS-1198
	public void checkUserCanUploadTheAllThreeImages() throws Exception{	
		InmateCatagory.sendKeys("Child");
     	CourtWarant.sendKeys("Negombo");
     	AgeAdmission.sendKeys("25");
		MealType.sendKeys("Diet");
		NameWarrent.sendKeys(Name_As_Warrent);
		OccurenceClassificatio.sendKeys("FO");
		Thread.sleep(3000);
		ImageRHSBrowse.sendKeys(RHS_Image_Path); 
		Thread.sleep(3000);
		ImageFrontBrowse.sendKeys(Front_Image_Path);
		Thread.sleep(3000);
		ImageLHSBrowse.sendKeys(LHS_Image_Path);
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
		
	public NewAdmissionPage doAdmission(){
			SaveInamteAdmissionButton.click();
			NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver,NewAdmissionPage.class);
			return newAdmissionPage;
	}

	public String getActualPageTitle(){
	    ActualPage_Header = CreateAdmissionHeader.getText();
		return ActualPage_Header;
	}
	
	public String getExpectedPageHeader(){
		ExpectedPage_Header = Constants.NewAdmission_ExpectedPageHeader;
		return ExpectedPage_Header;
		
	}
	
	public String getRegistrationNumber(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		String RegistrationNumber = RegNumber.getAttribute("value");
		System.out.println("Inmate Registration Number : " + RegistrationNumber);
		return RegistrationNumber;
	}

	
	
	public String getActualSelectedAgeCategory(){
		
		String ageCategoryValue = AgeCatagoryDropdown.getAttribute("value");
		WebElement ageCategorySelectedOption = driver.findElement(By.xpath(AgeCatagoryOptionFirstPart + ageCategoryValue + AgeCategoryOptionLastPart));
		
		return ageCategorySelectedOption.getText();
	}
	
	public void addAge(String age){
		
		AgeAdmission.sendKeys(age + Keys.TAB);
	}

	
	//-------------------Previous code--To Be Deleted----------------------------
	/*
	public void doCreateNewAdmitionFor_ChildInmate()throws Exception{				
		InmateCatagory.sendKeys("Child");
     	CourtWarant.sendKeys("Negombo");
     	AgeAddmission.sendKeys("25");
		MealType.sendKeys("Diet");
		BioMetric.sendKeys("Test Biometric");
		NameWarrent.sendKeys(Name_As_Warrent);
		OccurenceClassificatio.sendKeys("FO");
		Gender.sendKeys("male");	
	}
		
	//PIMS-656
	public void doCreateNewAdmitionFor_ConvictedInmate() throws Exception{		
 		InmateCatagory.sendKeys("Convicted");
     	CourtWarant.sendKeys("Negombo");
     	AgeAddmission.sendKeys("25");
		MealType.sendKeys("Diet");
		BioMetric.sendKeys("Test Biometric");
		NameWarrent.sendKeys(Name_As_Warrent);
		OccurenceClassificatio.sendKeys("FO");
		Gender.sendKeys("male");				
	}

	//PIMS-628
	public void doCreateNewAdmitionFor_Un_ConvictedInmate() throws Exception{	
 		InmateCatagory.sendKeys("Un-Convicted");
	 	CourtWarant.sendKeys("Colombo");
	 	AgeAddmission.sendKeys("20");
		MealType.sendKeys("Diet");
		NameWarrent.sendKeys(Name_As_Warrent);
		OccurenceClassificatio.sendKeys("FO");
		Gender.sendKeys("male");
	}
	public void doCreateNewAdmitionFor_Un_ConvictedInmate_WithSubHeadings() throws Exception{
		InmateCatagory.sendKeys("Child");
     	CourtWarant.sendKeys("Negombo");
     	AgeAddmission.sendKeys("20");
		MealType.sendKeys("Diet");
		BioMetric.sendKeys("Biometric Content");
		NameWarrent.sendKeys(Name_As_Warrent);
		OccurenceClassificatio.sendKeys("FO");
		Gender.sendKeys("male");
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
		InmateHealthConditionMedicalAttention.click();
		InmateHealthConditionPregnant.click();
		InmateHealthConditionRemarks.sendKeys("Health Conditions Remarks");
		InmateHealthConditionForPreSchool.click();
		InmateHealthConditionOfPreSchool.sendKeys("Health of school");
		InmateHealthConditionDrugsAddNew.click();
		InmateHealthConditionManageDrugs_Drugs.sendKeys("Other");
		InmateHealthConditionPhysicalAddNew.click();
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
	}
	*/

}
