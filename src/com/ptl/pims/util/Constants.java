
package com.ptl.pims.util;

public class Constants {

	
		//Registration Page:
	
		//Personal Details Tab
		public static final String InmateRegistration_FirtstRow_EditButton = "//*[@id='w0']/table/tbody/tr[1]/td[7]/a/span";
		public static final String InmateRegistration_Personal_OtherName1 = "//*[@id='admission-adm_other_name1']";
		public static final String InmateRegistration_Personal_OtherName2 = "//*[@id='admission-adm_other_name2']";
		public static final String InmateRegistration_Personal_CallName1 = "//*[@id='admission-adm_call_name1']";
		public static final String InmateRegistration_Personal_CallName2 = "//*[@id='admission-adm_call_name2']";
		public static final String InmateRegistration_Personal_AddressLine1 = "//*[@id='admission-adm_address_line_1']";
		public static final String InmateRegistration_Personal_AddressLine2 = "//*[@id='admission-adm_address_line_2']";
		public static final String InmateRegistration_Personal_PostOffice = "//*[@id='admission-adm_delivery_post_office']";
		public static final String InmateRegistration_Personal_PostalCode = "//*[@id='admission-adm_address_postal_code']";
		public static final String InmateRegistration_Personal_Country = "//*[@id='admission-adm_address_country']";
		public static final String InmateRegistration_Personal_Province = "//*[@id='admission-adm_province_id']";
		public static final String InmateRegistration_Personal_District = "//*[@id='admission-adm_district_id']";
		public static final String InmateRegistration_Personal_DS = "//*[@id='admission-adm_ds_id']";
		public static final String InmateRegistration_Personal_GSDivision = "//*[@id='admission-adm_gn_devision_id']";
		public static final String InmateRegistration_Personal_City = "//*[@id='admission-adm_city_id']";
		public static final String InmateRegistration_Personal_PoliceDivision = "//*[@id='admission-adm_police_division_id']";
		public static final String InmateRegistration_Personal_Update = "//*[@id='w0']/div[2]/button";
		
	
		public static final String InmateRegistration_personal_tab = "";
		public static final String InmateRegistration_calssfication_tab = "";
		public static final String InmateRegistration_Header = "";
		
		public static final String InmateRegistration_Classifiaction_Gender = "";
		public static final String InmateRegistration_Classification_Pervious_Conviction = "";
		public static final String InmateRegistration_Classifiaction_Calssification = "";
		
		// paths
		public static String CONFIG_FILE_PATH = System.getProperty("user.dir") +
					 "\\src\\com\\ptl\\config\\config.properties";
		public static String EXCEL_Path = System.getProperty("user.dir") +
					 "\\src\\com\\ptl\\data\\TestData.xlsx";
		
		// Page Title
		public static final String landingPageTitle = "Home";

		// Login Page
		public static final String Login_username = "//*[@id='login-form-login']";
		public static final String Login_password = "//*[@id='login-form-password']";
		public static final String Login_login = "//*[@id='login-form']/button";

		public static final String Login_PasswordError = "//*[@id='login-form']/div[2]/div";
		public static final String Login_PasswordErrorText = "Invalid login or password";
		public static final String Loginline2 = "//*[@id='login-form-login']";
		public static final String Login_emptylogin = "";
		public static final String Login_passwordline2 = "//*[@id='login-form-password']";
		public static final String Login_emptyPassword = "";
		
		

		
		// Home Page
		public static final String Home_PageHeader = "html/body/div[2]/div[2]/div/div/h1";
		public static final String Home_PageHeaderText = "PRISON INFORMATION MANAGEMENT SYSTEM";
		public static final String Home_RegistrationLink = ".//*[@id='w1']/li[2]/a";
		public static final String Home_AllocateLocationLink = ".//*[text()='Allocate Location']";
		public static final String Home_PropertyManagementLink = ".//*[text()='Property Management']";	
		public static final String Home_PageHeader2 = "//*[@id='w2']/li[1]/a";
		public static final String Home_PageHeaderText2 = "Login";
		public static final String LogOutLink = "//*[@id='w1']/li[6]/a";

		// Top Menu Links
		public static final String TopMenu_PIMSTopLink = "//a[text()='PIMS']";
		public static final String TopMenu_AdmissionTopLink = "//*[text()='Admission']";
		public static final String TopMenu_NewAdmissionSubLink = "//*[text()='New Admission']";
		public static final String TopMenu_EditSubLink = "//*[text()='Edit']";
		public static final String TopMenu_AuthorizeSubLink = "//*[text()='Authorize']";
		public static final String TopMenu_RegistrationMainLink = "//*[text()='Registration ']";
		public static final String TopMenu_RegistrationSubLink = "//*[text()='Registation']";
		public static final String TopMenu_AllocateLocationSubLink = "//*[text()='Alocate Location']";
		public static final String TopMenu_PropertyManagementSubLink = "//*[text()='Property Magement']";
		public static final String TopMenu_AuthorizeRegistrationSubLink = "//a[contains(@href,'/registration-authorization')]";
		public static final String TopMenu_PostRegistrationMainLink = "//a[text()='Post Registration ']";
		public static final String TopMenu_PostRegistrationSubLink = "//a[text()='Post Registration']";
		public static final String TopMenu_AuthorizePostRegistrationSubLink = "//a[contains(@href,'/post-registration-authorization')]";		
		public static final String TopMenu_LogOut = "//*[text()='Logout (admin_wataraka)']";
		// Logout (admin_wataraka)

		// New Admission Page
		public static final String CreateAdmissionButton = "//a[text() = 'Create Admission']";

		// Create Admission Page
		public static final String CreateAdmission_InmateCategory = "//*[@id='admission-adm_inmate_category_id']";
		public static final String CreateAdmission_CourtWarant = "//*[@id='admission-adm_court_id']";
		public static final String CreateAdmission_AgeAdmission = "//*[@id='admission-age_at_admission']";
		public static final String CreateAdmission_AgeCategory = "//*[@id='admission-adm_age_category_id']";
		public static final String CreateAdmission_RegistrationNumber = "//*[@id='admission-adm_age_category_id']";
		public static final String CreateAdmission_DateAdmission = "//*[@id='admission-adm_date_of_admission']";
		public static final String CreateAdmission_MealType = "//*[@id='admission-adm_meal_type_id']";
		public static final String CreateAdmission_Biometric = "//*[@id='admission-adm_biometric_id']";
		public static final String CreateAdmission_NameWarrant = "//*[@id='admission-adm_name_as_in_warrant']";
		public static final String CreateAdmission_OccurenceClassification = "//*[@id='admission-adm_occurrence_classification_id']";
		public static final String CreateAdmission_Gender = ".//*[@id='admission-adm_gender_id']";
		public static final String CreateAdmission_CurrentPrisonInstitute = "//*[@id='admission-adm_current_prison_institute_id']";
		public static final String CreateAdmission_ImageRHSBrowse = "";
		public static final String CreateAdmission_ImageRHSRemove = "";
		public static final String CreateAdmission_ImageFrontBrowse = "";
		public static final String CreateAdmission_ImageFrontRemove = "";
		public static final String CreateAdmission_ImageLHSBrowse = "";
		public static final String CreateAdmission_ImageLHSRemove = "";
		public static final String CreateAdmission_InmateCaseDetailTab = "//*[@id='w7']/li[1]/a";
		public static final String CreateAdmission_InmateCaseDetail_AddNew = "//*[@id='w7-tab0']/div/div[2]/button";
		public static final String CreateAdmission_InmateCaseDetail_Court = "//*[@id='inmatecasedetails-1-icd_court_id']";
		public static final String CreateAdmission_InmateCaseDetail_CaseNumber = "//*[@id='inmatecasedetails-1-icd_case_number']";
		public static final String CreateAdmission_InmateCaseDetail_DateConviction = "//*[@id='inmatecasedetails-1-icd_date_of_conviction']";
		public static final String CreateAdmission_InmateCaseDetail_Action = "";
		public static final String CreateAdmission_HealthConditionTab = "//*[@id='w7']/li[2]/a";
		public static final String CreateAdmission_HealthCondition_AddNew = "//*[@id='w7-tab1']/div[1]/div[2]/button";
		public static final String CreateAdmission_HealthCondition_MedicalAttention = "//*[@id='healthcondition-1-hco_is_medical_attention_needed']";
		public static final String CreateAdmission_HealthCondition_Pregnant = "//*[@id='healthcondition-1-hco_is_pregnant']";
		public static final String CreateAdmission_HealthCondition_Remarks = "//*[@id='healthcondition-1-hco_remarks']";
		public static final String CreateAdmission_HealthCondition_ForPreschool = "//*[@id='healthcondition-1-hco_is_medical_attention_needed_for__preschool']";
		public static final String CreateAdmission_HealthCondition_OfPreschool = "//*[@id='healthcondition-1-hco_helth_condition_of_preschool']";
		public static final String CreateAdmission_HealthCondition_Action = "//*[@id='health_condition_row_1']/td[8]/a/span";
		public static final String CreateAdmission_InmateComplainTab = "//*[@id='w7']/li[3]/a";
		public static final String CreateAdmission_PrivatePropertiesTab = "//*[@id='w7']/li[3]/a";
		public static final String CreateAdmission_InfantsPreschoolTab = "//*[@id='w7']/li[5]/a";
		public static final String CreateAdmission_HistoryTab = "//*[@id='w7']/li[6]/a";

		// Allocate Location Page
		public static final String AllocateLocation_Header = ".//div[contains(@class, 'admission-index')]/h1";
		public static final String AllocateLocation_ExpectedHeader = "Allocate Location";
		public static final String AllocateLocation_RegNoSearchField = "(.//*[@id='w0-filters']//input)[1]";
		public static final String AllocateLocation_BiometricSearchField = "(.//*[@id='w0-filters']//input)[2]";
		public static final String AllocateLocation_NameSearchField = "(.//*[@id='w0-filters']//input)[3]";
		public static final String AllocateLocation_OtherName1SearchField = "(.//*[@id='w0-filters']//input)[4]";
		public static final String AllocateLocation_LocationSearchField = "(.//*[@id='w0-filters']//input)[5]";
		public static final String AllocateLocation_TableFirstInmate_RegNo = ".//*[@id='w0']//tr[1]/td[2]";
		public static final String AllocateLocation_TableFirstInmate_Name = ".//*[@id='w0']//tr[1]/td[4]";
		public static final String AllocateLocation_TableFirstInmate_Location = ".//*[@id='w0']//tr[1]/td[6]";
		public static final String AllocateLocation_TableFirstLink = "(.//*[@id='w0']//td[7]//a)[1]";
		public static final String AllocateLocation_RegistrationNo = ".//*[@id='admission-adm_registration_no']";
		public static final String AllocateLocation_InmateName = ".//*[@id='admission-adm_name_as_in_warrant']";
		public static final String AllocateLocation_LocationDropdown = ".//*[@id='admission-adm_current_permenent_location_id']";
		public static final String AllocateLocation_SaveLocation = ".//*[text()='Save']";

		// Property Management Page
		public static final String PropertyManagement_Header = "";
		public static final String PropertyManagement_ExpectedHeader = "";
		public static final String PropertyManagement_RegNoSearchField = "(.//*[@id='w0-filters']//input)[1]";
		public static final String PropertyManagement_BiometricSearchField = "(.//*[@id='w0-filters']//input)[2]";
		public static final String PropertyManagement_NameSearchField = "(.//*[@id='w0-filters']//input)[3]";
		public static final String PropertyManagement_OtherName1SearchField = "(.//*[@id='w0-filters']//input)[4]";
		public static final String PropertyManagement_TableFirstLink = "(.//*[@id='w0']//td[7]//a)[1]";
			
		
		//Private Property Tab
		public static final String PropertyManagement_PrivatePropTab = "";
		public static final String PropertyManagement_Private_Date = "";
		public static final String PropertyManagement_Private_Item = "";
		public static final String PropertyManagement_Private_Description = "";
		public static final String PropertyManagement_Private_Quantity = "";
		public static final String PropertyManagement_Private_Value = "";
		//Prison Property Tab
		public static final String PropertyManagement_PrisonPropTab = "";
		public static final String PropertyManagement_Prison_Date = "";
		public static final String PropertyManagement_Prison_Item = "";
		public static final String PropertyManagement_Prison_Description = "";
		public static final String PropertyManagement_Prison_Quantity = "";
		public static final String PropertyManagement_Prison_Value = "";
		
		
		//Post Registration Page
		public static final String PostRegistration_PageTitle = "//h1[text()='Post Registration']";
		public static final String PostRegistration_PageTitleText = "Post Registration";
		public static final String PostRegistration_FirstUpdateIcon = "(.//a[@title='Update']/span)[1]";
		
		
		
		//Update Post Registration Page
		public static final String UpdatePostRegistration_CheckBox = "//*[@id='admission-adm_is_attended_to_orientation_programe']";
		public static final String UpdatePostRegistration_CurrentPrisonInstitute = "//*[@id='admission-adm_current_prison_institute_id']";
		public static final String UpdatePostRegistration_PhotoRightBrowse = "//*[@id='admission-image_rhs']";
		public static final String UpdatePostRegistration_PhotoFrontBrowse = "//*[@id='admission-image_front']";
		public static final String UpdatePostRegistration_PhotoLeftBrowse = "//*[@id='admission-image_lhs']";		
		public static final String UpdatePostRegistration_EducationalQualificationTab = "//a[text()='Educational Qualifications']";
		public static final String UpdatePostRegistration_EducationalQualificationTabStatus = "true";
		public static final String UpdatePostRegistration_EducationalQualificationAddNew = "(.//button[text()='Add New'])[1]";
		public static final String UpdatePostRegistration_Institute = "//*[@id='educationalqualification-1-equ_institute']";
		public static final String UpdatePostRegistration_QualificationType = "//*[@id='educationalqualification-1-equ_qulification_type_id']";
		public static final String UpdatePostRegistration_Language = "//*[@id='educationalqualification-1-equ_language_id']";
		public static final String UpdatePostRegistration_EducationalQualificationAction = "//a[contains(@onclick,'removeeducational')]";
		public static final String UpdatePostRegistration_EmploymentTab = "//a[text()='Employment']";		
		public static final String UpdatePostRegistration_EmploymentAddNew = "(.//button[text()='Add New'])[2]";
		public static final String UpdatePostRegistration_Employer = "//*[@id='employment-0-emp_employer']";
		public static final String UpdatePostRegistration_OrganizationalType = "//*[@id='employment-0-emp_organizational_type_id']";
		public static final String UpdatePostRegistration_Position = "//*[@id='employment-0-emp_position']";
		public static final String UpdatePostRegistration_DateFrom = "//*[@id='employment-0-emp_date_from']";
		public static final String UpdatePostRegistration_DateTo = "//*[@id='employment-0-emp_date_to']";
		public static final String UpdatePostRegistration_EmploymentAction = "//a[contains(@onclick,'removeemployment')]";
		public static final String UpdatePostRegistration_FamilyTab = "//a[text()='Family Data']";		
		public static final String UpdatePostRegistration_FamilyAddNew = "(.//button[text()='Add New'])[3]";
		public static final String UpdatePostRegistration_Name = "//*[@id='familydata-1-fda_name']";
		public static final String UpdatePostRegistration_Address1 = "//*[@id='familydata-1-fda_address_line1']";
		public static final String UpdatePostRegistration_Address2 = "//*[@id='familydata-1-fda_address_line2']";
		public static final String UpdatePostRegistration_Address3 = "//*[@id='familydata-1-fda_address_line3']";
		public static final String UpdatePostRegistration_NIC = "//*[@id='familydata-1-fda_nic']";
		public static final String UpdatePostRegistration_Age = "//*[@id='familydata-1-fda_age']";
		public static final String UpdatePostRegistration_Relationship = "//*[@id='familydata-1-fda_relationship_id']";		
		public static final String UpdatePostRegistration_Telephone = "//*[@id='familydata-1-fda_telephone']";
		public static final String UpdatePostRegistration_Income = "//*[@id='familydata-1-fda_income']";
		public static final String UpdatePostRegistration_FamilyAction = "//a[contains(@onclick,'removefamily')]";
		public static final String UpdatePostRegistration_ChildTab = "//a[text()='Child Data']";
		public static final String UpdatePostRegistration_ChildAddNew = "(.//button[text()='Add New'])[4]";
		public static final String UpdatePostRegistration_ChildName = "//*[@id='childdata-1-cda_name']";
		public static final String UpdatePostRegistration_ChildAddress1 = "//*[@id='childdata-1-cda_address_line1']";
		public static final String UpdatePostRegistration_ChildAddress2 = "//*[@id='childdata-1-cda_address_line2']";
		public static final String UpdatePostRegistration_ChildAddress3 = "//*[@id='childdata-1-cda_address_line3']";
		public static final String UpdatePostRegistration_ChildAge = "//*[@id='childdata-1-cda_age']";
		public static final String UpdatePostRegistration_ChildSchool = "//*[@id='childdata-1-cda_school']";
		public static final String UpdatePostRegistration_ChildGrade = "//*[@id='childdata-1-cda_grade']";
		public static final String UpdatePostRegistration_ChildSchoolAddress1 = "//*[@id='childdata-1-cda_school_address_line1']";
		public static final String UpdatePostRegistration_ChildSchoolAddress2 = "//*[@id='childdata-1-cda_school_address_line2']";
		public static final String UpdatePostRegistration_ChildSchoolAddress3 = "//*[@id='childdata-1-cda_school_address_line3']";
		public static final String UpdatePostRegistration_ChildAction = "//a[contains(@onclick,'removechild')]";
		
		public static final String UpdatePostRegistration_Update = "//button[text()='Update']";
		

}









