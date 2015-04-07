package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;

public class AdmissionEditTest extends TestBase{

	EditAdmissionPage editAdmissionPage; 
	EditAdmissionSelectPage editAdmissionSelectPage;
		
	@Test
	public void GoToEditAdmissionPage(){
		
		loginToApplication();
		TopMenu topMenu = getTopMenu();
		editAdmissionSelectPage = topMenu.gotoEditAdmissionPage();
		
		editAdmissionSelectPage = editAdmissionSelectPage.doSearch(registrationNo,"","");
		editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
		
	}	
	
	@Test(dependsOnMethods = "GoToEditAdmissionPage", dataProvider = "getAdmissionData")
	public void validateSavedInmateData(Hashtable<String, String> data){
		
		if(data.get("Registration Number").equals(registrationNo)){		
			
		boolean admissionDataSaved = editAdmissionPage.checkAvailableData(data.get("Inmate Category"),data.get("Court"),data.get("Age"),
				data.get("Meal Type"),data.get("Biometric"),data.get("Name"),data.get("Classification"),data.get("Gender"));		
	   
		Assert.assertTrue(admissionDataSaved,"Data was not saved Properly.");		
		APPLICATION_LOGS.debug("Data has been saved properly");
		
	    Assert.assertTrue(editAdmissionPage.allPicturesSavedProperly(),"Default photos still available for inmate. Upload failed.");		
		APPLICATION_LOGS.debug("Pictures uploaded properly");
		}		
	}		
	
	@Test(dependsOnMethods = "GoToEditAdmissionPage", dataProvider = "getEditAdmissionData") // PIMS-1194
	public void Test_doEditAdmission(Hashtable<String, String> data){
		
		editAdmissionPage.doEditAdmition(data.get("Inmate Category"),data.get("Court"),data.get("Age"),
				data.get("Meal Type"),data.get("Biometric"),data.get("Name"),data.get("Classification"),data.get("Gender"));
		

		registrationNo = editAdmissionPage.getRegistrationNumber();		
	    
		//Saves New Inmate Reg Num to exel sheet
		int rowNum = xls.getCellRowNum("Inmate Admission - Mandatory", "RunMode", "Yes"); 
	    xls.setCellData("Inmate Admission - Mandatory", "Registration Number", rowNum , registrationNo);
		
		editAdmissionSelectPage = editAdmissionPage.clickUpdateButton();
		
		Assert.assertTrue(editAdmissionSelectPage.getSuccessMessage().matches(Constants.EditAdmission_SuccessMessageText), 
				"Editing Admission has failed");		

	}
	
	@DataProvider
	public Object[][] getAdmissionData() {
		return TestUtil.getTestData("Inmate Admission - Mandatory", xls);		
	}
	
	@DataProvider
	public Object[][] getEditAdmissionData() {
		return TestUtil.getTestData("Inmate Edit Admission", xls);		
	}

}
