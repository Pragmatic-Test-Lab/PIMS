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

public class WrongPasswordTest extends TestBase {
	HomePage landingPage = null;

	@BeforeSuite
	public void init() {
		initConfiguration();
		APPLICATION_LOGS.debug("Configuration File initialized in Login Test");
		initDriver();
		APPLICATION_LOGS.debug("Browser initialized in Login Test");
	}

	
	
	@Test(dataProvider = "getLoginData")
	public void wrongpassword(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Login Test", xls) || data.get("Runmode").equals("No"))
		throw new SkipException("Skipping the test");
		
		System.out.println("************************************************");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(CONFIG.getProperty("BASE_URL"));		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		landingPage = lp.doLogin(data.get("Username"),data.get("Password"));
		
		
		String ErrorMessage = landingPage.getErrorMessage();
		System.out.println(ErrorMessage);
		String ExpectedErrorMessage= landingPage.getExpectedErrorMessage();
		System.out.println(ExpectedErrorMessage);
		Assert.assertTrue(ErrorMessage.equalsIgnoreCase(ExpectedErrorMessage), "Could not login!");
		
		isPasswordcorrect=true;
		APPLICATION_LOGS.debug("Password error");
		//landingPage.gotoProfile();
		APPLICATION_LOGS.debug("In Home page");
	
	}
		

	@DataProvider
	public Object[][] getLoginData() {
		return TestUtil.getTestData("Login Test", xls);
		
	}
}