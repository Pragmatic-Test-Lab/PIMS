package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;

public class RegistrationNumFormatTest extends TestBase{

		NewAdmissionPage newAdmissionPage;
		CreateAdmissionPage createNewAdmissionPage;

		@Test
		// PIMS-18, PIMS-19
		public void Test_doEditAdmission(){

			HomePage landingPage = returnToHomePage();
			TopMenu topMenu = getTopMenu();
			newAdmissionPage = topMenu.gotoNewAdmissionPage();
			createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();

			Assert.assertTrue(createNewAdmissionPage.getActualPageTitle().equals(Constants.NewAdmission_ExpectedPageHeader),
					"Could not go to new admission page.");
			
			Assert.assertTrue(createNewAdmissionPage.checkNumberFormat("Baby", "Colombo"),
					"Failed for Baby and Colombo");
			Assert.assertTrue(createNewAdmissionPage.checkNumberFormat("Child", "Negombo"),
					"Failed for Child and Negombo");
			Assert.assertTrue(createNewAdmissionPage.checkNumberFormat("Convicted", "Colombo"),
					"Failed for Convicted and Colombo");
			Assert.assertTrue(createNewAdmissionPage.checkNumberFormat("Un-Convicted", "Negombo"),
					"Failed for Un-Convicted and Negombo");
			Assert.assertTrue(createNewAdmissionPage.checkNumberFormat("Youth", "Colombo"),
					"Failed for Youth and Colombo");
			
		}

}
