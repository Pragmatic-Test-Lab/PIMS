package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.Admission.AuthorizeAdmissionSelectPage;
import com.ptl.pims.pages.Admission.EditAdmissionSelectPage;
import com.ptl.pims.pages.Admission.NewAdmissionPage;
import com.ptl.pims.pages.PostRegistration.PostRegistrationAuthorizePage;
import com.ptl.pims.pages.PostRegistration.PostRegistrationPage;
import com.ptl.pims.pages.Registration.AuthorizeRegistrationInmateSelectPage;
import com.ptl.pims.pages.Registration.InmateRegistrationSelectPage;
import com.ptl.pims.pages.Registration.AllocateLocation.AllocateLocationInmateSelectPage;
import com.ptl.pims.pages.Registration.PropertyManagement.PropertyManagementInmateSelectPage;
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

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(admissionTopLink).moveToElement(newAdmissionSubLink).click().build().perform();
		
		NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver, NewAdmissionPage.class);
		return newAdmissionPage;
	}	
	
	
	public EditAdmissionSelectPage gotoEditAdmissionPage() {

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(admissionTopLink).moveToElement(editSubLink).click().build().perform();
		
		EditAdmissionSelectPage editAdminSelectPage = PageFactory.initElements(driver, EditAdmissionSelectPage.class);
		return editAdminSelectPage;
	}
	
	
	public AuthorizeAdmissionSelectPage gotoAuthorizeAdmissionPage() {

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(admissionTopLink).moveToElement(authorizeSubLink).click().build().perform();
		
		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = PageFactory.initElements(driver, AuthorizeAdmissionSelectPage.class);
		return authorizeAdmissionSelectPage;
	}
	
	
	public PostRegistrationPage gotoPostRegistrationPage(){

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(postRegMain).moveToElement(postRegSub).click().build().perform();
		
		PostRegistrationPage postRegPage = PageFactory.initElements(driver, PostRegistrationPage.class);
		return postRegPage;
		
	}
	
	
	public PostRegistrationAuthorizePage gotoPostRegistrationAuthorizePage(){

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(postRegMain).moveToElement(postRegAuthorizeSub).click().build().perform();
		
		PostRegistrationAuthorizePage postRegAuthorizePage = PageFactory.initElements(driver, PostRegistrationAuthorizePage.class);
		return postRegAuthorizePage;
		
	}
	
	
	public PropertyManagementInmateSelectPage gotoManageProperty(){

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(registrationMainLink).moveToElement(propertyManagement).click().build().perform();
		
		PropertyManagementInmateSelectPage managePropertySelectInmate = PageFactory.initElements(driver, PropertyManagementInmateSelectPage.class);
		return managePropertySelectInmate;
		
	}
	

	public AuthorizeRegistrationInmateSelectPage gotoAuthorizeRegistrationPage() {

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(registrationMainLink).moveToElement(authorizeRegSub).click().build().perform();
		
		AuthorizeRegistrationInmateSelectPage authorizeInmateSelectPage = PageFactory.initElements(driver, AuthorizeRegistrationInmateSelectPage.class);
		return authorizeInmateSelectPage;
	}
	

	public AllocateLocationInmateSelectPage goToAllocateLocation() {

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(registrationMainLink).moveToElement(allocateLocationSubLink).click().build().perform();
		
		AllocateLocationInmateSelectPage allocateLocation = PageFactory
				.initElements(driver, AllocateLocationInmateSelectPage.class);
		return allocateLocation;
	}
	


	public InmateRegistrationSelectPage goToInmateRegistration() {

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(registrationMainLink).moveToElement(registrationSubLink).click().build().perform();
		
		InmateRegistrationSelectPage inmateRegistration = PageFactory.initElements(
				driver, InmateRegistrationSelectPage.class);
		return inmateRegistration;
	}

	public PostRegistrationAuthorizePage gotoAuthorizePostRegistration() {

		Actions action = new Actions(driver);
		action.moveToElement(registrationManagementTopLink).moveToElement(postRegMain).moveToElement(postRegAuthorizeSub).click().build().perform();
		
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
