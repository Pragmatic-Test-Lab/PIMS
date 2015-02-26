package com.ptl.pims.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ptl.pims.pages.AuthorizeAdmissionPage;
import com.ptl.pims.pages.AuthorizeAdmissionSelectPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;

public class AuthorizeAdmissionTest extends TestBase {

	HomePage landingPage = null;

	@Test // PIMS-1194
	public void Test_doCreateNewAdmitionFor_ConvictedInmate() throws InterruptedException{
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = topMenu.gotoAuthorizeAdmissionPage();
		
		//NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver, NewAdmissionPage.class);
		//String RegNumber = newAdmissionPage.getRegistrationNumber();
		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo,"", "");
		
		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch("","","");
		AuthorizeAdmissionPage authorizeAdmissionPage =  authorizeAdmissionSelectPage.clickFirstInmate();
		authorizeAdmissionPage.doAuthorizeAdmission();
		
	}
	
}
