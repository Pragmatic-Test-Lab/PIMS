package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.ptl.pims.pages.AuthorizeRegistrationInmateSelectPage;
import com.ptl.pims.pages.AuthorizeRegistrationPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AuthorizeRegistrationTest extends TestBase {

	@Test
	public void AuthorizeInmateRegistration() {												//pims-1196

		if(!TestUtil.isTestCaseRunmodeYes("Authorize Registration Test", xls))		
			throw new SkipException("Skipping the test");

		HomePage landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		
		APPLICATION_LOGS.debug("Going to Authorize Registration Page");
		AuthorizeRegistrationInmateSelectPage inmateAuthorizeSelect = topMenu.gotoAuthorizeRegistrationPage();
		Assert.assertEquals(inmateAuthorizeSelect.getHeader(), Constants.AuthorizeRegistration_ExpectedHeader,"Could not reach Authorize Registration Page");
		APPLICATION_LOGS.debug("Reached Authorize Registration Page");
		
		APPLICATION_LOGS.debug("Searching for inmate");		
		inmateAuthorizeSelect = inmateAuthorizeSelect.doSearch("10008/10/CBS/2015","","");
		AuthorizeRegistrationPage inmateAuthorize = inmateAuthorizeSelect.clickFirstInmate();		
		
		APPLICATION_LOGS.debug("Authorizing inmate");		
		inmateAuthorizeSelect = inmateAuthorize.authorizeInmate();
		
		Assert.assertTrue(inmateAuthorizeSelect.getSuccessMessage().matches(Constants.AuthorizeRegistration_SuccessMessageText),"Unable to authorize inmate");			
		APPLICATION_LOGS.debug("Changed Inmate location successfully");
	}

	
	

}
