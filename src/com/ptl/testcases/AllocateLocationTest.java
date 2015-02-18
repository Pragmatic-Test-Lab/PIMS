package com.ptl.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;

import org.apache.log4j.Level;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pages.AllocateLocationPage;
import com.ptl.pages.HomePage;
import com.ptl.pages.LoginPage;
import com.ptl.pages.TopMenu;
import com.ptl.util.TestUtil;

public class AllocateLocationTest extends TestBase {

	
	AllocateLocationPage allocateLocation = null;
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

		System.out.println("************************************************");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		landingPage = returnToHomePage();

		APPLICATION_LOGS.debug("Going to Allocate Location Page");
		allocateLocation = landingPage.goToAllocateLocation();

		String ActualHeader = allocateLocation.getHeader();
		String ExpectedHeader = allocateLocation.getExpectedHeader();

		Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader),
				"Could not reach Allocate Location");

		APPLICATION_LOGS.debug("Reached Allocate Location Page");
	}

	@Test(dependsOnMethods = "GoToAllocateLocationPage")
	public void clickInmateLink() {
		
		//
		// Use search if specific inmate is needed
		//

		// Saves First Inmates Registration Number, Name and Location
		FInmate_RegNum = allocateLocation.getFInmateRegNo();
		FInmate_Name = allocateLocation.getFInmateName();
		FInmate_Location = allocateLocation.getFInmateLocation();

		System.out.println("First Inmate : " + FInmate_RegNum + " -- " + FInmate_Name + " -- " + FInmate_Location);
		allocateLocation.clickFirstInmate();	
		
		//checks Inmate details
		boolean inmateDetailsValid = allocateLocation.validateAllocateLocationPageData(FInmate_RegNum, FInmate_Name, FInmate_Location);
		
		Assert.assertTrue(inmateDetailsValid, "Inmate details in page are not Matching");
		APPLICATION_LOGS.debug("Reached Inmates Allocate Location Page");

	}
	
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getAllocationData")
	public void changeInmateLocation(Hashtable<String, String> data) {
		
		Assert.assertTrue(!FInmate_Location.equals(data.get("New Location")), "Inmate already in " + FInmate_Location + ",Cannot change location");
		//change Inmate Location
		allocateLocation.changeLocation(data.get("New Location"));
		
		APPLICATION_LOGS.debug("Changed Inmates Location");

		
		//check if Inmate Location has changed		
		//gets changed Inmate
		allocateLocation.doSearch(FInmate_RegNum, null, FInmate_Name, null, null);		
		//check location and compare
		Assert.assertTrue(!FInmate_Location.equals(data.get("New Location")), "Inmate already in " + FInmate_Location + ",Cannot change location");		
		
	}


	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Allocate Location Test", xls);

	}
}
