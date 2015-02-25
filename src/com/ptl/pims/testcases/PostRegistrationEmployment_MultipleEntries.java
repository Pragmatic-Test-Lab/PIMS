package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.UpdatePostRegistrationPage;
import com.ptl.pims.util.TestUtil;

public class PostRegistrationEmployment_MultipleEntries extends TestBase {
	HomePage landingPage = null;
	
	
	@Test(dataProvider = "getEmploymentMultipleEntriesData")
	public void VerifyMultipleEntries(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("UpdatePostReg Test", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();
		APPLICATION_LOGS.debug("Going to Home Page");
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Top Menu");
		PostRegistrationPage postRegPage = topMenu.gotoPostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Post Registration Page");
		UpdatePostRegistrationPage updatePostRegPage = postRegPage.gotoUpdatePostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Update Post Registration Page");
		updatePostRegPage.gotoEmploymentTab();
		APPLICATION_LOGS.debug("Go to the Employment tab");
		updatePostRegPage.EnterEmploymentData(data.get("Employers"), data.get("Organizational Types"), data.get("Positions"), 
				data.get("Dates From"), data.get("Dates To"));
		postRegPage = updatePostRegPage.ClickUpdateButton();		
		Assert.assertEquals(postRegPage.getActualSuccessMessage().contains(postRegPage.getExpectedSuccessMessage()), "Unable to add multiple employment entries");		

		APPLICATION_LOGS.debug("Reached Post Registration Page");
	}
	
	
	@DataProvider
	public Object[][] getEmploymentMultipleEntriesData() {
		return TestUtil.getTestData("UpdatePostReg Test", xls);

	}





}
