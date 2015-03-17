package com.ptl.pims.pages;

import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(xpath=Constants.UpdatePostRegistration_Update)
	WebElement update;

	//Educational Qualification tab
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationTab)
	WebElement educationalQualificationTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalTBody)
	WebElement education_tbody;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationAddNew)
	WebElement addNew;
	String instituteFirstPart=Constants.UpdatePostRegistration_InstituteFirstPart;	
	String instituteLastPart=Constants.UpdatePostRegistration_InstituteLastPart;
	String qualificationTypeFirstPart=Constants.UpdatePostRegistration_QualificationTypeFirstPart;
	String qualificationTypeLastPart=Constants.UpdatePostRegistration_QualificationTypeLastPart;
	String languageFirstPart = Constants.UpdatePostRegistration_LanguageFirstPart;
	String languageLastPart=Constants.UpdatePostRegistration_LanguageLastPart;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationAction)
	WebElement educationAction;
	
	//Employment tab
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentTab)
	WebElement employmentTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmployerTBody)
	WebElement employer_tbody;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentAddNew)
	WebElement employmentAddNew;
	String employerFirstPart=Constants.UpdatePostRegistration_EmployerFirstPart;	
	String employerLastPart=Constants.UpdatePostRegistration_EmployerLastPart;
	String organizationalTypeFirstPart=Constants.UpdatePostRegistration_OrganizationalTypeFirstPart;	
	String organizationalTypeLastPart=Constants.UpdatePostRegistration_OrganizationalTypeLastPart;
	String positionFirstPart=Constants.UpdatePostRegistration_PositionFirstPart;	
	String positionLastPart=Constants.UpdatePostRegistration_PositionLastPart;
	String dateFromFirstPart=Constants.UpdatePostRegistration_DateFromFirstPart;	
	String dateFromLastPart=Constants.UpdatePostRegistration_DateFromLastPart;
	String dateToFirstPart=Constants.UpdatePostRegistration_DateToFirstPart;	
	String dateToLastPart=Constants.UpdatePostRegistration_DateToLastPart;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentAction)
	WebElement employmentAction;	
	
	//Family Tab
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyTab)
	WebElement familyDataTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyTBody)
	WebElement family_tbody;
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyAddNew)
	WebElement familyAddNew;
	String familyNameFirstPart = Constants.UpdatePostRegistration_FamilyNameFirstPart;
	String familyNameLastPart = Constants.UpdatePostRegistration_FamilyNameLastPart;
	String FamilyAddress1FirstPart = Constants.UpdatePostRegistration_Address1FirstPart;
	String FamilyAddress1LastPart = Constants.UpdatePostRegistration_Address1LastPart;
	String NICFirstPart = Constants.UpdatePostRegistration_NICFirstPart;
	String NICLastPart = Constants.UpdatePostRegistration_NICLastPart;
	String familyAgeFirstPart = Constants.UpdatePostRegistration_FamilyAgeFirstPart;
	String familyAgeLastPart = Constants.UpdatePostRegistration_FamilyAgeLastPart;
	String relationshipFirstPart = Constants.UpdatePostRegistration_RelationshipFirstPart;
	String relationshipLastPart = Constants.UpdatePostRegistration_RelationshipLastPart;
	String telephoneFirstPart = Constants.UpdatePostRegistration_TelephoneFirstPart;
	String telephoneLastPart = Constants.UpdatePostRegistration_TelephoneLastPart;
	String incomeFirstPart = Constants.UpdatePostRegistration_IncomeFirstPart;
	String incomeLastPart = Constants.UpdatePostRegistration_IncomeLastPart;	
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyAction)
	WebElement familyAction;
	
	//Child Tab
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildTab)
	WebElement childTab;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildTBody)
	WebElement child_tbody;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAddNew)
	WebElement childAddNew;	
	String Child_Name_first_part=Constants.UpdatePostRegistration_ChildNameFirstPart;
	String Child_Name_last_part=Constants.UpdatePostRegistration_ChildNamelasttPart;
	String Child_Address_first_part=Constants.UpdatePostRegistration_ChildAddress1_FirstPart;
	String Child_Address_last_part=Constants.UpdatePostRegistration_ChildAddress1_LastPart;
	String Child_age_first_part=Constants.UpdatePostRegistration_ChildAge_FirstPart;
	String Child_age_last_part=Constants.UpdatePostRegistration_ChildAge_LastPart;
	String Child_school_first_part=Constants.UpdatePostRegistration_ChildSchool_firstpart;
	String Child_school_last_part=Constants.UpdatePostRegistration_ChildSchool_lastpart;
	String Child_grade_first_part=Constants.UpdatePostRegistration_ChildGrade_firstpart;
	String Child_grade_last_part=Constants.UpdatePostRegistration_ChildGrade_lastpart;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAction)
	WebElement childAction;

	
	
	
	
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

	
	
	public void EnterGeneralData(String OrientationProgram, String CurrentPrison, String PhotoRight, String PhotoFront, String PhotoLeft){
		if(OrientationProgram.equalsIgnoreCase("Yes"))
			checkBox.click();
		
		curentPrisonInstitute.sendKeys(CurrentPrison);
		photoRight.sendKeys(PhotoRight);
		photoFront.sendKeys(PhotoFront);
		photoLeft.sendKeys(PhotoLeft);
	}
	
	
	public void EnterEducationalQualifications(String Institutes, String QualificationTypes, String Languages){
		
		String[] Institute = Institutes.split(",");
		String[] QualificationType = QualificationTypes.split(",");
		String[] Language = Languages.split(",");		
		
		int dataRows = initialRowCount(education_tbody);
		for (int i = 0; i < Institute.length; i++) {
			addNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath(instituteFirstPart+DataRowNumber+instituteLastPart)).sendKeys(Institute[i]);
				driver.findElement(By.xpath(qualificationTypeFirstPart+DataRowNumber+qualificationTypeLastPart)).sendKeys(QualificationType[i]);
				driver.findElement(By.xpath(languageFirstPart+DataRowNumber+languageLastPart)).sendKeys(Language[i]);
				
			} catch (Throwable t) { t.printStackTrace();}
			
		}
	}
	
	
	public void gotoEmploymentTab(){
		employmentTab.click();
	}
	
	public void gotoChildTab(){
		childTab.click();
	}
	
	public String getActualEmploymnetTabStatus(){		
		String ActualStatus = employmentTab.getAttribute("aria-expanded");
		return ActualStatus;
		
	}	
	
	public String getActualChildTabStatus(){		
		String ActualStatus = childTab.getAttribute("aria-expanded");
		return ActualStatus;
		
	}
	
	public String getExpectedEmploymentTabStatus(){
		String ExpectedStatus = Constants.UpdatePostRegistration_EmploymentTabStatus;
		return ExpectedStatus;
		
	}
	
	public String getExpectedChildTabStatus(){
		String ExpectedStatus = Constants.UpdatePostRegistration_ChildTabStatus;
		return ExpectedStatus;
		
	}
	
	public void EnterEmploymentData(String Employers, String OrganizationalTypes, String Positions, String DatesFrom, String DatesTo){		

		String[] Employer = Employers.split(",");
		String[] OrganizationalType = OrganizationalTypes.split(",");
		String[] Position = Positions.split(",");
		String[] DateFrom = DatesFrom.split(",");
		String[] DateTo = DatesTo.split(",");
		
		int dataRows = initialRowCount(employer_tbody);
		for (int i = 0; i < Employer.length; i++) {
			employmentAddNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);
			
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath(employerFirstPart +DataRowNumber+employerLastPart)).sendKeys(Employer[i]);
				driver.findElement(By.xpath(organizationalTypeFirstPart+DataRowNumber+organizationalTypeLastPart)).sendKeys(OrganizationalType[i]);
				driver.findElement(By.xpath(positionFirstPart+DataRowNumber+positionLastPart)).sendKeys(Position[i]);
				driver.findElement(By.xpath(dateFromFirstPart+DataRowNumber+dateFromLastPart)).sendKeys(DateFrom[i]);
				driver.findElement(By.xpath(dateToFirstPart+DataRowNumber+dateToLastPart)).sendKeys(DateTo[i]);
			} catch (Throwable t) { t.printStackTrace();}	
		}		
	}
	
	
	public void EnterFamilyData(String Name, String Address, String NIC, String Age, String Relationship,
			String Telephone, String Income){

		
		String[] Names = Name.split(",");
		String[] Addresss = Address.split(",");
		String[] NICs = NIC.split(",");
		String[] Ages = Age.split(",");
		String[] Relationships = Relationship.split(",");
		String[] Telephones = Telephone.split(",");
		String[] Incomes = Income.split(",");
		
		int dataRows = initialRowCount(family_tbody);
		for (int i = 0; i < Names.length; i++) {
			familyAddNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);
			
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath(familyNameFirstPart+DataRowNumber+familyNameLastPart)).sendKeys(Names[i]);
				driver.findElement(By.xpath(FamilyAddress1FirstPart+DataRowNumber+FamilyAddress1LastPart)).sendKeys(Addresss[i]);
				driver.findElement(By.xpath(NICFirstPart+DataRowNumber+NICLastPart)).sendKeys(NICs[i]);
				driver.findElement(By.xpath(familyAgeFirstPart+DataRowNumber+familyAgeLastPart)).sendKeys(Ages[i]);
				driver.findElement(By.xpath(relationshipFirstPart+DataRowNumber+relationshipLastPart)).sendKeys(Relationships[i]);
				driver.findElement(By.xpath(telephoneFirstPart+DataRowNumber+telephoneLastPart)).sendKeys(Telephones[i]);
				driver.findElement(By.xpath(incomeFirstPart+DataRowNumber+incomeLastPart)).sendKeys(Incomes[i]);
				
			} catch (Throwable t) { t.printStackTrace();}			
		}		
	}
	
	public void EnterChildData(String Names, String Addresss, String Ages, String Schools, String Grades){		

		String[] Name = Names.split(",");
		String[] Address = Addresss.split(",");
		String[] Age = Ages.split(",");
		String[] School = Schools.split(",");
		String[] Grade = Grades.split(",");
		
		int dataRows = initialRowCount(child_tbody);
		for (int i = 0; i < Name.length; i++) {
			childAddNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);
			
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath(Child_Name_first_part+DataRowNumber+Child_Name_last_part)).sendKeys(Name[i]);
				driver.findElement(By.xpath(Child_Address_first_part+DataRowNumber+Child_Address_last_part)).sendKeys(Address[i]);
				driver.findElement(By.xpath(Child_age_first_part+DataRowNumber+Child_age_last_part)).sendKeys(Age[i]);
				driver.findElement(By.xpath(Child_school_first_part+DataRowNumber+Child_school_last_part)).sendKeys(School[i]);
				driver.findElement(By.xpath(Child_grade_first_part+DataRowNumber+Child_grade_last_part)).sendKeys(Grade[i]);
				
			} catch (Throwable t) { t.printStackTrace();}
			
		}
	
	}


	public int initialRowCount(WebElement element){
		List<WebElement> rows = element.findElements(By.tagName("tr"));		
		int size = rows.size();
		return size;
		
	}
	
	
	public PostRegistrationPage ClickUpdateButton(){
		update.click();
		PostRegistrationPage postRegPage = PageFactory.initElements(driver, PostRegistrationPage.class);
		return postRegPage;
	}

}
