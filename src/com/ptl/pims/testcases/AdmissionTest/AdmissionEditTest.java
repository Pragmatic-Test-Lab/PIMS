package com.ptl.pims.testcases.AdmissionTest;

import java.util.Hashtable;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Admission.EditAdmissionPage;
import com.ptl.pims.pages.Admission.EditAdmissionSelectPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;

public class AdmissionEditTest extends TestBase{

	EditAdmissionPage editAdmissionPage; 
	EditAdmissionSelectPage editAdmissionSelectPage;
		
	@Test
	public void GoToEditAdmissionPage(){
			
		loginToApplication();
		editAdmissionSelectPage = getTopMenu().gotoEditAdmissionPage();
		
		editAdmissionSelectPage = editAdmissionSelectPage.doSearch(registrationNo,"","");
		editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
		
	}	
	
	@Test(dependsOnMethods = "GoToEditAdmissionPage", dataProvider = "getAdmissionData", priority = 1)
	public void validateSavedInmateData(Hashtable<String, String> data){
			
		boolean admissionDataSaved = editAdmissionPage.checkAvailableData(data.get("Inmate Category"),data.get("Court"),data.get("Age"),
				data.get("Meal Type"),data.get("Name"),data.get("Classification"),data.get("Gender"));		

		assertTrue(admissionDataSaved,"Data was not saved Properly. Saving Screenshot");		
	}		
	


	@Test(dependsOnMethods = "GoToEditAdmissionPage", dataProvider = "getEditAdmissionData", priority = 2) // PIMS-1194
	public void TestDoEditAdmission(Hashtable<String, String> data){
		
		editAdmissionPage.doEditAdmition(data.get("Inmate Category"),data.get("Court"),data.get("Age"),
				data.get("Meal Type"),data.get("Biometric") + " " + (new Random()).nextInt(5000),data.get("Name"),data.get("Classification"),data.get("Gender"));		

		registrationNo = editAdmissionPage.getRegistrationNumber();		
	    
		//Saves New Inmate Reg Num to exel sheet
		int rowNum = xls.getCellRowNum("Inmate Admission - Mandatory", "RunMode", "Yes"); 
	    xls.setCellData("Inmate Admission - Mandatory", "Registration Number", rowNum , registrationNo);
		
		editAdmissionSelectPage = editAdmissionPage.clickUpdateButton();
		
		assertTrue(editAdmissionSelectPage.successMessageAvaiable(), 
				"success Message unavailable in Edit Admission.");		

	}
	
	@DataProvider
	public Object[][] getAdmissionData() {
		return TestUtil.getTestData("Admission Data", xls);		
	}
	
	@DataProvider
	public Object[][] getEditAdmissionData() {
		return TestUtil.getTestData("Inmate Edit Admission", xls);		
	}

}
