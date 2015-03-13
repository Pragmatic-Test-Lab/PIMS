package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;


public class LogoutTest extends TestBase {
	
	LoginPage loginPage;
	
	@Test
	public void logoutTest() {
		
		loginToApplication();
		TopMenu topMenu = getTopMenu();
		loginPage = topMenu.doLogout();
		
		Assert.assertEquals(loginPage.getTitle(), Constants.Login_ExpectedTitle, "Could not logout!");
		APPLICATION_LOGS.debug("logged out");
	}
	
	@Test(dependsOnMethods = "logoutTest")
	public void afterlogoutTest() {

		Assert.assertTrue(loginPage.getUsernameFieldValue().equals(""), "login field not empty");
		Assert.assertTrue(loginPage.getPasswordFieldValue().equals(""), "password field not empty");

	
	}


}
