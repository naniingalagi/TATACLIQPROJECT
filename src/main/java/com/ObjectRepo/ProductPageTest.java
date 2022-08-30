package com.ObjectRepo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenricUtility.IconstantPath;
import com.GenricUtility.MsExcelUtility;

public class ProductPageTest {

	
	//MsExcelUtility msExcelUtility=new MsExcelUtility();
		
	@FindBy(xpath="//div[@class='ProductDescription__headerText']")
	private List<WebElement> productsName;
	
	
	@FindBy(xpath="//h2[contains(@class,'ProductDescription__description')]")
	private List<WebElement> productsDescr;
	
	
	@FindBy(xpath="//div[@class='ProductDescription__content']/descendant::h3[@class='ProductDescription__boldText']")
	private List<WebElement> productsprize;
	
	
	@FindBy(xpath="//div[@class='ProductModule__base' and @id='ProductModule-MP000000012689070']/descendant::img[@class='Image__actual']")
	private WebElement firstProd;
	
	
	
	public List<WebElement> getproductsname()	{
		return productsName;
	}
	
	public List<WebElement> getproductsDescription()	{
		return productsDescr;
	}
	
	public List<WebElement> getproductsPrizes(){
		return productsprize;
	}
	
	public WebElement getfirstProd(){
		return firstProd;
	}
	

	public ProductPageTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void productTataCliq() throws IOException
	{
		MsExcelUtility msExcelUtility=new MsExcelUtility();
		
		List<WebElement> productDetails=getproductsname();
		List<WebElement> productDescriptions=getproductsDescription();
		List<WebElement> productPrices=getproductsPrizes();	
	
		
	for(int i=1; i<=productDetails.size(); i++)
	{
	
		msExcelUtility.openExcel(IconstantPath.EXCELPATH);
		
		msExcelUtility.createRow("ProductDetails", i, 0, productDetails.get(i).getText());

		msExcelUtility.setDataintoExcel("ProductDetails", i, 1, productDescriptions.get(i).getText());

		msExcelUtility.setDataintoExcel("ProductDetails", i, 2, productPrices.get(i).getText());
		
		msExcelUtility.saveExcel(IconstantPath.EXCELPATH);
		
		msExcelUtility.closeExcel();
	}
		
}
	
    public void firstProd() {
    	
    	firstProd.click();
//    	List<WebElement> productDetails=getproductsname();
//    	for(int i=0; i<productDetails.size(); i++)
//    	{
//    	productDetails.get(i).click();
//    	break;
	}

}






