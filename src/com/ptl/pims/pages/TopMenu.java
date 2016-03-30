package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.pages.Admission.AuthorizeAdmissionSelectPage;
import com.ptl.pims.pages.Admission.EditAdmissionSelectPage;
import com.ptl.pims.pages.Admission.NewAdmissionPage;
import com.ptl.pims.pages.Registration.AuthorizeRegistrationInmateSelectPage;
import com.ptl.pims.pages.Registration.InmateRegistrationSelectPage;
import com.ptl.pims.pages.Registration.AllocateLocation.AllocateLocationInmateSelectPage;
import com.ptl.pims.pages.Registration.PropertyManagement.PropertyManagementInmateSelectPage;
import com.ptl.pims.testcases.TestBase;
import com.ptl.pims.util.Constants;

import java.util.ArrayList;

public class TopMenu extends CommonMethods{
	
	WebDriver driver;
	
	@FindBy(xpath=Constants.TopMenu_PIMSTopLink)
	WebElement homePageTopLink;
	@FindBy(xpath = Constants.TopMenu_LogOut)
	WebElement logout;

	public TopMenu(WebDriver dr){
		driver = dr;
	}
	
	public HomePage gotoHomePage(){
		homePageTopLink.click();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		return homePage;
	}
	
	public NewAdmissionPage gotoNewAdmissionPage(){

		moveAlongMenuAndClick(driver,
				new ArrayList<String>(){{
					add(Constants.TopMenu_RegistrationManagementTopLink);
					add(Constants.TopMenu_RegistrationManagement_AdmissionTopLink);
					add(Constants.TopMenu_NewAdmissionSubLink);
				}});
		
		NewAdmissionPage newAdmissionPage = PageFactory.initElements(driver, NewAdmissionPage.class);
		return newAdmissionPage;
	}
	
	public EditAdmissionSelectPage gotoEditAdmissionPage() {

        moveAlongMenuAndClick(driver,
                new ArrayList<String>(){{
                    add(Constants.TopMenu_RegistrationManagementTopLink);
                    add(Constants.TopMenu_RegistrationManagement_AdmissionTopLink);
                    add(Constants.TopMenu_EditAdmissionSubLink);
                }});
		
		EditAdmissionSelectPage editAdminSelectPage = PageFactory.initElements(driver, EditAdmissionSelectPage.class);
		return editAdminSelectPage;
	}
	
	
	public AuthorizeAdmissionSelectPage gotoAuthorizeAdmissionPage() {

        moveAlongMenuAndClick(driver,
                new ArrayList<String>(){{
                    add(Constants.TopMenu_RegistrationManagementTopLink);
                    add(Constants.TopMenu_RegistrationManagement_AdmissionTopLink);
                    add(Constants.TopMenu_AuthorizeAdmissionSubLink);
                }});
		
		AuthorizeAdmissionSelectPage authorizeAdmissionSelectPage = PageFactory.initElements(driver, AuthorizeAdmissionSelectPage.class);
		return authorizeAdmissionSelectPage;
	}

	public InmateRegistrationSelectPage goToInmateRegistration() {

		moveAlongMenuAndClick(driver,
				new ArrayList<String>(){{
					add(Constants.TopMenu_RegistrationManagementTopLink);
					add(Constants.TopMenu_RegistrationManagement_RegistrationTopLink);
					add(Constants.TopMenu_RegistrationSubLink);
				}});

		InmateRegistrationSelectPage inmateRegistration = PageFactory.initElements(
				driver, InmateRegistrationSelectPage.class);
		return inmateRegistration;
	}

	public AuthorizeRegistrationInmateSelectPage gotoAuthorizeRegistrationPage() {

		moveAlongMenuAndClick(driver,
				new ArrayList<String>(){{
					add(Constants.TopMenu_RegistrationManagementTopLink);
					add(Constants.TopMenu_RegistrationManagement_RegistrationTopLink);
					add(Constants.TopMenu_AuthorizeRegistrationSubLink);
				}});

		AuthorizeRegistrationInmateSelectPage authorizeInmateSelectPage = PageFactory.initElements(driver, AuthorizeRegistrationInmateSelectPage.class);
		return authorizeInmateSelectPage;
	}

	public AllocateLocationInmateSelectPage goToAllocateLocation() {

		moveAlongMenuAndClick(driver,
				new ArrayList<String>(){{
					add(Constants.TopMenu_RegistrationManagementTopLink);
					add(Constants.TopMenu_RegistrationManagement_RegistrationTopLink);
					add(Constants.TopMenu_AllocateLocationSubLink);
					add(Constants.TopMenu_AllocateLocationLastLink);
				}});
		
		AllocateLocationInmateSelectPage allocateLocation = PageFactory
				.initElements(driver, AllocateLocationInmateSelectPage.class);
		return allocateLocation;
	}

	public LoginPage doLogout(){
		logout.click();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		TestBase.isLoggedIn = false;
		return loginPage;
		
	}

}
