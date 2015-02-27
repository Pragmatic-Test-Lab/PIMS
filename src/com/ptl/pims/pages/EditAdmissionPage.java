package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ptl.pims.util.Constants;

public class EditAdmissionPage {
	
	WebDriver driver;
		
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
	
	@FindBy(xpath = Constants.Update_Admission_UpdateButton)
	WebElement UpdateInamteAdmissionButton;
	@FindBy(xpath = "//*[text() = 'Nimal Pathirana Updated']")
	WebElement EditConfirmMessage;

	String Updated_Name_As_Warrent = "Nimal Pathirana Updated";
	String Expected_Message  = "Saved "+ Updated_Name_As_Warrent + " successfully";
	
	
	public EditAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	
	//PIMS-1194
	public EditAdmissionSelectPage doEditAdmition(){
		
     	InmateCatagory.sendKeys("Child");
     	CourtWarant.sendKeys("Colombo");
     	AgeAddmission.sendKeys("20");
		AgeCatagory.sendKeys("Youth");
		DateAddmission.sendKeys("2015-02-14 15:55");
		MealType.sendKeys("Vegeterian");
		BioMetric.sendKeys("Biometric Content Updated");
		NameWarrent.sendKeys(Updated_Name_As_Warrent);
		OccurenceClassificatio.sendKeys("RC");
		
		UpdateInamteAdmissionButton.click();
		
		EditAdmissionSelectPage editAdmissionSelectPage = PageFactory.initElements(driver, EditAdmissionSelectPage.class);
		return editAdmissionSelectPage;	
	}
	
	
}
