package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;

public class AdmissionEditTest extends TestBase{

	HomePage landingPage = null;

	@Test // PIMS-1194
	public void Test_doCreateNewAdmitionFor_ConvictedInmate() throws InterruptedException{
		
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		EditAdmissionSelectPage editAdmissionSelectPage = topMenu.gotoEditAdmissionPage();
		editAdmissionSelectPage = editAdmissionSelectPage.doSearch(registrationNo,"","");
		EditAdmissionPage editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
		
		editAdmissionSelectPage = editAdmissionPage.doEditAdmition();
		Assert.assertTrue(editAdmissionSelectPage.getSuccessMessage().matches(Constants.EditAdmission_SuccessMessageText), "Editing Admission has failed");		

	}

}
