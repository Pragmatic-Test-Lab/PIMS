package com.ptl.pims.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.PropertyManagementInmateSelectPage;
import com.ptl.pims.pages.PropertyManagementPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class PropertyManagementNewTest extends TestBase {
	
	HomePage landingPage = null;
	PropertyManagementInmateSelectPage managePropertySelectInmate = null;
	PropertyManagementPage manageProperty = null;
	

	@Test(dataProvider = "getAllocationData")
	public void GoToAllocateLocationPage(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("Property Management Test", xls)
				|| data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");
		
		landingPage = returnToHomePage();	
		
		APPLICATION_LOGS.debug("Going to Property Management Page");		
		managePropertySelectInmate = landingPage.goToManageProperty();

		Assert.assertEquals(managePropertySelectInmate.getHeader(), Constants.PropertyManagement_ExpectedHeader, 
				"Could not reach Property Management");

		APPLICATION_LOGS.debug("Reached Property Management Page");

	}
	
	@Test(dependsOnMethods = "GoToAllocateLocationPage")
	public void clickInmateLink() {
		
		//
		// Use search if specific inmate is needed
		//

		manageProperty = managePropertySelectInmate.clickFirstInmate();	

		APPLICATION_LOGS.debug("Reached Inmates Property Management Page");

	}
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getAllocationData")      
	public void addInmateProperty(Hashtable<String, String> data) {
		
		//add Inmate Property
		manageProperty.addPrivateProperties(data.get("Private Date"), data.get("Private Item"), 
				data.get("Private Description"), data.get("Private Quantity"), data.get("Private Value"));
		
		manageProperty.addPrisonProperties(data.get("Prison Date"), data.get("Prison Item"), 
				data.get("Prison Description"), data.get("Prison Quantity"));
		
		//allocateLocationInmateSelect = allocationPage.changeLocation(data.get("New Location"));
		
		//APPLICATION_LOGS.debug("Changed Inmates Location");
	
		//gets changed Inmate
		//allocateLocationInmateSelect = allocateLocationInmateSelect.doSearch(null, null, null);	
		
		//allocationPage = allocateLocationInmateSelect.clickFirstInmate();
		
		//check location and compare
		//Assert.assertTrue(allocationPage.getCurrentLocation().equals(data.get("New Location")),
				//"Location Changing has failed");		
		
		//APPLICATION_LOGS.debug("Changed Inmate location successfully");

	} 

	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Property Management Test", xls);

	}
}
