package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.UpdatePostRegistrationPage;
import com.ptl.pims.util.TestUtil;

public class PostRegistrationTest extends TestBase{
	HomePage landingPage = null;
	
	
	@Test(dataProvider = "getPostRegistrationData")
	public void SearchAnInmate(Hashtable<String, String> data) {

		if (!TestUtil.isTestCaseRunmodeYes("PostReg Test", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();
		APPLICATION_LOGS.debug("Going to Home Page");
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Top Menu");
		PostRegistrationPage postRegPage = topMenu.gotoPostRegistrationPage();
		APPLICATION_LOGS.debug("Going to the Post Registration Page");

		postRegPage.doSearch(registrationNo, "", "", "");
		APPLICATION_LOGS.debug("Search an inmate");
		postRegPage.gotoUpdatePostRegistrationPage();
		APPLICATION_LOGS.debug("Reached Update Post Registration User Page");	
		
	}
	
	
	@DataProvider
	public Object[][] getPostRegistrationData() {
		return TestUtil.getTestData("PostReg Test", xls);

	}





}
