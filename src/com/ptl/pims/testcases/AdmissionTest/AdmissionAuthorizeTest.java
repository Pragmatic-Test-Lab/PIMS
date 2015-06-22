package com.ptl.pims.testcases.AdmissionTest;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Admission.AuthorizeAdmissionPage;
import com.ptl.pims.pages.Admission.AuthorizeAdmissionSelectPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;

public class AdmissionAuthorizeTest extends TestBase {

	AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage;
	AuthorizeAdmissionPage authorizeAdmissionPage;
	
	@Test
	// PIMS-1194
	public void GoTooAuthorizeAdmition() {

		loginToApplication();
		authorizeAdmissionSelectPage = getTopMenu().gotoAuthorizeAdmissionPage();

		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo, "", "");
		authorizeAdmissionPage = authorizeAdmissionSelectPage.clickFirstInmate();

	}

	//checks if Edited data is available
	@Test(dependsOnMethods = "GoTooAuthorizeAdmition", dataProvider = "getEditAdmissionData", priority = 1, groups="AdmissionAuthorize")
	public void validateSavedInmateData(Hashtable<String, String> data) {


			boolean admissionDataSaved = authorizeAdmissionPage.checkAvailableData(data.get("Inmate Category"), data.get("Court"),
					data.get("Age"), data.get("Meal Type"), data.get("Name"),data.get("Classification"),
					data.get("Gender"));
			
			assertTrue(admissionDataSaved,"Data was not saved Properly from Admission Edit.");
				
		
	}

	@Test(dependsOnMethods = "GoTooAuthorizeAdmition", priority = 2)
	public void TestAuthorizeAdmission() {

		authorizeAdmissionPage.changeAdmissionDate(TestUtil.getTodaysDate());
		authorizeAdmissionSelectPage = authorizeAdmissionPage.doAuthorizeAdmission();

	    assertTrue(authorizeAdmissionSelectPage.successMessageAvaiable(),"Failed to find Authorize Admission Page Success Message");		

	}
	
	@DataProvider
	public Object[][] getEditAdmissionData() {
		return TestUtil.getTestData("Inmate Edit Admission", xls);		
	}

}
