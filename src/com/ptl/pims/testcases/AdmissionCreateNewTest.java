package com.ptl.pims.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.CreateAdmissionPage;
import com.ptl.pims.pages.EditAdmissionPage;
import com.ptl.pims.pages.EditAdmissionSelectPage;
import com.ptl.pims.pages.NewAdmissionPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.TestUtil;


public class AdmissionCreateNewTest extends TestBase{

	NewAdmissionPage newAdmissionPage;
	CreateAdmissionPage createNewAdmissionPage;
	EditAdmissionPage editAdmissionPage; 
	
	String InmateName = "Nimal Pathirana";
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
	
	@Test(dependsOnMethods = "goToNewAdmissionPage", dataProvider = "getMandatoryData")
	public void TestAddDataToMandatoryField(Hashtable<String, String> data){
		
		if(data.get("RunMode").equals("Yes")){
			createNewAdmissionPage.doFillAllRequiredFileds(data.get("Inmate Category"),data.get("Court"),data.get("Age"),
					data.get("Meal Type"),data.get("Biometric"),data.get("Name"),data.get("Classification"),data.get("Gender"));

			createNewAdmissionPage.addInmatePictures(RHS_Image_Path,Front_Image_Path, LHS_Image_Path);		
		}
	}
	
	@Test(dependsOnMethods = "TestAddDataToMandatoryField", dataProvider = "getTabData")
	public void TestAddDataToTabMandatoryField(Hashtable<String, String> data){
		
		if(data.get("RunMode for Court").equals("Yes"))
		createNewAdmissionPage.filleCourtDetailsTab(data.get("Case Court"),data.get("Case Number"),data.get("DOConviction"), data.get("DOSentence"));
		
		if(data.get("RunMode for Health").equals("Yes"))
		createNewAdmissionPage.filleHealthConditionTab(Boolean.valueOf("Is Pregnant"),data.get("Health Remarks"),Boolean.valueOf("Is Med Attention"
				+ " for Preschooler"),data.get("PreSchooler Med Remark"),data.get("Drug"), data.get("Observation"));
		
		if(data.get("RunMode for Complaint").equals("Yes"))
		createNewAdmissionPage.fillInmateComplaint(data.get("Complaint Date"),data.get("Complaint Type"),data.get("Complaint Description"));
		
		if(data.get("RunMode for PProperty").equals("Yes"))
		createNewAdmissionPage.fillPrivatePropertiesTab(data.get("Private PDate"),data.get("Private PItem"),data.get("Private PDescription"),
				data.get("Private PQuantity"),data.get("Private PValue"));
		
		if(data.get("RunMode for Child").equals("Yes"))
		createNewAdmissionPage.fillInfantsPreschoolTab(data.get("Preschooler Name"),data.get("Preschooler DOB"));

	}
	
	@Test(dependsOnMethods = "TestAddDataToMandatoryField", dataProvider="getMandatoryData")
	public void TestSubmitAdmissionForm(Hashtable<String, String> data){
		
		if(data.get("RunMode").equals("Yes")){
		registrationNo = createNewAdmissionPage.getRegistrationNumber();		
	    newAdmissionPage = createNewAdmissionPage.doAdmission();	    
	    
	    //Saves Created Inmate Reg Num to exel sheet	    
	    int rowNum = xls.getCellRowNum("Inmate Admission - Mandatory", "RunMode", "Yes");
	    xls.setCellData("Inmate Admission - Mandatory", "Registration Number", rowNum , registrationNo);
	    
	    Assert.assertTrue(newAdmissionPage.getSuccessMessage().matches(Constants.CreateAdmission_SuccessMessageText),"Failed to Create inmate with all the sub headings");		
		APPLICATION_LOGS.debug("Inmate successfully created with all the sub headings");
		}
	}	
	
	
	

	@DataProvider
	public Object[][] getMandatoryData() {
		return TestUtil.getTestData("Inmate Admission - Mandatory", xls);
		
	}
	@DataProvider
	public Object[][] getTabData() {
		return TestUtil.getTestData("Inmate Admission - Tab", xls);
		
	}
	
	}
