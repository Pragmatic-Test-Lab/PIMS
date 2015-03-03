package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateNewAdmissionPage;
import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;


public class CreateNewAdmissionTest extends TestBase{

	HomePage landingPage = null;

    
	//@Test 
	public void Test_doCreateNewAdmitionFor_ChildInmate(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateNewAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doCreateNewAdmitionFor_ChildInmate();
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create child type inmate");		
			APPLICATION_LOGS.debug("Child type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	}
		
	//@Test // PIMS-656
	public void Test_doCreateNewAdmitionFor_ConvictedInmate(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();		
			CreateNewAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			creAdmissionPage.doCreateNewAdmitionFor_ConvictedInmate();
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create child type inmate");		
			APPLICATION_LOGS.debug("Child type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	}
	
	//@Test   // PIMS-628
	public void Test_doCreateNewAdmitionFor_Non_ConvictedInmate() {
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
			CreateNewAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			creAdmissionPage.doCreateNewAdmitionFor_Un_ConvictedInmate();
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create child type inmate");		
			APPLICATION_LOGS.debug("Child type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
	}
	
	//@Test   
	public void Test_doCreateNewAdmitionFor_Non_ConvictedInmate_WithSubHeadings(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			createNewAdmissionPage.doCreateNewAdmitionFor_Un_ConvictedInmate_WithSubHeadings();
			registrationNo = createNewAdmissionPage.getRegistrationNumber();
	        newAdmissionPage = createNewAdmissionPage.doAdmission();	
	        Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create child type inmate");		
			APPLICATION_LOGS.debug("Child type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
	}

	//@Test   // PIMS-898  
	public void Test_checkMealTypeIsSelectable() {
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    Assert.assertTrue(createNewAdmissionPage.checkMealTypeIsSelectable(), "Meal Type Is Not Selectable");
		    APPLICATION_LOGS.debug("Meal Type Is Selectable");
		}catch (Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
		
	}
	
	//@Test // PIMS-408
	public void Test_checkInmateRegistrationNumberIsAutoGenarated(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			
		    Assert.assertTrue(createNewAdmissionPage.checkIsInmateRegistrationNumberIsAutoGenarated(), "Faild - Autogenarating of Registration number");
		    APPLICATION_LOGS.debug("Registraion number succssfully autogenarated");
		}catch (Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
	}
	
	//@Test // PIMS-869
	public void Test_checkImateCatagoryIsSelectable(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			createNewAdmissionPage.checkImateCatagoryIsSelectable();
			Assert.assertTrue(createNewAdmissionPage.checkImateCatagoryIsSelectable(), "Inmate Catagory Is Not Selectable");
		    APPLICATION_LOGS.debug("Inamte Catagory Is Selectable");
		}catch (Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
	}
	
	//@Test   // PIMS-1190  
	public void Test_checkAgeCatagoryIsAutoSelected() {
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			String selectedOption = createNewAdmissionPage.checkAgeCatagoryIsAutoSelected();
			Assert.assertTrue(selectedOption.equalsIgnoreCase("Youth"),"Age catagory doesn't match with the age you entered");
			APPLICATION_LOGS.debug("Age catagory matched with the age you provided");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
	}

	@Test // PIMS-1198
	public void Test_checkUserCanUploadTheAllThreeImages() {
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			//Create Inmate with images
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateNewAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.checkUserCanUploadTheAllThreeImages();
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
		//	Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create child type inmate");		
		//	APPLICATION_LOGS.debug("Child type inmate successfully created");
			EditAdmissionSelectPage editAdmissionSelectPage = topMenu.gotoEditAdmissionPage();
			editAdmissionSelectPage = editAdmissionSelectPage.doSearch(registrationNo,"","");
			EditAdmissionPage editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
			Assert.assertTrue(editAdmissionPage.getRHSImageBox() , "RHS Image couldn't uploded correclty");
			APPLICATION_LOGS.debug("RHS Image uploded successfully");
			Assert.assertTrue(editAdmissionPage.getFrontImageBox() , "Frnot Image couldn't uplodaed correclty");
			APPLICATION_LOGS.debug("Front Image uploded successfully");
			Assert.assertTrue(editAdmissionPage.getLHSImageBox() , "LHS Image couldn't uplodaed correclty");
			APPLICATION_LOGS.debug("LHS Image uploded successfully");		
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	}
	
// -----------------Need to fix the issue on verification-------------
	/* 
	
	
	//@Test   // PIMS-19
	public void Test_checkRegistrationNumberFormtForUnConvictedInamtes() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
	    CreateNewAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		createNewAdmissionPage.checkRegistrationNumberFormtForUnConvictedInamtes();
	}
		
	@Test
	public void enterInmateCalasificationTest() throws InterruptedException {
		NewAdmissionPage newAdmissionPage = new NewAdmissionPage(driver);
		newAdmissionPage.doCreateNewAdmition();
	}*/
	

	
}
