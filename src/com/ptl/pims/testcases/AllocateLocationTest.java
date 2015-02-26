package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.AllocateLocationInmateSelectPage;
import com.ptl.pims.pages.AllocateLocationPage;
import com.ptl.pims.pages.CreateNewAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AllocateLocationTest extends TestBase {

	
	AllocateLocationInmateSelectPage allocateLocationInmateSelect = null;
	AllocateLocationPage allocationPage;

	@Test(dataProvider = "getAllocationData")
	public void GoToAllocateLocationPage(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("Allocate Location Test", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		HomePage landingPage = returnToHomePage();
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Allocate Location Page");		
		allocateLocationInmateSelect = topMenu.goToAllocateLocation();
		
		Assert.assertEquals(allocateLocationInmateSelect.getHeader(), Constants.AllocateLocation_ExpectedHeader, "Could not reach Allocate Location");
	}
	

	@Test(dependsOnMethods = "GoToAllocateLocationPage")	//pims-921
	public void clickInmateLink() {
		
		allocateLocationInmateSelect = allocateLocationInmateSelect.doSearch(registrationNo,"","");

		allocationPage = allocateLocationInmateSelect.clickFirstInmate();		
		APPLICATION_LOGS.debug("Reached Inmates Allocate Location Page");
		//Assert.assertTrue(allocationPage.validateInmateData(registrationNo, ""), "Inmate data is invalid");

	}
	
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getAllocationData")      //pims-993, pims-994
	public void changeInmateLocation(Hashtable<String, String> data) {
		
		Assert.assertTrue(!allocationPage.getCurrentLocation().equals(data.get("New Location")),"Cannot proceed. Inmate already in " + allocationPage.getCurrentLocation());
		
		//Change Inmate Location
		allocateLocationInmateSelect = allocationPage.changeLocation(data.get("New Location"));

		Assert.assertTrue(allocateLocationInmateSelect.getSuccessMessage().matches(Constants.AllocateLocation_SuccessMessageText),	"Location Changing has failed");		
		APPLICATION_LOGS.debug("Changed Inmate location successfully");
	}


	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Allocate Location Test", xls);

	}
}
