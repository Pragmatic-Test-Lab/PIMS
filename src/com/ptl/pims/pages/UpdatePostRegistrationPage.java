package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class UpdatePostRegistrationPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath=Constants.UpdatePostRegistration_CheckBox)
	WebElement checkBox;
	@FindBy(xpath=Constants.UpdatePostRegistration_CurrentPrisonInstitute)
	WebElement curentPrisonInstitute;
	@FindBy(xpath=Constants.UpdatePostRegistration_PhotoRightBrowse)
	WebElement photoRight;
	@FindBy(xpath=Constants.UpdatePostRegistration_PhotoFrontBrowse)
	WebElement photoFront;
	@FindBy(xpath=Constants.UpdatePostRegistration_PhotoLeftBrowse)
	WebElement photoLeft;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationTab)
	WebElement educationalQualificationTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationAddNew)
	WebElement addNew;
	@FindBy(xpath=Constants.UpdatePostRegistration_Institute)
	WebElement institute;
	@FindBy(xpath=Constants.UpdatePostRegistration_QualificationType)
	WebElement qualificationType;
	@FindBy(xpath=Constants.UpdatePostRegistration_Language)
	WebElement language;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationAction)
	WebElement educationAction;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentTab)
	WebElement employmentTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentAddNew)
	WebElement employmentAddNew;
	@FindBy(xpath=Constants.UpdatePostRegistration_Employer)
	WebElement employer;
	@FindBy(xpath=Constants.UpdatePostRegistration_OrganizationalType)
	WebElement organizationalType;
	@FindBy(xpath=Constants.UpdatePostRegistration_Position)
	WebElement position;
	@FindBy(xpath=Constants.UpdatePostRegistration_DateFrom)
	WebElement dateFrom;
	@FindBy(xpath=Constants.UpdatePostRegistration_DateTo)
	WebElement dateTo;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentAction)
	WebElement employmentAction;	
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyTab)
	WebElement familyDataTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyAddNew)
	WebElement familyAddNew;
	@FindBy(xpath=Constants.UpdatePostRegistration_Name)
	WebElement name;
	@FindBy(xpath=Constants.UpdatePostRegistration_Address1)
	WebElement addressLine1;
	@FindBy(xpath=Constants.UpdatePostRegistration_Address2)
	WebElement addressLine2;
	@FindBy(xpath=Constants.UpdatePostRegistration_Address3)
	WebElement addressLine3;
	@FindBy(xpath=Constants.UpdatePostRegistration_NIC)
	WebElement nic;
	@FindBy(xpath=Constants.UpdatePostRegistration_Age)
	WebElement age;
	@FindBy(xpath=Constants.UpdatePostRegistration_Relationship)
	WebElement relationship;
	@FindBy(xpath=Constants.UpdatePostRegistration_Telephone)
	WebElement telephone;
	@FindBy(xpath=Constants.UpdatePostRegistration_Income)
	WebElement income;
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyAction)
	WebElement familyAction;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildTab)
	WebElement childTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildName)
	WebElement childName;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAddress1)
	WebElement childAddressLine1;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAddress2)
	WebElement childAddressLine2;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAddress3)
	WebElement childAddressLine3;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAge)
	WebElement childAge;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildSchool)
	WebElement childSchool;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildGrade)
	WebElement childGrade;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildSchoolAddress1)
	WebElement schoolAddressLine1;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildSchoolAddress2)
	WebElement schoolAddressLine2;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildSchoolAddress3)
	WebElement schoolAddressLine3;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAction)
	WebElement childAction;
	@FindBy(xpath=Constants.UpdatePostRegistration_Update)
	WebElement update;
	
	
	
	
	public UpdatePostRegistrationPage(WebDriver dr){
		driver = dr;
	}
	
	
	public String getActualEducationalQualificationTabDefaultStatus(){
		String ActualDefaultStatus = "";
		
		if(educationalQualificationTab.getAttribute("aria-expanded") == null){
			ActualDefaultStatus = "true";			
		} else{
			ActualDefaultStatus = educationalQualificationTab.getAttribute("aria-expanded");
		}
		return ActualDefaultStatus;
		
	}	
	
	
	public String getExpectedEducationalQualificationTabDefaultStatus(){
		String ExpectedDefaultStatus = Constants.UpdatePostRegistration_EducationalQualificationTabStatus;
		return ExpectedDefaultStatus;
		
	}
	
	
	public void EnterGeneralData(String OrientationProgram, String CurrentPrison, String PhotoRight, String PhotoFront, String PhotoLeft){
		if(OrientationProgram.equalsIgnoreCase("Yes"))
			checkBox.click();
		
		curentPrisonInstitute.sendKeys(CurrentPrison);
		photoRight.sendKeys(PhotoRight);
		photoFront.sendKeys(PhotoFront);
		photoLeft.sendKeys(PhotoLeft);
	}
	
	
	public void EnterEducationalQualifications(String Institute, String QualificationType, String Language){
		addNew.click();
		institute.sendKeys(Institute);
		qualificationType.sendKeys(QualificationType);
		language.sendKeys(Language);
		
		
	}
	
	
	public void EnterEmploymentData(String Employer, String OrganizationalType, String Position, String DateFrom, String DateTo, String Action){
		employer.sendKeys(Employer);
		organizationalType.sendKeys(OrganizationalType);
		position.sendKeys(Position);
		dateFrom.sendKeys(DateFrom);
		dateTo.sendKeys(DateTo);
		
		
	}
	
	
	public void EnterFamilyData(String Name, String AddressLine1, String AddressLine2, String AddressLine3, String NIC, String Age, String Relationship,
			String Telephone, String Income){
		name.sendKeys(Name);
		addressLine1.sendKeys(AddressLine1);
		addressLine2.sendKeys(AddressLine2);
		addressLine3.sendKeys(AddressLine3);
		nic.sendKeys(NIC);
		age.sendKeys(Age);
		relationship.sendKeys(Relationship);
		telephone.sendKeys(Telephone);
		income.sendKeys(Income);
		
		
	}
	
	
	public void EnterChildData(String Name, String AddressLine1, String AddressLine2, String AddressLine3, String Age, String School,
			String Grade, String SchoolAddressLine1, String SchoolAddressLine2, String SchoolAddressLine3){
		
		childName.sendKeys(Name);
		childAddressLine1.sendKeys(AddressLine1);
		childAddressLine2.sendKeys(AddressLine2);
		childAddressLine3.sendKeys(AddressLine3);
		childAge.sendKeys(Age);
		childSchool.sendKeys(School);
		childGrade.sendKeys(Grade);
		schoolAddressLine1.sendKeys(SchoolAddressLine1);
		schoolAddressLine2.sendKeys(SchoolAddressLine2);
		schoolAddressLine3.sendKeys(SchoolAddressLine3);
	}
	
	
	public PostRegistrationPage ClickUpdateButton(){
		update.click();
		PostRegistrationPage postRegPage = PageFactory.initElements(driver, PostRegistrationPage.class);
		return postRegPage;
	}

}
