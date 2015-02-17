package com.ptl.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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

import com.ptl.pages.TopMenu;
import com.ptl.util.Constants;
import com.ptl.util.ReadXLS;

public class TestBase {

	public static Logger APPLICATION_LOGS = null;
	public static Properties CONFIG = null;
	public static WebDriver driver = null;
	public static TopMenu topMenu = null;
	public static boolean isLoggedIn = false;
	public static boolean isLoggedout = false;
	ReadXLS xls = new ReadXLS(System.getProperty("user.dir")+"\\src\\com\\ptl\\data\\TestData.xlsx");
	
	
		

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

	public void initDriver() {
		if (driver == null) {
			if (CONFIG.getProperty("browser").equalsIgnoreCase("firefox17")) {
				/*System.setProperty("webdriver.firefox.bin",
						"C:\\Program Files (x86)\\Mozilla Firefox17\\firefox.exe");*/
				ProfilesIni allProfiles = new ProfilesIni();
				FirefoxProfile profile17 = allProfiles.getProfile("Firefox17");	
				FirefoxBinary binary17 = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox17\\firefox.exe"));
				driver = new FirefoxDriver(binary17, profile17);
				
				
			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("firefox")) {
				/*System.setProperty("webdriver.firefox.bin",
						"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");*/
								
				ProfilesIni allProfiles = new ProfilesIni();				
				FirefoxProfile profile = allProfiles.getProfile("Selenium");
				//FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
				driver = new FirefoxDriver(profile);
				//driver = new FirefoxDriver();
				
			}else if (CONFIG.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				//ChromeOptions options = new ChromeOptions();				
				//options.setBinary(new File("C://Program Files (x86)//Google//Chrome//Application//chrome.exe"));
				driver = new ChromeDriver(capability);
				//driver = new ChromeDriver();
			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("IE")) {
				/*File file = new File("C:\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());*/
				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				driver = new InternetExplorerDriver(caps);
				
				//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
				//System.setProperty("webdriver.ie.driver", "E:\\Selenium\\workspace\\IEDriverServer.exe");
				//driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
	}
	
	
	
	
	public void quitDriver() {

		driver.quit();
		driver = null;
		
		/*try {
			if (isProcessRunging("chromedriver.exe (32 bit)") == true) {
				Runtime.getRuntime().exec("taskkill /F /IM <chromedriver>.exe");
				final String KILL = "taskkill /IM ";
				String processName = "chromedriver.exe"; 
				Runtime.getRuntime().exec(KILL + processName); 
				
				
			    Thread.sleep(2000L);
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		   /*if (isProcessRunging("chrome.exe") == true) {
		    killProcess("chrome.exe");
		    Thread.sleep(2000L);
		   }*/
		
		
		
	}

	public TopMenu getTopMenu(){
		if(topMenu == null){
			topMenu = PageFactory.initElements(driver, TopMenu.class);
		}
		return topMenu;
	}	

}
