package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.AuthorizeRegistrationInmateSelectPage;
import com.ptl.pims.pages.AuthorizeRegistrationPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AuthorizeRegistrationTest extends TestBase {
	
	HomePage landingPage = null;
	AuthorizeRegistrationInmateSelectPage inmateAuthorizeSelect  =null;
	AuthorizeRegistrationPage inmateAuthorize = null;

	@Test(dataProvider = "getAuthorizationData")   
	public void GoToAuthorizeRegistration(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Authorize Registration Test", xls) || data.get("Runmode").equals("No"))
			throw new SkipException("Skipping the test");

		landingPage = returnToHomePage();
		APPLICATION_LOGS.debug("Going to Home Page");
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Top Menu");

		inmateAuthorizeSelect = topMenu.gotoAuthorizeRegistrationPage(); 

		Assert.assertEquals(inmateAuthorizeSelect.getHeader(), Constants.AuthorizeRegistration_ExpectedHeader ,
				"Could not reach Authorize Registration Page");

			APPLICATION_LOGS.debug("Reached Authorize Registration Page");
	}

	@Test(dataProvider = "getAuthorizationData",dependsOnMethods="GoToAuthorizeRegistration")  
	public void clickInmateLink(Hashtable<String, String> data) {

		// Search if specific inmate is needed
		//NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver, NewAdmissionPage.class);
		//String RegNumber = newAdmissionPage.getRegistrationNumber();
		inmateAuthorizeSelect = inmateAuthorizeSelect.doSearch(registrationNo,"","");
		

		inmateAuthorize = inmateAuthorizeSelect.clickFirstInmate();		
		APPLICATION_LOGS.debug("Reached Inmates Authorize Registration Page");

	}
	
	@Test(dependsOnMethods = "clickInmateLink", dataProvider = "getAuthorizationData")      //pims-1196
	public void AuthorizeInmate(Hashtable<String, String> data) {
		
		inmateAuthorizeSelect = inmateAuthorize.authorizeInmate();	
				
		//check Success Message
		Assert.assertTrue(inmateAuthorizeSelect.getSuccessMessage().matches(Constants.AuthorizeRegistration_SuccessMessageText),
				"Unable to authorize inmate");			
		
		APPLICATION_LOGS.debug("Changed Inmate location successfully");

	}

	
	@DataProvider
	public Object[][] getAuthorizationData() {
		return TestUtil.getTestData("Authorize Registration", xls);

	}

}
