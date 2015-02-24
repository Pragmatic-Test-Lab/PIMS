package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.InmateRegistration;
import com.ptl.pims.util.TestUtil;

public class InmateRegistrationTest extends TestBase {

	HomePage landingPage = null;



	@Test(dataProvider = "getInmatePersonalData")   //PIM-1080
	public void enterInmatePersonalDataTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Registration-Personal", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();

		APPLICATION_LOGS.debug("Going to Inmate Registration Page");
		InmateRegistration inmateRegistration  = landingPage.goToInmateRegistration();

		//String ActualHeader = inmateRegistration.getHeader();
		//String ExpectedHeader = inmateRegistration.getExpectedHeader();

		//	Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader), "Could not reach Registration");

		APPLICATION_LOGS.debug("Reached Allocate Location Page");

		inmateRegistration.doAddPersonalDetailsOfInmate(data.get("OtherName1"),data.get("OtherName2"), 
				data.get("CallName1"), data.get("CallName2"),data.get("AddrLine1"), data.get("AddrLine2"), 
				data.get("PostOffice"),data.get("PostCode"), data.get("Country"),	data.get("Province"), 
				data.get("District"),data.get("DS"), data.get("GsDiv"), data.get("City"),data.get("PoliceDiv"));

	}

	@Test(dataProvider = "getInmateClassificationData")   //PIM-1082
	public void enterInmateCalasificationTest(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Inmate Reg-Classification", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();

		APPLICATION_LOGS.debug("Going to Inmate Registration Page");
		InmateRegistration inmateRegistration  = landingPage.goToInmateRegistration();

		//String ActualHeader = inmateRegistration.getHeader();
		//String ExpectedHeader = inmateRegistration.getExpectedHeader();

		//	Assert.assertTrue(ActualHeader.equalsIgnoreCase(ExpectedHeader), "Could not reach Registration");

		APPLICATION_LOGS.debug("Reached Allocate Location Page");

		inmateRegistration.doAddCalsifiactionDetailsOfInmate(data.get("gender"),data.get("preConvict"),data.get("classif")); 


	}


	@DataProvider
	public Object[][] getInmatePersonalData() {
		return TestUtil.getTestData("Inmate Registration-Personal", xls);

	}

	@DataProvider
	public Object[][] getInmateClassificationData() {
		return TestUtil.getTestData("Inmate Reg-Classification", xls);

	}

	@AfterSuite
	public void quite(){
		driver.quit();
	}

}

