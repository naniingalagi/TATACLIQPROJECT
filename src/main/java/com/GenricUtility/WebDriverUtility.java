
package com.GenricUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * THis class use to maintain all WebDriver actions
 * @author CHANDAN KUMARa
 *
 */
public class WebDriverUtility {
	 WebDriverWait wait=null;
	Actions act=null;
	Select select= null;
	JavascriptExecutor js=null;
	 /**
	 * This method use to navigate to the application
	 * @param url
	 * @param driver
	 */
	public  void navigateApp(String url,WebDriver driver) {
		driver.get(url);
	}
	/**
	 * This method use to maximize the browser and implicitly wait till page load 
	 * @param driver
	 */
	public  void browserSetting(WebDriver driver,long longTimeOut ) {
		maximizeBrowser(driver);
		waitTillPageLoad(driver, longTimeOut);
	}
	/**
	 * This method use to  maximize the browser
	 * @param driver
	 */
	public  void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method use to implicitly wait till page load 
	 * @param driver
	 * @param longTimeOut
	 */
	public  void waitTillPageLoad(WebDriver driver,long longTimeOut) {
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	}
	/**
	 * This method use to initialize the action class
	 * @param driver
	 */
	public  void initalizeTheAction(WebDriver driver) {
		act = new Actions(driver);
	}
	/**
	 * This method use to mouse hover on the element
	 * @param driver
	 * @param morelink
	 */
	public  void mouseHoverOntheElement(WebElement morelink) {
		act.moveToElement(morelink).perform();
	}
	/**
	 * this method use to double click
	 */
	public  void doubleClick() {
		act.doubleClick().perform();
	}
	/**
	 * This method use to quit from to browser
	 * @param driver
	 */
	public  void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method used for explicitly wait
	 * @param driver
	 * @param timeOut
	 */
	public  void explicitlyWait(WebDriver driver, long timeOut) {
		wait=new WebDriverWait(driver, timeOut);
	}
	/**
	 * This method use to wait until element  clickable
	 * @param driver
	 * @param timeOut
	 * @param element
	 */

	public  void waitUntilElementClikable(WebElement element ) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * THis method use to wait until element visible
	 * @param element
	 */
	public  void waitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method used handle child browser
	 * @param driver
	 * @param actualText
	 * @param partialText
	 */

	public  void switchToWindow(WebDriver driver,String partialText ) {
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText));{
				break;
			}
		}
	}
	/**
	 * This method use to initialize the select
	 * @param element
	 */
	public  void intializeTheSelect(WebElement element) {
		select=new Select(element);

	}

	/**
	 *This method use to select by values
	 */
	public  void selectByValue(String value) {
		select.selectByValue(value);
	}
	/**
	 * This method use to select by index
	 * @param index
	 * @param element
	 */
	public  void selectByIndex(int index) {
		select.selectByIndex(index);
	}
	/**
	 * This method use to select by visible text
	 * @param element
	 * @param text
	 */
	public  void selectByVisibleText(String text) {
		select.selectByVisibleText(text);
	}
	/**
	 * This method use to switch to frame by index
	 * @param driver
	 * @param index
	 */
	public  void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method use to switch the frame by Name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public  void switchToFrameBy(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method use to switch the frame by webElement
	 * @param frameElement
	 * @param driver
	 */
	public  void switchToFrameBy(String frameElement, WebDriver driver) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method use to switch back to frame to browser
	 * @param driver
	 */
	public  void switchTodefaultBroswer( WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to switch to any browser
	 * @param driver
	 * @param title
	 */
	public  void switchToChild(WebDriver driver,String title) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String w_id = it.next();
			driver.switchTo().window(w_id);
			String current_title = driver.getTitle();
			if(current_title.contains(title)) {
				break;
			}
		}
	}
	/**
	 * This method use to intialize the javaScriptEceutrer
	 * @param driver
	 */
	public  void intializeJs(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}
	/**
	 * This method use to enter the data into the textfield
	 * @param driver
	 * @param element
	 * @param data
	 */
	public  void enterDataThroughJd(WebDriver driver,WebElement element, String data) {

		js.executeScript("argument[0].value=argument[1]",element,data);

	}
	/**
	 * This method use to navigate the application by using javaScriptExecutor
	 * @param driver
	 * @param url
	 */
	public  void navigateTheApplicationThroughJs(WebDriver driver, String url) {
		js.executeScript("window.location=argument[0]",url);
	}
	/**
	 * This method use scrool by height
	 * @param height
	 */
	public  void scroolToSpecifiedHeight(String height) {
		js.executeScript("window.scrollBy(0,"+height+")");

	}
	/**
	 * this method use to scroll bottom
	 */
	public  void scrollToBottom() {
		js.executeScript("window.scrolBy(0,document.body.scrollHeight)");

	}
	/**
	 * This method use to scroll till element view
	 * @param element
	 */ 

	public  void scrollTillElement(WebElement element) {
		js.executeScript("argument[0].scrillIntoView()", element);
	}
	/**
	 * THis method use to take screen shot
	 * @param fileName
	 */
	public  String takeScreenShot(String fileName,WebDriver driver) {
		TakesScreenshot	ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+fileName+"_"+".png");
		
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("file not stored in proper loaction");
		}
		return dst.getAbsolutePath();

	}
	
	
	
	


}







