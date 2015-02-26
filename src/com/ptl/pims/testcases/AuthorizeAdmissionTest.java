package com.ptl.pims.testcases;

import org.testng.annotations.Test;
import com.ptl.pims.pages.AuthorizeAdmissionPage;
import com.ptl.pims.pages.AuthorizeAdmissionSelectPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.TopMenu;

public class AuthorizeAdmissionTest extends TestBase {

	@Test // PIMS-1194
	public void Test_doAuthorizeAdmition(){
		
		HomePage landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = topMenu.gotoAuthorizeAdmissionPage();

		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo,"", "");	
		AuthorizeAdmissionPage authorizeAdmissionPage =  authorizeAdmissionSelectPage.clickFirstInmate();
		authorizeAdmissionPage.doAuthorizeAdmission();
	}
	
}
