package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class AuthorizeAdmissionPage {

    WebDriver driver;
    
	@FindBy(xpath = Constants.CreateAdmission_NameWarrant)
	WebElement NameWarrent;
	@FindBy(xpath = Constants.CreateAdmission_Biometric)
	WebElement BioMetric;
	@FindBy(xpath = Constants.CreateAdmission_AgeAdmission)
	WebElement AgeAddmission;
  
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


	public boolean checkAvailableData(String inmateCatagory, String court, String age, String meal, 
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
	
}
