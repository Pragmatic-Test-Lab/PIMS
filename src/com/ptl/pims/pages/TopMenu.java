package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.Constants;

public class TopMenu {
	
	WebDriver driver;
	
	@FindBy(xpath=Constants.PIMSTopLink)
	WebElement homePageTopLink;
	@FindBy(xpath=Constants.AdmissionTopLink)
	WebElement admissionTopLink;
	@FindBy(xpath = Constants.NewAdmissionSubLink)
	WebElement newAdmissionSubLink;
	@FindBy(xpath=Constants.EditSubLink)
	WebElement editSubLink;
	@FindBy(xpath = Constants.AuthorizeSubLink)
	WebElement authorizeSubLink;
	@FindBy(xpath = Constants.RegistrationMainLink)
	WebElement registrationMainLink;
	@FindBy(xpath = Constants.RegistrationSubLink)
	WebElement registrationSubLink;
	@FindBy(xpath = Constants.AllocateLocationSubLink)
	WebElement allocateLocationSubLink;
	@FindBy(xpath = Constants.PropertyManagementSubLink)
	WebElement propertyManagement;
	@FindBy(xpath = Constants.AuthorizeRegistrationSubLink)
	WebElement authorizeRegSub;
	@FindBy(xpath = Constants.PostRegistrationMainLink)
	WebElement postRegMain;
	@FindBy(xpath = Constants.PostRegistrationSubLink)
	WebElement postRegSub;
	@FindBy(xpath = Constants.AuthorizePostRegistrationSubLink)
	WebElement authorizePost;
	@FindBy(xpath = Constants.LogOut)
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
	
	
	public LoginPage doLogout(){
		logOut.click();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		TestBase.isLoggedIn = false;
		return loginPage;
		
	}
	

}
