package com.ptl.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pages.HomePage;
import com.ptl.pages.LoginPage;
import com.ptl.util.TestUtil;


public class LoginTest extends TestBase {
	HomePage landingPage = null;

	
	
	
	@Test(dataProvider = "getLoginData")
	public void loginTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Login Test", xls) || data.get("Runmode").equals("No"))
		throw new SkipException("Skipping the test");
		
		System.out.println("************************************************");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(CONFIG.getProperty("BASE_URL"));		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		landingPage = lp.doLogin(data.get("Username"),data.get("Password"));
		
		String ActualHeader = landingPage.getActualPageHeader();
		String ExpectedHeader = landingPage.getExpectedPageHeader();
		
		Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader), "Could not login!");
		
		isLoggedIn=true;
		APPLICATION_LOGS.debug("logged in");
		//landingPage.gotoProfile();
		APPLICATION_LOGS.debug("In Home page");
	
	}
		

	@DataProvider
	public Object[][] getLoginData() {
		return TestUtil.getTestData("Login Test", xls);
		
	}

}
