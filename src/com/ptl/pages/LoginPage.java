package com.ptl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.testcases.TestBase;
import com.ptl.util.Constants;

public class LoginPage {

	public WebDriver driver;

	@FindBy(xpath = Constants.username)
	public WebElement username;
	@FindBy(xpath = Constants.password)
	public WebElement password;
	@FindBy(xpath = Constants.login)
	public WebElement login;
	@FindBy(xpath = Constants.LogOut)
	public WebElement logOut;

	public LoginPage(WebDriver dr) {
		driver = dr;
	}

	public HomePage doLogin(String uName, String pWord) {
		username.sendKeys(uName);
		password.sendKeys(pWord);
		login.click();
		// validate login - successful

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		return homePage;
	}
	
	
}
