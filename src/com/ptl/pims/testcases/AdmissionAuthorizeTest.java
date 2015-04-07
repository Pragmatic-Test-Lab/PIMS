package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.AuthorizeAdmissionPage;
import com.ptl.pims.pages.AuthorizeAdmissionSelectPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.TestUtil;

public class AdmissionAuthorizeTest extends TestBase {

	AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage;
	AuthorizeAdmissionPage authorizeAdmissionPage;
	
	@Test
	// PIMS-1194
	public void TestGoTooAuthorizeAdmition() {

		loginToApplication();
		TopMenu topMenu = getTopMenu();
		authorizeAdmissionSelectPage = topMenu
				.gotoAuthorizeAdmissionPage();

		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(
				registrationNo, "", "");
		authorizeAdmissionPage = authorizeAdmissionSelectPage
				.clickFirstInmate();

	}

	//checks if Edited data is available
	@Test(dependsOnMethods = "TestGoTooAuthorizeAdmition", dataProvider = "getEditAdmissionData")
	public void validateSavedInmateData(Hashtable<String, String> data) {

		if (data.get("Registration Number").equals(registrationNo)) {

			boolean admissionDataSaved = authorizeAdmissionPage.checkAvailableData(data.get("Inmate Category"), data.get("Court"),
					data.get("Age"), data.get("Meal Type"),	data.get("Biometric"), data.get("Name"),data.get("Classification"),
					data.get("Gender"));

			Assert.assertTrue(admissionDataSaved,"Data was not saved Properly.");
			APPLICATION_LOGS.debug("Data has been saved properly");

		}
	}

	@Test(dependsOnMethods = "validateSavedInmateData")
	public void TestAuthorizeAdmission() {

		try {Thread.sleep(120000);} catch (InterruptedException e) {}
		authorizeAdmissionSelectPage = authorizeAdmissionPage.doAuthorizeAdmission();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		
		// validate authorization
		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo, "", "");
		
		Assert.assertTrue(authorizeAdmissionSelectPage.NoSearchResultsFound(),
				"Inmate Still available in authorization page. Authorization Failed.");
	}
	
	@DataProvider
	public Object[][] getEditAdmissionData() {
		return TestUtil.getTestData("Inmate Edit Admission", xls);		
	}

}
