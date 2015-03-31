package com.ptl.pims.util;

public class Constants {

	// paths
	public static String CONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\com\\ptl\\config\\config.properties";
	public static String EXCEL_Path = System.getProperty("user.dir")
			+ "\\src\\com\\ptl\\data\\TestData.xlsx";

	// Login Page
	public static final String Login_username = "//*[@id='login-form-login']";
	public static final String Login_password = "//*[@id='login-form-password']";
	public static final String Login_login = "//*[@id='login-form']/button";
	public static final String Login_ExpectedTitle = "Sign in";
	public static final String Login_PasswordError = "//*[text()='Password']/following::div[1]";
	public static final String Login_PasswordErrorText = "Invalid login or password";
	public static final String Loginline2 = "//*[@id='login-form-login']";
	public static final String Login_passwordline2 = "//*[@id='login-form-password']";

	// Home Page
	public static final String Home_PageHeader = ".//h1[@style='font-family:quicksandregular']";
	public static final String Home_PageHeaderText = "PRISON INFORMATION MANAGEMENT SYSTEM";


	// Top Menu Links
	public static final String TopMenu_PIMSTopLink = "//a[text()='PIMS']";
	public static final String TopMenu_RegistrationManagementTopLink = "//a[contains(text(),'Registration Management')]";
	public static final String TopMenu_RegistrationManagement_AdmissionTopLink = "//*[text() = 'Admission']";
	public static final String TopMenu_NewAdmissionSubLink = "//*[text()='New Admission']";
	public static final String TopMenu_EditSubLink = "//*[text()='Edit']";
	public static final String TopMenu_AuthorizeSubLink = "//*[text()='Authorize']";
	public static final String TopMenu_RegistrationManagement_RegistrationTopLink = "//*[text() = 'Registration']";
	public static final String TopMenu_RegistrationSubLink = "(.//*[text()='Registration'])[2]";
	public static final String TopMenu_AllocateLocationSubLink = "//*[text()='Allocate Location']";
	public static final String TopMenu_PropertyManagementSubLink = "//*[text()='Property Management']";
	public static final String TopMenu_AuthorizeRegistrationSubLink = "//a[contains(@href,'/registration-authorization')]";
	public static final String TopMenu_RegistrationManagement_PostRegistrationTopLink = "//a[text() = 'Post Registration']";
	public static final String TopMenu_PostRegistrationSubLink = "//a[text()='Post Registration']";
	public static final String TopMenu_AuthorizePostRegistrationSubLink = "//a[contains(@href,'/post-registration-authorization')]";
	public static final String TopMenu_LogOut = "//a[contains(text(),'Logout')]";

	//
	// New Admission Page
	//
	public static final String CreateAdmissionButton = "//a[text() = 'Create Admission']";
	public static final String NewAdmissionHeder = "//*[@class='admission-create']/h1";
	public static final String NewAdmission_ExpectedPageHeader = "Create Admission";
	public static final String CreateAdmission_SuccessMessageText = "Created .* successfully";
	// New Admission Main Details
	public static final String CreateAdmission_InmateCategory = "//*[@id='admission-adm_inmate_category_id']";
	public static final String CreateAdmission_CourtWarant = "//*[@id='admission-adm_court_id']";
	public static final String CreateAdmission_AgeAdmission = "//*[@id='admission-age_at_admission']";
	public static final String CreateAdmission_AgeCategory = "//*[@id='admission-adm_age_category_id']";
	public static final String AgeCatagoryOptionFirstPart = ".//*[@id='admission-adm_age_category_id']/option[@value='";
	public static final String AgeCatagoryOptionLastPart = "']";
	public static final String CreateAdmission_RegistrationNumber = "//*[@id='admission-adm_registration_no']";
	public static final String CreateAdmission_DateAdmission = "//*[@id='admission-adm_date_of_admission']";
	public static final String CreateAdmission_DateAdmission_MonthBackSelect = ".//*[@class='prev']";
	public static final String CreateAdmission_MealType = "//*[@id='admission-adm_meal_type_id']";
	public static final String CreateAdmission_Biometric = "//*[@id='admission-adm_biometric_id']";
	public static final String CreateAdmission_NameWarrant = "//*[@id='admission-adm_name_as_in_warrant']";
	public static final String CreateAdmission_OccurenceClassification = "//*[@id='admission-adm_occurrence_classification_id']";
	public static final String CreateAdmission_Gender = "//*[@id='admission-adm_gender_id']";
	public static final String CreateAdmission_CurrentPrisonInstitute = "//*[@id='admission-adm_current_prison_institute_id']";
	public static final String CreateAdmission_ImageRHSBrowse = "//*[@id='admission-image_rhs']";
	public static final String CreateAdmission_ImageFrontBrowse = "//*[@id='admission-image_front']";
	public static final String CreateAdmission_ImageLHSBrowse = "//*[@id='admission-image_lhs']";
	// New Admission Court Details
	public static final String CreateAdmission_InmateCourtDetailTab = "//a[text() = 'Court Detail']";
	public static final String CreateAdmission_InmateCourtDetail_AddNew = "(.//button[text()='Add New'])[1]";
	public static final String CreateAdmission_InmateCourtDetail_Court = "(//select[contains(@name, 'icd_court_id')])[1]";
	public static final String CreateAdmission_InmateCourtDetail_CaseNumber = "(//input[contains(@name, 'icd_case_number')])[1]";
	public static final String CreateAdmission_InmateCourtDetail_DateConviction = "(//input[contains(@name, 'icd_date_of_conviction')])[1]";
	public static final String CreateAdmission_InmateCourtDetail_DateSentence = "//*[@id='inmatecasedetails-1-icd_date_of_sentence']";
	public static final String CreateAdmission_InmateCourtDetail_Action = "";
	// New Admission Health Details
	public static final String CreateAdmission_HealthConditionTab = "//a[text() = 'Health Condition']";
	public static final String CreateAdmission_HealthCondition_AddNew = "(//button[text() ='Add New'])[1]";
	public static final String CreateAdmission_HealthCondition_MedicalAttention = "(.//input[contains(@name, 'hco_is_medical_attention_needed')])[2]";
	public static final String CreateAdmission_HealthCondition_Pregnant = "(//input[contains(@name, 'hco_is_pregnant')])[2]";
	public static final String CreateAdmission_HealthCondition_Remarks = "//input[contains(@name, 'hco_remarks')]";
	public static final String CreateAdmission_HealthCondition_ForPreschool = "(.//input[contains(@name, 'hco_is_medical_attention_needed')])[4]";
	public static final String CreateAdmission_HealthCondition_OfPreschool = "//input[contains(@name, 'hco_helth_condition_of_preschool')]";
	public static final String CreateAdmission_HealthCondition_Action = "//*[@id='health_condition_row_1']/td[8]/a/span";
	public static final String CreateAdmission_HealthCondition_ManageDrugs_AddNew = "(//button[text() ='Add New'])[2]";
	public static final String CreateAdmission_HealthCondition_ManageDrugs_Drug = "(//select[contains(@name, 'hdu_drugs_id')])[1]";
	public static final String CreateAdmission_HealthCondition_ManagePhysical_AddNew = "(//button[text() ='Add New'])[3]";
	public static final String CreateAdmission_HealthCondition_ManagePhysical_Observation = "(//select[contains(@name, 'hpo_physical_observation_id')])[1]";
	// New Admission Complaint Details
	public static final String CreateAdmission_InmateComplainTab = "//a[text() = 'Inmate Complaint']";
	public static final String CreateAdmission_InmateComplainNew = "(//button[text() ='Add New'])[4]";
	public static final String CreateAdmission_InmateComplainDate = "(//input[contains(@name, 'ico_date')])[1]";
	public static final String CreateAdmission_InmateComplain_TypeOfComplaint = "(//select[contains(@name, 'ico_type_of_compain_id')])[1]";
	public static final String CreateAdmission_InmateComplain_Description = "(//input[contains(@name, 'ico_description')])[1]";
	// New Admission Property Details
	public static final String CreateAdmission_PrivateProperties_Tab = "//a[text() = 'Private Properties']";
	public static final String CreateAdmission_PrivateProperties_AddNew = "(//button[text() ='Add New'])[5]";
	public static final String CreateAdmission_PrivateProperties_Date = "(//input[contains(@name, 'prp_date')])[1]";
	public static final String CreateAdmission_PrivateProperties_Item = "(//select[contains(@name, 'prp_item_id')])[1]";
	public static final String CreateAdmission_PrivateProperties_Description = "(//input[contains(@name, 'prp_description')])[1]";
	public static final String CreateAdmission_PrivateProperties_Quantity = "(//input[contains(@name, 'prp_quantity')])[1]";
	public static final String CreateAdmission_PrivateProperties_Value = "(//input[contains(@name, 'prp_value')])[1]";
	// New Admission Infant Details
	public static final String CreateAdmission_InfantsPreschoolTab = "//a[text() = 'Infants Or Preschoolers']";
	public static final String CreateAdmission_InfantsPreschoolAddNew = "(//button[text() ='Add New'])[6]";
	public static final String CreateAdmission_InfantsPreschoolName = "(//input[contains(@name, 'psc_name')])[1]";
	public static final String CreateAdmission_InfantsPreschoolDateOfBirth = "(//input[contains(@name, 'psc_date_of_birth')])[1]";
	// New Admission History Details
	public static final String CreateAdmission_HistoryTab = "//a[text() = 'History']";
	public static final String Create_Admission_CreateButton = "//button[text() = 'Create']";
	public static final String Update_Admission_UpdateButton = "//button[text() = 'Update']";
	public static final String Authorize_Admission = "//button[text() = 'Authorize']";

	//
	// Edit Admission Page
	//
	public static final String EditAdmission_SuccessMessageText = "Saved .* successfully";
	public static final String EditAdmission_SelectedDropdownEndPart = "/option[@selected='']";
	public static final String EditAdmission_DefaultFrontImage = "/PIMS3/web/../uploads/defaults/front.jpg";
	public static final String EditAdmission_DefaultRHSImage = "/PIMS3/web/../uploads/defaults/right.jpg";
	public static final String EditAdmission_DefaultLHSImage = "/PIMS3/web/../uploads/defaults/left.jpg";
	public static final String EditAdmission_FrontImage = ".//img[@title='Front Image']";
	public static final String EditAdmission_RHSImage = ".//img[@title='Right Hand Side Image']";
	public static final String EditAdmission_LHSImage = ".//img[@title='Left Hand Side Image']";

	//
	// Registration Page
	//
	public static final String InmateRegistration_SuccessMessageText = "Saved .* successfully";
	public static final String InmateRegistration_FrontImage = ".//img[@title='Front Image']";
	public static final String InmateRegistration_RHSImage = ".//img[@title='Right Hand Side Image']";
	public static final String InmateRegistration_LHSImage = ".//img[@title='Left Hand Side Image']";
	public static final String InmateRegistration_DefaultFrontImage = "/PIMS3/web/../uploads/defaults/front.jpg";
	public static final String InmateRegistration_DefaultRHSImage = "/PIMS3/web/../uploads/defaults/right.jpg";
	public static final String InmateRegistration_DefaultLHSImage = "/PIMS3/web/../uploads/defaults/left.jpg";
	public static final String InmateRegistration_ImageRHSBrowse = ".//*[@id='admission-image_rhs']";
	public static final String InmateRegistration_ImageRHSRemove = ".//div[@class='form-group field-admission-image_rhs']/descendant::div[@class='close fileinput-remove']";
	public static final String InmateRegistration_ImageFrontBrowse = ".//*[@id='admission-image_front']";
	public static final String InmateRegistration_ImageFrontRemove = ".//div[@class='form-group field-admission-image_front']/descendant::div[@class='close fileinput-remove']";
	public static final String InmateRegistration_ImageLHSBrowse = ".//*[@id='admission-image_lhs']";
	public static final String InmateRegistration_ImageLHSRemove = ".//div[@class='form-group field-admission-image_lhs']/descendant::div[@class='close fileinput-remove']";
	// Personal Details Tab
	public static final String InmateRegistration_personal_tab = ".//a[text()='Personal']";
	public static final String InmateRegistration_FirtstRow_EditButton = "//button[text()='Update']";
	// Update Registration
	public static final String InmateRegistration_Personal_OtherName1 = "//*[@id='admission-adm_other_name1']";
	public static final String InmateRegistration_Personal_OtherName2 = "//*[@id='admission-adm_other_name2']";
	public static final String InmateRegistration_Personal_CallName1 = "//*[@id='admission-adm_call_name1']";
	public static final String InmateRegistration_Personal_CallName2 = "//*[@id='admission-adm_call_name2']";
	public static final String InmateRegistration_Personal_AddressLine1 = "//*[@id='admission-adm_address_line_1']";
	public static final String InmateRegistration_Personal_AddressLine2 = "//*[@id='admission-adm_address_line_2']";
	public static final String InmateRegistration_Personal_PostOffice = "//*[@id='admission-adm_delivery_post_office']";
	public static final String InmateRegistration_Personal_PostalCode = "//*[@id='admission-adm_address_postal_code']";
	public static final String InmateRegistration_Personal_Country = "//*[@id='admission-adm_address_country']";
	//public static final String InmateRegistration_Personal_Province = "//*[@id='admission-adm_province_id']";
	public static final String InmateRegistration_Personal_Province = "//*[@id='province-id']";
	//public static final String InmateRegistration_Personal_District = "//*[@id='admission-adm_district_id']";
	public static final String InmateRegistration_Personal_District = "//*[@id='district-id']";
	//public static final String InmateRegistration_Personal_DS = "//*[@id='admission-adm_ds_id']";
	public static final String InmateRegistration_Personal_DS = "//*[@id='ds-id']";
	//public static final String InmateRegistration_Personal_GSDivision = "//*[@id='admission-adm_gn_devision_id']";
	public static final String InmateRegistration_Personal_GSDivision = "//*[@id='gn-id']";
	//public static final String InmateRegistration_Personal_City = "//*[@id='admission-adm_city_id']";
	public static final String InmateRegistration_Personal_City = "//*[@id='city-id']";
	//public static final String InmateRegistration_Personal_PoliceDivision = "//*[@id='admission-adm_police_division_id']";
	public static final String InmateRegistration_Personal_PoliceDivision = "//*[@id='pd-id']";
	public static final String InmateRegistration_Personal_Update = "//*[text()='Update']";
	// Inmate classification tab
	public static final String InmateRegistration_calssfication_tab = "//a[text()='Inmate Classification Details']";
	public static final String InmateRegistration_Header = "";
	public static final String InmateRegistration_Classification_Pervious_Conviction = "";
	public static final String InmateRegistration_Classifiaction_IsSpecial = "//*[@id='admission-adm_is_special']";
	// Inmate characteristics tab
	public static final String InmateRegistration_characteristics_tab = "//a[text()='Inmate Characteristic Details']";
	public static final String InmateRegistration_Characteristic_nationality = "//*[@id='admission-adm_nationality_id']";
	public static final String InmateRegistration_Classifiaction_race = "//*[@id='admission-adm_race_id']";
	public static final String InmateRegistration_Classifiaction_marital = "//*[@id='admission-adm_marital_status_id']";
	public static final String InmateRegistration_Classifiaction_religion = "//*[@id='admission-adm_religion_id']";
	public static final String InmateRegistration_Classifiaction_NIC = "//*[@id='admission-adm_nic']";
	public static final String InmateRegistration_Classifiaction_birthdate = "//*[@id='admission-adm_date_of_birth']";
	public static final String InmateRegistration_Classifiaction_birthplace = "//*[@id='admission-adm_birth_place']";
	public static final String InmateRegistration_Classifiaction_passport = "//*[@id='admission-adm_passport_no']";
	// Inmate identification tab
	public static final String InmateRegistration_identification_tab = "//a[text()='Inmate Identification Details']";
	public static final String InmateRegistration_identification_face = "//*[@id='admission-adm_face_id']";
	public static final String InmateRegistration_identification_faced = "//*[@id='admission-adm_face_description']";
	public static final String InmateRegistration_identification_hair = "//*[@id='admission-adm_hair_id']";
	public static final String InmateRegistration_identification_haird = "//*[@id='admission-adm_hair_description']";
	public static final String InmateRegistration_identification_eyes = "//*[@id='admission-adm_eyes_id']";
	public static final String InmateRegistration_identification_eyesd = "//*[@id='admission-adm_eyes_description']";
	public static final String InmateRegistration_identification_nose = "//*[@id='admission-adm_norse_id']";
	public static final String InmateRegistration_identification_nosed = "//*[@id='admission-adm_norse_description']";
	public static final String InmateRegistration_identification_health = "//*[@id='admission-adm_health_id']";
	public static final String InmateRegistration_identification_bodymark = "//*[@id='admission-adm_body_mark_1']";
	// Inmate case tab
	public static final String InmateRegistration_case_tab = "//a[text()='Inmate Case Details']";
	public static final String InmateRegistration_case_addnew = ".//button[text()='Add New']";
	public static final String InmateRegistration_CaseDetailsTable = ".//*[@id='sentence_grid']/tbody";
	public static final String InmateRegistration_CaseFieldsCommonFirstPart = ".//*[@id='sentence-";
	public static final String InmateRegistration_CaseNo_LastPart = "-sen_case_id']";
	public static final String InmateRegistration_Offence_LastPart = "-sen_offence_id']";
	public static final String InmateRegistration_OffenceDescription_LastPart = "-sen_discription_of_offence']";
	public static final String InmateRegistration_SentenceType_LastPart = "-sen_sentence_type_id']";
	public static final String InmateRegistration_Description_LastPart = "-sen_description']";
	public static final String InmateRegistration_Years_LastPart = "-sen_years']";
	public static final String InmateRegistration_Months_LastPart = "-sen_months']";
	public static final String InmateRegistration_Days_LastPart = "-sen_days']";
	public static final String InmateRegistration_FineCharges_LastPart = "-sen_fine_charges']";
	public static final String InmateRegistration_IsActive_LastPart = "-sen_is_active']";

	//
	// Allocate Location Page
	//
	public static final String AllocateLocation_ExpectedHeader = "Allocate Location";	
	public static final String AllocateLocation_RegistrationNo = ".//*[@id='admission-adm_registration_no']";
	public static final String AllocateLocation_InmateName = ".//*[@id='admission-adm_name_as_in_warrant']";
	public static final String AllocateLocation_LocationDropdown = ".//*[@id='admission-adm_current_permenent_location_id']";
	public static final String AllocateLocation_SaveLocation = ".//*[text()='Save']";
	public static final String AllocateLocation_CurrentLocation = ".//select[@id='admission-adm_current_permenent_location_id']//option[@selected='']";
	public static final String AllocateLocation_SaveButton = ".//*[text()='Save']";
	public static final String AllocateLocation_AddedSuccessfullyMessage = ".//div[@class='alert alert-success']";
	public static final String AllocateLocation_SuccessMessageText = ".* Assigned to .* Successfully.";

	//
	// Property Management Page
	//
	public static final String PropertyManagement_ExpectedHeader = "Property Management";
	public static final String PropertyManagement_AddedSuccessfullyMessage = ".//div[@class='alert alert-success']";
	public static final String PropertyManagement_SuccessMessageText = "Saved .* successfully";
	// Property Data Fields
	public static final String PropertyManagement_PrivateTab_TBody = ".//*[@id='private_property_grid']/tbody";
	public static final String PropertyManagement_PrisonTab_TBody = ".//*[@id='prison_property_grid']/tbody";
	public static final String PropertyManagement_UpdateButton = ".//button[text()='Update']";
	// Private Property Tab
	public static final String PropertyManagement_PrivateTab = ".//a[text()='Private Properties']";
	public static final String PropertyManagement_PrivateTab_AddNew = ".//*[@onclick='addprivate_propertyRow();']";
	public static final String PropertyManagement_PrivateTab_DateFirstPart = ".//*[@id='privateproperty-";
	public static final String PropertyManagement_PrivateTab_DateLastPart = "-prp_date']";
	public static final String PropertyManagement_PrivateTab_ItemFirstPart = ".//*[@id='privateproperty-";
	public static final String PropertyManagement_PrivateTab_ItemLastPart = "-prp_item_id']";
	public static final String PropertyManagement_PrivateTab_SelectedItemLastPart = "-prp_item_id']/descendant::option[@selected='']";
	public static final String PropertyManagement_PrivateTab_DescriptionFirstPart = ".//*[@id='privateproperty-";
	public static final String PropertyManagement_PrivateTab_DescriptionLastPart = "-prp_description']";
	public static final String PropertyManagement_PrivateTab_QuantityFirstPart = ".//*[@id='privateproperty-";
	public static final String PropertyManagement_PrivateTab_QuantityLastPart = "-prp_quantity']";
	public static final String PropertyManagement_PrivateTab_ValueFirstPart = ".//*[@id='privateproperty-";
	public static final String PropertyManagement_PrivateTab_ValueLastPart = "-prp_value']";
	// Prison Property Tab
	public static final String PropertyManagement_PrisonTab = ".//a[text()='Prison Properties']";
	public static final String PropertyManagement_PrisonTab_AddNew = ".//*[@onclick='addprison_propertyRow();']";
	public static final String PropertyManagement_PrisonTab_DateFirstPart = ".//*[@id='prisonproperty-";
	public static final String PropertyManagement_PrisonTab_DateLastPart = "-psp_date']";
	public static final String PropertyManagement_PrisonTab_ItemFirstPart = ".//*[@id='prisonproperty-";
	public static final String PropertyManagement_PrisonTab_ItemLastPart = "-psp_item_id']";
	public static final String PropertyManagement_PrisonTab_SelectedItemLastPart = "-psp_item_id']/descendant::option[@selected='']";
	public static final String PropertyManagement_PrisonTab_DescriptionFirstPart = ".//*[@id='prisonproperty-";
	public static final String PropertyManagement_PrisonTab_DescriptionLastPart = "-psp_description']";
	public static final String PropertyManagement_PrisonTab_QuantityFirstPart = ".//*[@id='prisonproperty-";
	public static final String PropertyManagement_PrisonTab_QuantityLastPart = "-psp_quantity']";
	
	//
	// Authorize Registration Page
	//
	public static final String AuthorizeRegistration_ExpectedHeader = "Registration Authorization";
	public static final String AuthorizeRegistration_AuthorizeButton = ".//button[text()='Authorize']";
	public static final String AuthorizeRegistration_AuthorizedSuccessfullyMessage = ".//div[@class='alert alert-success']";
	public static final String AuthorizeRegistration_SuccessMessageText = "Saved .* successfully";
	
	//
	// Post Registration Page
	//
	public static final String PostRegistration_PageTitle = "//h1[text()='Post Registration']";
	public static final String PostRegistration_PageTitleText = "Post Registration";
	public static final String PostRegistration_SuccessMessage = "//div[@class='alert alert-success']";
	public static final String PostRegistration_SuccessMessageText = "Saved .* successfully";
	public static final String PostRegistration_SearchByRegistrationNumber = "//input[contains(@name,'adm_registration_no')]";
	public static final String PostRegistration_SearchByBiometric = "//input[contains(@name,'adm_biometric_id')]";
	public static final String PostRegistration_SearchByWarrantName = "//input[contains(@name,'adm_name_as_in_warrant')]";
	public static final String PostRegistration_SearchByOtherName = "//input[contains(@name,'adm_other_name1')]";
	public static final String PostRegistration_FirstUpdateIcon = "(.//a[@title='Update']/span)[1]";
	public static final String UpdatePostRegistration_Update = "//button[text()='Update']";
	// Update Post Registration Page  
	public static final String UpdatePostRegistration_CheckBox = "//*[@id='admission-adm_is_attended_to_orientation_programe']";
	public static final String UpdatePostRegistration_CurrentPrisonInstitute = "//*[@id='admission-adm_current_prison_institute_id']";
	public static final String UpdatePostRegistration_PhotoRightBrowse = "//*[@id='admission-image_rhs']";
	public static final String UpdatePostRegistration_PhotoFrontBrowse = "//*[@id='admission-image_front']";
	public static final String UpdatePostRegistration_PhotoLeftBrowse = "//*[@id='admission-image_lhs']";
	//Educational Qualification Tab
	public static final String UpdatePostRegistration_EducationalQualificationTab = "//a[text()='Educational Qualifications']";
	public static final String UpdatePostRegistration_EducationalTBody = "//*[@id='educational_qualification_grid']/tbody";
	public static final String UpdatePostRegistration_EducationalQualificationTabStatus = "true";
	public static final String UpdatePostRegistration_EducationalQualificationAddNew = "(.//button[text()='Add New'])[1]";
	public static final String UpdatePostRegistration_InstituteFirstPart = "//*[@id='educationalqualification-";
	public static final String UpdatePostRegistration_InstituteLastPart = "-equ_institute']";
	public static final String UpdatePostRegistration_QualificationTypeFirstPart = "//*[@id='educationalqualification-";
	public static final String UpdatePostRegistration_QualificationTypeLastPart = "-equ_qulification_type_id']";
	public static final String UpdatePostRegistration_LanguageFirstPart = "//*[@id='educationalqualification-";
	public static final String UpdatePostRegistration_LanguageLastPart = "-equ_language_id']";
	public static final String UpdatePostRegistration_EducationalQualificationAction = "//a[contains(@onclick,'removeeducational')]";
	//Employment Tab
	public static final String UpdatePostRegistration_EmploymentTab = "//a[text()='Employment']";
	public static final String UpdatePostRegistration_EmployerTBody = "//*[@id='employment_grid']/tbody";
	public static final String UpdatePostRegistration_EmploymentTabStatus = "true";
	public static final String UpdatePostRegistration_EmploymentAddNew = "(.//button[text()='Add New'])[2]";
	public static final String UpdatePostRegistration_EmployerFirstPart = "//*[@id='employment-";
	public static final String UpdatePostRegistration_EmployerLastPart = "-emp_employer']";
	public static final String UpdatePostRegistration_OrganizationalTypeFirstPart = "//*[@id='employment-";
	public static final String UpdatePostRegistration_OrganizationalTypeLastPart = "-emp_organizational_type_id']";
	public static final String UpdatePostRegistration_PositionFirstPart = "//*[@id='employment-";
	public static final String UpdatePostRegistration_PositionLastPart = "-emp_position']";
	public static final String UpdatePostRegistration_DateFromFirstPart = "//*[@id='employment-";
	public static final String UpdatePostRegistration_DateFromLastPart = "-emp_date_from']";
	public static final String UpdatePostRegistration_DateToFirstPart = "//*[@id='employment-";
	public static final String UpdatePostRegistration_DateToLastPart = "-emp_date_to']";
	public static final String UpdatePostRegistration_EmploymentAction = "//a[contains(@onclick,'removeemployment')]";
	//Family Tab
	public static final String UpdatePostRegistration_FamilyTab = "//a[text()='Family Data']";
	public static final String UpdatePostRegistration_FamilyTBody = "//*[@id='family_data_grid']/tbody";
	public static final String UpdatePostRegistration_FamilyAddNew = "(.//button[text()='Add New'])[3]";
	public static final String UpdatePostRegistration_FamilyNameFirstPart = "//*[@id='familydata-";
	public static final String UpdatePostRegistration_FamilyNameLastPart = "-fda_name']";
	public static final String UpdatePostRegistration_Address1FirstPart = "//*[@id='familydata-";
	public static final String UpdatePostRegistration_Address1LastPart = "-fda_address_line1']";
	public static final String UpdatePostRegistration_NICFirstPart = "//*[@id='familydata-";
	public static final String UpdatePostRegistration_NICLastPart = "-fda_nic']";
	public static final String UpdatePostRegistration_FamilyAgeFirstPart = "//*[@id='familydata-";
	public static final String UpdatePostRegistration_FamilyAgeLastPart = "-fda_age']";
	public static final String UpdatePostRegistration_RelationshipFirstPart = "//*[@id='familydata-";
	public static final String UpdatePostRegistration_RelationshipLastPart = "-fda_relationship_id']";
	public static final String UpdatePostRegistration_TelephoneFirstPart = "//*[@id='familydata-";
	public static final String UpdatePostRegistration_TelephoneLastPart = "-fda_telephone']";
	public static final String UpdatePostRegistration_IncomeFirstPart = "//*[@id='familydata-";
	public static final String UpdatePostRegistration_IncomeLastPart = "-fda_income']";
	public static final String UpdatePostRegistration_FamilyAction = "//a[contains(@onclick,'removefamily')]";
	//Child Tab
	public static final String UpdatePostRegistration_ChildTab = "//a[text()='Child Data']";
	public static final String UpdatePostRegistration_ChildTBody = "//*[@id='child_data_grid']/tbody";
	public static final String UpdatePostRegistration_ChildAddNew = "(.//button[text()='Add New'])[4]";
	public static final String UpdatePostRegistration_ChildGrade_firstpart = "//*[@id='childdata-";
	public static final String UpdatePostRegistration_ChildGrade_lastpart = "-cda_grade']";
	public static final String UpdatePostRegistration_ChildAddress1_FirstPart = "//*[@id='childdata-";
	public static final String UpdatePostRegistration_ChildAddress1_LastPart = "-cda_address_line1']";
	public static final String UpdatePostRegistration_ChildAge_FirstPart = "//*[@id='childdata-";
	public static final String UpdatePostRegistration_ChildAge_LastPart = "-cda_age']";
	public static final String UpdatePostRegistration_ChildNameFirstPart = "//*[@id='childdata-";
	public static final String UpdatePostRegistration_ChildNamelasttPart = "-cda_name']";
	public static final String UpdatePostRegistration_ChildSchool_firstpart = "//*[@id='childdata-";
	public static final String UpdatePostRegistration_ChildSchool_lastpart = "-cda_school']";
	public static final String UpdatePostRegistration_ChildTabStatus = "true";
	public static final String UpdatePostRegistration_ChildAction = "//a[contains(@onclick,'removechild')]";

	
	//
	// Post Registration Authorize
	//
	public static final String PostRegAuthorize_PageTitleText = "Post Registration Authorize";
	public static final String PostRegAuthorize_SuccessMessageText = "Saved successfully";
	public static final String PostRegAuthorize_SearchBy_OtherName = "//input[@name='PostRegistrationAuthorizationSearch[adm_other_name1]']";
	public static final String PostRegAuthorize_SearchBy_OrientationDate = "//input[@name='PostRegistrationAuthorizationSearch[adm_date_of_orientation]']";
	// Authorize Post Registration User page
	public static final String AuthorizePostRegUserPage_CheckBox = "//*[@id='admission-adm_is_attended_to_orientation_programe']";
	public static final String AuthorizePostRegUserPage_CurrentPrisonInstitute = "//*[@id='admission-adm_current_prison_institute_id']";
	public static final String AuthorizePostRegUserPage_PhotoRightBrowse = "//*[@id='admission-image_rhs']";
	public static final String AuthorizePostRegUserPage_PhotoFrontBrowse = "//*[@id='admission-image_front']";
	public static final String AuthorizePostRegUserPage_PhotoLeftBrowse = "//*[@id='admission-image_lhs']";
	public static final String AuthorizePostRegUserPage_EducationalQualificationTab = "//a[text()='Educational Qualifications']";
	public static final String AuthorizePostRegUserPage_EducationalTBody = "//*[@id='educational_qualification_grid']/tbody";
	public static final String AuthorizePostRegUserPage_EducationalQualificationTabStatus = "true";
	public static final String AuthorizePostRegUserPage_EducationalQualificationAddNew = "(.//button[text()='Add New'])[1]";
	public static final String AuthorizePostRegUserPage_Institute = "//*[@id='educationalqualification-1-equ_institute']";
	public static final String AuthorizePostRegUserPage_InstituteFirstPart = "//*[@id='educationalqualification-";
	public static final String AuthorizePostRegUserPage_InstituteLastPart = "-equ_institute']";
	public static final String AuthorizePostRegUserPage_QualificationType = "//*[@id='educationalqualification-1-equ_qulification_type_id']";
	public static final String AuthorizePostRegUserPage_QualificationTypeFirstPart = "//*[@id='educationalqualification-";
	public static final String AuthorizePostRegUserPage_QualificationTypeLastPart = "-equ_qulification_type_id']";
	public static final String AuthorizePostRegUserPage_Language = "//*[@id='educationalqualification-1-equ_language_id']";
	public static final String AuthorizePostRegUserPage_LanguageFirstPart = "//*[@id='educationalqualification-";
	public static final String AuthorizePostRegUserPage_LanguageLastPart = "-equ_language_id']";
	public static final String AuthorizePostRegUserPage_EducationalQualificationAction = "//a[contains(@onclick,'removeeducational')]";
	public static final String AuthorizePostRegUserPage_EmploymentTab = "//a[text()='Employment']";
	public static final String AuthorizePostRegUserPage_EmployerTBody = "//*[@id='employment_grid']/tbody";
	public static final String AuthorizePostRegUserPage_EmploymentTabStatus = "true";
	public static final String AuthorizePostRegUserPage_EmploymentAddNew = "(.//button[text()='Add New'])[2]";
	public static final String AuthorizePostRegUserPage_Employer = "//*[@id='employment-0-emp_employer']";
	public static final String AuthorizePostRegUserPage_EmployerFirstPart = "//*[@id='employment-";
	public static final String AuthorizePostRegUserPage_EmployerLastPart = "-emp_employer']";
	public static final String AuthorizePostRegUserPage_OrganizationalType = "//*[@id='employment-0-emp_organizational_type_id']";
	public static final String AuthorizePostRegUserPage_OrganizationalTypeFirstPart = "//*[@id='employment-";
	public static final String AuthorizePostRegUserPage_OrganizationalTypeLastPart = "-emp_organizational_type_id']";
	public static final String AuthorizePostRegUserPage_Position = "//*[@id='employment-0-emp_position']";
	public static final String AuthorizePostRegUserPage_PositionFirstPart = "//*[@id='employment-";
	public static final String AuthorizePostRegUserPage_PositionLastPart = "-emp_position']";
	public static final String AuthorizePostRegUserPage_DateFrom = "//*[@id='employment-0-emp_date_from']";
	public static final String AuthorizePostRegUserPage_DateFromFirstPart = "//*[@id='employment-";
	public static final String AuthorizePostRegUserPage_DateFromLastPart = "-emp_date_from']";
	public static final String AuthorizePostRegUserPage_DateTo = "//*[@id='employment-0-emp_date_to']";
	public static final String AuthorizePostRegUserPage_DateToFirstPart = "//*[@id='employment-";
	public static final String AuthorizePostRegUserPage_DateToLastPart = "-emp_date_to']";
	public static final String AuthorizePostRegUserPage_EmploymentAction = "//a[contains(@onclick,'removeemployment')]";
	public static final String AuthorizePostRegUserPage_FamilyTab = "//a[text()='Family Data']";
	public static final String AuthorizePostRegUserPage_FamilyAddNew = "(.//button[text()='Add New'])[3]";
	public static final String AuthorizePostRegUserPage_Name = "//*[@id='familydata-1-fda_name']";
	public static final String AuthorizePostRegUserPage_Address1 = "//*[@id='familydata-1-fda_address_line1']";
	public static final String AuthorizePostRegUserPage_Address2 = "//*[@id='familydata-1-fda_address_line2']";
	public static final String AuthorizePostRegUserPage_Address3 = "//*[@id='familydata-1-fda_address_line3']";
	public static final String AuthorizePostRegUserPage_NIC = "//*[@id='familydata-1-fda_nic']";
	public static final String AuthorizePostRegUserPage_Age = "//*[@id='familydata-1-fda_age']";
	public static final String AuthorizePostRegUserPage_Relationship = "//*[@id='familydata-1-fda_relationship_id']";
	public static final String AuthorizePostRegUserPage_Telephone = "//*[@id='familydata-1-fda_telephone']";
	public static final String AuthorizePostRegUserPage_Income = "//*[@id='familydata-1-fda_income']";
	public static final String AuthorizePostRegUserPage_FamilyAction = "//a[contains(@onclick,'removefamily')]";
	public static final String AuthorizePostRegUserPage_ChildTab = "//a[text()='Child Data']";
	public static final String AuthorizePostRegUserPage_ChildAddNew = "(.//button[text()='Add New'])[4]";
	public static final String AuthorizePostRegUserPage_ChildAction = "//a[contains(@onclick,'removechild')]";

	public static final String AuthorizePostRegUserPage_Authorize = "//button[text()='Authorize']";


	// Inmate Search Pages
	public static final String SelectInmate_Header = ".//*[@class='breadcrumb']/following::h1";
	public static final String InmateSearch_RegNoSearchField = ".//*[contains(@name,'Search[adm_registration_no]')]";
	public static final String InmateSearch_BiometricSearchField = ".//*[contains(@name,'Search[adm_biometric_id]')]";
	public static final String InmateSearch_NameSearchField = ".//*[contains(@name,'Search[adm_name_as_in_warrant]')]";
	public static final String InmateSearch_TableFirstInmate = "(.//*[contains(@class, 'glyphicon')]//parent::a)[1]";
	public static final String InmateSearchPage_SuccessMessage = ".//div[@class='alert alert-success']";
	public static final String InmateSearchPage_NoSearchResultsFound = ".//*[text()='No results found.']";


	// Calendar Popup
	public static final String CalendarPopup_MonthYearText = "(.//th[@class='datepicker-switch'])[1]";
	public static final String CalendarPopup_MonthYearText_FirstPart = "(.//span[text()='";
	public static final String CalendarPopup_MonthYearText_LastPart = "'])";
	public static final String CalendarPopup_YearText = "(.//th[@class='datepicker-switch'])[2]";
	public static final String CalendarPopup_DateText_FirstPart = "//td[contains(@class,'day')][text()='";
	public static final String CalendarPopup_DateText_LastPart = "']";
	public static final String CalendarPopup_HourText_FirstPart = "//*[text()='";
	public static final String CalendarPopup_HourText_LastPart = "']";
	public static final String CalendarPopup_MinuteText_FirstPart = "//*[text()='";
	public static final String CalendarPopup_MinuteText_LastPart = "']";

}
