package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;


public abstract class SelectInmatePage extends CommonMethods {

	
	// Inmate Select Page Header
	@FindBy(xpath = Constants.SelectInmate_Header)
	public WebElement HeaderField;
	@FindBy(xpath = Constants.InmateSearchPage_SuccessMessage)
	public WebElement successMessage;
	
	By noResultsMessage =  By.xpath(Constants.InmateSearchPage_NoSearchResultsFound);

	// SearchFields
	@FindBy(xpath = Constants.InmateSearch_RegNoSearchField)
	public WebElement RegNoSearchField;
	@FindBy(xpath = Constants.InmateSearch_BiometricSearchField)
	public WebElement BiometricSearchField;
	@FindBy(xpath = Constants.InmateSearch_NameSearchField)
	public WebElement NameSearchField;

	public WebDriver driver;
	
	public String getHeader() {
		return HeaderField.getText();
	}
	
	//Searching with basic details Registration No, Biometric, Name
	@SuppressWarnings("unchecked")
	public <T extends SelectInmatePage>T doSearch(String RegNo, String Biometric, String Name) {

		waitAndReplaceKeys(driver, Constants.InmateSearch_RegNoSearchField, RegNo);
        waitAndReplaceKeys(driver, Constants.InmateSearch_BiometricSearchField, Biometric);
        waitAndReplaceKeys(driver, Constants.InmateSearch_NameSearchField, Name);

        NameSearchField.sendKeys(Keys.ENTER);
        return (T)PageFactory.initElements(driver, this.getClass());
	}
	
	public boolean successMessageAvaiable(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		return checkElementIsPresent(driver, By.xpath(Constants.InmateSearchPage_SuccessMessage));
	}
	
	public String getSuccessMessage(){
		
		return driver.findElement(By.xpath(Constants.InmateSearchPage_SuccessMessage)).getText();
	}

	public void clickFirstRecord(){

        //click first record
        waitForJSandJQueryToLoad(driver);
        waitAndClick(driver, Constants.InmateSearch_TableFirstInmate);
	}
	
}
