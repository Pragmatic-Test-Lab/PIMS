package com.ptl.pims.testcases.AdmissionTest;

import java.util.Hashtable;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.pages.Admission.CreateAdmissionPage;
import com.ptl.pims.pages.Admission.EditAdmissionPage;
import com.ptl.pims.pages.Admission.NewAdmissionPage;
import com.ptl.pims.testcases.TestBase;
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
		newAdmissionPage = getTopMenu().gotoNewAdmissionPage();
		createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
	}	
	
	@Test(dependsOnMethods = "goToNewAdmissionPage", dataProvider = "getAdmissionData")
	public void fillAdmissionData(Hashtable<String, String> data){

			createNewAdmissionPage.doFillAllRequiredFileds(data.get("Inmate Category"),data.get("Court"),data.get("Age"),
					data.get("Meal Type"),data.get("Biometric") + " " + (new Random()).nextInt(5000),data.get("Name"),data.get("Classification"),data.get("Gender"));

			createNewAdmissionPage.addInmatePictures(RHS_Image_Path,Front_Image_Path, LHS_Image_Path);	
			
			inmateCase = data.get("Case Court");
			createNewAdmissionPage.filleCourtDetailsTab(data.get("Case Court"),data.get("Case Number"),TestUtil.getTodaysDate(), TestUtil.getTodaysDate());
			
			createNewAdmissionPage.filleHealthConditionTab(Boolean.valueOf("Is Pregnant"),data.get("Health Remarks"),Boolean.valueOf("Is Med Attention"
					+ " for Preschooler"),data.get("PreSchooler Med Remark"),data.get("Drug"), data.get("Observation"));
			
			createNewAdmissionPage.fillInmateComplaint(data.get("Complaint Date"),data.get("Complaint Type"),data.get("Complaint Description"));
			
			createNewAdmissionPage.fillPrivatePropertiesTab(data.get("Private PDate"),data.get("Private PItem"),data.get("Private PDescription"),
					data.get("Private PQuantity"),data.get("Private PValue"));
			
			createNewAdmissionPage.fillInfantsPreschoolTab(data.get("Preschooler Name"),data.get("Preschooler DOB"));			

	}

	
	@Test(dependsOnMethods = "fillAdmissionData", dataProvider="getAdmissionData")
	public void SubmitAdmission(Hashtable<String, String> data){
		
		registrationNo = createNewAdmissionPage.getRegistrationNumber();		
	    newAdmissionPage = createNewAdmissionPage.doAdmission();	    
	    
	    //Saves Created Inmate Reg Num to exel sheet	    
	    int rowNum = xls.getCellRowNum("Inmate Admission - Mandatory", "RunMode", "Yes");
	    xls.setCellData("Inmate Admission - Mandatory", "Registration Number", rowNum , registrationNo);
	    //
	    
	    assertTrue(newAdmissionPage.successMessageAvaiable(),"Failed to find Admission Page Success Message");		
		
	}		
	

	@DataProvider
	public Object[][] getAdmissionData() {
		return TestUtil.getTestData("Admission Data", xls);
		
	}

	
	}
