package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.pims.util.Constants;

public class CalendarPopup {
	
	WebDriver driver;
	
	
	@FindBy(xpath=Constants.CalendarInputField)
	WebElement calendarInputField;
	@FindBy(xpath=Constants.CalendarPopup_MonthYearText)
	WebElement monthYearText;
	String monthYearText_FirstPart = Constants.CalendarPopup_MonthYearText_FirstPart;
	String monthYearText_LastPart = Constants.CalendarPopup_MonthYearText_LastPart;
	@FindBy(xpath=Constants.CalendarPopup_YearText)
	WebElement yearText;
	String dateText_FirstPart = Constants.CalendarPopup_DateText_FirstPart;
	String dateText_LastPart = Constants.CalendarPopup_DateText_LastPart;	
	String YearToBeSelected_XPath = "";
	String MonthToBeSelected_XPath = "";
	String DateToBeSelected_XPath = "";
	
			
	public CalendarPopup(WebDriver dr){
		driver = dr;
	}
	
	
	public void selectDate(String Year, String Month, String Date){
		calendarInputField.click(); // open the calendar popup
		monthYearText.click(); // click on the month & year text
		yearText.click(); //click on the top year text
		YearToBeSelected_XPath = monthYearText_FirstPart + Year + monthYearText_LastPart;
		driver.findElement(By.xpath(YearToBeSelected_XPath)).click(); //click on the selected year text
		MonthToBeSelected_XPath = monthYearText_FirstPart + Month + monthYearText_LastPart;
		driver.findElement(By.xpath(MonthToBeSelected_XPath)).click(); //click on the selected month text
		DateToBeSelected_XPath = dateText_FirstPart + Date + dateText_LastPart;
		driver.findElement(By.xpath(DateToBeSelected_XPath)).click(); //click on the selected date text
		
	}

}
