package com.ptl.pims.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;



public abstract class SelectInmatePage {

	
	// Inmate Select Page Header
	@FindBy(xpath = Constants.AllocateLocation_Header)
	public WebElement HeaderField;
	// SearchFields
	@FindBy(xpath = Constants.InmateSearch_RegNoSearchField)
	public WebElement RegNoSearchField;
	@FindBy(xpath = Constants.InmateSearch_BiometricSearchField)
	public WebElement BiometricSearchField;
	@FindBy(xpath = Constants.InmateSearch_NameSearchField)
	public WebElement NameSearchField;

	//first Inmate Select Button
	@FindBy(xpath = Constants.InmateSearch_TableFirstInmate)
	public WebElement firstInmateLink;
	
	public WebDriver driver;
	
	public String getHeader() {
		return HeaderField.getText();
	}
	
	//Searching with basic details Registration No, Biometric, Name
	@SuppressWarnings("unchecked")
	public <T extends SelectInmatePage>T doSearch(String RegNo, String Biometric, String Name) {

		RegNoSearchField.sendKeys(RegNo);
		BiometricSearchField.sendKeys(Biometric);
		NameSearchField.sendKeys(Name);
		
		NameSearchField.sendKeys(Keys.ENTER);
		
		return (T)PageFactory.initElements(driver, this.getClass());
 
	}
	

	
/*	public int numberOfInmateRecordsInPage(){
		
		
		
		return 0;
	}*/
	
}