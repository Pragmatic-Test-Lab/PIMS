package com.ptl.pims.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;

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
