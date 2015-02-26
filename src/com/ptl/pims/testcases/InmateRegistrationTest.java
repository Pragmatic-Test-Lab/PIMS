package com.ptl.pims.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.InmateRegistration;
import com.ptl.pims.pages.InmateRegistrationSelectPage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class InmateRegistrationTest extends TestBase {

	HomePage landingPage = null;
	InmateRegistrationSelectPage inmateRegistrationSelect  =null;
	InmateRegistration inmateRegistration = null;

	@Test(dataProvider = "getInmatePersonalData")   //PIM-1080
	public void enterInmatePersonalDataTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Registration-Personal", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();

		APPLICATION_LOGS.debug("Going to Inmate Registration Page");
		inmateRegistrationSelect  = landingPage.goToInmateRegistration();
		//NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver, NewAdmissionPage.class);
		//String RegNumber = newAdmissionPage.getRegistrationNumber();
		
		inmateRegistrationSelect = inmateRegistrationSelect.doSearch(registrationNo,"" ,"");

		inmateRegistration = inmateRegistrationSelect.clickFirstInmate(); 

		//String ActualHeader = inmateRegistration.getHeader();
		//String ExpectedHeader = inmateRegistration.getExpectedHeader();

		//Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader), "Could not reach Registration");

		APPLICATION_LOGS.debug("Reached Allocate Location Page");

		inmateRegistration.doAddPersonalDetailsOfInmate(data.get("OtherName1"),data.get("OtherName2"), 
				data.get("CallName1"), data.get("CallName2"),data.get("AddrLine1"), data.get("AddrLine2"), 
				data.get("PostOffice"),data.get("PostCode"), data.get("Country"),	data.get("Province"), 
				data.get("District"),data.get("DS"), data.get("GsDiv"), data.get("City"),data.get("PoliceDiv"));

	}

	@Test(dataProvider = "getInmateClassificationData",dependsOnMethods="enterInmatePersonalDataTest")   //PIM-1082
	public void enterInmateCalasificationTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Reg-Classification", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		//landingPage = returnToHomePage();

		//APPLICATION_LOGS.debug("Going to Inmate Registration Page");
		//InmateRegistrationSelectPage inmateRegistrationSelect  = landingPage.goToInmateRegistration();

		//InmateRegistration inmateRegistration = inmateRegistrationSelect.clickFirstInmate(); 

		//String ActualHeader = inmateRegistration.getHeader();
		//String ExpectedHeader = inmateRegistration.getExpectedHeader();

		//	Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader), "Could not reach Registration");

		//	APPLICATION_LOGS.debug("Reached Allocate Location Page");

		inmateRegistration.doAddClassifiactionDetailsOfInmate(data.get("classif")); 


	}

	@Test(dataProvider = "getInmateCharacteristicData",dependsOnMethods="enterInmateCalasificationTest")   
	public void enterInmateCharacteristicTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Reg-Characteristic", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		inmateRegistration.doAddCharacteristicDetailsOfInmate(data.get("nationality"),data.get("race"),data.get("marital"),data.get("religion"),
				data.get("nic"),data.get("birthdate"), data.get("birthplace"), data.get("passport")); 

	}

	@Test(dataProvider = "getIdentificationData",dependsOnMethods="enterInmateCharacteristicTest")   
	public void enterInmateIdentificationTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Reg-Identification", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		inmateRegistration.doAddIdentificationDetailsOfInmate(data.get("face"),data.get("faced"),data.get("hair"),data.get("haird"),
				data.get("eyes"),data.get("eyesd"), data.get("nose"), data.get("bodymark")); 
		inmateRegistrationSelect = inmateRegistration.clickButton();

		Assert.assertTrue(inmateRegistrationSelect.getSuccessMessage().matches(Constants.InmateRegistration_SuccessMessageText),
				"Success Message not displayed");
		
		APPLICATION_LOGS.debug("Success Message received.");
	}


/*	@Test(dataProvider = "getcaseData",dependsOnMethods="enterInmateIdentificationTest")   
	public void enterInmatecaseTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Reg-Case", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		inmateRegistration.doAddcaseDetailsOfInmate(data.get("casen"),data.get("offense"),data.get("offdescription"),data.get("sentence"),
				data.get("description"),data.get("days"), data.get("fine")); 
		
		inmateRegistrationSelect = inmateRegistration.clickButton();

		

	}*/



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

