package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.TestUtil;

public class AdmissionAgeCategoryTest extends TestBase {

	CreateAdmissionPage createAdmissionPage;

	@Test //PIMS-1190
	public void GoToCreateAdmission() {

			HomePage landingPage = returnToHomePage();
			TopMenu topMenu = getTopMenu();
			NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
			createAdmissionPage = newAdmissionPage.getCreateAdmissionPage();					
	}	

	@Test(dataProvider = "getAgeCategoryData")
	public void ValidateAutoSelectedAgeCategory(Hashtable<String, String> data) {

			createAdmissionPage.addAge(data.get("Age"));		
			Assert.assertEquals(createAdmissionPage.getActualSelectedAgeCategory(), data.get("Category"),
					"Failed for age of "+ data.get("Age") + "for " + data.get("Category") + ".");
				
	}
	

	@DataProvider
	public Object[][] getAgeCategoryData() {
		return TestUtil.getTestData("Age Category Data", xls);

	}

}
