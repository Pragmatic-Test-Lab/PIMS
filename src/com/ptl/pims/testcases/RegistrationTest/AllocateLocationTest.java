package com.ptl.pims.testcases.RegistrationTest;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Registration.AllocateLocation.AllocateLocationInmateSelectPage;
import com.ptl.pims.pages.Registration.AllocateLocation.AllocateLocationPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;

public class AllocateLocationTest extends TestBase {

	
	AllocateLocationInmateSelectPage allocateLocationInmateSelect = null;
	AllocateLocationPage allocationPage;

	@Test
	public void GoToAllocateLocationPage() {

		loginToApplication();
		allocateLocationInmateSelect = getTopMenu().goToAllocateLocation();
		
		allocateLocationInmateSelect = allocateLocationInmateSelect.doSearch(registrationNo,"","");
		allocationPage = allocateLocationInmateSelect.clickFirstInmate();		
	}	
	
	@Test(dependsOnMethods = "GoToAllocateLocationPage", dataProvider = "getAllocationData")      //pims-993, pims-994
	public void changeInmateLocation(Hashtable<String, String> data) {
		
		allocateLocationInmateSelect = allocationPage.changeLocation(data.get("New Location"));
		assertTrue(allocateLocationInmateSelect.successMessageAvaiable(), "Allocate Location success message not found");		
	}

	@DataProvider
	public Object[][] getAllocationData() {
		return TestUtil.getTestData("Allocate Location Test", xls);

	}
}
