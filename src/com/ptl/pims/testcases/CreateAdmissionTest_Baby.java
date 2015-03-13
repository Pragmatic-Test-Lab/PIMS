package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;

public class CreateAdmissionTest_Baby extends TestBase {

	
	@Test 
	public void Test_doCreateNewAdmitionFor_Baby_Inmate_With_Required_Fields(){
		try{
			loginToApplication();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doFillAllRequiredFileds("Baby","Negombo","7","Diet","Test Biometric","Nimal Pathirana","FO","male");
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create baby type inmate");		
			APPLICATION_LOGS.debug("Baby type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	}
}
