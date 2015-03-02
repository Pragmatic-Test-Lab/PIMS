package com.ptl.pims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ptl.pims.util.Constants;

public class CalendarPopup {
	
	WebDriver driver;


	String monthYearText_FirstPart = Constants.CalendarPopup_MonthYearText_FirstPart;
	String monthYearText_LastPart = Constants.CalendarPopup_MonthYearText_LastPart;
	String dateText_FirstPart = Constants.CalendarPopup_DateText_FirstPart;
	String dateText_LastPart = Constants.CalendarPopup_DateText_LastPart;	
	String YearToBeSelected_XPath = "";
	String MonthToBeSelected_XPath = "";
	String DateToBeSelected_XPath = "";
	
			
	public CalendarPopup(WebDriver dr){
		driver = dr;
	}
	
	
	public void selectDate(WebElement calendarInputField, String Year, String Month, String Date){
		
		calendarInputField.click(); 
		
		WebElement monthYearText = driver.findElement(By.xpath(Constants.CalendarPopup_MonthYearText));
		monthYearText.click(); // click on the month & year text

		WebElement yearText = driver.findElement(By.xpath(Constants.CalendarPopup_YearText));
		yearText.click(); //click on the top year text
		
		YearToBeSelected_XPath = monthYearText_FirstPart + Year + monthYearText_LastPart;
		driver.findElement(By.xpath(YearToBeSelected_XPath)).click(); //click on the selected year text
		MonthToBeSelected_XPath = monthYearText_FirstPart + Month + monthYearText_LastPart;
		driver.findElement(By.xpath(MonthToBeSelected_XPath)).click(); //click on the selected month text
		DateToBeSelected_XPath = dateText_FirstPart + Date + dateText_LastPart;
		driver.findElement(By.xpath(DateToBeSelected_XPath)).click(); //click on the selected date text
		
	}
	
	
	public void selectDate(WebElement calendarInputField, String wholeDate){
		
		String[] splitDate = wholeDate.split("-");
		
		String year = splitDate[0];
		String month = splitDate[1];
		String day = splitDate[2];
		
		calendarInputField.click(); // open the calendar popup
		
		WebElement monthYearText = driver.findElement(By.xpath(Constants.CalendarPopup_MonthYearText));
		monthYearText.click(); // click on the month & year text

		WebElement yearText = driver.findElement(By.xpath(Constants.CalendarPopup_YearText));
		yearText.click(); //click on the top year text
		
		YearToBeSelected_XPath = monthYearText_FirstPart + year + monthYearText_LastPart;
		driver.findElement(By.xpath(YearToBeSelected_XPath)).click(); //click on the selected year text
		MonthToBeSelected_XPath = monthYearText_FirstPart + month + monthYearText_LastPart;
		driver.findElement(By.xpath(MonthToBeSelected_XPath)).click(); //click on the selected month text
		DateToBeSelected_XPath = dateText_FirstPart + day + dateText_LastPart;
		driver.findElement(By.xpath(DateToBeSelected_XPath)).click(); //click on the selected date text
		
	}


}
