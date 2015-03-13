package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class WrongPasswordTest extends TestBase {
	
	LoginPage loginPage;
	
	@Test(dataProvider = "getInvalidLoginData")
	public void invaalidDataLogin(Hashtable<String, String> data) {

		if(!TestUtil.isTestCaseRunmodeYes("Login Test", xls))
		throw new SkipException("Skipping the test");
		
		if(isLoggedIn){
			TopMenu topMenu = getTopMenu();
			loginPage = topMenu.doLogout();
		}
			
		driver.get(CONFIG.getProperty("BASE_URL"));		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.doLogin(data.get("Username"),data.get("Password"));		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		Assert.assertTrue(loginPage.getErrorMessage().equals(Constants.Login_PasswordErrorText), "No error message shown with data Username:" + data.get("Username") + "Password:" + data.get("Password"));		
		
	}
		

	@DataProvider
	public Object[][] getInvalidLoginData() {
		return TestUtil.getTestData("Invalid Login Data", xls);
		
	}
}
