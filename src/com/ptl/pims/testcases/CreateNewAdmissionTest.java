package com.ptl.pims.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;


public class CreateNewAdmissionTest extends TestBase{

	NewAdmissionPage newAdmissionPage;
	CreateAdmissionPage createNewAdmissionPage;
	String RHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String Front_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";
	String LHS_Image_Path = System.getProperty("user.dir")+ "\\src\\images\\Format_PNG.png";

	@Test   
	public void goToNewAdmissionPage(){

			loginToApplication();		
			TopMenu topMenu = getTopMenu();
			newAdmissionPage = topMenu.gotoNewAdmissionPage();
		    createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
		    
			Assert.assertTrue(createNewAdmissionPage.getActualPageTitle().equals(Constants.NewAdmission_ExpectedPageHeader),
					"Could not go to new admission page.");		
	}	
	
	@Test(dependsOnMethods = "goToNewAdmissionPage")   // PIMS-898, PIMS-408, PIMS-869 
	public void TestFields() {
		    Assert.assertTrue(createNewAdmissionPage.checkMealTypeIsSelectable(), "Meal Type Is Not Selectable");
		    Assert.assertTrue(createNewAdmissionPage.checkIsInmateRegistrationNumberIsAutoGenarated(), "Failed at Auto Genarating of Registration number");
			Assert.assertTrue(createNewAdmissionPage.checkImateCatagoryIsSelectable(), "Inmate Catagory Is Not Selectable");		
	}
	
	@Test(dependsOnMethods = "TestFields")
	public void TestDoCreateNewAdmition(){
		
		createNewAdmissionPage.doFillAllRequiredFileds("Un-Convicted","Negombo","25","Diet","Test Biometric","PTL Remission","FO","male");
		//createNewAdmissionPage.addInmatePictures(RHS_Image_Path,Front_Image_Path, LHS_Image_Path);
		
		createNewAdmissionPage.filleCourtDetailsTab("Colombo","CASE001","2015-02-24", "2015-03-10");
		createNewAdmissionPage.filleHealthConditionTab(true,"Health Conditions Remarks",true,"Health of school","Other", "Cough");
		createNewAdmissionPage.fillInmateComplaint("2015-02-10","Health","Descriptios");
		createNewAdmissionPage.fillPrivatePropertiesTab("2015-02-18","Phone","Descriptions","1","200.89");
		createNewAdmissionPage.fillInfantsPreschoolTab("Name hi","2015-02-25");

		
		registrationNo = createNewAdmissionPage.getRegistrationNumber();		
	    newAdmissionPage = createNewAdmissionPage.doAdmission();	
	    
	    Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Failed to Create inmate with all the sub headings");		
		APPLICATION_LOGS.debug("Inmate successfully created with all the sub headings");

	}
	
	@Test(dependsOnMethods = "TestDoCreateNewAdmition")
	public void TestDataSavedProperly(){
		
		TopMenu topMenu = getTopMenu();
		EditAdmissionSelectPage editAdmissionSelectPage = topMenu.gotoEditAdmissionPage();
		
		editAdmissionSelectPage = editAdmissionSelectPage.doSearch(registrationNo,"","");
		EditAdmissionPage editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
		
		boolean savedProperly = editAdmissionPage.allMandatoryAdmissionDataSavedProperly("Un-Convicted","Negombo","25","Diet",
				"Test Biometric","Nimal Pathirana","FO","male");		
	    Assert.assertTrue(savedProperly,"Data was not saved Properly.");		
		APPLICATION_LOGS.debug("Data has been saved properly");
		
	    Assert.assertTrue(editAdmissionPage.allPicturesSavedProperly(),"Default photos still available for inmate. Upload failed.");		
		APPLICATION_LOGS.debug("Pictures uploaded properly");
		
	}
	}
