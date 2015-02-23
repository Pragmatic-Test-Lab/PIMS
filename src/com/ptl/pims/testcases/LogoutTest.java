package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class LogoutTest extends TestBase {
	HomePage landingPage = null;


	
	
	@Test(dataProvider = "getLoginData")
	public void logoutTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Login Test", xls) || data.get("Runmode").equals("No"))
		throw new SkipException("Skipping the test");
		
		driver.get(CONFIG.getProperty("BASE_URL"));		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		landingPage = lp.doLogin(data.get("Username"),data.get("Password"));
		isLoggedIn=true;
		landingPage.gotoLogout();
		
		Assert.assertEquals(landingPage.getActualPageHeader2(), Constants.Home_PageHeaderText2, "Could not logout!");
		
		isLoggedIn=false;
		APPLICATION_LOGS.debug("logged out");
		//landingPage.gotoProfile();
		APPLICATION_LOGS.debug("In Home page");
	
	}
		

	@DataProvider
	public Object[][] getLoginData() {
		return TestUtil.getTestData("Login Test", xls);
		
	}

}
