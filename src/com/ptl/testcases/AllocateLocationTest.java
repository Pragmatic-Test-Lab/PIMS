package com.ptl.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pages.AllocateLocationInmateSelectPage;
import com.ptl.pages.AllocateLocationPage;
import com.ptl.pages.HomePage;
import com.ptl.pages.LoginPage;
import com.ptl.pages.TopMenu;
import com.ptl.util.Constants;
import com.ptl.util.TestUtil;

public class AllocateLocationTest extends TestBase {

	
	AllocateLocationInmateSelectPage allocateLocationInmateSelect = null;
	AllocateLocationPage allocationPage;
	HomePage landingPage;
	
	String FInmate_RegNum;
	String FInmate_Name;
	String FInmate_Location;

	@BeforeSuite
	public void init() {
		initConfiguration();
		APPLICATION_LOGS.debug("Configuration File initialized in Login Test");
		initDriver();
		APPLICATION_LOGS.debug("Browser initialized in Login Test");
	}

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

	@Test(dependsOnMethods = "GoToAllocateLocationPage")
	public void clickInmateLink() {
		
		//
		// Use search if specific inmate is needed
		//
		//

		// Saves First Inmates Registration Number, Name and Location
		FInmate_RegNum = allocateLocationInmateSelect.getFInmateRegNo();
		FInmate_Name = allocateLocationInmateSelect.getFInmateName();
		FInmate_Location = allocateLocationInmateSelect.getFInmateLocation();

		System.out.println("First Inmate : " + FInmate_RegNum + " -- " + FInmate_Name + " -- " + FInmate_Location);
		allocationPage = allocateLocationInmateSelect.clickFirstInmate();	
		
		//checks Inmate details
		boolean inmateDetailsValid = allocationPage.validateAllocateLocationPageData(FInmate_RegNum, FInmate_Name, FInmate_Location);
		
		Assert.assertTrue(inmateDetailsValid, "Inmate details in page are not Matching");
		APPLICATION_LOGS.debug("Reached Inmates Allocate Location Page");

	}
	
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getAllocationData")
	public void changeInmateLocation(Hashtable<String, String> data) {
		
		Assert.assertTrue(!FInmate_Location.equals(data.get("New Location")), "Inmate already in " + FInmate_Location + ",Cannot change location");
		//change Inmate Location
		allocationPage.changeLocation(data.get("New Location"));
		
		APPLICATION_LOGS.debug("Changed Inmates Location");
		
		//check if Inmate Location has changed		
		//gets changed Inmate
		allocateLocationInmateSelect.doSearch(FInmate_RegNum, null, FInmate_Name, null, null);		
		//check location and compare
		Assert.assertTrue(!FInmate_Location.equals(data.get("New Location")), "Inmate already in " + FInmate_Location + ",Cannot change location");		
		
	}


	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Allocate Location Test", xls);

	}
}
