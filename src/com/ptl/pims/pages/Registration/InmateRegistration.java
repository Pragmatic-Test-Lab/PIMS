package com.ptl.pims.pages.Registration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.CommonMethods;
import com.ptl.pims.util.Constants;

public class InmateRegistration extends CommonMethods{

	WebDriver driver ;

	@FindBy(xpath = Constants.InmateRegistration_FirtstRow_EditButton)
	public WebElement editFirstInmate;
	@FindBy(xpath = Constants.InmateRegistration_Personal_Update)
	public WebElement updateButton;
	@FindBy(xpath = Constants.InmateRegistration_Header)
	public WebElement HeaderField;
	@FindBy(xpath = Constants.InmateRegistration_personal_tab)
	public WebElement tab_personal;
	@FindBy(xpath = Constants.InmateRegistration_calssfication_tab)
	public WebElement tab_classification;
	@FindBy(xpath = Constants.InmateRegistration_characteristics_tab)
	public WebElement tab_characteristic;
	@FindBy(xpath = Constants.InmateRegistration_identification_tab)
	public WebElement tab_identification;
	@FindBy(xpath = Constants.InmateRegistration_case_tab)
	public WebElement tab_case;

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


	//Classification details tab
	@FindBy(xpath = Constants.InmateRegistration_Classification_Pervious_Conviction)
	public WebElement previous_conviction;
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_IsSpecial)
	public WebElement classification_IsSpecial;

	//characteristic details tab
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


	//identification details tab
	@FindBy(xpath = Constants.InmateRegistration_identification_face)
	public WebElement face;
	@FindBy(xpath = Constants.InmateRegistration_identification_faced)
	public WebElement faced;
	@FindBy(xpath = Constants.InmateRegistration_identification_hair)
	public WebElement hair;
	@FindBy(xpath = Constants.InmateRegistration_identification_haird)
	public WebElement haird;
	@FindBy(xpath = Constants.InmateRegistration_identification_eyes)
	public WebElement eyes;
	@FindBy(xpath = Constants.InmateRegistration_identification_eyesd)
	public WebElement eyesd;
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
	public WebElement Case_TabTableBody;
	
	private String caseFieldsCommonFirstPart = Constants.InmateRegistration_CaseFieldsCommonFirstPart;
	private String caseNo_LastPart = Constants.InmateRegistration_CaseNo_LastPart;
	private String offence_LastPart = Constants.InmateRegistration_Offence_LastPart;
	private String offenceDescription_LastPart = Constants.InmateRegistration_OffenceDescription_LastPart;
	private String sentenceType_LastPart = Constants.InmateRegistration_SentenceType_LastPart;
	private String description_LastPart = Constants.InmateRegistration_Description_LastPart;
	private String years_LastPart = Constants.InmateRegistration_Years_LastPart;
	private String months_LastPart = Constants.InmateRegistration_Months_LastPart;
	private String days_LastPart = Constants.InmateRegistration_Days_LastPart;
	private String fineCharges_LastPart = Constants.InmateRegistration_FineCharges_LastPart;
	private String isActive_LastPart = Constants.InmateRegistration_IsActive_LastPart;

	
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
	public void doAddInmatePhotos(){

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

		tab_personal.click();
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

		tab_classification.click();
		classification_IsSpecial.click();		

	}


	public void doAddCharacteristicDetailsOfInmate(String Nationality, String Race, String Marital, String Religion, String nic, String DOB, String BirthPlace, String PassportNumber){

		tab_characteristic.click();
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

		tab_identification.click();
		face.sendKeys(Face);
		faced.sendKeys(FaceD);
		hair.sendKeys(Hair);
		haird.sendKeys(HairD);
		eyes.sendKeys(Eyes);
		eyesd.sendKeys(EyesD);
		nose.sendKeys(Nose);
		health.sendKeys(Health);
		bodymark.sendKeys(BodyMark);

	}


	public void doAddcaseDetailsOfInmate(String CaseNo, String Offense, String OffDescription, String Sentence, String Description, String Day, String Month, 
			String Year, String Fine){

		tab_case.click();
		
		String[] CaseNos = CaseNo.split(",");
		String[] Offenses = Offense.split(",");
		String[] OffDescriptions = OffDescription.split(",");
		String[] Sentences = Sentence.split(",");
		String[] Descriptions = Description.split(",");		
		String[] Years = Year.split(",");		
		String[] Months = Month.split(",");		
		String[] Days = Day.split(",");		
		String[] Fines = Fine.split(",");		

		int dataRows = initialRowCount(Case_TabTableBody);
		
		for(int i=0; i< CaseNos.length; i++){

			add_new.click();			
			int newDataRow = dataRows + i;	
			
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + caseNo_LastPart)).sendKeys(CaseNos[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + offence_LastPart)).sendKeys(Offenses[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + offenceDescription_LastPart)).sendKeys(OffDescriptions[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + sentenceType_LastPart)).sendKeys(Sentences[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + description_LastPart)).sendKeys(Descriptions[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + years_LastPart)).sendKeys(Years[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + months_LastPart)).sendKeys(Months[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + days_LastPart)).sendKeys(Days[i]);
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + fineCharges_LastPart)).sendKeys(Fines[i]);
			
			driver.findElement(By.xpath(caseFieldsCommonFirstPart + newDataRow + isActive_LastPart)).click();
			
		}	

	}
	


	private int initialRowCount(WebElement element) {
		List<WebElement> rows = element.findElements(By.tagName("tr"));		
		int size = rows.size();
		return size;
	}

	public InmateRegistrationSelectPage clickButton() {
		
		updateButton.click();
		
		InmateRegistrationSelectPage InmateRegistrationSelectPage = PageFactory
				.initElements(driver, InmateRegistrationSelectPage.class);
		return InmateRegistrationSelectPage;
	}

	

}
