package com.ptl.pims.testcases.AdmissionTest;

import java.util.Calendar;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.Admission.CreateAdmissionPage;
import com.ptl.pims.pages.Admission.NewAdmissionPage;
import com.ptl.pims.testcases.TestBase;
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
					"failed for age of "+ data.get("Age") + ".");
	}
	
	
	@Test(dependsOnMethods="GoToCreateAdmission",  dataProvider = "getRegNoData") 
	public void TestRegNumFormat(Hashtable<String, String> data) {

		String category = data.get("Category");
		String court = data.get("Case");
		int year = Calendar.getInstance().get(Calendar.YEAR);

		String registrationNum = createAdmissionPage.setCategoryAndCourt(category, court);

		String CourtId = "";
		if(court.equalsIgnoreCase("colombo court of appeal")) CourtId = " CM";
		if(court.equalsIgnoreCase("negombo high court"))	CourtId = "NHC";

		switch (category.toLowerCase()) {
			case "baby":
				assertTrue(registrationNum.matches("B/...../../" + CourtId + "/" + year), registrationNum + " did not match pattern B/...../../" + CourtId + "/" + year);
				break;
			case "child":
				assertTrue(registrationNum.matches("C/...../../" + CourtId + "/" + year), registrationNum + " did not match pattern C/...../../" + CourtId + "/" + year);
				break;
			case "convicted":
				assertTrue(registrationNum.matches("./...../" + year), registrationNum + " did not match pattern ./...../" + year);
				break;
			case "un-convicted":
				assertTrue(registrationNum.matches("...../../" + CourtId + "/" + year), registrationNum + " did not match pattern ...../../" + CourtId + "/" + year);
				break;
			case "youth":
				assertTrue(registrationNum.matches("Y/...../../" + CourtId + "/" + year), registrationNum + " did not match pattern Y/...../../" + CourtId + "/" + year);
				break;
		}

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
