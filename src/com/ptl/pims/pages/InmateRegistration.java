package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.pims.util.Constants;

public class InmateRegistration {
	
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
	@FindBy(xpath = Constants.InmateRegistration_Classifiaction_Calssification)
	public WebElement classification;
	
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
	@FindBy(xpath = Constants.InmateRegistration_identification_bodymark)
	public WebElement bodymark;
	
	
	
	
	
	
	public InmateRegistration(WebDriver dr){		
		driver = dr;
	}
	
	public String getHeader(){		
		return HeaderField.getText();
	}
	
	public String getExpectedHeader(){
		return ""; //Constants.InmateRegistration_ExpectedHeader;
	}
	
	public void doAddPersonalDetailsOfInmate(String othrName1, String othrName2, String cllName1, 
			String cllName2, String addLine1, String addLine2, String postOff, String postCode,
			String cntry, String prvnce , String dstrct, String ds, String gsDiv, String cty,
			String plicDiv){
		
		//TODO : add method to search by reg number
//		editFirstInmate.click();
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
		district.sendKeys(dstrct);
		Ds.sendKeys(ds);
		gsDivision.sendKeys(gsDiv);
		city.sendKeys(cty);
		policeDivision.sendKeys(plicDiv);
	//	updateButton.click();
		
	}
	

	public void doAddClassifiactionDetailsOfInmate(String classif){
		//TODO : add method to search by reg number
		//editFirstInmate.click();
		tab_classification.click();
		classification.sendKeys(classif);		
		//updateButton.click();
		
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
	//	updateButton.click();
		
	}
	

	public void doAddIdentificationDetailsOfInmate(String Face, String FaceD, String Hair, String HairD, String Eyes, String EyesD, String Nose, String BodyMark){
		
		tab_identification.click();
		face.sendKeys(Face);
		faced.sendKeys(FaceD);
		hair.sendKeys(Hair);
		haird.sendKeys(HairD);
		eyes.sendKeys(Eyes);
		eyesd.sendKeys(EyesD);
		nose.sendKeys(Nose);
		bodymark.sendKeys(BodyMark);
		updateButton.click();
		
	}

	
	
}
