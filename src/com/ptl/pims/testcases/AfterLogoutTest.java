
package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.util.TestUtil;

public class AfterLogoutTest extends TestBase {
	HomePage landingPage = null;

	@BeforeSuite
	public void init() {
		initConfiguration();
		APPLICATION_LOGS.debug("Configuration File initialized in Login Test");
		initDriver();
		APPLICATION_LOGS.debug("Browser initialized in Login Test");
	}

	
	
	@Test(dataProvider = "getLoginData")
	public void logoutTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Login Test", xls) || data.get("Runmode").equals("No"))
		throw new SkipException("Skipping the test");
		
		driver.get(CONFIG.getProperty("BASE_URL"));		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		landingPage = lp.doLogin(data.get("Username"),data.get("Password"));
		isLoggedIn = true;
		
		landingPage.gotoLogout();
		
		//String ActualHeader2 = landingPage.getActualPageHeader2();
		String Loginline= landingPage.getloginline();
		String emptylogin= landingPage.getemptylogin();
		//String Passwordline= landingPage.getpasswordline();
		//String emptypassword= landingPage.getemptypassword();
		//String ExpectedHeader2 = landingPage.getExpectedPageHeader2();
		
		Assert.assertTrue(Loginline.equalsIgnoreCase(emptylogin), "login not empty");
		
		isLoggedIn =false;
		
		APPLICATION_LOGS.debug("logged out");
		//landingPage.gotoProfile();
		APPLICATION_LOGS.debug("In Home page");
	
	}
		

	@DataProvider
	public Object[][] getLoginData() {
		return TestUtil.getTestData("Login Test", xls);
		
	}

}

