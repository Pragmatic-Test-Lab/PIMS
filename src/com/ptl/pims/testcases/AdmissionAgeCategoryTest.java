package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.TestUtil;

public class AdmissionAgeCategoryTest extends TestBase {

	CreateAdmissionPage createAdmissionPage;

	@Test
	public void GoToCreateAdmission() {

		if (!TestUtil.isTestCaseRunmodeYes("CreateAdmission Test", xls)	)
			throw new SkipException("Skipping the Auto Selected Age Category test");

			HomePage landingPage = returnToHomePage();
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
			createAdmissionPage = newAdmissionPage.getCreateAdmissionPage();					
	}
	

	@Test(dataProvider = "getAgeCategoryData")
	public void ValidateAutoSelectedAgeCategory(Hashtable<String, String> data) {

			createAdmissionPage.addAge(data.get("Min Age"));		
			Assert.assertEquals(data.get("Category"), createAdmissionPage.getActualSelectedAgeCategory(),
					"Failed for minimum age of " + data.get("Category") + ". Genarated category is " + createAdmissionPage.getActualSelectedAgeCategory());
					
	}
	

	@DataProvider
	public Object[][] getAgeCategoryData() {
		return TestUtil.getTestData("Age Category Data", xls);

	}

}
