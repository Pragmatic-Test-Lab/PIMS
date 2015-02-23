package com.ptl.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.util.Constants;

public class SelectInmatePage {

	// SearchFields
	@FindBy(xpath = Constants.SelectInmate_RegNoSearchField)
	public WebElement RegNoSearchField;
	@FindBy(xpath = Constants.SelectInmate_BiometricSearchField)
	public WebElement BiometricSearchField;
	@FindBy(xpath = Constants.SelectInmate_NameSearchField)
	public WebElement NameSearchField;
	@FindBy(xpath = Constants.SelectInmate_OtherName1SearchField)
	public WebElement OtherName1SearchField;

	//first Inmate Select Button
	@FindBy(xpath = Constants.SelectInmate_TableFirstLink)
	public WebElement firstInmateLink;
	
	WebDriver driver;
	
	
	public class doSearch(String RegNo, String Biometric, String Name,
			String OtherName1) {

		RegNoSearchField.sendKeys(RegNo);
		BiometricSearchField.sendKeys(Biometric);
		NameSearchField.sendKeys(Name);
		OtherName1SearchField.sendKeys(OtherName1);

		
		getClass() searchResultPage = PageFactory
				.initElements(driver, getClass());
		
		return searchResultPage; 
	}
}
