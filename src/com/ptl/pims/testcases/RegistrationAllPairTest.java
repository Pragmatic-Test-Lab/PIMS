package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.InmateRegistration;
import com.ptl.pims.pages.InmateRegistrationSelectPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class RegistrationAllPairTest extends TestBase{

	TopMenu topMenu;
	
	@Test 
	public void loginToSystem(){
		
			HomePage landingPage = returnToHomePage();		
			topMenu = getTopMenu();		
	} 
	
	
	@Test (dependsOnMethods = "loginToSystem", dataProvider = "getAllPairData")
	public void fillIdentificationDetailsTab(Hashtable<String, String> data){
		

			InmateRegistrationSelectPage inmateRegistrationSelect  = topMenu.goToInmateRegistration();
		
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
