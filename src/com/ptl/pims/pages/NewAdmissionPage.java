package com.ptl.pims.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ptl.pims.util.*;

public class NewAdmissionPage extends SelectInmatePage {

	
	@FindBy(xpath = Constants.CreateAdmissionButton)
	WebElement CreateAdmissionButton;
	
	public NewAdmissionPage(WebDriver dr){
		driver = dr;
	}
	
	public CreateNewAdmissionPage getCreateAdmissionPage(){
		
		CreateAdmissionButton.click();
		CreateNewAdmissionPage createNewAdmissionPage = PageFactory.initElements(driver, CreateNewAdmissionPage.class);
		return createNewAdmissionPage;
		
	}

}
