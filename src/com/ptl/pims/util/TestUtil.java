package com.ptl.pims.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ptl.pims.testcases.TestBase;

public class TestUtil {

	private static final String RANDOM_CHAR_LIST =
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	public static String getRandomString(int length){

		StringBuffer randStr = new StringBuffer();
		Random random = new Random();

		for(int i=0; i< length; i++){
			randStr.append(RANDOM_CHAR_LIST.charAt(random.nextInt(RANDOM_CHAR_LIST.length() - 1)));
		}
		return randStr.toString();
	}

	public static boolean isTestCaseRunmodeYes(String testCaseName,	ReadXLS xls) {

		for (int rowNum = 2; rowNum <= xls.getRowCount("Test Cases"); rowNum++) {
			if (xls.getCellData("Test Cases", "TCID", rowNum).equalsIgnoreCase(testCaseName)) {
				if (xls.getCellData("Test Cases", "Runmode", rowNum).equalsIgnoreCase("Yes")){
					// String testDataSheet= xls.getCellData("Test Case", "TestCaseID", rowNum);
					System.out.println("rowNum: "+ rowNum);
					System.out.println("Runmode " + xls.getCellData(testCaseName, "Runmode", rowNum));
					return true;
				}
				else{
					System.out.println("rowNum: "+ rowNum);
					return false;
				}
			}
		}
		return false;
	}
	
	
	public static Object[][] getTestData(String testCaseName, ReadXLS xls){
		
		//Test data starting row number
		//int testDataStartRowNum = 2;
		//number of data rows
		int totalDataRows = xls.getRowCount(testCaseName);
		//number of columns
		int totalCols = xls.getColumnCount(testCaseName);
		
		Object[][] data = new Object[totalDataRows - 1][1];
		int index=0;
		
		Hashtable<String, String> table = null;
		for(int dataRowNum=2; dataRowNum<=totalDataRows; dataRowNum++){
			table = new Hashtable<String, String>();
			
			for(int dataColNum=0; dataColNum<totalCols; dataColNum++){
				table.put(xls.getCellData(testCaseName, dataColNum, 1), 
						xls.getCellData(testCaseName, dataColNum, dataRowNum));
				System.out.print(xls.getCellData(testCaseName, dataColNum, dataRowNum)+ " -- ");
			}
			data[index][0] = table;
			index++;
			System.out.println();			
		}
		
		System.out.println("done");
		System.out.println("Number of data rows: "+ (totalDataRows-1));
		
		return data;
		
	}

	public static void takeScreenShot(WebDriver driver, String fileName) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(
					scrFile,
					new File(
							"c:\\Selenium-TestRun\\Failure Screenshots\\Iteration 1\\"
									+ (new SimpleDateFormat("yyyy-MM-dd")
											.format(Calendar.getInstance()
													.getTime())) + "\\"
									+ fileName + ".png"));
		} catch (IOException e1) {
		}
	}

	public static String getTodaysDate(){
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		String Month = "";
		
		switch(month){
			case 0:Month = "Jan"; break;
			case 1:Month = "Feb"; break;
			case 2:Month = "Mar"; break;
			case 3:Month = "Apr"; break;
			case 4:Month = "May"; break;
			case 5:Month = "Jun"; break;
			case 6:Month = "Jul"; break;
			case 7:Month = "Aug"; break;
			case 8:Month = "Sep"; break;
			case 9:Month = "Oct"; break;
			case 10:Month = "Nov"; break;
			case 11:Month = "Dec"; break;		
		}
		
		return year + "-" +  Month + "-" + day;}

}
