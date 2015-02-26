package com.ptl.pims.testcases;

import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateNewAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;


public class NewAdmissionTest extends TestBase{

	HomePage landingPage = null;

	@Test // PIMS-656
	public void Test_doCreateNewAdmitionFor_ConvictedInmate(){
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	
		CreateNewAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		creAdmissionPage.doCreateNewAdmitionFor_ConvictedInmate();
		registrationNo = creAdmissionPage.getRegistrationNumber();
		creAdmissionPage.doAdmission();
	}
	
	@Test   // PIMS-628
	public void Test_doCreateNewAdmitionFor_Non_ConvictedInmate() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	
		CreateNewAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		creAdmissionPage.doCreateNewAdmitionFor_Un_ConvictedInmate();
		registrationNo = creAdmissionPage.getRegistrationNumber();
		creAdmissionPage.doAdmission();
	}
	
	//@Test   
	public void Test_doCreateNewAdmitionFor_Non_ConvictedInmate_WithSubHeadings() throws Exception {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.doCreateNewAdmitionFor_Un_ConvictedInmate_WithSubHeadings();
		registrationNo = createNewAdmissionPage.getRegistrationNumber();
		createNewAdmissionPage.doAdmission();
	}
	
	
	
	@Test   // PIMS-898
	public void Test_checkMealTypeIsSelectable() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.checkMealTypeIsSelectable();
		registrationNo = createNewAdmissionPage.getRegistrationNumber();
		createNewAdmissionPage.doAdmission();
	}
	
	@Test   // PIMS-1190
	public void Test_checkAgeCatagoryIsAutoSelected() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.checkAgeCatagoryIsAutoSelected();
		registrationNo = createNewAdmissionPage.getRegistrationNumber();
		createNewAdmissionPage.doAdmission();
	}
	
	@Test   // PIMS-19
	public void Test_checkRegistrationNumberFormtForUnConvictedInamtes() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.checkRegistrationNumberFormtForUnConvictedInamtes();
		registrationNo = createNewAdmissionPage.getRegistrationNumber();
		createNewAdmissionPage.doAdmission();
	}
	
	@Test // PIMS-408
	public void Test_checkInmateRegistrationNumberIsAutoGenarated(){
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.checkInmateRegistrationNumberIsAutoGenarated();
		registrationNo = createNewAdmissionPage.getRegistrationNumber();
		createNewAdmissionPage.doAdmission();
	}
	
	@Test // PIMS-869
	public void Test_checkImateCatagoryIsSelectable(){
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.checkImateCatagoryIsSelectable();
		registrationNo = createNewAdmissionPage.getRegistrationNumber();
		createNewAdmissionPage.doAdmission();
	}
	
	@Test // PIMS-1198
	public void Test_checkUserCanUploadTheAllThreeImages() throws Exception{
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.checkUserCanUploadTheAllThreeImages();
		registrationNo = createNewAdmissionPage.getRegistrationNumber();
		createNewAdmissionPage.doAdmission();
	}
	
	/*
	@Test
	public void enterInmateCalasificationTest() throws InterruptedException {
		NewAdmissionPage newAdmissionPage = new NewAdmissionPage(driver);
		newAdmissionPage.doCreateNewAdmition();
	}*/
	

	
}
