package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.AllocateLocationInmateSelectPage;
import com.ptl.pims.pages.AllocateLocationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AllocateLocationTest extends TestBase {

	
	AllocateLocationInmateSelectPage allocateLocationInmateSelect = null;
	AllocateLocationPage allocationPage;

	@Test
	public void GoToAllocateLocationPage() {

		if (!TestUtil.isTestCaseRunmodeYes("Allocate Location Test", xls))
			throw new SkipException("Skipping the test");

		loginToApplication();
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Allocate Location Page");		
		allocateLocationInmateSelect = topMenu.goToAllocateLocation();
		
		allocateLocationInmateSelect = allocateLocationInmateSelect.doSearch(registrationNo,"","");
		allocationPage = allocateLocationInmateSelect.clickFirstInmate();		

		Assert.assertTrue(allocationPage.validateInmateData(registrationNo, null), "Inmate data is invalid");
	}	
	
	@Test(dependsOnMethods = "GoToAllocateLocationPage", dataProvider = "getAllocationData")      //pims-993, pims-994
	public void changeInmateLocation(Hashtable<String, String> data) {
		
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
