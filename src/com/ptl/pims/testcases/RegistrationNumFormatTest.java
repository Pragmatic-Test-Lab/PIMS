package com.ptl.pims.testcases;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class RegistrationNumFormatTest extends TestBase{

		NewAdmissionPage newAdmissionPage;
		CreateAdmissionPage createNewAdmissionPage;

		@Test   
		public void goToNewAdmissionPage(){

				loginToApplication();		
				TopMenu topMenu = getTopMenu();
				newAdmissionPage = topMenu.gotoNewAdmissionPage();
			    createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
			    
				Assert.assertTrue(createNewAdmissionPage.getActualPageTitle().equals(Constants.NewAdmission_ExpectedPageHeader),
						"Could not go to new admission page.");		
		}	
		
		@Test(dependsOnMethods = "goToNewAdmissionPage", dataProvider = "getTestData") 
		public void TestRegNumFormata(Hashtable<String, String> data) {
			
			Assert.assertTrue(createNewAdmissionPage.checkNumberFormat(data.get("Category"), data.get("Case")));

		}

		
		@DataProvider
		public Object[][] getTestData() {
			return TestUtil.getTestData("Registration Number Format Data", xls);

		}


}
