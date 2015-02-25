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
	@FindBy(xpath=Constants.TopMenu_AdmissionTopLink)
	WebElement admissionTopLink;
	@FindBy(xpath = Constants.TopMenu_NewAdmissionSubLink)
	WebElement newAdmissionSubLink;
	@FindBy(xpath=Constants.TopMenu_EditSubLink)
	WebElement editSubLink;
	@FindBy(xpath = Constants.TopMenu_AuthorizeSubLink)
	WebElement authorizeSubLink;
	@FindBy(xpath = Constants.TopMenu_RegistrationMainLink)
	WebElement registrationMainLink;
	@FindBy(xpath = Constants.TopMenu_RegistrationSubLink)
	WebElement registrationSubLink;
	@FindBy(xpath = Constants.TopMenu_AllocateLocationSubLink)
	WebElement allocateLocationSubLink;
	@FindBy(xpath = Constants.TopMenu_PropertyManagementSubLink)
	WebElement propertyManagement;
	@FindBy(xpath = Constants.TopMenu_AuthorizeRegistrationSubLink)
	WebElement authorizeRegSub;
	@FindBy(xpath = Constants.TopMenu_PostRegistrationMainLink)
	WebElement postRegMain;
	@FindBy(xpath = Constants.TopMenu_PostRegistrationSubLink)
	WebElement postRegSub;
	@FindBy(xpath = Constants.TopMenu_AuthorizePostRegistrationSubLink)
	WebElement authorizePost;
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
		admissionTopLink.click();
		newAdmissionSubLink.click();
		NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver, NewAdmissionPage.class);
		return newAdmissionPage;
	}	
	
	
	public EditAdmissionPage gotoEditAdmissionPage() {
		admissionTopLink.click();
		editSubLink.click();
		EditAdmissionPage editAdmiPage = PageFactory.initElements(driver, EditAdmissionPage.class);
		return editAdmiPage;
	}
	
	
	public AuthorizeAdmissionPage gotoAuthorizeAdmissionPage() {
		admissionTopLink.click();
		editSubLink.click();
		AuthorizeAdmissionPage authorizeAdmissionPage = PageFactory.initElements(driver, AuthorizeAdmissionPage.class);
		return authorizeAdmissionPage;
	}
	
	
	public PostRegistrationPage gotoPostRegistrationPage(){
		postRegMain.click();
		postRegSub.click();
		PostRegistrationPage postRegPage = PageFactory.initElements(driver, PostRegistrationPage.class);
		return postRegPage;
		
	}
	
	public PropertyManagementInmateSelectPage gotoManageProperty(){
		registrationMainLink.click();
		propertyManagement.click();
		PropertyManagementInmateSelectPage managePropertySelectInmate = PageFactory.initElements(driver, PropertyManagementInmateSelectPage.class);
		return managePropertySelectInmate;
		
	}
	
	public LoginPage doLogout(){
		logOut.click();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		TestBase.isLoggedIn = false;
		return loginPage;
		
	}
	

}
