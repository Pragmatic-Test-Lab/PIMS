package com.ptl.pims.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ptl.pims.util.Constants;

public class PropertyManagementPage {

	//Private Property Tab	
	@FindBy(xpath = Constants.PropertyManagement_PrivateTab)
	public WebElement Private_Tab;
	@FindBy(xpath = Constants.PropertyManagement_PrivateTab_TBody)
	public WebElement Private_TabTableBody;
	@FindBy(xpath = Constants.PropertyManagement_PrivateTab_AddNew)
	public WebElement PrivateTab_AddNew;	
	private String privateDateFirstPart = Constants.PropertyManagement_PrivateTab_DateFirstPart;
	private String privateDateLastPart = Constants.PropertyManagement_PrivateTab_DateLastPart;
	private String privateItemFirstPart = Constants.PropertyManagement_PrivateTab_ItemFirstPart;
	private String privateItemLastPart = Constants.PropertyManagement_PrivateTab_ItemLastPart;
	private String privateSelectedItemLastPart = Constants.PropertyManagement_PrivateTab_SelectedItemLastPart;
	private String privateDescriptionFirstPart = Constants.PropertyManagement_PrivateTab_DescriptionFirstPart;
	private String privateDescriptionLastPart = Constants.PropertyManagement_PrivateTab_DescriptionLastPart;
	private String privateQuantityFirstPart = Constants.PropertyManagement_PrivateTab_QuantityFirstPart;
	private String privateQuantityLastPart = Constants.PropertyManagement_PrivateTab_QuantityLastPart;
	private String privateValueFirstPart = Constants.PropertyManagement_PrivateTab_ValueFirstPart;
	private String privateValueLastPart = Constants.PropertyManagement_PrivateTab_ValueLastPart;
	

	// Prison Property Tab
	@FindBy(xpath = Constants.PropertyManagement_PrisonTab)
	public WebElement Prison_Tab;
	@FindBy(xpath = Constants.PropertyManagement_PrisonTab_TBody)
	public WebElement Prison_TabTableBody;
	@FindBy(xpath = Constants.PropertyManagement_PrisonTab_AddNew)
	public WebElement PrisonTab_AddNew;
	private String prisonDateFirstPart = Constants.PropertyManagement_PrisonTab_DateFirstPart;
	private String prisonDateLastPart = Constants.PropertyManagement_PrisonTab_DateLastPart;
	private String prisonItemFirstPart = Constants.PropertyManagement_PrisonTab_ItemFirstPart;
	private String prisonItemLastPart = Constants.PropertyManagement_PrisonTab_ItemLastPart;
	private String prisonSelectedItemLastPart = Constants.PropertyManagement_PrisonTab_SelectedItemLastPart;
	private String prisonDescriptionFirstPart = Constants.PropertyManagement_PrisonTab_DescriptionFirstPart;
	private String prisonDescriptionLastPart = Constants.PropertyManagement_PrisonTab_DescriptionLastPart;
	private String prisonQuantityFirstPart = Constants.PropertyManagement_PrisonTab_QuantityFirstPart;
	private String prisonQuantityLastPart = Constants.PropertyManagement_PrisonTab_QuantityLastPart;


	@FindBy(xpath = Constants.PropertyManagement_UpdateButton)
	public WebElement submitButton;

	WebDriver driver;
	
	public PropertyManagementPage(WebDriver dr) {
		driver = dr;
	}

	//adds private property details
	public void addPrivateProperties(String date, String item, String description, String quantity, String value){
		
		//click Private Property Tab
		Private_Tab.click();

		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");
		String[] values = value.split(",");		

		int dataRows = initialRowCount(Private_TabTableBody);
		
		for(int i=0; i< dates.length; i++){

			PrivateTab_AddNew.click();
			
			int newDataRow = dataRows + i;	
			
			driver.findElement(By.xpath(privateDateFirstPart + newDataRow + privateDateLastPart)).sendKeys(dates[i] + Keys.ENTER);
			driver.findElement(By.xpath(privateItemFirstPart + newDataRow + privateItemLastPart)).sendKeys(items[i]);
			driver.findElement(By.xpath(privateDescriptionFirstPart + newDataRow + privateDescriptionLastPart)).sendKeys(descriptions[i]);
			driver.findElement(By.xpath(privateQuantityFirstPart + newDataRow + privateQuantityLastPart)).sendKeys(quantities[i]);
			driver.findElement(By.xpath(privateValueFirstPart + newDataRow + privateValueLastPart)).sendKeys(values[i]);
			
		}		
	}	

	//adds prison property details
	public void addPrisonProperties(String date, String item, String description, String quantity){

		//click Prison Property Tab
		Prison_Tab.click();

		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");

		int dataRows = initialRowCount(Prison_TabTableBody);
		
		for(int i=0; i< dates.length; i++){

			PrisonTab_AddNew.click();
			
			int newDataRow = dataRows + i;	
			
			driver.findElement(By.xpath(prisonDateFirstPart + newDataRow + prisonDateLastPart)).sendKeys(dates[i] + Keys.ENTER);
			driver.findElement(By.xpath(prisonItemFirstPart + newDataRow + prisonItemLastPart)).sendKeys(items[i]);
			driver.findElement(By.xpath(prisonDescriptionFirstPart + newDataRow + prisonDescriptionLastPart)).sendKeys(descriptions[i]);
			driver.findElement(By.xpath(prisonQuantityFirstPart + newDataRow + prisonQuantityLastPart)).sendKeys(quantities[i]);
			
		}		
	}
	
	
	private int initialRowCount(WebElement element) {
		List<WebElement> rows = element.findElements(By.tagName("tr"));		
		int size = rows.size() - 1;
		return size;
	}

	//saves Changed property details
	public PropertyManagementInmateSelectPage submitPropertyForm(){
		
		submitButton.click();
		
		PropertyManagementInmateSelectPage propertyManagementSelectPage = PageFactory
				.initElements(driver, PropertyManagementInmateSelectPage.class);
		return propertyManagementSelectPage;
	}
	
	//checks if saved private property records contain passed property details
	public boolean isPrivatePropertyRecordsFound(String date, String item, String description, String quantity, String value){
		
		//click Private Property Tab
		Private_Tab.click();

		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");
		String[] values = value.split(",");		

		int dataRows = initialRowCount(Private_TabTableBody);
		
		//creates a boolean value for each search
		boolean propertyFound[] =new boolean[dates.length];
		Arrays.fill(propertyFound, false);		

		for (int i = 0; i < dataRows; i++) {

			String savedDate = driver.findElement(By.xpath(privateDateFirstPart + i + privateDateLastPart)).getAttribute("value");
			String selectedItem = driver.findElement(By.xpath(privateItemFirstPart + i + privateSelectedItemLastPart)).getText();
			String savedDescription = driver.findElement(By.xpath(privateDescriptionFirstPart + i + privateDescriptionLastPart)).getAttribute("value");
			String savedQuantity = driver.findElement(By.xpath(privateQuantityFirstPart + i	+ privateQuantityLastPart)).getAttribute("value");
			String savedValue = driver.findElement(By.xpath(privateValueFirstPart + i + privateValueLastPart)).getAttribute("value");

			for (int j = 0; j < dates.length; j++) {
				if (savedDate.equals(dates[j]) && selectedItem.equals(items[j]) && savedDescription.equals(descriptions[j])
					&& savedQuantity.equals(quantities[j]) )
					if(savedValue.equals(values[j]) || savedValue.equals(values[j] + ".00"))
					propertyFound[j] = true;
			}}

		for (boolean result : propertyFound) {
			if (!result) {
				//returns false even if one of the properties were not found
				return false;
			}}

		return true;
	}

	
	//checks if saved prison property records contain passed property details
	public boolean isPrisonPropertyRecordsFound(String date, String item, String description, String quantity){
		
		// click Prison Property Tab
		Prison_Tab.click();

		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");

		int dataRows = initialRowCount(Prison_TabTableBody);

		// creates a boolean value for each search
		boolean propertyFound[] = new boolean[dates.length];
		Arrays.fill(propertyFound, false);

		for (int i = 0; i < dataRows; i++) {

			String savedDate = driver.findElement(By.xpath(prisonDateFirstPart + i + prisonDateLastPart)).getAttribute("value");
			String selectedItem = driver.findElement(By.xpath(prisonItemFirstPart + i + prisonSelectedItemLastPart)).getText();
			String savedDescription = driver.findElement(By.xpath(prisonDescriptionFirstPart + i + prisonDescriptionLastPart)).getAttribute("value");
			String savedQuantity = driver.findElement(By.xpath(prisonQuantityFirstPart + i + prisonQuantityLastPart)).getAttribute("value");


			for (int j = 0; j < dates.length; j++) {
				if (savedDate.equals(dates[j]) && selectedItem.equals(items[j]) && savedDescription.equals(descriptions[j]) && savedQuantity.equals(quantities[j]))
					propertyFound[j] = true;
			}
		}

		for (boolean result : propertyFound) {
			if (!result) {
				// returns false even if one of the properties were not found
				return false;
			}
		}

		return true;
	}


	//edits Private Property found in 'PropertyPosition' position
	public boolean editPrivateProperties(String PropertyPosition, String date, String item, String description, String quantity, String value) {
		
		// click Private Property Tab
		Private_Tab.click();
		int positionToEdit = Integer.parseInt(PropertyPosition);

		if (initialRowCount(Private_TabTableBody) < positionToEdit)
			return false;
		
		WebElement Datefield = driver.findElement(By.xpath(privateDateFirstPart + positionToEdit + privateDateLastPart));
		WebElement Itemfield = driver.findElement(By.xpath(privateItemFirstPart + positionToEdit + privateSelectedItemLastPart));
		WebElement Descriptionfield = driver.findElement(By.xpath(privateDescriptionFirstPart + positionToEdit + privateDescriptionLastPart));
		WebElement Quantityfield = driver.findElement(By.xpath(privateQuantityFirstPart + positionToEdit + privateQuantityLastPart));
		WebElement Valuefield = driver.findElement(By.xpath(privateValueFirstPart + positionToEdit + privateValueLastPart));

		// editing data
		clearElement(Datefield);
		Datefield.sendKeys(date + Keys.ENTER);
		
		clearElement(Itemfield);
		Itemfield.sendKeys(item);
		
		clearElement(Descriptionfield);
		Descriptionfield.sendKeys(description);
		
		clearElement(Quantityfield);
		Quantityfield.sendKeys(quantity);
		
		clearElement(Valuefield);
		Valuefield.sendKeys(value);

		return true;
	}
	
	public void clearElement(WebElement element){		
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}

	//edits Prison Property found in 'PropertyPosition' position
	public boolean editPrisonProperties(String PropertyPosition, String date, String item, String description, String quantity) {
		
		// click Prison Property Tab
		Prison_Tab.click();
		int positionToEdit = Integer.parseInt(PropertyPosition);

		if (initialRowCount(Prison_TabTableBody) < positionToEdit)
			return false;
		
		WebElement Datefield = driver.findElement(By.xpath(prisonDateFirstPart + positionToEdit + prisonDateLastPart));
		WebElement Itemfield = driver.findElement(By.xpath(prisonItemFirstPart + positionToEdit + prisonSelectedItemLastPart));
		WebElement Descriptionfield = driver.findElement(By.xpath(prisonDescriptionFirstPart + positionToEdit + prisonDescriptionLastPart));
		WebElement Quantityfield = driver.findElement(By.xpath(prisonQuantityFirstPart + positionToEdit + prisonQuantityLastPart));

		// editing data
		clearElement(Datefield);
		Datefield.sendKeys(date + Keys.ENTER);
		
		clearElement(Itemfield);
		Itemfield.sendKeys(item);
		
		clearElement(Descriptionfield);
		Descriptionfield.sendKeys(description);
		
		clearElement(Quantityfield);
		Quantityfield.sendKeys(quantity);

		return true;
		
	}

}
