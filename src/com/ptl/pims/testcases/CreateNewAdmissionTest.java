package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;


public class CreateNewAdmissionTest extends TestBase{

	HomePage landingPage = null;
	String RHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String Front_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String LHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";

	//@Test 
	public void Test_doCreateNewAdmitionFor_Baby_Inmate_With_Required_Fields(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doCreateNewAdmissionWithRequiredFileds("Baby","Negombo","7","Diet","Test Biometric","Nimal Pathirana","FO","male");
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create baby type inmate");		
			APPLICATION_LOGS.debug("Baby type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	}
	
	//@Test 
	public void Test_doCreateNewAdmitionFor_Child_Inmate_With_Required_Fields(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doCreateNewAdmissionWithRequiredFileds("Child","Negombo","15","Diet","Test Biometric","Nimal Pathirana","FO","male");
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create child type inmate");		
			APPLICATION_LOGS.debug("Child type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	} 
	
	//@Test 
	public void Test_doCreateNewAdmitionFor_Youth_Inmate_With_Required_Fields(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doCreateNewAdmissionWithRequiredFileds("Youth","Negombo","25","Diet","Test Biometric","Nimal Pathirana","FO","male");
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create youth type inmate");		
			APPLICATION_LOGS.debug("Youth type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	} 
	
	//@Test 
	public void Test_doCreateNewAdmitionFor_Convicted_Inmate_With_Required_Fields(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    creAdmissionPage.doCreateNewAdmissionWithRequiredFileds("Convicted","Negombo","25","Diet","Test Biometric","Nimal Pathirana","FO","male");
			registrationNo = creAdmissionPage.getRegistrationNumber();
			newAdmissionPage = creAdmissionPage.doAdmission();	
			Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create convicted type inmate");		
			APPLICATION_LOGS.debug("Convicted type inmate successfully created");
		}catch(Exception ex){
			APPLICATION_LOGS.debug(ex.getMessage());
		}
		
	} 
	
	//@Test 
	public void Test_doCreateNewAdmitionFor_Un_Convicted_Inmate_With_Required_Fields(){
			try{
				landingPage = returnToHomePage();		
				TopMenu topMenu = getTopMenu();
				NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();			
				CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			    creAdmissionPage.doCreateNewAdmissionWithRequiredFileds("Un-Convicted","Negombo","25","Diet","Test Biometric","Nimal Pathirana","FO","male");
				registrationNo = creAdmissionPage.getRegistrationNumber();
				newAdmissionPage = creAdmissionPage.doAdmission();	
				Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create Un-convicted type inmate");		
				APPLICATION_LOGS.debug("Un-Convicted type inmate successfully created");
			}catch(Exception ex){
				APPLICATION_LOGS.debug(ex.getMessage());
			}
			
		} 
		
	//@Test   
	public void Test_doCreateNewAdmitionFor_Un_ConvictedInmate_WithSubHeadings(){
		try{
			landingPage = returnToHomePage();		
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		    CreateAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			createNewAdmissionPage.doCreateNewAdmitionWithSubHeadings("Un-Convicted","Negombo","25","Diet","Test Biometric","Nimal Pathirana","FO","male",
					RHS_Image_Path,Front_Image_Path, LHS_Image_Path,"Colombo","CASE001","2015-02-24",
					true,"Health Conditions Remarks",true,"Health of school","Other", "Cough",
					"2015-02-10","Health","Descriptios","2015-02-18","Other","Descriptions","1","200.89","Name hi","2015-02-25");
			registrationNo = createNewAdmissionPage.getRegistrationNumber();
	        newAdmissionPage = createNewAdmissionPage.doAdmission();	
	        Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Faild - Create Un-Convicted type inmate with all the sub headings");		
			APPLICATION_LOGS.debug("Un-Convicted type inmate successfully created with all the sub headings");
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
		    CreateAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
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
		    CreateAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			
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
		    CreateAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
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
		    CreateAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
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
			CreateAdmissionPage creAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
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
	

	//---------------------Previous codes-------------------------To be Deleted----------------------
	
	/*//@Test 
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
		*/
	
}
