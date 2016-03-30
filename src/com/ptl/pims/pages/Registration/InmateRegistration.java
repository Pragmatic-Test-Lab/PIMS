package com.ptl.pims.pages.Registration;

import java.util.List;

import com.ptl.pims.pages.CalendarPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.CommonMethods;
import com.ptl.pims.util.Constants;

public class InmateRegistration extends CommonMethods{

	WebDriver driver ;

	@FindBy(xpath = Constants.InmateRegistration_Header)
	public WebElement HeaderField;

	//tabs
	@FindBy(xpath = Constants.InmateRegistration_personal_tab)
	public WebElement tab_Personal;
	@FindBy(xpath = Constants.InmateRegistration_calssfication_tab)
	public WebElement tab_Classification;
	@FindBy(xpath = Constants.InmateRegistration_characteristics_tab)
	public WebElement tab_Characteristic;
	@FindBy(xpath = Constants.InmateRegistration_identification_tab)
	public WebElement tab_Identification;
	@FindBy(xpath = Constants.InmateRegistration_case_tab)
	public WebElement tab_Case;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationTab)
	WebElement tab_EducationalQualification;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentTab)
	WebElement tab_Employment;
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyTab)
	WebElement tab_FamilyDetails;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildTab)
	WebElement tab_ChildDetails;

	//Personal details tab
	@FindBy(xpath = Constants.InmateRegistration_Personal_OtherName1)
	public WebElement otherName1;
	@FindBy(xpath = Constants.InmateRegistration_Personal_OtherName2)
	public WebElement otherName2;
	@FindBy(xpath = Constants.InmateRegistration_Personal_CallName1)
	public WebElement callName1;
	@FindBy(xpath = Constants.InmateRegistration_Personal_CallName2)
	public WebElement callName2;
	@FindBy(xpath = Constants.InmateRegistration_Personal_AddressLine1)
	public WebElement addressLine1;
	@FindBy(xpath = Constants.InmateRegistration_Personal_AddressLine2)
	public WebElement addressLine2;
	@FindBy(xpath = Constants.InmateRegistration_Personal_PostOffice)
	public WebElement postOffice;
	@FindBy(xpath = Constants.InmateRegistration_Personal_PostalCode)
	public WebElement postalCode;
	@FindBy(xpath = Constants.InmateRegistration_Personal_Country)
	public WebElement country;
	@FindBy(xpath = Constants.InmateRegistration_Personal_Province)
	public WebElement province;
	@FindBy(xpath = Constants.InmateRegistration_Personal_District)
	public WebElement district;
	@FindBy(xpath = Constants.InmateRegistration_Personal_DS)
	public WebElement Ds;
	@FindBy(xpath = Constants.InmateRegistration_Personal_GSDivision)
	public WebElement gsDivision;
	@FindBy(xpath = Constants.InmateRegistration_Personal_City)
	public WebElement city;
	@FindBy(xpath = Constants.InmateRegistration_Personal_PoliceDivision)
	public WebElement policeDivision;


	//Inmate classification details tab
	@FindBy(xpath = Constants.InmateRegistration_Classification_Pervious_Conviction)
	public WebElement previous_conviction;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_IsSpecial)
	public WebElement classification_IsSpecial;

	//Inmate characteristic details tab
	@FindBy(xpath = Constants.InmateRegistration_Characteristic_nationality)
	public WebElement nationality;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_race)
	public WebElement race;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_marital)
	public WebElement marital;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_religion)
	public WebElement religion;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_NIC)
	public WebElement NIC;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_birthdate)
	public WebElement birthdate;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_birthplace)
	public WebElement birthplace;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_passport)
	public WebElement passport;


	//Inmate identification details tab
	@FindBy(xpath = Constants.InmateRegistration_identification_face)
	public WebElement face;
	@FindBy(xpath = Constants.InmateRegistration_identification_faced)
	public WebElement faceDesc;
	@FindBy(xpath = Constants.InmateRegistration_identification_hair)
	public WebElement hair;
	@FindBy(xpath = Constants.InmateRegistration_identification_haird)
	public WebElement hairDesc;
	@FindBy(xpath = Constants.InmateRegistration_identification_eyes)
	public WebElement eyes;
	@FindBy(xpath = Constants.InmateRegistration_identification_eyesd)
	public WebElement eyesDesc;
	@FindBy(xpath = Constants.InmateRegistration_identification_nose)
	public WebElement nose;
	@FindBy(xpath = Constants.InmateRegistration_identification_health)
	public WebElement health;
	@FindBy(xpath = Constants.InmateRegistration_identification_bodymark)
	public WebElement bodymark;


	//case details tab
	@FindBy(xpath = Constants.InmateRegistration_case_addnew)
	public WebElement add_new;
	@FindBy(xpath = Constants.InmateRegistration_CaseDetailsTable)
	public WebElement case_TableBody;

	//Educational Qualification tab
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalTBody)
	WebElement education_TableBody;
	@FindBy(xpath=Constants.UpdatePostRegistration_EducationalQualificationAddNew)
	WebElement eduQualificationsAddNew;

	//Employment tab
	@FindBy(xpath=Constants.UpdatePostRegistration_EmployerTBody)
	WebElement employer_TableBody;
	@FindBy(xpath=Constants.UpdatePostRegistration_EmploymentAddNew)
	WebElement employmentAddNew;

	//Family Tab
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyTBody)
	WebElement family_TableBody;
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyAddNew)
	WebElement familyAddNew;
	@FindBy(xpath=Constants.UpdatePostRegistration_FamilyAction)
	WebElement familyAction;

	//Child Tab
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildTBody)
	WebElement child_TableBody;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAddNew)
	WebElement childAddNew;
	@FindBy(xpath=Constants.UpdatePostRegistration_ChildAction)
	WebElement childAction;
	
	//Image Upload
	@FindBy(xpath = Constants.InmateRegistration_RHSImage)
	WebElement ImageRHS;
	@FindBy(xpath = Constants.InmateRegistration_ImageRHSBrowse)
	WebElement ImageRHSBrowse;
	@FindBy(xpath = Constants.InmateRegistration_ImageRHSRemove)
	WebElement ImageRHSRemove;
	@FindBy(xpath = Constants.InmateRegistration_FrontImage)
	WebElement ImageFront;
	@FindBy(xpath = Constants.InmateRegistration_ImageFrontBrowse)
	WebElement ImageFrontBrowse;
	@FindBy(xpath = Constants.InmateRegistration_ImageFrontRemove)
	WebElement ImageFrontRemove;
	@FindBy(xpath = Constants.InmateRegistration_LHSImage)
	WebElement ImageLHS;
	@FindBy(xpath = Constants.InmateRegistration_ImageLHSBrowse)
	WebElement ImageLHSBrowse;
	@FindBy(xpath = Constants.InmateRegistration_ImageLHSRemove)
	WebElement ImageLHSRemove;
	
	String RHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Register_Format_JPG.jpg";
	String Front_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Register_Format_JPG.jpg";
	String LHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Register_Format_JPG.jpg";
	
	public InmateRegistration(WebDriver dr){		
		driver = dr;
	}

	public String getHeader(){
		return HeaderField.getText();
	}

	//adds/edits inmate photos
	public void replaceInmatePhotos(){

		//removing present images
		ImageFrontRemove.click();
		ImageRHSRemove.click();
		ImageLHSRemove.click();		
		
		//adding new photos
		ImageRHSBrowse.sendKeys(RHS_Image_Path);
		ImageFrontBrowse.sendKeys(Front_Image_Path);
		ImageLHSBrowse.sendKeys(LHS_Image_Path);
	}
	
	//checks if front photo uploaded in admission is available in registration
	public boolean IsFrontPhotoAvailable(){

		if(!ImageFront.getAttribute("src").equals(Constants.InmateRegistration_DefaultFrontImage))
			return true;

		return false;
	}

	public void doAddPersonalDetailsOfInmate(String othrName1, String othrName2, String cllName1, 
			String cllName2, String addLine1, String addLine2, String postOff, String postCode,
			String cntry, String prvnce){

		tab_Personal.click();
		otherName1.sendKeys(othrName1);
		otherName2.sendKeys(othrName2);
		callName1.sendKeys(cllName1);
		callName2.sendKeys(cllName2);
		addressLine1.sendKeys(addLine1);
		addressLine2.sendKeys(addLine2);
		postOffice.sendKeys(postOff);
		postalCode.sendKeys(postCode);
		country.sendKeys(cntry);
		province.sendKeys(prvnce);

	}


	public void doAddClassifiactionDetailsOfInmate(){

		tab_Classification.click();
		classification_IsSpecial.click();		

	}


	public void doAddCharacteristicDetailsOfInmate(String Nationality, String Race, String Marital, String Religion, String nic, String DOB, String BirthPlace, String PassportNumber){

		tab_Characteristic.click();
		nationality.sendKeys(Nationality);
		race.sendKeys(Race);
		marital.sendKeys(Marital);
		religion.sendKeys(Religion);
		NIC.sendKeys(nic);
		birthdate.sendKeys(DOB);
		birthplace.sendKeys(BirthPlace);
		passport.sendKeys(PassportNumber);

	}


	public void doAddIdentificationDetailsOfInmate(String Face, String FaceD, String Hair, String HairD, String Eyes, String EyesD, String Nose, String Health, String BodyMark){

		tab_Identification.click();
		face.sendKeys(Face);
		faceDesc.sendKeys(FaceD);
		hair.sendKeys(Hair);
		hairDesc.sendKeys(HairD);
		eyes.sendKeys(Eyes);
		eyesDesc.sendKeys(EyesD);
		nose.sendKeys(Nose);
		health.sendKeys(Health);
		bodymark.sendKeys(BodyMark);
	}


	public void doAddcaseDetailsOfInmate(String CaseNo, String Offense, String OffDescription, String Sentence, String Description, String Day, String Month, 
			String Year, String Fine){

		tab_Case.click();
		
		String[] CaseNos = CaseNo.split(",");
		String[] Offenses = Offense.split(",");
		String[] OffDescriptions = OffDescription.split(",");
		String[] Sentences = Sentence.split(",");
		String[] Descriptions = Description.split(",");		
		String[] Years = Year.split(",");		
		String[] Months = Month.split(",");		
		String[] Days = Day.split(",");		
		String[] Fines = Fine.split(",");		

		int dataRows = initialRowCount(case_TableBody);
		
		for(int i=0; i< CaseNos.length; i++){

			add_new.click();			
			int newDataRow = dataRows + i;

			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_CaseNo_LastPart, CaseNos[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_Offence_LastPart, Offenses[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_OffenceDescription_LastPart, OffDescriptions[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_SentenceType_LastPart, Sentences[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_Description_LastPart, Descriptions[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_Years_LastPart, Years[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_Months_LastPart, Months[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_Days_LastPart, Days[i]);
			waitAndSendKeys(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_FineCharges_LastPart, Fines[i]);

			waitAndClick(driver, Constants.InmateRegistration_CaseFieldsCommonFirstPart + newDataRow + Constants.InmateRegistration_IsActive_LastPart);
		}
	}



	public void EnterEducationalQualifications(String Institutes, String QualificationTypes, String Languages){

		tab_EducationalQualification.click();

		String[] Institute = Institutes.split(",");
		String[] QualificationType = QualificationTypes.split(",");
		String[] Language = Languages.split(",");

		int dataRows = initialRowCount(education_TableBody);
		for (int i = 0; i < Institute.length; i++) {
			eduQualificationsAddNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);

			waitAndSendKeys(driver, Constants.UpdatePostRegistration_InstituteFirstPart + DataRowNumber + Constants.UpdatePostRegistration_InstituteLastPart, Institute[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_QualificationTypeFirstPart + DataRowNumber + Constants.UpdatePostRegistration_QualificationTypeLastPart, QualificationType[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_LanguageFirstPart + DataRowNumber + Constants.UpdatePostRegistration_LanguageLastPart, Language[i]);
		}
	}


	public void EnterEmploymentData(String Employers, String OrganizationalTypes, String Positions, String DatesFrom, String DatesTo){

		tab_Employment.click();

		String[] Employer = Employers.split(",");
		String[] OrganizationalType = OrganizationalTypes.split(",");
		String[] Position = Positions.split(",");
		String[] DateFrom = DatesFrom.split(",");
		String[] DateTo = DatesTo.split(",");

        CalendarPopup CLNDR = new CalendarPopup(driver);

		int dataRows = initialRowCount(employer_TableBody);
		for (int i = 0; i < Employer.length; i++) {

			employmentAddNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);

			waitAndSendKeys(driver, Constants.UpdatePostRegistration_EmployerFirstPart + DataRowNumber + Constants.UpdatePostRegistration_EmployerLastPart, Employer[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_OrganizationalTypeFirstPart + DataRowNumber + Constants.UpdatePostRegistration_OrganizationalTypeLastPart, OrganizationalType[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_PositionFirstPart + DataRowNumber + Constants.UpdatePostRegistration_PositionLastPart, Position[i]);

            CLNDR.selectDate(driver.findElement(By.xpath(Constants.UpdatePostRegistration_DateFromFirstPart + DataRowNumber + Constants.UpdatePostRegistration_DateFromLastPart)), DateFrom[i]);
            CLNDR.selectDate(driver.findElement(By.xpath(Constants.UpdatePostRegistration_DateToFirstPart + DataRowNumber + Constants.UpdatePostRegistration_DateToLastPart)), DateTo[i]);
		}
	}


	public void EnterFamilyData(String Name, String Address, String NIC, String Age, String Relationship,
								String Telephone, String Income){

		tab_FamilyDetails.click();

		String[] Names = Name.split(",");
		String[] Addresss = Address.split(",");
		String[] NICs = NIC.split(",");
		String[] Ages = Age.split(",");
		String[] Relationships = Relationship.split(",");
		String[] Telephones = Telephone.split(",");
		String[] Incomes = Income.split(",");

		int dataRows = initialRowCount(family_TableBody);
		for (int i = 0; i < Names.length; i++) {
			familyAddNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);

			waitAndSendKeys(driver, Constants.UpdatePostRegistration_FamilyNameFirstPart + DataRowNumber + Constants.UpdatePostRegistration_FamilyNameLastPart, Names[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_Address1FirstPart + DataRowNumber + Constants.UpdatePostRegistration_Address1LastPart, Addresss[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_NICFirstPart + DataRowNumber + Constants.UpdatePostRegistration_NICLastPart, NICs[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_FamilyAgeFirstPart + DataRowNumber + Constants.UpdatePostRegistration_FamilyAgeLastPart, Ages[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_RelationshipFirstPart + DataRowNumber + Constants.UpdatePostRegistration_RelationshipLastPart, Relationships[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_TelephoneFirstPart + DataRowNumber + Constants.UpdatePostRegistration_TelephoneLastPart, Telephones[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_IncomeFirstPart + DataRowNumber + Constants.UpdatePostRegistration_IncomeLastPart, Incomes[i]);
		}
	}

	public void EnterChildData(String Names, String Addresss, String Ages, String Schools, String Grades){

		tab_ChildDetails.click();

		String[] Name = Names.split(",");
		String[] Address = Addresss.split(",");
		String[] Age = Ages.split(",");
		String[] School = Schools.split(",");
		String[] Grade = Grades.split(",");

		int dataRows = initialRowCount(child_TableBody);
		for (int i = 0; i < Name.length; i++) {
			childAddNew.click();
			int newDataRow = dataRows + i;
			String DataRowNumber = String.valueOf(newDataRow);

			waitAndSendKeys(driver, Constants.UpdatePostRegistration_ChildNameFirstPart + DataRowNumber + Constants.UpdatePostRegistration_ChildNamelasttPart, Name[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_ChildAddress1_FirstPart + DataRowNumber + Constants.UpdatePostRegistration_ChildAddress1_LastPart, Address[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_ChildAge_FirstPart + DataRowNumber + Constants.UpdatePostRegistration_ChildAge_LastPart, Age[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_ChildSchool_firstpart + DataRowNumber + Constants.UpdatePostRegistration_ChildSchool_lastpart, School[i]);
			waitAndSendKeys(driver, Constants.UpdatePostRegistration_ChildGrade_firstpart + DataRowNumber + Constants.UpdatePostRegistration_ChildGrade_lastpart, Grade[i]);
		}
	}


	private int initialRowCount(WebElement element) {
		List<WebElement> rows = element.findElements(By.tagName("tr"));		
		int size = rows.size();

        if(size == 0)
            return 1;
        else return size;
	}

	public InmateRegistrationSelectPage clickButton() {
		
		waitAndClick(driver, Constants.InmateRegistration_Personal_Update);
		
		InmateRegistrationSelectPage InmateRegistrationSelectPage = PageFactory
				.initElements(driver, InmateRegistrationSelectPage.class);
		return InmateRegistrationSelectPage;
	}
	

}
