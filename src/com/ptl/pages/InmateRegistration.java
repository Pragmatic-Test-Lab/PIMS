package com.ptl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.util.Constants;

public class InmateRegistration {
	
	WebDriver driver ;
	
	@FindBy(xpath = Constants.InmateRegistaration_FirtstRow_EditButton)
	public WebElement editFirstInmate;
	@FindBy(xpath = Constants.InmateRegistration_Personal_OtherName1)
	public WebElement otherName1;
	@FindBy(xpath = Constants.InmateRegistration_Personal_OtherName2)
	public WebElement otherName2;
	@FindBy(xpath = Constants.InmateRegistration_Personal_CallName1)
	public WebElement callName1;
	@FindBy(xpath = Constants.InmateRegistration_Personal_CallName2)
	public WebElement callName2;
	@FindBy(xpath = Constants.InmateRegistration_Personal_AddressLine1)
	public WebElement addressLine1;
	@FindBy(xpath = Constants.InmateRegistration_Personal_AddressLine2)
	public WebElement addressLine2;
	@FindBy(xpath = Constants.InmateRegistration_Personal_PostOffice)
	public WebElement postOffice;
	@FindBy(xpath = Constants.InmateRegistration_Personal_PostalCode)
	public WebElement postalCode;
	@FindBy(xpath = Constants.InmateRegistration_Personal_Country)
	public WebElement country;
	@FindBy(xpath = Constants.InmateRegistration_Personal_Province)
	public WebElement province;
	@FindBy(xpath = Constants.InmateRegistration_Personal_District)
	public WebElement district;
	@FindBy(xpath = Constants.InmateRegistration_Personal_DS)
	public WebElement Ds;
	@FindBy(xpath = Constants.InmateRegistration_Personal_GSDivision)
	public WebElement gsDivision;
	@FindBy(xpath = Constants.InmateRegistration_Personal_City)
	public WebElement city;
	@FindBy(xpath = Constants.InmateRegistration_Personal_PoliceDivision)
	public WebElement policeDivision;
	@FindBy(xpath = Constants.InmateRegistration_Personal_Update)
	public WebElement updateButton;
	
	
	public InmateRegistration(WebDriver dr){		
		driver = dr;
	}
	
	public void doAddPersonalDetailsOfInmate(String othrName1, String othrName2, String cllName1, 
			String cllName2, String addLine1, String addLine2, String postOff, String postCode,
			String cntry, String prvnce , String dstrct, String ds, String gsDiv, String cty,
			String plicDiv){
		
		//TODO : add method to search by reg number
		editFirstInmate.click();
		otherName1.sendKeys(othrName1);
		otherName2.sendKeys(othrName2);
		callName1.sendKeys(cllName1);
		callName2.sendKeys(cllName2);
		addressLine1.sendKeys(addLine1);
		addressLine2.sendKeys(addLine2);
		postOffice.sendKeys(postOff);
		postalCode.sendKeys(postCode);
		country.sendKeys(cntry);
		province.sendKeys(prvnce);
		district.sendKeys(dstrct);
		Ds.sendKeys(ds);
		gsDivision.sendKeys(gsDiv);
		city.sendKeys(cty);
		policeDivision.sendKeys(plicDiv);
		updateButton.click();
		
	}
	
	
}
