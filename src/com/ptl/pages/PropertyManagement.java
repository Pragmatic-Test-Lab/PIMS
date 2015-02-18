package com.ptl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.util.Constants;

public class PropertyManagement {

	WebDriver driver;
	
	// AllocateLocation Inmate Select Page
	@FindBy(xpath = Constants.PropertyManagement_Header)
	
	public WebElement HeaderField;
	// SearchFields
	@FindBy(xpath = Constants.PropertyManagement_RegNoSearchField)
	public WebElement RegNoSearchField;
	@FindBy(xpath = Constants.PropertyManagement_BiometricSearchField)
	public WebElement BiometricSearchField;
	@FindBy(xpath = Constants.PropertyManagement_NameSearchField)
	public WebElement NameSearchField;
	@FindBy(xpath = Constants.PropertyManagement_OtherName1SearchField)
	public WebElement OtherName1SearchField;
	
	@FindBy(xpath = Constants.AllocateLocation_TableFirstLink)
	public WebElement firstInmateLink;
	
	
	//Private Property Tab
	@FindBy(xpath = Constants.PropertyManagement_PrivatePropTab)
	public WebElement Private_Tab;
	@FindBy(xpath = Constants.PropertyManagement_Private_Date)
	public WebElement Private_Date;
	@FindBy(xpath = Constants.PropertyManagement_Private_Item)
	public WebElement Private_Item;
	@FindBy(xpath = Constants.PropertyManagement_Private_Description)
	public WebElement Private_Description;
	@FindBy(xpath = Constants.PropertyManagement_Private_Quantity)
	public WebElement Private_Quantity;
	@FindBy(xpath = Constants.PropertyManagement_Private_Value)
	public WebElement Private_Value;

	//Prison Property Tab
	@FindBy(xpath = Constants.PropertyManagement_PrisonPropTab)
	public WebElement Prison_Tab;
	@FindBy(xpath = Constants.PropertyManagement_Prison_Date)
	public WebElement Prison_Date;
	@FindBy(xpath = Constants.PropertyManagement_Prison_Item)
	public WebElement Prison_Item;
	@FindBy(xpath = Constants.PropertyManagement_Prison_Description)
	public WebElement Prison_Description;
	@FindBy(xpath = Constants.PropertyManagement_Prison_Quantity)
	public WebElement Prison_Quantity;

	
	
	public PropertyManagement(WebDriver dr) {
		driver = dr;
	}
	
	// Search for inmate
	public void doSearch(String RegNo, String Biometric, String Name,
			String OtherName1, String Location) {

		RegNoSearchField.sendKeys(RegNo);
		BiometricSearchField.sendKeys(Biometric);
		NameSearchField.sendKeys(Name);
		OtherName1SearchField.sendKeys(OtherName1);
		//LocationSearchField.sendKeys(Location);

		//LocationSearchField.sendKeys(Keys.ENTER);
	}

	// clicks the first inmate in Table
	public void clickFirstInmate() {
		firstInmateLink.click();
	}
	
	//adds private property details
	public void addPrivateProperty(String date, String item, String description, String quantity, String value){
		
		//click Private Property Tab
		
		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");
		String[] values = value.split(",");
		
		//gets the length of each array and takes the minimum value
		int numberOfItems = Math.min(dates.length, Math.min(items.length, Math.min(descriptions.length, Math.min(quantities.length, values.length))));
		
		for(int i=0; i<numberOfItems; i++){
			//setdate Private_Date = date
			
			Private_Item.sendKeys(items[i]);
			Private_Description.sendKeys(descriptions[i]);
			Private_Quantity.sendKeys(quantities[1]);
			Private_Value.sendKeys(values[i]);
		}
		
	}	
	
	//adds prison property details
	public void addPrisonProperty(String date, String item, String description, String quantity){
		
		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");
		
		//gets the length of each array and takes the minimum value
		int numberOfItems = Math.min(dates.length, Math.min(items.length,quantities.length));
		
		for(int i=0; i<numberOfItems; i++){
			//setdate Private_Date = date
			
			Prison_Item.sendKeys(items[i]);
			Prison_Description.sendKeys(descriptions[i]);
			Prison_Quantity.sendKeys(quantities[1]);
		}
		
	}

	public String getHeader() {
		return HeaderField.getText();
	}

	public String getExpectedHeader() {
		return Constants.PropertyManagement_ExpectedHeader;
	}
	
}
