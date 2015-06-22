package com.ptl.pims.testcases.PostRegistration;

import org.testng.annotations.Test;

import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.PostRegistration.AuthorizePostRegUserPage;
import com.ptl.pims.pages.PostRegistration.PostRegistrationAuthorizePage;
import com.ptl.pims.testcases.TestBase;

public class AuthorizePostRegistration extends TestBase {

	@Test // PIMS-674
	public void Test_doAuthorizePostReg(){
		
		loginToApplication();		
		TopMenu topMenu = getTopMenu();
		PostRegistrationAuthorizePage authorizePostRegsitrationSelectPage = topMenu.gotoAuthorizePostRegistration();

		authorizePostRegsitrationSelectPage = authorizePostRegsitrationSelectPage.doSearch(registrationNo,"", "");	
		AuthorizePostRegUserPage authorizePostRegsitrationPage =  authorizePostRegsitrationSelectPage.clickFirstInmate();
		
		authorizePostRegsitrationSelectPage = authorizePostRegsitrationPage.ClickAuthorizeButton();
		assertTrue(authorizePostRegsitrationSelectPage.successMessageAvaiable(), 
				"Success Message not Found in Post-Registration Authorize");
		
	}
	
}

