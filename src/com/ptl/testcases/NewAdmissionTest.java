package com.ptl.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pages.HomePage;
import com.ptl.pages.InmateRegistration;
import com.ptl.pages.NewAdmissionPage;
import com.ptl.pages.TopMenu;
import com.ptl.util.TestUtil;

public class NewAdmissionTest extends TestBase{

	HomePage landingPage = null;

	@Test
	public void enterInmateCalasificationTest() {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		
		
		newAdmissionPage.doCreateNewAdmition();
	}

}
