package com.ptl.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pages.HomePage;
import com.ptl.pages.InmateRegistration;
import com.ptl.pages.NewAdmissionPage;
import com.ptl.util.TestUtil;

public class NewAdmissionTest extends TestBase{

	HomePage landingPage = null;

	@BeforeSuite
	public void init() {
		initConfiguration();
		APPLICATION_LOGS.debug("Configuration File initialized in Login Test");
		initDriver();
		APPLICATION_LOGS.debug("Browser initialized in Login Test");
	}


	@Test
	public void enterInmateCalasificationTest() {
		NewAdmissionPage newAdmissionPage = new NewAdmissionPage(driver);
		newAdmissionPage.doCreateNewAdmition();
	}


/*	@AfterSuite
	public void quite(){
		driver.quit();
	}*/
	
}
