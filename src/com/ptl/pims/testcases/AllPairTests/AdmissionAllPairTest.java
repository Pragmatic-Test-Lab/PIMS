package com.ptl.pims.testcases.AllPairTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.Admission.CreateAdmissionPage;
import com.ptl.pims.pages.Admission.NewAdmissionPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AdmissionAllPairTest extends TestBase {

	TopMenu topMenu;

	@Test
	public void loginToSystem() {

		loginToApplication();
		topMenu = getTopMenu();
	}

	@Test(dependsOnMethods = "loginToSystem", dataProvider = "getAllPairData")
	public void createAdmissions(Hashtable<String, String> data) {

		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		CreateAdmissionPage creAdmissionPage = newAdmissionPage
				.getCreateAdmissionPage();

		creAdmissionPage.fillRequiredFields(data.get("Type of User"),
				data.get("Location"), data.get("Age"), data.get("meal"),
				TestUtil.getRandomString(8), TestUtil.getRandomString(16) , data.get("Classification"),
				data.get("Gender"));
		newAdmissionPage = creAdmissionPage.submitAdmission();

		Assert.assertTrue(newAdmissionPage.successMessageAvaiable(),
				"Failed to create inmate with data : " + data.get("Type of User") + ", " + data.get("Location") + ", " + data.get("Age") + ", "
						+ data.get("meal") + ", " + data.get("Classification") + ", " + data.get("Gender"));

		APPLICATION_LOGS.debug("Completed Test No : " + data.get("Test Number"));
	}

	@DataProvider
	public Object[][] getAllPairData() {
		return TestUtil.getTestData("Admission All Pair Values", xls);

	}

}
