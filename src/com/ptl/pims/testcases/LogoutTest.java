package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class LogoutTest extends TestBase {
	
	@Test
	public void logoutTest() {

		if(!TestUtil.isTestCaseRunmodeYes("Login-out Test", xls))
		throw new SkipException("Skipping the test");
		
		HomePage landingPage = returnToHomePage();
		landingPage.gotoLogout();
		
		Assert.assertEquals(landingPage.getActualPageHeader2(), Constants.Home_PageHeaderText2, "Could not logout!");
		APPLICATION_LOGS.debug("logged out");
	}


}
