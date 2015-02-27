package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ptl.pims.util.Constants;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class EditAdmissionPage extends CommonMethods{
	
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
	
	//Verify the images
	By rhs_image_alert_by = By.xpath(Constants.EditAdmission_RHS_Image_Alert_Text);
	By front_image_alert_by = By.xpath(Constants.EditAdmission_Front_Image_Alert_Text);
	By lhs_image_alert_by = By.xpath(Constants.EditAdmission_LHS_Image_Alert_Text);
	
	public EditAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	
	//PIMS-1194
	public void doEditAdmition(){
		
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
        Assert.assertTrue(EditConfirmMessage.isDisplayed()== true, "Adimssion Eidt Failed");	
	}
	
	public boolean getRHSImageBox() throws Exception{
		try{
			boolean result = checkElementIsPresent(driver,rhs_image_alert_by);
			return result;
		}catch(Exception ex){
			throw ex;
		}
	}
	public boolean getFrontImageBox() throws Exception{
		try{
			boolean result = checkElementIsPresent(driver,front_image_alert_by);
			return result;
		}catch(Exception ex){
			throw ex;
		}
	}
	public boolean getLHSImageBox() throws Exception{
		try{
			boolean result = checkElementIsPresent(driver,lhs_image_alert_by);
			return result;
		}catch(Exception ex){
			throw ex;
		}
	}
}
