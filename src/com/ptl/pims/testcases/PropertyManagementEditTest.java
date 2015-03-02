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

	PropertyManagementInmateSelectPage managePropertySelectInmate;
	PropertyManagementPage manageProperty;
	

	@Test(dataProvider = "getPropertyData")
	public void GoToAllocateLocationPage(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("Property Management Test", xls)	|| data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");
		
		HomePage landingPage = returnToHomePage();
		TopMenu topMenu = getTopMenu();
		
		APPLICATION_LOGS.debug("Going to Property Management Page");	
		managePropertySelectInmate = topMenu.gotoManageProperty();
		Assert.assertEquals(managePropertySelectInmate.getHeader(), Constants.PropertyManagement_ExpectedHeader, "Could not reach Property Management");
		
	}
	
	@Test(dependsOnMethods = "GoToAllocateLocationPage", dataProvider = "getPropertyData")
	public void clickInmateLink(Hashtable<String, String> data) {
		
		managePropertySelectInmate = managePropertySelectInmate.doSearch(registrationNo,"" ,"");

		manageProperty = managePropertySelectInmate.clickFirstInmate();
		APPLICATION_LOGS.debug("Reached Inmates Property Management Page");

	}
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getPropertyData") 	//pims- 285, pims-1012  
	public void editInmateProperty(Hashtable<String, String> data) {
		
		APPLICATION_LOGS.debug("Editing inmate property details.");

		Assert.assertTrue(manageProperty.IsEditIndexWithinNoOfRows("PRIVATE", Integer.parseInt(data.get("Private Property Position"))), "given Private Property index exceeds Properties Found.");
		manageProperty.editPrivateProperties(data.get("Private Property Position"), data.get("Private Date"), data.get("Private Item"), 
				data.get("Private Description"), data.get("Private Quantity"), data.get("Private Value"));
	
		Assert.assertTrue(manageProperty.IsEditIndexWithinNoOfRows("PRISON", Integer.parseInt(data.get("Prison Property Position"))), "given Private Property index exceeds Properties Found.");
		manageProperty.editPrisonProperties(data.get("Prison Property Position"), data.get("Prison Date"), data.get("Prison Item"), 
				data.get("Prison Description"), data.get("Prison Quantity"));

		
		APPLICATION_LOGS.debug("Saving Edited Property Details.");		
		managePropertySelectInmate = manageProperty.submitPropertyForm();
				
		Assert.assertTrue(managePropertySelectInmate.getSuccessMessage().matches(Constants.PropertyManagement_SuccessMessageText),
				"Success Message not displayed.");		

	}

	
	@DataProvider
	public Object[][] getPropertyData() {
		return TestUtil.getTestData("Property Management Edit", xls);

	}
}
