package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ptl.pims.util.Constants;

public class CreateNewAdmissionPage extends CommonMethods {

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
	
	String Name_As_Warrent = "Nimal Pathirana";

	
	public CreateNewAdmissionPage(WebDriver dr){
		driver = dr;
	}

	public void doCreateNewAdmitionFor_ChildInmate() throws Exception{	
		try{			
			InmateCatagory.sendKeys("Child");
	     	CourtWarant.sendKeys("Negombo");
	     	AgeAddmission.sendKeys("25");
			MealType.sendKeys("Diet");
			BioMetric.sendKeys("Test Biometric");
			NameWarrent.sendKeys(Name_As_Warrent);
			OccurenceClassificatio.sendKeys("FO");
			Gender.sendKeys("male");	
		}
		catch(Exception ex){
			throw ex;		
		}
	}
		
	//PIMS-656
	public void doCreateNewAdmitionFor_ConvictedInmate() throws Exception{		
     	try{
     		InmateCatagory.sendKeys("Convicted");
         	CourtWarant.sendKeys("Negombo");
         	AgeAddmission.sendKeys("25");
    		MealType.sendKeys("Diet");
    		BioMetric.sendKeys("Test Biometric");
    		NameWarrent.sendKeys(Name_As_Warrent);
    		OccurenceClassificatio.sendKeys("FO");
    		Gender.sendKeys("male");	
     	}
     	catch(Exception ex){
     		throw ex;
     	}			
	}

	//PIMS-628
	public void doCreateNewAdmitionFor_Un_ConvictedInmate() throws Exception{	
	 	try{
	 		InmateCatagory.sendKeys("Un-Convicted");
		 	CourtWarant.sendKeys("Colombo");
		 	AgeAddmission.sendKeys("20");
			MealType.sendKeys("Diet");
			NameWarrent.sendKeys(Name_As_Warrent);
			OccurenceClassificatio.sendKeys("FO");
			Gender.sendKeys("male");
	 	}catch(Exception ex){
	 		throw ex;
	 	}
	
	}
	
	public void doCreateNewAdmitionFor_Un_ConvictedInmate_WithSubHeadings() throws Exception{
		
		try{
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
		}catch(Exception ex){
			throw ex;
		}
	}
	
	//PIMS-898
	public boolean checkMealTypeIsSelectable()throws Exception{
		try{
			if(MealType.getAttribute("disabled") == null)
				return true;
			else 
				return false;
		}catch (Exception ex){
			throw ex;
		}
			
	}
	
	//PIMS-869
	public boolean checkImateCatagoryIsSelectable() throws Exception{		
		try{
			if(InmateCatagory.getAttribute("disabled") == null)
				return true;
			else
				return false;	    
		}catch(Exception ex){
			throw ex;
		}
	}
	
	//PIMS-408
	public boolean checkIsInmateRegistrationNumberIsAutoGenarated() throws Exception{
		try{
			InmateCatagory.sendKeys("Convicted");
	     	CourtWarant.sendKeys("Negombo");
			MealType.sendKeys("Diet");
			if(RegNumber.getText()!= "")
				return  true;
			else
				return false;
		}catch(Exception ex){
			throw ex;
		}
	}
	
	//PIMS-1190
	public String checkAgeCatagoryIsAutoSelected() throws Exception{	
		try{
			InmateCatagory.sendKeys("Un-Convicted");
	     	CourtWarant.sendKeys("Negombo");
			AgeAddmission.sendKeys("20");
			MealType.sendKeys("Diet");
			String selectedOption = new Select(driver.findElement(By.xpath(Constants.CreateAdmission_AgeCategory))).getFirstSelectedOption().getText();
			return selectedOption;
		}catch(Exception ex){
			throw ex;
		}
		
	 
	}
	
	//PIMS-1198
	public void checkUserCanUploadTheAllThreeImages() throws Exception{	
			
			try{
				InmateCatagory.sendKeys("Child");
		     	CourtWarant.sendKeys("Negombo");
		     	AgeAddmission.sendKeys("25");
				MealType.sendKeys("Diet");
				NameWarrent.sendKeys(Name_As_Warrent);
				OccurenceClassificatio.sendKeys("FO");
				Thread.sleep(3000);
				ImageRHSBrowse.sendKeys(RHS_Image_Path); 
				Thread.sleep(3000);
				ImageFrontBrowse.sendKeys(Front_Image_Path);
				Thread.sleep(3000);
				ImageLHSBrowse.sendKeys(LHS_Image_Path);
			} catch(Exception ex){
				
				throw ex;
			}
			
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
		
	public NewAdmissionPage doAdmission() throws Exception {
		try{
			SaveInamteAdmissionButton.click();
			NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver,NewAdmissionPage.class);
			return newAdmissionPage;
		}
		catch(Exception ex){
			 throw ex;
		}
		
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

}
