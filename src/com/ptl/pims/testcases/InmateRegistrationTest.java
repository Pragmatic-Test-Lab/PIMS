package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.InmateRegistration;
import com.ptl.pims.pages.InmateRegistrationSelectPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class InmateRegistrationTest extends TestBase {

	InmateRegistrationSelectPage inmateRegistrationSelect;
	InmateRegistration inmateRegistration;

	@Test  //PIMS-1080
	public void goInmateRegistrationPage() {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Registration Test", xls))
			throw new SkipException("Skipping the test");
		
		HomePage landingPage = returnToHomePage();
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Inmate Registration Page");
		inmateRegistrationSelect  = topMenu.goToInmateRegistration();
		
		inmateRegistrationSelect = inmateRegistrationSelect.doSearch("10045/10/CBS/2015","" ,"");
		inmateRegistration = inmateRegistrationSelect.clickFirstInmate(); 
		APPLICATION_LOGS.debug("Reached Allocate Location Page");

	}
	
	@Test(dependsOnMethods="goInmateRegistrationPage")   //PIMS-389
	public void checkInmateFrontImage() {
		
		Assert.assertTrue(inmateRegistration.IsFrontPhotoAvailable(), "Front Photo Not Found");

	}
	
	@Test(dependsOnMethods="goInmateRegistrationPage")   //PIMS-630, PIMS-631, PIMS-632
	public void enterInmateImages() {
		
		inmateRegistration.doAddInmatePhotos();

	}
	
	@Test(dataProvider = "getInmatePersonalData",dependsOnMethods="goInmateRegistrationPage")   //PIMS-1079
	public void enterInmatePersonalData(Hashtable<String, String> data) {

		if(data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");
		
		APPLICATION_LOGS.debug("Adding Personal Data");
		inmateRegistration.doAddPersonalDetailsOfInmate(data.get("OtherName1"),data.get("OtherName2"), 
				data.get("CallName1"), data.get("CallName2"),data.get("AddrLine1"), data.get("AddrLine2"), 
				data.get("PostOffice"),data.get("PostCode"), data.get("Country"),	data.get("Province"), 
				data.get("District"),data.get("DS"), data.get("GsDiv"), data.get("City"),data.get("PoliceDiv"));
		
	}	
	

	@Test(dataProvider = "getInmateClassificationData",dependsOnMethods="goInmateRegistrationPage")   //PIMS-1080
	public void enterInmateCalasificationTest(Hashtable<String, String> data) {

		if(data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		APPLICATION_LOGS.debug("Adding Classification Data");
		inmateRegistration.doAddClassifiactionDetailsOfInmate(data.get("classif")); 
	}

	@Test(dataProvider = "getInmateCharacteristicData",dependsOnMethods="goInmateRegistrationPage")   //PIMS-1082
	public void enterInmateCharacteristicTest(Hashtable<String, String> data) {

		if(data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		APPLICATION_LOGS.debug("Adding Characteristics Data");
		inmateRegistration.doAddCharacteristicDetailsOfInmate(data.get("nationality"),data.get("race"),data.get("marital"),data.get("religion"),
				data.get("nic"),data.get("birthdate"), data.get("birthplace"), data.get("passport")); 

	}

	@Test(dataProvider = "getIdentificationData",dependsOnMethods="goInmateRegistrationPage")   //PIMS-1083
	public void enterInmateIdentificationTest(Hashtable<String, String> data) {

		if(data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");
		
		APPLICATION_LOGS.debug("Adding Identification Data");
		inmateRegistration.doAddIdentificationDetailsOfInmate(data.get("face"),data.get("faced"),data.get("hair"),data.get("haird"),
				data.get("eyes"),data.get("eyesd"), data.get("nose"), data.get("bodymark")); 

	}


	//@Test(dataProvider = "getcaseData",dependsOnMethods="goInmateRegistrationPage")   //PIMS-1085
	public void enterInmatecaseTest(Hashtable<String, String> data) {

		if(data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		APPLICATION_LOGS.debug("Adding Inmate Case Data");
		inmateRegistration.doAddcaseDetailsOfInmate(data.get("casen"),data.get("offense"),data.get("offdescription"),data.get("sentence"),
				data.get("description"),data.get("days"), data.get("months"),data.get("years"), data.get("fine")); 		

	}
	
	//@Test(dependsOnMethods="goInmateRegistrationPage")   //PIMS-990,PIMS-49
	public void submitRegistrationData() {
	
		inmateRegistrationSelect = inmateRegistration.clickButton();
		
		Assert.assertTrue(inmateRegistrationSelect.getSuccessMessage().matches(Constants.InmateRegistration_SuccessMessageText), "Registration of Inmate has failed");		

	}



	@DataProvider
	public Object[][] getInmatePersonalData() {
		return TestUtil.getTestData("Inmate Registration-Personal", xls);

	}

	@DataProvider
	public Object[][] getInmateClassificationData() {
		return TestUtil.getTestData("Inmate Reg-Classification", xls);

	}

	@DataProvider
	public Object[][] getInmateCharacteristicData() {
		return TestUtil.getTestData("Inmate Reg-Characteristic", xls);

	}

	@DataProvider
	public Object[][] getIdentificationData() {
		return TestUtil.getTestData("Inmate Reg-Identification", xls);

	}

	@DataProvider
	public Object[][] getcaseData() {
		return TestUtil.getTestData("Inmate Reg-Case", xls);

	}

}

