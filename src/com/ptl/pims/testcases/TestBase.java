package com.ptl.pims.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ptl.pims.pages.HomePage;
import com.ptl.pims.pages.LoginPage;
import com.ptl.pims.pages.TopMenu;
import com.ptl.pims.util.Constants;
import com.ptl.pims.util.ReadXLS;

public class TestBase {

	public static Logger APPLICATION_LOGS = null;
	public static Properties CONFIG = null;
	public static WebDriver driver = null;
	public static TopMenu topMenu = null;
	public static boolean isLoggedIn = false;
	public static int tempNum = 1;
	public static String registrationNo = "";
	public static String inmateCase = "";
	protected ReadXLS xls = new ReadXLS(System.getProperty("user.dir")
			+ "\\src\\com\\ptl\\data\\TestData.xlsx");

	@BeforeSuite
	public void initConfiguration() {

		if (CONFIG == null) {
			// initialize loggin & properties files
			APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");

			// initialize Properties file
			CONFIG = new Properties();
			FileInputStream fs;
			try {
				fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
				CONFIG.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		

	}

	@BeforeSuite
	public void initDriver() {
		if (driver == null) {
			if (CONFIG.getProperty("browser").equalsIgnoreCase("firefox17")) {
				/*
				 * System.setProperty("webdriver.firefox.bin",
				 * "C:\\Program Files (x86)\\Mozilla Firefox17\\firefox.exe");
				 */
				ProfilesIni allProfiles = new ProfilesIni();
				FirefoxProfile profile17 = allProfiles.getProfile("Firefox17");
				FirefoxBinary binary17 = new FirefoxBinary(
						new File(
								"C:\\Program Files (x86)\\Mozilla Firefox17\\firefox.exe"));
				driver = new FirefoxDriver(binary17, profile17);

			} else if (CONFIG.getProperty("browser")
					.equalsIgnoreCase("firefox")) {
				/*
				 * System.setProperty("webdriver.firefox.bin",
				 * "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				 */

				ProfilesIni allProfiles = new ProfilesIni();
				FirefoxProfile profile = allProfiles.getProfile("Selenium");
				// FirefoxBinary binary = new FirefoxBinary(new
				// File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
				driver = new FirefoxDriver(profile);
				// driver = new FirefoxDriver();

			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")
								+ "//drivers//chromedriver.exe");
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				// ChromeOptions options = new ChromeOptions();
				// options.setBinary(new
				// File("C://Program Files (x86)//Google//Chrome//Application//chrome.exe"));
				driver = new ChromeDriver(capability);
				// driver = new ChromeDriver();
			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("IE")) {
				/*
				 * File file = new File("C:\\IEDriverServer.exe");
				 * System.setProperty("webdriver.ie.driver",
				 * file.getAbsolutePath());
				 */

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")
								+ "//drivers//IEDriverServer.exe");
				DesiredCapabilities caps = DesiredCapabilities
						.internetExplorer();
				caps.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				driver = new InternetExplorerDriver(caps);

				// System.setProperty("webdriver.ie.driver",
				// System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
				// System.setProperty("webdriver.ie.driver",
				// "E:\\Selenium\\workspace\\IEDriverServer.exe");
				// driver = new InternetExplorerDriver();
			}
			APPLICATION_LOGS.debug("Browser initialized");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@AfterSuite
//	public void quitDriver() {
//
//		driver.quit();
//		driver = null;
//	}


	public TopMenu getTopMenu() {
		if (topMenu == null) {
			topMenu = PageFactory.initElements(driver, TopMenu.class);
		}
		return topMenu;
	}
	
	public void loginToApplication(){
		
		HomePage landingPage;
				
		if (!isLoggedIn) {
			APPLICATION_LOGS.debug("Login into system");
			driver.get(CONFIG.getProperty("BASE_URL"));
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

			landingPage = lp
					.doLogin(CONFIG.getProperty("USER_NAME"), CONFIG.getProperty("PASSWORD"));

			Assert.assertTrue(landingPage.IsMainPageImageShown(),
					"Homepage Image not found!");
			
			APPLICATION_LOGS.debug("Successfully logged in");
			isLoggedIn = true;
		}

	}
	
	public void assertTrue(boolean condition, String message){		

		if(!condition){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("c:\\Selenium-TestRun\\Failure Screenshots\\Iteration 1\\" 
							+ (new SimpleDateFormat("yyyy-MM-dd\\HH-mm-ss").format(Calendar.getInstance().getTime())) + " - " + message + ".png"));
		} catch (IOException e1) {}		
		}
		Assert.assertTrue(condition, message);
		
	}
	
	
	

}
