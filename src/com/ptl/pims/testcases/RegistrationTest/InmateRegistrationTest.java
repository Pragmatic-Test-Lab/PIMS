package com.ptl.pims.testcases.RegistrationTest;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Registration.InmateRegistration;
import com.ptl.pims.pages.Registration.InmateRegistrationSelectPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;

public class InmateRegistrationTest extends TestBase {

	InmateRegistrationSelectPage inmateRegistrationSelect;
	InmateRegistration inmateRegistration;

	@Test
	public void goInmateRegistrationPage() {
		
		registrationNo = "T/10390/2015";
		
		loginToApplication();
		inmateRegistrationSelect  = getTopMenu().goToInmateRegistration();
		
		inmateRegistrationSelect = inmateRegistrationSelect.doSearch(registrationNo,"" ,"");
		inmateRegistration = inmateRegistrationSelect.clickFirstInmate(); 
	}

	
	@Test(dataProvider = "getInmateRegData",dependsOnMethods="goInmateRegistrationPage")   //PIMS-1079
	public void registerInmateTest(Hashtable<String, String> data) {

		inmateRegistration.doAddInmatePhotos();
		
		inmateRegistration.doAddPersonalDetailsOfInmate(data.get("OtherName1"),data.get("OtherName2"), 
				data.get("CallName1"), data.get("CallName2"),data.get("AddrLine1"), data.get("AddrLine2"), 
				data.get("PostOffice"),data.get("PostCode"), data.get("Country"),	data.get("Province"));
		
		inmateRegistration.doAddClassifiactionDetailsOfInmate(); 

		inmateRegistration.doAddCharacteristicDetailsOfInmate(data.get("Nationality"),data.get("Race"),data.get("Marital"),data.get("Religion"),
				data.get("NIC"),data.get("Birthdate"), data.get("Birthplace"), data.get("Passport")); 
		
		inmateRegistration.doAddIdentificationDetailsOfInmate(data.get("Face"),data.get("Faced"),data.get("Hair"),data.get("Haird"),
				data.get("Eyes"),data.get("Eyesd"), data.get("Nose"), null, data.get("Bodymark")); 
		
		inmateCase = "CASE001";
		
		inmateRegistration.doAddcaseDetailsOfInmate(inmateCase,data.get("Offense"),data.get("Offdescription"),data.get("Sentence"),
				data.get("Description"),data.get("Days"), data.get("Months"),data.get("Years"), data.get("Fine")); 	
		
		inmateRegistrationSelect = inmateRegistration.clickButton();
		
		assertTrue(inmateRegistrationSelect.successMessageAvaiable(), "success Message in Registration Page could not be found.");
	}	


	@DataProvider
	public Object[][] getInmateRegData() {
		return TestUtil.getTestData("Inmate Registration", xls);

	}


}

