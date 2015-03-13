package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.UpdatePostRegistrationPage;

public class PostRegistration_VerifyEmploymentTabEnableTest extends TestBase {

	@Test
	public void VerifyEmploymentTabEnable() {
		
		loginToApplication();
		TopMenu topMenu = getTopMenu();

		PostRegistrationPage postRegPage = topMenu.gotoPostRegistrationPage();
		UpdatePostRegistrationPage updatePostRegPage = postRegPage.gotoUpdatePostRegistrationPage();
		APPLICATION_LOGS.debug("Going to Post Registration Page");
		updatePostRegPage.gotoEmploymentTab();
		APPLICATION_LOGS.debug("Clicked on the Employment tab");
		Assert.assertEquals(updatePostRegPage.getActualEmploymnetTabStatus(), updatePostRegPage.getExpectedEmploymentTabStatus(), "Unable to go to the Employment tab");		

		APPLICATION_LOGS.debug("Reached Post Registration Page");
	}	

}
