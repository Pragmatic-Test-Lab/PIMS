package com.ptl.pims.pages.Admission;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.CommonMethods;
import com.ptl.pims.util.Constants;

public class EditAdmissionPage extends CommonMethods{
	
	WebDriver driver;
	@FindBy(xpath = Constants.Update_Admission_UpdateButton)
	WebElement UpdateInamteAdmissionButton;
		
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

	
	//Inmate Images
	@FindBy(xpath = Constants.EditAdmission_FrontImage)
	WebElement FrontImage;
	@FindBy(xpath = Constants.EditAdmission_RHSImage)
	WebElement RHSImage;
	@FindBy(xpath = Constants.EditAdmission_LHSImage)
	WebElement LHSImage;

	
	public EditAdmissionPage(WebDriver dr){
		driver = dr;
	}	
	
	//PIMS-1194
	public void doEditAdmition(String inmateCatagory, String court, String age, String meal, 
			String biometric,String nameAsWarrent, String classification, String gender){
		
     	InmateCatagory.sendKeys(inmateCatagory);
     	CourtWarant.sendKeys(court);
     	clearField(AgeAddmission);
     		AgeAddmission.sendKeys(age);
		MealType.sendKeys(meal);
		clearField(BioMetric);
			BioMetric.sendKeys(biometric);
		clearField(NameWarrent);
			NameWarrent.sendKeys(nameAsWarrent);
		OccurenceClassificatio.sendKeys(classification);
		Gender.sendKeys(gender);

	}
	
	public EditAdmissionSelectPage clickUpdateButton(){

		UpdateInamteAdmissionButton.click();
		
		EditAdmissionSelectPage editAdmissionSelectPage = PageFactory.initElements(driver, EditAdmissionSelectPage.class);
		return editAdmissionSelectPage;	
	}
	
	
	
	private void clearField(WebElement element){
		
		element.click();
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.DELETE);	
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
	
	//PIMS - 1198
	public boolean allPicturesSavedProperly(){

		if((!FrontImage.getAttribute("src").equals(Constants.EditAdmission_DefaultFrontImage))
			&& (!RHSImage.getAttribute("src").equals(Constants.EditAdmission_DefaultRHSImage))
			&& (!LHSImage.getAttribute("src").equals(Constants.EditAdmission_DefaultLHSImage)))
			return true;

		
		return false;
	}

	public String getRegistrationNumber() {
		
		return RegNumber.getAttribute("value");		
	}

}
