package com.ptl.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ptl.pages.HomePage;
import com.ptl.pages.InmateRegistration;
import com.ptl.pages.LoginPage;
import com.ptl.util.TestUtil;

public class InmateRegistrationTest extends TestBase {

	HomePage landingPage = null;
	
	@BeforeSuite
	public void init() {
		initConfiguration();
		APPLICATION_LOGS.debug("Configuration File initialized in Inmate Personal Registration");
		initDriver();
		APPLICATION_LOGS.debug("Browser initialized in Inmate Registration Test");
	}

	@Test(dataProvider = "getInmatePersonalData")
	public void loginTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Registration-Personal", xls) || data.get("Runmode").equals("No"))
		throw new SkipException("Skipping the test");
		
		System.out.println("************************************************");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		if (!isLoggedIn) {
		APPLICATION_LOGS.debug("Attempting login to system");
		driver.get(CONFIG.getProperty("BASE_URL"));
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		landingPage = lp.doLogin(data.get("Username"), data.get("Password"));
		
		String ActualHeader = landingPage.getActualPageHeader();
		String ExpectedHeader = landingPage.getExpectedPageHeader();
		
		Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader),
		"Could not login!");
		APPLICATION_LOGS.debug("Successfully logged in");
		isLoggedIn = true;
		} else {
		//to implement topmenu code
		}
		
		APPLICATION_LOGS.debug("Going to Inmate Registration Page");
		InmateRegistration inmateRegistration  = landingPage.goToInmateRegistration();
		
		String ActualHeader = allocateLocation.getHeader();
		String ExpectedHeader = allocateLocation.getExpectedHeader();
		
		Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader), "Could not reach Allocate Location");
		
		APPLICATION_LOGS.debug("Reached Allocate Location Page");
	
	}
}

