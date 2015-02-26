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
	
	AuthorizeRegistrationInmateSelectPage inmateAuthorizeSelect;
	AuthorizeRegistrationPage inmateAuthorize;

	@Test
	public void GoToAuthorizeRegistration() {

		if(!TestUtil.isTestCaseRunmodeYes("Authorize Registration Test", xls))
			throw new SkipException("Skipping the test");

		HomePage landingPage = returnToHomePage();
		TopMenu topMenu = getTopMenu();

		inmateAuthorizeSelect = topMenu.gotoAuthorizeRegistrationPage(); 
		Assert.assertTrue(inmateAuthorizeSelect.getHeader().equalsIgnoreCase(Constants.AuthorizeRegistration_ExpectedHeader),"Could not reach Authorize Registration Page");
		
		inmateAuthorizeSelect = inmateAuthorizeSelect.doSearch(registrationNo,"","");	

		inmateAuthorize = inmateAuthorizeSelect.clickFirstInmate();		
		APPLICATION_LOGS.debug("Reached Inmates Authorization Page");
	}
	
	
	@Test(dependsOnMethods = "GoToAuthorizeRegistration")      //pims-1196
	public void AuthorizeInmate(Hashtable<String, String> data) {
		
		inmateAuthorizeSelect = inmateAuthorize.authorizeInmate();	
				
		Assert.assertTrue(inmateAuthorizeSelect.getSuccessMessage().matches(Constants.AuthorizeRegistration_SuccessMessageText), "Unable to authorize inmate");			
		APPLICATION_LOGS.debug("Changed Inmate location successfully");
	}


}
