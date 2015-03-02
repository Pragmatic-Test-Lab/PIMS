package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.UpdatePostRegistrationPage;

public class PostRegistration_VerifyChildrenTabEnableTest extends TestBase{
	HomePage landingPage = null;
	
	
	@Test
	public void VerifyChildTabEnable() {
		
		landingPage = returnToHomePage();
		APPLICATION_LOGS.debug("Going to Home Page");
		TopMenu topMenu = getTopMenu();
		APPLICATION_LOGS.debug("Going to Top Menu");
		PostRegistrationPage postRegPage = topMenu.gotoPostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Post Registration Page");
		UpdatePostRegistrationPage updatePostRegPage = postRegPage.gotoUpdatePostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Post Registration Page");
		updatePostRegPage.gotoChildTab();
		APPLICATION_LOGS.debug("Clicked on the Child tab");
		Assert.assertEquals(updatePostRegPage.getActualChildTabStatus(), updatePostRegPage.getExpectedChildTabStatus(), "Unable to go to the Child tab");		
		
		APPLICATION_LOGS.debug("Reached Post Registration Page");
}
}