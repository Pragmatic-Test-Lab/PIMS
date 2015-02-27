
package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.util.TestUtil;

public class AfterLogoutTest extends TestBase {
	HomePage landingPage = null;
	
	
	@Test
	public void afterlogoutTest() {

		if(!TestUtil.isTestCaseRunmodeYes("Login-out Test", xls))
			throw new SkipException("Skipping the test");
				
		HomePage landingPage = returnToHomePage();
		landingPage.gotoLogout();
				
		//String ActualHeader2 = landingPage.getActualPageHeader2();
		String Loginline= landingPage.getloginline();
		String emptylogin= landingPage.getemptylogin();
		String Passwordline= landingPage.getpasswordline();
		String emptypassword= landingPage.getemptypassword();
		//String ExpectedHeader2 = landingPage.getExpectedPageHeader2();
		
		Assert.assertTrue(Loginline.equalsIgnoreCase(emptylogin), "login not empty");
		Assert.assertTrue(Passwordline.equalsIgnoreCase(emptypassword), "password not empty");
				
		APPLICATION_LOGS.debug("logged out");
		APPLICATION_LOGS.debug("In Home page");
	
	}

}

