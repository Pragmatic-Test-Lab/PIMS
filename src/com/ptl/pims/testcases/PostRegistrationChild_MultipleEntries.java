package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.UpdatePostRegistrationPage;
import com.ptl.pims.util.TestUtil;

public class PostRegistrationChild_MultipleEntries extends TestBase {

	
	@Test(dataProvider = "getChildMultipleEntriesData")
	public void VerifyMultipleEntries(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("UpdatePostReg Test", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		loginToApplication();
		TopMenu topMenu = getTopMenu();
		
		PostRegistrationPage postRegPage = topMenu.gotoPostRegistrationPage();
		UpdatePostRegistrationPage updatePostRegPage = postRegPage.gotoUpdatePostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Update Post Registration Page");
		updatePostRegPage.gotoChildTab();
		APPLICATION_LOGS.debug("Clicked on the Child tab");
		updatePostRegPage.EnterChildData(data.get("Names"), data.get("Addresss"), data.get("Ages"), 
				data.get("Schools"), data.get("Grades"));
		postRegPage = updatePostRegPage.ClickUpdateButton();
		APPLICATION_LOGS.debug("Actual Message: "+ postRegPage.getActualSuccessMessage());
		APPLICATION_LOGS.debug("Expected Message: "+ postRegPage.getExpectedSuccessMessage());
		Assert.assertTrue(postRegPage.getActualSuccessMessage().matches(postRegPage.getExpectedSuccessMessage()), "Unable to add multiple education entries");		

		APPLICATION_LOGS.debug("Reached Post Registration Page");
	}
	
	
	@DataProvider
	public Object[][] getChildMultipleEntriesData() {
		return TestUtil.getTestData("UpdatePostReg Test", xls);

	}


	
}
