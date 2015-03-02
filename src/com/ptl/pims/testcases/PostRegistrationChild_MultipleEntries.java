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

public class PostRegistrationChild_MultipleEntries extends TestBase {

HomePage landingPage = null;
	
	
	@Test(dataProvider = "getChildMultipleEntriesData")
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
		updatePostRegPage.gotoChildTab();
		APPLICATION_LOGS.debug("Clicked on the Child tab");
		updatePostRegPage.EnterChildData(data.get("Names"), data.get("Addresss"), data.get("Ages"), 
				data.get("Schools"), data.get("Grades"));
		postRegPage = updatePostRegPage.ClickUpdateButton();
		APPLICATION_LOGS.debug("Actual Message: "+ postRegPage.getActualSuccessMessage());
		APPLICATION_LOGS.debug("Expected Message: "+ postRegPage.getExpectedSuccessMessage());
		Assert.assertTrue(postRegPage.getActualSuccessMessage().contains(postRegPage.getExpectedSuccessMessage()), "Unable to add multiple child entries");		

		APPLICATION_LOGS.debug("Reached Post Registration Page");
	}
	
	
	@DataProvider
	public Object[][] getChildMultipleEntriesData() {
		return TestUtil.getTestData("UpdatePostReg Test", xls);

	}


	
}
