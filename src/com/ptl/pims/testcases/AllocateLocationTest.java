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
		Assert.assertTrue(allocateLocationInmateSelect.getHeader().equalsIgnoreCase(Constants.AllocateLocation_ExpectedHeader),"Could not reach Allocate Location");
		//Assert.assertEquals(allocateLocationInmateSelect.getHeader(), Constants.AllocateLocation_ExpectedHeader ,
			//	"Could not reach Allocate Location");

		APPLICATION_LOGS.debug("Reached Allocate Location Page");
	}

	@Test(dependsOnMethods = "GoToAllocateLocationPage")
	public void clickInmateLink() {
		
		//
		// Use search if specific inmate is needed
		//

		allocationPage = allocateLocationInmateSelect.clickFirstInmate();
		
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
		//allocateLocationInmateSelect.doSearch(FInmate_RegNum, null, FInmate_Name, null, null);	
		
		//check location and compare
		Assert.assertTrue(!FInmate_Location.equals(data.get("New Location")), "Inmate already in " + FInmate_Location + ",Cannot change location");		
		
	}


	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Allocate Location Test", xls);

	}
}
