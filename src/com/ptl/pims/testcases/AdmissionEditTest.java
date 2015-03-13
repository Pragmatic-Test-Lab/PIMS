package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;

public class AdmissionEditTest extends TestBase{

	@Test // PIMS-1194
	public void Test_doEditAdmission(){
		
		loginToApplication();		
		TopMenu topMenu = getTopMenu();
		EditAdmissionSelectPage editAdmissionSelectPage = topMenu.gotoEditAdmissionPage();
		
		editAdmissionSelectPage = editAdmissionSelectPage.doSearch(registrationNo,"","");
		EditAdmissionPage editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
		
		editAdmissionSelectPage = editAdmissionPage.doEditAdmition("Child","Colombo","20","Vegeterian"
				,"Biometric Content Updated","Nimal Pathirana Updated","RC","male");
		Assert.assertTrue(editAdmissionSelectPage.getSuccessMessage().matches(Constants.EditAdmission_SuccessMessageText), "Editing Admission has failed");		

	}

}
