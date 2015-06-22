package com.ptl.pims.testcases.RegistrationTest;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Registration.AuthorizeRegistrationInmateSelectPage;
import com.ptl.pims.pages.Registration.AuthorizeRegistrationPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;

public class AuthorizeRegistrationTest extends TestBase {
	
	AuthorizeRegistrationInmateSelectPage inmateAuthorizeSelect;
	AuthorizeRegistrationPage inmateAuthorize;

	@Test		//pims-1196
	public void GoToAuthorizeRegistration() {

		if(!TestUtil.isTestCaseRunmodeYes("Authorize Registration Test", xls))
			throw new SkipException("Skipping the test");

		loginToApplication();

		inmateAuthorizeSelect = getTopMenu().gotoAuthorizeRegistrationPage(); 
		inmateAuthorizeSelect = inmateAuthorizeSelect.doSearch(registrationNo,"","");
		inmateAuthorize = inmateAuthorizeSelect.clickFirstInmate();				
		
		inmateAuthorizeSelect = inmateAuthorize.authorizeInmate();	
		
		assertTrue(inmateAuthorizeSelect.successMessageAvaiable(), "Authorize Registratrion success message not found");		

		
	}


}
