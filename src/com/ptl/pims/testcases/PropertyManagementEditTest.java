package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.PropertyManagementInmateSelectPage;
import com.ptl.pims.pages.PropertyManagementPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class PropertyManagementEditTest extends TestBase {

	PropertyManagementInmateSelectPage managePropertySelectInmate = null;
	PropertyManagementPage manageProperty = null;
	

	@Test(dataProvider = "getPropertyData")
	public void GoToAllocateLocationPage(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("Property Management Test", xls)|| data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");
		
		HomePage landingPage = returnToHomePage();
		APPLICATION_LOGS.debug("Going to Home Page");
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Top Menu");				
		managePropertySelectInmate = topMenu.gotoManageProperty();
		APPLICATION_LOGS.debug("Going to Property Management Page");

		Assert.assertEquals(managePropertySelectInmate.getHeader(), Constants.PropertyManagement_ExpectedHeader,"Could not reach Property Management");
		APPLICATION_LOGS.debug("Reached Property Management Page");
	}
	
	
	@Test(dependsOnMethods = "GoToAllocateLocationPage", dataProvider = "getPropertyData")
	public void clickInmateLink(Hashtable<String, String> data) {

		// Search if specific inmate is needed
		// allocateLocationInmateSelect = allocateLocationInmateSelect.doSearch(data.get("RegNo"),data.get("Biometric") ,data.get("Name"));

		manageProperty = managePropertySelectInmate.clickFirstInmate();
		APPLICATION_LOGS.debug("Reached Inmates Property Management Page");

	}
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getPropertyData") 	//pims- 285  
	public void editInmateProperty(Hashtable<String, String> data) {
		
		APPLICATION_LOGS.debug("Editing inmate property details.");
		
		//edit Inmate Property
		boolean privateEditSuccessfull = manageProperty.editPrivateProperties(data.get("Private Property Position"), data.get("Private Date"), data.get("Private Item"), 
				data.get("Private Description"), data.get("Private Quantity"), data.get("Private Value"));
	
		Assert.assertTrue(privateEditSuccessfull, "given Private Property index exceeds found private property amount");

		boolean prisonEditSuccessfull = manageProperty.editPrisonProperties(data.get("Prison Property Position"), data.get("Prison Date"), data.get("Prison Item"), 
				data.get("Prison Description"), data.get("Prison Quantity"));
		
		Assert.assertTrue(prisonEditSuccessfull, "given Prison Property index exceeds found prison property amount");		
		APPLICATION_LOGS.debug("Saving edited Property Details.");
		
		managePropertySelectInmate = manageProperty.submitPropertyForm();
		
		//checks if message contains words 'Saved' & 'successfully'
		Assert.assertTrue(managePropertySelectInmate.getSuccessMessage().contains(Constants.PropertyManagement_ExpectedSuccessMessagePart1) && 
				managePropertySelectInmate.getSuccessMessage().contains(Constants.PropertyManagement_ExpectedSuccessMessagePart2),
				"Success Message not displayed correctly.");
		
		APPLICATION_LOGS.debug("Success Message received.");

	}

	
	@DataProvider
	public Object[][] getPropertyData() {
		return TestUtil.getTestData("Property Management Edit", xls);

	}
}
