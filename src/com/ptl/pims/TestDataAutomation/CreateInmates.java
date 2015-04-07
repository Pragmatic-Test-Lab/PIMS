package com.ptl.pims.TestDataAutomation;

import org.testng.annotations.Test;

import com.ptl.pims.pages.AuthorizeAdmissionPage;
import com.ptl.pims.pages.AuthorizeAdmissionSelectPage;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.testcases.TestBase;

public class CreateInmates extends TestBase {

	public String inmateCategory = "Convicted";
	public String inmateCourt = "Negombo";
	public String inmateName = "PTL Remission ";
	

	@Test
	public void createInmate() {

		loginToApplication();
		TopMenu topMenu = getTopMenu();
		NewAdmissionPage newAdmissionPage = topMenu.gotoNewAdmissionPage();
		CreateAdmissionPage createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		
		createNewAdmissionPage.doFillAllRequiredFileds(inmateCategory, inmateCourt, "25", "Diet", "Test Biometric", 
				inmateName + (tempNum++),	"FO", "male");
		
		createNewAdmissionPage.filleCourtDetailsTab("Colombo", "CASE001","2015-02-24", "2015-03-10");
		
		/*createNewAdmissionPage.filleHealthConditionTab(true,"Health Conditions Remarks", true, "Health of school", "Other",
				"Cough");
		createNewAdmissionPage.fillInmateComplaint("2015-02-10", "Health","Descriptions");
		createNewAdmissionPage.fillPrivatePropertiesTab("2015-02-18", "Phone","Descriptions", "1", "200.89");
		createNewAdmissionPage.fillInfantsPreschoolTab("Name hi", "2015-02-25");*/
		
		registrationNo = createNewAdmissionPage.getRegistrationNumber();		
		newAdmissionPage = createNewAdmissionPage.doAdmission();

	}


	@Test(dependsOnMethods = "createInmate")
	public void authorizeCreatedAdmission() {

		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = topMenu.gotoAuthorizeAdmissionPage();

		authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo,"", "");	
		AuthorizeAdmissionPage authorizeAdmissionPage =  authorizeAdmissionSelectPage.clickFirstInmate();
		
		authorizeAdmissionSelectPage = authorizeAdmissionPage.doAuthorizeAdmission();

	}

}
