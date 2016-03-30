package com.ptl.pims.testcases.RegistrationTest;

import java.util.Hashtable;

import com.ptl.pims.pages.Registration.AuthorizeRegistrationInmateSelectPage;
import com.ptl.pims.pages.Registration.AuthorizeRegistrationPage;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Registration.InmateRegistration;
import com.ptl.pims.pages.Registration.InmateRegistrationSelectPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;

public class InmateRegistrationTest extends TestBase {

	InmateRegistrationSelectPage inmateRegistrationSelect;
	InmateRegistration inmateRegistration;

	AuthorizeRegistrationInmateSelectPage inmateAuthorizeSelect;
	AuthorizeRegistrationPage inmateAuthorize;

	@Test
	public void goInmateRegistrationPage() {
		
		loginToApplication();
		inmateRegistrationSelect  = getTopMenu().goToInmateRegistration();
		
		inmateRegistrationSelect = inmateRegistrationSelect.doSearch(registrationNo,"" ,"");
		inmateRegistration = inmateRegistrationSelect.clickFirstInmate(); 
	}

	
	@Test(dataProvider = "getInmateRegData",dependsOnMethods="goInmateRegistrationPage")   //PIMS-1079
	public void registerInmateTest(Hashtable<String, String> data) {

		inmateRegistration.replaceInmatePhotos();
		
		inmateRegistration.doAddPersonalDetailsOfInmate(data.get("OtherName1"),data.get("OtherName2"), 
				data.get("CallName1"), data.get("CallName2"),data.get("AddrLine1"), data.get("AddrLine2"), 
				data.get("PostOffice"),data.get("PostCode"), data.get("Country"),	data.get("Province"));
		
		inmateRegistration.doAddClassifiactionDetailsOfInmate(); 

		inmateRegistration.doAddCharacteristicDetailsOfInmate(data.get("Nationality"),data.get("Race"),data.get("Marital"),data.get("Religion"),
				data.get("NIC"),data.get("Birthdate"), data.get("Birthplace"), data.get("Passport")); 
		
		inmateRegistration.doAddIdentificationDetailsOfInmate(data.get("Face"),data.get("Faced"),data.get("Hair"),data.get("Haird"),
				data.get("Eyes"),data.get("Eyesd"), data.get("Nose"), null, data.get("Bodymark"));

		inmateRegistration.EnterEducationalQualifications(data.get("Institues"), data.get("Qualification Types"), data.get("Languages"));

		inmateRegistration.EnterEmploymentData(data.get("Employers"), data.get("Organizational Types"), data.get("Positions"),
				data.get("Dates From"), data.get("Dates To"));

		inmateRegistration.EnterFamilyData("Herath", "1111223", "212121212v", "31", "Spouse", "11223331212", "32000");

		inmateRegistration.EnterChildData(data.get("Names"), data.get("Addresss"), data.get("Ages"), data.get("Schools"), data.get("Grades"));

		inmateRegistrationSelect = inmateRegistration.clickButton();
		assertTrue(inmateRegistrationSelect.successMessageAvaiable(), "success Message in Registration Page could not be found.");
	}

	@Test(dependsOnMethods="registerInmateTest")
	public void goToAuthorizeRegistrationPage() {

		inmateAuthorizeSelect = getTopMenu().gotoAuthorizeRegistrationPage();
		inmateAuthorizeSelect = inmateAuthorizeSelect.doSearch(registrationNo,"","");
		inmateAuthorize = inmateAuthorizeSelect.clickFirstInmate();
	}

	@Test(dependsOnMethods="goToAuthorizeRegistrationPage")
	public void authorizeRegistrationTest() {

		inmateAuthorizeSelect = inmateAuthorize.authorizeInmate();
		assertTrue(inmateAuthorizeSelect.successMessageAvaiable(), "Authorize Registratrion success message not found");
	}

	@DataProvider
	public Object[][] getInmateRegData() {
		return TestUtil.getTestData("Inmate Registration", xls);

	}


}

