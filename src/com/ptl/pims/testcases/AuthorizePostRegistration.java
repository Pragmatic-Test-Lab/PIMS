package com.ptl.pims.testcases;

import org.testng.annotations.Test;
import com.ptl.pims.pages.AuthorizePostRegUserPage;
import com.ptl.pims.pages.PostRegistrationAuthorizePage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.TopMenu;

public class AuthorizePostRegistration extends TestBase {

	@Test // PIMS-674
	public void Test_doAuthorizePostReg(){
		
		HomePage landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		PostRegistrationAuthorizePage authorizePostRegsitrationSelectPage = topMenu.gotoAuthorizePostRegistration();

		authorizePostRegsitrationSelectPage = authorizePostRegsitrationSelectPage.doSearch(registrationNo,"", "");	
		AuthorizePostRegUserPage authorizePostRegsitrationPage =  authorizePostRegsitrationSelectPage.clickFirstInmate();
		
		authorizePostRegsitrationSelectPage = authorizePostRegsitrationPage.ClickAuthorizeButton();
		
	}
	
}
