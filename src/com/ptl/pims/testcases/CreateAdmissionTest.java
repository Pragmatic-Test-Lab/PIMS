package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.TestUtil;

public class CreateAdmissionTest extends TestBase {

	HomePage landingPage = null;

	@Test(dataProvider = "getCreateAdmissionData")
	public void ValidateAutoSelectedAgeCategory(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("CreateAdmission Test", xls)	|| data.get("Runmode").equals("No") || data.get("Runmode").equals("")){
			APPLICATION_LOGS.debug("Skipping the Auto Selected Age Category test");
			throw new SkipException("Skipping the Auto Selected Age Category test");
		} else{
			APPLICATION_LOGS.debug("Executing Auto Selected Age Category test...");
			landingPage = returnToHomePage();
			APPLICATION_LOGS.debug("Going to Home Page");
			TopMenu topMenu = getTopMenu();
			APPLICATION_LOGS.debug("Going to Top Menu");
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
			APPLICATION_LOGS.debug("Going to the New Admission Page");
			CreateAdmissionPage createAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			APPLICATION_LOGS.debug("Going to the Create Admission Page");
			
			
			APPLICATION_LOGS.debug("Expected Age Category: " + 
			createAdmissionPage.getExpectedAutoSelectedAgeCategory(data.get("Admission Age")));
			APPLICATION_LOGS.debug("Actual Age Category: " + createAdmissionPage.getActualAutoSelectedAgeCategory());
			
			Assert.assertEquals(createAdmissionPage.getActualAutoSelectedAgeCategory(), 
					createAdmissionPage.getExpectedAutoSelectedAgeCategory(data.get("Admission Age")), 
					"Actual Auto Selected Age Category is not equal to the expected one");
			
			APPLICATION_LOGS.debug("Successfully executed the Auto Selected Age Category test");
		}
	}
	
	
	

	@DataProvider
	public Object[][] getCreateAdmissionData() {
		return TestUtil.getTestData("CreateAdmission Test", xls);

	}

}
