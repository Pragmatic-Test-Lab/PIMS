package com.ptl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ptl.util.Constants;


public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath=Constants.Home_PageHeader)
	WebElement pageHeader;
	String ExpectedPageHeader = Constants.Home_PageHeaderText;
	
	
	@FindBy(xpath=Constants.PasswordError)
	WebElement ErrorMessage2;
	String ExpectedErrorMessage = Constants.PasswordErrorText;
	String ErrorMessage;
	
	String ActualPageHeader;
	@FindBy(xpath=Constants.Home_PageHeader2)
	WebElement pageHeader2;
	String ExpectedPageHeader2 = Constants.Home_PageHeaderText2;
	
	String ActualPageHeader2;
	@FindBy(xpath=Constants.LogOutLink)
	WebElement LogoutLink;
	
	String loginline;
	@FindBy(xpath=Constants.Loginline2)
	WebElement loginline2;
	String emptyLogin= Constants.emptylogin;
	
	public HomePage(WebDriver dr){
		driver = dr;
		
	}
	
	public String getActualPageHeader(){
		return ActualPageHeader = pageHeader.getText();
	}
	
	public String getExpectedPageHeader(){
		return ExpectedPageHeader;
	}
	
	public String getErrorMessage(){
		return ErrorMessage = ErrorMessage2.getText();
	}
		
	public String getExpectedErrorMessage(){
		return ExpectedErrorMessage;
	}
	

public String getExpectedPageHeader2(){
		return ExpectedPageHeader2;
	}
	
	public String getActualPageHeader2(){
		return ActualPageHeader = pageHeader2.getText();
	}
	
	public String getloginline(){
		return loginline = loginline2.getText();
	}
	
	public String getemptylogin(){
		return emptyLogin;
	}
	
	public LoginPage gotoLogout(){
		LogoutLink.click();
		LoginPage Logout = PageFactory.initElements(driver, LoginPage.class);
		System.out.println("Logout done");
		return Logout;
	}

}
