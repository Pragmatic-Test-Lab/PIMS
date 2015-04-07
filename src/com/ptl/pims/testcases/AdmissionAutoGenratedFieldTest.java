package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.TestUtil;

public class AdmissionAutoGenratedFieldTest extends TestBase {

	CreateAdmissionPage createAdmissionPage;

	@Test //PIMS-1190
	public void GoToCreateAdmission() {

			loginToApplication();
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
			createAdmissionPage = newAdmissionPage.getCreateAdmissionPage();					
	}	

	@Test(dependsOnMethods="GoToCreateAdmission", dataProvider = "getAgeCategoryData")
	public void ValidateAutoSelectedAgeCategory(Hashtable<String, String> data) {

			createAdmissionPage.addAge(data.get("Age"));		
			Assert.assertEquals(createAdmissionPage.getActualSelectedAgeCategory(), data.get("Category"),
					"Failed for age of "+ data.get("Age") + ".");				
	}
	
	
	@Test(dependsOnMethods="GoToCreateAdmission",  dataProvider = "getRegNoData") 
	public void TestRegNumFormat(Hashtable<String, String> data) {
		
		Assert.assertTrue(createAdmissionPage.checkNumberFormat(data.get("Category"), data.get("Case")));

	}

	
	@DataProvider
	public Object[][] getRegNoData() {
		return TestUtil.getTestData("Registration Number Format Data", xls);

	}

	@DataProvider
	public Object[][] getAgeCategoryData() {
		return TestUtil.getTestData("Age Category Data", xls);

	}

}
