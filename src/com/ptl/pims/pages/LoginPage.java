package com.ptl.pims.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = Constants.Login_username)
	public WebElement username;
	@FindBy(xpath = Constants.Login_password)
	public WebElement password;
	@FindBy(xpath = Constants.Login_login)
	public WebElement login;

	public LoginPage(WebDriver dr) {
		driver = dr;
	}

	public HomePage doLogin(String uName, String pWord) {
		
		username.sendKeys(uName);
		password.sendKeys(pWord);
		login.click();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		return homePage;
	}

}
