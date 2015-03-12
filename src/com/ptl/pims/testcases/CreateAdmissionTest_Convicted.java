package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;

public class CreateAdmissionTest_Convicted extends TestBase {

	
	@Test 
	public void Test_doCreateNewAdmitionFor_Convicted_Inmate_With_Required_Fields(){
		try{
			HomePage landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doFillAllRequiredFileds("Convicted","Negombo","25","Diet","Test Biometric","Nimal Pathirana","FO","male");
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create convicted type inmate");		
			APPLICATION_LOGS.debug("Convicted type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	} 
}
