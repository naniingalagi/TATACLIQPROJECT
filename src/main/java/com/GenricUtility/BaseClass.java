package com.GenricUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public  WebDriver driver;
	public String url;
	public  long timeouts;
	public MsExcelUtility msExcelUtility;
	public PropertyFileUtility propertyFileUtility;
	public WebDriverUtility webDriverUtility ;
	public static WebDriver staticdriver;
	//public String browser;
	/**
	 * This method use to open the excel,propertyfile,Getconnection with datbase.
	 * @throws Throwable
	 * 
	 */
	@BeforeSuite()
	public void beforeSuite() throws Throwable{



	}
	/**
	 * AfterTest add to Base configuration 
	 */
	@AfterTest
	public void afterTest() {

	}

	/**
	 * This method use to open the class,lanuch the browser navigate the application fetch the data from propertyfile  and browser Setting instance of common POM class
	 * @throws IOException
	 * dute nonstatic create object in the @beforeClass 
	 */

	@Parameters(value="BROWSER")
	@BeforeClass()
	public void beforClass(String browser) throws IOException {

		msExcelUtility= new MsExcelUtility();
		propertyFileUtility=new PropertyFileUtility();
		propertyFileUtility.openPropertyFile("./src/test/resources/commonData.properties");
		url=propertyFileUtility.getDataFromPropertFile("url");
		//String browser = propertyFileUtility.getDataFromPropertFile("browser");

		//browser=System.getProperty("BROWSER");
		
		msExcelUtility.openExcel("./src/test/resources/TestData.xlsx");

		switch (browser) {
		case "chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			break;
		case"firefox":
			FirefoxOptions option1 = new FirefoxOptions();
			option1.addArguments("--disable-notifications");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(option1);
			break;

		case "edge":
			//EdgeOptions opt = new EdgeOptions();
			//opt.addArguments("--disable-notifications");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("please specify proper browser key");
			FirefoxOptions option4 = new FirefoxOptions();
			option4.addArguments("--disable-notifications");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(option4);
			break;

		}

		staticdriver=driver;
		webDriverUtility = new WebDriverUtility();
		webDriverUtility.navigateApp(url, driver);
		webDriverUtility.browserSetting(driver, timeouts);

	}



	/**
	 * This method use to login the application
	 */
	@BeforeMethod()
	public void beforMethod() {

	}

	/**
	 * This method use to logout the application
	 */
	@AfterMethod()
	public void afterMethpd() {


	}

	/**
	 * This method use to quit the browser
	 * @throws IOException 
	 */
	@AfterClass()
	public void afterClass() throws IOException {

		webDriverUtility.quitBrowser(driver);
	}
	/**
	 * This method use to close the excel,close dataBase
	 * @throws IOException
	 */
	@AfterSuite()
	public void afterSuite() throws IOException {


	}


}
