package com.ptl.pims.testcases.RegistrationTest;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Registration.PropertyManagement.PropertyManagementInmateSelectPage;
import com.ptl.pims.pages.Registration.PropertyManagement.PropertyManagementPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class PropertyManagementNewTest extends TestBase {
	
	PropertyManagementInmateSelectPage managePropertySelectInmate;
	PropertyManagementPage manageProperty;
	

	@Test
	public void GoToAllocateLocationPage() {
		
		loginToApplication();
		managePropertySelectInmate = getTopMenu().gotoManageProperty();
		assertTrue(managePropertySelectInmate.getHeader().equals(Constants.PropertyManagement_ExpectedHeader), "Could not reach Property Management");

		managePropertySelectInmate = managePropertySelectInmate.doSearch(registrationNo,"", "");
		manageProperty = managePropertySelectInmate.clickFirstInmate();			
	}

	@Test(dependsOnMethods = "GoToAllocateLocationPage", dataProvider = "getPropertyData")    
	public void addInmateProperty(Hashtable<String, String> data) {		
		
		manageProperty.addPrivateProperties(data.get("Private Date"), data.get("Private Item"), 
				data.get("Private Description"), data.get("Private Quantity"), data.get("Private Value"));	

		manageProperty.addPrisonProperties(data.get("Prison Date"), data.get("Prison Item"), 
				data.get("Prison Description"), data.get("Prison Quantity"));
			
		managePropertySelectInmate = manageProperty.submitPropertyForm();
		
		assertTrue(managePropertySelectInmate.successMessageAvaiable(),"Success Message not found at Property Management Page.");	
	}


	@DataProvider
	public Object[][] getPropertyData() {
		return TestUtil.getTestData("Property Management Add", xls);

	}
}
