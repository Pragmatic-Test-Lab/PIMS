package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AdmissionAllPairTest extends TestBase{

	TopMenu topMenu;
	
	@Test 
	public void loginToSystem(){
		
			HomePage landingPage = returnToHomePage();		
			topMenu = getTopMenu();		
	} 
	
	
	@Test (dependsOnMethods = "loginToSystem", dataProvider = "getAllPairData")
	public void createAdmissions(Hashtable<String, String> data){

			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			
		    creAdmissionPage.doFillAllRequiredFileds(data.get("Type of User"),data.get("Location"),data.get("Age"),data.get("meal"),
		    		"Test Biometric","Test Name",data.get("Classification"),data.get("Gender"));
			newAdmissionPage = creAdmissionPage.doAdmission();
			
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Failed to create inmate with data : " +
					data.get("Type of User") + ", " + data.get("Location") + ", " + data.get("Age") + ", " + data.get("meal") + ", " + 	data.get("Classification")
						 + ", " +  data.get("Gender")
					);		
			APPLICATION_LOGS.debug("Completed Test No : " + data.get("Test Number"));

	} 
	
	@DataProvider
	public Object[][] getAllPairData() {
		return TestUtil.getTestData("Admission All Pair Values", xls);
		
	}
	
}
