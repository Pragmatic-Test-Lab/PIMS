package com.ptl.pims.testcases;

import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;


public class NewAdmissionTest extends TestBase{

	HomePage landingPage = null;
/*
	//@Test // PIMS-656
	public void Test_doCreateNewAdmitionFor_ConvictedInmate(){
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.doCreateNewAdmitionFor_ConvictedInmate();
	}*/
	
	@Test   // PIMS-628
	public void Test_doCreateNewAdmitionFor_Non_ConvictedInmate() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		
		registrationNo = newAdmissionPage.getRegistrationNumber();
		
		newAdmissionPage.doCreateNewAdmitionFor_Un_ConvictedInmate();
	}
	
	/*
	//@Test   // PIMS-898
	public void Test_checkMealTypeIsSelectable() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.checkMealTypeIsSelectable();;
	}
	
	//@Test   // PIMS-1190
	public void Test_checkAgeCatagoryIsAutoSelected() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.checkAgeCatagoryIsAutoSelected();
	}
	
	//@Test   // PIMS-19
	public void Test_checkRegistrationNumberFormtForUnConvictedInamtes() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.checkRegistrationNumberFormtForUnConvictedInamtes();
	}
	
	//@Test // PIMS-408
	public void Test_checkInmateRegistrationNumberIsAutoGenarated(){
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.checkInmateRegistrationNumberIsAutoGenarated();
	}
	
	//@Test // PIMS-869
	public void Test_checkImateCatagoryIsSelectable(){
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.checkImateCatagoryIsSelectable();
	}
	
	//@Test // PIMS-1198
	public void Test_checkUserCanUploadTheAllThreeImages() throws Exception{
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.checkUserCanUploadTheAllThreeImages();
	}
	
	
	
	@Test
	public void createNewAdmissionTest() throws InterruptedException {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.doCreateNewAdmition();
	}
	

	

	//@Test
	public void enterInmateCalasificationTest() throws InterruptedException {
		NewAdmissionPage newAdmissionPage = new NewAdmissionPage(driver);
		newAdmissionPage.doCreateNewAdmition();
	}
*/

	
}
