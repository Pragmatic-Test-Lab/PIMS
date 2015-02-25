package com.ptl.pims.testcases;

import org.testng.annotations.Test;

import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.TopMenu;

public class AdmissionEditTest extends TestBase{

	HomePage landingPage = null;

	@Test // PIMS-1194
	public void Test_doCreateNewAdmitionFor_ConvictedInmate() throws InterruptedException{
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		EditAdmissionSelectPage editAdmissionSelectPage = topMenu.gotoEditAdmissionPage();
		editAdmissionSelectPage = editAdmissionSelectPage.doSearch("","","");
		EditAdmissionPage editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
		editAdmissionPage.doEditAdmition();
	}

}
