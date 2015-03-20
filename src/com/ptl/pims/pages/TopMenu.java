package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.Constants;

public class TopMenu {
	
	WebDriver driver;
	
	@FindBy(xpath=Constants.TopMenu_PIMSTopLink)
	WebElement homePageTopLink;
	@FindBy(xpath=Constants.TopMenu_RegistrationManagementTopLink)
	WebElement registrationManagementTopLink;	
	@FindBy(xpath=Constants.TopMenu_RegistrationManagement_AdmissionTopLink)
	WebElement admissionTopLink;
	@FindBy(xpath = Constants.TopMenu_NewAdmissionSubLink)
	WebElement newAdmissionSubLink;
	@FindBy(xpath=Constants.TopMenu_EditSubLink)
	WebElement editSubLink;
	@FindBy(xpath = Constants.TopMenu_AuthorizeSubLink)
	WebElement authorizeSubLink;
	@FindBy(xpath = Constants.TopMenu_RegistrationManagement_RegistrationTopLink)
	WebElement registrationMainLink;
	@FindBy(xpath = Constants.TopMenu_RegistrationSubLink)
	WebElement registrationSubLink;
	@FindBy(xpath = Constants.TopMenu_AllocateLocationSubLink)
	WebElement allocateLocationSubLink;
	@FindBy(xpath = Constants.TopMenu_PropertyManagementSubLink)
	WebElement propertyManagement;
	@FindBy(xpath = Constants.TopMenu_AuthorizeRegistrationSubLink)
	WebElement authorizeRegSub;
	@FindBy(xpath = Constants.TopMenu_RegistrationManagement_PostRegistrationTopLink)
	WebElement postRegMain;
	@FindBy(xpath = Constants.TopMenu_PostRegistrationSubLink)
	WebElement postRegSub;
	@FindBy(xpath = Constants.TopMenu_AuthorizePostRegistrationSubLink)
	WebElement postRegAuthorizeSub;
	@FindBy(xpath = Constants.TopMenu_LogOut)
	WebElement logOut;
	
	
	
	public TopMenu(WebDriver dr){
		driver = dr;
	}
	
	public HomePage gotoHomePage(){
		homePageTopLink.click();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		return homePage;
	}

	
	public NewAdmissionPage gotoNewAdmissionPage(){
		registrationManagementTopLink.click();
		admissionTopLink.click();
		newAdmissionSubLink.click();
		NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver, NewAdmissionPage.class);
		return newAdmissionPage;
	}	
	
	
	public EditAdmissionSelectPage gotoEditAdmissionPage() {
		registrationManagementTopLink.click();
		admissionTopLink.click();
		editSubLink.click();
		EditAdmissionSelectPage editAdminSelectPage = PageFactory.initElements(driver, EditAdmissionSelectPage.class);
		return editAdminSelectPage;
	}
	
	
	public AuthorizeAdmissionSelectPage gotoAuthorizeAdmissionPage() {
		registrationManagementTopLink.click();
		admissionTopLink.click();
		authorizeSubLink.click();
		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = PageFactory.initElements(driver, AuthorizeAdmissionSelectPage.class);
		return authorizeAdmissionSelectPage;
	}
	
	
	public PostRegistrationPage gotoPostRegistrationPage(){
		registrationManagementTopLink.click();
		postRegMain.click();
		postRegSub.click();
		PostRegistrationPage postRegPage = PageFactory.initElements(driver, PostRegistrationPage.class);
		return postRegPage;
		
	}
	
	
	public PostRegistrationAuthorizePage gotoPostRegistrationAuthorizePage(){
		registrationManagementTopLink.click();
		postRegMain.click();
		postRegAuthorizeSub.click();
		PostRegistrationAuthorizePage postRegAuthorizePage = PageFactory.initElements(driver, PostRegistrationAuthorizePage.class);
		return postRegAuthorizePage;
		
	}
	
	
	public PropertyManagementInmateSelectPage gotoManageProperty(){
		registrationManagementTopLink.click();
		registrationMainLink.click();
		propertyManagement.click();
		PropertyManagementInmateSelectPage managePropertySelectInmate = PageFactory.initElements(driver, PropertyManagementInmateSelectPage.class);
		return managePropertySelectInmate;
		
	}
	

	public AuthorizeRegistrationInmateSelectPage gotoAuthorizeRegistrationPage() {
		registrationManagementTopLink.click();
		registrationMainLink.click();
		authorizeRegSub.click();
		AuthorizeRegistrationInmateSelectPage authorizeInmateSelectPage = PageFactory.initElements(driver, AuthorizeRegistrationInmateSelectPage.class);
		return authorizeInmateSelectPage;
	}
	

	public AllocateLocationInmateSelectPage goToAllocateLocation() {
		registrationManagementTopLink.click();
		registrationMainLink.click();
		allocateLocationSubLink.click();
		AllocateLocationInmateSelectPage allocateLocation = PageFactory
				.initElements(driver, AllocateLocationInmateSelectPage.class);
		return allocateLocation;
	}
	


	public InmateRegistrationSelectPage goToInmateRegistration() {
		registrationManagementTopLink.click();
		registrationMainLink.click();
		registrationSubLink.click();
		InmateRegistrationSelectPage inmateRegistration = PageFactory.initElements(
				driver, InmateRegistrationSelectPage.class);
		return inmateRegistration;
	}

	public PostRegistrationAuthorizePage gotoAuthorizePostRegistration() {
		registrationManagementTopLink.click();
		postRegMain.click();
		postRegAuthorizeSub.click();
		PostRegistrationAuthorizePage postRegistration = PageFactory.initElements(
				driver, PostRegistrationAuthorizePage.class);
		return postRegistration;
	}
	
	public LoginPage doLogout(){
		logOut.click();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		TestBase.isLoggedIn = false;
		return loginPage;
		
	}


	

}
