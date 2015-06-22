package com.ptl.pims.pages.PostRegistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class AuthorizePostRegUserPage {
	
	WebDriver driver;

	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Authorize)
	WebElement authorize;
	
	
	public AuthorizePostRegUserPage(WebDriver dr){
		driver=dr;
	}
	
	
	
	public PostRegistrationAuthorizePage ClickAuthorizeButton(){
		authorize.click();
		PostRegistrationAuthorizePage postRegAuthorizePage = PageFactory.initElements(driver, PostRegistrationAuthorizePage.class);
		return postRegAuthorizePage;
	}
	
/*	 
	
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_CheckBox)
	WebElement checkBox;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_CurrentPrisonInstitute)
	WebElement curentPrisonInstitute;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_PhotoRightBrowse)
	WebElement photoRight;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_PhotoFrontBrowse)
	WebElement photoFront;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_PhotoLeftBrowse)
	WebElement photoLeft;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EducationalQualificationTab)
	WebElement educationalQualificationTab;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EducationalTBody)
	WebElement education_tbody;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EducationalQualificationAddNew)
	WebElement addNew;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Institute)
	WebElement institute;
	String instituteFirstPart=Constants.AuthorizePostRegUserPage_InstituteFirstPart;	
	String instituteLastPart=Constants.AuthorizePostRegUserPage_InstituteLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_QualificationType)
	WebElement qualificationType;
	String qualificationTypeFirstPart=Constants.AuthorizePostRegUserPage_QualificationTypeFirstPart;
	String qualificationTypeLastPart=Constants.AuthorizePostRegUserPage_QualificationTypeLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Language)
	WebElement language;
	String languageFirstPart = Constants.AuthorizePostRegUserPage_LanguageFirstPart;
	String languageLastPart=Constants.AuthorizePostRegUserPage_LanguageLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EducationalQualificationAction)
	WebElement educationAction;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EmploymentTab)
	WebElement employmentTab;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EmployerTBody)
	WebElement employer_tbody;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EmploymentAddNew)
	WebElement employmentAddNew;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Employer)
	WebElement employer;
	String employerFirstPart=Constants.AuthorizePostRegUserPage_EmployerFirstPart;	
	String employerLastPart=Constants.AuthorizePostRegUserPage_EmployerLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_OrganizationalType)
	WebElement organizationalType;
	String organizationalTypeFirstPart=Constants.AuthorizePostRegUserPage_OrganizationalTypeFirstPart;	
	String organizationalTypeLastPart=Constants.AuthorizePostRegUserPage_OrganizationalTypeLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Position)
	WebElement position;
	String positionFirstPart=Constants.AuthorizePostRegUserPage_PositionFirstPart;	
	String positionLastPart=Constants.AuthorizePostRegUserPage_PositionLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_DateFrom)
	WebElement dateFrom;
	String dateFromFirstPart=Constants.AuthorizePostRegUserPage_DateFromFirstPart;	
	String dateFromLastPart=Constants.AuthorizePostRegUserPage_DateFromLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_DateTo)
	WebElement dateTo;
	String dateToFirstPart=Constants.AuthorizePostRegUserPage_DateToFirstPart;	
	String dateToLastPart=Constants.AuthorizePostRegUserPage_DateToLastPart;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_EmploymentAction)
	WebElement employmentAction;	
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_FamilyTab)
	WebElement familyDataTab;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_FamilyAddNew)
	WebElement familyAddNew;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Name)
	WebElement name;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Address1)
	WebElement addressLine1;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Address2)
	WebElement addressLine2;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Address3)
	WebElement addressLine3;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_NIC)
	WebElement nic;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Age)
	WebElement age;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Relationship)
	WebElement relationship;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Telephone)
	WebElement telephone;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_Income)
	WebElement income;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_FamilyAction)
	WebElement familyAction;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildTab)
	WebElement childTab;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildName)
	WebElement childName;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildAddress1)
	WebElement childAddressLine1;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildAddress2)
	WebElement childAddressLine2;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildAddress3)
	WebElement childAddressLine3;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildAge)
	WebElement childAge;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildSchool)
	WebElement childSchool;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildGrade)
	WebElement childGrade;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildSchoolAddress1)
	WebElement schoolAddressLine1;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildSchoolAddress2)
	WebElement schoolAddressLine2;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildSchoolAddress3)
	WebElement schoolAddressLine3;
	@FindBy(xpath=Constants.AuthorizePostRegUserPage_ChildAction)
	WebElement childAction;
 
 
 
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
	
	
	public void EnterEducationalQualifications(String Institutes, String QualificationTypes, String Languages){
		
		String[] Institute = Institutes.split(",");
		String[] QualificationType = QualificationTypes.split(",");
		String[] Language = Languages.split(",");		
		
		int dataRows = initialRowCount(education_tbody);
		for (int i = 0; i < Institute.length; i++) {
			addNew.click();
			int newDataRow = dataRows + i - 1;
			String DataRowNumber = String.valueOf(newDataRow);
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath(instituteFirstPart+DataRowNumber+instituteLastPart)).sendKeys(Institute[i]);
				driver.findElement(By.xpath(qualificationTypeFirstPart+DataRowNumber+qualificationTypeLastPart)).sendKeys(QualificationType[i]);
				driver.findElement(By.xpath(languageFirstPart+DataRowNumber+languageLastPart)).sendKeys(Language[i]);
				
			} catch (Throwable t) {
				// TODO Auto-generated catch block
				t.printStackTrace();
			}
			
		}
	}
	
	
	public void gotoEmploymentTab(){
		employmentTab.click();
	}
	
	
	public String getActualEmploymnetTabStatus(){		
		String ActualStatus = employmentTab.getAttribute("aria-expanded");
		return ActualStatus;
		
	}	
	
	
	public String getExpectedEmploymentTabStatus(){
		String ExpectedStatus = Constants.UpdatePostRegistration_EmploymentTabStatus;
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
			int newDataRow = dataRows + i - 1;
			String DataRowNumber = String.valueOf(newDataRow);
			
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath(employerFirstPart+DataRowNumber+employerLastPart)).sendKeys(Employer[i]);
				driver.findElement(By.xpath(organizationalTypeFirstPart+DataRowNumber+organizationalTypeLastPart)).sendKeys(OrganizationalType[i]);
				driver.findElement(By.xpath(positionFirstPart+DataRowNumber+positionLastPart)).sendKeys(Position[i]);
				driver.findElement(By.xpath(dateFromFirstPart+DataRowNumber+dateFromLastPart)).sendKeys(DateFrom[i]);
				driver.findElement(By.xpath(dateToFirstPart+DataRowNumber+dateToLastPart)).sendKeys(DateTo[i]);
			} catch (Throwable t) {
				// TODO Auto-generated catch block
				t.printStackTrace();
			}
			
			
		}
	
		
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
	
	
	public int initialRowCount(WebElement element){
		List<WebElement> rows = element.findElements(By.tagName("tr"));		
		int size = rows.size();
		return size;
		
	}
*/

}

