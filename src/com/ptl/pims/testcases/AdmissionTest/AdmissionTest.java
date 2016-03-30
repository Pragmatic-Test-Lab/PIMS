package com.ptl.pims.testcases.AdmissionTest;

import java.util.Hashtable;
import java.util.Random;

import com.ptl.pims.pages.Admission.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.TestUtil;


public class AdmissionTest extends TestBase {

    NewAdmissionPage newAdmissionPage;
    CreateAdmissionPage createNewAdmissionPage;

    String RHS_Image_Path = System.getProperty("user.dir") + "\\src\\images\\Format_PNG.png";
    String Front_Image_Path = System.getProperty("user.dir") + "\\src\\images\\Format_PNG.png";
    String LHS_Image_Path = System.getProperty("user.dir") + "\\src\\images\\Format_PNG.png";

    EditAdmissionPage editAdmissionPage;
    EditAdmissionSelectPage editAdmissionSelectPage;

    AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage;
    AuthorizeAdmissionPage authorizeAdmissionPage;

    @Test
    public void goToNewAdmissionPage() {

        loginToApplication();
        newAdmissionPage = getTopMenu().gotoNewAdmissionPage();
        createNewAdmissionPage = newAdmissionPage.getCreateAdmissionPage();
    }

    @Test(dependsOnMethods = "goToNewAdmissionPage", dataProvider = "getAdmissionData")
    public void createNewAdmission(Hashtable<String, String> data) {

        createNewAdmissionPage.fillRequiredFields(data.get("Inmate Category"), data.get("Court"), data.get("Age"),
                data.get("Meal Type"), data.get("Biometric") + " " + (new Random()).nextInt(5000), data.get("Name"), data.get("Classification"), data.get("Gender"));

        createNewAdmissionPage.addInmatePictures(RHS_Image_Path, Front_Image_Path, LHS_Image_Path);

        inmateCase = data.get("Case Court");
        createNewAdmissionPage.fillCourtDetailsTab(data.get("Case Court"), data.get("Case Number"), TestUtil.getTodaysDate(), TestUtil.getTodaysDate());

        createNewAdmissionPage.fillHealthConditionsTab(Boolean.valueOf("Is Pregnant"), data.get("Health Remarks"), Boolean.valueOf("Is Med Attention"
                + " for Preschooler"), data.get("PreSchooler Med Remark"), data.get("Drug"), data.get("Observation"));

        createNewAdmissionPage.fillInmateComplaintsTab(data.get("Complaint Date"), data.get("Complaint Type"), data.get("Complaint Description"));

        createNewAdmissionPage.fillPrivatePropertiesTab(TestUtil.getTodaysDate(), data.get("Private PItem"), data.get("Private PDescription"),
                data.get("Private PQuantity"));

        createNewAdmissionPage.fillInfantsPreschoolTab(data.get("Preschooler Name"), data.get("Preschooler DOB"));

        registrationNo = createNewAdmissionPage.getRegistrationNumber();
        newAdmissionPage = createNewAdmissionPage.submitAdmission();

        //Saves Created Inmate Reg Num to exel sheet
        int rowNum = xls.getCellRowNum("Inmate Admission - Mandatory", "RunMode", "Yes");
        xls.setCellData("Inmate Admission - Mandatory", "Registration Number", rowNum, registrationNo);
        //

        assertTrue(newAdmissionPage.successMessageAvaiable(), "Failed to find Admission Page Success Message");
    }

    @Test(dependsOnMethods = "createNewAdmission")
    public void goToEditAdmission() {

        loginToApplication();
        editAdmissionSelectPage = getTopMenu().gotoEditAdmissionPage();

        editAdmissionSelectPage = editAdmissionSelectPage.doSearch(registrationNo," "," ");
        editAdmissionPage =  editAdmissionSelectPage.clickFirstInmate();
    }

    @Test(dependsOnMethods = "goToEditAdmission", dataProvider = "getAdmissionData", priority = 1)
    public void validateAdmissionData(Hashtable<String, String> data){

        editAdmissionPage.checkSavedData(data.get("Inmate Category"),data.get("Court"),data.get("Age"),
                data.get("Meal Type"),data.get("Name"),data.get("Classification"),data.get("Gender"));
    }

    @Test(dependsOnMethods = "goToEditAdmission", dataProvider = "getEditAdmissionData", priority = 2) // PIMS-1194
    public void editAdmission(Hashtable<String, String> data){

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

    @Test(dependsOnMethods = "editAdmission")
    public void goTooAuthorizeAdmition() {

        loginToApplication();
        authorizeAdmissionSelectPage = getTopMenu().gotoAuthorizeAdmissionPage();

        authorizeAdmissionSelectPage = authorizeAdmissionSelectPage.doSearch(registrationNo, "", "");
        authorizeAdmissionPage = authorizeAdmissionSelectPage.clickFirstInmate();
    }

    @Test(dependsOnMethods = "goTooAuthorizeAdmition", dataProvider = "getEditAdmissionData", priority = 1, groups="AdmissionAuthorize")
    public void validateSavedInmateData(Hashtable<String, String> data) {

        authorizeAdmissionPage.checkSavedData(data.get("Inmate Category"), data.get("Court"),
                data.get("Age"), data.get("Meal Type"), data.get("Name"),data.get("Classification"),
                data.get("Gender"));
    }

    @Test(dependsOnMethods = "goTooAuthorizeAdmition", priority = 2)
    public void authorizeAdmission() {

        authorizeAdmissionSelectPage = authorizeAdmissionPage.doAuthorizeAdmission();
        assertTrue(authorizeAdmissionSelectPage.successMessageAvaiable(),"Failed to find Authorize Admission Page Success Message");
    }

    @DataProvider
    public Object[][] getAdmissionData() { return TestUtil.getTestData("Admission Data", xls); }

    @DataProvider
    public Object[][] getEditAdmissionData() {
        return TestUtil.getTestData("Inmate Edit Admission", xls);
    }


}
