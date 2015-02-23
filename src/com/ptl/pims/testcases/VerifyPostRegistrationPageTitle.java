package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.TestUtil;

public class VerifyPostRegistrationPageTitle extends TestBase{
	HomePage landingPage = null;
	
	
	@Test(dataProvider = "getVerificationData")
	public void GoToAllocateLocationPage(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("PostReg Test", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();
		APPLICATION_LOGS.debug("Going to Home Page");
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Top Menu");
		PostRegistrationPage postRegPage = topMenu.gotoPostRegistrationPage();			
		Assert.assertEquals(postRegPage.getActualPageTitle(), postRegPage.getExpectedPageTitle(), "Page Title is not correct");
		

		APPLICATION_LOGS.debug("Reached Post Registration Page");
	}
	
	
	@DataProvider
	public Object[][] getVerificationData() {
		return TestUtil.getTestData("PostReg Test", xls);

	}

}
