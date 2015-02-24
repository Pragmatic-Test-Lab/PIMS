package com.ptl.pims.pages;

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
	@FindBy(xpath = Constants.PropertyManagement_PrivatePropTab)
	public WebElement Private_Tab;
	@FindBy(xpath = Constants.PropertyManagement_PrivateTab_AddNew)
	public WebElement PrivateTab_AddNew;

	// Prison Property Tab
	@FindBy(xpath = Constants.PropertyManagement_PrisonPropTab)
	public WebElement Prison_Tab;
	@FindBy(xpath = Constants.PropertyManagement_PrisonTab_AddNew)
	public WebElement PrisonTab_AddNew;

	@FindBy(xpath = Constants.UpdatePropertyManagementButton)
	public WebElement submitButton;

	WebDriver driver;
	
	public PropertyManagementPage(WebDriver dr) {
		driver = dr;
	}

	//adds private property details
	public void addPrivateProperties(String date, String item, String description, String quantity, String value){
		
		//click Private Property Tab
		Private_Tab.click();
		
		//gets No of available Properties
		int NoOfInitialProperties = getPrivatePropertyRows().size();
		
		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");
		String[] values = value.split(",");
		
		//gets the length of each array and takes the minimum value
		int numberOfItems = Math.min(dates.length, Math.min(items.length, Math.min(descriptions.length, Math.min(quantities.length, values.length))));
		
		for(int i=0; i< numberOfItems; i++){
			//adds new property row
			PrivateTab_AddNew.click();
			
			//gets the last row(newly added row)
			WebElement lastRow = getPrivatePropertyRows().get(NoOfInitialProperties + i);
			
			//add date
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrivateTab_Date)).sendKeys(dates[i] + Keys.ENTER);
			//add item
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrivateTab_Item)).sendKeys(items[i]);
			//add description
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrivateTab_Description)).sendKeys(descriptions[i]);
			//add quantity
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrivateTab_Quantity)).sendKeys(quantities[i]);
			//add value
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrivateTab_Value)).sendKeys(quantities[i]);

		}		
	}	
	
	//adds prison property details
	public void addPrisonProperties(String date, String item, String description, String quantity){

		//click Private Property Tab
		Prison_Tab.click();
		
		//gets No of available Properties
		int NoOfInitialProperties = getPrisonPropertyRows().size();
		
		String[] dates = date.split(",");
		String[] items = item.split(",");
		String[] descriptions = description.split(",");
		String[] quantities = quantity.split(",");
		
		//gets the length of each array and takes the minimum value
		int numberOfItems = Math.min(dates.length, Math.min(items.length,quantities.length));
				
		for(int i=0; i< numberOfItems; i++){
			//adds new property row
			PrisonTab_AddNew.click();
			
			//gets the last row(newly added row)
			WebElement lastRow = getPrisonPropertyRows().get(NoOfInitialProperties + i);
			
			//add date
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrisonTab_Date)).sendKeys(dates[i] + Keys.ENTER);
			//add item
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrisonTab_Item)).sendKeys(items[i]);
			//add description
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrisonTab_Description)).sendKeys(descriptions[i]);
			//add quantity
			lastRow.findElement(By.xpath(Constants.PropertyManagement_PrisonTab_Quantity)).sendKeys(quantities[i]);

		}
		
	}
	
	//retrieves all rows in Private Property Tab
	private List<WebElement> getPrivatePropertyRows(){
		
		return driver.findElements(By.xpath(Constants.PropertyManagement_PrivateTab_AllRows));
	}
	
	//retrieves all rows in Prison Property Tab
	private List<WebElement> getPrisonPropertyRows(){
		
		return driver.findElements(By.xpath(Constants.PropertyManagement_PrisonTab_AllRows));
	}
	
	//saves Changed property details
	public PropertyManagementInmateSelectPage submitPropertyForm(){
		
		submitButton.click();
		
		PropertyManagementInmateSelectPage propertyManagementSelectPage = PageFactory
				.initElements(driver, PropertyManagementInmateSelectPage.class);
		return propertyManagementSelectPage;
	}
	
	


}
