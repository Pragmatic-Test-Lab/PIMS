package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;

public class CreateAdmissionTest_UnConvicted extends TestBase {

	
	@Test 
	public void Test_doCreateNewAdmitionFor_Un_Convicted_Inmate_With_Required_Fields(){
		try{
			loginToApplication();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doFillAllRequiredFileds("Un-Convicted","Negombo","25","Diet","Test Biometric","Nimal Pathirana","FO","male");
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create Un-convicted type inmate");		
			APPLICATION_LOGS.debug("Un-Convicted type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	} 
}
