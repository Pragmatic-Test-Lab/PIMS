package com.ptl.pims.testcases.AllPairTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.Registration.InmateRegistration;
import com.ptl.pims.pages.Registration.InmateRegistrationSelectPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class RegistrationAllPairTest extends TestBase{
	
	InmateRegistrationSelectPage inmateRegistrationSelect;
	
	@Test
	public void loginToSystem(){
		
			loginToApplication();		
			TopMenu topMenu = getTopMenu();	
			inmateRegistrationSelect  = topMenu.goToInmateRegistration();
	} 
	
	
	@Test (dataProvider = "getAllPairData", dependsOnMethods="loginToSystem")
	public void createRegistrations(Hashtable<String, String> data){
		
		inmateRegistrationSelect = inmateRegistrationSelect.doSearch(registrationNo,"" ,"");
		InmateRegistration inmateRegistration = inmateRegistrationSelect.clickFirstInmate(); 
		
		APPLICATION_LOGS.debug("Adding Identification Data");
		inmateRegistration.doAddIdentificationDetailsOfInmate(data.get("Face"),null,data.get("Hair"),null,
				data.get("Eyes"),null, data.get("Nose"), data.get("Health"), null);
		
		inmateRegistrationSelect = inmateRegistration.clickButton();
		
		Assert.assertTrue(inmateRegistrationSelect.getSuccessMessage().matches(Constants.InmateRegistration_SuccessMessageText), "Failed to create inmate with data : " +
				data.get("Face") + ", " + data.get("Hair") + ", " + data.get("Eyes") + ", " + data.get("Nose") + ", " + data.get("Health")
				);
		
		APPLICATION_LOGS.debug("Completed Test No : " + data.get("Test Number"));		
	} 
	
	
	
	@DataProvider
	public Object[][] getAllPairData() {
		return TestUtil.getTestData("Identification All Pair Values", xls);
		
	}
}
