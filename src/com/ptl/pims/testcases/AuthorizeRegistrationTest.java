package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.ptl.pims.pages.AuthorizeRegistrationInmateSelectPage;
import com.ptl.pims.pages.AuthorizeRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.TestUtil;

public class AuthorizeRegistrationTest extends TestBase {
	
	AuthorizeRegistrationInmateSelectPage inmateAuthorizeSelect;
	AuthorizeRegistrationPage inmateAuthorize;

	@Test		//pims-1196
	public void GoToAuthorizeRegistration() {

		if(!TestUtil.isTestCaseRunmodeYes("Authorize Registration Test", xls))
			throw new SkipException("Skipping the test");

		loginToApplication();
		TopMenu topMenu = getTopMenu();

		inmateAuthorizeSelect = topMenu.gotoAuthorizeRegistrationPage(); 
		inmateAuthorizeSelect = inmateAuthorizeSelect.doSearch(registrationNo,"","");
		inmateAuthorize = inmateAuthorizeSelect.clickFirstInmate();				
		APPLICATION_LOGS.debug("Reached Inmates Authorization Page");
		
		inmateAuthorizeSelect = inmateAuthorize.authorizeInmate();	
		
		//validate authorization
		//
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		inmateAuthorizeSelect = inmateAuthorizeSelect.doSearch(registrationNo,"", "");	

		Assert.assertTrue(inmateAuthorizeSelect.NoSearchResultsFound(), 
				"Inmate Still available in authorization page. Authorization Failed.");
		//
		
	}


}
