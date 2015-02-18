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
import com.ptl.pages.PropertyManagement;
import com.ptl.pages.TopMenu;
import com.ptl.util.Constants;
import com.ptl.util.TestUtil;

public class PropertyManagementNewTest extends TestBase {
	
	HomePage landingPage = null;
	PropertyManagement manageProperty = null;
	
	@BeforeSuite
	public void init() {
		initConfiguration();
		APPLICATION_LOGS.debug("Configuration File initialized in Login Test");
		initDriver();
		APPLICATION_LOGS.debug("Browser initialized in Login Test");
	}

	@Test(dataProvider = "getAllocationData")
	public void GoToAllocateLocationPage(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("Property Management Test", xls)
				|| data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");
		
		landingPage = returnToHomePage();		
		APPLICATION_LOGS.debug("Going to Property Management Page");		
		manageProperty = landingPage.goToManageProperty();

		Assert.assertEquals(manageProperty.getHeader(), Constants.PropertyManagement_ExpectedHeader, 
				"Could not reach Property Management");

		APPLICATION_LOGS.debug("Reached Property Management Page");

	}
	
	@Test(dependsOnMethods = "GoToAllocateLocationPage")
	public void clickInmateLink() {
		
		//
		// Use search if specific inmate is needed
		//

		// Saves First Inmates Registration Number, Name and Location
//		FInmate_RegNum = manageProperty.getFInmateRegNo();
//		FInmate_Name = manageProperty.getFInmateName();
//		FInmate_Location = manageProperty.getFInmateLocation();

		manageProperty.clickFirstInmate();	
		
		//checks Inmate details
		//boolean inmateDetailsValid = manageProperty.validatemanagePropertyPageData(FInmate_RegNum, FInmate_Name, FInmate_Location);
		
		//Assert.assertTrue(inmateDetailsValid, "Inmate details in page are not Matching");
		APPLICATION_LOGS.debug("Reached Inmates Allocate Location Page");

	}
	


	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Allocate Location Test", xls);

	}
}
