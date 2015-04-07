package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;


public class LoginLogoutTest extends TestBase {

	LoginPage lp;
	
	@Test(dataProvider = "getLoginData")
	public void loginTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Login Test", xls) || data.get("Runmode").equals("No"))
		throw new SkipException("Skipping the test");
		
		driver.get(CONFIG.getProperty("BASE_URL"));		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		HomePage landingPage = lp.doLogin(data.get("Username"),data.get("Password"));
		
		Assert.assertEquals(landingPage.getActualPageHeader(), Constants.Home_PageHeaderText, "Could not login!");
		
		isLoggedIn=true;
		APPLICATION_LOGS.debug("logged in. In Home page");

	
	}
	
	@Test(dependsOnMethods="loginTest")
	public void logoutTest() {		

		lp = topMenu.doLogout();
		
		Assert.assertEquals(lp.getTitle(), Constants.Login_ExpectedTitle, "Could not logout!");
		APPLICATION_LOGS.debug("logged out");
		
		Assert.assertTrue(lp.getUsernameFieldValue().equals(""), "login field not empty");
		Assert.assertTrue(lp.getPasswordFieldValue().equals(""), "password field not empty");
	}

		

	@DataProvider
	public Object[][] getLoginData() {
		return TestUtil.getTestData("Login Test", xls);
		
	}

}
