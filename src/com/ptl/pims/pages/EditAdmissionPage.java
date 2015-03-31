package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ptl.pims.util.Constants;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

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
	public EditAdmissionSelectPage doEditAdmition(String inmateCatagory, String court, String age, String meal, 
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
		
		UpdateInamteAdmissionButton.click();
		
		EditAdmissionSelectPage editAdmissionSelectPage = PageFactory.initElements(driver, EditAdmissionSelectPage.class);
		return editAdmissionSelectPage;	
	}
	
	private void clearField(WebElement element){
		
		element.click();
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.DELETE);	
	}
	
	public boolean allMandatoryAdmissionDataSavedProperly(String inmateCatagory, String court, String age, String meal, 
			String biometric,String nameAsWarrent, String classification, String gender){
		
		WebElement selectedCategory = driver.findElement(By.xpath("." + Constants.CreateAdmission_InmateCategory 
				+ Constants.EditAdmission_SelectedDropdownEndPart));
		WebElement selectedCourt = driver.findElement(By.xpath(Constants.CreateAdmission_CourtWarant 
				+ Constants.EditAdmission_SelectedDropdownEndPart));		
		WebElement selectedMeal = driver.findElement(By.xpath(Constants.CreateAdmission_MealType 
				+ Constants.EditAdmission_SelectedDropdownEndPart));
		WebElement selectedClassification = driver.findElement(By.xpath(Constants.CreateAdmission_OccurenceClassification 
				+ Constants.EditAdmission_SelectedDropdownEndPart));
		WebElement selectedGender = driver.findElement(By.xpath(Constants.CreateAdmission_Gender 
				+ Constants.EditAdmission_SelectedDropdownEndPart));
		
		
		
		//page values
		String InmateCat = selectedCategory.getText();
		String Court = selectedCourt.getText();
		String Age = AgeAddmission.getAttribute("value");
		String Meal = selectedMeal.getText();
		String Biometric = BioMetric.getAttribute("value");
		String NameAsWarrent = NameWarrent.getAttribute("value");
		String Classification = selectedClassification.getText();
		String Gender = selectedGender.getText();
		
		if(inmateCatagory.equals(InmateCat) && court.equals(Court) && age.equals(Age) && meal.equals(Meal) 
				&& biometric.equals(Biometric) && nameAsWarrent.equals(NameAsWarrent) 
				&& classification.equals(Classification) && gender.equals(Gender))		
		return true;
		else return false;
	}
	
	//PIMS - 1198
	public boolean allPicturesSavedProperly(){

		if((!FrontImage.getAttribute("src").equals(Constants.EditAdmission_DefaultFrontImage))
			&& (!RHSImage.getAttribute("src").equals(Constants.EditAdmission_DefaultRHSImage))
			&& (!LHSImage.getAttribute("src").equals(Constants.EditAdmission_DefaultLHSImage)))
			return true;

		
		return false;
	}

}
