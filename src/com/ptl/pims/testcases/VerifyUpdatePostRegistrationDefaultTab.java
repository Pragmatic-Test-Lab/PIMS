package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.UpdatePostRegistrationPage;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class VerifyUpdatePostRegistrationDefaultTab extends TestBase {
	HomePage landingPage = null;
	
	
	@Test(dataProvider = "getVerificationData")
	public void TestUpdatePostRegistrationDefaultTab(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("UpdatePostReg Test", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();
		APPLICATION_LOGS.debug("Going to Home Page");
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Top Menu");
		PostRegistrationPage postRegPage = topMenu.gotoPostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Post Registration Page");
		UpdatePostRegistrationPage updatePostRegPage = postRegPage.gotoUpdatePostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Update Post Registration Page");		
			
		Assert.assertEquals(updatePostRegPage.getActualEducationalQualificationTabDefaultStatus(), 
				Constants.UpdatePostRegistration_EducationalQualificationTabStatus, "Default Tab is not the Educational Qualification");
		

		APPLICATION_LOGS.debug("Educational Qualification tab is the default tab");
	}
	
	
	@DataProvider
	public Object[][] getVerificationData() {
		return TestUtil.getTestData("UpdatePostReg Test", xls);

	}



}
