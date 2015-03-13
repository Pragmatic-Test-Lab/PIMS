package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ptl.pims.pages.AuthorizeAdmissionPage;
import com.ptl.pims.pages.AuthorizeAdmissionSelectPage;
import com.ptl.pims.pages.TopMenu;

public class AuthorizeAdmissionTest extends TestBase {

	@Test // PIMS-1194
	public void Test_doAuthorizeAdmition(){
		
		loginToApplication();		
		TopMenu topMenu = getTopMenu();
		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = topMenu.gotoAuthorizeAdmissionPage();

		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo,"", "");	
		AuthorizeAdmissionPage authorizeAdmissionPage =  authorizeAdmissionSelectPage.clickFirstInmate();
		
		authorizeAdmissionSelectPage = authorizeAdmissionPage.doAuthorizeAdmission();
		
		//validate authorization
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo,"", "");	

		Assert.assertTrue(authorizeAdmissionSelectPage.NoSearchResultsFound(), 
				"Inmate Still available in authorization page. Authorization Failed.");
	}
	
}
