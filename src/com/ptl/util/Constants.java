package com.ptl.util;

public class Constants {

	// paths
	public static String CONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\com\\ptl\\config\\config.properties";
	public static String EXCEL_Path = System.getProperty("user.dir")
			+ "\\src\\com\\ptl\\data\\TestData.xlsx";

	// Page Title
	public static final String landingPageTitle = "Home";

	// Login Page
	public static final String username = "//*[@id='login-form-login']";
	public static final String password = "//*[@id='login-form-password']";
	public static final String login = "//*[@id='login-form']/button";
	
	
	//Home Page
	public static final String Home_PageHeader = "//img[contains(@alt, 'placeholder image')]/ancestor::div[1]/h1";
	public static final String Home_PageHeaderText = "Prison Information Management System";
	
	
	// Top Menu Links
	public static final String PIMSTopLink = "//a[text()='PIMS']";
	public static final String AdmissionTopLink = "//*[text()='Admission ']";
	public static final String NewAdmissionSubLink = "//*[text()='New Admission']";
	public static final String EditSubLink ="//*[text()='Edit']";	
	public static final String AuthorizeSubLink="//*[text()='Authorize']";	
	public static final String RegistrationMainLink = "//*[text()='Registration ']";
	public static final String RegistrationSubLink = "//*[text()='Registation']";
	public static final String AllocateLocationSubLink = "//*[text()='Alocate Location']";
	public static final String PropertyManagementSubLink = "//*[text()='Property Magement']";
	public static final String AuthorizeRegistrationSubLink = "//a[contains(@href,'/registration-authorization')]";
	public static final String PostRegistrationMainLink = "//a[text()='Post Registration ']";
	public static final String PostRegistrationSubLink = "//a[text()='Post Registration']";
	public static final String AuthorizePostRegistrationSubLink = "//a[contains(@href,'/post-registration-authorization')]";
	public static final String LogOut = "//*[text()='Logout (admin)']";
	
	
	//New Admission Page
	public static final String CreateAdmissionButton = "//a[text() = 'Create Admission']";
	
	
	//Create Admission Page
	public static final String CreateAdmission_InmateCategory = "";
	public static final String CreateAdmission_CourtWarant = "";
	public static final String CreateAdmission_AgeAdmission = "";
	public static final String CreateAdmission_AgeCategory = "";
	public static final String CreateAdmission_RegistrationNumber = "";
	public static final String CreateAdmission_DateAdmission = "";
	public static final String CreateAdmission_MealType = "";
	public static final String CreateAdmission_Biometric = "";
	public static final String CreateAdmission_NameWarrant = "";
	public static final String CreateAdmission_OccurenceClassification = "";
	public static final String CreateAdmission_Gender = "";
	public static final String CreateAdmission_CurrentPrisonInstitute = "";
	public static final String CreateAdmission_ImageRHSBrowse = "";
	public static final String CreateAdmission_ImageRHSRemove = "";
	public static final String CreateAdmission_ImageFrontBrowse = "";
	public static final String CreateAdmission_ImageFrontRemove = "";
	public static final String CreateAdmission_ImageLHSBrowse = "";
	public static final String CreateAdmission_ImageLHSRemove = "";
	public static final String CreateAdmission_InmateCaseDetailTab = "";
	public static final String CreateAdmission_InmateCaseDetail_AddNew = "";
	public static final String CreateAdmission_InmateCaseDetail_Court = "";
	public static final String CreateAdmission_InmateCaseDetail_CaseNumber = "";
	public static final String CreateAdmission_InmateCaseDetail_DateConviction = "";
	public static final String CreateAdmission_InmateCaseDetail_Action = "";	
	public static final String CreateAdmission_HealthConditionTab  = "";
	public static final String CreateAdmission_HealthCondition_AddNew  = "";
	public static final String CreateAdmission_HealthCondition_MedicalAttention  = "";
	public static final String CreateAdmission_HealthCondition_Pregnant  = "";
	public static final String CreateAdmission_HealthCondition_Remarks  = "";
	public static final String CreateAdmission_HealthCondition_ForPreschool  = "";
	public static final String CreateAdmission_HealthCondition_OfPreschool  = "";
	public static final String CreateAdmission_HealthCondition_Action = "";
	public static final String CreateAdmission_InmateComplainTab = "";
	public static final String CreateAdmission_PrivatePropertiesTab = "";
	public static final String CreateAdmission_InfantsPreschoolTab = "";
	public static final String CreateAdmission_HistoryTab = "";
	
	
}
