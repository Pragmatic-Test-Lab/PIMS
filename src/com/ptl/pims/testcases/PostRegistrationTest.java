package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.PostRegistrationPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.pages.UpdatePostRegistrationPage;
import com.ptl.pims.util.TestUtil;

public class PostRegistrationTest extends TestBase{
	
	PostRegistrationPage postRegPage;
	UpdatePostRegistrationPage updatePostRegPage; 
	
	
	@Test									//PIMS-881, PIMS-
	public void SearchAnInmate() {		

		if (!TestUtil.isTestCaseRunmodeYes("PostReg Test", xls))
			throw new SkipException("Skipping the test");

		loginToApplication();
		TopMenu topMenu = getTopMenu();

		postRegPage = topMenu.gotoPostRegistrationPage();
		Assert.assertEquals(postRegPage.getActualPageTitle(), postRegPage.getExpectedPageTitle(), "Could not get to Post Registration Page");	
		APPLICATION_LOGS.debug("Going to the Post Registration Page");

		postRegPage.doSearch(registrationNo, "", "", "");
		APPLICATION_LOGS.debug("Search an inmate");
		updatePostRegPage = postRegPage.gotoUpdatePostRegistrationPage();
		APPLICATION_LOGS.debug("Reached Update Post Registration User Page");	
		
	}
	
	@Test(dependsOnMethods="SearchAnInmate", dataProvider="getPostRegistrationData")
	public void fillPostRegistrationTabsTest(Hashtable<String, String> data){
		
		updatePostRegPage.EnterEducationalQualifications(data.get("Institues"), data.get("Qualification Types"), data.get("Languages"));
			
		updatePostRegPage.gotoEmploymentTab();
		APPLICATION_LOGS.debug("Go to the Employment tab");
		updatePostRegPage.EnterEmploymentData(data.get("Employers"), data.get("Organizational Types"), data.get("Positions"), 
				data.get("Dates From"), data.get("Dates To"));
		
		updatePostRegPage.gotoChildTab();
		APPLICATION_LOGS.debug("Clicked on the Child tab");
		updatePostRegPage.EnterChildData(data.get("Names"), data.get("Addresss"), data.get("Ages"), data.get("Schools"), data.get("Grades"));
		
	}
	
	@Test(dependsOnMethods="fillPostRegistrationTabsTest")
	public void submitPostRegistrationTest(){
		
		postRegPage = updatePostRegPage.ClickUpdateButton();
		APPLICATION_LOGS.debug("Actual Message: "+ postRegPage.getActualSuccessMessage());	
	}
	
	
	@DataProvider
	public Object[][] getPostRegistrationData() {
		return TestUtil.getTestData("UpdatePostReg Test", xls);

	}





}
