package com.ptl.pims.pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

	public boolean checkElementIsPresent(WebDriver driver , By byCondition){
		boolean present;
		try {
		   driver.findElement(byCondition);
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		
		return present;
	}
}
