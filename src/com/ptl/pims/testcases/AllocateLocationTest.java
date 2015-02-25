package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.AllocateLocationInmateSelectPage;
import com.ptl.pims.pages.AllocateLocationPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AllocateLocationTest extends TestBase {

	
	AllocateLocationInmateSelectPage allocateLocationInmateSelect = null;
	AllocateLocationPage allocationPage;
	HomePage landingPage;
	
	String FInmate_RegNum;
	String FInmate_Name;
	String FInmate_Location;


	@Test(dataProvider = "getAllocationData")
	public void GoToAllocateLocationPage(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("Allocate Location Test", xls)
				|| data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();

		APPLICATION_LOGS.debug("Going to Allocate Location Page");
		
		allocateLocationInmateSelect = landingPage.goToAllocateLocation();
		
		Assert.assertEquals(allocateLocationInmateSelect.getHeader(), Constants.AllocateLocation_ExpectedHeader ,
			"Could not reach Allocate Location");

		APPLICATION_LOGS.debug("Reached Allocate Location Page");
	}
	

	@Test(dependsOnMethods = "GoToAllocateLocationPage", dataProvider = "getAllocationData")	//pims-921
	public void clickInmateLink(Hashtable<String, String> data) {
		
		//
		// Search if specific inmate is needed
		// allocateLocationInmateSelect = allocateLocationInmateSelect.doSearch(data.get("RegNo"),data.get("Biometric") ,data.get("Name"));
		//

		allocationPage = allocateLocationInmateSelect.clickFirstInmate();
		
		APPLICATION_LOGS.debug("Reached Inmates Allocate Location Page");

	}
	
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getAllocationData")      //pims-993, pims-994
	public void changeInmateLocation(Hashtable<String, String> data) {
		
		Assert.assertTrue(!allocationPage.getCurrentLocation().equals(data.get("New Location")),
				"Inmate already in " + allocationPage.getCurrentLocation() + ",Cannot change location");
		
		//change Inmate Location
		allocateLocationInmateSelect = allocationPage.changeLocation(data.get("New Location"));
		
		APPLICATION_LOGS.debug("Changed Inmates Location");
	
		//gets changed Inmate
		//allocateLocationInmateSelect = allocateLocationInmateSelect.doSearch(null, null, null);	
		
		allocationPage = allocateLocationInmateSelect.clickFirstInmate();
		
		//check location and compare
		Assert.assertTrue(allocationPage.getCurrentLocation().equals(data.get("New Location")),
				"Location Changing has failed");		
		
		APPLICATION_LOGS.debug("Changed Inmate location successfully");

	}


	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Allocate Location Test", xls);

	}
}
