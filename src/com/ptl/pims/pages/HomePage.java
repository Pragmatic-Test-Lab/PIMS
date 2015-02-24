package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ptl.pims.util.Constants;

public class HomePage {

	WebDriver driver;

	String ActualPageHeader;

	@FindBy(xpath = Constants.Home_RegistrationLink)
	WebElement RegistrationLink;

	@FindBy(xpath = Constants.Home_PropertyManagementLink)
	WebElement PropertyManagementLink;

	@FindBy(xpath = Constants.Home_PageHeader2)
	WebElement pageHeader2;

	String ActualPageHeader2;
	@FindBy(xpath = Constants.LogOutLink)
	WebElement LogoutLink;

	@FindBy(xpath = Constants.Home_AllocateLocationLink)
	WebElement AllocateLocationLink;

	@FindBy(xpath = Constants.RegistrationMainLink)
	WebElement registrationMainLink;
	@FindBy(xpath = Constants.RegistrationSubLink)
	WebElement registrationSubLink;

	@FindBy(xpath = Constants.Home_PageHeader)
	WebElement pageHeader;

	@FindBy(xpath = Constants.PasswordError)
	WebElement ErrorMessage2;

	String loginline;
	@FindBy(xpath = Constants.Loginline2)
	WebElement loginline2;
	String emptyLogin = Constants.emptylogin;

	String passwordline;
	@FindBy(xpath = Constants.passwordline2)
	WebElement PasswordLine2;
	String emptyPassword = Constants.emptyPassword;

	public HomePage(WebDriver dr) {
		driver = dr;

	}

	public String getErrorMessage() {
		return ErrorMessage2.getText();
	}

	public String getloginline() {
		return loginline = loginline2.getText();
	}

	public String getemptylogin() {
		return emptyLogin;
	}

	public String getpasswordline() {
		return passwordline = PasswordLine2.getText();
	}

	public String getemptypassword() {
		return emptyPassword;
	}

	public String getActualPageHeader() {
		return ActualPageHeader = pageHeader.getText();
	}

	public AllocateLocationInmateSelectPage goToAllocateLocation() {

		RegistrationLink.click();
		AllocateLocationLink.click();

		AllocateLocationInmateSelectPage allocateLocation = PageFactory
				.initElements(driver, AllocateLocationInmateSelectPage.class);
		return allocateLocation;
	}

	public InmateRegistrationSelectPage goToInmateRegistration() {
		registrationMainLink.click();
		registrationSubLink.click();
		InmateRegistrationSelectPage inmateRegistration = PageFactory.initElements(
				driver, InmateRegistrationSelectPage.class);
		return inmateRegistration;
	}

	public String getActualPageHeader2() {
		return ActualPageHeader = pageHeader2.getText();
	}

	public LoginPage gotoLogout() {
		LogoutLink.click();
		LoginPage Logout = PageFactory.initElements(driver, LoginPage.class);
		System.out.println("Logout done");
		return Logout;
	}

	public PropertyManagementInmateSelectPage goToManageProperty() {

		PropertyManagementLink.click();
		PropertyManagementInmateSelectPage propertyManagement = PageFactory.initElements(
				driver, PropertyManagementInmateSelectPage.class);
		return propertyManagement;
	}
}
