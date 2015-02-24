package com.ptl.pims.testcases;

import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;


public class NewAdmissionTest extends TestBase{

	HomePage landingPage = null;

	@Test
	public void createNewAdmissionTest() throws InterruptedException {
		landingPage = returnToHomePage();		
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		newAdmissionPage.doCreateNewAdmition();
	}
	
	

}
