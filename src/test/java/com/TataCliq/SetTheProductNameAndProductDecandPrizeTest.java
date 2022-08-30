package com.TataCliq;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.testng.annotations.Test;
import com.GenricUtility.BaseClass;
import com.ObjectRepo.HomePageTest;
import com.ObjectRepo.ProductPageTest;

public class SetTheProductNameAndProductDecandPrizeTest extends BaseClass {
	@Test
	public void setTheProductNameAndProductDecandPrizeTest() throws AWTException, InterruptedException, IOException {

		HomePageTest hp = new HomePageTest(driver);
		
		ProductPageTest prodpage=new ProductPageTest(driver);
		
		hp.homePage(driver, msExcelUtility.getDataFromExcel("ProductName", 1, 0));
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		prodpage.productTataCliq();
		
		//prodpage.firstProd();
				String partialurl="utsa-by-westside-pink-embroidered-a-line-kurta";
		
		webDriverUtility.switchToChild(driver, partialurl);
		
		
		

	}
	
}
