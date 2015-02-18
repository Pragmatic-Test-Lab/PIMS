package com.ptl.testcases;

import org.testng.annotations.BeforeSuite;

import com.ptl.pages.HomePage;

public class PostRegistration extends TestBase{
	HomePage landingPage = null;
	
	@BeforeSuite
	public void init() {
		initConfiguration();
		APPLICATION_LOGS.debug("Configuration File initialized in Inmate Personal Registration");
		initDriver();
		APPLICATION_LOGS.debug("Browser initialized in Inmate Registration Test");
	}

}
