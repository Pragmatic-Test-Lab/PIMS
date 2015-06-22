package com.ptl.pims.testcases.PostRegistration;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.PostRegistration.PostRegistrationPage;
import com.ptl.pims.pages.PostRegistration.UpdatePostRegistrationPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;

public class PostRegistrationTest extends TestBase{
	
	PostRegistrationPage postRegPage;
	UpdatePostRegistrationPage updatePostRegPage; 
	
	
	@Test									//PIMS-881, PIMS-
	public void SearchAnInmate() {		

		loginToApplication();

		postRegPage = getTopMenu().gotoPostRegistrationPage();
		assertTrue(postRegPage.getActualPageTitle().equals(postRegPage.getExpectedPageTitle()), "Could not get to Post Registration Page");	

		postRegPage.doSearch(registrationNo, "", "");
		updatePostRegPage = postRegPage.gotoUpdatePostRegistrationPage();	
	}
	
	@Test(dependsOnMethods="SearchAnInmate", dataProvider="getPostRegistrationData")
	public void fillPostRegistrationTabsTest(Hashtable<String, String> data){
		
		updatePostRegPage.EnterEducationalQualifications(data.get("Institues"), data.get("Qualification Types"), data.get("Languages"));
		
		updatePostRegPage.gotoEmploymentTab();
		APPLICATION_LOGS.debug("Go to the Employment tab");
		updatePostRegPage.EnterEmploymentData(data.get("Employers"), data.get("Organizational Types"), data.get("Positions"), 
				data.get("Dates From"), data.get("Dates To"));
		
		updatePostRegPage.gotoFamilyTab();
		updatePostRegPage.EnterFamilyData("Herath", "1111223", "212121212v", "31", "Spouse", "11223331212", "32000");		
		
		updatePostRegPage.gotoChildTab();
		APPLICATION_LOGS.debug("Clicked on the Child tab");
		updatePostRegPage.EnterChildData(data.get("Names"), data.get("Addresss"), data.get("Ages"), data.get("Schools"), data.get("Grades"));

	}
	
	@Test(dependsOnMethods="fillPostRegistrationTabsTest")
	public void submitPostRegistrationTest(){
		
		postRegPage = updatePostRegPage.ClickUpdateButton();
		assertTrue(postRegPage.successMessageAvaiable(), "Success message not found in Post Registration.");
	}
	
	
	@DataProvider
	public Object[][] getPostRegistrationData() {
		return TestUtil.getTestData("UpdatePostReg Test", xls);

	}





}
